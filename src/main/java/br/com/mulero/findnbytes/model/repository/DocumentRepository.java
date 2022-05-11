package br.com.mulero.findnbytes.model.repository;

import br.com.mulero.findnbytes.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {

    int AMOUNT_DEFAULT = 50;

    @Query(value = "select getSnippetOfContent(?1, ?2, ?3) from DUAL", nativeQuery = true)
    String getSnippetOfContent(String word, Long id, int amount);

    default String getSnippetOfContent(String word, Long id) {
        return getSnippetOfContent(word, id, AMOUNT_DEFAULT);
    }
}
