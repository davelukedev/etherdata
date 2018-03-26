package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "transactionapi")
public class TransactionAPIImpl implements TransactionAPI {

    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");

    /**
     *  检查合同执行状态（如果在合同执行期间发生错误）
     *  注意：isError“：”0“=合格，isError”：“1”=合同执行期间出错
     *  https://api.etherscan.io/api?module=transaction&action=getstatus&txhash=0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    @Override
    public String checkContractExecutionStatus(String txHash) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "transaction");
        map.put("action", "getstatus");
        map.put("txhash",txHash);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * 检查交易收据状态（仅适用于后拜占庭叉交易）
     * 注意：状态：0 =失败，1 =通过。将返回前/后分叉的空/空值
     * https://api.etherscan.io/api?module=transaction&action=gettxreceiptstatus&txhash=0x513c1ba0bebf66436b5fed86ab668452b7805593c05073eb2d51d3a52f480a76&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    @Override
    public String checkTransactionReceiptStatus(String txHash) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "transaction");
        map.put("action", "gettxreceiptstatus");
        map.put("txhash",txHash);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
