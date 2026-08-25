package com.aliyun.player;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface UrlListPlayer extends IListPlayer, UrlPlayer {
    void addUrl(String str, String str2);

    boolean moveTo(String str);

    boolean moveToNext();

    boolean moveToPrev();
}
