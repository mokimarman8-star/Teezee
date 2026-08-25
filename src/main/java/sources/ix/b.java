package ix;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final int a() {
        Object obj;
        String value;
        Integer v;
        try {
            Result$Companion result$Companion = Result.Companion;
            ConfigBean c = cm.f.c.a().c("login_method_config", true);
            obj = Result.constructor-impl(Integer.valueOf((c == null || (value = c.getValue()) == null || (v = StringsKt.v(value)) == null) ? 0 : v.intValue()));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0;
        }
        return ((Number) obj).intValue();
    }

    public final boolean b() {
        return a() == 1;
    }
}
