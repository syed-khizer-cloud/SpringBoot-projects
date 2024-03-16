package com.example.mileage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MileageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateMileage(@RequestParam("initialDistance") double initialDistance,
                                   @RequestParam("finalDistance") double finalDistance,
                                   @RequestParam("fuel") double fuel,
                                   Model model) {
        double mileage = calculateMileage(initialDistance, finalDistance, fuel);
        model.addAttribute("mileage", mileage);
        return "result";
    }

    private double calculateMileage(double initialDistance, double finalDistance, double fuel) {
        double distanceTravelled = finalDistance - initialDistance;
        return distanceTravelled / fuel;
    }
}
