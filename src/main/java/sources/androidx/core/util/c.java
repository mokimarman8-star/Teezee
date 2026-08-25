package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.collections.LongIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {

    public static final class a extends LongIterator {

        /* renamed from: a, reason: collision with root package name */
        private int f7122a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LongSparseArray f7123b;

        a(LongSparseArray longSparseArray) {
            this.f7123b = longSparseArray;
        }

        public long a() {
            LongSparseArray longSparseArray = this.f7123b;
            int i5 = this.f7122a;
            this.f7122a = i5 + 1;
            return longSparseArray.keyAt(i5);
        }

        public boolean hasNext() {
            return this.f7122a < this.f7123b.size();
        }
    }

    public static final LongIterator a(LongSparseArray longSparseArray) {
        return new a(longSparseArray);
    }
}
