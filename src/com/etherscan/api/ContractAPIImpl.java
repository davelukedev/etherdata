package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "contractapi")
public class ContractAPIImpl implements ContractAPI {
    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");
    /**
     *获取验证合同源代码的合同ABI
     * https://api.etherscan.io/api?module=contract&action=getabi&address=0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    @Override
    public String GetContractABI(String address) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "contract");
        map.put("action", "getabi");
        map.put("address",address);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
