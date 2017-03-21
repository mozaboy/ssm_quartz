package com.zxk175.ssm.dto;

/**
 * Created by zxk175 on 17/3/21.
 */
public class TreeNode {
    private long id;
    private String text;
    private String state;

    public TreeNode() {
        super();
    }

    public TreeNode(long id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
