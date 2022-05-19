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
public class PowerSupplyUnitEntity implements ComponentEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int power;
    private double efficiency;
    private double cost;
    private String model;

    @Override
    public Component toComponent(String recomendation) {
        Component c = new Component();
        c.setName(model);
        c.setRecomendation(recomendation);
        List<ComponentParameter> componentParameters = new ArrayList<>();
        componentParameters.add(new ComponentParameter("Мощность", String.valueOf(power) + " Вт"));
        componentParameters.add(new ComponentParameter("КПД", String.valueOf(efficiency) + " %"));
        componentParameters.add(new ComponentParameter("Стоимость", String.valueOf(cost) + " р"));
        c.setComponentParameters(componentParameters);
        return c;
    }
}
