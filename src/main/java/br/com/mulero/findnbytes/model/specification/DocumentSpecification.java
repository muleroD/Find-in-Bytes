package br.com.mulero.findnbytes.model.specification;

import br.com.mulero.findnbytes.model.Document;
import br.com.mulero.findnbytes.model.Document_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class DocumentSpecification {

    public Specification<Document> contentLike(String word) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.upper(root.get(Document_.content)),
                String.format("%%%s%%", word.toUpperCase())
        );
    }
}
