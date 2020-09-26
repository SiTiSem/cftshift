package com.cft.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    @GetMapping("/computer")
    public List<Computer> getAllComputer() {
        return computerRepository.findAll();
    }

    @PostMapping("/computer")
    public Computer createComputer(@RequestBody Computer computer) {
        return computerRepository.save(computer);
    }

    @GetMapping("/computer/{id}")
    public Computer getComputerById(@PathVariable(value = "id") Long computerId) {
        return computerRepository.findById(computerId)
                .orElseThrow(() -> new EquipmentNotFoundException(computerId));
    }

    @PutMapping("/computer/{id}")
    public Computer putComputer(@PathVariable(value = "id") Long computerId,
                           @RequestBody Computer computerDetails) throws EquipmentNotFoundException {

        Computer computer = computerRepository.findById(computerId)
                .orElseThrow(() -> new EquipmentNotFoundException(computerId));

        computer.setArticle(computerDetails.getArticle());
        computer.setManufacturer(computerDetails.getManufacturer());
        computer.setPrice(computerDetails.getPrice());
        computer.setNumber(computerDetails.getNumber());
        computer.setFormFactor(computerDetails.getFormFactor());

        return computerRepository.save(computer);
    }
}
