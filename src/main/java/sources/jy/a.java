package jy;

import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ CoroutineContext[] a;
    public final /* synthetic */ Ref.IntRef b;

    public /* synthetic */ a(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        this.a = coroutineContextArr;
        this.b = intRef;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return CombinedContext.c(this.a, this.b, (Unit) obj, (CoroutineContext$Element) obj2);
    }
}
