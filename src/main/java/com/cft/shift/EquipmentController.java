package com.cft.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentController {

    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("/")
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
}
