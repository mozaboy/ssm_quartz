package com.zxk175.ssm.dto;

import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
public class NodeVO {
    private Integer id;
    private String text;
    private String link = "#";
    private List<NodeVO> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<NodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeVO> nodes) {
        this.nodes = nodes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
