package com.etherscan.service;

import com.etherscan.api.StatsAPIImpl;
import com.etherscan.pojo.EtherLastPrice;
import com.etherscan.pojo.GetTotalSupplyResponse;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "statusservice")
public class StatusService {
    @Resource(name="statsapi")
    private StatsAPIImpl api;

    public GetTotalSupplyResponse getTotalSupplyOfEther() {
        String responseStr = api.GetTotalSupplyOfEther();
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new GetTotalSupplyResponse(jsonObject);
        }
        return null;
    }

    public EtherLastPrice getETHERLastPrice() {
        String responseStr = api.GetETHERLastPrice();
        if(responseStr == null || responseStr ==""){
            return null;
        }
        JSONObject jsonObject = JsonUtil.getJsonObject(responseStr);
        if(jsonObject != null){
            return new EtherLastPrice(jsonObject);
        }
        return null;
    }
}
