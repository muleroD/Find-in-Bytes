package br.com.mulero.findnbytes.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentoService {
    void upload(MultipartFile file);
}
