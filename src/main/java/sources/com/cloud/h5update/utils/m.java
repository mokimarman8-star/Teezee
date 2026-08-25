package com.cloud.h5update.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class m {
    public static final m a = new m();

    private m() {
    }

    /* JADX WARN: Finally extract failed */
    public final void a(File file, String str) {
        Intrinsics.h(str, "dstDir");
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String canonicalPath = file2.getCanonicalPath();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Intrinsics.g(entries, "zipFile.entries()");
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Intrinsics.g(nextElement, "zipEntrys.nextElement()");
                ZipEntry zipEntry = nextElement;
                String name = zipEntry.getName();
                Intrinsics.g(name, "zipEntryName");
                if (!StringsKt.c0(name, "../", false, 2, (Object) null)) {
                    File file3 = new File(str + File.separator + name);
                    String canonicalPath2 = file3.getCanonicalPath();
                    Intrinsics.g(canonicalPath2, "tmpCanonicalPath");
                    Intrinsics.g(canonicalPath, "dstCanonicalPath");
                    if (StringsKt.W(canonicalPath2, canonicalPath, false, 2, (Object) null)) {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!zipEntry.isDirectory()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                InputStream inputStream = zipFile.getInputStream(zipEntry);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                    }
                                    fileOutputStream.flush();
                                    Unit unit = Unit.a;
                                    CloseableKt.a(inputStream, (Throwable) null);
                                    CloseableKt.a(fileOutputStream, (Throwable) null);
                                } finally {
                                }
                            } finally {
                            }
                        } else if (!file3.exists()) {
                            file3.mkdirs();
                        }
                    } else {
                        continue;
                    }
                }
            }
            Unit unit2 = Unit.a;
            CloseableKt.a(zipFile, (Throwable) null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(zipFile, th);
                throw th2;
            }
        }
    }
}
