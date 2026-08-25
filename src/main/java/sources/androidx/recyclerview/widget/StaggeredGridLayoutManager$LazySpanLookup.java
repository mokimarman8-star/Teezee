package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class StaggeredGridLayoutManager$LazySpanLookup {

    /* renamed from: a, reason: collision with root package name */
    int[] f12891a;

    /* renamed from: b, reason: collision with root package name */
    List f12892b;

    @SuppressLint({"BanParcelableUsage"})
    static class FullSpanItem implements Parcelable {
        public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f12893a;

        /* renamed from: b, reason: collision with root package name */
        int f12894b;

        /* renamed from: c, reason: collision with root package name */
        int[] f12895c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12896d;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public FullSpanItem createFromParcel(Parcel parcel) {
                return new FullSpanItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public FullSpanItem[] newArray(int i5) {
                return new FullSpanItem[i5];
            }
        }

        FullSpanItem() {
        }

        FullSpanItem(Parcel parcel) {
            this.f12893a = parcel.readInt();
            this.f12894b = parcel.readInt();
            this.f12896d = parcel.readInt() == 1;
            int readInt = parcel.readInt();
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f12895c = iArr;
                parcel.readIntArray(iArr);
            }
        }

        int a(int i5) {
            int[] iArr = this.f12895c;
            if (iArr == null) {
                return 0;
            }
            return iArr[i5];
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "FullSpanItem{mPosition=" + this.f12893a + ", mGapDir=" + this.f12894b + ", mHasUnwantedGapAfter=" + this.f12896d + ", mGapPerSpan=" + Arrays.toString(this.f12895c) + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.f12893a);
            parcel.writeInt(this.f12894b);
            parcel.writeInt(this.f12896d ? 1 : 0);
            int[] iArr = this.f12895c;
            if (iArr == null || iArr.length <= 0) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f12895c);
            }
        }
    }

    StaggeredGridLayoutManager$LazySpanLookup() {
    }

    private int i(int i5) {
        if (this.f12892b == null) {
            return -1;
        }
        FullSpanItem f5 = f(i5);
        if (f5 != null) {
            this.f12892b.remove(f5);
        }
        int size = this.f12892b.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            }
            if (((FullSpanItem) this.f12892b.get(i6)).f12893a >= i5) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            return -1;
        }
        FullSpanItem fullSpanItem = (FullSpanItem) this.f12892b.get(i6);
        this.f12892b.remove(i6);
        return fullSpanItem.f12893a;
    }

    private void l(int i5, int i6) {
        List list = this.f12892b;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.f12892b.get(size);
            int i7 = fullSpanItem.f12893a;
            if (i7 >= i5) {
                fullSpanItem.f12893a = i7 + i6;
            }
        }
    }

    private void m(int i5, int i6) {
        List list = this.f12892b;
        if (list == null) {
            return;
        }
        int i7 = i5 + i6;
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.f12892b.get(size);
            int i8 = fullSpanItem.f12893a;
            if (i8 >= i5) {
                if (i8 < i7) {
                    this.f12892b.remove(size);
                } else {
                    fullSpanItem.f12893a = i8 - i6;
                }
            }
        }
    }

    public void a(FullSpanItem fullSpanItem) {
        if (this.f12892b == null) {
            this.f12892b = new ArrayList();
        }
        int size = this.f12892b.size();
        for (int i5 = 0; i5 < size; i5++) {
            FullSpanItem fullSpanItem2 = (FullSpanItem) this.f12892b.get(i5);
            if (fullSpanItem2.f12893a == fullSpanItem.f12893a) {
                this.f12892b.remove(i5);
            }
            if (fullSpanItem2.f12893a >= fullSpanItem.f12893a) {
                this.f12892b.add(i5, fullSpanItem);
                return;
            }
        }
        this.f12892b.add(fullSpanItem);
    }

    void b() {
        int[] iArr = this.f12891a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f12892b = null;
    }

    void c(int i5) {
        int[] iArr = this.f12891a;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i5, 10) + 1];
            this.f12891a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i5 >= iArr.length) {
            int[] iArr3 = new int[o(i5)];
            this.f12891a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.f12891a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    int d(int i5) {
        List list = this.f12892b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (((FullSpanItem) this.f12892b.get(size)).f12893a >= i5) {
                    this.f12892b.remove(size);
                }
            }
        }
        return h(i5);
    }

    public FullSpanItem e(int i5, int i6, int i7, boolean z5) {
        List list = this.f12892b;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.f12892b.get(i8);
            int i9 = fullSpanItem.f12893a;
            if (i9 >= i6) {
                return null;
            }
            if (i9 >= i5 && (i7 == 0 || fullSpanItem.f12894b == i7 || (z5 && fullSpanItem.f12896d))) {
                return fullSpanItem;
            }
        }
        return null;
    }

    public FullSpanItem f(int i5) {
        List list = this.f12892b;
        if (list == null) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.f12892b.get(size);
            if (fullSpanItem.f12893a == i5) {
                return fullSpanItem;
            }
        }
        return null;
    }

    int g(int i5) {
        int[] iArr = this.f12891a;
        if (iArr == null || i5 >= iArr.length) {
            return -1;
        }
        return iArr[i5];
    }

    int h(int i5) {
        int[] iArr = this.f12891a;
        if (iArr == null || i5 >= iArr.length) {
            return -1;
        }
        int i6 = i(i5);
        if (i6 == -1) {
            int[] iArr2 = this.f12891a;
            Arrays.fill(iArr2, i5, iArr2.length, -1);
            return this.f12891a.length;
        }
        int min = Math.min(i6 + 1, this.f12891a.length);
        Arrays.fill(this.f12891a, i5, min, -1);
        return min;
    }

    void j(int i5, int i6) {
        int[] iArr = this.f12891a;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        c(i7);
        int[] iArr2 = this.f12891a;
        System.arraycopy(iArr2, i5, iArr2, i7, (iArr2.length - i5) - i6);
        Arrays.fill(this.f12891a, i5, i7, -1);
        l(i5, i6);
    }

    void k(int i5, int i6) {
        int[] iArr = this.f12891a;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        c(i7);
        int[] iArr2 = this.f12891a;
        System.arraycopy(iArr2, i7, iArr2, i5, (iArr2.length - i5) - i6);
        int[] iArr3 = this.f12891a;
        Arrays.fill(iArr3, iArr3.length - i6, iArr3.length, -1);
        m(i5, i6);
    }

    void n(int i5, StaggeredGridLayoutManager$c staggeredGridLayoutManager$c) {
        c(i5);
        this.f12891a[i5] = staggeredGridLayoutManager$c.f12910e;
    }

    int o(int i5) {
        int length = this.f12891a.length;
        while (length <= i5) {
            length *= 2;
        }
        return length;
    }
}
