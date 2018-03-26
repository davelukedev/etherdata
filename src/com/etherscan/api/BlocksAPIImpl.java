package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "blockapi")
public class BlocksAPIImpl implements BlocksAPI {

    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");

    /**
     * BlockNo获得Block和Uncle奖励
     * https://api.etherscan.io/api?module=block&action=getblockreward&blockno=2165403&apikey=YourApiKeyToken
     * @param blockNo
     * @return
     */
    @Override
    public String getBlockAndUncleRewardsByBlockNo(String blockNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "block");
        map.put("action", "getblockreward");
        map.put("blockno",blockNo);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
