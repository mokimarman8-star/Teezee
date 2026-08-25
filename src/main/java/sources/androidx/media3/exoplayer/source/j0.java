package androidx.media3.exoplayer.source;

import android.util.SparseArray;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private int f11510a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f11511b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.m f11512c;

    public j0() {
        this(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.source.i0
            @Override // androidx.media3.common.util.m
            public final void accept(Object obj) {
                j0.i(obj);
            }
        });
    }

    public j0(androidx.media3.common.util.m mVar) {
        this.f11511b = new SparseArray();
        this.f11512c = mVar;
        this.f11510a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i5, Object obj) {
        if (this.f11510a == -1) {
            androidx.media3.common.util.a.g(this.f11511b.size() == 0);
            this.f11510a = 0;
        }
        if (this.f11511b.size() > 0) {
            SparseArray sparseArray = this.f11511b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            androidx.media3.common.util.a.a(i5 >= keyAt);
            if (keyAt == i5) {
                androidx.media3.common.util.m mVar = this.f11512c;
                SparseArray sparseArray2 = this.f11511b;
                mVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f11511b.append(i5, obj);
    }

    public void c() {
        for (int i5 = 0; i5 < this.f11511b.size(); i5++) {
            this.f11512c.accept(this.f11511b.valueAt(i5));
        }
        this.f11510a = -1;
        this.f11511b.clear();
    }

    public void d(int i5) {
        for (int size = this.f11511b.size() - 1; size >= 0 && i5 < this.f11511b.keyAt(size); size--) {
            this.f11512c.accept(this.f11511b.valueAt(size));
            this.f11511b.removeAt(size);
        }
        this.f11510a = this.f11511b.size() > 0 ? Math.min(this.f11510a, this.f11511b.size() - 1) : -1;
    }

    public void e(int i5) {
        int i6 = 0;
        while (i6 < this.f11511b.size() - 1) {
            int i7 = i6 + 1;
            if (i5 < this.f11511b.keyAt(i7)) {
                return;
            }
            this.f11512c.accept(this.f11511b.valueAt(i6));
            this.f11511b.removeAt(i6);
            int i8 = this.f11510a;
            if (i8 > 0) {
                this.f11510a = i8 - 1;
            }
            i6 = i7;
        }
    }

    public Object f(int i5) {
        if (this.f11510a == -1) {
            this.f11510a = 0;
        }
        while (true) {
            int i6 = this.f11510a;
            if (i6 <= 0 || i5 >= this.f11511b.keyAt(i6)) {
                break;
            }
            this.f11510a--;
        }
        while (this.f11510a < this.f11511b.size() - 1 && i5 >= this.f11511b.keyAt(this.f11510a + 1)) {
            this.f11510a++;
        }
        return this.f11511b.valueAt(this.f11510a);
    }

    public Object g() {
        return this.f11511b.valueAt(r0.size() - 1);
    }

    public boolean h() {
        return this.f11511b.size() == 0;
    }
}
