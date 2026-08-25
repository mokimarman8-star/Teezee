package androidx.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class x0 {
    private Object[] array;
    private int[] hashes;
    private int size;

    @JvmOverloads
    public x0() {
        this(0, 1, null);
    }

    public x0(int i5) {
        this.hashes = i5 == 0 ? n.a.f16549a : new int[i5];
        this.array = i5 == 0 ? n.a.f16551c : new Object[i5 << 1];
    }

    public /* synthetic */ x0(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public x0(x0 x0Var) {
        this(0, 1, null);
        if (x0Var != null) {
            putAll(x0Var);
        }
    }

    private final int a(Object obj, int i5) {
        int i6 = this.size;
        if (i6 == 0) {
            return -1;
        }
        int a5 = n.a.a(this.hashes, i6, i5);
        if (a5 < 0 || Intrinsics.c(obj, this.array[a5 << 1])) {
            return a5;
        }
        int i7 = a5 + 1;
        while (i7 < i6 && this.hashes[i7] == i5) {
            if (Intrinsics.c(obj, this.array[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = a5 - 1; i8 >= 0 && this.hashes[i8] == i5; i8--) {
            if (Intrinsics.c(obj, this.array[i8 << 1])) {
                return i8;
            }
        }
        return ~i7;
    }

    private final int c() {
        int i5 = this.size;
        if (i5 == 0) {
            return -1;
        }
        int a5 = n.a.a(this.hashes, i5, 0);
        if (a5 < 0 || this.array[a5 << 1] == null) {
            return a5;
        }
        int i6 = a5 + 1;
        while (i6 < i5 && this.hashes[i6] == 0) {
            if (this.array[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = a5 - 1; i7 >= 0 && this.hashes[i7] == 0; i7--) {
            if (this.array[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    @JvmName
    public final int __restricted$indexOfValue(Object obj) {
        int i5 = this.size * 2;
        Object[] objArr = this.array;
        if (obj == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (Intrinsics.c(obj, objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = n.a.f16549a;
            this.array = n.a.f16551c;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return __restricted$indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i5) {
        int i6 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i5) {
            int[] copyOf = Arrays.copyOf(iArr, i5);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i5 * 2);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
        }
        if (this.size != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof x0) {
                if (size() != ((x0) obj).size()) {
                    return false;
                }
                x0 x0Var = (x0) obj;
                int i5 = this.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    Object keyAt = keyAt(i6);
                    Object valueAt = valueAt(i6);
                    Object obj2 = x0Var.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !x0Var.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.c(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i7 = this.size;
            for (int i8 = 0; i8 < i7; i8++) {
                Object keyAt2 = keyAt(i8);
                Object valueAt2 = valueAt(i8);
                Object obj3 = ((Map) obj).get(keyAt2);
                if (valueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                        return false;
                    }
                } else if (!Intrinsics.c(valueAt2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.array[(indexOfKey << 1) + 1] : obj2;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i5 = this.size;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj != null ? obj.hashCode() : 0) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? c() : a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public Object keyAt(int i5) {
        boolean z5 = false;
        if (i5 >= 0 && i5 < this.size) {
            z5 = true;
        }
        if (!z5) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        return this.array[i5 << 1];
    }

    public Object put(Object obj, Object obj2) {
        int i5 = this.size;
        int hashCode = obj != null ? obj.hashCode() : 0;
        int a5 = obj != null ? a(obj, hashCode) : c();
        if (a5 >= 0) {
            int i6 = (a5 << 1) + 1;
            Object[] objArr = this.array;
            Object obj3 = objArr[i6];
            objArr[i6] = obj2;
            return obj3;
        }
        int i7 = ~a5;
        int[] iArr = this.hashes;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i8);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i8 << 1);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i5 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.hashes;
            int i9 = i7 + 1;
            ArraysKt.j(iArr2, iArr2, i9, i7, i5);
            Object[] objArr2 = this.array;
            ArraysKt.l(objArr2, objArr2, i9 << 1, i7 << 1, this.size << 1);
        }
        int i10 = this.size;
        if (i5 == i10) {
            int[] iArr3 = this.hashes;
            if (i7 < iArr3.length) {
                iArr3[i7] = hashCode;
                Object[] objArr3 = this.array;
                int i11 = i7 << 1;
                objArr3[i11] = obj;
                objArr3[i11 + 1] = obj2;
                this.size = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(x0 x0Var) {
        Intrinsics.h(x0Var, "map");
        int i5 = x0Var.size;
        ensureCapacity(this.size + i5);
        if (this.size != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(x0Var.keyAt(i6), x0Var.valueAt(i6));
            }
        } else if (i5 > 0) {
            ArraysKt.j(x0Var.hashes, this.hashes, 0, 0, i5);
            ArraysKt.l(x0Var.array, this.array, 0, 0, i5 << 1);
            this.size = i5;
        }
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0 || !Intrinsics.c(obj2, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public Object removeAt(int i5) {
        if (!(i5 >= 0 && i5 < this.size)) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        Object[] objArr = this.array;
        int i6 = i5 << 1;
        Object obj = objArr[i6 + 1];
        int i7 = this.size;
        if (i7 <= 1) {
            clear();
        } else {
            int i8 = i7 - 1;
            int[] iArr = this.hashes;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i5 < i8) {
                    int i9 = i5 + 1;
                    ArraysKt.j(iArr, iArr, i5, i9, i7);
                    Object[] objArr2 = this.array;
                    ArraysKt.l(objArr2, objArr2, i6, i9 << 1, i7 << 1);
                }
                Object[] objArr3 = this.array;
                int i10 = i8 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                int i11 = i7 > 8 ? i7 + (i7 >> 1) : 8;
                int[] copyOf = Arrays.copyOf(iArr, i11);
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
                this.hashes = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.array, i11 << 1);
                Intrinsics.g(copyOf2, "copyOf(this, newSize)");
                this.array = copyOf2;
                if (i7 != this.size) {
                    throw new ConcurrentModificationException();
                }
                if (i5 > 0) {
                    ArraysKt.j(iArr, this.hashes, 0, 0, i5);
                    ArraysKt.l(objArr, this.array, 0, 0, i6);
                }
                if (i5 < i8) {
                    int i12 = i5 + 1;
                    ArraysKt.j(iArr, this.hashes, i5, i12, i7);
                    ArraysKt.l(objArr, this.array, i6, i12 << 1, i7 << 1);
                }
            }
            if (i7 != this.size) {
                throw new ConcurrentModificationException();
            }
            this.size = i8;
        }
        return obj;
    }

    public Object replace(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, obj2);
        }
        return null;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0 || !Intrinsics.c(obj2, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, obj3);
        return true;
    }

    public Object setValueAt(int i5, Object obj) {
        boolean z5 = false;
        if (i5 >= 0 && i5 < this.size) {
            z5 = true;
        }
        if (!z5) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        int i6 = (i5 << 1) + 1;
        Object[] objArr = this.array;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        return obj2;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i6);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i6);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Object valueAt(int i5) {
        boolean z5 = false;
        if (i5 >= 0 && i5 < this.size) {
            z5 = true;
        }
        if (!z5) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        return this.array[(i5 << 1) + 1];
    }
}
