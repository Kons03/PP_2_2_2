package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @RequestMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count,
                          Model model) {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Moskvich Sobyanina", "001", "Color of shit");
        Car car2 = new Car("Dodge", "SUVs", "Red");
        Car car3 = new Car("Ferrari", "448", "Blue");
        Car car4 = new Car("Mercedes", "600", "Green");
        Car car5 = new Car("Volvo", "XC90", "Purple");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        model.addAttribute("cars", cars.stream().limit(count).collect(Collectors.toList()));

        return "cars";
    }
}
