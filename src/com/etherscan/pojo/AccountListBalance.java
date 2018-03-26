package com.etherscan.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AccountListBalance extends BaseResponse {

    public AccountListBalance(JSONObject jsonObject){
        if(jsonObject !=null){
            this.setStatus(jsonObject.getString("status"));
            this.setMessage(jsonObject.getString("message"));
            JSONArray objs = jsonObject.getJSONArray("result");
            List<AccountBalance> accountBalanceList = new ArrayList<AccountBalance>();
            AccountBalance balance = null;
            JSONObject resultObj = null;
            for (int i = 0; i < objs.size(); i++) {
                resultObj = objs.getJSONObject(i);
                balance = new AccountBalance(resultObj);
                if(balance != null){
                    balance.setStatus(jsonObject.getString("status"));
                    balance.setMessage(jsonObject.getString("message"));
                }
                accountBalanceList.add(balance);
            }
            this.setAccountsbalances(accountBalanceList);
        }else{
            return;
        }
    }
    List<AccountBalance> accountsbalances;

    public List<AccountBalance> getAccountsbalances() {
        return accountsbalances;
    }

    public void setAccountsbalances(List<AccountBalance> accountsbalances) {
        this.accountsbalances = accountsbalances;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("status:").append(this.getStatus()).append(" messages:").append(this.getMessage());
        sbf.append(" result:[");
        List<AccountBalance> accountsbalanceses = this.getAccountsbalances();
        if(accountsbalanceses != null && accountsbalanceses.size()>0)
        {
            for (AccountBalance balance:accountsbalanceses){
                sbf.append(balance.toString()).append(",");
            }
            sbf.append("]");
        }
        return sbf.toString();
    }
}
