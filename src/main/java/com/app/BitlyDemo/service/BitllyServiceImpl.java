package com.app.BitlyDemo.service;


import com.app.BitlyDemo.DTO.BityResponseDTO;
import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BitllyServiceImpl implements  BitllyService{

    @Value("${bitly_token}")
    String BITLY_TOKEN;

    private Bitly client;

    @PostConstruct
    public void setup(){
        client = new Bitly(BITLY_TOKEN);
    }

    public BityResponseDTO processBitly(String longURL) {

       String link = "error";

       try{
           CreateBitlinkResponse response = client.bitlinks().shorten(longURL).get();
           link = response.getLink();
       }catch (Exception ex){
            log.error("Bily error {}", ex);
       }

        BityResponseDTO  bitly = new BityResponseDTO();
        bitly.setShortenURL(link);

        return bitly;
    }


}
