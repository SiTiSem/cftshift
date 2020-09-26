package com.cft.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiskController {

    @Autowired
    DiskRepository diskRepository;

    @GetMapping("/disk")
    public List<Disk> getAllDisk() {
        return diskRepository.findAll();
    }

    @PostMapping("/disk")
    public Disk createDisk(@RequestBody Disk disk) {
        return diskRepository.save(disk);
    }

    @GetMapping("/disk/{id}")
    public Disk getDiskById(@PathVariable(value = "id") Long Id) {
        return diskRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));
    }

    @PutMapping("/disk/{id}")
    public Disk putDisk(@PathVariable(value = "id") Long Id,
                           @RequestBody Disk diskDetails) throws EquipmentNotFoundException {

        Disk disk = diskRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));

        disk.setArticle(diskDetails.getArticle());
        disk.setManufacturer(diskDetails.getManufacturer());
        disk.setPrice(diskDetails.getPrice());
        disk.setNumber(diskDetails.getNumber());
        disk.setSize(diskDetails.getSize());

        return diskRepository.save(disk);
    }
}
