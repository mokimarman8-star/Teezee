package lj;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.Intrinsics;
import zg.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final int a(float f) {
        h hVar = h.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return hVar.a(a, f);
    }

    public static final int b(int i) {
        h hVar = h.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return hVar.a(a, i);
    }
}
