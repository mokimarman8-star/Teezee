package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilterViewModel extends androidx.lifecycle.b {
    public static final a f = new a(null);
    public static final int g = 8;
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;
    private final yk.c e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilterViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.z
            public final Object invoke() {
                androidx.lifecycle.b0 g2;
                g2 = UGCFilterViewModel.g();
                return g2;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.a0
            public final Object invoke() {
                androidx.lifecycle.b0 q;
                q = UGCFilterViewModel.q();
                return q;
            }
        });
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.b0
            public final Object invoke() {
                androidx.lifecycle.b0 p;
                p = UGCFilterViewModel.p();
                return p;
            }
        });
        this.e = (yk.c) kg.c.e.a().h(yk.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 g() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 p() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 q() {
        return new androidx.lifecycle.b0();
    }

    public final UGCFilterItem h(String str) {
        UGCFilterResponse uGCFilterResponse;
        BaseDto baseDto = (BaseDto) k().f();
        Object obj = null;
        List<UGCFilterItem> items = (baseDto == null || (uGCFilterResponse = (UGCFilterResponse) baseDto.getData()) == null) ? null : uGCFilterResponse.getItems();
        if (items == null) {
            return null;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.c(((UGCFilterItem) next).getCategoryId(), str)) {
                obj = next;
                break;
            }
        }
        return (UGCFilterItem) obj;
    }

    public final void i(String str) {
        Intrinsics.h(str, "category");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UGCFilterViewModel$getFilterItems$1(str, this, null), 2, (Object) null);
    }

    public final LiveData j() {
        return k();
    }

    public final androidx.lifecycle.b0 k() {
        return (androidx.lifecycle.b0) this.b.getValue();
    }

    public final androidx.lifecycle.b0 l() {
        return (androidx.lifecycle.b0) this.d.getValue();
    }

    public final void m(String str, int i, int i2, String str2, Integer num, Integer num2, Integer num3, String str3, boolean z) {
        Intrinsics.h(str, "category");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UGCFilterViewModel$getUGCContentList$1(str.length() == 0 ? "Education" : str, i, str2, num, num2, num3, z, this, i2, str3, null), 2, (Object) null);
    }

    public final LiveData n() {
        return o();
    }

    public final androidx.lifecycle.b0 o() {
        return (androidx.lifecycle.b0) this.c.getValue();
    }
}
