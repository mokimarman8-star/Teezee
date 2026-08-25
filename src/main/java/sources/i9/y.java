package i9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.b;
import java.io.EOFException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class y {
    private final com.google.android.exoplayer2.util.d0 a = new com.google.android.exoplayer2.util.d0(10);

    public Metadata a(m mVar, b.a aVar) {
        Metadata metadata = null;
        int i = 0;
        while (true) {
            try {
                mVar.peekFully(this.a.d(), 0, 10);
                this.a.P(0);
                if (this.a.G() != 4801587) {
                    break;
                }
                this.a.Q(3);
                int C = this.a.C();
                int i2 = C + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a.d(), 0, bArr, 0, 10);
                    mVar.peekFully(bArr, 10, C);
                    metadata = new com.google.android.exoplayer2.metadata.id3.b(aVar).e(bArr, i2);
                } else {
                    mVar.advancePeekPosition(C);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i);
        return metadata;
    }
}
