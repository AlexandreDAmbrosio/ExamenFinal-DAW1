package pe.edu.cibertec.efdaw1.response;

import pe.edu.cibertec.efdaw1.dto.CarDto;

import java.util.List;

public record FindCarsResponse(
        String code,
        String error,
        List<CarDto> cars
) {
}
