package com.asciencio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    @NotBlank(message = "PropertyName is mandatory")
    private String propertyName;
    @NotNull(message = "Type is mandatory")
    private PropertyType propertyType;
    @NotBlank(message = "PropertyOwner is mandatory")
    private PropertyType propertyOwner;
    @NotNull(message = "occupancyStatus is mandatory")
    private OccupancyStatus occupancyStatus;
    @NotBlank(message = "PropertyDetails is mandatory")
    private String propertyDetails;
    private Boolean authorized;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyDTO that = (PropertyDTO) o;

        if (!getId().equals(that.getId())) return false;
        if (!getPropertyName().equals(that.getPropertyName())) return false;
        if (getPropertyType() != that.getPropertyType()) return false;
        if (getPropertyOwner() != that.getPropertyOwner()) return false;
        if (getOccupancyStatus() != that.getOccupancyStatus()) return false;
        if (!getPropertyDetails().equals(that.getPropertyDetails())) return false;
        return getAuthorized().equals(that.getAuthorized());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getPropertyName().hashCode();
        result = 31 * result + getPropertyType().hashCode();
        result = 31 * result + getPropertyOwner().hashCode();
        result = 31 * result + getOccupancyStatus().hashCode();
        result = 31 * result + getPropertyDetails().hashCode();
        result = 31 * result + getAuthorized().hashCode();
        return result;
    }
}
