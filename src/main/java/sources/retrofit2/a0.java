package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
abstract class a0 {

    class a extends a0 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Iterable iterable) {
            if (iterable == null) {
                return;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a0.this.a(h0Var, it.next());
            }
        }
    }

    class b extends a0 {
        b() {
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                a0.this.a(h0Var, Array.get(obj, i));
            }
        }
    }

    static final class c extends a0 {
        private final Method a;
        private final int b;
        private final retrofit2.k c;

        c(Method method, int i, retrofit2.k kVar) {
            this.a = method;
            this.b = i;
            this.c = kVar;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                throw o0.p(this.a, this.b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                h0Var.l((RequestBody) this.c.convert(obj));
            } catch (IOException e) {
                throw o0.q(this.a, e, this.b, "Unable to convert " + obj + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class d extends a0 {
        private final String a;
        private final retrofit2.k b;
        private final boolean c;

        d(String str, retrofit2.k kVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = kVar;
            this.c = z;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.b.convert(obj)) == null) {
                return;
            }
            h0Var.a(this.a, str, this.c);
        }
    }

    static final class e extends a0 {
        private final Method a;
        private final int b;
        private final retrofit2.k c;
        private final boolean d;

        e(Method method, int i, retrofit2.k kVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = kVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.a, this.b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.a, this.b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.a, this.b, "Field map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.c.convert(value);
                if (str2 == null) {
                    throw o0.p(this.a, this.b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                h0Var.a(str, str2, this.d);
            }
        }
    }

    static final class f extends a0 {
        private final String a;
        private final retrofit2.k b;
        private final boolean c;

        f(String str, retrofit2.k kVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = kVar;
            this.c = z;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.b.convert(obj)) == null) {
                return;
            }
            h0Var.b(this.a, str, this.c);
        }
    }

    static final class g extends a0 {
        private final Method a;
        private final int b;
        private final retrofit2.k c;
        private final boolean d;

        g(Method method, int i, retrofit2.k kVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = kVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.a, this.b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.a, this.b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.a, this.b, "Header map contained null value for key '" + str + "'.", new Object[0]);
                }
                h0Var.b(str, (String) this.c.convert(value), this.d);
            }
        }
    }

    static final class h extends a0 {
        private final Method a;
        private final int b;

        h(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Headers headers) {
            if (headers == null) {
                throw o0.p(this.a, this.b, "Headers parameter must not be null.", new Object[0]);
            }
            h0Var.c(headers);
        }
    }

    static final class i extends a0 {
        private final Method a;
        private final int b;
        private final Headers c;
        private final retrofit2.k d;

        i(Method method, int i, Headers headers, retrofit2.k kVar) {
            this.a = method;
            this.b = i;
            this.c = headers;
            this.d = kVar;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                h0Var.d(this.c, (RequestBody) this.d.convert(obj));
            } catch (IOException e) {
                throw o0.p(this.a, this.b, "Unable to convert " + obj + " to RequestBody", e);
            }
        }
    }

    static final class j extends a0 {
        private final Method a;
        private final int b;
        private final retrofit2.k c;
        private final String d;

        j(Method method, int i, retrofit2.k kVar, String str) {
            this.a = method;
            this.b = i;
            this.c = kVar;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.a, this.b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.a, this.b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.a, this.b, "Part map contained null value for key '" + str + "'.", new Object[0]);
                }
                h0Var.d(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.d}), (RequestBody) this.c.convert(value));
            }
        }
    }

    static final class k extends a0 {
        private final Method a;
        private final int b;
        private final String c;
        private final retrofit2.k d;
        private final boolean e;

        k(Method method, int i, String str, retrofit2.k kVar, boolean z) {
            this.a = method;
            this.b = i;
            Objects.requireNonNull(str, "name == null");
            this.c = str;
            this.d = kVar;
            this.e = z;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj != null) {
                h0Var.f(this.c, (String) this.d.convert(obj), this.e);
                return;
            }
            throw o0.p(this.a, this.b, "Path parameter \"" + this.c + "\" value must not be null.", new Object[0]);
        }
    }

    static final class l extends a0 {
        private final String a;
        private final retrofit2.k b;
        private final boolean c;

        l(String str, retrofit2.k kVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = kVar;
            this.c = z;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.b.convert(obj)) == null) {
                return;
            }
            h0Var.g(this.a, str, this.c);
        }
    }

    static final class m extends a0 {
        private final Method a;
        private final int b;
        private final retrofit2.k c;
        private final boolean d;

        m(Method method, int i, retrofit2.k kVar, boolean z) {
            this.a = method;
            this.b = i;
            this.c = kVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.a, this.b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.a, this.b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.a, this.b, "Query map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.c.convert(value);
                if (str2 == null) {
                    throw o0.p(this.a, this.b, "Query map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                h0Var.g(str, str2, this.d);
            }
        }
    }

    static final class n extends a0 {
        private final retrofit2.k a;
        private final boolean b;

        n(retrofit2.k kVar, boolean z) {
            this.a = kVar;
            this.b = z;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            h0Var.g((String) this.a.convert(obj), null, this.b);
        }
    }

    static final class o extends a0 {
        static final o a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, MultipartBody.Part part) {
            if (part != null) {
                h0Var.e(part);
            }
        }
    }

    static final class p extends a0 {
        private final Method a;
        private final int b;

        p(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                throw o0.p(this.a, this.b, "@Url parameter is null.", new Object[0]);
            }
            h0Var.m(obj);
        }
    }

    static final class q extends a0 {
        final Class a;

        q(Class cls) {
            this.a = cls;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            h0Var.h(this.a, obj);
        }
    }

    a0() {
    }

    abstract void a(h0 h0Var, Object obj);

    final a0 b() {
        return new b();
    }

    final a0 c() {
        return new a();
    }
}
