package br.com.angelo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/soma/{valorX}/{valorY}",
                    method=RequestMethod.GET)
    public Double soma(
            @PathVariable("valorX") Double valor1,
            @PathVariable("valorY") String valor2
    ) {

        return 1D;
    }
}
