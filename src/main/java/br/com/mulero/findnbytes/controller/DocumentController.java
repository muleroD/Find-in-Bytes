package br.com.mulero.findnbytes.controller;

import br.com.mulero.findnbytes.dto.DocumentDTO;
import br.com.mulero.findnbytes.dto.IdNameDTO;
import br.com.mulero.findnbytes.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DocumentController {

    private final DocumentService service;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.service = documentService;
    }

    @GetMapping("listAll")
    public List<IdNameDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("search")
    public List<DocumentDTO> searchDocuments(@RequestParam String word) {
        return service.search(word);
    }

    @PostMapping("upload")
    public void uploadFile(@RequestParam MultipartFile arquivo) {
        service.upload(arquivo);
    }

}
