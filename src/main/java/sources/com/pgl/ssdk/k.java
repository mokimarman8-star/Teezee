package com.pgl.ssdk;

import com.pgl.ssdk.c;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.pgl.ssdk.f;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class k {
    @DungeonFlag
    private static e a(ByteBuffer byteBuffer) throws a, NoSuchAlgorithmException, CertificateException {
        ByteBuffer a = f.a(byteBuffer);
        a.get(new byte[a.remaining()]);
        a.flip();
        a.position(0);
        f.a(a);
        byte[] b = f.b(f.a(a));
        try {
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b));
            if (generateCertificate instanceof X509Certificate) {
                return new e(String.valueOf(((X509Certificate) generateCertificate).getSubjectDN()), b);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<e> a(o oVar, c.a aVar) throws IOException, f.a {
        return b(f.a(oVar, aVar, 1896449818).a);
    }

    public static List<e> b(ByteBuffer byteBuffer) {
        try {
            ByteBuffer a = f.a(byteBuffer);
            if (!a.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (a.hasRemaining()) {
                try {
                    arrayList.add(a(f.a(a)));
                } catch (a | BufferUnderflowException unused) {
                    return null;
                } catch (NoSuchAlgorithmException | CertificateException unused2) {
                }
            }
            return arrayList;
        } catch (a unused3) {
            return null;
        }
    }
}
