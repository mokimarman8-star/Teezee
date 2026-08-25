package com.transsion.transfer.androidasync;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class u extends n {
    public u(s sVar) {
        super(sVar);
        o(0);
    }

    @Override // com.transsion.transfer.androidasync.n
    protected void j(ByteBufferList byteBufferList) {
        ByteBufferList r = r(byteBufferList);
        if (r != byteBufferList) {
            byteBufferList.B();
            r.f(byteBufferList);
        }
    }

    public abstract ByteBufferList r(ByteBufferList byteBufferList);
}
