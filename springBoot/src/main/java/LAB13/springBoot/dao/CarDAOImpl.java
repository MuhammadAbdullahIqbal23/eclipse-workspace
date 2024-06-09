package LAB13.springBoot.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import LAB13.springBoot.bean.Car;

@Repository
public class CarDAOImpl implements CarDAO {
    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void updateCar(Car car) {
        cars = cars.stream()
                .map(c -> c.getId().equals(car.getId()) ? car : c)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}
