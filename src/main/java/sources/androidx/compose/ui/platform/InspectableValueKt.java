package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class InspectableValueKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function1 f4660a = new Function1<z0, Unit>() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((z0) obj);
            return Unit.a;
        }

        public final void invoke(z0 z0Var) {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4661b;

    public static final Function1 a() {
        return f4660a;
    }

    public static final boolean b() {
        return f4661b;
    }
}
