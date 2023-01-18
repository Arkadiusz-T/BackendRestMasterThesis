package com.tokarskia.BackendMagisterka.controller;

import com.tokarskia.BackendMagisterka.HelperClasses.DatabaseDataGetter;
import com.tokarskia.BackendMagisterka.HelperClasses.StringSimilarity;
import com.tokarskia.BackendMagisterka.model.Response;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ResponseController {
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/porownajTexty")
    public Response generateResponse(
            @RequestParam(value = "textLength", defaultValue = "krotkie")String textLength,
            @RequestParam(value = "textType", defaultValue = "varchar")String textType,
            @RequestParam(value = "requestSentTimeStamp", defaultValue = "100")Long requestSentTime,
            @RequestParam(value = "dbmsType", defaultValue = "mysql")String dbmsType){
        Long czasPrzeslaniaRequestuZFrontuDoBackendu = policzCzasPrzesaniaRequestuZFrontenduDoBackendu(requestSentTime, System.currentTimeMillis());
        Pair<Long, List<String>> czasOrazTekstyZBazyDanych = pobierzTekstyZBazyDanych(textLength, textType, dbmsType);
        Double podobienstwoTextow = StringSimilarity.similarity(czasOrazTekstyZBazyDanych.getSecond().get(0),czasOrazTekstyZBazyDanych.getSecond().get(1));
        return new Response(
                czasOrazTekstyZBazyDanych.getFirst(),
                czasPrzeslaniaRequestuZFrontuDoBackendu,
                System.currentTimeMillis(),
                podobienstwoTextow
        );
    }

    private Long policzCzasPrzesaniaRequestuZFrontenduDoBackendu(Long czasWyslaniaRequestuZFrontendu, Long timeNow){
        return timeNow - czasWyslaniaRequestuZFrontendu;
    }

    private Pair<Long, List<String>> pobierzTekstyZBazyDanych (String textsLength, String textsType, String dbmsType){
        LinkedList<String> ll = new LinkedList<String>();
        Long timeBeforeDataRetrival = System.currentTimeMillis();
        Pair<String, String> texts = DatabaseDataGetter.getTexts(textsLength, textsType, dbmsType);
        Long timeAfterDataRetrival = System.currentTimeMillis();
        Long elapsedTimeToGetData = timeAfterDataRetrival - timeBeforeDataRetrival;
        ll.add(texts.getFirst());
        ll.add(texts.getSecond());
        Pair<Long, List<String>> qq = Pair.of(elapsedTimeToGetData,ll);
        return qq;
    }
}
