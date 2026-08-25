package com.transsion.postdetail.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailViewModel extends t0 {
    private VideoDataLoader d;
    private VideoImmersiveDataLoaderV2 e;
    private final String a = "PostDetailViewModel";
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.d
        public final Object invoke() {
            ao.b L;
            L = PostDetailViewModel.L();
            return L;
        }
    });
    private final Lazy c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.e
        public final Object invoke() {
            tm.a p;
            p = PostDetailViewModel.p();
            return p;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.f
        public final Object invoke() {
            b0 J;
            J = PostDetailViewModel.J();
            return J;
        }
    });
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.g
        public final Object invoke() {
            b0 I;
            I = PostDetailViewModel.I();
            return I;
        }
    });
    private final Lazy h = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.h
        public final Object invoke() {
            b0 E;
            E = PostDetailViewModel.E();
            return E;
        }
    });
    private final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.i
        public final Object invoke() {
            b0 H;
            H = PostDetailViewModel.H();
            return H;
        }
    });
    private final Lazy j = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.j
        public final Object invoke() {
            b0 q;
            q = PostDetailViewModel.q();
            return q;
        }
    });
    private final Lazy k = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.k
        public final Object invoke() {
            b0 K;
            K = PostDetailViewModel.K();
            return K;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b D() {
        return (ao.b) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 E() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 H() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 I() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 J() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 K() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b L() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tm.a p() {
        return (tm.a) kg.c.e.a().h(tm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 q() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tm.a s() {
        return (tm.a) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 w() {
        return (b0) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 z() {
        return (b0) this.f.getValue();
    }

    public final LiveData A() {
        return z();
    }

    public final PostSubjectBean B() {
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.e;
        if (videoImmersiveDataLoaderV2 != null) {
            return (PostSubjectBean) videoImmersiveDataLoaderV2.a();
        }
        return null;
    }

    public final b0 C() {
        return (b0) this.k.getValue();
    }

    public final void F(Integer num, String str) {
        List list;
        am.b bVar;
        Object obj;
        Object obj2 = null;
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
                    if (((am.b) obj) instanceof VideoDataLoader) {
                        break;
                    }
                }
            }
            bVar = (am.b) obj;
        } else {
            bVar = null;
        }
        VideoDataLoader videoDataLoader = (VideoDataLoader) bVar;
        if (videoDataLoader == null) {
            videoDataLoader = new VideoDataLoader(null, 1, null);
        }
        this.d = videoDataLoader;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((am.b) next) instanceof VideoImmersiveDataLoaderV2) {
                    obj2 = next;
                    break;
                }
            }
            obj2 = (am.b) obj2;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = (VideoImmersiveDataLoaderV2) obj2;
        if (videoImmersiveDataLoaderV2 == null) {
            videoImmersiveDataLoaderV2 = new VideoImmersiveDataLoaderV2(str, null, null, 0, 14, null);
        }
        this.e = videoImmersiveDataLoaderV2;
    }

    public void G(String str, int i) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostDetailViewModel$like$1(str, i, this, null), 3, (Object) null);
    }

    public final void r(String str) {
        Intrinsics.h(str, "postId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostDetailViewModel$deletePost$1(str, this, null), 3, (Object) null);
    }

    public final b0 t() {
        return (b0) this.j.getValue();
    }

    public final void u(String str, int i, String str2, int i2, boolean z, int i3) {
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "nextPage");
        if (!z) {
            kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostDetailViewModel$getImmVideoList$1(this, str, null), 3, (Object) null);
            return;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.e;
        if (videoImmersiveDataLoaderV2 != null) {
            videoImmersiveDataLoaderV2.u(str);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV22 = this.e;
        if (videoImmersiveDataLoaderV22 != null) {
            videoImmersiveDataLoaderV22.s(str2);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV23 = this.e;
        if (videoImmersiveDataLoaderV23 != null) {
            videoImmersiveDataLoaderV23.t(i2);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV24 = this.e;
        if (videoImmersiveDataLoaderV24 != null) {
            videoImmersiveDataLoaderV24.f(w());
        }
    }

    public final LiveData v() {
        return w();
    }

    public final void x(String str) {
        Intrinsics.h(str, "postId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostDetailViewModel$getPostDetail$1(this, str, null), 3, (Object) null);
    }

    public final b0 y() {
        return (b0) this.g.getValue();
    }
}
