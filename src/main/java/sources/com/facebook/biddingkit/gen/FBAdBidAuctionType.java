package com.facebook.biddingkit.gen;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum FBAdBidAuctionType {
    FIRST_PRICE(1),
    SECOND_PRICE(2);

    private final int mValue;

    FBAdBidAuctionType(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
