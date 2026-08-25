package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements d {
    private final Object a;
    private final Function3 b;
    private final Function3 c;
    private final Function3 d;

    public e(Object obj, Function3 function3, Function3 function32, Function3 function33) {
        this.a = obj;
        this.b = function3;
        this.c = function32;
        this.d = function33;
    }

    public /* synthetic */ e(Object obj, Function3 function3, Function3 function32, Function3 function33, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function32, (i & 8) != 0 ? null : function33);
    }
}
