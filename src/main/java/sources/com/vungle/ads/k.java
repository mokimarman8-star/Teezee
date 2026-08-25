package com.vungle.ads;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface k extends com.vungle.ads.a {

    public static final class a {
        public static /* synthetic */ void play$default(k kVar, Context context, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
            }
            if ((i & 1) != 0) {
                context = null;
            }
            kVar.play(context);
        }
    }

    @Override // com.vungle.ads.a
    /* synthetic */ Boolean canPlayAd();

    @Override // com.vungle.ads.a
    /* synthetic */ void load(String str);

    void play(Context context);
}
