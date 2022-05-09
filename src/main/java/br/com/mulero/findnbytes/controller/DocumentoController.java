package br.com.mulero.findnbytes.controller;

import br.com.mulero.findnbytes.dto.DocumentoDTO;
import br.com.mulero.findnbytes.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping("listar")
    public List<DocumentoDTO> listarDocumentos() {
        return service.listAll();
    }

    @GetMapping("pesquisar")
    public String pesquisarDocumentos(@RequestParam String trecho) {
        // TODO - Retornar documentos com trecho pesquisado
        return trecho;
    }

    @PostMapping("upload")
    public void uploadDocumento(@RequestParam MultipartFile arquivo) {
        service.upload(arquivo);
    }

}
