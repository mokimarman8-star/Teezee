package androidx.recyclerview.widget;

import android.util.SparseIntArray;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class GridLayoutManager$c {

    /* renamed from: a, reason: collision with root package name */
    final SparseIntArray f12801a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    final SparseIntArray f12802b = new SparseIntArray();

    /* renamed from: c, reason: collision with root package name */
    private boolean f12803c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12804d = false;

    static int a(SparseIntArray sparseIntArray, int i5) {
        int size = sparseIntArray.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            if (sparseIntArray.keyAt(i7) < i5) {
                i6 = i7 + 1;
            } else {
                size = i7 - 1;
            }
        }
        int i8 = i6 - 1;
        if (i8 < 0 || i8 >= sparseIntArray.size()) {
            return -1;
        }
        return sparseIntArray.keyAt(i8);
    }

    int b(int i5, int i6) {
        if (!this.f12804d) {
            return d(i5, i6);
        }
        int i7 = this.f12802b.get(i5, -1);
        if (i7 != -1) {
            return i7;
        }
        int d5 = d(i5, i6);
        this.f12802b.put(i5, d5);
        return d5;
    }

    int c(int i5, int i6) {
        if (!this.f12803c) {
            return e(i5, i6);
        }
        int i7 = this.f12801a.get(i5, -1);
        if (i7 != -1) {
            return i7;
        }
        int e5 = e(i5, i6);
        this.f12801a.put(i5, e5);
        return e5;
    }

    public int d(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int a5;
        if (!this.f12804d || (a5 = a(this.f12802b, i5)) == -1) {
            i7 = 0;
            i8 = 0;
            i9 = 0;
        } else {
            i7 = this.f12802b.get(a5);
            i8 = a5 + 1;
            i9 = c(a5, i6) + f(a5);
            if (i9 == i6) {
                i7++;
                i9 = 0;
            }
        }
        int f5 = f(i5);
        while (i8 < i5) {
            int f6 = f(i8);
            i9 += f6;
            if (i9 == i6) {
                i7++;
                i9 = 0;
            } else if (i9 > i6) {
                i7++;
                i9 = f6;
            }
            i8++;
        }
        return i9 + f5 > i6 ? i7 + 1 : i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(int i5, int i6) {
        int i7;
        int i8;
        int f5 = f(i5);
        if (f5 == i6) {
            return 0;
        }
        if (!this.f12803c || (i7 = a(this.f12801a, i5)) < 0) {
            i7 = 0;
            i8 = 0;
            if (i7 >= i5) {
                int f6 = f(i7);
                i8 += f6;
                if (i8 == i6) {
                    i8 = 0;
                } else if (i8 > i6) {
                    i8 = f6;
                }
                i7++;
                if (i7 >= i5) {
                    if (f5 + i8 <= i6) {
                        return i8;
                    }
                    return 0;
                }
            }
        } else {
            i8 = this.f12801a.get(i7) + f(i7);
            i7++;
            if (i7 >= i5) {
            }
        }
    }

    public abstract int f(int i5);

    public void g() {
        this.f12802b.clear();
    }

    public void h() {
        this.f12801a.clear();
    }

    public void i(boolean z5) {
        if (!z5) {
            this.f12802b.clear();
        }
        this.f12803c = z5;
    }
}
