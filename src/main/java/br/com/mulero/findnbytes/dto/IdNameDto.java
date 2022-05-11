package br.com.mulero.findnbytes.dto;

import br.com.mulero.findnbytes.model.Document;
import lombok.Data;

@Data
public class IdNameDto {
    private Long id;
    private String name;

    public IdNameDto(Document document) {
        this.id = document.getId();
        this.name = document.getName();
    }
}
