package ru.computer.helper.computerhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.computer.helper.computerhelper.model.Function;
import ru.computer.helper.computerhelper.service.FunctionService;

import java.util.List;

@RestController
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @GetMapping("/functions")
    public List<Function> getFunctions(){
        return functionService.getFunctions();
    }
}
