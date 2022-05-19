package ru.computer.helper.computerhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.computer.helper.computerhelper.model.Component;
import ru.computer.helper.computerhelper.model.Function;
import ru.computer.helper.computerhelper.repository.CPURepository;
import ru.computer.helper.computerhelper.repository.GPURepository;
import ru.computer.helper.computerhelper.repository.PowerSupplyUnitRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FunctionService {

    @Autowired
    PowerSupplyUnitRepository powerSupplyUnitRepository;
    @Autowired
    CPURepository cpuRepository;
    @Autowired
    GPURepository gpuRepository;

    public List<Function> getFunctions(){
        List<Function> functions = new ArrayList<>();

        // making batary search function
        List<Component> components = new ArrayList<>();
        components.add(getCoolingComponent());
        components.add(getCPUComponent());
        components.add(getGPUComponent());

        int battery_title = 2131755039;
        int battery_text = 2131755038;
        int battery_name = 2131755037;
        int battery_drawable = 2131230814;
        functions.add(new Function(battery_title, battery_text, battery_name, battery_drawable, 0,  components));

        // making gpu balanced function
        components = new ArrayList<>();
        components.add(getCPUComponent());
        int gpu_title =   2131755074;
        int gpu_text =    2131755073;
        int gpu_name =    2131755072;
        int gpu_drawable =2131230854;
        functions.add(new Function(gpu_title, gpu_text, gpu_name, gpu_drawable, 1, components));
        // todo make functions here
        functions.add(new Function());
        functions.add(new Function());
        functions.add(new Function());
        functions.add(new Function());
        functions.add(new Function());
        functions.add(new Function());
        functions.add(new Function());

        return functions;
    }

    private Component getCoolingComponent(){
        Component c = new Component();
        c.setName("Охлаждение");
        c.setIcon(2131230844);
        List<String> variants = Arrays.asList("1 вентилятор", "2 вентилятора", "3 вентилятора", "4 вентилятора",
                "5 вентиляторов", "6 вентиляторов", "7 вентиляторов", "8 вентиляторов");
        c.setVariants(variants);
        // todo water cooling
        return c;
    }

    private Component getCPUComponent(){
        Component c = new Component();
        c.setName("Процессор");
        c.setIcon(2131230845);
        List<String> variants = cpuRepository.findAll().stream().map((s) -> s.getModel()).collect(Collectors.toList());
        c.setVariants(variants);
        return c;
    }

    private Component getGPUComponent(){
        Component c = new Component();
        c.setName("Видеокарта");
        c.setIcon(2131230855);
        List<String> variants = gpuRepository.findAll().stream().map((s) -> s.getModel()).collect(Collectors.toList());
        c.setVariants(variants);
        return c;
    }
}
