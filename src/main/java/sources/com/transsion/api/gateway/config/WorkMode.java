package com.transsion.api.gateway.config;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public enum WorkMode {
    MODE_TEST(1),
    MODE_ONLINE(3);

    private int mode;

    WorkMode(int i) {
        this.mode = i;
    }

    public int getMode() {
        return this.mode;
    }
}
