package com.example.demo.controller;

import com.example.demo.service.NumberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {
    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/even")
    public List<String> getEvenNumbers(@RequestBody List<Integer> numbers) {
        return numberService.getEvenNumbersAsStrings(numbers);
    }
}