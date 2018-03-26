package com.etherscan.service;

import com.etherscan.api.GethParityProxyAPIImpl;
import com.etherscan.pojo.*;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "gethparityproxyservice")
public class GethParityProxyService {
    @Resource(name="gethparityproxyapi")
    private GethParityProxyAPIImpl api;

    /**
     *
     * @return
     */
    public BlockNumber ethBlockNumber() {
        String responseStr = api.ethBlockNumber();
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
        if(jsObject != null){
            return new BlockNumber(jsObject);
        }
        return null;
    }

    public Block ethGetBlockByNumber(String tag) {
        if(tag == null || tag == "")return null;
        String responseStr = api.ethGetBlockByNumber(tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new Block(jsonObject);
        }
        return null;
    }

    public Block ethGetUncleByBlockNumberAndIndex(String tag, String index) {
        if(tag == null || tag == "" || index == null || index == "")return null;
        String responseStr = api.ethGetUncleByBlockNumberAndIndex(tag,index);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new Block(jsonObject);
        }
        return null;
    }

    public BlockTransationCount getBlockTransactionCountByNumber(String tag) {
        if(tag == null || tag == "") return null;
        String responseStr = api.getBlockTransactionCountByNumber(tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new BlockTransationCount(jsonObject);
        }
        return null;
    }

    public BlockTransation getTransactionByHash(String txHash) {
        if(txHash == null || txHash == "") return null;
        String responseStr = api.getTransactionByHash(txHash);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new BlockTransation(jsonObject);
        }
        return null;
    }

    public BlockTransation getTransactionByBlockNumberAndIndex(String tag, String index) {
        if(tag == null || tag == "" || index == null || index == "") return null;
        String responseStr = api.getTransactionByBlockNumberAndIndex(tag,index);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new BlockTransation(jsonObject);
        }
        return null;
    }

    public BlockTransationCount getTransactionCount(String address, String tag) {
        if(address == null || address == "" || tag == null || tag == "") return null;
        String responseStr = api.getTransactionCount(address,tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new BlockTransationCount(jsonObject);
        }
        return null;
    }

    public CallResponse call(String to, String data, String tag) {
        if(to == null || to == "" || tag == null || tag == "" || data == null || data =="") return null;
        String responseStr = api.call(to,data,tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new CallResponse(jsonObject);
        }
        return null;
    }

    public GetCodeResponse getCode(String address, String tag) {
        if(address == null || address == "" || tag == null || tag == "") return null;
        String responseStr = api.getCode(address,tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new GetCodeResponse(jsonObject);
        }
        return null;
    }

    public GetStorageResponse getStorageAt(String address, String position, String tag) {
        if(address == null || address == ""|| position == null || position == "" || tag == null || tag == "") return null;
        String responseStr = api.getStorageAt(address,position,tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new GetStorageResponse(jsonObject);
        }
        return null;
    }

    public GetPriceResponse gasPrice() {
       String responseStr = api.gasPrice();
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new GetPriceResponse(jsonObject);
        }
        return null;
    }

    public String estimateGas(String to, String value, String gasPrice, String gas) {
        return api.estimateGas(to,value,gasPrice,gas);
    }

}
