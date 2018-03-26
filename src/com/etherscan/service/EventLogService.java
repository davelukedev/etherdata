package com.etherscan.service;

import com.etherscan.api.EventLogAPIImpl;
import com.etherscan.pojo.EventLogList;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "eventlogservice")
public class EventLogService {
    @Resource(name="eventlogapi")
    private EventLogAPIImpl api;

    /**
     * 从块号379224获取事件日志到'最新'块，其中日志地址= 0x33990122638b9132ca29c723bdf037f1a891a70c和主题[0] = 0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545
     * @param fromBlock
     * @param toBlock
     * @param address
     * @param topic0
     * @return
     */
    public EventLogList getEventLogsByBlocksAndAddressTopic0(String fromBlock, String toBlock, String address, String topic0) {
        if(fromBlock == null) return null;
        if(toBlock == null) toBlock = "latest";
        if(address == null) return null;
        if(topic0 == null) return null;
        String responsStr =  api.GetEventLogsByBlocksAndAddressTopic0(fromBlock,toBlock,address,topic0);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            return new EventLogList(jsObject);
        }
        return null;
    }

    /**
     * 获取事件日志从块号379224到块400000，其中日志地址= 0x33990122638b9132ca29c723bdf037f1a891a70c，主题[0] = 0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545'AND'主题[1] = 0x72657075746174696f6e00000000000000000000000000000000000000000000
     * @param fromBlock
     * @param toBlock
     * @param address
     * @param topic0
     * @param topic1
     * @return
     */
    public EventLogList getEventLogsByBlocksAndAddressTopics(String fromBlock, String toBlock, String address, String topic0,String topic1) {
        if(fromBlock == null) return null;
        if(toBlock == null) toBlock = "latest";
        if(address == null) return null;
        if(topic0 == null) return null;
        if(topic1 == null) return null;
        String responsStr =  api.GetEventLogsByBlocksAndAddressTopics(fromBlock,toBlock,address,topic0,topic1);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            return new EventLogList(jsObject);
        }
        return null;
    }
}
