package br.com.angelo.controllers;

import br.com.angelo.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello sayHello(
            @RequestParam(value="name", defaultValue = "World")
            String name) {
        return new Hello(counter.incrementAndGet(), String.format(template,name));
    }
}
