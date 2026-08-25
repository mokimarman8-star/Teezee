package ih;

import com.tn.lib.widget.R;
import com.tn.lib.widget.toast.core.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b implements fh.a {
    public static final a a = new a((DefaultConstructorMarker) null);
    private static final Lazy b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: ih.a
        public final Object invoke() {
            b h;
            h = b.h();
            return h;
        }
    });

    private final void g(CharSequence charSequence, int i, int i2, int i3, int i4, int i6) {
        if (i6 != 0) {
            h.a.j(i6);
        } else {
            h.a.j(R.layout.libui_common_toast_layout);
        }
        if (i2 != 0 || i3 != 0 || i4 != 0) {
            h.a.f(i2, i3, i4);
        }
        if (i != 0) {
            h.a.k(i);
        } else {
            h.a.l(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b h() {
        return new b();
    }

    public void a(int i) {
        g("", i, 0, 0, 0, 0);
    }

    public void b(CharSequence charSequence) {
        g(charSequence, 0, 0, 0, 0, 0);
    }

    public void c(int i, CharSequence charSequence, int i2, int i3, int i4) {
        Intrinsics.h(charSequence, "text");
        g(charSequence, 0, i2, i3, i4, i);
    }

    public void d(CharSequence charSequence, int i) {
        g(charSequence, 0, i, 0, 0, 0);
    }
}
