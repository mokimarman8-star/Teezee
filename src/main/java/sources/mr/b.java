package mr;

import android.app.Application;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.toast.core.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements jr.a {
    public static final a a = new a(null);
    private static final Lazy b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: mr.a
        public final Object invoke() {
            b f;
            f = b.f();
            return f;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return (b) b.b.getValue();
        }

        public final void b(Application application) {
            Intrinsics.h(application, "application");
            h.b(h.a, application, null, 2, null);
        }
    }

    private final void e(CharSequence charSequence, int i, int i2, int i3, int i4, int i5) {
        if (i5 != 0) {
            h.a.g(i5);
        } else {
            h.a.g(R.layout.short_tv_base_common_toast_layout);
        }
        if (i2 != 0 || i3 != 0 || i4 != 0) {
            h.a.c(i2, i3, i4);
        }
        if (i != 0) {
            h.a.h(i);
        } else {
            h.a.i(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b f() {
        return new b();
    }

    @Override // jr.a
    public void a(int i) {
        e(BuildConfig.FLAVOR, i, 0, 0, 0, 0);
    }

    @Override // jr.a
    public void b(CharSequence charSequence) {
        e(charSequence, 0, 0, 0, 0, 0);
    }
}
