package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class o implements ReadableByteChannel, ScatteringByteChannel {
    private AbstractSelectableChannel a;

    o(AbstractSelectableChannel abstractSelectableChannel) {
        abstractSelectableChannel.configureBlocking(false);
        this.a = abstractSelectableChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public boolean d() {
        return false;
    }

    public abstract boolean h();

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.a.isOpen();
    }

    public abstract SelectionKey j(Selector selector);

    public SelectionKey k(Selector selector, int i) {
        return this.a.register(selector, i);
    }

    public abstract void l();

    public abstract int m(ByteBuffer[] byteBufferArr);
}
