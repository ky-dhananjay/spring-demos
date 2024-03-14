package com.example.urlshortner.repository;

import com.example.urlshortner.beans.BeanExamples;
import com.example.urlshortner.model.domain.CsvBean;
import com.example.urlshortner.model.domain.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class URLShortnerRepoCsvImpl implements URLShortnerRepo {
    @Autowired
    BeanExamples beanExamples;
    private static final String URL_CSV_SOURCE = "csv/url.csv";

//    public String writeCsvFromBean(CsvBean csvBean) throws Exception {
//        Path path = Paths.get(
//            ClassLoader.getSystemResource(URL_CSV_SOURCE).toURI());
//        return beanExamples.writeCsvFromBean(path,csvBean);
//    }
    @Override
    public void save(Url url) {
        try {
            Path path = Paths.get(
                ClassLoader.getSystemResource(URL_CSV_SOURCE).toURI());
            beanExamples.writeCsvFromBean(path, url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
