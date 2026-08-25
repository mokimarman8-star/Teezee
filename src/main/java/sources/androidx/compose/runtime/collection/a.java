package androidx.compose.runtime.collection;

import android.util.SparseArray;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f2676a;

    public a(int i5) {
        this(new SparseArray(i5));
    }

    public /* synthetic */ a(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }

    private a(SparseArray sparseArray) {
        this.f2676a = sparseArray;
    }

    public final Object a(int i5) {
        return this.f2676a.get(i5);
    }

    public final void b(int i5, Object obj) {
        this.f2676a.put(i5, obj);
    }
}
