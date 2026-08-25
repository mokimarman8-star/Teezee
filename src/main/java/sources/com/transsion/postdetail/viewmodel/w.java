package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w extends t0 {
    private ShortTvVideoImmersiveDataLoader d;
    private final String a = "ShortTvDetailViewModel";
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.q
        public final Object invoke() {
            ao.b t;
            t = w.t();
            return t;
        }
    });
    private final Lazy c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.r
        public final Object invoke() {
            tm.a h;
            h = w.h();
            return h;
        }
    });
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.s
        public final Object invoke() {
            b0 p;
            p = w.p();
            return p;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.t
        public final Object invoke() {
            b0 r;
            r = w.r();
            return r;
        }
    });
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.u
        public final Object invoke() {
            b0 i;
            i = w.i();
            return i;
        }
    });
    private final Lazy h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.v
        public final Object invoke() {
            b0 s;
            s = w.s();
            return s;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final tm.a h() {
        return (tm.a) kg.c.e.a().h(tm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 i() {
        return new b0();
    }

    private final b0 m() {
        return (b0) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 p() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 r() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 s() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b t() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    public final b0 j() {
        return (b0) this.g.getValue();
    }

    public final void k(String str, int i, String str2, int i2, int i3) {
        String str3;
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(str2);
        immVideoRequestEntity.setPerPage(i2);
        immVideoRequestEntity.setSessionId(jg.b.a.h());
        Uri b = com.transsion.baselib.report.h.a.b();
        if (b == null || (str3 = b.toString()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        immVideoRequestEntity.setDeepLink(str3);
        immVideoRequestEntity.setUserPrefer(BuildConfig.FLAVOR);
        immVideoRequestEntity.setLatest_events(new ej.a(ej.b.a.e()));
        if (str.length() == 0) {
            str = "0";
        }
        immVideoRequestEntity.setPostId(str);
        immVideoRequestEntity.setTabId(i);
        immVideoRequestEntity.setImmersiveRecType(i3);
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.d;
        if (shortTvVideoImmersiveDataLoader != null) {
            shortTvVideoImmersiveDataLoader.r(immVideoRequestEntity);
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader2 = this.d;
        if (shortTvVideoImmersiveDataLoader2 != null) {
            shortTvVideoImmersiveDataLoader2.f(m());
        }
    }

    public final LiveData l() {
        return m();
    }

    public final ShortTVRespData n() {
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.d;
        if (shortTvVideoImmersiveDataLoader != null) {
            return (ShortTVRespData) shortTvVideoImmersiveDataLoader.a();
        }
        return null;
    }

    public final b0 o() {
        return (b0) this.h.getValue();
    }

    public final void q(Integer num) {
        List list;
        am.b bVar;
        Object obj;
        if (num != null) {
            list = am.e.a.a(num.intValue());
        } else {
            list = null;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((am.b) obj) instanceof ShortTvVideoImmersiveDataLoader) {
                        break;
                    }
                }
            }
            bVar = (am.b) obj;
        } else {
            bVar = null;
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = (ShortTvVideoImmersiveDataLoader) bVar;
        if (shortTvVideoImmersiveDataLoader == null) {
            shortTvVideoImmersiveDataLoader = new ShortTvVideoImmersiveDataLoader(null, 1, null);
        }
        this.d = shortTvVideoImmersiveDataLoader;
    }
}
