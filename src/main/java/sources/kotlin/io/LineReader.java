package kotlin.io;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlin/io/LineReader;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "b", "[B", "bytes", HttpUrl.FRAGMENT_ENCODE_SET, "c", "[C", "chars", "Ljava/nio/ByteBuffer;", "d", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/CharBuffer;", "e", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "f", "Ljava/lang/StringBuilder;", "sb", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LineReader {
    public static final LineReader a = new LineReader();

    /* renamed from: b, reason: from kotlin metadata */
    private static final byte[] bytes;

    /* renamed from: c, reason: from kotlin metadata */
    private static final char[] chars;

    /* renamed from: d, reason: from kotlin metadata */
    private static final ByteBuffer byteBuf;

    /* renamed from: e, reason: from kotlin metadata */
    private static final CharBuffer charBuf;

    /* renamed from: f, reason: from kotlin metadata */
    private static final StringBuilder sb;

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        char[] cArr = new char[32];
        chars = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.g(wrap, "wrap(...)");
        byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        Intrinsics.g(wrap2, "wrap(...)");
        charBuf = wrap2;
        sb = new StringBuilder();
    }

    private LineReader() {
    }
}
