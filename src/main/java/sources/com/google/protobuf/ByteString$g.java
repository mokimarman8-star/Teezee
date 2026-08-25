package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ByteString$g extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private byte[] buffer;
    private int bufferPos;
    private final ArrayList<ByteString> flushedBuffers;
    private int flushedBuffersTotalBytes;
    private final int initialCapacity;

    ByteString$g(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Buffer size < 0");
        }
        this.initialCapacity = i;
        this.flushedBuffers = new ArrayList<>();
        this.buffer = new byte[i];
    }

    private void flushFullBuffer(int i) {
        this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
        int length = this.flushedBuffersTotalBytes + this.buffer.length;
        this.flushedBuffersTotalBytes = length;
        this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i, length >>> 1))];
        this.bufferPos = 0;
    }

    private void flushLastBuffer() {
        int i = this.bufferPos;
        byte[] bArr = this.buffer;
        if (i >= bArr.length) {
            this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
        } else if (i > 0) {
            this.flushedBuffers.add(new ByteString.LiteralByteString(Arrays.copyOf(bArr, i)));
        }
        this.flushedBuffersTotalBytes += this.bufferPos;
        this.bufferPos = 0;
    }

    public synchronized void reset() {
        this.flushedBuffers.clear();
        this.flushedBuffersTotalBytes = 0;
        this.bufferPos = 0;
    }

    public synchronized int size() {
        return this.flushedBuffersTotalBytes + this.bufferPos;
    }

    public synchronized ByteString toByteString() {
        flushLastBuffer();
        return ByteString.copyFrom(this.flushedBuffers);
    }

    public String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        try {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPos;
            this.bufferPos = i2 + 1;
            bArr[i2] = (byte) i;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        try {
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i3 = this.bufferPos;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.bufferPos += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                flushFullBuffer(i4);
                System.arraycopy(bArr, i + length2, this.buffer, 0, i4);
                this.bufferPos = i4;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int i;
        ByteString[] byteStringArr;
        byte[] bArr;
        int i2;
        synchronized (this) {
            byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);
            bArr = this.buffer;
            i2 = this.bufferPos;
        }
        for (ByteString byteString : byteStringArr) {
            byteString.writeTo(outputStream);
        }
        outputStream.write(Arrays.copyOf(bArr, i2));
    }
}
