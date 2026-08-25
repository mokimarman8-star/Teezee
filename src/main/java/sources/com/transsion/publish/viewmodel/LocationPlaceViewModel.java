package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.place.PlaceDao;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocationPlaceViewModel extends t0 {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.a
        public final Object invoke() {
            po.a q;
            q = LocationPlaceViewModel.q();
            return q;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.b
        public final Object invoke() {
            PlaceDao p;
            p = LocationPlaceViewModel.p();
            return p;
        }
    });
    private final b0 c = new b0();
    private final b0 d = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaceDao m() {
        return (PlaceDao) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final po.a n() {
        return (po.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaceDao p() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final po.a q() {
        return (po.a) kg.c.e.a().h(po.a.class);
    }

    public final void h() {
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new LocationPlaceViewModel$clearCache$1(this, null), 2, (Object) null);
    }

    public final void i() {
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceViewModel$getCache$1(this, null), 3, (Object) null);
    }

    public final b0 j() {
        return this.d;
    }

    public final void k(Double d, Double d2) {
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceViewModel$getLocationPlaceList$1(this, d, d2, null), 3, (Object) null);
    }

    public final b0 l() {
        return this.c;
    }

    public final void o(List list) {
        Intrinsics.h(list, "list");
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new LocationPlaceViewModel$insertCache$1(list, this, null), 2, (Object) null);
    }
}
