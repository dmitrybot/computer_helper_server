package ru.computer.helper.computerhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.computer.helper.computerhelper.model.Component;
import ru.computer.helper.computerhelper.model.ComponentParameter;
import ru.computer.helper.computerhelper.model.Function;
import ru.computer.helper.computerhelper.entity.PowerSupplyUnitEntity;
import ru.computer.helper.computerhelper.repository.CPURepository;
import ru.computer.helper.computerhelper.repository.GPURepository;
import ru.computer.helper.computerhelper.repository.PowerSupplyUnitRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerSupplyUnitService {

    @Autowired
    PowerSupplyUnitRepository powerSupplyUnitRepository;
    @Autowired
    CPURepository cpuRepository;
    @Autowired
    GPURepository gpuRepository;

    public List<Component> getPowerSupplyUnitComponents(Function function){
        List<Component> components = new ArrayList<>();


        int pcPower = cpuRepository.findByModel(function.getComponentList().get(1).getPickedVariant()).getTdp() +
                gpuRepository.findByModel(function.getComponentList().get(2).getPickedVariant()).getTdp() +
                Integer.parseInt(function.getComponentList().get(0).getPickedVariant().substring(0, 1)) * 5 + 70;

        System.out.println(pcPower);

        Comparator<PowerSupplyUnitEntity> comparator = Comparator.comparing(obj -> obj.getCost());
        List<PowerSupplyUnitEntity> powerSupplyUnitEntities = powerSupplyUnitRepository.findAll()
                .stream().sorted(comparator).collect(Collectors.toList());
        boolean[] b = {true, true, true};
        for (PowerSupplyUnitEntity p : powerSupplyUnitEntities){
            if (p.getPower() * p.getEfficiency() * 0.01 * 0.85 > pcPower && b[0]){
                Component c = p.toComponent("Лучшая цена");
                c.addComponentParameter(new ComponentParameter("Загруженность", String.valueOf((double) pcPower / (double) p.getPower())));
                components.add(c);
                b[0] = false;
                continue;
            }

            if (p.getPower() * p.getEfficiency() * 0.01 * 0.65 > pcPower && b[1]){
                Component c = p.toComponent(null);
                c.addComponentParameter(new ComponentParameter("Загруженность", String.valueOf((double) pcPower / (double) p.getPower())));
                components.add(c);
                b[1] = false;
                continue;
            }

            if (p.getPower() * p.getEfficiency() * 0.01 * 0.55 > pcPower && b[2]){
                Component c = p.toComponent("Наиболее подходящий");
                c.addComponentParameter(new ComponentParameter("Загруженность", String.valueOf((double) pcPower / (double) p.getPower())));
                components.add(c);
                b[2] = false;
                break;
            }
        }
        return components;
    }
}
