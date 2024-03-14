package com.example.urlshortner.model.domain;

import java.util.List;

public class CsvTransfer {
    private List<CsvBean> csvList;

    public List<CsvBean> getCsvList() {
        return csvList;
    }

    public void setCsvList(List<CsvBean> csvList) {
        this.csvList = csvList;
    }
}
