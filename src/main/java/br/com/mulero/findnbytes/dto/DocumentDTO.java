package br.com.mulero.findnbytes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentDTO {
    private String filename;
    private String snippet;
}
