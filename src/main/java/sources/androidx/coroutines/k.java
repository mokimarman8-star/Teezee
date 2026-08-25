package androidx.coroutines;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f13226a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f13227b;

    public k(RoomDatabase roomDatabase) {
        Intrinsics.h(roomDatabase, "database");
        this.f13226a = roomDatabase;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.g(newSetFromMap, "newSetFromMap(...)");
        this.f13227b = newSetFromMap;
    }

    public final LiveData a(String[] strArr, boolean z5, Callable callable) {
        Intrinsics.h(strArr, "tableNames");
        Intrinsics.h(callable, "callableFunction");
        return new t(this.f13226a, this, z5, strArr, callable);
    }

    public final void b(LiveData liveData) {
        Intrinsics.h(liveData, "liveData");
        this.f13227b.add(liveData);
    }

    public final void c(LiveData liveData) {
        Intrinsics.h(liveData, "liveData");
        this.f13227b.remove(liveData);
    }
}
