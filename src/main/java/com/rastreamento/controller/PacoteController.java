package com.rastreamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rastreamento.model.Pacote;
import com.rastreamento.service.PacoteService;

@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {
    private final PacoteService service;

    public PacoteController(PacoteService service){
        this.service = service;
    }

    @GetMapping
    public List<Pacote> listarPacotes(){
        return service.listarPacotes();
    }

    @PostMapping
    public Pacote cadastrarPacote(@RequestBody Pacote pacote){
        return service.salvarPacote(pacote);
    }
}
