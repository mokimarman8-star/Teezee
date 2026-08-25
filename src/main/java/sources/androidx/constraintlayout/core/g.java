package androidx.constraintlayout.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f5664a;

    /* renamed from: b, reason: collision with root package name */
    private int f5665b;

    g(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f5664a = new Object[i5];
    }

    @Override // androidx.constraintlayout.core.f
    public void a(Object[] objArr, int i5) {
        if (i5 > objArr.length) {
            i5 = objArr.length;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = objArr[i6];
            int i7 = this.f5665b;
            Object[] objArr2 = this.f5664a;
            if (i7 < objArr2.length) {
                objArr2[i7] = obj;
                this.f5665b = i7 + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.f
    public Object acquire() {
        int i5 = this.f5665b;
        if (i5 <= 0) {
            return null;
        }
        int i6 = i5 - 1;
        Object[] objArr = this.f5664a;
        Object obj = objArr[i6];
        objArr[i6] = null;
        this.f5665b = i5 - 1;
        return obj;
    }

    @Override // androidx.constraintlayout.core.f
    public boolean release(Object obj) {
        int i5 = this.f5665b;
        Object[] objArr = this.f5664a;
        if (i5 >= objArr.length) {
            return false;
        }
        objArr[i5] = obj;
        this.f5665b = i5 + 1;
        return true;
    }
}
