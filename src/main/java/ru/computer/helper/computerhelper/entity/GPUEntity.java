package ru.computer.helper.computerhelper.entity;

import lombok.*;
import ru.computer.helper.computerhelper.model.Component;
import ru.computer.helper.computerhelper.model.ComponentParameter;

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
public class GPUEntity implements ComponentEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeVideoMemory;
    private double videoMemory;
    private double frequency;
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
        componentParameters.add(new ComponentParameter("Тип видеопамяти", String.valueOf(typeVideoMemory)));
        componentParameters.add(new ComponentParameter("Количество видеопамяти", String.valueOf(videoMemory)));
        componentParameters.add(new ComponentParameter("Стоимость", String.valueOf(cost)));
        c.setComponentParameters(componentParameters);
        return c;
    }
}
