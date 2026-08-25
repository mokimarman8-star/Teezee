package lv;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import com.therouter.TheRouter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends androidx.lifecycle.b {
    private final Lazy b;
    private final Lazy c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: lv.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 e;
                e = c.e();
                return e;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: lv.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qx.a h;
                h = c.h();
                return h;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 e() {
        return new b0();
    }

    private final b0 g() {
        return (b0) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a h() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    public final LiveData f() {
        return g();
    }

    protected void onCleared() {
        super/*androidx.lifecycle.t0*/.onCleared();
    }
}
