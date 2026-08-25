package da;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class h extends SimpleDecoder implements j {
    private final String n;

    class a extends n {
        a() {
        }

        public void l() {
            h.this.n(this);
        }
    }

    protected h(String str) {
        super(new m[2], new n[2]);
        this.n = str;
        q(MemoryConstants.KB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final m c() {
        return new m();
    }

    @Override // da.j
    public void setPositionUs(long j) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final n d() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException e(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException f(m mVar, n nVar, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(((DecoderInputBuffer) mVar).c);
            nVar.m(((DecoderInputBuffer) mVar).e, w(byteBuffer.array(), byteBuffer.limit(), z), mVar.i);
            nVar.d(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    protected abstract i w(byte[] bArr, int i, boolean z);
}
