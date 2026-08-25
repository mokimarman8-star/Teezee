package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.a0;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class i0 {
    private final Class a;
    private final Method b;
    private final HttpUrl c;
    final String d;
    private final String e;
    private final Headers f;
    private final MediaType g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final a0[] k;
    final boolean l;

    static final class a {
        private static final Pattern y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        final k0 a;
        final Class b;
        final Method c;
        final Annotation[] d;
        final Annotation[][] e;
        final Type[] f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        String o;
        boolean p;
        boolean q;
        boolean r;
        String s;
        Headers t;
        MediaType u;
        Set v;
        a0[] w;
        boolean x;

        a(k0 k0Var, Class cls, Method method) {
            this.a = k0Var;
            this.b = cls;
            this.c = method;
            this.d = method.getAnnotations();
            this.f = method.getGenericParameterTypes();
            this.e = method.getParameterAnnotations();
        }

        private static Class a(Class cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr, boolean z2) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw o0.n(this.c, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.u = MediaType.get(trim);
                    } catch (IllegalArgumentException e) {
                        throw o0.o(this.c, e, "Malformed content type: %s", trim);
                    }
                } else if (z2) {
                    builder.addUnsafeNonAscii(substring, trim);
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z2) {
            String str3 = this.o;
            if (str3 != null) {
                throw o0.n(this.c, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.o = str;
            this.p = z2;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (y.matcher(substring).find()) {
                    throw o0.n(this.c, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.s = str2;
            this.v = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof DELETE) {
                d("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                d("GET", ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                d("HEAD", ((HEAD) annotation).value(), false);
                return;
            }
            if (annotation instanceof PATCH) {
                d("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                d("POST", ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                d("PUT", ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                d("OPTIONS", ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                d(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                retrofit2.http.Headers headers = (retrofit2.http.Headers) annotation;
                String[] value = headers.value();
                if (value.length == 0) {
                    throw o0.n(this.c, "@Headers annotation is empty.", new Object[0]);
                }
                this.t = c(value, headers.allowUnsafeNonAsciiValues());
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.q) {
                    throw o0.n(this.c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.r = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.r) {
                    throw o0.n(this.c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.q = true;
            }
        }

        private a0 f(int i, Type type, Annotation[] annotationArr, boolean z2) {
            a0 a0Var;
            if (annotationArr != null) {
                a0Var = null;
                for (Annotation annotation : annotationArr) {
                    a0 g = g(i, type, annotationArr, annotation);
                    if (g != null) {
                        if (a0Var != null) {
                            throw o0.p(this.c, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        a0Var = g;
                    }
                }
            } else {
                a0Var = null;
            }
            if (a0Var != null) {
                return a0Var;
            }
            if (z2) {
                try {
                    if (o0.h(type) == Continuation.class) {
                        this.x = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw o0.p(this.c, i, "No Retrofit annotation found.", new Object[0]);
        }

        private a0 g(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                j(i, type);
                if (this.n) {
                    throw o0.p(this.c, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.j) {
                    throw o0.p(this.c, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.k) {
                    throw o0.p(this.c, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.l) {
                    throw o0.p(this.c, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.m) {
                    throw o0.p(this.c, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.s != null) {
                    throw o0.p(this.c, i, "@Url cannot be used with @%s URL", this.o);
                }
                this.n = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new a0.p(this.c, i);
                }
                throw o0.p(this.c, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                j(i, type);
                if (this.k) {
                    throw o0.p(this.c, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.l) {
                    throw o0.p(this.c, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.m) {
                    throw o0.p(this.c, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.n) {
                    throw o0.p(this.c, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.s == null) {
                    throw o0.p(this.c, i, "@Path can only be used with relative url on @%s", this.o);
                }
                this.j = true;
                Path path = (Path) annotation;
                String value = path.value();
                i(i, value);
                return new a0.k(this.c, i, value, this.a.i(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                j(i, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class h = o0.h(type);
                this.k = true;
                if (!Iterable.class.isAssignableFrom(h)) {
                    return h.isArray() ? new a0.l(value2, this.a.i(a(h.getComponentType()), annotationArr), encoded).b() : new a0.l(value2, this.a.i(type, annotationArr), encoded);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.l(value2, this.a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                }
                throw o0.p(this.c, i, h.getSimpleName() + " must include generic type (e.g., " + h.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                j(i, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class h2 = o0.h(type);
                this.l = true;
                if (!Iterable.class.isAssignableFrom(h2)) {
                    return h2.isArray() ? new a0.n(this.a.i(a(h2.getComponentType()), annotationArr), encoded2).b() : new a0.n(this.a.i(type, annotationArr), encoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.n(this.a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                }
                throw o0.p(this.c, i, h2.getSimpleName() + " must include generic type (e.g., " + h2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                j(i, type);
                Class h3 = o0.h(type);
                this.m = true;
                if (!Map.class.isAssignableFrom(h3)) {
                    throw o0.p(this.c, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type i2 = o0.i(type, h3, Map.class);
                if (!(i2 instanceof ParameterizedType)) {
                    throw o0.p(this.c, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) i2;
                Type g = o0.g(0, parameterizedType);
                if (String.class == g) {
                    return new a0.m(this.c, i, this.a.i(o0.g(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw o0.p(this.c, i, "@QueryMap keys must be of type String: " + g, new Object[0]);
            }
            if (annotation instanceof Header) {
                j(i, type);
                Header header = (Header) annotation;
                String value3 = header.value();
                Class h4 = o0.h(type);
                if (!Iterable.class.isAssignableFrom(h4)) {
                    return h4.isArray() ? new a0.f(value3, this.a.i(a(h4.getComponentType()), annotationArr), header.allowUnsafeNonAsciiValues()).b() : new a0.f(value3, this.a.i(type, annotationArr), header.allowUnsafeNonAsciiValues());
                }
                if (type instanceof ParameterizedType) {
                    return new a0.f(value3, this.a.i(o0.g(0, (ParameterizedType) type), annotationArr), header.allowUnsafeNonAsciiValues()).c();
                }
                throw o0.p(this.c, i, h4.getSimpleName() + " must include generic type (e.g., " + h4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new a0.h(this.c, i);
                }
                j(i, type);
                Class h5 = o0.h(type);
                if (!Map.class.isAssignableFrom(h5)) {
                    throw o0.p(this.c, i, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                }
                Type i3 = o0.i(type, h5, Map.class);
                if (!(i3 instanceof ParameterizedType)) {
                    throw o0.p(this.c, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) i3;
                Type g2 = o0.g(0, parameterizedType2);
                if (String.class == g2) {
                    return new a0.g(this.c, i, this.a.i(o0.g(1, parameterizedType2), annotationArr), ((HeaderMap) annotation).allowUnsafeNonAsciiValues());
                }
                throw o0.p(this.c, i, "@HeaderMap keys must be of type String: " + g2, new Object[0]);
            }
            if (annotation instanceof Field) {
                j(i, type);
                if (!this.q) {
                    throw o0.p(this.c, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.g = true;
                Class h6 = o0.h(type);
                if (!Iterable.class.isAssignableFrom(h6)) {
                    return h6.isArray() ? new a0.d(value4, this.a.i(a(h6.getComponentType()), annotationArr), encoded3).b() : new a0.d(value4, this.a.i(type, annotationArr), encoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new a0.d(value4, this.a.i(o0.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                }
                throw o0.p(this.c, i, h6.getSimpleName() + " must include generic type (e.g., " + h6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                j(i, type);
                if (!this.q) {
                    throw o0.p(this.c, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class h7 = o0.h(type);
                if (!Map.class.isAssignableFrom(h7)) {
                    throw o0.p(this.c, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type i4 = o0.i(type, h7, Map.class);
                if (!(i4 instanceof ParameterizedType)) {
                    throw o0.p(this.c, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) i4;
                Type g3 = o0.g(0, parameterizedType3);
                if (String.class == g3) {
                    k i6 = this.a.i(o0.g(1, parameterizedType3), annotationArr);
                    this.g = true;
                    return new a0.e(this.c, i, i6, ((FieldMap) annotation).encoded());
                }
                throw o0.p(this.c, i, "@FieldMap keys must be of type String: " + g3, new Object[0]);
            }
            if (annotation instanceof Part) {
                j(i, type);
                if (!this.r) {
                    throw o0.p(this.c, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.h = true;
                String value5 = part.value();
                Class h8 = o0.h(type);
                if (value5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(h8)) {
                        if (h8.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h8.getComponentType())) {
                                return a0.o.a.b();
                            }
                            throw o0.p(this.c, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(h8)) {
                            return a0.o.a;
                        }
                        throw o0.p(this.c, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (MultipartBody.Part.class.isAssignableFrom(o0.h(o0.g(0, (ParameterizedType) type)))) {
                            return a0.o.a.c();
                        }
                        throw o0.p(this.c, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw o0.p(this.c, i, h8.getSimpleName() + " must include generic type (e.g., " + h8.getSimpleName() + "<String>)", new Object[0]);
                }
                Headers of = Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding()});
                if (!Iterable.class.isAssignableFrom(h8)) {
                    if (!h8.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(h8)) {
                            throw o0.p(this.c, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new a0.i(this.c, i, of, this.a.g(type, annotationArr, this.d));
                    }
                    Class a = a(h8.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(a)) {
                        throw o0.p(this.c, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new a0.i(this.c, i, of, this.a.g(a, annotationArr, this.d)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type g4 = o0.g(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(o0.h(g4))) {
                        throw o0.p(this.c, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new a0.i(this.c, i, of, this.a.g(g4, annotationArr, this.d)).c();
                }
                throw o0.p(this.c, i, h8.getSimpleName() + " must include generic type (e.g., " + h8.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof PartMap) {
                j(i, type);
                if (!this.r) {
                    throw o0.p(this.c, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.h = true;
                Class h9 = o0.h(type);
                if (!Map.class.isAssignableFrom(h9)) {
                    throw o0.p(this.c, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type i7 = o0.i(type, h9, Map.class);
                if (!(i7 instanceof ParameterizedType)) {
                    throw o0.p(this.c, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) i7;
                Type g5 = o0.g(0, parameterizedType4);
                if (String.class == g5) {
                    Type g6 = o0.g(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(o0.h(g6))) {
                        throw o0.p(this.c, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new a0.j(this.c, i, this.a.g(g6, annotationArr, this.d), ((PartMap) annotation).encoding());
                }
                throw o0.p(this.c, i, "@PartMap keys must be of type String: " + g5, new Object[0]);
            }
            if (annotation instanceof Body) {
                j(i, type);
                if (this.q || this.r) {
                    throw o0.p(this.c, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.i) {
                    throw o0.p(this.c, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    k g7 = this.a.g(type, annotationArr, this.d);
                    this.i = true;
                    return new a0.c(this.c, i, g7);
                } catch (RuntimeException e) {
                    throw o0.q(this.c, e, i, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof Tag)) {
                return null;
            }
            j(i, type);
            Class h10 = o0.h(type);
            for (int i8 = i - 1; i8 >= 0; i8--) {
                a0 a0Var = this.w[i8];
                if ((a0Var instanceof a0.q) && ((a0.q) a0Var).a.equals(h10)) {
                    throw o0.p(this.c, i, "@Tag type " + h10.getName() + " is duplicate of " + b0.b.a(this.c, i8) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new a0.q(h10);
        }

        static Set h(String str) {
            Matcher matcher = y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i, String str) {
            if (!z.matcher(str).matches()) {
                throw o0.p(this.c, i, "@Path parameter name must match %s. Found: %s", y.pattern(), str);
            }
            if (!this.v.contains(str)) {
                throw o0.p(this.c, i, "URL \"%s\" does not contain \"{%s}\".", this.s, str);
            }
        }

        private void j(int i, Type type) {
            if (o0.j(type)) {
                throw o0.p(this.c, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        i0 b() {
            for (Annotation annotation : this.d) {
                e(annotation);
            }
            if (this.o == null) {
                throw o0.n(this.c, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.p) {
                if (this.r) {
                    throw o0.n(this.c, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.q) {
                    throw o0.n(this.c, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.e.length;
            this.w = new a0[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < length) {
                this.w[i2] = f(i2, this.f[i2], this.e[i2], i2 == i);
                i2++;
            }
            if (this.s == null && !this.n) {
                throw o0.n(this.c, "Missing either @%s URL or @Url parameter.", this.o);
            }
            boolean z2 = this.q;
            if (!z2 && !this.r && !this.p && this.i) {
                throw o0.n(this.c, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z2 && !this.g) {
                throw o0.n(this.c, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.r || this.h) {
                return new i0(this);
            }
            throw o0.n(this.c, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    i0(a aVar) {
        this.a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.a.c;
        this.d = aVar.o;
        this.e = aVar.s;
        this.f = aVar.t;
        this.g = aVar.u;
        this.h = aVar.p;
        this.i = aVar.q;
        this.j = aVar.r;
        this.k = aVar.w;
        this.l = aVar.x;
    }

    static i0 b(k0 k0Var, Class cls, Method method) {
        return new a(k0Var, cls, method).b();
    }

    Request a(Object obj, Object[] objArr) {
        a0[] a0VarArr = this.k;
        int length = objArr.length;
        if (length != a0VarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + a0VarArr.length + ")");
        }
        h0 h0Var = new h0(this.d, this.c, this.e, this.f, this.g, this.h, this.i, this.j);
        if (this.l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            a0VarArr[i].a(h0Var, objArr[i]);
        }
        return h0Var.k().tag(v.class, new v(this.a, obj, this.b, arrayList)).build();
    }
}
