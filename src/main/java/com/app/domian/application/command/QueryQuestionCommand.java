package com.app.domian.application.command;

/**
 * @description:
 * @author: quliang
 * @create: 2022-11-07 18:53
 **/

public class QueryQuestionCommand {
    private Integer page;
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
