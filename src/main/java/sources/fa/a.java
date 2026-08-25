package fa;

import com.google.android.exoplayer2.util.d0;
import da.h;
import da.i;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends h {
    private final b o;

    public a(List list) {
        super("DvbDecoder");
        d0 d0Var = new d0((byte[]) list.get(0));
        this.o = new b(d0Var.J(), d0Var.J());
    }

    @Override // da.h
    protected i w(byte[] bArr, int i, boolean z) {
        if (z) {
            this.o.r();
        }
        return new c(this.o.b(bArr, i));
    }
}
