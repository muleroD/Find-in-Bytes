create or replace function getSnippetOfContent(word in varchar2, idDocument in varchar2, amount in number) return varchar2 is
    snippet varchar2(200);
begin
    select regexp_replace(DBMS_LOB.SUBSTR(UPPER(CONTENT), amount, DBMS_LOB.INSTR(UPPER(CONTENT), UPPER(word))),
                          '[[:space:]]', ' ')
    into snippet
    from DOCUMENT
    where ID = idDocument;

    return snippet;
end;