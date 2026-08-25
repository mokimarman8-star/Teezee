package yl;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: yl.c
        public final Object invoke() {
            e.a();
            return null;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: yl.d
        public final Object invoke() {
            MMKV e;
            e = e.e();
            return e;
        }
    });

    private e() {
    }

    public static /* synthetic */ a a() {
        c();
        return null;
    }

    private static final a c() {
        android.support.v4.media.session.c.a(kg.c.e.a().h(a.class));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        return MMKV.I("mb_web_res");
    }

    public final void d() {
        b.a.b();
    }
}
