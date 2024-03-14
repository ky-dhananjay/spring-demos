package com.example.urlshortner.beans;

import com.example.urlshortner.model.domain.CsvBean;
import com.example.urlshortner.model.domain.CsvTransfer;
import com.example.urlshortner.model.domain.Url;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class BeanExamples implements ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(BeanExamples.class);

    public List<CsvBean> beanBuilderExample(Path path, Class clazz) throws Exception {
        CsvTransfer csvTransfer = new CsvTransfer();

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
                .withType(clazz)
                .build();

            csvTransfer.setCsvList(cb.parse());
        }
        return csvTransfer.getCsvList();
    }

    public void writeCsvFromBean(Path path, CsvBean csvBean) throws Exception {
        //List<CsvBean> sampleData = Arrays.asList(csvBean);
        List<CsvBean> sampleData = Arrays.asList(csvBean);
        logger.info(csvBean.toString());
        try (Writer writer  = new FileWriter(path.toString())) {
            StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
                .withQuotechar('\'')
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
            sbc.write(sampleData);
        }
       // return Helpers.readFile(path);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        logger.info("started application runner...");
//        Path path = Paths.get(
//            ClassLoader.getSystemResource("csv/url.csv").toURI());
//        logger.info(String.valueOf(path));
//        writeCsvFromBean(path, new Url.Builder()
//            .id(12L)
//            .sourceUrl("aderfdver")
//            .shortenedUrl("ada")
//            .createdAt(Instant.now().toEpochMilli())
//            .build());
//        writeCsvFromBean(path, new Url.Builder()
//            .id(13L)
//            .sourceUrl("aderfdversdvsdvrdf")
//            .shortenedUrl("adav")
//            .createdAt(Instant.now().toEpochMilli())
//            .build());
//        logger.info("reading csv");
//        List<CsvBean> urls = beanBuilderExample(path, Url.class);
//        for (CsvBean c :
//            urls) {
//            logger.info(c.toString());
//        }
    }
}
