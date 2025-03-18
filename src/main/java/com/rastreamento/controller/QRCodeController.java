package com.rastreamento.controller;

import com.rastreamento.service.QRCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService){
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateQRCode(@RequestParam String texto){
        try {
            String qrCodeBase64 = qrCodeService.gerarQRCoDeBase64(texto);
            return ResponseEntity.ok(qrCodeBase64);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Erro ao gerar QR Code");
        }
    }
}
