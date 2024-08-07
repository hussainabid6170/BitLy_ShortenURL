package com.app.BitlyDemo.controller;


import com.app.BitlyDemo.DTO.BityRequestDTO;
import com.app.BitlyDemo.DTO.BityResponseDTO;
import com.app.BitlyDemo.service.BitllyService;
import com.opsmatters.bitly.api.services.BitlyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class BitlyRestController {

    private BitllyService bitlyService;


    public BitlyRestController (BitllyService bitlyService){
        this.bitlyService = bitlyService;
    }


        @PostMapping("postbitly")
        public BityResponseDTO processBitly(@RequestBody BityRequestDTO bityRequestDTO){
           return  bitlyService.processBitly(bityRequestDTO.getLongURL());
        }


}
