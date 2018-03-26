package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "eventlogapi")
public class EventLogAPIImpl implements EventLogAPI {

    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");

    /**
     * 从块号379224获取事件日志到'最新'块，其中日志地址= 0x33990122638b9132ca29c723bdf037f1a891a70c和主题[0] = 0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545
     * https://api.etherscan.io/api?module=logs&action=getLogs＆fromBlock
     = 379224
     ＆toBlock = latest
     ＆address = 0x33990122638b9132ca29c723bdf037f1a891a70c
     ＆topic0 = 0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545
     ＆apikey = YourApiKeyToken
     * @return
     */
    @Override
    public String GetEventLogsByBlocksAndAddressTopic0(String fromBlock, String toBlock, String address, String topic0) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "logs");
        map.put("action", "getLogs");
        map.put("fromBlock", fromBlock);
        if(toBlock == null || toBlock == "" ){
            toBlock = "latest";
        }
        map.put("toBlock", toBlock);
        map.put("address",address);
        map.put("topic0",topic0);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * 获取事件日志从块号379224到块400000，其中日志地址= 0x33990122638b9132ca29c723bdf037f1a891a70c，主题[0] = 0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545'AND'主题[1] = 0x72657075746174696f6e00000000000000000000000000000000000000000000
     https://api.etherscan.io/api?module=logs&action=getLogs
     &fromBlock=379224
     &toBlock=400000
     &address=0x33990122638b9132ca29c723bdf037f1a891a70c
     &topic0=0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545
     &topic0_1_opr=and
     &topic1=0x72657075746174696f6e00000000000000000000000000000000000000000000
     &apikey=YourApiKeyToken
     * @return
     */
    @Override
    public String GetEventLogsByBlocksAndAddressTopics(String fromBlock, String toBlock, String address, String topic0, String topic1) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "logs");
        map.put("action", "getLogs");
        map.put("fromBlock", fromBlock);
        if(toBlock == null || toBlock == "" ){
            toBlock = "latest";
        }
        map.put("toBlock", toBlock);
        map.put("address",address);
        map.put("topic0",topic0);
        map.put("topic0_1_opr","and");
        map.put("topic1",topic1);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
