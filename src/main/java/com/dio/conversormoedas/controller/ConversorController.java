package com.dio.conversormoedas.controller;

import com.dio.conversormoedas.entity.Transacao;
import com.dio.conversormoedas.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conversor")
public class ConversorController {

    @Autowired
    private ConversorService conversorService;

    @PostMapping()
    public Transacao converterValor(@RequestParam String moeda,@RequestParam BigDecimal valor) {
        return conversorService.realizarConversor(moeda, valor);
    }
}
