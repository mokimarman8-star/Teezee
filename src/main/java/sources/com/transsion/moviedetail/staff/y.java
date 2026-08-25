package com.transsion.moviedetail.staff;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import com.google.gson.JsonObject;
import com.transsion.moviedetail.staff.a;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.postdetail.bean.Pager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y extends t0 {
    private final b0 a = new b0();
    private final b0 b = new b0();
    private final b0 c = new b0();
    private final b0 d = new b0();
    private final b0 e = new b0();
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.staff.x
        public final Object invoke() {
            a x;
            x = y.x();
            return x;
        }
    });
    private int g = 1;
    private boolean h = true;
    private io.reactivex.rxjava3.disposables.c i;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            y.this.e.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffList movieStaffList) {
            super.c(movieStaffList);
            y.this.e.q(movieStaffList);
        }
    }

    public static final class b extends dg.a {
        b() {
        }

        public void a(String str, String str2) {
            y.this.a.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Staff staff) {
            super.c(staff);
            y.this.a.q(staff);
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            io.reactivex.rxjava3.disposables.c cVar;
            y.this.c.q((Object) null);
            io.reactivex.rxjava3.disposables.c cVar2 = y.this.i;
            if (cVar2 == null || cVar2.isDisposed() || (cVar = y.this.i) == null) {
                return;
            }
            cVar.dispose();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffSubjectList movieStaffSubjectList) {
            io.reactivex.rxjava3.disposables.c cVar;
            Pager pager;
            Boolean hasMore;
            super.c(movieStaffSubjectList);
            if (movieStaffSubjectList != null && (pager = movieStaffSubjectList.getPager()) != null && (hasMore = pager.getHasMore()) != null) {
                y.this.h = hasMore.booleanValue();
            }
            y.this.c.q(movieStaffSubjectList);
            if (movieStaffSubjectList != null) {
                y yVar = y.this;
                List list = (List) yVar.b.f();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(movieStaffSubjectList);
                yVar.b.q(list);
            }
            y.this.g++;
            io.reactivex.rxjava3.disposables.c cVar2 = y.this.i;
            if (cVar2 == null || cVar2.isDisposed() || (cVar = y.this.i) == null) {
                return;
            }
            cVar.dispose();
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            super.onSubscribe(cVar);
            y.this.i = cVar;
        }
    }

    static final class d implements yx.h {
        final /* synthetic */ JsonObject a;

        d(JsonObject jsonObject) {
            this.a = jsonObject;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JsonObject jsonObject) {
            Intrinsics.h(jsonObject, "it");
            RequestBody.Companion companion = RequestBody.Companion;
            String jsonElement = this.a.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.Companion.parse("application/json"));
        }
    }

    static final class e implements yx.h {
        e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody requestBody) {
            Intrinsics.h(requestBody, "it");
            return a.C0040a.d(y.this.r(), requestBody, null, 2, null);
        }
    }

    public static final class f extends dg.a {
        final /* synthetic */ int e;

        f(int i) {
            this.e = i;
        }

        public void a(String str, String str2) {
            y.this.d.q(-1);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            y.this.d.q(Integer.valueOf(this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.moviedetail.staff.a r() {
        return (com.transsion.moviedetail.staff.a) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.moviedetail.staff.a x() {
        return (com.transsion.moviedetail.staff.a) kg.c.e.a().h(com.transsion.moviedetail.staff.a.class);
    }

    public final void n() {
        this.c.q((Object) null);
    }

    public final void o(String str) {
        if (str == null) {
            return;
        }
        a.C0040a.b(r(), str, null, 2, null).f(dg.d.a.c()).subscribe(new a());
    }

    public final void p(String str) {
        if (str == null) {
            return;
        }
        a.C0040a.a(r(), str, null, 2, null).f(dg.d.a.c()).subscribe(new b());
    }

    public final void q(String str, int i) {
        if (str == null || !this.h) {
            return;
        }
        io.reactivex.rxjava3.disposables.c cVar = this.i;
        if (cVar == null || cVar.isDisposed()) {
            int i2 = this.g;
            int i3 = 1;
            if (i2 > 1) {
                i3 = i + 1 + ((i2 - 2) * 60);
                i = i3 + 59;
            }
            a.C0040a.c(r(), str, i3, i, 1, null, 16, null).f(dg.d.a.c()).subscribe(new c());
        }
    }

    public final LiveData s() {
        return this.e;
    }

    public final LiveData t() {
        return this.a;
    }

    public final LiveData u() {
        return this.b;
    }

    public final LiveData v() {
        return this.c;
    }

    public final LiveData w() {
        return this.d;
    }

    public final void y(String str, int i) {
        if (str == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("staffId", str);
        jsonObject.addProperty("action", Integer.valueOf(i));
        io.reactivex.rxjava3.core.j.t(jsonObject).u(new d(jsonObject)).n(new e()).f(dg.d.a.c()).subscribe(new f(i));
    }
}
