package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.e;
import retrofit2.l;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class l extends e.a {
    private final Executor a;

    class a implements e {
        final /* synthetic */ Type a;
        final /* synthetic */ Executor b;

        a(Type type, Executor executor) {
            this.a = type;
            this.b = executor;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d b(d dVar) {
            Executor executor = this.b;
            return executor == null ? dVar : new b(executor, dVar);
        }
    }

    static final class b implements d {
        final Executor a;
        final d b;

        class a implements f {
            final /* synthetic */ f a;

            a(f fVar) {
                this.a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(f fVar, Throwable th) {
                fVar.a(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(f fVar, j0 j0Var) {
                if (b.this.b.isCanceled()) {
                    fVar.a(b.this, new IOException("Canceled"));
                } else {
                    fVar.b(b.this, j0Var);
                }
            }

            @Override // retrofit2.f
            public void a(d dVar, final Throwable th) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: retrofit2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.b.a.this.e(fVar, th);
                    }
                });
            }

            @Override // retrofit2.f
            public void b(d dVar, final j0 j0Var) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: retrofit2.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.b.a.this.f(fVar, j0Var);
                    }
                });
            }
        }

        b(Executor executor, d dVar) {
            this.a = executor;
            this.b = dVar;
        }

        @Override // retrofit2.d
        public void cancel() {
            this.b.cancel();
        }

        @Override // retrofit2.d
        public d clone() {
            return new b(this.a, this.b.clone());
        }

        @Override // retrofit2.d
        public j0 execute() {
            return this.b.execute();
        }

        @Override // retrofit2.d
        public void f(f fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.b.f(new a(fVar));
        }

        @Override // retrofit2.d
        public boolean isCanceled() {
            return this.b.isCanceled();
        }

        @Override // retrofit2.d
        public Request request() {
            return this.b.request();
        }
    }

    l(Executor executor) {
        this.a = executor;
    }

    @Override // retrofit2.e.a
    public e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (e.a.c(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(o0.g(0, (ParameterizedType) type), o0.l(annotationArr, m0.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
