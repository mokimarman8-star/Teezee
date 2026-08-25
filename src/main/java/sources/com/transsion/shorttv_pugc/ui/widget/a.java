package com.transsion.shorttv_pugc.ui.widget;

import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a extends com.transsion.player.orplayer.e {

    /* renamed from: com.transsion.shorttv_pugc.ui.widget.a$a, reason: collision with other inner class name */
    public static final class C0008a {
        public static /* synthetic */ void a(a aVar, ShorttvModel.UGCVideo uGCVideo, ShortTvDetailListFragment shortTvDetailListFragment, Integer num, boolean z, String str, String str2, boolean z2, boolean z3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setData");
            }
            aVar.setData(uGCVideo, shortTvDetailListFragment, num, z, str, str2, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3);
        }
    }

    long getProgress();

    void onPageRelease(int i);

    void onPageSelected(com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, ShorttvModel.UGCVideo uGCVideo);

    void setData(ShorttvModel.UGCVideo uGCVideo, ShortTvDetailListFragment shortTvDetailListFragment, Integer num, boolean z, String str, String str2, boolean z2, boolean z3);
}
