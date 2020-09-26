package com.cft.shift;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class EquipmentNotFoundException extends RuntimeException {

    EquipmentNotFoundException(Long id) {
        super("Could not find computer " + id);
    }
}
