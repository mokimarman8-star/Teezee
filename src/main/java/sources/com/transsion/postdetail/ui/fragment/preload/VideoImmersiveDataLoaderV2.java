package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.b0;
import com.transsion.push.bean.MsgStyle;
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
public final class VideoImmersiveDataLoaderV2 extends am.b {
    private String f;
    private String g;
    private String h;
    private int i;
    private final Lazy j;

    public VideoImmersiveDataLoaderV2(String str, String str2, String str3, int i) {
        Intrinsics.h(str2, "postId");
        Intrinsics.h(str3, "page");
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = i;
        this.j = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.d
            public final Object invoke() {
                ao.b r;
                r = VideoImmersiveDataLoaderV2.r();
                return r;
            }
        });
    }

    public /* synthetic */ VideoImmersiveDataLoaderV2(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "0" : str2, (i2 & 4) != 0 ? MsgStyle.CUSTOM_LEFT_PIC : str3, (i2 & 8) != 0 ? 5 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b q() {
        return (ao.b) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b r() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        j(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new VideoImmersiveDataLoaderV2$loadDataFromService$1(this, null), 3, (Object) null));
    }

    public final String m() {
        return this.h;
    }

    public final String n() {
        return this.f;
    }

    public final int o() {
        return this.i;
    }

    public final String p() {
        return this.g;
    }

    public final void s(String str) {
        Intrinsics.h(str, "<set-?>");
        this.h = str;
    }

    public final void t(int i) {
        this.i = i;
    }

    public final void u(String str) {
        Intrinsics.h(str, "<set-?>");
        this.g = str;
    }
}
