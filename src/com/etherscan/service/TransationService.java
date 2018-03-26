package com.etherscan.service;

import com.etherscan.api.TransactionAPIImpl;
import com.etherscan.pojo.ContractExecutionStatus;
import com.etherscan.pojo.TokenAccountBalance;
import com.etherscan.pojo.TransactionReceiptStatus;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "trancationservice")
public class TransationService {
    @Resource(name = "transactionapi")
    private TransactionAPIImpl api;

    public ContractExecutionStatus checkContractExecutionStatus(String txHash) {
        if(txHash == null || txHash == "")return null;
        String responseStr = api.checkContractExecutionStatus(txHash);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new ContractExecutionStatus(jsonObject);
        }
        return null;
    }

    public TransactionReceiptStatus checkTransactionReceiptStatus(String txHash) {
        if(txHash == null || txHash == "")return null;
        String responseStr = api.checkTransactionReceiptStatus(txHash);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new TransactionReceiptStatus(jsonObject);
        }
        return null;
    }

}
