package v2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f18069a;

    /* renamed from: b, reason: collision with root package name */
    private final DataOutputStream f18070b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f18069a = byteArrayOutputStream;
        this.f18070b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(a aVar) {
        this.f18069a.reset();
        try {
            b(this.f18070b, aVar.f18063a);
            String str = aVar.f18064b;
            if (str == null) {
                str = "";
            }
            b(this.f18070b, str);
            this.f18070b.writeLong(aVar.f18065c);
            this.f18070b.writeLong(aVar.f18066d);
            this.f18070b.write(aVar.f18067e);
            this.f18070b.flush();
            return this.f18069a.toByteArray();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }
}
