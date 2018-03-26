package com.etherscan.api;

import java.util.List;

/**
 * 在etherscan中获取帐号相关的API
 */
public interface AccountAPI {
    /**
     * 获取单个地址的余额
     * https://api.etherscan.io/api?module=account&action=balance&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    public String getEtherBalanceSingleAddress(String address);
    /**
     * 获取多个地址的余额，最多只能20个
     * https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    public String getEtherBalanceMultipleAddress(List<String> address);

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
    public String getNormalTransactionByAddress(String address,String startblock,String endblock,String sort);

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
    public String getNormalTransactionByAddressPage(String address,String startblock,String endblock,String sort,String page,String offset);

    /**
     * 根据地址查询Internal交易数据
     * http://api.etherscan.io/api?module=account&action=txlistinternal&address=0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3&startblock=0&endblock=2702578&sort=asc&apikey=YourApiKeyToken
     * @param address
     * @param startblock
     * @param endblock
     * @param sort
     * @return
     */
    public String getInternalTransationsByAddress(String address,String startblock,String endblock,String sort);

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
    public String getInternalTransationsByAddressPage(String address,String startblock,String endblock,String sort,String page,String offset);

    /**
     * https://api.etherscan.io/api?module=account&action=txlistinternal&txhash=0x40eb908387324f2b575b4879cd9d7188f69c8fc9d87c901b9e2daaea4b442170&apikey=YourApiKeyToken
     * @param hash
     * @return
     */
    public String getTransationsByHash(String hash);

    /**
     * 获取按地址开采的块列表
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    public String getListOfBlocksMinedByAddress(String address);

    /**
     * 分页获取按地址开采的块列表
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&page=1&offset=10&apikey=YourApiKeyToken
     * @param address
     * @param page
     * @param offset
     * @return
     */
    public String getListOfBlocksMinedByAddressPage(String address,String page,String offset);
}
