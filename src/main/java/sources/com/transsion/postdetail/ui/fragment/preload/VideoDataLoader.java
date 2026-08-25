package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.b0;
import com.transsion.gslb.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoDataLoader extends am.b {
    private String f;
    private final Lazy g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoDataLoader() {
        this(r0, 1, r0);
        String str = null;
    }

    public VideoDataLoader(String str) {
        Intrinsics.h(str, "postId");
        this.f = str;
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.b
            public final Object invoke() {
                ao.b o;
                o = VideoDataLoader.o();
                return o;
            }
        });
    }

    public /* synthetic */ VideoDataLoader(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildConfig.FLAVOR : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b n() {
        return (ao.b) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b o() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        j(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new VideoDataLoader$loadDataFromService$1(this, null), 3, (Object) null));
    }

    public final String m() {
        return this.f;
    }

    public final void p(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f = str;
    }
}
