package com.zxk175.ssm.dto;

import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
public class NodeVO {
    private Integer nodeId;

    private String text;

    private Integer parentId;

    private List<NodeVO> children;

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<NodeVO> getChildren() {
        return children;
    }

    public void setChildren(List<NodeVO> children) {
        this.children = children;
    }
}
