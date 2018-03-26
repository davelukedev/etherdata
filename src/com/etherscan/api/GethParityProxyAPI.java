package com.etherscan.api;

public interface GethParityProxyAPI {

    /**
     * Returns the number of most recent block
     * https://api.etherscan.io/api?module=proxy&action=eth_blockNumber&apikey=YourApiKeyToken
     * @return
     */
    public String ethBlockNumber();

    /**
     * Returns information about a block by block number.
     * https://api.etherscan.io/api?module=proxy&action=eth_getBlockByNumber&tag=0x10d4f&boolean=true&apikey=YourApiKeyToken
     * @param tag
     * @return
     */
    public String ethGetBlockByNumber(String tag);

    /**
     * Returns information about a uncle by block number.
     * https://api.etherscan.io/api?module=proxy&action=eth_getUncleByBlockNumberAndIndex&tag=0x210A9B&index=0x0&apikey=YourApiKeyToken
     * @param tag
     * @param index
     * @return
     */
    public String ethGetUncleByBlockNumberAndIndex(String tag,String index);

    /**
     * https://api.etherscan.io/api?module=proxy&action=eth_getBlockTransactionCountByNumber&tag=0x10FB78&apikey=YourApiKeyToken
     * Returns the number of transactions in a block from a block matching the given block number
     * @param tag
     * @return
     */
    public String getBlockTransactionCountByNumber(String tag);

    /**
     * Returns the information about a transaction requested by transaction hash
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByHash&txhash=0x1e2910a262b1008d0616a0beb24c1a491d78771baa54a33e66065e03b1f46bc1&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    public String getTransactionByHash(String txHash);

    /**
     * Returns information about a transaction by block number and transaction index position
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByBlockNumberAndIndex&tag=0x10d4f&index=0x0&apikey=YourApiKeyToken
     * @param tag
     * @param index
     * @return
     */
    public String getTransactionByBlockNumberAndIndex(String tag,String index);

    /**
     * Returns the number of transactions sent from an address
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionCount&address=0x2910543af39aba0cd09dbb2d50200b3e800a63d2&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param tag
     * @return
     */
    public String getTransactionCount(String address,String tag);

    /**
     * Creates new message call transaction or a contract creation for signed transactions
     * https://api.etherscan.io/api?module=proxy&action=eth_sendRawTransaction&hex=0xf904808000831cfde080&apikey=YourApiKeyToken
     * @param hex
     * @return
     */
    public String sendRawTransaction(String hex);

    /**
     * Returns the receipt of a transaction by transaction hash
     * https://api.etherscan.io/api?module=proxy&action=eth_getTransactionReceipt&txhash=0x1e2910a262b1008d0616a0beb24c1a491d78771baa54a33e66065e03b1f46bc1&apikey=YourApiKeyToken
     * @param txHash
     * @return
     */
    public String getTransactionReceipt(String txHash);

    /**
     * Executes a new message call immediately without creating a transaction on the block chain
     * https://api.etherscan.io/api?module=proxy&action=eth_call&to=0xAEEF46DB4855E25702F8237E8f403FddcaF931C0&data=0x70a08231000000000000000000000000e16359506c028e51f16be38986ec5746251e9724&tag=latest&apikey=YourApiKeyToken
     * @param to
     * @param data
     * @param tag
     * @return
     */
    public String call(String to,String data,String tag);

    /**
     * Returns code at a given address
     * https://api.etherscan.io/api?module=proxy&action=eth_getCode&address=0xf75e354c5edc8efed9b59ee9f67a80845ade7d0c&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param tag
     * @return
     */
    public String getCode(String address,String tag);

    /**
     * Returns the value from a storage position at a given address.
     * https://api.etherscan.io/api?module=proxy&action=eth_getStorageAt&address=0x6e03d9cce9d60f3e9f2597e13cd4c54c55330cfd&position=0x0&tag=latest&apikey=YourApiKeyToken
     * @param address
     * @param position
     * @param tag
     * @return
     */
    public String getStorageAt(String address,String position,String tag);

    /**
     * Returns the current price per gas in wei.
     * https://api.etherscan.io/api?module=proxy&action=eth_gasPrice&apikey=YourApiKeyToken
     * @return
     */
    public String gasPrice();

    /**
     * Makes a call or transaction, which won't be added to the blockchain and returns the used gas, which can be used for estimating the used gas
     * https://api.etherscan.io/api?module=proxy&action=eth_estimateGas&to=0xf0160428a8552ac9bb7e050d90eeade4ddd52843&value=0xff22&gasPrice=0x051da038cc&gas=0xffffff&apikey=YourApiKeyToken
     * @param to
     * @param value
     * @param gasPrice
     * @param gas
     * @return
     */
    public String estimateGas(String to,String value,String gasPrice,String gas);
}
