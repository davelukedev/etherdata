package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class BlocksUncle {

    public BlocksUncle(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("miner") != null){this.setMiner(jsonObject.getString("miner"));}
            if(jsonObject.get("unclePosition") != null){this.setUnclePosition(jsonObject.getString("unclePosition"));}
            if(jsonObject.get("blockreward") != null){this.setBlockreward(jsonObject.getString("blockreward"));}
        }else{ return;}
    }
    private String miner;
    private String unclePosition;
    private String blockreward;

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public String getUnclePosition() {
        return unclePosition;
    }

    public void setUnclePosition(String unclePosition) {
        this.unclePosition = unclePosition;
    }

    public String getBlockreward() {
        return blockreward;
    }

    public void setBlockreward(String blockreward) {
        this.blockreward = blockreward;
    }

    @Override
    public String toString() {
        return "miner:"+this.getMiner()+" unclePosition:"+this.getUnclePosition()+" blockreward:"+this.getBlockreward();
    }
}
