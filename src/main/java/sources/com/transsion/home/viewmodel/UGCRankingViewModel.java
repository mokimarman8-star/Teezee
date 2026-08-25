package com.transsion.home.viewmodel;

import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCRankingViewModel extends t0 {
    public static final a g = new a(null);
    public static final int h = 8;
    private String e;
    private final androidx.lifecycle.b0 a = new androidx.lifecycle.b0();
    private final androidx.lifecycle.b0 b = new androidx.lifecycle.b0();
    private String c = MsgStyle.CUSTOM_LEFT_PIC;
    private final yk.d d = (yk.d) kg.c.e.a().h(yk.d.class);
    private String f = BuildConfig.FLAVOR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(UGCRankAllData uGCRankAllData) {
        ArrayList arrayList;
        if (uGCRankAllData != null) {
            List<UGCContent> items = uGCRankAllData.getItems();
            if (items != null) {
                arrayList = new ArrayList();
                for (Object obj : items) {
                    UGCContent uGCContent = (UGCContent) obj;
                    if (Intrinsics.c(uGCContent.getTopicType(), "UGC_VIDEO") && uGCContent.getVideo() != null) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            uGCRankAllData.setItems(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(UGCRankAllData uGCRankAllData) {
        List<UGCContent> items;
        String ops;
        String ops2;
        String ops3 = uGCRankAllData != null ? uGCRankAllData.getOps() : null;
        if (ops3 == null || ops3.length() == 0 || uGCRankAllData == null || (items = uGCRankAllData.getItems()) == null) {
            return;
        }
        for (UGCContent uGCContent : items) {
            UGCVideo video = uGCContent.getVideo();
            UGCCollection collection = uGCContent.getCollection();
            if (video != null && ((ops2 = video.getOps()) == null || ops2.length() == 0)) {
                video.setOps(ops3);
            }
            if (collection != null && ((ops = collection.getOps()) == null || ops.length() == 0)) {
                collection.setOps(ops3);
            }
        }
    }

    private final void p(boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UGCRankingViewModel$startRequest$1(z, this, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 j() {
        return this.b;
    }

    public final androidx.lifecycle.b0 k() {
        return this.a;
    }

    public final void l(String str, String str2) {
        Intrinsics.h(str2, "tabId");
        a.a.f(wf.a.a, "UGCRankingViewModel", "getRankData: category=" + str + ", tabId=" + str2, false, 4, (Object) null);
        this.e = str;
        this.f = str2;
        this.c = MsgStyle.CUSTOM_LEFT_PIC;
        p(false);
    }

    public final void m() {
        a.a.f(wf.a.a, "UGCRankingViewModel", "loadMore: currentPage=" + this.c, false, 4, (Object) null);
        p(true);
    }

    public final void n() {
        a.a.f(wf.a.a, "UGCRankingViewModel", "refresh: category=" + this.e + ", tabId=" + this.f, false, 4, (Object) null);
        this.c = MsgStyle.CUSTOM_LEFT_PIC;
        p(false);
    }
}
