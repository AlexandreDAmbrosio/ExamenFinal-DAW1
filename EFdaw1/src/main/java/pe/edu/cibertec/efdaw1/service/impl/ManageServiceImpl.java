package pe.edu.cibertec.efdaw1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.efdaw1.dto.CarDetailDto;
import pe.edu.cibertec.efdaw1.dto.CarDto;
import pe.edu.cibertec.efdaw1.dto.CarUpdateDto;
import pe.edu.cibertec.efdaw1.entity.Car;
import pe.edu.cibertec.efdaw1.repository.CarRepository;
import pe.edu.cibertec.efdaw1.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCarId(), car.getMake(), car.getModel(),
                    car.getYear(), car.getOwnerName(), car.getPurchaseDate(), car.getMileage(),
                    car.getEngineType(), car.getColor())
            );
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(
                car -> new CarDetailDto(
                        car.getCarId(), car.getMake(), car.getModel(), car.getYear(), car.getVin(),
                        car.getLicensePlate(), car.getOwnerName(), car.getOwnerContact(), car.getPurchaseDate(),
                        car.getMileage(), car.getEngineType(), car.getColor(), car.getInsuranceCompany(),
                        car.getInsurancePolicyNumber(), car.getRegistrationExpirationDate(), car.getServiceDueDate()
                )
        );
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setOwnerName(carDto.ownerName());
            car.setPurchaseDate(carDto.purchaseDate());
            car.setMileage(carDto.mileage());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarUpdateDto carUpdateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        if (optional.isEmpty()) {
            Car car = new Car();
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setVin(carUpdateDto.vin());
            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerName(carUpdateDto.ownerName());
            car.setOwnerContact(carUpdateDto.ownerContact());
            car.setPurchaseDate(new Date());
            car.setMileage(carUpdateDto.mileage());
            car.setEngineType(carUpdateDto.engineType());
            car.setColor(carUpdateDto.color());
            car.setInsuranceCompany(carUpdateDto.insuranceCompany());
            car.setInsurancePolicyNumber(carUpdateDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carUpdateDto.registrationExpirationDate());
            carRepository.save(car);
            return true;
        } else {
            return false;
        }
    }
}
