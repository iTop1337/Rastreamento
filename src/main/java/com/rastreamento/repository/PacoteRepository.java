package com.rastreamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rastreamento.model.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
