package br.com.mulero.findnbytes.controller;

import br.com.mulero.findnbytes.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @PostMapping("upload")
    public void uploadDocumento(@RequestParam MultipartFile arquivo) {
        service.upload(arquivo);
    }

}
