package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class y0 extends c implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    private static final y0 f7787d = new y0(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    private Object[] f7788b;

    /* renamed from: c, reason: collision with root package name */
    private int f7789c;

    private y0(Object[] objArr, int i5, boolean z5) {
        super(z5);
        this.f7788b = objArr;
        this.f7789c = i5;
    }

    private static Object[] b(int i5) {
        return new Object[i5];
    }

    public static y0 c() {
        return f7787d;
    }

    private void e(int i5) {
        if (i5 < 0 || i5 >= this.f7789c) {
            throw new IndexOutOfBoundsException(f(i5));
        }
    }

    private String f(int i5) {
        return "Index:" + i5 + ", Size:" + this.f7789c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, Object obj) {
        int i6;
        a();
        if (i5 < 0 || i5 > (i6 = this.f7789c)) {
            throw new IndexOutOfBoundsException(f(i5));
        }
        Object[] objArr = this.f7788b;
        if (i6 < objArr.length) {
            System.arraycopy(objArr, i5, objArr, i5 + 1, i6 - i5);
        } else {
            Object[] b5 = b(((i6 * 3) / 2) + 1);
            System.arraycopy(this.f7788b, 0, b5, 0, i5);
            System.arraycopy(this.f7788b, i5, b5, i5 + 1, this.f7789c - i5);
            this.f7788b = b5;
        }
        this.f7788b[i5] = obj;
        this.f7789c++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i5 = this.f7789c;
        Object[] objArr = this.f7788b;
        if (i5 == objArr.length) {
            this.f7788b = Arrays.copyOf(objArr, ((i5 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7788b;
        int i6 = this.f7789c;
        this.f7789c = i6 + 1;
        objArr2[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.w.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public y0 mutableCopyWithCapacity(int i5) {
        if (i5 >= this.f7789c) {
            return new y0(Arrays.copyOf(this.f7788b, i5), this.f7789c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i5) {
        e(i5);
        return this.f7788b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public Object remove(int i5) {
        a();
        e(i5);
        Object[] objArr = this.f7788b;
        Object obj = objArr[i5];
        if (i5 < this.f7789c - 1) {
            System.arraycopy(objArr, i5 + 1, objArr, i5, (r2 - i5) - 1);
        }
        this.f7789c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i5, Object obj) {
        a();
        e(i5);
        Object[] objArr = this.f7788b;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7789c;
    }
}
