package androidx.coroutines;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class InvalidationTracker$b {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f13017a;

    public InvalidationTracker$b(String[] strArr) {
        Intrinsics.h(strArr, "tables");
        this.f13017a = strArr;
    }

    public final String[] a() {
        return this.f13017a;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(Set set);
}
