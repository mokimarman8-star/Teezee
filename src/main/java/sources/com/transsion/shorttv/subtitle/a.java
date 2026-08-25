package com.transsion.shorttv.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nr.e;
import qr.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {
    public static final C0063a a = C0063a.a;

    /* renamed from: com.transsion.shorttv.subtitle.a$a, reason: collision with other inner class name */
    public static final class C0063a {
        static final /* synthetic */ C0063a a = new C0063a();

        private C0063a() {
        }

        public final a a(FragmentActivity fragmentActivity, k0 k0Var, ShortTvViewModel shortTvViewModel, e eVar, String str) {
            Intrinsics.h(fragmentActivity, "activity");
            Intrinsics.h(k0Var, "viewBinding");
            Intrinsics.h(eVar, "epItem");
            return new ShortTVSubtitleControlImp(fragmentActivity, k0Var, shortTvViewModel, eVar, str);
        }
    }

    void a(Function1 function1);

    void b(Function1 function1);

    void c(boolean z);

    void d(long j);

    void e();

    void f();

    void h(xr.b bVar);

    void onDestroy();
}
