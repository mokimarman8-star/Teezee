package com.transsion.shorttv_pugc;

import com.transsion.player.enum.PlayMimeType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.shorttv_pugc.ShorttvModel;
import gn.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    public static final e a(ShorttvModel.UGCVideo uGCVideo) {
        Intrinsics.h(uGCVideo, "<this>");
        String playUrl = uGCVideo.getPlayUrl();
        String playUrl2 = uGCVideo.getPlayUrl();
        if (playUrl2 == null) {
            playUrl2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new e(playUrl, playUrl2, uGCVideo.videoUGCPosition(), (PlayMimeType) null, (MediaItem) null, 24, (DefaultConstructorMarker) null);
    }
}
