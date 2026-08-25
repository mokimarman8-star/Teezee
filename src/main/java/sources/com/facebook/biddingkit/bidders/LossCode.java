package com.facebook.biddingkit.bidders;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum LossCode {
    WIN(0),
    TIMEOUT(2),
    NO_BID(9),
    OUTBID(102),
    DID_NOT_PARTICIPATE(2003);

    private final int mCode;

    LossCode(int i) {
        this.mCode = i;
    }

    public String getStringValue() {
        return Integer.toString(this.mCode);
    }
}
