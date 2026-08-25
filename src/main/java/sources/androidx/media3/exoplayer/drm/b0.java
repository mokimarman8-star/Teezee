package androidx.media3.exoplayer.drm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import x1.f4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface b0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f10239a;

        /* renamed from: b, reason: collision with root package name */
        private final String f10240b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10241c;

        public a(byte[] bArr, String str, int i5) {
            this.f10239a = bArr;
            this.f10240b = str;
            this.f10241c = i5;
        }

        public byte[] a() {
            return this.f10239a;
        }

        public String b() {
            return this.f10240b;
        }
    }

    public interface b {
        void a(b0 b0Var, byte[] bArr, int i5, int i6, byte[] bArr2);
    }

    public interface c {
        b0 a(UUID uuid);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f10242a;

        /* renamed from: b, reason: collision with root package name */
        private final String f10243b;

        public d(byte[] bArr, String str) {
            this.f10242a = bArr;
            this.f10243b = str;
        }

        public byte[] a() {
            return this.f10242a;
        }

        public String b() {
            return this.f10243b;
        }
    }

    int a();

    androidx.media3.decoder.b b(byte[] bArr);

    boolean c(byte[] bArr, String str);

    void closeSession(byte[] bArr);

    a d(byte[] bArr, List list, int i5, HashMap hashMap);

    void e(b bVar);

    void f(byte[] bArr, f4 f4Var);

    d getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2);

    void provideProvisionResponse(byte[] bArr);

    Map queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
