package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class Contract extends BaseResponse {

    public Contract(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){this.setAbi(jsonObject.getString("result"));}
        }else {return;}
    }
    private String abi;

    public String getAbi() {
        return abi;
    }

    public void setAbi(String abi) {
        this.abi = abi;
    }

    @Override
    public String toString() {
       StringBuffer sbf = new StringBuffer(" status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
       sbf.append(" ABI:").append(this.getAbi());
       return  sbf.toString();
    }
}
