package com.transsion.room.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomNet;
import com.transsion.room.R$string;
import com.transsion.room.bean.CheckInEntity;
import ip.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomDetailViewModel extends t0 {
    public static final a f = new a(null);
    private final Lazy a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.room.viewmodel.e
        public final Object invoke() {
            ip.a D;
            D = RoomDetailViewModel.D();
            return D;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.f
        public final Object invoke() {
            aj.a A;
            A = RoomDetailViewModel.A();
            return A;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.g
        public final Object invoke() {
            b0 B;
            B = RoomDetailViewModel.B();
            return B;
        }
    });
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.h
        public final Object invoke() {
            b0 y;
            y = RoomDetailViewModel.y();
            return y;
        }
    });
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.i
        public final Object invoke() {
            b0 z;
            z = RoomDetailViewModel.z();
            return z;
        }
    });

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
            RoomDetailViewModel.this.r().q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomItem roomItem) {
            RoomDetailViewModel.this.r().q(roomItem);
        }
    }

    public static final class c extends dg.a {
        final /* synthetic */ String d;
        final /* synthetic */ RoomDetailViewModel e;

        c(String str, RoomDetailViewModel roomDetailViewModel) {
            this.d = str;
            this.e = roomDetailViewModel;
        }

        public void a(String str, String str2) {
            this.e.m().q((Object) null);
            fh.b.a.d(R$string.join_room_fail);
            a.a.f(wf.a.a, "RoomModel", "onFailure message.." + str2, false, 4, (Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            fh.b.a.d(R$string.join_room_success);
            gx.b.a.a().f(1, this.d);
            this.e.m().q(new RoomNet("success"));
            a.a.f(wf.a.a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, (Object) null);
        }
    }

    public static final class d extends dg.a {
        final /* synthetic */ String d;
        final /* synthetic */ RoomDetailViewModel e;

        d(String str, RoomDetailViewModel roomDetailViewModel) {
            this.d = str;
            this.e = roomDetailViewModel;
        }

        public void a(String str, String str2) {
            this.e.n().q((Object) null);
            a.a.f(wf.a.a, "RoomModel", "checkOutRoom onFailure message.." + str2, false, 4, (Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            gx.b.a.a().f(0, this.d);
            this.e.n().q(new RoomNet("success"));
            a.a.f(wf.a.a, "RoomModel", "checkOutRoom onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final aj.a A() {
        Application a2 = Utils.a();
        if (a2 != null) {
            return AppDatabase.p.b(a2).v1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 B() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ip.a D() {
        return (ip.a) kg.c.e.a().h(ip.a.class);
    }

    private final RequestBody l(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 m() {
        return (b0) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 n() {
        return (b0) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final aj.a o() {
        return (aj.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 r() {
        return (b0) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ip.a u() {
        return (ip.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 y() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 z() {
        return new b0();
    }

    public final void C(String str) {
        Intrinsics.h(str, "groupId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomDetailViewModel$roomVisit$1(str, this, null), 3, (Object) null);
    }

    public final void p(String str) {
        Intrinsics.h(str, "groupId");
        a.C0077a.b(u(), gg.a.a.a(), str, 0, 4, null).f(dg.d.a.c()).subscribe(new b());
    }

    public final LiveData q() {
        return r();
    }

    public final LiveData s() {
        return m();
    }

    public final LiveData t() {
        return n();
    }

    public final void v(RoomItem roomItem) {
        Intrinsics.h(roomItem, "roomItem");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RoomDetailViewModel$insertRecentlyRoom$1(roomItem, this, null), 3, (Object) null);
    }

    public final void w(String str) {
        Intrinsics.h(str, "groupId");
        ip.a u = u();
        String a2 = gg.a.a.a();
        String j = com.blankj.utilcode.util.o.j(new CheckInEntity(str));
        Intrinsics.g(j, "toJson(...)");
        u.i(a2, l(j)).f(dg.d.a.c()).subscribe(new c(str, this));
    }

    public final void x(String str) {
        Intrinsics.h(str, "groupId");
        ip.a u = u();
        String a2 = gg.a.a.a();
        String j = com.blankj.utilcode.util.o.j(new CheckInEntity(str));
        Intrinsics.g(j, "toJson(...)");
        u.k(a2, l(j)).f(dg.d.a.c()).subscribe(new d(str, this));
    }
}
