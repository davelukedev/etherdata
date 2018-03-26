package com.etherscan.pojo;

import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventLog extends BaseResponse {

    public EventLog(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("address") != null){this.setAddress(jsonObject.getString("address"));}
            if(jsonObject.get("data") != null){this.setData(jsonObject.getString("data"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("timeStamp") != null){this.setTimeStamp(jsonObject.getString("timeStamp"));}
            if(jsonObject.get("gasPrice") != null){this.setGasPrice(jsonObject.getString("gasPrice"));}
            if(jsonObject.get("gasUsed") != null){this.setGasUsed(jsonObject.getString("gasUsed"));}
            if(jsonObject.get("logIndex") != null){this.setLogIndex(jsonObject.getString("logIndex"));}
            if(jsonObject.get("transactionHash") != null){this.setTransactionHash(jsonObject.getString("transactionHash"));}
            if(jsonObject.get("transactionIndex") != null){this.setTransactionIndex(jsonObject.getString("transactionIndex"));}
            if(jsonObject.get("topics") != null){
                Object[] strings = (Object[]) JsonUtil.getObjectArrayFromJson(jsonObject.getString("topics").toString());
                List<String> topics = new ArrayList<String>();
                for(Object ss:strings){
                    topics.add((String)ss);
                }
                this.setTopics(topics);
            }
        }else {return;}
    }
    private String address;
    private String data;
    private String blockNumber;
    private String timeStamp;
    private String gasPrice;
    private String gasUsed;
    private String logIndex;
    private String transactionHash;
    private String transactionIndex;
    private List<String> topics;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(String logIndex) {
        this.logIndex = logIndex;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("address:").append(this.getAddress());
        List<String> topics = this.getTopics();
        sbf.append(" topics:[");
        for(int i = 0;i<topics.size();i++){
            sbf.append(topics.get(i)).append(",");
        }
        sbf.append("]");
        sbf.append(" data:").append(this.getData());
        sbf.append(" blockNumber:").append(this.getBlockNumber());
        sbf.append(" timeStamp:").append(this.getTimeStamp());
        sbf.append(" gasPrice:").append(this.getGasPrice());
        sbf.append(" gasUsed:").append(this.getGasUsed());
        sbf.append(" logIndex:").append(this.getLogIndex());
        sbf.append(" transactionHash:").append(this.getTransactionHash());
        sbf.append(" transactionIndex:").append(this.getTransactionIndex());
        return sbf.toString();
    }
}
