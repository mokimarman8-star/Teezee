package com.aliyun.player;

import com.aliyun.player.source.BitStreamSource;
import com.aliyun.player.source.UrlSource;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface UrlPlayer extends IPlayer {
    void setDataSource(BitStreamSource bitStreamSource);

    void setDataSource(UrlSource urlSource);
}
