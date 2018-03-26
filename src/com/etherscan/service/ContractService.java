package com.etherscan.service;

import com.etherscan.api.ContractAPIImpl;
import com.etherscan.pojo.Contract;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "contractservice")
public class ContractService {
    @Resource(name="contractapi")
    private ContractAPIImpl api;

    public Contract getContractABI(String address) {
        if(address == null) return null;
        String responsStr =  api.GetContractABI(address);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            return new Contract(jsObject);
        }
        return null;
    }
}
