package com.tokarskia.BackendMagisterka.controller;

import com.tokarskia.BackendMagisterka.HelperClasses.DatabaseDataGetter;
import com.tokarskia.BackendMagisterka.HelperClasses.StringSimilarity;
import com.tokarskia.BackendMagisterka.model.Response;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ResponseController {
    @GetMapping("/porownajTexty")
    public Response generateResponse(@RequestParam(value = "textLength", defaultValue = "100")Long textLength, @RequestParam(value = "czasWyslaniaRequestuZFrontendu", defaultValue = "100")Long czasWyslaniaRequestuZFrontendu){
        Pair<Long, List<String>> czasOrazTekstyZBazyDanych = pobierzTekstyZBazyDanych();
        Long czasPobraniaTekstowZBazyDanych = czasOrazTekstyZBazyDanych.getFirst();
        Long czasPrzeslaniaRequestuZFrontuDoBackendu = policzCzasPrzesaniaRequestuZFrontenduDoBackendu(czasWyslaniaRequestuZFrontendu);
        Double podobienstwoTextow = StringSimilarity.similarity(czasOrazTekstyZBazyDanych.getSecond().get(0),czasOrazTekstyZBazyDanych.getSecond().get(1));
        return new Response(czasPobraniaTekstowZBazyDanych,czasPrzeslaniaRequestuZFrontuDoBackendu, "100", podobienstwoTextow);
    }

    private Long policzCzasPrzesaniaRequestuZFrontenduDoBackendu(Long czasWyslaniaRequestuZFrontendu){
        return System.currentTimeMillis() - czasWyslaniaRequestuZFrontendu;
    }

    private Pair<Long, List<String>> pobierzTekstyZBazyDanych (){
        LinkedList<String> ll = new LinkedList<String>();
        Long timeBeforeDataRetrival = System.currentTimeMillis();
        Pair<String, String> texts = DatabaseDataGetter.getTexts();
        Long timeAfterDataRetrival = System.currentTimeMillis();
        Long elapsedTimeToGetData = timeAfterDataRetrival - timeBeforeDataRetrival;
        ll.add(texts.getFirst());
        ll.add(texts.getSecond());
        Pair<Long, List<String>> qq = Pair.of(elapsedTimeToGetData,ll);
        return qq;
    }
}
