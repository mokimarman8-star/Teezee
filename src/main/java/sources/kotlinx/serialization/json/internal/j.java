package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class j {
    public final h0 a;
    private boolean b;

    public j(h0 writer) {
        Intrinsics.h(writer, "writer");
        this.a = writer;
        this.b = true;
    }

    public final boolean a() {
        return this.b;
    }

    public void b() {
        this.b = true;
    }

    public void c() {
        this.b = false;
    }

    public void d(byte b) {
        this.a.writeLong(b);
    }

    public final void e(char c) {
        this.a.a(c);
    }

    public void f(double d) {
        this.a.c(String.valueOf(d));
    }

    public void g(float f) {
        this.a.c(String.valueOf(f));
    }

    public void h(int i) {
        this.a.writeLong(i);
    }

    public void i(long j) {
        this.a.writeLong(j);
    }

    public final void j(String v) {
        Intrinsics.h(v, "v");
        this.a.c(v);
    }

    public void k(short s) {
        this.a.writeLong(s);
    }

    public void l(boolean z) {
        this.a.c(String.valueOf(z));
    }

    public final void m(String value) {
        Intrinsics.h(value, "value");
        this.a.b(value);
    }

    protected final void n(boolean z) {
        this.b = z;
    }

    public void o() {
    }

    public void p() {
    }
}
