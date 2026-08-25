package androidx.compose.foundation.lazy;

import kotlin.jvm.functions.Function3;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class t {
    public static /* synthetic */ void a(u uVar, Object obj, Object obj2, Function3 function3, int i5, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i5 & 1) != 0) {
            obj = null;
        }
        if ((i5 & 2) != 0) {
            obj2 = null;
        }
        uVar.a(obj, obj2, function3);
    }
}
