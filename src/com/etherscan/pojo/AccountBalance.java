package com.etherscan.pojo;

import net.sf.json.JSONObject;

public class AccountBalance extends BaseResponse {

    private String account;
    private String balance;

    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getAccount() {
        return account;
    }

    public AccountBalance(){
        super();
    }
    public AccountBalance(JSONObject jsonObject) {
        if(jsonObject != null){
            if(jsonObject.get("status") != null){
                this.setStatus(jsonObject.getString("status"));
            }
            if(jsonObject.get("message") != null){
                this.setMessage(jsonObject.getString("message"));
            }
            if(jsonObject.get("result") != null){
                this.setBalance(jsonObject.getString("result"));
            }
            if(jsonObject.get("account") != null){
                this.setAccount(jsonObject.getString("account"));
            }
            if(jsonObject.get("balance") != null){
                this.setBalance(jsonObject.getString("balance"));
            }
        }else {
            return;
        }
    }

    @Override
    public String toString() {
        return "status:"+this.getStatus()+" message:"+this.getMessage()+" account:" + this.getAccount() +" balance:"+this.getBalance();
    }
}
