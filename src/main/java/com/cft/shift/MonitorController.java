package com.cft.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonitorController {

    @Autowired
    MonitorRepository monitorRepository;

    @GetMapping("/monitor")
    public List<Monitor> getAllMonitor() {
        return monitorRepository.findAll();
    }

    @PostMapping("/monitor")
    public Monitor createMonitor(@RequestBody Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @GetMapping("/monitor/{id}")
    public Monitor getMonitorById(@PathVariable(value = "id") Long Id) {
        return monitorRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));
    }

    @PutMapping("/monitor/{id}")
    public Monitor putMonitor(@PathVariable(value = "id") Long Id,
                           @RequestBody Monitor monitorDetails) throws EquipmentNotFoundException {

        Monitor monitor = monitorRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));

        monitor.setArticle(monitorDetails.getArticle());
        monitor.setManufacturer(monitorDetails.getManufacturer());
        monitor.setPrice(monitorDetails.getPrice());
        monitor.setNumber(monitorDetails.getNumber());
        monitor.setDiagonal(monitorDetails.getDiagonal());

        return monitorRepository.save(monitor);
    }
}
