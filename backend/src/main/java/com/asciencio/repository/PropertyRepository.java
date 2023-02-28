package com.asciencio.repository;

import com.asciencio.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

    List<Property> findByNameIgnoreCaseContainingOrAddressIgnoreCaseContaining(String propertyName, String propertyDetails);
}
