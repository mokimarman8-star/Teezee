package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class w implements st.d {
    static Hashtable n = new Hashtable();
    p i;
    private l a = new a(0);
    private l b = new b(1);
    private l c = new c(2);
    private l d = new d(4);
    private l e = new e(8);
    private j f = new f();
    private j g = new g();
    private j h = new h();
    private LinkedList j = new LinkedList();
    private ArrayList k = new ArrayList();
    ByteOrder l = ByteOrder.BIG_ENDIAN;
    ByteBufferList m = new ByteBufferList();

    class a extends l {
        a(int i) {
            super(i);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.k.add(null);
            return null;
        }
    }

    class b extends l {
        b(int i) {
            super(i);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.k.add(Byte.valueOf(byteBufferList.e()));
            return null;
        }
    }

    class c extends l {
        c(int i) {
            super(i);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.k.add(Short.valueOf(byteBufferList.q()));
            return null;
        }
    }

    class d extends l {
        d(int i) {
            super(i);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.k.add(Integer.valueOf(byteBufferList.n()));
            return null;
        }
    }

    class e extends l {
        e(int i) {
            super(i);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.k.add(Long.valueOf(byteBufferList.o()));
            return null;
        }
    }

    class f implements j {
        f() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            w.this.k.add(bArr);
        }
    }

    class g implements j {
        g() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ByteBufferList byteBufferList) {
            w.this.k.add(byteBufferList);
        }
    }

    class h implements j {
        h() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            w.this.k.add(new String(bArr));
        }
    }

    static class i extends l {
        j b;

        public i(int i, j jVar) {
            super(i);
            if (i <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.b = jVar;
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.a];
            byteBufferList.h(bArr);
            this.b.a(bArr);
            return null;
        }
    }

    public interface j {
        void a(Object obj);
    }

    static class k extends l {
        byte b;
        st.d c;

        public k(byte b, st.d dVar) {
            super(1);
            this.b = b;
            this.c = dVar;
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z = true;
            while (true) {
                if (byteBufferList.E() <= 0) {
                    break;
                }
                ByteBuffer D = byteBufferList.D();
                D.mark();
                int i = 0;
                while (D.remaining() > 0) {
                    z = D.get() == this.b;
                    if (z) {
                        break;
                    }
                    i++;
                }
                D.reset();
                if (z) {
                    byteBufferList.c(D);
                    byteBufferList.g(byteBufferList2, i);
                    byteBufferList.e();
                    break;
                }
                byteBufferList2.a(D);
            }
            this.c.C(pVar, byteBufferList2);
            if (z) {
                return null;
            }
            return this;
        }
    }

    static abstract class l {
        int a;

        public l(int i) {
            this.a = i;
        }

        public abstract l a(p pVar, ByteBufferList byteBufferList);
    }

    public w(p pVar) {
        this.i = pVar;
        pVar.F(this);
    }

    @Override // st.d
    public void C(p pVar, ByteBufferList byteBufferList) {
        byteBufferList.f(this.m);
        while (this.j.size() > 0 && this.m.C() >= ((l) this.j.peek()).a) {
            this.m.u(this.l);
            l a2 = ((l) this.j.poll()).a(pVar, this.m);
            if (a2 != null) {
                this.j.addFirst(a2);
            }
        }
        if (this.j.size() == 0) {
            this.m.f(byteBufferList);
        }
    }

    public w b(int i2, j jVar) {
        this.j.add(new i(i2, jVar));
        return this;
    }

    public w c(byte b2, st.d dVar) {
        this.j.add(new k(b2, dVar));
        return this;
    }
}
