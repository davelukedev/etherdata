package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NormalTransationList extends BaseResponse {

    public NormalTransationList(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            JSONArray objs = jsonObject.getJSONArray("result");
            List<NormalTransation> normalTransationsList = new ArrayList<NormalTransation>();
            NormalTransation transation = null;
            JSONObject resultObj = null;
            for (int i = 0; i < objs.size(); i++) {
                resultObj = objs.getJSONObject(i);
                transation = new NormalTransation(resultObj);
                if(transation != null){
                    transation.setStatus(jsonObject.getString("status"));
                    transation.setMessage(jsonObject.getString("message"));
                }
                normalTransationsList.add(transation);
            }
            this.setNormalTransationList(normalTransationsList);
        }else{return;}

    }
    private List<NormalTransation> normalTransationList;

    public List<NormalTransation> getNormalTransationList() {
        return normalTransationList;
    }

    public void setNormalTransationList(List<NormalTransation> normalTransationList) {
        this.normalTransationList = normalTransationList;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" result:[");
        List<NormalTransation> normalTransationss = this.getNormalTransationList();
        if(normalTransationss != null && normalTransationss.size()>0)
        {
            for (NormalTransation normalTransation:normalTransationss){
                sbf.append(normalTransation.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
