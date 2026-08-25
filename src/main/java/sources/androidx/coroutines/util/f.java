package androidx.coroutines.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    public static final Object a(Class cls, String str) {
        String str2;
        String str3;
        Intrinsics.h(cls, "klass");
        Intrinsics.h(str, "suffix");
        Package r02 = cls.getPackage();
        if (r02 == null || (str2 = r02.getName()) == null) {
            str2 = "";
        }
        String canonicalName = cls.getCanonicalName();
        Intrinsics.e(canonicalName);
        if (str2.length() != 0) {
            canonicalName = canonicalName.substring(str2.length() + 1);
            Intrinsics.g(canonicalName, "substring(...)");
        }
        String str4 = StringsKt.P(canonicalName, '.', '_', false, 4, (Object) null) + str;
        try {
            if (str2.length() == 0) {
                str3 = str4;
            } else {
                str3 = str2 + '.' + str4;
            }
            Class<?> cls2 = Class.forName(str3, true, cls.getClassLoader());
            Intrinsics.f(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str4 + " does not exist. Is Room annotation processor correctly configured?", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName(), e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName(), e7);
        }
    }

    public static /* synthetic */ Object b(Class cls, String str, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = "_Impl";
        }
        return a(cls, str);
    }
}
