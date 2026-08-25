package ih;

import android.app.Application;
import com.tn.lib.widget.toast.core.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b$a {
    private b$a() {
    }

    public /* synthetic */ b$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final b a() {
        return (b) b.f().getValue();
    }

    public final void b(Application application) {
        Intrinsics.h(application, "application");
        h.c(h.a, application, null, 2, null);
    }
}
