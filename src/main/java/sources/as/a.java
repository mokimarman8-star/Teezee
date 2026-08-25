package as;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.utils.h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends t0 {
    private final b0 a = new b0();
    private final b0 b = new b0();
    private final b0 c = new b0();
    private final b0 d = new b0();
    private final b0 e = new b0();
    private String f;

    public final void b() {
        this.d.q((Object) null);
        this.e.q((Object) null);
        this.c.q(Boolean.valueOf(Intrinsics.c(h.a.d().getString("k_subtitle_language", BuildConfig.FLAVOR), "off")));
        this.f = null;
    }

    public final String c() {
        return this.f;
    }

    public final b0 d() {
        return this.d;
    }

    public final b0 e() {
        return this.e;
    }

    public final b0 f() {
        return this.c;
    }

    public final void g(String str) {
        this.f = str;
    }
}
