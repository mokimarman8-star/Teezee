package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class d0 implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(g0.c(((Boolean) obj).booleanValue(), (CoroutineContext$Element) obj2));
    }
}
