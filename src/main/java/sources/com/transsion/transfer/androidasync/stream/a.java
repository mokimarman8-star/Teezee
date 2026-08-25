package com.transsion.transfer.androidasync.stream;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.p;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import st.d;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a implements d, st.a {
    private OutputStream a;

    public a(OutputStream outputStream) {
        this.a = outputStream;
    }

    @Override // st.d
    public void C(p pVar, ByteBufferList byteBufferList) {
        while (byteBufferList.E() > 0) {
            try {
                try {
                    ByteBuffer D = byteBufferList.D();
                    this.a.write(D.array(), D.arrayOffset() + D.position(), D.remaining());
                    ByteBufferList.A(D);
                } catch (Exception e) {
                    g(e);
                }
            } finally {
                byteBufferList.B();
            }
        }
    }

    @Override // st.a
    public void g(Exception exc) {
        exc.printStackTrace();
    }
}
