package bm;

import io.reactivex.rxjava3.core.m;
import kotlin.jvm.internal.Intrinsics;
import yx.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class e$a implements h {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    e$a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final m apply(String str) {
        a c = e.c(e.a);
        String str2 = this.a;
        String str3 = this.b;
        Intrinsics.e(str);
        return c.a(str2, str3, str, this.c);
    }
}
