package com.etherscan.api;

public interface StatsAPI {

    /**
     * (Result returned in Wei, to get value in Ether divide resultAbove/1000000000000000000)
     * https://api.etherscan.io/api?module=stats&action=ethsupply&apikey=YourApiKeyToken
     * @return
     */
    public String GetTotalSupplyOfEther();

    /**
     * https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken
     * @return
     */
    public String GetETHERLastPrice();
}
