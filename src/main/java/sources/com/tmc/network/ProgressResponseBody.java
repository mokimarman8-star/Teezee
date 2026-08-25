package com.tmc.network;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tmc/network/ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "mListener", "Lcom/tmc/network/ProgressListener;", "(Lokhttp3/ResponseBody;Lcom/tmc/network/ProgressListener;)V", "bufferedSource", "Lokio/BufferedSource;", "contentLength", TtmlNode.ANONYMOUS_REGION_ID, "contentType", "Lokhttp3/MediaType;", "mySource", "Lokio/Source;", "source", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private final ProgressListener mListener;
    private final ResponseBody responseBody;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        Intrinsics.h(responseBody, "responseBody");
        this.responseBody = responseBody;
        this.mListener = progressListener;
    }

    private final Source mySource(final Source source) {
        return new ForwardingSource(source) { // from class: com.tmc.network.ProgressResponseBody$mySource$1
            final /* synthetic */ Source $source;
            private long totalBytesRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(source);
                this.$source = source;
            }

            public final long getTotalBytesRead() {
                return this.totalBytesRead;
            }

            public long read(Buffer sink, long byteCount) throws IOException {
                ProgressListener progressListener;
                Intrinsics.h(sink, "sink");
                long read = super.read(sink, byteCount);
                this.totalBytesRead += read != -1 ? read : 0L;
                progressListener = ProgressResponseBody.this.mListener;
                if (progressListener != null) {
                    progressListener.onProgress(this.totalBytesRead, ProgressResponseBody.this.contentLength(), this.totalBytesRead == ProgressResponseBody.this.contentLength());
                }
                return read;
            }

            public final void setTotalBytesRead(long j) {
                this.totalBytesRead = j;
            }
        };
    }

    public long contentLength() {
        return this.responseBody.contentLength();
    }

    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(mySource(this.responseBody.source()));
        }
        BufferedSource bufferedSource = this.bufferedSource;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        throw new NullPointerException("null cannot be cast to non-null type okio.BufferedSource");
    }
}
