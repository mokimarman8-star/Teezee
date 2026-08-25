package com.transsion.player.longvideo.helper;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.flow.bean.DubsInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.subtitle.R;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.h;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVodSubtitleHelper {
    private final mn.j a;
    private final String b;
    private List c;
    private final w d;
    private final Function1 e;
    private boolean f;
    private List g;
    private final VideoSubtitleControl h;
    private boolean i;
    private DownloadBean j;
    private ln.a k;
    private boolean l;
    private View m;
    private ViewGroup n;
    private final n0 o;
    private final kotlinx.coroutines.n0 p;
    private final Lazy q;
    private final Lazy r;

    public static final class a implements lt.a {
        a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LongVodUiType.values().length];
            try {
                iArr[LongVodUiType.LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodUiType.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public LongVodSubtitleHelper(mn.j jVar, String str, List list, w wVar, Function1 function1, boolean z) {
        Intrinsics.h(jVar, "viewBinding");
        Intrinsics.h(list, "dubs");
        Intrinsics.h(wVar, "callback");
        this.a = jVar;
        this.b = str;
        this.c = list;
        this.d = wVar;
        this.e = function1;
        this.f = z;
        this.g = new ArrayList();
        this.l = true;
        this.p = o0.a(y0.b());
        this.q = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.g0
            public final Object invoke() {
                VideoDetailPlayDao k0;
                k0 = LongVodSubtitleHelper.k0();
                return k0;
            }
        });
        this.r = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.i0
            public final Object invoke() {
                UGCVideoDetailPlayDao g0;
                g0 = LongVodSubtitleHelper.g0();
                return g0;
            }
        });
        FragmentActivity context = jVar.getRoot().getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        n0 n0Var = (n0) new v0(context).a(n0.class);
        this.o = n0Var;
        this.l = com.transsion.baselib.report.launch.b.a.b().getBoolean("subtitle_land_guide", true);
        FragmentActivity context2 = jVar.getRoot().getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        VideoSubtitleControl videoSubtitleControl = new VideoSubtitleControl(context2, str, com.transsion.baselib.helper.d.a.d(), this.c, new Function1() { // from class: com.transsion.player.longvideo.helper.j0
            public final Object invoke(Object obj) {
                Unit r;
                r = LongVodSubtitleHelper.r(((Boolean) obj).booleanValue());
                return r;
            }
        }, new Function2() { // from class: com.transsion.player.longvideo.helper.k0
            public final Object invoke(Object obj, Object obj2) {
                Unit s;
                s = LongVodSubtitleHelper.s(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return s;
            }
        }, new Function3() { // from class: com.transsion.player.longvideo.helper.l0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit t;
                t = LongVodSubtitleHelper.t(LongVodSubtitleHelper.this, (String) obj, (String) obj2, ((Integer) obj3).intValue());
                return t;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.m0
            public final Object invoke(Object obj) {
                Unit u;
                u = LongVodSubtitleHelper.u(LongVodSubtitleHelper.this, (DubsInfo) obj);
                return u;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.y
            public final Object invoke(Object obj) {
                Unit v;
                v = LongVodSubtitleHelper.v(LongVodSubtitleHelper.this, (List) obj);
                return v;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.z
            public final Object invoke(Object obj) {
                Unit w;
                w = LongVodSubtitleHelper.w(LongVodSubtitleHelper.this, (String) obj);
                return w;
            }
        }, new Function2() { // from class: com.transsion.player.longvideo.helper.a0
            public final Object invoke(Object obj, Object obj2) {
                Unit x;
                x = LongVodSubtitleHelper.x(LongVodSubtitleHelper.this, (String) obj, (String) obj2);
                return x;
            }
        });
        videoSubtitleControl.O(LocalVideoUiType.MIDDLE);
        videoSubtitleControl.g0(new a());
        videoSubtitleControl.c0(new Function1() { // from class: com.transsion.player.longvideo.helper.b0
            public final Object invoke(Object obj) {
                Unit P;
                P = LongVodSubtitleHelper.P(LongVodSubtitleHelper.this, (String) obj);
                return P;
            }
        });
        this.h = videoSubtitleControl;
        if (this.f) {
            this.l = false;
        }
        androidx.lifecycle.b0 b2 = n0Var.b();
        FragmentActivity context3 = jVar.getRoot().getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        b2.j(context3, new c(new Function1() { // from class: com.transsion.player.longvideo.helper.h0
            public final Object invoke(Object obj) {
                Unit q;
                q = LongVodSubtitleHelper.q(LongVodSubtitleHelper.this, (ht.a) obj);
                return q;
            }
        }));
    }

    public /* synthetic */ LongVodSubtitleHelper(mn.j jVar, String str, List list, w wVar, Function1 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jVar, str, list, wVar, function1, (i & 32) != 0 ? true : z);
    }

    private final void E() {
        if (this.g.isEmpty() && this.l) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            if (bVar.b().getBoolean("subtitle_is_search_downloaded", false)) {
                this.l = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
            } else {
                this.l = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
                this.d.b(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(DownloadBean downloadBean) {
        this.i = true;
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), "流媒体，开始播放检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        com.transsion.subtitle.h.a.b().e(downloadBean, new Function1() { // from class: com.transsion.player.longvideo.helper.c0
            public final Object invoke(Object obj) {
                Unit G;
                G = LongVodSubtitleHelper.G(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue());
                return G;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(LongVodSubtitleHelper longVodSubtitleHelper, boolean z) {
        if (!z && longVodSubtitleHelper.g.isEmpty()) {
            longVodSubtitleHelper.a.getRoot().post(new Runnable() { // from class: com.transsion.player.longvideo.helper.d0
                @Override // java.lang.Runnable
                public final void run() {
                    LongVodSubtitleHelper.H();
                }
            });
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
    }

    private final ImageView J() {
        return null;
    }

    private final TextView K() {
        if (this.f) {
            return this.a.o.x;
        }
        return null;
    }

    private final TextView L() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao N() {
        return (UGCVideoDetailPlayDao) this.r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao O() {
        return (VideoDetailPlayDao) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(LongVodSubtitleHelper longVodSubtitleHelper, String str) {
        longVodSubtitleHelper.d.f(str);
        return Unit.a;
    }

    private final void Q(DownloadBean downloadBean) {
        kotlinx.coroutines.i.d(this.p, (CoroutineContext) null, (CoroutineStart) null, new LongVodSubtitleHelper$loadFromDB$1(downloadBean, this, null), 3, (Object) null);
    }

    private final void U(View view) {
        mn.k kVar = this.a.o;
        View view2 = this.m;
        if (view2 != null) {
            uf.c.g(view2);
        }
    }

    private final void V(View view, boolean z) {
        this.d.b(true, true);
        w wVar = this.d;
        String string = Utils.a().getString(z ? R.string.subtitle_turn_on_toast : R.string.subtitle_turn_off_toast);
        Intrinsics.g(string, "getString(...)");
        wVar.c(string);
    }

    private final void a0(VideoSubtitleControl videoSubtitleControl) {
        LocalVideoUiType localVideoUiType = LocalVideoUiType.MIDDLE;
        TextView K = K();
        mn.j jVar = this.a;
        videoSubtitleControl.Z(localVideoUiType, K, jVar.A, jVar.z, jVar.k, false);
        videoSubtitleControl.i0(new Function1() { // from class: com.transsion.player.longvideo.helper.x
            public final Object invoke(Object obj) {
                Unit b0;
                b0 = LongVodSubtitleHelper.b0(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue());
                return b0;
            }
        });
        videoSubtitleControl.E(localVideoUiType, new Function2() { // from class: com.transsion.player.longvideo.helper.e0
            public final Object invoke(Object obj, Object obj2) {
                Unit c0;
                c0 = LongVodSubtitleHelper.c0(LongVodSubtitleHelper.this, (View) obj, ((Boolean) obj2).booleanValue());
                return c0;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.f0
            public final Object invoke(Object obj) {
                Unit d0;
                d0 = LongVodSubtitleHelper.d0(LongVodSubtitleHelper.this, (View) obj);
                return d0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(LongVodSubtitleHelper longVodSubtitleHelper, boolean z) {
        View I = longVodSubtitleHelper.I();
        if (I != null) {
            I.setVisibility(z ? 0 : 8);
        }
        ImageView J = longVodSubtitleHelper.J();
        if (J != null) {
            J.setVisibility(z ? 8 : 0);
        }
        TextView L = longVodSubtitleHelper.L();
        if (L != null) {
            L.setText(Utils.a().getString(z ? com.transsion.postdetail.R.string.play_loading : com.transsion.postdetail.R.string.turn_on_short));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(LongVodSubtitleHelper longVodSubtitleHelper, View view, boolean z) {
        Intrinsics.h(view, "switchView");
        longVodSubtitleHelper.V(view, z);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(LongVodSubtitleHelper longVodSubtitleHelper, View view) {
        Intrinsics.h(view, "settingView");
        longVodSubtitleHelper.U(view);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao g0() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao k0() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(LongVodSubtitleHelper longVodSubtitleHelper, ht.a aVar) {
        VideoSubtitleControl videoSubtitleControl = longVodSubtitleHelper.h;
        Intrinsics.e(aVar);
        videoSubtitleControl.N(aVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(boolean z) {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LongVodSubtitleHelper longVodSubtitleHelper, boolean z, boolean z2) {
        if (z) {
            longVodSubtitleHelper.d.b(true, z2);
        } else {
            longVodSubtitleHelper.d.b(false, true);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(LongVodSubtitleHelper longVodSubtitleHelper, String str, String str2, int i) {
        Intrinsics.h(str, "lanName");
        Intrinsics.h(str2, "lan");
        longVodSubtitleHelper.o.d().n(new Pair(str, str2));
        longVodSubtitleHelper.d.g(str, str2, i);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(LongVodSubtitleHelper longVodSubtitleHelper, DubsInfo dubsInfo) {
        Intrinsics.h(dubsInfo, "it");
        Function1 function1 = longVodSubtitleHelper.e;
        if (function1 != null) {
            function1.invoke(dubsInfo);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(LongVodSubtitleHelper longVodSubtitleHelper, List list) {
        Intrinsics.h(list, "list");
        longVodSubtitleHelper.o.c().n(list);
        longVodSubtitleHelper.d.e(list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(LongVodSubtitleHelper longVodSubtitleHelper, String str) {
        w wVar = longVodSubtitleHelper.d;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        wVar.c(str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(LongVodSubtitleHelper longVodSubtitleHelper, String str, String str2) {
        longVodSubtitleHelper.d.d(str, str2);
        return Unit.a;
    }

    public final View I() {
        return null;
    }

    public final Map M() {
        return this.h.F();
    }

    public final void R() {
        this.h.M();
    }

    public final void S() {
        DownloadBean downloadBean;
        if (this.i || (downloadBean = this.j) == null) {
            return;
        }
        this.i = true;
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), "流媒体，网络连接成功开始检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        h.b.a(com.transsion.subtitle.h.a.b(), downloadBean, (Function1) null, 2, (Object) null);
    }

    public final void T(ln.a aVar, ln.c cVar) {
        UGCVideoBelongToCollection belongToCollection;
        UGCVideoBelongToCollection belongToCollection2;
        UGCVideoBelongToCollection belongToCollection3;
        Intrinsics.h(aVar, "bean");
        Intrinsics.h(cVar, "playStream");
        this.i = false;
        this.k = aVar;
        if (aVar.d() != null) {
            this.j = aVar.d();
        } else {
            DownloadBean downloadBean = new DownloadBean(cVar.h(), cVar.c(), aVar.p(), BuildConfig.FLAVOR, StringsKt.x(cVar.g()), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, aVar.e(), aVar.l(), 0, 0, 0, 0, 0, 0, 0, aVar.o(), this.b, null, aVar.p(), 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1477181472, -1, 65535, null);
            downloadBean.setStream(cVar.k());
            downloadBean.setStreamVideoDetail(true);
            UGCVideo u = aVar.u();
            downloadBean.setUgcVideoId(u != null ? u.getUgcVideoId() : null);
            UGCVideo u2 = aVar.u();
            downloadBean.setUgcVideoCollectionId((u2 == null || (belongToCollection3 = u2.getBelongToCollection()) == null) ? null : belongToCollection3.getCollectionId());
            UGCVideo u3 = aVar.u();
            downloadBean.setUgcVideoName(u3 != null ? u3.getTitle() : null);
            UGCVideo u4 = aVar.u();
            downloadBean.setUgcVideoCollectionName((u4 == null || (belongToCollection2 = u4.getBelongToCollection()) == null) ? null : belongToCollection2.getCollectionName());
            UGCVideo u5 = aVar.u();
            downloadBean.setUgcVideoPosition((u5 == null || (belongToCollection = u5.getBelongToCollection()) == null) ? null : belongToCollection.getPosition());
            UGCVideo u6 = aVar.u();
            downloadBean.setUgcVideoType(u6 != null ? u6.getCategory() : null);
            downloadBean.setOps(aVar.q());
            downloadBean.setSubtitleIdType(cVar.d());
            this.j = downloadBean;
        }
        a.a aVar2 = wf.a.a;
        String a2 = com.transsion.baselib.report.a.a.a();
        DownloadBean downloadBean2 = this.j;
        String ugcVideoId = downloadBean2 != null ? downloadBean2.getUgcVideoId() : null;
        DownloadBean downloadBean3 = this.j;
        aVar2.c(a2, "subtitle onSetNewDataSource，ugcVideoId:" + ugcVideoId + " CollectionId:" + (downloadBean3 != null ? downloadBean3.getUgcVideoCollectionId() : null), true);
        this.h.h0(this.j);
        DownloadBean downloadBean4 = this.j;
        Intrinsics.e(downloadBean4);
        Q(downloadBean4);
    }

    public final void W(LongVodUiType longVodUiType) {
        Intrinsics.h(longVodUiType, "uiType");
        if (longVodUiType == LongVodUiType.LAND) {
            E();
        }
        int i = b.a[longVodUiType.ordinal()];
        this.h.O(i != 1 ? i != 2 ? LocalVideoUiType.MIDDLE : LocalVideoUiType.PORTRAIT : LocalVideoUiType.LAND);
    }

    public final void X(long j) {
        this.h.R(j);
    }

    public final void Y() {
        this.h.T();
    }

    public final void Z() {
        VideoSubtitleControl videoSubtitleControl = this.h;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.X();
        }
    }

    public final void e0(boolean z) {
        this.h.b0(z);
    }

    public final void f0(ViewGroup viewGroup) {
        this.n = viewGroup;
        a0(this.h);
    }

    public final void h0(List list) {
        Intrinsics.h(list, "dubs");
        this.c = list;
        this.h.p0(list);
    }

    public final void i0(long j) {
        this.h.q0(j);
    }

    public final void j0(float f) {
        this.h.r0(f);
    }
}
