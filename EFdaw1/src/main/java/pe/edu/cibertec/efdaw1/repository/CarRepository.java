package pe.edu.cibertec.efdaw1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.efdaw1.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
