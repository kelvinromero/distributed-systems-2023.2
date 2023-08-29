package br.edu.ifpb.progdist.hellospring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public static String hello() {
        return "Hello KELVIN ROMERO";
    }
}
