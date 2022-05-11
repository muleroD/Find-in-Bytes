package br.com.mulero.findnbytes.service;

import br.com.mulero.findnbytes.dto.DocumentDTO;
import br.com.mulero.findnbytes.dto.IdNameDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    void upload(MultipartFile file);

    List<IdNameDTO> listAll();

    List<DocumentDTO> search(String word);
}
