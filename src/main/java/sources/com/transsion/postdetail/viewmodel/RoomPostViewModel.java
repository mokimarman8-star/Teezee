package com.transsion.postdetail.viewmodel;

import android.content.Context;
import android.location.Address;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomPostViewModel extends t0 {
    public static final a o = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.n
        public final Object invoke() {
            ao.c X;
            X = RoomPostViewModel.X();
            return X;
        }
    });
    private final Lazy b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.o
        public final Object invoke() {
            tm.a t;
            t = RoomPostViewModel.t();
            return t;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.p
        public final Object invoke() {
            bo.a s;
            s = RoomPostViewModel.s();
            return s;
        }
    });
    private final b0 d = new b0();
    private final b0 e = new b0();
    private final b0 f = new b0();
    private final b0 g = new b0();
    private final b0 h = new b0();
    private final b0 i = new b0();
    private final b0 j = new b0();
    private final b0 k = new b0();
    private final b0 l = new b0();
    private final b0 m = new b0();
    private long n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void J(RoomPostViewModel roomPostViewModel, boolean z, boolean z2, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = 9;
        }
        roomPostViewModel.I(z, z2, str, str2, str3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.c M() {
        return (ao.c) this.a.getValue();
    }

    public static /* synthetic */ void P(RoomPostViewModel roomPostViewModel, boolean z, boolean z2, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = 9;
        }
        roomPostViewModel.O(z, z2, str, str2, str3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.c X() {
        return (ao.c) kg.c.e.a().h(ao.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bo.a s() {
        return new bo.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tm.a t() {
        return (tm.a) kg.c.e.a().h(tm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final bo.a v() {
        return (bo.a) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tm.a w() {
        return (tm.a) this.b.getValue();
    }

    public final b0 A() {
        return this.f;
    }

    public final b0 B() {
        return this.h;
    }

    public final b0 C() {
        return this.g;
    }

    public final void D(Context context, boolean z, boolean z2, String str, int i, String str2) {
        Intrinsics.h(context, "context");
        S();
        if (z) {
            T();
            U();
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getPostExplore$1(z, z2, this, str, i, str2, null), 3, (Object) null);
    }

    public final void E(boolean z, String str, int i, String str2) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$getPostExploreMoreCache$1(this, str, i, str2, z, null), 2, (Object) null);
    }

    public final void F(boolean z, String str, int i, double d, double d2) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$getPostNearby$1(this, str, i, d2, d, z, null), 2, (Object) null);
    }

    public final void G(boolean z, String str, String str2, int i, String str3, boolean z2) {
        Intrinsics.h(str3, "sortType");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getPostNewest$1(this, str, str2, i, str3, z2, z, null), 3, (Object) null);
    }

    public final void H(boolean z, String str, String str2, int i, boolean z2) {
        Intrinsics.h(str, "groupId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getPostPopular$1(this, str, str2, i, z2, z, null), 3, (Object) null);
    }

    public final void I(boolean z, boolean z2, String str, String str2, String str3, int i) {
        Intrinsics.h(str, "tabId");
        if (z) {
            V(str);
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getPostSubPageList$1(z, str, z2, this, str2, i, str3, null), 3, (Object) null);
    }

    public final void K(double d, double d2, Address address) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getRecommendRooms$1(this, d, d2, address, null), 3, (Object) null);
    }

    public final b0 L() {
        return this.j;
    }

    public final b0 N() {
        return this.m;
    }

    public final void O(boolean z, boolean z2, String str, String str2, String str3, int i) {
        Intrinsics.h(str, "tabId");
        if (z) {
            W(str);
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$getStaggeredPostPageList$1(z, str, z2, this, str2, i, str3, null), 3, (Object) null);
    }

    public final b0 Q() {
        return this.l;
    }

    public final void R(String str, int i) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$like$1(str, i, this, null), 3, (Object) null);
    }

    public final void S() {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$loadPostExploreActiveSaveCache$1(this, null), 2, (Object) null);
    }

    public final void T() {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$loadPostExploreBuiltInCache$1(this, null), 2, (Object) null);
    }

    public final void U() {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$loadPostExploreNetCache$1(this, null), 2, (Object) null);
    }

    public final void V(String str) {
        Intrinsics.h(str, "tabId");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$loadPostSubPageCache$1(str, this, null), 2, (Object) null);
    }

    public final void W(String str) {
        Intrinsics.h(str, "tabId");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomPostViewModel$loadStaggeredPostPageCache$1(str, this, null), 2, (Object) null);
    }

    public final void u(String str) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomPostViewModel$deletePost$1(str, this, null), 3, (Object) null);
    }

    public final b0 x() {
        return this.i;
    }

    public final b0 y() {
        return this.d;
    }

    public final b0 z() {
        return this.e;
    }
}
