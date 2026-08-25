package v9;

import com.google.android.exoplayer2.source.p;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ p.a a;
    public final /* synthetic */ com.google.android.exoplayer2.source.p b;
    public final /* synthetic */ h c;
    public final /* synthetic */ i d;

    public /* synthetic */ l(p.a aVar, com.google.android.exoplayer2.source.p pVar, h hVar, i iVar) {
        this.a = aVar;
        this.b = pVar;
        this.c = hVar;
        this.d = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a.f(this.a, this.b, this.c, this.d);
    }
}
