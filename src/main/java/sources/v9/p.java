package v9;

import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ p.a a;
    public final /* synthetic */ com.google.android.exoplayer2.source.p b;
    public final /* synthetic */ o.b c;
    public final /* synthetic */ i d;

    public /* synthetic */ p(p.a aVar, com.google.android.exoplayer2.source.p pVar, o.b bVar, i iVar) {
        this.a = aVar;
        this.b = pVar;
        this.c = bVar;
        this.d = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a.d(this.a, this.b, this.c, this.d);
    }
}
