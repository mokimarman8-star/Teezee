package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private int a;
    private Protobuf.IntEncoding b = Protobuf.IntEncoding.DEFAULT;

    /* renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    private static final class C0036a implements Protobuf {
        private final int b;
        private final Protobuf.IntEncoding c;

        C0036a(int i, Protobuf.IntEncoding intEncoding) {
            this.b = i;
            this.c = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.b == protobuf.tag() && this.c.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.b) + (this.c.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.c;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.b;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.b + "intEncoding=" + this.c + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public Protobuf a() {
        return new C0036a(this.a, this.b);
    }

    public a c(int i) {
        this.a = i;
        return this;
    }
}
