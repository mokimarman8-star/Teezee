package v9;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.q1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements s {
    @Override // v9.s
    public int a(q1 q1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.k(4);
        return -4;
    }

    @Override // v9.s
    public boolean isReady() {
        return true;
    }

    @Override // v9.s
    public void maybeThrowError() {
    }

    @Override // v9.s
    public int skipData(long j) {
        return 0;
    }
}
