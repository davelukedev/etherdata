package com.etherscan.pojo;

import com.etherscan.util.JsonUtil;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EtherLastPrice  extends BaseResponse{

    public EtherLastPrice(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){
                JSONObject jsObj = jsonObject.getJSONObject("result");
                if(jsObj.get("ethbtc") != null){this.setEthbtc(jsObj.getString("ethbtc"));}
                if(jsObj.get("ethbtc_timestamp") != null){this.setEthbtc_timestamp(jsObj.getString("ethbtc_timestamp"));}
                if(jsObj.get("ethusd") != null){this.setEthusd(jsObj.getString("ethusd"));}
                if(jsObj.get("ethusd_timestamp") != null){this.setEthusd_timestamp(jsObj.getString("ethusd_timestamp"));}
            }

        }else {return;}
    }
    private String ethbtc;
    private String ethbtc_timestamp;
    private String ethusd;
    private String ethusd_timestamp;

    public String getEthbtc() {
        return ethbtc;
    }

    public void setEthbtc(String ethbtc) {
        this.ethbtc = ethbtc;
    }

    public String getEthbtc_timestamp() {
        return ethbtc_timestamp;
    }

    public void setEthbtc_timestamp(String ethbtc_timestamp) {
        this.ethbtc_timestamp = ethbtc_timestamp;
    }

    public String getEthusd() {
        return ethusd;
    }

    public void setEthusd(String ethusd) {
        this.ethusd = ethusd;
    }

    public String getEthusd_timestamp() {
        return ethusd_timestamp;
    }

    public void setEthusd_timestamp(String ethusd_timestamp) {
        this.ethusd_timestamp = ethusd_timestamp;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" ethbtc:").append(this.getEthbtc());
        sbf.append(" ethbtc_timestamp:").append(this.getEthbtc_timestamp());
        sbf.append(" ethusd:").append(this.getEthbtc());
        sbf.append(" ethusd_timestamp:").append(this.getEthbtc_timestamp());
        return sbf.toString();
    }
}
