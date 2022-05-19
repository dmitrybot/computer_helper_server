package ru.computer.helper.computerhelper.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PowerSupplyUnitModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int power;
    private double efficiency;
    private double cost;
    private String model;
    private String recomendation = null;
    private String variants;


}
