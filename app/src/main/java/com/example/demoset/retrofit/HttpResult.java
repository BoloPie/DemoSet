package com.example.demoset.retrofit;

/**
 * 有些Http服务返回一个固定格式的数据的问题
 */

public class HttpResult<T> {

    /*有些Http服务返回一个固定格式的数据的问题
    * {
 "resultCode": 0,
 "resultMessage": "成功",
 "data": {}
}*/
    private int resultCode;
    private String resultMessage;

    private T data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
