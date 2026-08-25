package androidx.coroutines;

import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class t extends RoomTrackingLiveData {

    /* renamed from: t, reason: collision with root package name */
    private final Callable f13298t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(RoomDatabase roomDatabase, k kVar, boolean z5, String[] strArr, Callable callable) {
        super(roomDatabase, kVar, z5, strArr, null);
        Intrinsics.h(roomDatabase, "database");
        Intrinsics.h(kVar, "container");
        Intrinsics.h(strArr, "tableNames");
        Intrinsics.h(callable, "callableFunction");
        this.f13298t = callable;
    }

    @Override // androidx.coroutines.RoomTrackingLiveData
    public Object t(Continuation continuation) {
        return this.f13298t.call();
    }
}
