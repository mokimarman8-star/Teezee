package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.u0;
import com.transsion.flow.bean.CategoryItemBean;
import com.transsion.home.bean.CategoryBean;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CategoryViewModel extends androidx.lifecycle.b {
    private int b;
    private int c;
    private final Lazy d;
    private final Lazy e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = 1;
        this.c = 10;
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.a
            public final Object invoke() {
                yk.b n;
                n = CategoryViewModel.n();
                return n;
            }
        });
        this.e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.b
            public final Object invoke() {
                androidx.lifecycle.b0 h;
                h = CategoryViewModel.h();
                return h;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 h() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yk.b l() {
        return (yk.b) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(CategoryBean categoryBean) {
        List<CategoryItemBean> list;
        if (categoryBean == null || (list = categoryBean.getList()) == null) {
            return;
        }
        for (CategoryItemBean categoryItemBean : list) {
            Subject subject = categoryItemBean.getSubject();
            String ops = subject != null ? subject.getOps() : null;
            if (ops == null || ops.length() == 0) {
                Subject subject2 = categoryItemBean.getSubject();
                if (subject2 != null) {
                    subject2.setOps(categoryBean.getOps());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yk.b n() {
        return (yk.b) kg.c.e.a().h(yk.b.class);
    }

    public final void i(String str) {
        Intrinsics.h(str, "type");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new CategoryViewModel$getCategoryList$1(str, this, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 j() {
        return (androidx.lifecycle.b0) this.e.getValue();
    }

    public final int k() {
        return this.b;
    }

    public final void o(int i) {
        this.b = i;
    }
}
