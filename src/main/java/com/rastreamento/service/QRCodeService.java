package com.rastreamento.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class QRCodeService {

    private static final String QR_CODE_PATH = "qrcodes/";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    public  String gerarQRCode(String texto, String nomeArquivo) throws Exception {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(texto, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);

        Path path = FileSystems.getDefault().getPath(QR_CODE_PATH + nomeArquivo);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return path.toAbsolutePath().toString();
    }

    public String gerarQRCoDeBase64(String texto) throws Exception{
        BitMatrix bitMatrix = new MultiFormatWriter().encode(texto, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
