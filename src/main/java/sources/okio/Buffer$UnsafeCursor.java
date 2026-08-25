package okio;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", HttpUrl.FRAGMENT_ENCODE_SET, "end", HttpUrl.FRAGMENT_ENCODE_SET, "offset", HttpUrl.FRAGMENT_ENCODE_SET, "readWrite", HttpUrl.FRAGMENT_ENCODE_SET, "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", MRAIDPresenter.CLOSE, HttpUrl.FRAGMENT_ENCODE_SET, "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Buffer$UnsafeCursor implements Closeable {

    @JvmField
    public Buffer buffer;

    @JvmField
    public byte[] data;

    @JvmField
    public boolean readWrite;
    private Segment segment;

    @JvmField
    public long offset = -1;

    @JvmField
    public int start = -1;

    @JvmField
    public int end = -1;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.buffer = null;
        setSegment$okio(null);
        this.offset = -1L;
        this.data = null;
        this.start = -1;
        this.end = -1;
    }

    public final long expandBuffer(int minByteCount) {
        if (minByteCount <= 0) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + minByteCount).toString());
        }
        if (minByteCount > 8192) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + minByteCount).toString());
        }
        Buffer buffer = this.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        Segment writableSegment$okio = buffer.writableSegment$okio(minByteCount);
        int i = 8192 - writableSegment$okio.limit;
        writableSegment$okio.limit = 8192;
        long j = i;
        buffer.setSize$okio(size + j);
        setSegment$okio(writableSegment$okio);
        this.offset = size;
        this.data = writableSegment$okio.data;
        this.start = 8192 - i;
        this.end = 8192;
        return j;
    }

    /* renamed from: getSegment$okio, reason: from getter */
    public final Segment getSegment() {
        return this.segment;
    }

    public final int next() {
        long j = this.offset;
        Buffer buffer = this.buffer;
        Intrinsics.e(buffer);
        if (j == buffer.size()) {
            throw new IllegalStateException("no more bytes");
        }
        long j2 = this.offset;
        return seek(j2 == -1 ? 0L : j2 + (this.end - this.start));
    }

    public final long resizeBuffer(long newSize) {
        Buffer buffer = this.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        if (newSize <= size) {
            if (newSize < 0) {
                throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
            }
            long j = size - newSize;
            while (true) {
                if (j <= 0) {
                    break;
                }
                Segment segment = buffer.head;
                Intrinsics.e(segment);
                Segment segment2 = segment.prev;
                Intrinsics.e(segment2);
                int i = segment2.limit;
                long j2 = i - segment2.pos;
                if (j2 > j) {
                    segment2.limit = i - ((int) j);
                    break;
                }
                buffer.head = segment2.pop();
                SegmentPool.recycle(segment2);
                j -= j2;
            }
            setSegment$okio(null);
            this.offset = newSize;
            this.data = null;
            this.start = -1;
            this.end = -1;
        } else if (newSize > size) {
            long j3 = newSize - size;
            boolean z = true;
            while (j3 > 0) {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int min = (int) Math.min(j3, 8192 - writableSegment$okio.limit);
                writableSegment$okio.limit += min;
                j3 -= min;
                if (z) {
                    setSegment$okio(writableSegment$okio);
                    this.offset = size;
                    this.data = writableSegment$okio.data;
                    int i2 = writableSegment$okio.limit;
                    this.start = i2 - min;
                    this.end = i2;
                    z = false;
                }
            }
        }
        buffer.setSize$okio(newSize);
        return size;
    }

    public final int seek(long offset) {
        Segment segment;
        Buffer buffer = this.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (offset < -1 || offset > buffer.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + buffer.size());
        }
        if (offset == -1 || offset == buffer.size()) {
            setSegment$okio(null);
            this.offset = offset;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        }
        long size = buffer.size();
        Segment segment2 = buffer.head;
        long j = 0;
        if (getSegment() != null) {
            long j2 = this.offset;
            int i = this.start;
            Intrinsics.e(getSegment());
            long j3 = j2 - (i - r9.pos);
            if (j3 > offset) {
                segment = segment2;
                segment2 = getSegment();
                size = j3;
            } else {
                segment = getSegment();
                j = j3;
            }
        } else {
            segment = segment2;
        }
        if (size - offset > offset - j) {
            while (true) {
                Intrinsics.e(segment);
                int i2 = segment.limit;
                int i3 = segment.pos;
                if (offset < (i2 - i3) + j) {
                    break;
                }
                j += i2 - i3;
                segment = segment.next;
            }
        } else {
            while (size > offset) {
                Intrinsics.e(segment2);
                segment2 = segment2.prev;
                Intrinsics.e(segment2);
                size -= segment2.limit - segment2.pos;
            }
            j = size;
            segment = segment2;
        }
        if (this.readWrite) {
            Intrinsics.e(segment);
            if (segment.shared) {
                Segment unsharedCopy = segment.unsharedCopy();
                if (buffer.head == segment) {
                    buffer.head = unsharedCopy;
                }
                segment = segment.push(unsharedCopy);
                Segment segment3 = segment.prev;
                Intrinsics.e(segment3);
                segment3.pop();
            }
        }
        setSegment$okio(segment);
        this.offset = offset;
        Intrinsics.e(segment);
        this.data = segment.data;
        int i4 = segment.pos + ((int) (offset - j));
        this.start = i4;
        int i5 = segment.limit;
        this.end = i5;
        return i5 - i4;
    }

    public final void setSegment$okio(Segment segment) {
        this.segment = segment;
    }
}
