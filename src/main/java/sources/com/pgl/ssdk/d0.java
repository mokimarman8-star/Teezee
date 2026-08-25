package com.pgl.ssdk;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d0 {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00dd, code lost:
    
        if (r9.length() == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context) {
        String str;
        synchronized (d0.class) {
            try {
                String str2 = context.getFilesDir().getAbsolutePath() + "/dic";
                if (new File(str2).exists()) {
                    a("chmod 777 ".concat(String.valueOf(str2)));
                    String a = a(str2);
                    a("chmod 600 ".concat(String.valueOf(str2)));
                    if (a != null && a.length() > 0) {
                        return a;
                    }
                }
                InputStream open = context.getResources().getAssets().open("dic");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    a(bArr, read, "dic".getBytes(Charset.forName(C.UTF8_NAME)));
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                a("chmod 777 ".concat(String.valueOf(str2)));
                str = a(str2);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = a(str2);
                }
                a("chmod 600 ".concat(String.valueOf(str2)));
            } catch (Throwable unused) {
                str = "0[<!>]EXCEPTION[<!>]";
            }
            if (str != null) {
                try {
                } finally {
                }
            }
            str = "0[<!>]ERROR[<!>]";
            return str;
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb2 = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb2.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
            }
        } while (read >= 4096);
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        r0 = null;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH);
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(process.getInputStream());
                } catch (Exception unused) {
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                }
            } catch (Exception unused2) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (process != null) {
                    throw th;
                }
                process.destroy();
                throw th;
            }
        } catch (Exception unused7) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        try {
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.write(10);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            process.waitFor();
            str2 = a(bufferedInputStream);
            try {
                bufferedOutputStream.close();
            } catch (IOException unused8) {
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused9) {
            }
        } catch (Exception unused10) {
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (process != null) {
            }
        }
        process.destroy();
        return str2;
    }

    private static void a(byte[] bArr, int i, byte[] bArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
        }
    }
}
