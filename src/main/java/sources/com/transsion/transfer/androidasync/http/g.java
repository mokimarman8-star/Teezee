package com.transsion.transfer.androidasync.http;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface g {

    public static class a extends e {
        public st.b c;
        public com.transsion.transfer.androidasync.future.a d;
        public String e;
    }

    public static class b extends d {
        public com.transsion.transfer.androidasync.p j;
    }

    public static class c extends a {
        public com.transsion.transfer.androidasync.j f;
        public i g;
        public st.a h;
        public st.a i;
    }

    public static class d extends f {
    }

    public static class e {
        public com.transsion.transfer.androidasync.util.e a = new com.transsion.transfer.androidasync.util.e();
        public j b;
    }

    public static class f extends c {
    }

    /* renamed from: com.transsion.transfer.androidasync.http.g$g, reason: collision with other inner class name */
    public static class C0013g extends h {
        public Exception k;
    }

    public static class h extends b {
    }

    public interface i {
        com.transsion.transfer.androidasync.s E();

        int b();

        i c(int i);

        Headers e();

        i f(com.transsion.transfer.androidasync.s sVar);

        i m(String str);

        i o(com.transsion.transfer.androidasync.p pVar);

        String protocol();

        i r(String str);

        com.transsion.transfer.androidasync.j socket();

        i v(Headers headers);
    }

    void a(e eVar);

    void b(C0013g c0013g);

    void c(f fVar);

    void d(b bVar);

    com.transsion.transfer.androidasync.future.a e(a aVar);

    boolean f(c cVar);

    void g(d dVar);

    j h(h hVar);
}
