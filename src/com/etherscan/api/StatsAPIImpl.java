package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "statsapi")
public class StatsAPIImpl implements StatsAPI {

    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");
    /**
     * (Result returned in Wei, to get value in Ether divide resultAbove/1000000000000000000)
     * https://api.etherscan.io/api?module=stats&action=ethsupply&apikey=YourApiKeyToken
     * @return
     */
    @Override
    public String GetTotalSupplyOfEther() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "stats");
        map.put("action", "ethsupply");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken
     * @return
     */
    @Override
    public String GetETHERLastPrice() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "stats");
        map.put("action", "ethprice");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
