package com.haizuka.api.output;

import java.util.ArrayList;
import java.util.List;

import haizuka.dto.HaiZukaDTO;

public class HaizukaOutput {
    private int page;
    private int totalPage;
    private List<HaiZukaDTO> listResult = new ArrayList<HaiZukaDTO>();

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<HaiZukaDTO> getListResult() {
        return this.listResult;
    }

    public void setListResult(List<HaiZukaDTO> listResult) {
        this.listResult = listResult;
    }

}
