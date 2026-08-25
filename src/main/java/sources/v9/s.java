package v9;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.q1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface s {
    int a(q1 q1Var, DecoderInputBuffer decoderInputBuffer, int i);

    boolean isReady();

    void maybeThrowError();

    int skipData(long j);
}
