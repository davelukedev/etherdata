package com.etherscan.service;

import com.etherscan.api.TokenInfoAPIImpl;
import com.etherscan.pojo.GetTotalSupplyResponse;
import com.etherscan.pojo.TokenAccountBalance;
import com.etherscan.pojo.TotalSupplyContractAddress;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "tokeninfoservice")
public class TokenInfoService {
    @Resource(name="tokeninfoapi")
    private TokenInfoAPIImpl api;

    public TotalSupplyContractAddress TotalSupplyByContractAddress(String contractAddress) {
        if(contractAddress == null || contractAddress == "") return null;
        String responseStr = api.TotalSupplyByContractAddress(contractAddress);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new TotalSupplyContractAddress(jsonObject);
        }
        return null;
    }

    public TokenAccountBalance TokenAccountBalanceForTokenContractAddress(String contractAddress, String address, String tag) {
        if(contractAddress == null || contractAddress == "" || address == null || address == "" || tag == null || tag == "") return null;
        String responseStr = api.TokenAccountBalanceForTokenContractAddress(contractAddress,address,tag);
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new TokenAccountBalance(jsonObject);
        }
        return null;
    }
}
