package ru.cbr.dekart.ma1gus.services;
import lombok.extern.slf4j.Slf4j;
import org.apache.any23.encoding.TikaEncodingDetector;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Сервис обработки xml
 */
@Service
@Slf4j
public class XMLService {

    /**
     * Метод проверки расширения
     *
     * @param is поток данных
     */
    public boolean isXml(InputStream is) throws IOException {
        Tika tika = new Tika();
        return tika.detect(is).equalsIgnoreCase("application/xml");
    }

    /**
     * Метод проверки расширения
     *
     * @param fileName название файла
     */
    public boolean isXml(String fileName) {
        //return FilenameUtils.getExtension(fileName).equalsIgnoreCase("xml");
        return true;
    }

    /**
     * Метод получения Reader объекта в зависимости от кодировки
     *
     * @param is поток данных
     * @param encoding кодировка
     * @return Reader
     */
    public Reader getFileReader(InputStream is, String encoding) throws IOException {
        if (encoding.equalsIgnoreCase("UTF-8")) {
            BOMInputStream bomInputStream = new BOMInputStream(is);
            if (bomInputStream.hasBOM()) {
                return new InputStreamReader(bomInputStream, bomInputStream.getBOMCharsetName());
            } else return new InputStreamReader(bomInputStream, StandardCharsets.UTF_8);
        } else return new InputStreamReader(is, Charset.forName("windows-1251"));
    }

    /**
     * Метод получения кодировки
     *
     * @param is поток данных
     * @return кодировка
     */
    public String getEncoding(InputStream is) throws IOException {
        TikaEncodingDetector tikaEncodingDetector = new TikaEncodingDetector();
        return tikaEncodingDetector.guessEncoding(is);
    }
}
