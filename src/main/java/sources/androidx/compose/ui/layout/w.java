package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class w {
    public static v a(x xVar, int i5, int i6, Map map, Function1 function1) {
        return xVar.L0(i5, i6, map, null, function1);
    }

    public static /* synthetic */ v b(x xVar, int i5, int i6, Map map, Function1 function1, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i7 & 4) != 0) {
            map = MapsKt.h();
        }
        return xVar.p0(i5, i6, map, function1);
    }
}
