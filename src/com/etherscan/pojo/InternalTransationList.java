package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InternalTransationList extends BaseResponse {

    public InternalTransationList(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            JSONArray objs = jsonObject.getJSONArray("result");
            List<InternalTransation> internalTransationsList = new ArrayList<InternalTransation>();
            InternalTransation transation = null;
            JSONObject resultObj = null;
            for (int i = 0; i < objs.size(); i++) {
                resultObj = objs.getJSONObject(i);
                transation = new InternalTransation(resultObj);
                if(transation != null){
                    transation.setStatus(jsonObject.getString("status"));
                    transation.setMessage(jsonObject.getString("message"));
                }
                internalTransationsList.add(transation);
            }
            this.setInternalTransationList(internalTransationsList);
        }else{return;}
    }
    private List<InternalTransation> internalTransationList ;

    public List<InternalTransation> getInternalTransationList() {
        return internalTransationList;
    }
    public void setInternalTransationList(List<InternalTransation> internalTransationList) {
        this.internalTransationList = internalTransationList;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" result:[");
        List<InternalTransation> internalTransationss = this.getInternalTransationList();
        if(internalTransationss != null && internalTransationss.size()>0)
        {
            for (InternalTransation internalTransation:internalTransationss){
                sbf.append(internalTransation.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
