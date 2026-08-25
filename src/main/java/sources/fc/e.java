package fc;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class e implements dc.d, dc.f {
    private e a = null;
    private boolean b = true;
    private final JsonWriter c;
    private final Map d;
    private final Map e;
    private final dc.c f;
    private final boolean g;

    e(Writer writer, Map map, Map map2, dc.c cVar, boolean z) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = cVar;
        this.g = z;
    }

    private boolean t(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e w(String str, Object obj) {
        y();
        this.c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.c.nullValue();
        return this;
    }

    private e x(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        y();
        this.c.name(str);
        return k(obj, false);
    }

    private void y() {
        if (!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.a;
        if (eVar != null) {
            eVar.y();
            this.a.b = false;
            this.a = null;
            this.c.endObject();
        }
    }

    @Override // dc.d
    public dc.d a(dc.b bVar, Object obj) {
        return p(bVar.b(), obj);
    }

    @Override // dc.d
    public dc.d c(dc.b bVar, boolean z) {
        return q(bVar.b(), z);
    }

    @Override // dc.d
    public dc.d d(dc.b bVar, long j) {
        return o(bVar.b(), j);
    }

    @Override // dc.d
    public dc.d e(dc.b bVar, int i) {
        return n(bVar.b(), i);
    }

    @Override // dc.d
    public dc.d f(dc.b bVar, double d) {
        return m(bVar.b(), d);
    }

    public e h(double d) {
        y();
        this.c.value(d);
        return this;
    }

    public e i(int i) {
        y();
        this.c.value(i);
        return this;
    }

    public e j(long j) {
        y();
        this.c.value(j);
        return this;
    }

    e k(Object obj, boolean z) {
        int i = 0;
        if (z && t(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        p((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.c.endObject();
                return this;
            }
            dc.c cVar = (dc.c) this.d.get(obj.getClass());
            if (cVar != null) {
                return v(cVar, obj, z);
            }
            dc.e eVar = (dc.e) this.e.get(obj.getClass());
            if (eVar != null) {
                eVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return v(this.f, obj, z);
            }
            if (obj instanceof f) {
                i(((f) obj).getNumber());
            } else {
                b(((Enum) obj).name());
            }
            return this;
        }
        if (obj instanceof byte[]) {
            return s((byte[]) obj);
        }
        this.c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.c.value(r7[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                j(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.c.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.c.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                k(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                k(obj2, false);
            }
        }
        this.c.endArray();
        return this;
    }

    @Override // dc.f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e b(String str) {
        y();
        this.c.value(str);
        return this;
    }

    public e m(String str, double d) {
        y();
        this.c.name(str);
        return h(d);
    }

    public e n(String str, int i) {
        y();
        this.c.name(str);
        return i(i);
    }

    public e o(String str, long j) {
        y();
        this.c.name(str);
        return j(j);
    }

    public e p(String str, Object obj) {
        return this.g ? x(str, obj) : w(str, obj);
    }

    public e q(String str, boolean z) {
        y();
        this.c.name(str);
        return g(z);
    }

    @Override // dc.f
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e g(boolean z) {
        y();
        this.c.value(z);
        return this;
    }

    public e s(byte[] bArr) {
        y();
        if (bArr == null) {
            this.c.nullValue();
        } else {
            this.c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    void u() {
        y();
        this.c.flush();
    }

    e v(dc.c cVar, Object obj, boolean z) {
        if (!z) {
            this.c.beginObject();
        }
        cVar.a(obj, this);
        if (!z) {
            this.c.endObject();
        }
        return this;
    }
}
