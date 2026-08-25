package com.cloud.hisavana.sdk.common.athena;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum AthenaTracker$ClickJumpType {
    PS_FULL_SCREEN(0),
    PS_HALF_SCREEN(1),
    GP(3),
    PULL_LIVE(4),
    OTHER(5);

    private final int rawValue;

    AthenaTracker$ClickJumpType(int i) {
        this.rawValue = i;
    }

    public int rawValue() {
        return this.rawValue;
    }
}
