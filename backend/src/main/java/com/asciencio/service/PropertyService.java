package com.asciencio.service;

import com.asciencio.exception.NotFoundException;
import com.asciencio.mapper.PropertyMapper;
import com.asciencio.model.Property;
import com.asciencio.model.PropertyDTO;
import com.asciencio.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyMapper propertyMapper;

    public ResponseEntity save(PropertyDTO propertyDTO) {
        Property property =  propertyRepository.save(propertyMapper.mapEntity(propertyDTO));
        return  ResponseEntity.status(HttpStatus.CREATED).body(property);
    }

    public ResponseEntity update(PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(propertyDTO.getId())
                .orElseThrow(()-> new NotFoundException(String.join(" : ", "Property Id  Not Found  : ", propertyDTO.getId().toString())));
        property =  propertyRepository.save(propertyMapper.updateEntity(property, propertyDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }

    public ResponseEntity approve(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(()-> new NotFoundException(String.join(" : ", "Property Id  Not Found  : ", propertyId.toString())));
        if(!property.getAuthorized()) {
            property.setAuthorized(true);
            property.setUpdatedAt(Instant.now());
            property = propertyRepository.save(property);
            return ResponseEntity.status(HttpStatus.CREATED).body(property);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.join(" : ", "Property Already Authorized  : ", propertyId.toString()));
        }
    }

    public ResponseEntity search(String searchString) {
        List<Property> propertyList = propertyRepository.findByNameIgnoreCaseContainingOrAddressIgnoreCaseContaining(searchString, searchString);
        List<PropertyDTO> propertyDTOList =  propertyList.stream().map(propertyMapper :: mapDTO).collect(Collectors.toList());
        if(null != propertyDTOList && propertyDTOList.size()>0) {
            return ResponseEntity.status(HttpStatus.OK).body(propertyDTOList);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}
