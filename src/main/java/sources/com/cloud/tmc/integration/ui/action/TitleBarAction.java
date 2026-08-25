package com.cloud.tmc.integration.ui.action;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface TitleBarAction {
    void changeNavigationBarProgress(int i, int i2, long j);

    boolean getNavigationBarProgressUpdateStatus();

    void hideNavigationBarLoading();

    void setCapsuleStyle(boolean z);

    void setNavigationBarIconStyle(boolean z);

    void showNavigationBarLoading();
}
