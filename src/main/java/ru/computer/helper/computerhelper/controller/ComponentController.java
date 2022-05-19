package ru.computer.helper.computerhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.computer.helper.computerhelper.model.Component;
import ru.computer.helper.computerhelper.model.Function;
import ru.computer.helper.computerhelper.service.GPUService;
import ru.computer.helper.computerhelper.service.PowerSupplyUnitService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ComponentController {

    @Autowired
    PowerSupplyUnitService powerSupplyUnitService;
    @Autowired
    GPUService gpuService;

    @PostMapping("/components")
    public List<Component> getComponents(@RequestBody Function function){
        switch (function.getPosition()){
            case 0:
                return powerSupplyUnitService.getPowerSupplyUnitComponents(function);
            case 1:
                return gpuService.getGPUComponent(function);
        }
        return null;
    }

}
