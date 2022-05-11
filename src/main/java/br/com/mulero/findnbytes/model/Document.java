package br.com.mulero.findnbytes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] archive;

    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

}
