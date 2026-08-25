package v9;

import android.net.Uri;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.util.p0;
import i9.a0;
import java.io.EOFException;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements com.google.android.exoplayer2.source.r {
    private final i9.r a;
    private i9.l b;
    private i9.m c;

    public a(i9.r rVar) {
        this.a = rVar;
    }

    public void a() {
        i9.l lVar = this.b;
        if (lVar instanceof p9.f) {
            ((p9.f) lVar).i();
        }
    }

    public long b() {
        i9.m mVar = this.c;
        if (mVar != null) {
            return mVar.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(com.google.android.exoplayer2.upstream.g gVar, Uri uri, Map map, long j, long j2, i9.n nVar) {
        i9.f fVar = new i9.f(gVar, j, j2);
        this.c = fVar;
        if (this.b != null) {
            return;
        }
        i9.l[] c = this.a.c(uri, map);
        if (c.length == 1) {
            this.b = c[0];
        } else {
            int length = c.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                i9.l lVar = c[i];
                try {
                } catch (EOFException unused) {
                    if (this.b == null) {
                    }
                } catch (Throwable th) {
                    com.google.android.exoplayer2.util.a.g(this.b != null || fVar.getPosition() == j);
                    fVar.resetPeekPosition();
                    throw th;
                }
                if (lVar.c(fVar)) {
                    this.b = lVar;
                    com.google.android.exoplayer2.util.a.g(true);
                    fVar.resetPeekPosition();
                    break;
                } else {
                    if (this.b == null) {
                    }
                    boolean z = true;
                    com.google.android.exoplayer2.util.a.g(z);
                    fVar.resetPeekPosition();
                    i++;
                }
            }
            if (this.b == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + p0.M(c) + ") could read the stream.", (Uri) com.google.android.exoplayer2.util.a.e(uri));
            }
        }
        this.b.b(nVar);
    }

    public int d(a0 a0Var) {
        return ((i9.l) com.google.android.exoplayer2.util.a.e(this.b)).d((i9.m) com.google.android.exoplayer2.util.a.e(this.c), a0Var);
    }

    public void release() {
        i9.l lVar = this.b;
        if (lVar != null) {
            lVar.release();
            this.b = null;
        }
        this.c = null;
    }

    public void seek(long j, long j2) {
        ((i9.l) com.google.android.exoplayer2.util.a.e(this.b)).seek(j, j2);
    }
}
