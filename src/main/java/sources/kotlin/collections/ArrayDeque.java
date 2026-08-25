package kotlin.collections;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;

@SinceKotlin
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0007\u0018\u0000 U*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001VB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ%\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0007J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00028\u0000¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b(\u0010%J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010%J\u000f\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b.\u0010%J\r\u0010/\u001a\u00028\u0000¢\u0006\u0004\b/\u0010%J\u000f\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b0\u0010%J\u0017\u00101\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00103J\u001d\u00104\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b4\u00105J%\u00104\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b4\u00106J\u0018\u00107\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b7\u00108J \u00109\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b;\u00102J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u00102J\u0017\u0010@\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b@\u00108J\u001d\u0010A\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\bA\u00105J\u001d\u0010B\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\bB\u00105J\u000f\u0010C\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010\u0007J)\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010E\"\u0004\b\u0001\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0EH\u0016¢\u0006\u0004\bG\u0010JJ\u001f\u0010K\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0014¢\u0006\u0004\bK\u0010\u001bR\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010LR\u001e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010T\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\f\u0010L\u001a\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", HttpUrl.FRAGMENT_ENCODE_SET, "initialCapacity", "<init>", "(I)V", "()V", "minCapacity", HttpUrl.FRAGMENT_ENCODE_SET, "f", "newCapacity", "c", "index", "o", "(I)I", "m", "j", "e", "internalIndex", HttpUrl.FRAGMENT_ENCODE_SET, "elements", "a", "(ILjava/util/Collection;)V", "fromIndex", "toIndex", "r", "(II)V", "s", "internalFromIndex", "internalToIndex", "n", "registerModification", HttpUrl.FRAGMENT_ENCODE_SET, "isEmpty", "()Z", "first", "()Ljava/lang/Object;", "i", "last", "l", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "p", "removeLast", "q", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", "T", HttpUrl.FRAGMENT_ENCODE_SET, "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "()[Ljava/lang/Object;", "removeRange", "I", "head", "b", "[Ljava/lang/Object;", "elementData", "value", "getSize", "()I", "size", "d", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final Object[] e = new Object[0];

    /* renamed from: a, reason: from kotlin metadata */
    private int head;

    /* renamed from: b, reason: from kotlin metadata */
    private Object[] elementData;

    /* renamed from: c, reason: from kotlin metadata */
    private int size;

    public ArrayDeque() {
        this.elementData = e;
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = e;
        } else {
            if (i <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i);
            }
            objArr = new Object[i];
        }
        this.elementData = objArr;
    }

    private final void a(int internalIndex, Collection elements) {
        Iterator<E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i = this.head;
        for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
            this.elementData[i2] = it.next();
        }
        this.size = size() + elements.size();
    }

    private final void c(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        ArraysKt.l(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i = this.head;
        ArraysKt.l(objArr3, objArr, length - i, 0, i);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int e(int index) {
        return index == 0 ? ArraysKt.Y(this.elementData) : index - 1;
    }

    private final void f(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.elementData = new Object[RangesKt.e(minCapacity, 10)];
        } else {
            c(AbstractList.INSTANCE.e(objArr.length, minCapacity));
        }
    }

    private final int j(int index) {
        if (index == ArraysKt.Y(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int m(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    private final void n(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            ArraysKt.u(this.elementData, null, internalFromIndex, internalToIndex);
            return;
        }
        Object[] objArr = this.elementData;
        ArraysKt.u(objArr, null, internalFromIndex, objArr.length);
        ArraysKt.u(this.elementData, null, 0, internalToIndex);
    }

    private final int o(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    private final void r(int fromIndex, int toIndex) {
        int o = o(this.head + (fromIndex - 1));
        int o2 = o(this.head + (toIndex - 1));
        while (fromIndex > 0) {
            int i = o + 1;
            int min = Math.min(fromIndex, Math.min(i, o2 + 1));
            Object[] objArr = this.elementData;
            int i2 = o2 - min;
            int i3 = o - min;
            ArraysKt.l(objArr, objArr, i2 + 1, i3 + 1, i);
            o = m(i3);
            o2 = m(i2);
            fromIndex -= min;
        }
    }

    private final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    private final void s(int fromIndex, int toIndex) {
        int o = o(this.head + toIndex);
        int o2 = o(this.head + fromIndex);
        int size = size();
        while (true) {
            size -= toIndex;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            toIndex = Math.min(size, Math.min(objArr.length - o, objArr.length - o2));
            Object[] objArr2 = this.elementData;
            int i = o + toIndex;
            ArraysKt.l(objArr2, objArr2, o2, o, i);
            o = o(i);
            o2 = o(o2 + toIndex);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, Object element) {
        AbstractList.INSTANCE.c(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        registerModification();
        f(size() + 1);
        int o = o(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int e2 = e(o);
            int e3 = e(this.head);
            int i = this.head;
            if (e2 >= i) {
                Object[] objArr = this.elementData;
                objArr[e3] = objArr[i];
                ArraysKt.l(objArr, objArr, i, i + 1, e2 + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.l(objArr2, objArr2, i - 1, i, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt.l(objArr3, objArr3, 0, 1, e2 + 1);
            }
            this.elementData[e2] = element;
            this.head = e3;
        } else {
            int o2 = o(this.head + size());
            if (o < o2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.l(objArr4, objArr4, o + 1, o, o2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.l(objArr5, objArr5, 1, 0, o2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt.l(objArr6, objArr6, o + 1, o, objArr6.length - 1);
            }
            this.elementData[o] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection elements) {
        Intrinsics.h(elements, "elements");
        AbstractList.INSTANCE.c(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        registerModification();
        f(size() + elements.size());
        int o = o(this.head + size());
        int o2 = o(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head;
            int i2 = i - size;
            if (o2 < i) {
                Object[] objArr = this.elementData;
                ArraysKt.l(objArr, objArr, i2, i, objArr.length);
                if (size >= o2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.l(objArr2, objArr2, objArr2.length - size, 0, o2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.l(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.l(objArr4, objArr4, 0, size, o2);
                }
            } else if (i2 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.l(objArr5, objArr5, i2, i, o2);
            } else {
                Object[] objArr6 = this.elementData;
                i2 += objArr6.length;
                int i3 = o2 - i;
                int length = objArr6.length - i2;
                if (length >= i3) {
                    ArraysKt.l(objArr6, objArr6, i2, i, o2);
                } else {
                    ArraysKt.l(objArr6, objArr6, i2, i, i + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.l(objArr7, objArr7, 0, this.head + length, o2);
                }
            }
            this.head = i2;
            a(m(o2 - size), elements);
        } else {
            int i4 = o2 + size;
            if (o2 < o) {
                int i5 = size + o;
                Object[] objArr8 = this.elementData;
                if (i5 <= objArr8.length) {
                    ArraysKt.l(objArr8, objArr8, i4, o2, o);
                } else if (i4 >= objArr8.length) {
                    ArraysKt.l(objArr8, objArr8, i4 - objArr8.length, o2, o);
                } else {
                    int length2 = o - (i5 - objArr8.length);
                    ArraysKt.l(objArr8, objArr8, 0, length2, o);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.l(objArr9, objArr9, i4, o2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.l(objArr10, objArr10, size, 0, o);
                Object[] objArr11 = this.elementData;
                if (i4 >= objArr11.length) {
                    ArraysKt.l(objArr11, objArr11, i4 - objArr11.length, o2, objArr11.length);
                } else {
                    ArraysKt.l(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.l(objArr12, objArr12, i4, o2, objArr12.length - size);
                }
            }
            a(o2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        Intrinsics.h(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        f(size() + elements.size());
        a(o(this.head + size()), elements);
        return true;
    }

    public final void addFirst(Object element) {
        registerModification();
        f(size() + 1);
        int e2 = e(this.head);
        this.head = e2;
        this.elementData[e2] = element;
        this.size = size() + 1;
    }

    public final void addLast(Object element) {
        registerModification();
        f(size() + 1);
        this.elementData[o(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            n(this.head, o(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int index) {
        AbstractList.INSTANCE.b(index, size());
        return this.elementData[o(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: getSize, reason: from getter */
    public int getLength() {
        return this.size;
    }

    public final Object i() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i;
        int o = o(this.head + size());
        int i2 = this.head;
        if (i2 < o) {
            while (i2 < o) {
                if (Intrinsics.c(element, this.elementData[i2])) {
                    i = this.head;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (i2 < o) {
            return -1;
        }
        int length = this.elementData.length;
        while (true) {
            if (i2 >= length) {
                for (int i3 = 0; i3 < o; i3++) {
                    if (Intrinsics.c(element, this.elementData[i3])) {
                        i2 = i3 + this.elementData.length;
                        i = this.head;
                    }
                }
                return -1;
            }
            if (Intrinsics.c(element, this.elementData[i2])) {
                i = this.head;
                break;
            }
            i2++;
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object l() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[o(this.head + CollectionsKt.n(this))];
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.elementData[o(this.head + CollectionsKt.n(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int Y;
        int i;
        int o = o(this.head + size());
        int i2 = this.head;
        if (i2 < o) {
            Y = o - 1;
            if (i2 <= Y) {
                while (!Intrinsics.c(element, this.elementData[Y])) {
                    if (Y != i2) {
                        Y--;
                    }
                }
                i = this.head;
                return Y - i;
            }
            return -1;
        }
        if (i2 > o) {
            int i3 = o - 1;
            while (true) {
                if (-1 >= i3) {
                    Y = ArraysKt.Y(this.elementData);
                    int i4 = this.head;
                    if (i4 <= Y) {
                        while (!Intrinsics.c(element, this.elementData[Y])) {
                            if (Y != i4) {
                                Y--;
                            }
                        }
                        i = this.head;
                    }
                } else {
                    if (Intrinsics.c(element, this.elementData[i3])) {
                        Y = i3 + this.elementData.length;
                        i = this.head;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    public final Object p() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final Object q() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        int o;
        Intrinsics.h(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int o2 = o(this.head + size());
            int i = this.head;
            if (i < o2) {
                o = i;
                while (i < o2) {
                    Object obj = this.elementData[i];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[o] = obj;
                        o++;
                    }
                    i++;
                }
                ArraysKt.u(this.elementData, null, o, o2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                o = o(i2);
                for (int i3 = 0; i3 < o2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[o] = obj3;
                        o = j(o);
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = m(o - this.head);
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int index) {
        AbstractList.INSTANCE.b(index, size());
        if (index == CollectionsKt.n(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        registerModification();
        int o = o(this.head + index);
        Object obj = this.elementData[o];
        if (index < (size() >> 1)) {
            int i = this.head;
            if (o >= i) {
                Object[] objArr = this.elementData;
                ArraysKt.l(objArr, objArr, i + 1, i, o);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.l(objArr2, objArr2, 1, 0, o);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.head;
                ArraysKt.l(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i3 = this.head;
            objArr4[i3] = null;
            this.head = j(i3);
        } else {
            int o2 = o(this.head + CollectionsKt.n(this));
            if (o <= o2) {
                Object[] objArr5 = this.elementData;
                ArraysKt.l(objArr5, objArr5, o, o + 1, o2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.l(objArr6, objArr6, o, o + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.l(objArr7, objArr7, 0, 1, o2 + 1);
            }
            this.elementData[o2] = null;
        }
        this.size = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i = this.head;
        Object obj = objArr[i];
        objArr[i] = null;
        this.head = j(i);
        this.size = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int o = o(this.head + CollectionsKt.n(this));
        Object[] objArr = this.elementData;
        Object obj = objArr[o];
        objArr[o] = null;
        this.size = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.d(fromIndex, toIndex, size());
        int i = toIndex - fromIndex;
        if (i == 0) {
            return;
        }
        if (i == size()) {
            clear();
            return;
        }
        if (i == 1) {
            remove(fromIndex);
            return;
        }
        registerModification();
        if (fromIndex < size() - toIndex) {
            r(fromIndex, toIndex);
            int o = o(this.head + i);
            n(this.head, o);
            this.head = o;
        } else {
            s(fromIndex, toIndex);
            int o2 = o(this.head + size());
            n(m(o2 - i), o2);
        }
        this.size = size() - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int o;
        Intrinsics.h(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int o2 = o(this.head + size());
            int i = this.head;
            if (i < o2) {
                o = i;
                while (i < o2) {
                    Object obj = this.elementData[i];
                    if (elements.contains(obj)) {
                        this.elementData[o] = obj;
                        o++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt.u(this.elementData, null, o, o2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                o = o(i2);
                for (int i3 = 0; i3 < o2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[o] = obj3;
                        o = j(o);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = m(o - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int index, Object element) {
        AbstractList.INSTANCE.b(index, size());
        int o = o(this.head + index);
        Object[] objArr = this.elementData;
        Object obj = objArr[o];
        objArr[o] = element;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        Intrinsics.h(array, "array");
        if (array.length < size()) {
            array = d.a(array, size());
        }
        int o = o(this.head + size());
        int i = this.head;
        if (i < o) {
            ArraysKt.p(this.elementData, array, 0, i, o, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.l(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.l(objArr2, array, objArr2.length - this.head, 0, o);
        }
        return CollectionsKt.g(size(), array);
    }
}
