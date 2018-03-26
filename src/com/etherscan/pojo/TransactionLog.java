package com.etherscan.pojo;

import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {
    public TransactionLog(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("address") != null){this.setAddress(jsonObject.getString("address"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("data") != null){this.setData(jsonObject.getString("data"));}
            if(jsonObject.get("transactionHash") != null){this.setTransactionHash(jsonObject.getString("transactionHash"));}
            if(jsonObject.get("transactionIndex") != null){this.setTransactionIndex(jsonObject.getString("transactionIndex"));}
            if(jsonObject.get("blockHash") != null){this.setBlockHash(jsonObject.getString("blockHash"));}
            if(jsonObject.get("logIndex") != null){this.setLogIndex(jsonObject.getString("logIndex"));}
            if(jsonObject.get("removed") != null){this.setRemoved(jsonObject.getString("removed"));}
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
    private List<String> topics;
    private String data;
    private String blockNumber;
    private String transactionHash;
    private String transactionIndex;
    private String blockHash;
    private String logIndex;
    private String removed;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
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

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(String logIndex) {
        this.logIndex = logIndex;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
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
        sbf.append(" logIndex:").append(this.getLogIndex());
        sbf.append(" transactionHash:").append(this.getTransactionHash());
        sbf.append(" transactionIndex:").append(this.getTransactionIndex());
        sbf.append(" blockHash:").append(this.getBlockHash());
        sbf.append(" removed:").append(this.getRemoved());
        return sbf.toString();
    }
}
