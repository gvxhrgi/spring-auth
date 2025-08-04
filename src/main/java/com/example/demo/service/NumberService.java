package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumberService {
    public List<String> getEvenNumbersAsStrings(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}