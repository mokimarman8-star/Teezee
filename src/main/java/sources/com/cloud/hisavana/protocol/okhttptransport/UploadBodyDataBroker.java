package com.cloud.hisavana.protocol.okhttptransport;

import android.util.Pair;
import com.google.common.base.m;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class UploadBodyDataBroker implements Sink {
    private final BlockingQueue a = new ArrayBlockingQueue(1);
    private final AtomicBoolean b = new AtomicBoolean();
    private final AtomicReference c = new AtomicReference();

    enum ReadResult {
        SUCCESS,
        END_OF_BODY
    }

    UploadBodyDataBroker() {
    }

    private Pair d() {
        try {
            return (Pair) this.a.take();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for a read to finish!");
        }
    }

    Future b(ByteBuffer byteBuffer) {
        Throwable th = (Throwable) this.c.get();
        if (th != null) {
            return Futures.e(th);
        }
        y s = y.s();
        this.a.add(Pair.create(byteBuffer, s));
        Throwable th2 = (Throwable) this.c.get();
        if (th2 != null) {
            s.setException(th2);
        }
        return s;
    }

    public void close() {
        this.b.set(true);
    }

    public void flush() {
    }

    void h() {
        if (this.b.getAndSet(true)) {
            throw new IllegalStateException("Already closed");
        }
        ((y) d().second).set(ReadResult.END_OF_BODY);
    }

    void j(Throwable th) {
        this.c.set(th);
        Pair pair = (Pair) this.a.poll();
        if (pair != null) {
            ((y) pair.second).setException(th);
        }
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j) {
        m.u(!this.b.get());
        while (j != 0) {
            Pair d = d();
            ByteBuffer byteBuffer = (ByteBuffer) d.first;
            y yVar = (y) d.second;
            int limit = byteBuffer.limit();
            byteBuffer.limit((int) Math.min(limit, j));
            try {
                long read = buffer.read(byteBuffer);
                if (read == -1) {
                    IOException iOException = new IOException("The source has been exhausted but we expected more!");
                    yVar.setException(iOException);
                    throw iOException;
                }
                j -= read;
                byteBuffer.limit(limit);
                yVar.set(ReadResult.SUCCESS);
            } catch (IOException e) {
                yVar.setException(e);
                throw e;
            }
        }
    }
}
