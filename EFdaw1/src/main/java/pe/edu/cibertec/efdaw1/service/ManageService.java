package pe.edu.cibertec.efdaw1.service;

import pe.edu.cibertec.efdaw1.dto.CarDetailDto;
import pe.edu.cibertec.efdaw1.dto.CarDto;
import pe.edu.cibertec.efdaw1.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(Integer id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(Integer id) throws Exception;

    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;

}
