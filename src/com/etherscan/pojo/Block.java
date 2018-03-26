package com.etherscan.pojo;

import com.etherscan.util.JsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Block {

    public Block(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("jsonrpc") != null){this.setJsonrpc(jsonObject.getString("jsonrpc"));}
            if(jsonObject.get("id") != null){this.setId(jsonObject.getString("id"));}
            if(jsonObject.get("result") != null){
                JSONObject jsObjct = jsonObject.getJSONObject("result");
                if(jsObjct.get("difficulty") != null){this.setDifficulty(jsObjct.getString("difficulty"));}
                if(jsObjct.get("extraData") != null){this.setExtraData(jsObjct.getString("extraData"));}
                if(jsObjct.get("gasLimit") != null){this.setGasLimit(jsObjct.getString("gasLimit"));}
                if(jsObjct.get("gasUsed") != null){this.setGasUsed(jsObjct.getString("gasUsed"));}
                if(jsObjct.get("hash") != null){this.setHash(jsObjct.getString("hash"));}
                if(jsObjct.get("logsBloom") != null){this.setLogsBloom(jsObjct.getString("logsBloom"));}
                if(jsObjct.get("miner") != null){this.setMiner(jsObjct.getString("miner"));}
                if(jsObjct.get("mixHash") != null){this.setMixHash(jsObjct.getString("mixHash"));}
                if(jsObjct.get("nonce") != null){this.setNonce(jsObjct.getString("nonce"));}
                if(jsObjct.get("number") != null){this.setNumber(jsObjct.getString("number"));}
                if(jsObjct.get("parentHash") != null){this.setParentHash(jsObjct.getString("parentHash"));}
                if(jsObjct.get("receiptsRoot") != null){this.setReceiptsRoot(jsObjct.getString("receiptsRoot"));}
                if(jsObjct.get("sha3Uncles") != null){this.setSha3Uncles(jsObjct.getString("sha3Uncles"));}
                if(jsObjct.get("size") != null){this.setSize(jsObjct.getString("size"));}
                if(jsObjct.get("stateRoot") != null){this.setStateRoot(jsObjct.getString("stateRoot"));}
                if(jsObjct.get("timestamp") != null){this.setTimestamp(jsObjct.getString("timestamp"));}
                if(jsObjct.get("totalDifficulty") != null){this.setTotalDifficulty(jsObjct.getString("totalDifficulty"));}
                if(jsObjct.get("transactionsRoot") != null){this.setTransactionsRoot(jsObjct.getString("transactionsRoot"));}
                if(jsObjct.get("transactions") != null){
                    JSONArray objs = jsObjct.getJSONArray("transactions");
                    List<BlockTransation> blockTransations = new ArrayList<BlockTransation>();
                    BlockTransation blockTransation = null;
                    JSONObject resultObj = null;
                    for (int i = 0; i < objs.size(); i++) {
                        resultObj = objs.getJSONObject(i);
                        blockTransation = new BlockTransation(resultObj);
                        blockTransations.add(blockTransation);
                    }
                    this.setBlockTransationList(blockTransations);
                }
                if(jsObjct.get("uncles") != null)
                {
                    Object[] strings = (Object[]) JsonUtil.getObjectArrayFromJson(jsObjct.getString("uncles").toString());
                    List<String> uncles = new ArrayList<String>();
                    for(Object ss:strings){
                        uncles.add((String)ss);
                    }
                    this.setUncles(uncles);
                }
            }

        }else{ return;}
    }
    private String jsonrpc;
    private String id;
    private String difficulty;
    private String extraData;
    private String gasLimit;
    private String gasUsed;
    private String hash;
    private String logsBloom;
    private String miner;
    private String mixHash;
    private String nonce;
    private String number;
    private String parentHash;
    private String receiptsRoot;
    private String sha3Uncles;
    private String size;
    private String stateRoot;
    private String timestamp;
    private String totalDifficulty;
    private String transactionsRoot;
    private List<BlockTransation> blockTransationList;
    private List<String> uncles;

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public String getMixHash() {
        return mixHash;
    }

    public void setMixHash(String mixHash) {
        this.mixHash = mixHash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getReceiptsRoot() {
        return receiptsRoot;
    }

    public void setReceiptsRoot(String receiptsRoot) {
        this.receiptsRoot = receiptsRoot;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public void setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public void setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
    }

    public List<BlockTransation> getBlockTransationList() {
        return blockTransationList;
    }

    public void setBlockTransationList(List<BlockTransation> blockTransationList) {
        this.blockTransationList = blockTransationList;
    }

    public List<String> getUncles() {
        return uncles;
    }

    public void setUncles(List<String> uncles) {
        this.uncles = uncles;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("jsonrpc:").append(this.getJsonrpc());
        sbf.append(" id:").append(this.getId());
        sbf.append(" difficulty:").append(this.getDifficulty());
        sbf.append(" extraData:").append(this.getExtraData());
        sbf.append(" gasLimit:").append(this.getGasLimit());
        sbf.append(" gasUsed:").append(this.getGasUsed());
        sbf.append(" hash:").append(this.getHash());
        sbf.append(" logsBloom:").append(this.getLogsBloom());
        sbf.append(" miner:").append(this.getMiner());
        sbf.append(" mixHash:").append(this.getMixHash());
        sbf.append(" nonce:").append(this.getNonce());
        sbf.append(" number:").append(this.getNumber());
        sbf.append(" parentHash:").append(this.getParentHash());
        sbf.append(" receiptsRoot:").append(this.getReceiptsRoot());
        sbf.append(" sha3Uncles:").append(this.getSha3Uncles());
        sbf.append(" size:").append(this.getSize());
        sbf.append(" stateRoot:").append(this.getStateRoot());
        sbf.append(" timestamp:").append(this.getTimestamp());
        sbf.append(" totalDifficulty:").append(this.getTotalDifficulty());
        sbf.append(" transactionsRoot:").append(this.getTransactionsRoot());
        sbf.append("Transation:[");
        List<BlockTransation> blockTransationList = this.getBlockTransationList();
        if(blockTransationList != null && blockTransationList.size()>0)
        {
            for(BlockTransation blockTransation:blockTransationList){
                sbf.append(blockTransation.toString()).append(",");
            }
        }
        sbf.append("]");
        sbf.append(" uncles:[");
        List<String> uncles = this.getUncles();
        if(uncles != null && uncles.size()>0){
            for(String uncle:uncles){
                sbf.append(uncle).append(",");
            }
        }
        sbf.append("]");
        return sbf.toString();
    }
}
