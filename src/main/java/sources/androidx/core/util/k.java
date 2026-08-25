package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.IntIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k {

    public static final class a extends IntIterator {

        /* renamed from: a, reason: collision with root package name */
        private int f7129a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseArray f7130b;

        a(SparseArray sparseArray) {
            this.f7130b = sparseArray;
        }

        public int a() {
            SparseArray sparseArray = this.f7130b;
            int i5 = this.f7129a;
            this.f7129a = i5 + 1;
            return sparseArray.keyAt(i5);
        }

        public boolean hasNext() {
            return this.f7129a < this.f7130b.size();
        }
    }

    public static final IntIterator a(SparseArray sparseArray) {
        return new a(sparseArray);
    }
}
