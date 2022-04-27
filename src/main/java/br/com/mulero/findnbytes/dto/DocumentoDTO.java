package br.com.mulero.findnbytes.dto;

import br.com.mulero.findnbytes.model.Documento;
import lombok.Data;

@Data
public class DocumentoDTO {
    private Long id;
    private String nome;

    public DocumentoDTO(Documento documento) {
        this.id = documento.getId();
        this.nome = documento.getNome();
    }
}
