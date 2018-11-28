package com.tfd.p2p.commons.beans;

public class ResultsBean {
    private String massge;
    private int code;
    private Object data;

    public ResultsBean() {
    }

    public String getMassge() {
        return massge;
    }

    public void setMassge(String massge) {
        this.massge = massge;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultsBean{" +
                "massge='" + massge + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
