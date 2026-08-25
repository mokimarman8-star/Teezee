package com.cloud.tmc.miniapp.action;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface RefreshAction {
    void enableHeaderTranslationContent(boolean z);

    void enableLoadMore(boolean z);

    void enableRefresh(boolean z);

    void onLoadMoreEvent();

    void onRefreshEvent();

    boolean startRefresh();

    boolean stopLoadMore();

    boolean stopRefresh();
}
