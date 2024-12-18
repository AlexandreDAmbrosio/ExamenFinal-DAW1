package pe.edu.cibertec.efdaw1.dto;

import java.util.Date;

public record CarDto(
        Integer carId,
        String make,
        String model,
        Integer year,
        String ownerName,
        Date purchaseDate,
        Integer mileage,
        String engineType,
        String color
) {
}
