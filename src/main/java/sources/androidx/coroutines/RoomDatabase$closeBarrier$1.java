package androidx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class RoomDatabase$closeBarrier$1 extends FunctionReferenceImpl implements Function0<Unit> {
    RoomDatabase$closeBarrier$1(Object obj) {
        super(0, obj, RoomDatabase.class, "onClosed", "onClosed()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m364invoke();
        return Unit.a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m364invoke() {
        RoomDatabase.g((RoomDatabase) ((CallableReference) this).receiver);
    }
}
