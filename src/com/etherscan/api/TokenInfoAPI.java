package com.etherscan.api;

public interface TokenInfoAPI {


    /**
     * Get ERC20-Token TotalSupply by ContractAddress
     * https://api.etherscan.io/api?module=stats&action=tokensupply&contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&apikey=YourApiKeyToken
     * @param contractAddress
     * @return
     */
    public String TotalSupplyByContractAddress(String contractAddress);

    /**
     * https://api.etherscan.io/api?module=account&action=tokenbalance&contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&address=0xe04f27eb70e025b78871a2ad7eabe85e61212761&tag=latest&apikey=YourApiKeyToken
     * @param contractAddress
     * @param address
     * @param tag
     * @return
     */
    public String TokenAccountBalanceForTokenContractAddress(String contractAddress,String address,String tag);
}
