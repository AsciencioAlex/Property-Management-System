package com.asciencio.controller;

import com.asciencio.model.PropertyDTO;
import com.asciencio.service.PropertyService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("api/v1/property")
public class PropertyManagementController {
	@Setter
	@Autowired
	private PropertyService propertyService;

	@ApiOperation(value = "Saves the property entry in the given JSON format",
			notes = "Pass valid type values",
			response = ResponseEntity.class)
	@PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity add(@Valid @RequestBody PropertyDTO propertyDTO) {
		return propertyService.save(propertyDTO);
	}

	@ApiOperation(value = "updates the property entry in the given JSON format",
			notes = "Only propertyType, occupancyStatus fields can be updated",
			response = ResponseEntity.class)
	@PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity update(@RequestBody PropertyDTO propertyDTO){
		return propertyService.update(propertyDTO);
	}

	@ApiOperation(value = "Approves the property with given id to be listed",
			notes = "A property once approved, cannot be disapproved",
			response = ResponseEntity.class)
	@PostMapping(value = "/approve/{propertyId}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity approve(@PathVariable("propertyId") Long propertyId){
		return propertyService.approve(propertyId);
	}

	@ApiOperation(value = "Searches for property based on matching any of  name, address, propertyType or occupancyStatus",
			notes = "Returns list of properties matching any of the search strings",
			response = ResponseEntity.class)
	@GetMapping(value = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity search(@RequestParam("searchString") String searchString){
		return propertyService.search(searchString);
	}

}
