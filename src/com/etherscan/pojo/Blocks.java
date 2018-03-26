package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Blocks extends BaseResponse {
    public Blocks(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){
                JSONObject jsObj = jsonObject.getJSONObject("result");
                if(jsObj !=null){
                    if(jsObj.get("blockNumber") != null){this.setBlockNumber(jsObj.getString("blockNumber"));}
                    if(jsObj.get("timeStamp") != null){this.setTimeStamp(jsObj.getString("timeStamp"));}
                    if(jsObj.get("blockMiner") != null){this.setBlockMiner(jsObj.getString("blockMiner"));}
                    if(jsObj.get("blockReward") != null){this.setBlockReward(jsObj.getString("blockReward"));}
                    if(jsObj.get("uncleInclusionReward") != null){this.setUncleInclusionReward(jsObj.getString("uncleInclusionReward"));}
                    if(jsObj.get("uncles") != null){
                        JSONArray unclesObjs = jsObj.getJSONArray("uncles");
                        List<BlocksUncle> unclesList = new ArrayList<BlocksUncle>();
                        BlocksUncle uncle = null;
                        for (int i = 0; i < unclesObjs.size(); i++) {
                            uncle = new BlocksUncle(unclesObjs.getJSONObject(i));
                            unclesList.add(uncle);
                        }
                        this.setUncles(unclesList);
                    }
                }
            }
        }else{return;}
    }
    private String blockNumber;
    private String timeStamp;
    private String blockMiner;
    private String blockReward;
    private String uncleInclusionReward;
    private List<BlocksUncle> uncles;

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

    public String getBlockMiner() {
        return blockMiner;
    }

    public void setBlockMiner(String blockMiner) {
        this.blockMiner = blockMiner;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(String blockReward) {
        this.blockReward = blockReward;
    }

    public String getUncleInclusionReward() {
        return uncleInclusionReward;
    }

    public void setUncleInclusionReward(String uncleInclusionReward) {
        this.uncleInclusionReward = uncleInclusionReward;
    }

    public List<BlocksUncle> getUncles() {
        return uncles;
    }

    public void setUncles(List<BlocksUncle> uncles) {
        this.uncles = uncles;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" blockNumber:").append(this.getBlockNumber());
        sbf.append(" timeStamp:").append(this.getTimeStamp());
        sbf.append(" blockMiner:").append(this.getBlockMiner());
        sbf.append(" blockReward:").append(this.getBlockReward());
        sbf.append(" uncleInclusionReward:").append(this.getUncleInclusionReward());
        sbf.append(" result:[");
        List<BlocksUncle> blocksUncles = this.getUncles();
        if(blocksUncles != null && blocksUncles.size()>0)
        {
            for (BlocksUncle blocksUncle:blocksUncles){
                sbf.append(blocksUncle.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
