package br.com.mulero.findnbytes.model.repository;

import br.com.mulero.findnbytes.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {

    @Query(value = "select getSnippetOfContent(?1, ?2, ?3) from DUAL", nativeQuery = true)
    String getSnippetOfContent(String word, Long id, Long amount);
}
