package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f7631a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f7632b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f7633c;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f7634a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f7635b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f7636c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f7637d;

        public a(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f7634a = fieldType;
            this.f7635b = obj;
            this.f7636c = fieldType2;
            this.f7637d = obj2;
        }
    }

    private h0(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f7631a = new a(fieldType, obj, fieldType2, obj2);
        this.f7632b = obj;
        this.f7633c = obj2;
    }

    static int b(a aVar, Object obj, Object obj2) {
        return s.b(aVar.f7634a, 1, obj) + s.b(aVar.f7636c, 2, obj2);
    }

    public static h0 d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new h0(fieldType, obj, fieldType2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, a aVar, Object obj, Object obj2) {
        s.w(codedOutputStream, aVar.f7634a, 1, obj);
        s.w(codedOutputStream, aVar.f7636c, 2, obj2);
    }

    public int a(int i5, Object obj, Object obj2) {
        return CodedOutputStream.S(i5) + CodedOutputStream.C(b(this.f7631a, obj, obj2));
    }

    a c() {
        return this.f7631a;
    }
}
