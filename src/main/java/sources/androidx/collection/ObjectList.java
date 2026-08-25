package androidx.collection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class ObjectList {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1241a;

    /* renamed from: b, reason: collision with root package name */
    public int f1242b;

    private ObjectList(int i5) {
        this.f1241a = i5 == 0 ? r0.f1323a : new Object[i5];
    }

    public /* synthetic */ ObjectList(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static /* synthetic */ String d(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
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
        return objectList.c(charSequence, charSequence5, charSequence6, i7, charSequence7, function1);
    }

    public final boolean a(Object obj) {
        return b(obj) >= 0;
    }

    public final int b(Object obj) {
        int i5 = 0;
        if (obj == null) {
            Object[] objArr = this.f1241a;
            int i6 = this.f1242b;
            while (i5 < i6) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        Object[] objArr2 = this.f1241a;
        int i7 = this.f1242b;
        while (i5 < i7) {
            if (obj.equals(objArr2[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public final String c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.f1241a;
        int i6 = this.f1242b;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            Object obj = objArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
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
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i5 = objectList.f1242b;
            int i6 = this.f1242b;
            if (i5 == i6) {
                Object[] objArr = this.f1241a;
                Object[] objArr2 = objectList.f1241a;
                IntRange s5 = RangesKt.s(0, i6);
                int f5 = s5.f();
                int i7 = s5.i();
                if (f5 > i7) {
                    return true;
                }
                while (Intrinsics.c(objArr[f5], objArr2[f5])) {
                    if (f5 == i7) {
                        return true;
                    }
                    f5++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = this.f1241a;
        int i5 = this.f1242b;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            i6 += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return i6;
    }

    public String toString() {
        return d(this, null, "[", "]", 0, null, new Function1<Object, CharSequence>() { // from class: androidx.collection.ObjectList$toString$1
            {
                super(1);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CharSequence m18invoke(Object obj) {
                return obj == ObjectList.this ? "(this)" : String.valueOf(obj);
            }
        }, 25, null);
    }
}
