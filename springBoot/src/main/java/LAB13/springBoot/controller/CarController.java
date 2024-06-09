package LAB13.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import LAB13.springBoot.bean.Car;
import LAB13.springBoot.dao.CarDAO;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarDAO carDAO;

    @GetMapping
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carDAO.getCarById(id);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carDAO.addCar(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        carDAO.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carDAO.deleteCar(id);
    }
}
