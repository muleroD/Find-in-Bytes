package br.com.mulero.findnbytes.dto;

import br.com.mulero.findnbytes.model.Document;
import lombok.Data;

@Data
public class IdNameDTO {
    private Long id;
    private String name;

    public IdNameDTO(Document document) {
        this.id = document.getId();
        this.name = document.getName();
    }
}
