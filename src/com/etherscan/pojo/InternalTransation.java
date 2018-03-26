package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class InternalTransation extends BaseResponse {
    private String blockNumber;
    private String timeStamp;
    private String hash;
    private String from;
    private String to;
    private String value;
    private String contractAddress;
    private String input;
    private String type;
    private String gas;
    private String gasUsed;
    private String traceId;
    private String isError;
    private String errCode;

    public InternalTransation(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("timeStamp") != null){this.setTimeStamp(jsonObject.getString("timeStamp"));}
            if(jsonObject.get("hash") != null){this.setHash(jsonObject.getString("hash"));}
            if(jsonObject.get("from") != null){this.setFrom(jsonObject.getString("from"));}
            if(jsonObject.get("to") != null){this.setTo(jsonObject.getString("to"));}
            if(jsonObject.get("value") != null){this.setValue(jsonObject.getString("value"));}
            if(jsonObject.get("contractAddress") != null){this.setContractAddress(jsonObject.getString("contractAddress"));}
            if(jsonObject.get("input") != null){this.setInput(jsonObject.getString("input"));}
            if(jsonObject.get("type") != null){this.setType(jsonObject.getString("type"));}
            if(jsonObject.get("gas") != null){this.setGas(jsonObject.getString("gas"));}
            if(jsonObject.get("gasUsed") != null){this.setGasUsed(jsonObject.getString("gasUsed"));}
            if(jsonObject.get("traceId") != null){this.setTraceId(jsonObject.getString("traceId"));}
            if(jsonObject.get("isError") != null){this.setIsError(jsonObject.getString("isError"));}
            if(jsonObject.get("errCode") != null){this.setErrCode(jsonObject.getString("errCode"));}
        }else{
            return;
        }
    }
    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("blockNumber:").append(this.getBlockNumber());
        sbf.append(" timeStamp:").append(this.getTimeStamp());
        sbf.append(" hash:").append(this.getHash());
        sbf.append(" from:").append(this.getFrom());
        sbf.append(" to:").append(this.getTo());
        sbf.append(" value:").append(this.getValue());
        sbf.append(" contractAddress:").append(this.getContractAddress());
        sbf.append(" input:").append(this.getInput());
        sbf.append(" type:").append(this.getType());
        sbf.append(" gas:").append(this.getGas());
        sbf.append(" gasUsed:").append(this.getGasUsed());
        sbf.append(" traceId:").append(this.getTraceId());
        sbf.append(" isError:").append(this.getIsError());
        sbf.append(" errCode:").append(this.getErrCode());
        return sbf.toString();
    }
}
