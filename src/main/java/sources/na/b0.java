package na;

import com.google.android.exoplayer2.a3;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.source.o;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class b0 {
    private a a;
    private com.google.android.exoplayer2.upstream.e b;

    public interface a {
        void onTrackSelectionsInvalidated();
    }

    protected final com.google.android.exoplayer2.upstream.e a() {
        return (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.i(this.b);
    }

    public z b() {
        return z.A;
    }

    public void c(a aVar, com.google.android.exoplayer2.upstream.e eVar) {
        this.a = aVar;
        this.b = eVar;
    }

    protected final void d() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public boolean e() {
        return false;
    }

    public abstract void f(Object obj);

    public void g() {
        this.a = null;
        this.b = null;
    }

    public abstract c0 h(a3[] a3VarArr, v9.y yVar, o.b bVar, l3 l3Var);

    public void i(com.google.android.exoplayer2.audio.e eVar) {
    }

    public void j(z zVar) {
    }
}
