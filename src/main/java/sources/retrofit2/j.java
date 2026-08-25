package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.e;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class j extends e.a {

    private static final class a implements e {
        private final Type a;

        /* renamed from: retrofit2.j$a$a, reason: collision with other inner class name */
        private class C0011a implements f {
            private final CompletableFuture a;

            public C0011a(CompletableFuture completableFuture) {
                this.a = completableFuture;
            }

            @Override // retrofit2.f
            public void a(d dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // retrofit2.f
            public void b(d dVar, j0 j0Var) {
                if (j0Var.e()) {
                    this.a.complete(j0Var.a());
                } else {
                    this.a.completeExceptionally(new HttpException(j0Var));
                }
            }
        }

        a(Type type) {
            this.a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(d dVar) {
            b bVar = new b(dVar);
            dVar.f(new C0011a(bVar));
            return bVar;
        }
    }

    private static final class b extends CompletableFuture {
        private final d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.a.cancel();
            }
            return super.cancel(z);
        }
    }

    private static final class c implements e {
        private final Type a;

        private class a implements f {
            private final CompletableFuture a;

            public a(CompletableFuture completableFuture) {
                this.a = completableFuture;
            }

            @Override // retrofit2.f
            public void a(d dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // retrofit2.f
            public void b(d dVar, j0 j0Var) {
                this.a.complete(j0Var);
            }
        }

        c(Type type) {
            this.a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(d dVar) {
            b bVar = new b(dVar);
            dVar.f(new a(bVar));
            return bVar;
        }
    }

    j() {
    }

    @Override // retrofit2.e.a
    public e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (e.a.c(type) != g.a()) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type b2 = e.a.b(0, (ParameterizedType) type);
        if (e.a.c(b2) != j0.class) {
            return new a(b2);
        }
        if (b2 instanceof ParameterizedType) {
            return new c(e.a.b(0, (ParameterizedType) b2));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
