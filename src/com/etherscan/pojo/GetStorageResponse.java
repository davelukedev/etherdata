package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class GetStorageResponse {

    public GetStorageResponse(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("jsonrpc") != null){this.setJsonrpc(jsonObject.getString("jsonrpc"));}
            if(jsonObject.get("id") != null){this.setId(jsonObject.getString("id"));}
            if(jsonObject.get("result") != null){this.setResult(jsonObject.getString("result"));}
        }else {return;}
    }
    private String jsonrpc;
    private String id;
    private String result;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("jsonrpc:").append(this.getJsonrpc()).append(" id:").append(this.getId()).append(" result:").append(this.getResult());
        return sbf.toString();
    }
}
