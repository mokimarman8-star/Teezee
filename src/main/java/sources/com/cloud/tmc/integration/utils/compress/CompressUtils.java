package com.cloud.tmc.integration.utils.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class CompressUtils {
    private static final int BUFF_SIZE = 1024;

    /* JADX WARN: Finally extract failed */
    public static void untarGZip(File file, String str) throws IOException {
        byte[] bArr = new byte[BUFF_SIZE];
        dz.b bVar = new dz.b(new BufferedInputStream(new FileInputStream(file)));
        while (true) {
            try {
                dz.a o = bVar.o();
                if (o == null) {
                    bVar.close();
                    return;
                }
                File file2 = new File(str + File.separator + o.f());
                if (o.h()) {
                    file2.mkdirs();
                } else {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    while (true) {
                        try {
                            int read = bVar.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            } catch (Throwable th3) {
                try {
                    bVar.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public static void unzip(File file, String str) throws IOException {
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String canonicalPath = file2.getCanonicalPath();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!name.contains("../")) {
                    File file3 = new File(str + File.separator + name);
                    if (file3.getCanonicalPath().startsWith(canonicalPath)) {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!nextElement.isDirectory()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                InputStream inputStream = zipFile.getInputStream(nextElement);
                                try {
                                    byte[] bArr = new byte[BUFF_SIZE];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                    }
                                    fileOutputStream.flush();
                                    inputStream.close();
                                    fileOutputStream.close();
                                } finally {
                                }
                            } finally {
                            }
                        } else if (!file3.exists()) {
                            file3.mkdirs();
                        }
                    }
                }
            }
            zipFile.close();
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
