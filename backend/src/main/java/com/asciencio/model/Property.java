package com.asciencio.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propertyName;
    private PropertyType propertyType;
    private String propertyOwner;
    private OccupancyStatus occupancyStatus;
    private String propertyDetails;
    private Boolean authorized;
    private Instant createdAt;
    private Instant updatedAt;
}
