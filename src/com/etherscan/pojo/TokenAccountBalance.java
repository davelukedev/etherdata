package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class TokenAccountBalance extends BaseResponse{

    public TokenAccountBalance(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){this.setResult(jsonObject.getString("result"));}

        }else{return;}
    }
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage()).append(" result:").append(this.getResult());
        return sbf.toString();
    }
}
