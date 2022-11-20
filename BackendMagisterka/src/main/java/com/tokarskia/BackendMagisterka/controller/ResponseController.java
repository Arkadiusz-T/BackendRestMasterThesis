package com.tokarskia.BackendMagisterka.controller;

import com.tokarskia.BackendMagisterka.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    final Long czasOtrzymaniaZapytaniaZFrontendu = System.currentTimeMillis();

    @GetMapping("/porownajTexty")
    public Response generateResponse(@RequestParam(value = "textLength", defaultValue = "100")String textLength){
        return new Response(100.0,"100", "100");
    }
}
