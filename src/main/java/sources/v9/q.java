package v9;

import com.google.android.exoplayer2.source.p;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ p.a a;
    public final /* synthetic */ com.google.android.exoplayer2.source.p b;
    public final /* synthetic */ i c;

    public /* synthetic */ q(p.a aVar, com.google.android.exoplayer2.source.p pVar, i iVar) {
        this.a = aVar;
        this.b = pVar;
        this.c = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a.e(this.a, this.b, this.c);
    }
}
