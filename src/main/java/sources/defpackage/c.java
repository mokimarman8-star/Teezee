package defpackage;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f14182a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f14183b = LazyKt.b(new Function0() { // from class: b
        public final Object invoke() {
            MMKV c5;
            c5 = c.c();
            return c5;
        }
    });

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        return MMKV.I("palm_pay_kv");
    }

    public final MMKV b() {
        return (MMKV) f14183b.getValue();
    }
}
