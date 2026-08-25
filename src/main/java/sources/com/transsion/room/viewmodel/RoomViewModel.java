package com.transsion.room.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomTabBean;
import com.transsion.push.bean.MsgStyle;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import okio.Okio;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomViewModel extends androidx.lifecycle.b {
    public static final a l = new a(null);
    private final Lazy b;
    private final Lazy c;
    private final b0 d;
    private final b0 e;
    private final Lazy f;
    private final b0 g;
    private final b0 h;
    private final b0 i;
    private final b0 j;
    private final Lazy k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends dg.a {
        b() {
        }

        public void a(String str, String str2) {
            RoomViewModel.this.y().q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.y().q(roomBean);
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            RoomViewModel.this.D().q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.D().q(roomBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.m
            public final Object invoke() {
                b0 L;
                L = RoomViewModel.L();
                return L;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.n
            public final Object invoke() {
                b0 O;
                O = RoomViewModel.O();
                return O;
            }
        });
        this.d = new b0();
        this.e = new b0();
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.o
            public final Object invoke() {
                qp.a r;
                r = RoomViewModel.r();
                return r;
            }
        });
        this.g = new b0();
        this.h = new b0();
        this.i = new b0();
        this.j = new b0();
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.p
            public final Object invoke() {
                ip.a Q;
                Q = RoomViewModel.Q();
                return Q;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 D() {
        return (b0) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ip.a K() {
        return (ip.a) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 L() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M() {
        try {
            InputStream open = Utils.a().getAssets().open("room_top_tab.json");
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    private final void N() {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RoomViewModel$loadRoomTabCache$1(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 O() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(RoomTabBean roomTabBean) {
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            bVar.b().putString("k_room_tab_cache_version", roomTabBean.getVersion());
            Result.constructor-impl(bVar.b().putString("k_room_tab_cache", com.blankj.utilcode.util.o.j(roomTabBean)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ip.a Q() {
        return (ip.a) kg.c.e.a().h(ip.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qp.a r() {
        return new qp.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qp.a s() {
        return (qp.a) this.f.getValue();
    }

    public static /* synthetic */ void u(RoomViewModel roomViewModel, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        if ((i2 & 4) != 0) {
            i = 16;
        }
        roomViewModel.t(context, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 y() {
        return (b0) this.b.getValue();
    }

    public final b0 A() {
        return this.e;
    }

    public final void B(String str, int i, String str2) {
        Intrinsics.h(str, "page");
        if (str2 != null) {
            K().o(gg.a.a.a(), str, i, str2).f(dg.d.a.c()).subscribe(new c());
        }
    }

    public final LiveData C() {
        return D();
    }

    public final void E() {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomViewModel$getRoomFilterTabList$1(this, null), 3, (Object) null);
    }

    public final void F(boolean z, int i, String str, int i2, Double d, Double d2, Address address) {
        Intrinsics.h(str, "page");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomViewModel$getRoomList$1(d2, d, address, str, i2, i, this, z, null), 3, (Object) null);
    }

    public final b0 G() {
        return this.d;
    }

    public final void H() {
        N();
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomViewModel$getRoomTabs$1(this, null), 3, (Object) null);
    }

    public final b0 I() {
        return this.h;
    }

    public final b0 J() {
        return this.i;
    }

    public final void t(Context context, String str, int i) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "page");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomViewModel$getCommunityRooms$1(this, context, str, i, null), 3, (Object) null);
    }

    public final b0 v() {
        return this.j;
    }

    public final void w(String str, int i) {
        Intrinsics.h(str, "page");
        K().f(gg.a.a.a(), str, i).f(dg.d.a.c()).subscribe(new b());
    }

    public final LiveData x() {
        return y();
    }

    public final void z(boolean z, String str, int i, String str2) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomViewModel$getMyRooms$1(this, str, i, str2, z, null), 3, (Object) null);
    }
}
