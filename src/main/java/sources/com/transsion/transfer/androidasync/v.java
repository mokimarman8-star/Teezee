package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class v implements st.d {
    Charset a;
    ByteBufferList b;
    a c;

    public interface a {
        void a(String str);
    }

    public v() {
        this(null);
    }

    public v(Charset charset) {
        this.b = new ByteBufferList();
        this.a = charset;
    }

    @Override // st.d
    public void C(p pVar, ByteBufferList byteBufferList) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBufferList.C());
        while (byteBufferList.C() > 0) {
            byte e = byteBufferList.e();
            if (e == 10) {
                allocate.flip();
                this.b.a(allocate);
                this.c.a(this.b.z(this.a));
                this.b = new ByteBufferList();
                return;
            }
            allocate.put(e);
        }
        allocate.flip();
        this.b.a(allocate);
    }

    public void a(a aVar) {
        this.c = aVar;
    }
}
