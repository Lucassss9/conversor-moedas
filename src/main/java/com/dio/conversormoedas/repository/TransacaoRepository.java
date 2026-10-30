package com.dio.conversormoedas.repository;

import com.dio.conversormoedas.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
