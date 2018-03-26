package com.etherscan.api;

/**
 * 合约相关的API
 */
public interface ContractAPI {
    /**
     *获取验证合同源代码的合同ABI
     * https://api.etherscan.io/api?module=contract&action=getabi&address=0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413&apikey=YourApiKeyToken
     * @param address
     * @return
     */
    public String GetContractABI(String address);
}
