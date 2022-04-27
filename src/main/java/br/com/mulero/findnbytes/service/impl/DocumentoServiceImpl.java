package br.com.mulero.findnbytes.service.impl;

import br.com.mulero.findnbytes.model.Documento;
import br.com.mulero.findnbytes.repository.DocumentoRepository;
import br.com.mulero.findnbytes.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static br.com.mulero.findnbytes.util.FileReaderUtils.getBytes;
import static br.com.mulero.findnbytes.util.FileReaderUtils.getContent;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Override
    public void upload(MultipartFile file) {
        Documento documento = Documento.builder()
                .nome(file.getOriginalFilename())
                .arquivo(getBytes(file))
                .conteudo(getContent(file))
                .build();

        repository.save(documento);
    }


}
