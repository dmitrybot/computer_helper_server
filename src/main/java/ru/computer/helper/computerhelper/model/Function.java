package ru.computer.helper.computerhelper.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Function {

    private int title = 2131755071;
    private int text = 2131755071;
    private int name = 2131755071;
    private int image = 0;
    private int position;
    List<Component> componentList = new ArrayList<>();



}
