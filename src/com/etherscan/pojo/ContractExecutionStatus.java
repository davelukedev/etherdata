package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class ContractExecutionStatus extends BaseResponse {

    public ContractExecutionStatus(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){
                JSONObject jsObj = jsonObject.getJSONObject("result");
                if(jsObj.get("isError") != null){this.setIsError(jsObj.getString("isError"));}
                if(jsObj.get("errDescription") != null){this.setErrDescription(jsObj.getString("errDescription"));}
            }
        }else {return;}
    }
    private String isError;
    private String errDescription;

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getErrDescription() {
        return errDescription;
    }

    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus());
        sbf.append(" message:").append(this.getMessage());
        sbf.append(" isError:").append(this.getIsError());
        sbf.append(" errDescription:").append(this.getErrDescription());
        return sbf.toString();
    }
}
