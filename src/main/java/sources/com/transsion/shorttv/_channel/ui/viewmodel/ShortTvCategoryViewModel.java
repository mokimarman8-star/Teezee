package com.transsion.shorttv._channel.ui.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.shorttv._channel.model.ShortTvCategoryBean;
import com.transsion.shorttv._channel.model.ShortTvCategoryItemBean;
import com.transsion.shorttv.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvCategoryViewModel extends androidx.lifecycle.b {
    private int b;
    private int c;
    private final Lazy d;
    private final Lazy e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvCategoryViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = 1;
        this.c = 10;
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.a
            public final Object invoke() {
                rq.a n;
                n = ShortTvCategoryViewModel.n();
                return n;
            }
        });
        this.e = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.b
            public final Object invoke() {
                b0 h;
                h = ShortTvCategoryViewModel.h();
                return h;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 h() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rq.a l() {
        return (rq.a) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ShortTvCategoryBean shortTvCategoryBean) {
        List<ShortTvCategoryItemBean> list;
        if (shortTvCategoryBean == null || (list = shortTvCategoryBean.getList()) == null) {
            return;
        }
        for (ShortTvCategoryItemBean shortTvCategoryItemBean : list) {
            Subject subject = shortTvCategoryItemBean.getSubject();
            String ops = subject != null ? subject.getOps() : null;
            if (ops == null || ops.length() == 0) {
                Subject subject2 = shortTvCategoryItemBean.getSubject();
                if (subject2 != null) {
                    subject2.setOps(shortTvCategoryBean.getOps());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rq.a n() {
        return (rq.a) kg.c.e.a().h(rq.a.class);
    }

    public final void i(String str) {
        Intrinsics.h(str, "type");
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new ShortTvCategoryViewModel$getCategoryList$1(str, this, null), 2, (Object) null);
    }

    public final b0 j() {
        return (b0) this.e.getValue();
    }

    public final int k() {
        return this.b;
    }

    public final void o(int i) {
        this.b = i;
    }
}
