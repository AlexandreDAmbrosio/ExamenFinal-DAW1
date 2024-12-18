package pe.edu.cibertec.efdaw1.response;

import pe.edu.cibertec.efdaw1.dto.CarDetailDto;

public record FindCarResponse(
        String code,
        String error,
        CarDetailDto carDetailDto
) {
}
