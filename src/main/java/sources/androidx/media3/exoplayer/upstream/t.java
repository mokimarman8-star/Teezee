package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class t {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator f11695h = new Comparator() { // from class: androidx.media3.exoplayer.upstream.r
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g5;
            g5 = t.g((t.b) obj, (t.b) obj2);
            return g5;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator f11696i = new Comparator() { // from class: androidx.media3.exoplayer.upstream.s
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h5;
            h5 = t.h((t.b) obj, (t.b) obj2);
            return h5;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f11697a;

    /* renamed from: e, reason: collision with root package name */
    private int f11701e;

    /* renamed from: f, reason: collision with root package name */
    private int f11702f;

    /* renamed from: g, reason: collision with root package name */
    private int f11703g;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f11699c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f11698b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f11700d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f11704a;

        /* renamed from: b, reason: collision with root package name */
        public int f11705b;

        /* renamed from: c, reason: collision with root package name */
        public float f11706c;

        private b() {
        }
    }

    public t(int i5) {
        this.f11697a = i5;
    }

    private void d() {
        if (this.f11700d != 1) {
            Collections.sort(this.f11698b, f11695h);
            this.f11700d = 1;
        }
    }

    private void e() {
        if (this.f11700d != 0) {
            Collections.sort(this.f11698b, f11696i);
            this.f11700d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f11704a - bVar2.f11704a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f11706c, bVar2.f11706c);
    }

    public void c(int i5, float f5) {
        b bVar;
        d();
        int i6 = this.f11703g;
        if (i6 > 0) {
            b[] bVarArr = this.f11699c;
            int i7 = i6 - 1;
            this.f11703g = i7;
            bVar = bVarArr[i7];
        } else {
            bVar = new b();
        }
        int i8 = this.f11701e;
        this.f11701e = i8 + 1;
        bVar.f11704a = i8;
        bVar.f11705b = i5;
        bVar.f11706c = f5;
        this.f11698b.add(bVar);
        this.f11702f += i5;
        while (true) {
            int i9 = this.f11702f;
            int i10 = this.f11697a;
            if (i9 <= i10) {
                return;
            }
            int i11 = i9 - i10;
            b bVar2 = (b) this.f11698b.get(0);
            int i12 = bVar2.f11705b;
            if (i12 <= i11) {
                this.f11702f -= i12;
                this.f11698b.remove(0);
                int i13 = this.f11703g;
                if (i13 < 5) {
                    b[] bVarArr2 = this.f11699c;
                    this.f11703g = i13 + 1;
                    bVarArr2[i13] = bVar2;
                }
            } else {
                bVar2.f11705b = i12 - i11;
                this.f11702f -= i11;
            }
        }
    }

    public float f(float f5) {
        e();
        float f6 = f5 * this.f11702f;
        int i5 = 0;
        for (int i6 = 0; i6 < this.f11698b.size(); i6++) {
            b bVar = (b) this.f11698b.get(i6);
            i5 += bVar.f11705b;
            if (i5 >= f6) {
                return bVar.f11706c;
            }
        }
        if (this.f11698b.isEmpty()) {
            return Float.NaN;
        }
        return ((b) this.f11698b.get(r5.size() - 1)).f11706c;
    }

    public void i() {
        this.f11698b.clear();
        this.f11700d = -1;
        this.f11701e = 0;
        this.f11702f = 0;
    }
}
