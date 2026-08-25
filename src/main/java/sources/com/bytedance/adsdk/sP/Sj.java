package com.bytedance.adsdk.sP;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class Sj<E> implements Collection<E>, Set<E> {
    private static int Dq;
    private static Object[] HiB;
    private static Object[] Jcg;
    private static int vS;
    Object[] Sj;
    private Zq<E, E> TEQ;
    int sP;
    private int[] uA;
    private static final int[] TKC = new int[0];
    private static final Object[] EjP = new Object[0];

    public Sj() {
        this(0);
    }

    public Sj(int i) {
        if (i == 0) {
            this.uA = TKC;
            this.Sj = EjP;
        } else {
            EjP(i);
        }
        this.sP = 0;
    }

    private void EjP(int i) {
        if (i == 8) {
            synchronized (Sj.class) {
                Object[] objArr = Jcg;
                if (objArr != null) {
                    this.Sj = objArr;
                    Jcg = (Object[]) objArr[0];
                    this.uA = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Dq--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (Sj.class) {
                Object[] objArr2 = HiB;
                if (objArr2 != null) {
                    this.Sj = objArr2;
                    HiB = (Object[]) objArr2[0];
                    this.uA = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    vS--;
                    return;
                }
            }
        }
        this.uA = new int[i];
        this.Sj = new Object[i];
    }

    private int Sj() {
        int i = this.sP;
        if (i == 0) {
            return -1;
        }
        int Sj = sP.Sj(this.uA, i, 0);
        if (Sj < 0 || this.Sj[Sj] == null) {
            return Sj;
        }
        int i2 = Sj + 1;
        while (i2 < i && this.uA[i2] == 0) {
            if (this.Sj[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = Sj - 1; i3 >= 0 && this.uA[i3] == 0; i3--) {
            if (this.Sj[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private int Sj(Object obj, int i) {
        int i2 = this.sP;
        if (i2 == 0) {
            return -1;
        }
        int Sj = sP.Sj(this.uA, i2, i);
        if (Sj < 0 || obj.equals(this.Sj[Sj])) {
            return Sj;
        }
        int i3 = Sj + 1;
        while (i3 < i2 && this.uA[i3] == i) {
            if (obj.equals(this.Sj[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = Sj - 1; i4 >= 0 && this.uA[i4] == i; i4--) {
            if (obj.equals(this.Sj[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private static void Sj(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (Sj.class) {
                try {
                    if (Dq < 10) {
                        objArr[0] = Jcg;
                        objArr[1] = iArr;
                        for (int i2 = i - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        Jcg = objArr;
                        Dq++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (Sj.class) {
                try {
                    if (vS < 10) {
                        objArr[0] = HiB;
                        objArr[1] = iArr;
                        for (int i3 = i - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        HiB = objArr;
                        vS++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private Zq<E, E> sP() {
        if (this.TEQ == null) {
            this.TEQ = new Zq<E, E>() { // from class: com.bytedance.adsdk.sP.Sj.1
                @Override // com.bytedance.adsdk.sP.Zq
                protected int Sj() {
                    return Sj.this.sP;
                }

                @Override // com.bytedance.adsdk.sP.Zq
                protected int Sj(Object obj) {
                    return Sj.this.Sj(obj);
                }

                @Override // com.bytedance.adsdk.sP.Zq
                protected Object Sj(int i, int i2) {
                    return Sj.this.Sj[i];
                }

                @Override // com.bytedance.adsdk.sP.Zq
                protected void Sj(int i) {
                    Sj.this.TKC(i);
                }

                @Override // com.bytedance.adsdk.sP.Zq
                protected void TKC() {
                    Sj.this.clear();
                }

                @Override // com.bytedance.adsdk.sP.Zq
                protected Map<E, E> sP() {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.TEQ;
    }

    public int Sj(Object obj) {
        return obj == null ? Sj() : Sj(obj, obj.hashCode());
    }

    public void Sj(int i) {
        int[] iArr = this.uA;
        if (iArr.length < i) {
            Object[] objArr = this.Sj;
            EjP(i);
            int i2 = this.sP;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.uA, 0, i2);
                System.arraycopy(objArr, 0, this.Sj, 0, this.sP);
            }
            Sj(iArr, objArr, this.sP);
        }
    }

    public E TKC(int i) {
        Object[] objArr = this.Sj;
        E e = (E) objArr[i];
        int i2 = this.sP;
        if (i2 <= 1) {
            Sj(this.uA, objArr, i2);
            this.uA = TKC;
            this.Sj = EjP;
            this.sP = 0;
        } else {
            int[] iArr = this.uA;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.sP = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.Sj;
                    System.arraycopy(objArr2, i4, objArr2, i, this.sP - i);
                }
                this.Sj[this.sP] = null;
            } else {
                EjP(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.sP--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.uA, 0, i);
                    System.arraycopy(objArr, 0, this.Sj, 0, i);
                }
                int i8 = this.sP;
                if (i < i8) {
                    int i9 = i + 1;
                    System.arraycopy(iArr, i9, this.uA, i, i8 - i);
                    System.arraycopy(objArr, i9, this.Sj, i, this.sP - i);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int Sj;
        if (e == null) {
            Sj = Sj();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            Sj = Sj(e, hashCode);
        }
        if (Sj >= 0) {
            return false;
        }
        int i2 = ~Sj;
        int i3 = this.sP;
        int[] iArr = this.uA;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.Sj;
            EjP(i4);
            int[] iArr2 = this.uA;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.Sj, 0, objArr.length);
            }
            Sj(iArr, objArr, this.sP);
        }
        int i8 = this.sP;
        if (i2 < i8) {
            int[] iArr3 = this.uA;
            int i9 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i9, i8 - i2);
            Object[] objArr2 = this.Sj;
            System.arraycopy(objArr2, i2, objArr2, i9, this.sP - i2);
        }
        this.uA[i2] = i;
        this.Sj[i2] = e;
        this.sP++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        Sj(this.sP + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.sP;
        if (i != 0) {
            Sj(this.uA, this.Sj, i);
            this.uA = TKC;
            this.Sj = EjP;
            this.sP = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return Sj(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.sP; i++) {
                try {
                    if (!set.contains(sP(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.uA;
        int i = this.sP;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.sP <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return sP().EjP().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int Sj = Sj(obj);
        if (Sj < 0) {
            return false;
        }
        TKC(Sj);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.sP - 1; i >= 0; i--) {
            if (!collection.contains(this.Sj[i])) {
                TKC(i);
                z = true;
            }
        }
        return z;
    }

    public E sP(int i) {
        return (E) this.Sj[i];
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.sP;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.sP;
        Object[] objArr = new Object[i];
        System.arraycopy(this.Sj, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.sP) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.sP));
        }
        System.arraycopy(this.Sj, 0, tArr, 0, this.sP);
        int length = tArr.length;
        int i = this.sP;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return MiniAppConfigHelper.DEFAULT_KEY_CORS_LIST;
        }
        StringBuilder sb = new StringBuilder(this.sP * 14);
        sb.append('{');
        for (int i = 0; i < this.sP; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E sP = sP(i);
            if (sP != this) {
                sb.append(sP);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
