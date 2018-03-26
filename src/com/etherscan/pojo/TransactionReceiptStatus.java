package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class TransactionReceiptStatus extends BaseResponse {

    public TransactionReceiptStatus(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){
                JSONObject jsObj = jsonObject.getJSONObject("result");
                if(jsObj.get("status") != null){this.setStatus(jsObj.getString("status"));}
            }
        }else {return;}
    }
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus());
        sbf.append(" message:").append(this.getMessage());
        sbf.append(" status:").append(this.getStatus());
        return sbf.toString();
    }
}
