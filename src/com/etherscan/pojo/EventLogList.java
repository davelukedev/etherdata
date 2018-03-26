package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventLogList extends BaseResponse {

    public EventLogList(JSONObject jsonObject){
        if(jsonObject != null){
            if(jsonObject.get("status") != null){this.setStatus(jsonObject.getString("status"));}
            if(jsonObject.get("message") != null){this.setMessage(jsonObject.getString("message"));}
            if(jsonObject.get("result") != null){
                JSONArray objs = jsonObject.getJSONArray("result");
                List<EventLog> eventLogList = new ArrayList<EventLog>();
                EventLog eventLog = null;
                JSONObject resultObj = null;
                for (int i = 0; i < objs.size(); i++) {
                    resultObj = objs.getJSONObject(i);
                    eventLog = new EventLog(resultObj);
                    eventLogList.add(eventLog);
                }
                this.setEventLogList(eventLogList);
            }
        }else {return;}
    }
    private List<EventLog> eventLogList;

    public List<EventLog> getEventLogList() {
        return eventLogList;
    }

    public void setEventLogList(List<EventLog> eventLogList) {
        this.eventLogList = eventLogList;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" result:[");
        List<EventLog> eventLogList = this.getEventLogList();
        if(eventLogList != null && eventLogList.size()>0)
        {
            for (EventLog eventLog:eventLogList){
                sbf.append(eventLog.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
