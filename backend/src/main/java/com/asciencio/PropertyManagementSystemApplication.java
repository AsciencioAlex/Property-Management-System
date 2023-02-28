package com.asciencio;

import com.asciencio.model.OccupancyStatus;
import com.asciencio.model.Property;
import com.asciencio.model.PropertyType;
import com.asciencio.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class PropertyManagementSystemApplication implements CommandLineRunner {
	@Autowired
	private PropertyRepository propertyRepository;

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Property property = Property.builder()
				.propertyName("Nokratis Hotel")
				.propertyDetails("Hotel")
				.propertyOwner("Alex Asciencio")
				.propertyType(PropertyType.INDEPENDENT)
				.occupancyStatus(OccupancyStatus.VACANT)
				.authorized(false)
				.createdAt(Instant.now())
				.build();
		Property property1 = Property.builder()
				.propertyName("Himalayas Gardens Resort")
				.propertyDetails("Resort")
				.propertyOwner("Alex Asciencio")
				.propertyType(PropertyType.BUILDER)
				.occupancyStatus(OccupancyStatus.OCCUPIED)
				.authorized(false)
				.createdAt(Instant.now())
				.build();

		Property property3 = Property.builder()
				.propertyName("Malkins Motel")
				.propertyDetails("Motel")
				.propertyOwner("Alex Asciencio")
				.propertyType(PropertyType.APARTMENT)
				.occupancyStatus(OccupancyStatus.BOOKED)
				.authorized(false)
				.createdAt(Instant.now())
				.build();

		propertyRepository.save(property);
		propertyRepository.save(property1);
		propertyRepository.save(property3);

	}
}