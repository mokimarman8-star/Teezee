package v8;

import java.util.Arrays;
import v8.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a extends e {
    private final Iterable a;
    private final byte[] b;

    static final class b extends e.a {
        private Iterable a;
        private byte[] b;

        b() {
        }

        @Override // v8.e.a
        public e a() {
            String str = "";
            if (this.a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v8.e.a
        public e.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.a = iterable;
            return this;
        }

        @Override // v8.e.a
        public e.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }

    private a(Iterable iterable, byte[] bArr) {
        this.a = iterable;
        this.b = bArr;
    }

    @Override // v8.e
    public Iterable b() {
        return this.a;
    }

    @Override // v8.e
    public byte[] c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a.equals(eVar.b())) {
            if (Arrays.equals(this.b, eVar instanceof a ? ((a) eVar).b : eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.b) + "}";
    }
}
