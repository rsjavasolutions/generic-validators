package com.rsjava.validators.car;

import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.car.response.CarResponse;
import com.rsjava.validators.car.service.CarService;
import com.rsjava.validators.car.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse getCar(@PathVariable String uuid) {
        return carService.getCar(uuid);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> getCars() {
        return carService.getCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCar(@RequestBody @Valid CarRequest request) {
        return carService.saveCar(request);
    }

    @PutMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse updateCar(@PathVariable String uuid,
                                 @RequestBody CarRequest request) {
        return carService.updateCar(uuid, request);
    }

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String uuid) {
        carService.deleteCar(uuid);
    }
}
