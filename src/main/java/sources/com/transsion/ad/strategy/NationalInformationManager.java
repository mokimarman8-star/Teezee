package com.transsion.ad.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NationalInformationManager {
    public static final NationalInformationManager a = new NationalInformationManager();

    private NationalInformationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        String simpleName = NationalInformationManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final Object b(Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$getAllNationalInformationList$2(null), continuation);
    }

    public final String d() {
        String string;
        MMKV c = mg.a.a.c();
        String str = BuildConfig.FLAVOR;
        if (c != null && (string = c.getString("sp_code", BuildConfig.FLAVOR)) != null) {
            str = string;
        }
        if (TextUtils.isEmpty(str)) {
            str = tg.b.a.o();
        }
        if (str.length() <= 0 || str.length() < 3) {
            return str;
        }
        String substring = str.substring(0, 3);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public final Object e(String str, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$getNationalInformation$2(str, null), continuation);
    }

    public final Object f(Context context, Continuation continuation) {
        Object g = kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$initLocalMcc$2(context, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
