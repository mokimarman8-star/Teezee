package n9;

import i9.b0;
import i9.c0;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d implements n {
    private final long a;
    private final n b;

    class a implements b0 {
        final /* synthetic */ b0 a;

        a(b0 b0Var) {
            this.a = b0Var;
        }

        @Override // i9.b0
        public long getDurationUs() {
            return this.a.getDurationUs();
        }

        @Override // i9.b0
        public b0.a getSeekPoints(long j) {
            b0.a seekPoints = this.a.getSeekPoints(j);
            c0 c0Var = seekPoints.a;
            c0 c0Var2 = new c0(c0Var.a, c0Var.b + d.this.a);
            c0 c0Var3 = seekPoints.b;
            return new b0.a(c0Var2, new c0(c0Var3.a, c0Var3.b + d.this.a));
        }

        @Override // i9.b0
        public boolean isSeekable() {
            return this.a.isSeekable();
        }
    }

    public d(long j, n nVar) {
        this.a = j;
        this.b = nVar;
    }

    @Override // i9.n
    public void endTracks() {
        this.b.endTracks();
    }

    @Override // i9.n
    public void g(b0 b0Var) {
        this.b.g(new a(b0Var));
    }

    @Override // i9.n
    public e0 track(int i, int i2) {
        return this.b.track(i, i2);
    }
}
