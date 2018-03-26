package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class NormalTransation extends BaseResponse {
    private String blockNumber;
    private String timeStamp;
    private String hash;
    private String nonce;
    private String blockHash;
    private String transactionIndex;
    private String from;
    private String to;
    private String value;
    private String gas;
    private String gasPrice;
    private String isError;
    private String txreceipt_status;
    private String input;
    private String contractAddress;
    private String cumulativeGasUsed;
    private String gasUsed;
    private String confirmations;

    public NormalTransation(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("timeStamp") != null){this.setTimeStamp(jsonObject.getString("timeStamp"));}
            if(jsonObject.get("hash") != null){this.setHash(jsonObject.getString("hash"));}
            if(jsonObject.get("nonce") != null){this.setNonce(jsonObject.getString("nonce"));}
            if(jsonObject.get("blockHash") != null){this.setBlockHash(jsonObject.getString("blockHash"));}
            if(jsonObject.get("transactionIndex") != null){this.setTransactionIndex(jsonObject.getString("transactionIndex"));}
            if(jsonObject.get("from") != null){this.setFrom(jsonObject.getString("from"));}
            if(jsonObject.get("to") != null){this.setTo(jsonObject.getString("to"));}
            if(jsonObject.get("value") != null){this.setValue(jsonObject.getString("value"));}
            if(jsonObject.get("gas") != null){this.setGas(jsonObject.getString("gas"));}
            if(jsonObject.get("gasPrice") != null){this.setGasPrice(jsonObject.getString("gasPrice"));}
            if(jsonObject.get("isError") != null){this.setIsError(jsonObject.getString("isError"));}
            if(jsonObject.get("txreceipt_status") != null){this.setTxreceipt_status(jsonObject.getString("txreceipt_status"));}
            if(jsonObject.get("input") != null){this.setInput(jsonObject.getString("input"));}
            if(jsonObject.get("contractAddress") != null){this.setContractAddress(jsonObject.getString("contractAddress"));}
            if(jsonObject.get("cumulativeGasUsed") != null){this.setCumulativeGasUsed(jsonObject.getString("cumulativeGasUsed"));}
            if(jsonObject.get("gasUsed") != null){this.setGasUsed(jsonObject.getString("gasUsed"));}
            if(jsonObject.get("confirmations") != null){this.setConfirmations(jsonObject.getString("confirmations"));}
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

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
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

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getTxreceipt_status() {
        return txreceipt_status;
    }

    public void setTxreceipt_status(String txreceipt_status) {
        this.txreceipt_status = txreceipt_status;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
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

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(String confirmations) {
        this.confirmations = confirmations;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("blockNumber:").append(this.getBlockNumber());
        sbf.append(" timeStamp:").append(this.getTimeStamp());
        sbf.append(" hash:").append(this.getHash());
        sbf.append(" nonce:").append(this.getNonce());
        sbf.append(" blockHash:").append(this.getBlockHash());
        sbf.append(" transactionIndex:").append(this.getTransactionIndex());
        sbf.append(" from:").append(this.getFrom());
        sbf.append(" to:").append(this.getTo());
        sbf.append(" value:").append(this.getValue());
        sbf.append(" gas:").append(this.getGas());
        sbf.append(" gasPrice:").append(this.getGasPrice());
        sbf.append(" isError:").append(this.getIsError());
        sbf.append(" txreceipt_status:").append(this.getTxreceipt_status());
        sbf.append(" input:").append(this.getInput());
        sbf.append(" contractAddress:").append(this.getContractAddress());
        sbf.append(" cumulativeGasUsed:").append(this.getCumulativeGasUsed());
        sbf.append(" gasUsed:").append(this.getGasUsed());
        sbf.append(" confirmations:").append(this.getConfirmations());
        return sbf.toString();
    }
}
