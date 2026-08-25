package ax;

import cm.f;
import com.hisavana.common.constant.ComConstants;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b {
    private final String a = "GET";
    private int b = ComConstants.defScheduleTime;
    private int c = ComConstants.defScheduleTime;
    private int d = 1;
    private int e = ((DownloadExecutor.a.a() / 2) + 2) / this.d;
    private int f = 3;
    private int g = 5;
    private final Lazy h = LazyKt.b(new Function0() { // from class: ax.a
        public final Object invoke() {
            long h;
            h = b.h();
            return Long.valueOf(h);
        }
    });
    private final int i = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h() {
        Long x;
        ConfigBean c = f.c.a().c("downloadRangeSize", true);
        String value = c != null ? c.getValue() : null;
        if (value == null || value.length() == 0 || (x = StringsKt.x(value)) == null) {
            return 5242880L;
        }
        return x.longValue();
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    public final long d() {
        return ((Number) this.h.getValue()).longValue();
    }

    public final int e() {
        return this.i;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.f;
    }

    public final void i(int i) {
        this.d = i;
    }
}
