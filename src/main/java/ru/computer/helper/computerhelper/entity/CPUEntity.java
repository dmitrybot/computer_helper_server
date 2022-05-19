package ru.computer.helper.computerhelper.entity;

import lombok.*;
import ru.computer.helper.computerhelper.model.ComponentParameter;
import ru.computer.helper.computerhelper.model.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CPUEntity implements ComponentEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double frequency;
    private int coreAmount;
    private int threadAmount;
    private double cost;
    private int tdp;
    private int passmark;
    private String model;

    @Override
    public Component toComponent(String recomendation) {
        Component c = new Component();
        c.setName(model);
        c.setRecomendation(recomendation);
        List<ComponentParameter> componentParameters = new ArrayList<>();
        componentParameters.add(new ComponentParameter("Частота", String.valueOf(frequency)));
        componentParameters.add(new ComponentParameter("Количество ядер", String.valueOf(coreAmount)));
        componentParameters.add(new ComponentParameter("Количество потоков", String.valueOf(threadAmount)));
        componentParameters.add(new ComponentParameter("Стоимость", String.valueOf(cost)));
        c.setComponentParameters(componentParameters);
        return c;
    }
}
