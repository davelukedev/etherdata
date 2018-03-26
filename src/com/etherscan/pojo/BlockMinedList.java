package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlockMinedList extends BaseResponse {

    public BlockMinedList(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            JSONArray objs = jsonObject.getJSONArray("result");
            List<BlockMined> blockMinedList = new ArrayList<BlockMined>();
            BlockMined blockMined = null;
            JSONObject resultObj = null;
            for (int i = 0; i < objs.size(); i++) {
                resultObj = objs.getJSONObject(i);
                blockMined = new BlockMined(resultObj);
                if(blockMined != null){
                    blockMined.setStatus(jsonObject.getString("status"));
                    blockMined.setMessage(jsonObject.getString("message"));
                }
                blockMinedList.add(blockMined);
            }
            this.setBlockMinedList(blockMinedList);
        }else{return;}
    }

    private List<BlockMined> blockMinedList ;

    public List<BlockMined> getBlockMinedList() {
        return blockMinedList;
    }

    public void setBlockMinedList(List<BlockMined> blockMinedList) {
        this.blockMinedList = blockMinedList;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" result:[");
        List<BlockMined> blockMinedList = this.getBlockMinedList();
        if(blockMinedList != null && blockMinedList.size()>0)
        {
            for (BlockMined blockMined:blockMinedList){
                sbf.append(blockMined.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
