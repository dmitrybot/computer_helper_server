package ru.computer.helper.computerhelper.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Component {

    private String name;
    private List<String> variants;
    private int icon;
    private String pickedVariant;
    private String recomendation;
    private List<ComponentParameter> componentParameters;

    public void addComponentParameter(ComponentParameter componentParameter){
        componentParameters.add(componentParameter);
    }

}
