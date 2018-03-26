package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "tokeninfoapi")
public class TokenInfoAPIImpl implements TokenInfoAPI{
    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");
    /**
     * Get ERC20-Token TotalSupply by ContractAddress
     * https://api.etherscan.io/api?module=stats&action=tokensupply&contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&apikey=YourApiKeyToken
     * @param contractAddress
     * @return
     */
    @Override
    public String TotalSupplyByContractAddress(String contractAddress) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "stats");
        map.put("action", "tokensupply");
        map.put("contractaddress",contractAddress);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * https://api.etherscan.io/api?module=account&action=tokenbalance&contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&address=0xe04f27eb70e025b78871a2ad7eabe85e61212761&tag=latest&apikey=YourApiKeyToken
     * @param contractAddress
     * @param address
     * @param tag
     * @return
     */
    @Override
    public String TokenAccountBalanceForTokenContractAddress(String contractAddress, String address, String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "stats");
        map.put("action", "tokensupply");
        map.put("contractaddress",contractAddress);
        map.put("address",address);
        if(tag == null || tag == ""){
            tag = "latest";
        }
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
