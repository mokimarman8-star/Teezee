package com.transsnet.downloader.manager;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.c0;
import com.tencent.mmkv.MMKV;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class f {
    private static final int h = 0;
    public static final a a = new a((DefaultConstructorMarker) null);
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.e
        public final Object invoke() {
            f i2;
            i2 = f.i();
            return i2;
        }
    });
    private static final String c = "key_next_dl_type";
    private static final String d = "key_last_download_time";
    private static final String e = "key_today_downloaded_times";
    private static final int f = 1;
    private static final int g = 2;
    private static final int i = 1;
    private static final int j = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final f i() {
        return new f();
    }

    public final int f() {
        return h;
    }

    public final void g() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (!c0.f(bVar.b().getLong(d, 0L))) {
            bVar.b().putInt(e, 1);
            return;
        }
        MMKV b2 = bVar.b();
        String str = e;
        bVar.b().putInt(str, b2.getInt(str, 0) + 1);
    }

    public final void h() {
        f();
    }

    public final void j(FragmentActivity fragmentActivity, Subject subject, Function0 function0) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(subject, "subject");
        if (f() != h || function0 == null) {
            return;
        }
        function0.invoke();
    }
}
