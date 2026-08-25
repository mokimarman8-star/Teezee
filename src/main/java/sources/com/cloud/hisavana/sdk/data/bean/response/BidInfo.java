package com.cloud.hisavana.sdk.data.bean.response;

import com.cloud.hisavana.sdk.common.constant.Constants;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class BidInfo {
    private String adCreativeId;
    private String biddingToken;
    private String codeSeatId;
    private Constants.CURRENCY currency;
    private Double price;

    public String getAdCreativeId() {
        String str = this.adCreativeId;
        return str == null ? "" : str;
    }

    public String getBiddingToken() {
        return this.biddingToken;
    }

    public String getCodeSeatId() {
        return this.codeSeatId;
    }

    public Constants.CURRENCY getCurrency() {
        return this.currency;
    }

    public double getPrice() {
        Double d = this.price;
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public void setAdCreativeId(String str) {
        this.adCreativeId = str;
    }

    public void setBiddingToken(String str) {
        this.biddingToken = str;
    }

    public void setCodeSeatId(String str) {
        this.codeSeatId = str;
    }

    public void setCurrency(Constants.CURRENCY currency) {
        this.currency = currency;
    }

    public void setPrice(Double d) {
        this.price = d;
    }
}
