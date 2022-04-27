package br.com.mulero.findnbytes.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.apache.commons.io.FilenameUtils.getExtension;

@Slf4j
public class FileReaderUtils {

    FileReaderUtils() {
    }

    public static byte[] getBytes(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Erro ler bytes do arquivo: " + ioException.getMessage());
        }
    }

    public static String getContent(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String ext = getExtension(file.getOriginalFilename());

            switch (Objects.requireNonNull(ext)) {
                case "txt":
                    return getContentFromSimplesFile(inputStream);

                case "doc":
                    return getContentFromDoc(inputStream);

                case "docx":
                    return getContentFromDocx(inputStream);

                default:
                    throw new IllegalArgumentException("Extensão inválida: " + ext);
            }
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
            throw new IllegalArgumentException("Erro ao ler conteúdo do arquivo: " + ioException.getMessage());
        }
    }

    private static String getContentFromSimplesFile(InputStream inputStream) throws IOException {
        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        IOUtils.copy(inputStream, writer, encoding);
        return writer.toString();
    }

    private static String getContentFromDoc(InputStream inputStream) throws IOException {
        WordExtractor extractor = new WordExtractor(new HWPFDocument(inputStream));
        String content = extractor.getText();
        extractor.close();
        inputStream.close();
        return content;

    }

    private static String getContentFromDocx(InputStream inputStream) throws IOException {
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(inputStream));
        String content = extractor.getText();
        extractor.close();
        inputStream.close();
        return content;
    }
}
