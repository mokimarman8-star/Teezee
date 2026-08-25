package kl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class g implements f {
    private final Object[] a;
    private int b;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    private boolean a(Object obj) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // kl.f
    public Object acquire() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.b = i2;
        return obj;
    }

    @Override // kl.f
    public boolean release(Object obj) {
        if (a(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        this.b = i + 1;
        return true;
    }
}
