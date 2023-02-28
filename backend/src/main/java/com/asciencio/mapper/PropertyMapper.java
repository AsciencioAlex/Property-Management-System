package com.asciencio.mapper;

import com.asciencio.model.Property;
import com.asciencio.model.PropertyDTO;
import org.mapstruct.*;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        componentModel = "spring")
public abstract class PropertyMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "propertyName", source = "propertyName")
    @Mapping(target = "propertyDetails", source = "propertyDetails")
    @Mapping(target = "propertyOwner", source = "propertyOwner")
    @Mapping(target = "authorized", expression = "java(false)")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
   
    public abstract Property mapEntity(PropertyDTO propertyDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "propertyName", source = "propertyName")
    @Mapping(target = "propertyDetails", source = "propertyDetails")
    @Mapping(target = "propertyOwner", source = "propertyOwner")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    public abstract Property updateEntity(@MappingTarget Property property, PropertyDTO propertyDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "propertyName", source = "propertyName")
    @Mapping(target = "propertyDetails", source = "propertyDetails")
    @Mapping(target = "propertyOwner", source = "propertyOwner")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "authorized", source = "authorized")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "createdAt")
    public abstract PropertyDTO mapDTO(Property property);
}
