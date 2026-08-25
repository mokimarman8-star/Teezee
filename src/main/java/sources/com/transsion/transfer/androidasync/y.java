package com.transsion.transfer.androidasync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class y extends o {
    ServerSocketChannel b;

    y(ServerSocketChannel serverSocketChannel) {
        super(serverSocketChannel);
        this.b = serverSocketChannel;
    }

    @Override // com.transsion.transfer.androidasync.o
    public boolean h() {
        return false;
    }

    @Override // com.transsion.transfer.androidasync.o
    public SelectionKey j(Selector selector) {
        return this.b.register(selector, 16);
    }

    @Override // com.transsion.transfer.androidasync.o
    public void l() {
    }

    @Override // com.transsion.transfer.androidasync.o
    public int m(ByteBuffer[] byteBufferArr) {
        throw new IOException("Can't write ServerSocketChannel");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) {
        throw new IOException("Can't read ServerSocketChannel");
    }
}
