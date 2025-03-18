package com.rastreamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rastreamento.model.Pacote;
import com.rastreamento.repository.PacoteRepository;

@Service
public class PacoteService {
    private final PacoteRepository repository;
    public  final QRCodeService qrCodeService;

    public PacoteService(PacoteRepository repository, QRCodeService qrCodeService){
        this.repository = repository;
        this.qrCodeService = qrCodeService;
    }

    public List<Pacote> listarPacotes(){
        return repository.findAll();
    }

    public Pacote salvarPacote(Pacote pacote){
        try {
            String qrCodeBase64 = qrCodeService.gerarQRCoDeBase64(pacote.getLocalizacao());
            pacote.setCodigoQR(qrCodeBase64);
        } catch (Exception e){
            throw new RuntimeException("Erro ao gerar QR code", e);
        }
        return repository.save(pacote);
    }
}
