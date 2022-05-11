package br.com.mulero.findnbytes.service.impl;

import br.com.mulero.findnbytes.dto.DocumentDTO;
import br.com.mulero.findnbytes.dto.IdNameDTO;
import br.com.mulero.findnbytes.model.Document;
import br.com.mulero.findnbytes.model.repository.DocumentRepository;
import br.com.mulero.findnbytes.model.specification.DocumentSpecification;
import br.com.mulero.findnbytes.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.mulero.findnbytes.util.FileReaderUtils.getBytes;
import static br.com.mulero.findnbytes.util.FileReaderUtils.getContent;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;
    private final DocumentSpecification specification;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentSpecification documentSpecification) {
        this.repository = documentRepository;
        this.specification = documentSpecification;
    }

    @Override
    public void upload(MultipartFile file) {
        Document document = new Document();

        document.setName(file.getOriginalFilename());
        document.setArchive(getBytes(file));
        document.setContent(getContent(file));

        repository.save(document);
    }

    @Override
    public List<IdNameDTO> listAll() {
        return repository.findAll().stream()
                .map(IdNameDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentDTO> search(String word) {
        Specification<Document> where = Specification.where(null);

        if (StringUtils.hasLength(word)) {
            where = where.and(specification.contentLike(word));
        }

        return repository.findAll(where).stream()
                .map(document -> entityToDto(document, word))
                .collect(Collectors.toList());
    }

    private DocumentDTO entityToDto(Document document, String word) {
        String snippet = repository.getSnippetOfContent(word, document.getId());
        return new DocumentDTO(document.getName(), snippet);
    }

}
