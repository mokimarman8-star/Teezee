package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class b extends ForwardingSink {
    private boolean a;

    public b(Sink sink) {
        super(sink);
    }

    protected abstract void b(IOException iOException);

    public void close() {
        if (this.a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.a = true;
            b(e);
        }
    }

    public void flush() {
        if (this.a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.a = true;
            b(e);
        }
    }

    public void write(Buffer buffer, long j) {
        if (this.a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.a = true;
            b(e);
        }
    }
}
