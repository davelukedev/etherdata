package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class BlockTransation {
    public BlockTransation(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("blockHash") != null){this.setBlockHash(jsonObject.getString("blockHash"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("from") != null){this.setFrom(jsonObject.getString("from"));}
            if(jsonObject.get("gas") != null){this.setGas(jsonObject.getString("gas"));}
            if(jsonObject.get("gasPrice") != null){this.setGasPrice(jsonObject.getString("gasPrice"));}
            if(jsonObject.get("hash") != null){this.setHash(jsonObject.getString("hash"));}
            if(jsonObject.get("input") != null){this.setInput(jsonObject.getString("input"));}
            if(jsonObject.get("nonce") != null){this.setNonce(jsonObject.getString("nonce"));}
            if(jsonObject.get("to") != null){this.setTo(jsonObject.getString("to"));}
            if(jsonObject.get("transactionIndex") != null){this.setTransactionIndex(jsonObject.getString("transactionIndex"));}
            if(jsonObject.get("value") != null){this.setValue(jsonObject.getString("value"));}
            if(jsonObject.get("v") != null){this.setV(jsonObject.getString("v"));}
            if(jsonObject.get("r") != null){this.setR(jsonObject.getString("r"));}
            if(jsonObject.get("s") != null){this.setS(jsonObject.getString("s"));}
        }else{ return;}
    }
    private String blockHash;
    private String blockNumber;
    private String from;
    private String gas;
    private String gasPrice;
    private String hash;
    private String input;
    private String nonce;
    private String to;
    private String transactionIndex;
    private String value;
    private String v;
    private String r;
    private String s;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("blockHash:").append(this.getBlockHash());
        sbf.append(" blockNumber:").append(this.getBlockNumber());
        sbf.append(" from:").append(this.getFrom());
        sbf.append(" gas:").append(this.getGas());
        sbf.append(" gasPrice:").append(this.getGasPrice());
        sbf.append(" hash:").append(this.getHash());
        sbf.append(" input:").append(this.getInput());
        sbf.append(" nonce:").append(this.getNonce());
        sbf.append(" to:").append(this.getTo());
        sbf.append(" transactionIndex:").append(this.getTransactionIndex());
        sbf.append(" value:").append(this.getValue());
        sbf.append(" v:").append(this.getV());
        sbf.append(" r:").append(this.getR());
        sbf.append(" s:").append(this.getS());
        return sbf.toString();
    }
}
