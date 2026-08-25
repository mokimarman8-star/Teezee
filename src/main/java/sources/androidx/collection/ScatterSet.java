package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class ScatterSet {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1243a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1244b;

    /* renamed from: c, reason: collision with root package name */
    public int f1245c;

    /* renamed from: d, reason: collision with root package name */
    public int f1246d;

    public class a implements Set, KMappedMarker {
        public a() {
        }

        public int a() {
            return ScatterSet.this.f1246d;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return ScatterSet.this.a(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Intrinsics.h(collection, "elements");
            ScatterSet scatterSet = ScatterSet.this;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!scatterSet.a(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ScatterSet.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Intrinsics.h(objArr, "array");
            return CollectionToArray.b(this, objArr);
        }
    }

    private ScatterSet() {
        this.f1243a = v0.f1350a;
        this.f1244b = n.a.f16551c;
    }

    public /* synthetic */ ScatterSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String g(ScatterSet scatterSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i6 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i6 & 4) == 0 ? charSequence3 : "";
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            function1 = null;
        }
        return scatterSet.f(charSequence, charSequence5, charSequence6, i7, charSequence7, function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Object obj) {
        int i5;
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 & 127;
        int i8 = this.f1245c;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.f1243a;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = (i7 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j7) >> 3) + i9) & i8;
                if (Intrinsics.c(this.f1244b[i5], obj)) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        return i5 >= 0;
    }

    public final int b() {
        return this.f1245c;
    }

    public final int c() {
        return this.f1246d;
    }

    public final boolean d() {
        return this.f1246d == 0;
    }

    public final boolean e() {
        return this.f1246d != 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ScatterSet)) {
            return false;
        }
        ScatterSet scatterSet = (ScatterSet) obj;
        if (scatterSet.c() != c()) {
            return false;
        }
        Object[] objArr = this.f1244b;
        long[] jArr = this.f1243a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && !scatterSet.a(objArr[(i5 << 3) + i7])) {
                            return false;
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return true;
    }

    public final String f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.f1244b;
        long[] jArr = this.f1243a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i10 = 0; i10 < i9; i10++) {
                        if ((j5 & 255) < 128) {
                            Object obj = objArr[(i6 << 3) + i10];
                            if (i7 == i5) {
                                sb.append(charSequence4);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence);
                            }
                            if (function1 == null) {
                                sb.append(obj);
                            } else {
                                sb.append((CharSequence) function1.invoke(obj));
                            }
                            i7++;
                            i8 = 8;
                        }
                        j5 >>= i8;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append(charSequence3);
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        Object[] objArr = this.f1244b;
        long[] jArr = this.f1243a;
        int length = jArr.length - 2;
        int i5 = 0;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j5) < 128) {
                            Object obj = objArr[(i6 << 3) + i9];
                            i7 += obj != null ? obj.hashCode() : 0;
                        }
                        j5 >>= 8;
                    }
                    if (i8 != 8) {
                        return i7;
                    }
                }
                if (i6 == length) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
        }
        return i5;
    }

    public String toString() {
        return g(this, null, "[", "]", 0, null, new Function1<Object, CharSequence>() { // from class: androidx.collection.ScatterSet$toString$1
            {
                super(1);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CharSequence m19invoke(Object obj) {
                return obj == ScatterSet.this ? "(this)" : String.valueOf(obj);
            }
        }, 25, null);
    }
}
