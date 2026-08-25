package com.hisavana.common.interfacz;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface IBidWithNotify {
    String getPayload();

    boolean isExpired();

    void notifyLoss();

    void notifyWin();
}
