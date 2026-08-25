package v9;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ p.a a;
    public final /* synthetic */ com.google.android.exoplayer2.source.p b;
    public final /* synthetic */ h c;
    public final /* synthetic */ i d;
    public final /* synthetic */ IOException e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ m(p.a aVar, com.google.android.exoplayer2.source.p pVar, h hVar, i iVar, IOException iOException, boolean z) {
        this.a = aVar;
        this.b = pVar;
        this.c = hVar;
        this.d = iVar;
        this.e = iOException;
        this.f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a.b(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
