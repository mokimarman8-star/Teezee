package com.transsion.subtitle_download.utils;

import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final boolean a(String zipFilePath, String destFilePath) {
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        Intrinsics.h(zipFilePath, "zipFilePath");
        Intrinsics.h(destFilePath, "destFilePath");
        byte[] bArr = new byte[1024];
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(destFilePath);
            try {
                fileInputStream = new FileInputStream(zipFilePath);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream);
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                b.a.b("GzipUti --> unGzip() --> " + Log.getStackTraceString(th));
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                        return false;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream == null) {
                                    return false;
                                }
                                fileInputStream.close();
                                return false;
                            } catch (Throwable th4) {
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                        throw th4;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th4;
                            }
                        }
                    }
                    gZIPInputStream.close();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    return true;
                } catch (Throwable th6) {
                    th = th6;
                    gZIPInputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                gZIPInputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            gZIPInputStream = null;
            fileInputStream = null;
        }
    }
}
