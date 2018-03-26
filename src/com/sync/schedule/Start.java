package com.sync.schedule;

import com.etherscan.pojo.*;
import com.etherscan.service.*;
import com.etherscan.util.PropertyUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void  main(String[] args){
        System.out.println("start schedule...");
        String path = Class.class.getClass().getResource("/").getPath();
        System.out.println("Path :"+path);
        //String springConfig = path+"resources/application-schedule.xml";
        String springConfig = path+"resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(springConfig);

        //Test AccountService
        //AccountService service = (AccountService) context.getBean("accountservice");
        //testGetEtherBalanceSingleAddress(service);
        //testGetEtherBalanceMultipleAddress(service);
        //testgetNormalTransactionByAddress(service);
        //testgetNormalTransactionByAddressPage(service);
        //testgetInternalTransactionByAddress(service);
        //testgetInternalTransactionByAddressPage(service);
        //testGetTransationsByHash(service);
        //testGetListOfBlocksMinedByAddress(service);
        //testGetListOfBlocksMinedByAddressPage(service);

        //Test BlocksService
        //BlocksService service = (BlocksService) context.getBean("blocksservice");
        //TestGetBlockAndUncleRewardsByBlockNo(service);

        //Test ContractService
        //ContractService service = (ContractService) context.getBean("contractservice");
        //TestGetContractABI(service);

        //Test EventLogService
        //EventLogService service = (EventLogService) context.getBean("eventlogservice");
        //TestGetEventLogsByBlocksAndAddressTopic0(service);
        //TestGetEventLogsByBlocksAndAddressTopics(service);

        //TestGethParityProxyService
        GethParityProxyService service = (GethParityProxyService) context.getBean("gethparityproxyservice");
        //TestEthBlockNumber(service);
        TestEthGetBlockByNumber(service);

    }

    public static void TestEthGetBlockByNumber(GethParityProxyService service){
        String tag = "0x10d4f";
        Block block = service.ethGetBlockByNumber(tag);
        System.out.println(block.toString());
    }

    public static void TestEthBlockNumber(GethParityProxyService service){
        BlockNumber blockNumber = service.ethBlockNumber();
        System.out.println(blockNumber.toString());
    }

    public static void TestGetEventLogsByBlocksAndAddressTopics(EventLogService service){
        String fromBlock="379224";
        String toBlock = "latest";
        String address = "0x33990122638b9132ca29c723bdf037f1a891a70c";
        String topic0 = "0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545";
        String topic1 = "0x72657075746174696f6e00000000000000000000000000000000000000000000";
        EventLogList eventLogList = service.getEventLogsByBlocksAndAddressTopics(fromBlock,toBlock,address,topic0,topic1);
        System.out.println(eventLogList.toString());
    }

    public static void TestGetEventLogsByBlocksAndAddressTopic0(EventLogService service){
        String fromBlock="379224";
        String toBlock = "latest";
        String address = "0x33990122638b9132ca29c723bdf037f1a891a70c";
        String topic0 = "0xf63780e752c6a54a94fc52715dbc5518a3b4c3c2833d301a204226548a2a8545";
        EventLogList eventLogList = service.getEventLogsByBlocksAndAddressTopic0(fromBlock,toBlock,address,topic0);
        System.out.println(eventLogList.toString());
    }

    public static void TestGetContractABI(ContractService service){
        String address = "0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413";
        Contract contract = service.getContractABI(address);
        System.out.println(contract.toString());
    }

    public static void TestGetBlockAndUncleRewardsByBlockNo(BlocksService service){
        String blockNo = "2165403";
        Blocks blocks = service.getBlockAndUncleRewardsByBlockNo(blockNo);
        System.out.println(blocks.toString());
    }

    public static void testGetListOfBlocksMinedByAddress(AccountService service){
        String address = "0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b";
        BlockMinedList blockMinedList = service.getListOfBlocksMinedByAddress(address);
        System.out.println(blockMinedList.toString());
    }
    public static void testGetListOfBlocksMinedByAddressPage(AccountService service){
        String address = "0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b";
        String page = "1";
        String offset = "15";
        BlockMinedList blockMinedList = service.getListOfBlocksMinedByAddressPage(address,page,offset);
        System.out.println(blockMinedList.toString());
    }
    public static void testGetEtherBalanceSingleAddress(AccountService service){
        String address = "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a";
        AccountBalance balance = service.getEtherBalanceSingleAddress(address);
        System.out.println(balance.toString());
    }
    public static void testGetEtherBalanceMultipleAddress(AccountService service){
        String address = "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a";
        List<String> addresses = new ArrayList<String>();
        addresses.add("0x63a9975ba31b0b9626b34300f7f627147df1f526");
        addresses.add("0x198ef1ec325a96cc354c7266a038be8b5c558f67");
        addresses.add("0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a");
        AccountListBalance balances = service.getEtherBalanceMultipleAddress(addresses);
        System.out.println(balances.toString());
    }
    public static void testgetNormalTransactionByAddress(AccountService service){
        String address = "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a";
        NormalTransationList normalTransationList = service.getNormalTransactionByAddress(address,"0","999999","asc");
        System.out.println(normalTransationList.toString());
    }
    public static void testgetNormalTransactionByAddressPage(AccountService service){
        String address = "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a";
        NormalTransationList normalTransationList = service.getNormalTransactionByAddressPage(address,"0","999999","asc","1","10");
        System.out.println(normalTransationList.toString());
    }
    public static void testgetInternalTransactionByAddress(AccountService service){
        String address = "0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3";
        InternalTransationList internalTransationList = service.getInternalTransationsByAddress(address,"0","9999999","asc");
        System.out.println(internalTransationList.toString());
    }
    public static void testgetInternalTransactionByAddressPage(AccountService service){
        String address = "0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3";
        InternalTransationList internalTransationList = service.getInternalTransationsByAddressPage(address,"0","9999999","asc","1","10");
        System.out.println(internalTransationList.toString());
    }

    public static void testGetTransationsByHash(AccountService service){
        String hash = "0x1a50f1dc0bc912745f7d09b988669f71d199719e2fb7592c2074ede9578032d0";
        InternalTransationList internalTransationList = service.getTransationsByHash(hash);
        System.out.println(internalTransationList.toString());
    }
}
