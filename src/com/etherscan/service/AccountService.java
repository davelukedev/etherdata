package com.etherscan.service;

import com.etherscan.api.AccountAPIImpl;
import com.etherscan.pojo.*;
import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "accountservice")
public class AccountService {
    @Resource(name="accountapi")
    private AccountAPIImpl api;

    /**
     * 根据地址返回余额信息
     * @param address
     * @return
     */
    public AccountBalance getEtherBalanceSingleAddress(String address) {
        if(address == null || address == ""){
            return null;
        }
        String responsStr =  api.getEtherBalanceSingleAddress(address);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            AccountBalance balance = new AccountBalance(jsObject);
            balance.setAccount(address);
            return balance;
        }
        return null;
    }

    /**
     * 根据地址返回余额信息
     * @param address
     * @return
     */
    public AccountListBalance getEtherBalanceMultipleAddress(List<String> address) {
        if(address == null || address.size()<= 0){
            return null;
        }
        String responsStr =  api.getEtherBalanceMultipleAddress(address);
        if(responsStr == null || responsStr ==""){
            return null;
        }
        JSONObject jsObject = JsonUtil.getJsonObject(responsStr);
        if(jsObject != null){
            AccountListBalance balance = new AccountListBalance(jsObject);
            return balance;
        }
        return null;
    }

    /**
     * 根据地址获取交易数据
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    public NormalTransationList getNormalTransactionByAddress(String address, String startblock, String endblock, String sort){
        if(address == null){
            return null;
        }
        if(startblock == null){
            startblock = "0";
        }
        if(endblock == null){
            endblock = "99999999";
        }
        if(sort == null){
            sort = "asc";
        }
        String responseStr = api.getNormalTransactionByAddress(address,startblock,endblock,sort);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                NormalTransationList normalTransationList = new NormalTransationList(jsObject);
                return normalTransationList;
            }
        }
        return null;
    }


    /**
     * 分页
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @param page
     * @param offset
     * @return
     */
    public NormalTransationList getNormalTransactionByAddressPage(String address, String startblock, String endblock, String sort, String page, String offset) {
        if(address == null){
            return null;
        }
        if(startblock == null){
            startblock = "0";
        }
        if(endblock == null){
            endblock = "99999999";
        }
        if(sort == null){
            sort = "asc";
        }
        if(page == null){
            page = "1";
        }
        if(offset == null){
            offset = "10";
        }
        String responseStr = api.getNormalTransactionByAddressPage(address,startblock,endblock,sort,page,offset);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                NormalTransationList normalTransationList = new NormalTransationList(jsObject);
                return normalTransationList;
            }
        }
        return null;
    }

    /**
     * 根据地址查询Internal交易数据
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    public InternalTransationList getInternalTransationsByAddress(String address, String startblock, String endblock, String sort) {
        if(address == null){
            return null;
        }
        if(startblock == null){
            startblock = "0";
        }
        if(endblock == null){
            endblock = "99999999";
        }
        if(sort == null){
            sort = "asc";
        }
        String responseStr = api.getInternalTransationsByAddress(address,startblock,endblock,sort);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                InternalTransationList internalTransationList = new InternalTransationList(jsObject);
                return internalTransationList;
            }
        }
        return null;
    }
    /**
     * 根据地址查询Internal交易数据,分页
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    public InternalTransationList getInternalTransationsByAddressPage(String address, String startblock, String endblock, String sort,String page,String offset) {
        if(address == null){
            return null;
        }
        if(startblock == null){
            startblock = "0";
        }
        if(endblock == null){
            endblock = "99999999";
        }
        if(sort == null){
            sort = "asc";
        }
        if(page == null){
            page = "1";
        }
        if(offset == null){
            offset = "10";
        }
        String responseStr = api.getInternalTransationsByAddressPage(address,startblock,endblock,sort,page,offset);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                InternalTransationList internalTransationList = new InternalTransationList(jsObject);
                return internalTransationList;
            }
        }
        return null;
    }

    /**
     *
     * @param hash
     * @return
     */
    public InternalTransationList getTransationsByHash(String hash) {
        if(hash == null){
            return null;
        }
        String responseStr = api.getTransationsByHash(hash);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                InternalTransationList internalTransationList = new InternalTransationList(jsObject);
                return internalTransationList;
            }
        }
        return null;
    }

    /**
     * 获取按地址开采的块列表
     * @param address
     * @return
     */
    public BlockMinedList getListOfBlocksMinedByAddress(String address) {
        if(address == null) return null;
        String responseStr = api.getListOfBlocksMinedByAddress(address);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                BlockMinedList blockMinedList = new BlockMinedList(jsObject);
                return blockMinedList;
            }
        }
        return null;
    }

    /**
     * 分页获取按地址开采的块列表
     * @param address
     * @return
     */
    public BlockMinedList getListOfBlocksMinedByAddressPage(String address, String page, String offset) {
        if(address == null) return null;
        if(page == null) page = "1";
        if(offset == null) offset = "10";

        String responseStr = api.getListOfBlocksMinedByAddressPage(address,page,offset);
        if(responseStr != null){
            JSONObject jsObject = JsonUtil.getJsonObject(responseStr);
            if(jsObject != null){
                BlockMinedList blockMinedList = new BlockMinedList(jsObject);
                return blockMinedList;
            }
        }
        return null;
    }

}
