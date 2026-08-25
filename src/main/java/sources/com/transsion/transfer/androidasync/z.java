package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class z extends o {
    SocketChannel b;

    z(SocketChannel socketChannel) {
        super(socketChannel);
        this.b = socketChannel;
    }

    @Override // com.transsion.transfer.androidasync.o
    public boolean h() {
        return this.b.isConnected();
    }

    @Override // com.transsion.transfer.androidasync.o
    public SelectionKey j(Selector selector) {
        return k(selector, 8);
    }

    @Override // com.transsion.transfer.androidasync.o
    public void l() {
        try {
            this.b.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    @Override // com.transsion.transfer.androidasync.o
    public int m(ByteBuffer[] byteBufferArr) {
        return (int) this.b.write(byteBufferArr);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.b.read(byteBuffer);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) {
        return this.b.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) {
        return this.b.read(byteBufferArr, i, i2);
    }
}
