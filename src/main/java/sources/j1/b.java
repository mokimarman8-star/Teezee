package j1;

import androidx.datastore.flow.CorruptionException;
import androidx.datastore.flow.d;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f15807a;

    public b(Function1 function1) {
        Intrinsics.h(function1, "produceNewData");
        this.f15807a = function1;
    }

    @Override // androidx.datastore.flow.d
    public Object a(CorruptionException corruptionException, Continuation continuation) {
        return this.f15807a.invoke(corruptionException);
    }
}
