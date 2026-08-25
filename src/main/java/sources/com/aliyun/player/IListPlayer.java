package com.aliyun.player;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IListPlayer extends IPlayer {
    void clear();

    String getCurrentUid();

    int getMaxPreloadMemorySizeMB();

    void removeSource(String str);

    void setMaxPreloadMemorySizeMB(int i);

    void setPreloadCount(int i);
}
