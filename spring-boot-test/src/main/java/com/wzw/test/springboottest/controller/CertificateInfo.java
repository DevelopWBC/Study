package com.wzw.test.springboottest.controller;

/**
 * 提出来的证件信息
 * @author Wangzhiwen
 */
public class CertificateInfo<K,V> {
    /**  */
    private K text;

    /**  */
    private V source;

    public CertificateInfo() {
    }

    public K getText() {
        return text;
    }

    public void setText(K text) {
        this.text = text;
    }

    public V getSource() {
        return source;
    }

    public void setSource(V source) {
        this.source = source;
    }
}
