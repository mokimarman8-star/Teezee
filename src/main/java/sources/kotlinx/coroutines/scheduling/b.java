package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends e {
    public static final b g = new b();

    private b() {
        super(g.c, g.d, g.e, g.a);
    }

    @Override // kotlinx.coroutines.scheduling.e
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public i0 limitedParallelism(int i, String str) {
        kotlinx.coroutines.internal.i.a(i);
        return i >= g.c ? kotlinx.coroutines.internal.i.b(this, str) : super/*kotlinx.coroutines.i0*/.limitedParallelism(i, str);
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
