package androidx.media3.container;

import androidx.media3.common.util.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f9259a;

    public static final class b extends d {

        /* renamed from: b, reason: collision with root package name */
        public final long f9260b;

        /* renamed from: c, reason: collision with root package name */
        public final List f9261c;

        /* renamed from: d, reason: collision with root package name */
        public final List f9262d;

        public b(int i5, long j5) {
            super(i5);
            this.f9260b = j5;
            this.f9261c = new ArrayList();
            this.f9262d = new ArrayList();
        }

        public void b(b bVar) {
            this.f9262d.add(bVar);
        }

        public void c(c cVar) {
            this.f9261c.add(cVar);
        }

        public b d(int i5) {
            int size = this.f9262d.size();
            for (int i6 = 0; i6 < size; i6++) {
                b bVar = (b) this.f9262d.get(i6);
                if (bVar.f9259a == i5) {
                    return bVar;
                }
            }
            return null;
        }

        public c e(int i5) {
            int size = this.f9261c.size();
            for (int i6 = 0; i6 < size; i6++) {
                c cVar = (c) this.f9261c.get(i6);
                if (cVar.f9259a == i5) {
                    return cVar;
                }
            }
            return null;
        }

        @Override // androidx.media3.container.d
        public String toString() {
            return d.a(this.f9259a) + " leaves: " + Arrays.toString(this.f9261c.toArray()) + " containers: " + Arrays.toString(this.f9262d.toArray());
        }
    }

    public static final class c extends d {

        /* renamed from: b, reason: collision with root package name */
        public final j0 f9263b;

        public c(int i5, j0 j0Var) {
            super(i5);
            this.f9263b = j0Var;
        }
    }

    private d(int i5) {
        this.f9259a = i5;
    }

    public static String a(int i5) {
        return "" + ((char) ((i5 >> 24) & 255)) + ((char) ((i5 >> 16) & 255)) + ((char) ((i5 >> 8) & 255)) + ((char) (i5 & 255));
    }

    public String toString() {
        return a(this.f9259a);
    }
}
