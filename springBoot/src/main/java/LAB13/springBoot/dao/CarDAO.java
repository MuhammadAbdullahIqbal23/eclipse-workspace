package LAB13.springBoot.dao;

import java.util.List;
import LAB13.springBoot.bean.Car;

public interface CarDAO {
    List<Car> getAllCars();
    Car getCarById(Long id);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(Long id);
}
