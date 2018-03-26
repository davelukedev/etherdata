package com.etherscan.service;

import com.etherscan.api.BlocksAPIImpl;
import com.etherscan.pojo.Blocks;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "blocksservice")
public class BlocksService {
    @Resource(name="blockapi")
    private BlocksAPIImpl api;

    /**
     * BlockNo获得Block和Uncle奖励
     * @param blockNo
     * @return
     */
    public Blocks getBlockAndUncleRewardsByBlockNo(String blockNo) {
        if(blockNo == null) return null;
        String responsStr =  api.getBlockAndUncleRewardsByBlockNo(blockNo);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            return new Blocks(jsObject);
        }
        return null;
    }


}
