package com.transsion.baseui.util;

import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R;
import fh.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class m {
    public static final void a(int i) {
        try {
            Result.Companion companion = Result.Companion;
            b.a aVar = fh.b.a;
            int i2 = R.layout.base_layout_new_info_toast;
            String string = Utils.a().getString(i);
            Intrinsics.g(string, "getString(...)");
            b.a.h(aVar, i2, string, 0, 0, 0, 28, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public static final void b(String str) {
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            b.a.h(fh.b.a, R.layout.base_layout_new_info_toast, str, 0, 0, 0, 28, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public static final void c(int i) {
        try {
            Result.Companion companion = Result.Companion;
            b.a aVar = fh.b.a;
            int i2 = R.layout.base_layout_new_success_toast;
            String string = Utils.a().getString(i);
            Intrinsics.g(string, "getString(...)");
            b.a.h(aVar, i2, string, 0, 0, 0, 28, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public static final void d(int i) {
        try {
            Result.Companion companion = Result.Companion;
            b.a aVar = fh.b.a;
            int i2 = R.layout.base_layout_new_warn_toast;
            String string = Utils.a().getString(i);
            Intrinsics.g(string, "getString(...)");
            b.a.h(aVar, i2, string, 0, 0, 0, 28, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public static final void e(String str) {
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            b.a.h(fh.b.a, R.layout.base_layout_new_warn_toast, str, 0, 0, 0, 28, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }
}
