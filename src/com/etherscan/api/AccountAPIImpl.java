package com.etherscan.api;

import com.etherscan.util.HttpClientUtils;
import com.etherscan.util.PropertyUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "accountapi")
public class AccountAPIImpl implements AccountAPI {
    private String url = PropertyUtil.getProperty("etherscan.network");
    private String apikey = PropertyUtil.getProperty("etherscan.apikey");

    /**
     * 获取单个地址的余额
     * https://api.etherscan.io/api?module=account&action=balance&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    @Override
    public String getEtherBalanceSingleAddress(String address) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "balance");
        map.put("address",address);
        map.put("tag","latest");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 获取多个地址的余额，最多只能20个
     * https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    @Override
    public String getEtherBalanceMultipleAddress(List<String> address) {
        StringBuffer sbf = new StringBuffer();
        for(String addres : address){
            sbf.append(addres).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "balancemulti");
        map.put("address",sbf.toString().substring(0,sbf.toString().length()-1));
        map.put("tag","latest");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 根据地址获取交易数据
     * http://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&sort=asc&apikey=YourApiKeyToken
     * https://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&apikey=YourApiKeyToken
     * 分页
     * To get paginated results use page=<page number> and offset=<max records to return>
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    @Override
    public String getNormalTransactionByAddress(String address, String startblock, String endblock, String sort) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address",address);
        map.put("startblock",startblock);
        map.put("endblock",endblock);
        map.put("sort",sort);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     *  https://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&apikey=YourApiKeyToken
     * 分页
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @param page
     * @param offset
     * @return
     */
    @Override
    public String getNormalTransactionByAddressPage(String address, String startblock, String endblock, String sort, String page, String offset) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address",address);
        map.put("startblock",startblock);
        map.put("endblock",endblock);
        map.put("page",page);
        map.put("offset",offset);
        map.put("sort",sort);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 根据地址查询Internal交易数据
     * http://api.etherscan.io/api?module=account&action=txlistinternal&address=0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3&startblock=0&endblock=2702578&sort=asc&apikey=YourApiKeyToken
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    @Override
    public String getInternalTransationsByAddress(String address, String startblock, String endblock, String sort) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "txlistinternal");
        map.put("address",address);
        map.put("startblock",startblock);
        map.put("endblock",endblock);
        map.put("sort",sort);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 分页查询Internal交易数据
     * https://api.etherscan.io/api?module=account&action=txlistinternal&address=0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3&startblock=0&endblock=2702578&page=1&offset=10&sort=asc&apikey=YourApiKeyToken
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @param page
     * @param offset
     * @return
     */
    @Override
    public String getInternalTransationsByAddressPage(String address, String startblock, String endblock, String sort, String page, String offset) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "txlistinternal");
        map.put("address",address);
        map.put("startblock",startblock);
        map.put("endblock",endblock);
        map.put("page",page);
        map.put("offset",offset);
        map.put("sort",sort);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * https://api.etherscan.io/api?module=account&action=txlistinternal&txhash=0x40eb908387324f2b575b4879cd9d7188f69c8fc9d87c901b9e2daaea4b442170&apikey=YourApiKeyToken
     * @param hash
     * @return
     */
    @Override
    public String getTransationsByHash(String hash) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "txlistinternal");
        map.put("txhash",hash);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 获取按地址开采的块列表
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    @Override
    public String getListOfBlocksMinedByAddress(String address) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "getminedblocks");
        map.put("address",address);
        map.put("blocktype","blocks");
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }
    /**
     * 分页获取按地址开采的块列表
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&page=1&offset=10&apikey=YourApiKeyToken
     * @param address
     * @param page
     * @param offset
     * @return
     */
    @Override
    public String getListOfBlocksMinedByAddressPage(String address, String page, String offset) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("module", "account");
        map.put("action", "getminedblocks");
        map.put("address",address);
        map.put("blocktype","blocks");
        map.put("page",page);
        map.put("offset",offset);
        map.put("apikey",apikey);
        String responseStr = HttpClientUtils.doRequest(map,url , "get");
        return responseStr;
    }

    public static void main(String[] args){
        AccountAPIImpl impl = new AccountAPIImpl();
        impl.getEtherBalanceSingleAddress("0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae");
        List<String> address = new ArrayList<String>();
        address.add("0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a");
        address.add("0x63a9975ba31b0b9626b34300f7f627147df1f526");
        address.add("0x198ef1ec325a96cc354c7266a038be8b5c558f67");
        impl.getEtherBalanceMultipleAddress(address);

        impl.getNormalTransactionByAddress("0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a","0","99999999","asc");
        impl.getNormalTransactionByAddressPage("0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a","0","99999999","asc","1","10");

    }
}
