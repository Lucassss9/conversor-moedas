package com.dio.conversormoedas.service;

import com.dio.conversormoedas.client.CotacaoClient;
import com.dio.conversormoedas.dto.ConversorDto;
import com.dio.conversormoedas.entity.Transacao;
import com.dio.conversormoedas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class ConversorService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CotacaoClient cotacaoClient;

    private BigDecimal conversorMoedas(BigDecimal moeda, BigDecimal cotacao) {
        BigDecimal resultado = moeda.divide(cotacao, 2, RoundingMode.HALF_UP);
        return resultado;
    }

    public Transacao realizarConversor(String moeda, BigDecimal valor) {
        var resposta = cotacaoClient.buscarCotacao(moeda + "-BRL");
        ConversorDto conversor = resposta.get(moeda + "BRL");

        BigDecimal valorConvertido = conversorMoedas(valor, conversor.bid());

        Transacao transacao = new Transacao(null, moeda, valor, valorConvertido, LocalDate.now());

        return transacaoRepository.save(transacao);
    }
}
