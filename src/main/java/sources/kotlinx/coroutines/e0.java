package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class e0 implements Function2 {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ e0(Ref.ObjectRef objectRef, boolean z) {
        this.a = objectRef;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return g0.a(this.a, this.b, (CoroutineContext) obj, (CoroutineContext$Element) obj2);
    }
}
