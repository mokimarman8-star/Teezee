package com.google.firebase.crashlytics.internal.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class k0 {
    private static void a(InputStream inputStream, File file) {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        gZIPOutputStream2.finish();
                        CommonUtils.g(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.g(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void b(File file, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            InputStream inputStream = null;
            try {
                inputStream = j0Var.getStream();
                if (inputStream != null) {
                    a(inputStream, new File(file, j0Var.b()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.g((Closeable) null);
                throw th;
            }
            CommonUtils.g(inputStream);
        }
    }
}
