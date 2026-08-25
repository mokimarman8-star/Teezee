package com.transsion.room.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import com.transsion.flow.bean.RoomNet;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.room.bean.CreateRoomRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a d = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.a
        public final Object invoke() {
            b0 m;
            m = d.m();
            return m;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.b
        public final Object invoke() {
            b0 f;
            f = d.f();
            return f;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.c
        public final Object invoke() {
            ip.a n;
            n = d.n();
            return n;
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
            d.this.h().q((Object) null);
            a.a.f(wf.a.a, "RoomModel", "onFailure message.." + str2, false, 4, (Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(CheckNameBean checkNameBean) {
            d.this.h().q(checkNameBean);
            a.a.f(wf.a.a, "RoomModel", "onSuccess groupId.." + (checkNameBean != null ? checkNameBean.getGroupId() : null), false, 4, (Object) null);
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            d.this.k().q((Object) null);
            a.a.f(wf.a.a, "RoomModel", "onFailure message.." + str2, false, 4, (Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            d.this.k().q(roomNet);
            a.a.f(wf.a.a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, (Object) null);
        }
    }

    /* renamed from: com.transsion.room.viewmodel.d$d, reason: collision with other inner class name */
    public static final class C0055d extends dg.a {
        C0055d() {
        }

        public void a(String str, String str2) {
            d.this.k().q((Object) null);
            a.a.f(wf.a.a, "RoomModel", "onFailure message.." + str2, false, 4, (Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            d.this.k().q(new RoomNet("update"));
            a.a.f(wf.a.a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 f() {
        return new b0();
    }

    private final RequestBody i(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 k() {
        return (b0) this.a.getValue();
    }

    private final ip.a l() {
        return (ip.a) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 m() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ip.a n() {
        return (ip.a) kg.c.e.a().h(ip.a.class);
    }

    public final void e(String str) {
        Intrinsics.h(str, "name");
        l().e(gg.a.a.a(), str).f(dg.d.a.c()).subscribe(new b());
    }

    public final void g(String str, String str2, String str3, String str4) {
        Intrinsics.h(str, "name");
        Intrinsics.h(str2, "avator");
        Intrinsics.h(str3, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity(BuildConfig.FLAVOR, str, str2, str3, str4);
        ip.a l = l();
        String a2 = gg.a.a.a();
        String j = com.blankj.utilcode.util.o.j(createRoomRequestEntity);
        Intrinsics.g(j, "toJson(...)");
        l.g(a2, i(j)).f(dg.d.a.c()).subscribe(new c());
    }

    public final b0 h() {
        return (b0) this.b.getValue();
    }

    public final LiveData j() {
        return k();
    }

    public final void o(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.h(str, "groupId");
        Intrinsics.h(str2, "name");
        Intrinsics.h(str3, "avator");
        Intrinsics.h(str4, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity(str, str2, str3, str4, str5);
        ip.a l = l();
        String a2 = gg.a.a.a();
        String j = com.blankj.utilcode.util.o.j(createRoomRequestEntity);
        Intrinsics.g(j, "toJson(...)");
        l.b(a2, i(j)).f(dg.d.a.c()).subscribe(new C0055d());
    }
}
