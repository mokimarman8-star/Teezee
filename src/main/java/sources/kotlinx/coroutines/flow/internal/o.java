package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class o implements Function2 {
    public final /* synthetic */ SafeCollector a;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(q.a(this.a, ((Integer) obj).intValue(), (CoroutineContext$Element) obj2));
    }
}
