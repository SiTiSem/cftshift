package com.cft.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotebookController {

    @Autowired
    NotebookRepository notebookRepository;

    @GetMapping("/notebook")
    public List<Notebook> getAllNotebook() {
        return notebookRepository.findAll();
    }

    @PostMapping("/notebook")
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    @GetMapping("/notebook/{id}")
    public Notebook getNotebookById(@PathVariable(value = "id") Long Id) {
        return notebookRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));
    }

    @PutMapping("/notebook/{id}")
    public Notebook putNotebook(@PathVariable(value = "id") Long Id,
                           @RequestBody Notebook notebookDetails) throws EquipmentNotFoundException {

        Notebook notebook = notebookRepository.findById(Id)
                .orElseThrow(() -> new EquipmentNotFoundException(Id));

        notebook.setArticle(notebookDetails.getArticle());
        notebook.setManufacturer(notebookDetails.getManufacturer());
        notebook.setPrice(notebookDetails.getPrice());
        notebook.setNumber(notebookDetails.getNumber());
        notebook.setSize(notebookDetails.getSize());

        return notebookRepository.save(notebook);
    }
}
