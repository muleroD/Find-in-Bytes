package br.com.mulero.findnbytes.service;

import br.com.mulero.findnbytes.dto.IdNameDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    void upload(MultipartFile file);

    List<IdNameDto> listAll();

    String search(String word);
}
