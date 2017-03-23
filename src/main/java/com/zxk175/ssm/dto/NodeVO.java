package com.zxk175.ssm.dto;

import java.util.List;

/**
 * Created by zxk175 on 17/3/21.
 */
public class NodeVO {
    private Integer nodeId;

    private String text;

    private String href;

    private String icon;

    private String[] tags;

    private Integer parentId;

    private List<NodeVO> nodes;

    private boolean isLeaf = false;

    // 默认不能被选中，实现只有叶子节点才能被选中
    private boolean selectable = false;

    private State state = new State();

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<NodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeVO> nodes) {
        this.nodes = nodes;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
