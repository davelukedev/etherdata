package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TransactionReceipt {
    public TransactionReceipt(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("jsonrpc") != null){this.setJsonrpc(jsonObject.getString("jsonrpc"));}
            if(jsonObject.get("id") != null){this.setId(jsonObject.getString("id"));}
            if(jsonObject.get("result") != null){
                JSONObject resultJson = jsonObject.getJSONObject("result");
                if(resultJson.get("blockHash") != null){this.setBlockHash(resultJson.getString("blockHash"));}
                if(resultJson.get("blockNumber") != null){this.setBlockNumber(resultJson.getString("blockNumber"));}
                if(resultJson.get("contractAddress") != null){this.setContractAddress(resultJson.getString("contractAddress"));}
                if(resultJson.get("cumulativeGasUsed") != null){this.setCumulativeGasUsed(resultJson.getString("cumulativeGasUsed"));}
                if(resultJson.get("from") != null){this.setFrom(resultJson.getString("from"));}
                if(resultJson.get("gasUsed") != null){this.setGasUsed(resultJson.getString("gasUsed"));}
                if(resultJson.get("logsBloom") != null){this.setLogsBloom(resultJson.getString("logsBloom"));}
                if(resultJson.get("root") != null){this.setRoot(resultJson.getString("root"));}
                if(resultJson.get("to") != null){this.setTo(resultJson.getString("to"));}
                if(resultJson.get("transactionHash") != null){this.setTransactionHash(resultJson.getString("transactionHash"));}
                if(resultJson.get("transactionIndex") != null){this.setTransactionIndex(resultJson.getString("transactionIndex"));}
                if(resultJson.get("logs") != null){
                    List<TransactionLog> transactionLogList = new ArrayList<TransactionLog>();
                    TransactionLog transactionLog = null;
                    JSONObject resultObj = null;
                    JSONArray logs = resultJson.getJSONArray("logs");
                    if(logs != null && logs.size() > 0){
                        for (int i = 0;i<logs.size();i++){
                            resultObj = logs.getJSONObject(i);
                            transactionLog = new TransactionLog(resultObj);
                            transactionLogList.add(transactionLog);
                        }
                        this.setTransactionLogList(transactionLogList);
                    }
                }
            }
        }else {return;}
    }
    private String jsonrpc;
    private String id;
    private String blockHash;
    private String blockNumber;
    private String contractAddress;
    private String cumulativeGasUsed;
    private String from;
    private String gasUsed;
    private String logsBloom;
    private String root;
    private String to;
    private String transactionHash;
    private String transactionIndex;
    private List<TransactionLog> transactionLogList;

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

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    public void setCumulativeGasUsed(String cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public List<TransactionLog> getTransactionLogList() {
        return transactionLogList;
    }

    public void setTransactionLogList(List<TransactionLog> transactionLogList) {
        this.transactionLogList = transactionLogList;
    }
}
