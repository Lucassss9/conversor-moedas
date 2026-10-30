package com.dio.conversormoedas.client;

import com.dio.conversormoedas.dto.ConversorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "awesomeApi", url = "https://economia.awesomeapi.com.br/json/last")
public interface CotacaoClient {

    @GetMapping("/{moedas}")
    Map<String, ConversorDto> buscarCotacao(@PathVariable("moedas") String moedas);
}
