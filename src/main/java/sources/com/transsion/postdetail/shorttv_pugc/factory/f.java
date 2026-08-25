package com.transsion.postdetail.shorttv_pugc.factory;

import android.os.Build;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.postdetail.util.UGCShortTVFloatManager;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCategory;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDescImage;
import com.transsion.ugcvideodetail.api.bean.UGCVideoInteractiveInfo;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.videofloat.manager.a0;
import cw.b;
import cw.e;
import gw.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements vs.e {

    public static final class a implements gw.a {
        a() {
        }

        public boolean a(dw.a aVar) {
            return UGCShortTVFloatManager.b.m(aVar);
        }

        public void b(dw.a aVar) {
            UGCShortTVFloatManager uGCShortTVFloatManager = UGCShortTVFloatManager.b;
            uGCShortTVFloatManager.j();
            uGCShortTVFloatManager.n(aVar);
        }

        public void c(dw.a aVar) {
            a.a.a(this, aVar);
            UGCShortTVFloatManager.b.k(aVar);
        }
    }

    private final dw.a j(rs.d dVar) {
        ShorttvModel.UGCVideoCollection belongToCollection;
        ShorttvModel.UGCVideoCollection belongToCollection2;
        ShorttvModel.UGCVideoCollection belongToCollection3;
        ShorttvModel.UGCVideoCollection belongToCollection4;
        dw.a aVar = new dw.a(dVar.g(), dVar.c(), (ViewGroup) null, FloatPlayType.SHORT_TV, BuildConfig.FLAVOR, -1, dVar.a(), BuildConfig.FLAVOR, dVar.e());
        aVar.J(Integer.valueOf(SubjectType.SHORT_TV.getValue()));
        aVar.A(dVar.b());
        aVar.B(dVar.d());
        ShorttvModel.UGCVideo h = dVar.h();
        String collectionId = (h == null || (belongToCollection4 = h.getBelongToCollection()) == null) ? null : belongToCollection4.getCollectionId();
        ShorttvModel.UGCVideo h2 = dVar.h();
        String collectionName = (h2 == null || (belongToCollection3 = h2.getBelongToCollection()) == null) ? null : belongToCollection3.getCollectionName();
        ShorttvModel.UGCVideo h3 = dVar.h();
        Integer videoNum = (h3 == null || (belongToCollection2 = h3.getBelongToCollection()) == null) ? null : belongToCollection2.getVideoNum();
        ShorttvModel.UGCVideo h4 = dVar.h();
        UGCVideoBelongToCollection uGCVideoBelongToCollection = new UGCVideoBelongToCollection(collectionId, collectionName, videoNum, (h4 == null || (belongToCollection = h4.getBelongToCollection()) == null) ? null : belongToCollection.getPosition(), (UGCVideoDescImage) null, 16, (DefaultConstructorMarker) null);
        ShorttvModel.UGCVideo h5 = dVar.h();
        String ugcVideoId = h5 != null ? h5.getUgcVideoId() : null;
        ShorttvModel.UGCVideo h6 = dVar.h();
        String title = h6 != null ? h6.getTitle() : null;
        ShorttvModel.UGCVideo h7 = dVar.h();
        String description = h7 != null ? h7.getDescription() : null;
        ShorttvModel.UGCVideo h8 = dVar.h();
        String corner = h8 != null ? h8.getCorner() : null;
        ShorttvModel.UGCVideo h9 = dVar.h();
        Long duration = h9 != null ? h9.getDuration() : null;
        ShorttvModel.UGCVideo h10 = dVar.h();
        String watchNum = h10 != null ? h10.getWatchNum() : null;
        ShorttvModel.UGCVideo h11 = dVar.h();
        String releaseDate = h11 != null ? h11.getReleaseDate() : null;
        ShorttvModel.UGCVideo h12 = dVar.h();
        Long publishTime = h12 != null ? h12.getPublishTime() : null;
        ShorttvModel.UGCVideo h13 = dVar.h();
        String category = h13 != null ? h13.getCategory() : null;
        ShorttvModel.UGCVideo h14 = dVar.h();
        String ops = h14 != null ? h14.getOps() : null;
        ShorttvModel.UGCVideo h15 = dVar.h();
        String subjectId = h15 != null ? h15.getSubjectId() : null;
        ShorttvModel.UGCVideo h16 = dVar.h();
        List country = h16 != null ? h16.getCountry() : null;
        ShorttvModel.UGCVideo h17 = dVar.h();
        aVar.L(new UGCVideo(ugcVideoId, title, description, (List) null, (Cover) null, (Cover) null, corner, duration, watchNum, releaseDate, publishTime, category, (UGCVideoCreator) null, (UGCVideoInteractiveInfo) null, uGCVideoBelongToCollection, ops, subjectId, country, (UGCVideoDescImage) null, (String) null, (String) null, (List) null, (Integer) null, h17 != null ? h17.getRestrictKid() : 0, false, (UGCVideoCategory) null, (UGCVideoCategory) null, (UGCVideoCategory) null, (UGCVideoCategory) null, 528232504, (DefaultConstructorMarker) null));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(FragmentActivity fragmentActivity, boolean z) {
        if (z) {
            fragmentActivity.finish();
        }
        return Unit.a;
    }

    public void a(FragmentActivity fragmentActivity, boolean z, boolean z2, ViewGroup viewGroup) {
        Intrinsics.h(fragmentActivity, "activity");
        e.a aVar = cw.e.a;
        if (aVar.b().c() && com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true)) {
            aVar.b().a(fragmentActivity, true, z2, viewGroup);
        }
    }

    public void b(FragmentActivity fragmentActivity, String str, String str2, String str3) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str, "ugcVideoId");
        Intrinsics.h(str2, "pageName");
        cw.b.a.c().f(fragmentActivity, (String) null, str, str2, str3);
    }

    public void c() {
        b.b.a(cw.b.a.c(), false, 1, (Object) null);
    }

    public com.transsion.player.orplayer.f d(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a0.a.b(UGCShortTVFloatManager.b.h(str));
    }

    public boolean e(com.transsion.player.orplayer.f fVar) {
        return a0.a.c(fVar);
    }

    public boolean f(com.transsion.player.orplayer.f fVar) {
        return cw.c.a.c(fVar);
    }

    public void g(boolean z, FragmentActivity fragmentActivity, rs.d dVar) {
        Intrinsics.h(dVar, "bean");
        if (z) {
            if (fragmentActivity == null || fragmentActivity.isDestroyed() || fragmentActivity.isFinishing()) {
                return;
            }
            dw.a j = j(dVar);
            if (Build.VERSION.SDK_INT >= 31) {
                cw.e.a.b().h(fragmentActivity, j);
            }
        }
        cw.e.a.b().onPipModeChanged(z);
    }

    public void h(final FragmentActivity fragmentActivity, rs.d dVar) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(dVar, "bean");
        dw.a j = j(dVar);
        if (!com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true)) {
            wf.a.a.c("VideoFloat", "shottv 设置页pip开关被关闭了", true);
            return;
        }
        e.a aVar = cw.e.a;
        if (aVar.b().c()) {
            wf.a.a.c("VideoFloat-pip", "shottv 当前可用画中画，使用画中画播放", true);
            aVar.b().d(fragmentActivity, j, FloatActionType.HOME, false);
        } else {
            UGCShortTVFloatManager.b.q(dVar.f());
            cw.b.a.c().e(fragmentActivity, j, false, false, new Function1() { // from class: com.transsion.postdetail.shorttv_pugc.factory.e
                public final Object invoke(Object obj) {
                    Unit k;
                    k = f.k(fragmentActivity, ((Boolean) obj).booleanValue());
                    return k;
                }
            }, new a());
        }
    }
}
