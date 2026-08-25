package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class p {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f7948d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final int f7949a;

    /* renamed from: b, reason: collision with root package name */
    private final n f7950b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f7951c = 0;

    p(n nVar, int i5) {
        this.f7950b = nVar;
        this.f7949a = i5;
    }

    private androidx.emoji2.text.flatbuffer.b g() {
        ThreadLocal threadLocal = f7948d;
        androidx.emoji2.text.flatbuffer.b bVar = (androidx.emoji2.text.flatbuffer.b) threadLocal.get();
        if (bVar == null) {
            bVar = new androidx.emoji2.text.flatbuffer.b();
            threadLocal.set(bVar);
        }
        this.f7950b.d().k(bVar, this.f7949a);
        return bVar;
    }

    public void a(Canvas canvas, float f5, float f6, Paint paint) {
        Typeface g5 = this.f7950b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g5);
        canvas.drawText(this.f7950b.c(), this.f7949a * 2, 2, f5, f6, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i5) {
        return g().i(i5);
    }

    public int c() {
        return g().j();
    }

    public int d() {
        return this.f7951c & 3;
    }

    public int e() {
        return g().l();
    }

    public int f() {
        return g().m();
    }

    public short h() {
        return g().n();
    }

    public int i() {
        return g().o();
    }

    public boolean j() {
        return g().k();
    }

    public boolean k() {
        return (this.f7951c & 4) > 0;
    }

    public void l(boolean z5) {
        int d5 = d();
        if (z5) {
            this.f7951c = d5 | 4;
        } else {
            this.f7951c = d5;
        }
    }

    public void m(boolean z5) {
        int i5 = this.f7951c & 4;
        this.f7951c = z5 ? i5 | 2 : i5 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c5 = c();
        for (int i5 = 0; i5 < c5; i5++) {
            sb.append(Integer.toHexString(b(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
