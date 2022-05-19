package ru.computer.helper.computerhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.computer.helper.computerhelper.entity.GPUEntity;
import ru.computer.helper.computerhelper.entity.PowerSupplyUnitEntity;
import ru.computer.helper.computerhelper.model.Component;
import ru.computer.helper.computerhelper.model.Function;
import ru.computer.helper.computerhelper.repository.CPURepository;
import ru.computer.helper.computerhelper.repository.GPURepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPUService {

    @Autowired
    CPURepository cpuRepository;
    @Autowired
    GPURepository gpuRepository;

    public List<Component> getGPUComponent(Function function){
        List<Component> components = gpuRepository.findAll()
                .stream()
                .filter(s -> s.getPassmark() < cpuRepository.findByModel(function
                                .getComponentList()
                                .get(0)
                                .getPickedVariant())
                        .getPassmark() * 1.5)
                .sorted(Comparator.comparing(obj -> obj.getPassmark()))
                .map(s -> s.toComponent(null))
                .collect(Collectors.toList());
        return components.subList(Math.max(0, components.size() - 5), components.size());
    }
}
