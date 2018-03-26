package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component(value = "gethparityproxyapi")
public class GethParityProxyAPIImpl implements GethParityProxyAPI {
    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");

    /**
     * Returns the number of most recent block
     * https://api.etherscan.io/api?module=proxy&action=eth_blockNumber&apikey=YourApiKeyToken
     * @return
     */
    @Override
    public String ethBlockNumber() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_blockNumber");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * Returns information about a block by block number.
     * https://api.etherscan.io/api?module=proxy&action=eth_getBlockByNumber&tag=0x10d4f&boolean=true&apikey=YourApiKeyToken
     * @param tag
     * @return
     */
    @Override
    public String ethGetBlockByNumber(String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getBlockByNumber");
        map.put("tag", tag);
        map.put("boolean", "true");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns information about a uncle by block number.
     * https://api.etherscan.io/api?module=proxy&action=eth_getUncleByBlockNumberAndIndex&tag=0x210A9B&index=0x0&apikey=YourApiKeyToken
     * @param tag
     * @param index
     * @return
     */
    @Override
    public String ethGetUncleByBlockNumberAndIndex(String tag, String index) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getUncleByBlockNumberAndIndex");
        map.put("tag", tag);
        map.put("index", index);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * https://api.etherscan.io/api?module=proxy&action=eth_getBlockTransactionCountByNumber&tag=0x10FB78&apikey=YourApiKeyToken
     * Returns the number of transactions in a block from a block matching the given block number
     * @param tag
     * @return
     */
    @Override
    public String getBlockTransactionCountByNumber(String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getBlockTransactionCountByNumber");
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns the information about a transaction requested by transaction hash
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByHash&txhash=0x1e2910a262b1008d0616a0beb24c1a491d78771baa54a33e66065e03b1f46bc1&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    @Override
    public String getTransactionByHash(String txHash) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getTransactionByHash");
        map.put("txhash", txHash);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns information about a transaction by block number and transaction index position
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByBlockNumberAndIndex&tag=0x10d4f&index=0x0&apikey=YourApiKeyToken
     * @param tag
     * @param index
     * @return
     */
    @Override
    public String getTransactionByBlockNumberAndIndex(String tag, String index) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getTransactionByBlockNumberAndIndex");
        map.put("tag", tag);
        map.put("index", index);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns the number of transactions sent from an address
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionCount&address=0x2910543af39aba0cd09dbb2d50200b3e800a63d2&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param tag
     * @return
     */
    @Override
    public String getTransactionCount(String address, String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getTransactionCount");
        map.put("address", address);
        if(tag == null || tag == ""){
            tag = "latest";
        }
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Creates new message call transaction or a contract creation for signed transactions
     * https://api.etherscan.io/api?module=proxy&action=eth_sendRawTransaction&hex=0xf904808000831cfde080&apikey=YourApiKeyToken
     * @param hex
     * @return
     */
    @Override
    public String sendRawTransaction(String hex) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_sendRawTransaction");
        map.put("hex", hex);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns the receipt of a transaction by transaction hash
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionReceipt&txhash=0x1e2910a262b1008d0616a0beb24c1a491d78771baa54a33e66065e03b1f46bc1&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    @Override
    public String getTransactionReceipt(String txHash) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getTransactionReceipt");
        map.put("txhash", txHash);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Executes a new message call immediately without creating a transaction on the block chain
     * https://api.etherscan.io/api?module=proxy&action=eth_call&to=0xAEEF46DB4855E25702F8237E8f403FddcaF931C0&data=0x70a08231000000000000000000000000e16359506c028e51f16be38986ec5746251e9724&tag=latest&apikey=YourApiKeyToken
     * @param to
     * @param data
     * @param tag
     * @return
     */
    @Override
    public String call(String to, String data, String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_call");
        map.put("to", to);
        map.put("data", data);
        if(tag == null || tag == ""){
            tag = "latest";
        }
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns code at a given address
     * https://api.etherscan.io/api?module=proxy&action=eth_getCode&address=0xf75e354c5edc8efed9b59ee9f67a80845ade7d0c&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param tag
     * @return
     */
    @Override
    public String getCode(String address, String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getCode");
        map.put("address", address);
        if(tag == null || tag == ""){
            tag = "latest";
        }
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns the value from a storage position at a given address.
     * https://api.etherscan.io/api?module=proxy&action=eth_getStorageAt&address=0x6e03d9cce9d60f3e9f2597e13cd4c54c55330cfd&position=0x0&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param position
     * @param tag
     * @return
     */
    @Override
    public String getStorageAt(String address, String position, String tag) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_getStorageAt");
        map.put("address", address);
        map.put("position", position);
        if(tag == null || tag == ""){
            tag = "latest";
        }
        map.put("tag", tag);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Returns the current price per gas in wei.
     * https://api.etherscan.io/api?module=proxy&action=eth_gasPrice&apikey=YourApiKeyToken
     * @return
     */
    @Override
    public String gasPrice() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_gasPrice");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    /**
     * Makes a call or transaction, which won't be added to the blockchain and returns the used gas, which can be used for estimating the used gas
     * https://api.etherscan.io/api?module=proxy&action=eth_estimateGas&to=0xf0160428a8552ac9bb7e050d90eeade4ddd52843&value=0xff22&gasPrice=0x051da038cc&gas=0xffffff&apikey=YourApiKeyToken
     * @param to
     * @param value
     * @param gasPrice
     * @param gas
     * @return
     */
    @Override
    public String estimateGas(String to, String value, String gasPrice, String gas) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "proxy");
        map.put("action", "eth_estimateGas");
        map.put("to", to);
        map.put("value", value);
        map.put("gas", gas);
        map.put("gasPrice", gasPrice);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
}
