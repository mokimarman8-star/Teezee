package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class f implements j0 {
    private final byte[] a;
    private final String b;
    private final String c;

    f(String str, String str2, byte[] bArr) {
        this.b = str;
        this.c = str2;
        this.a = bArr;
    }

    private byte[] c() {
        if (d()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean d() {
        byte[] bArr = this.a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public CrashlyticsReport$d.b a() {
        byte[] c = c();
        if (c == null) {
            return null;
        }
        return CrashlyticsReport$d.b.a().b(c).c(this.b).a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public String b() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public InputStream getStream() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }
}
