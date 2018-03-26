package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class BlockMined extends BaseResponse {
    private String blockNumber;
    private String timeStamp;
    private String blockReward;

    public BlockMined(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("blockNumber") != null){this.setBlockNumber(jsonObject.getString("blockNumber"));}
            if(jsonObject.get("timeStamp") != null){this.setBlockNumber(jsonObject.getString("timeStamp"));}
            if(jsonObject.get("blockReward") != null){this.setBlockNumber(jsonObject.getString("blockReward"));}
        }else {
            return;
        }
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(String blockReward) {
        this.blockReward = blockReward;
    }

    @Override
    public String toString() {
        return "status:"+this.getStatus()+" message:"+this.getMessage()+" blockNumber:" + this.getBlockNumber() +" timeStamp:"+this.getTimeStamp() +" blockReward:" + this.getBlockReward();
    }
}
