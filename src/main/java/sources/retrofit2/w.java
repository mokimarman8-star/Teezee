package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class w implements d {
    private final i0 a;
    private final Object b;
    private final Object[] c;
    private final Call.Factory d;
    private final k e;
    private volatile boolean f;
    private Call g;
    private Throwable h;
    private boolean i;

    class a implements Callback {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        private void a(Throwable th) {
            try {
                this.a.a(w.this, th);
            } catch (Throwable th2) {
                o0.t(th2);
                th2.printStackTrace();
            }
        }

        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.a.b(w.this, w.this.d(response));
                } catch (Throwable th) {
                    o0.t(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                o0.t(th2);
                a(th2);
            }
        }
    }

    static final class b extends ResponseBody {
        private final ResponseBody a;
        private final BufferedSource b;
        IOException c;

        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) {
                try {
                    return super.read(buffer, j);
                } catch (IOException e) {
                    b.this.c = e;
                    throw e;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.a = responseBody;
            this.b = Okio.buffer(new a(responseBody.source()));
        }

        public void close() {
            this.a.close();
        }

        public long contentLength() {
            return this.a.contentLength();
        }

        public MediaType contentType() {
            return this.a.contentType();
        }

        public BufferedSource source() {
            return this.b;
        }

        void throwIfCaught() {
            IOException iOException = this.c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class c extends ResponseBody {
        private final MediaType a;
        private final long b;

        c(MediaType mediaType, long j) {
            this.a = mediaType;
            this.b = j;
        }

        public long contentLength() {
            return this.b;
        }

        public MediaType contentType() {
            return this.a;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    w(i0 i0Var, Object obj, Object[] objArr, Call.Factory factory, k kVar) {
        this.a = i0Var;
        this.b = obj;
        this.c = objArr;
        this.d = factory;
        this.e = kVar;
    }

    private Call b() {
        Call newCall = this.d.newCall(this.a.a(this.b, this.c));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private Call c() {
        Call call = this.g;
        if (call != null) {
            return call;
        }
        Throwable th = this.h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            Call b2 = b();
            this.g = b2;
            return b2;
        } catch (IOException | Error | RuntimeException e) {
            o0.t(e);
            this.h = e;
            throw e;
        }
    }

    @Override // retrofit2.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public w clone() {
        return new w(this.a, this.b, this.c, this.d, this.e);
    }

    @Override // retrofit2.d
    public void cancel() {
        Call call;
        this.f = true;
        synchronized (this) {
            call = this.g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    j0 d(Response response) {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return j0.c(o0.a(body), build);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return j0.g(null, build);
        }
        b bVar = new b(body);
        try {
            return j0.g(this.e.convert(bVar), build);
        } catch (RuntimeException e) {
            bVar.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.d
    public j0 execute() {
        Call c2;
        synchronized (this) {
            if (this.i) {
                throw new IllegalStateException("Already executed.");
            }
            this.i = true;
            c2 = c();
        }
        if (this.f) {
            c2.cancel();
        }
        return d(FirebasePerfOkHttpClient.execute(c2));
    }

    @Override // retrofit2.d
    public void f(f fVar) {
        Call call;
        Throwable th;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            try {
                if (this.i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.i = true;
                call = this.g;
                th = this.h;
                if (call == null && th == null) {
                    try {
                        Call b2 = b();
                        this.g = b2;
                        call = b2;
                    } catch (Throwable th2) {
                        th = th2;
                        o0.t(th);
                        this.h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            fVar.a(this, th);
            return;
        }
        if (this.f) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new a(fVar));
    }

    @Override // retrofit2.d
    public boolean isCanceled() {
        boolean z = true;
        if (this.f) {
            return true;
        }
        synchronized (this) {
            try {
                Call call = this.g;
                if (call == null || !call.isCanceled()) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // retrofit2.d
    public synchronized Request request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return c().request();
    }
}
