package br.com.mulero.findnbytes.service;

import br.com.mulero.findnbytes.dto.DocumentoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentoService {
    void upload(MultipartFile file);

    List<DocumentoDTO> listAll();

}
