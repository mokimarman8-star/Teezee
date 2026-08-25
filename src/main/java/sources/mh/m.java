package mh;

import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class m {
    public static final m a = new m();

    private m() {
    }

    public final Object a(Object obj, String str) {
        Object obj2;
        Intrinsics.h(obj, "instance");
        Intrinsics.h(str, "fieldName");
        try {
            Result.Companion companion = Result.Companion;
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            obj2 = Result.constructor-impl(declaredField.get(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.isFailure-impl(obj2)) {
            return null;
        }
        return obj2;
    }
}
