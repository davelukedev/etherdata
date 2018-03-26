package com.etherscan.api;

public interface BlocksAPI {

    /**
     * BlockNo获得Block和Uncle奖励
     * https://api.etherscan.io/api?module=block&action=getblockreward&blockno=2165403&apikey=YourApiKeyToken
     * @param blockNo
     * @return
     */
    public  String getBlockAndUncleRewardsByBlockNo(String blockNo);
}
