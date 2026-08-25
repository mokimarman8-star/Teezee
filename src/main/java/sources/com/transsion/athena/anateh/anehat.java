package com.transsion.athena.anateh;

import android.util.Base64;
import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.gslb.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file, byte[] bArr) throws Exception {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        FileInputStream fileInputStream;
        if (!file.exists() || !file.isFile()) {
            return BuildConfig.FLAVOR;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th3) {
                th2 = th3;
                byteArrayOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th4) {
            th2 = th4;
            byteArrayOutputStream = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    com.transsion.athena.taaneh.aethna.b(e4.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                throw th2;
            }
            try {
                byteArrayOutputStream.close();
                throw th2;
            } catch (IOException e5) {
                com.transsion.athena.taaneh.aethna.b(e5.getMessage());
                throw th2;
            }
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length == 0) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    com.transsion.athena.taaneh.aethna.b(e6.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                    com.transsion.athena.taaneh.aethna.b(e7.getMessage());
                }
                return BuildConfig.FLAVOR;
            }
            String str = new String(a(bArr, byteArray));
            try {
                fileInputStream.close();
            } catch (IOException e8) {
                com.transsion.athena.taaneh.aethna.b(e8.getMessage());
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e9) {
                com.transsion.athena.taaneh.aethna.b(e9.getMessage());
            }
            return str;
        } catch (Exception e10) {
            e = e10;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            throw e;
        } catch (Throwable th5) {
            th2 = th5;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
        }
    }

    public static String a(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                return new String(Base64.encode(a(bArr, str), 2));
            }
            com.transsion.athena.taaneh.aethna.b("encryptEventData password is null");
            return null;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String a(String str, byte[] bArr, int i) {
        try {
            if (bArr != null) {
                return new String(a(bArr, Base64.decode(str, 2)));
            }
            com.transsion.athena.taaneh.aethna.b("decryptEventData password is null");
            return null;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public static void a(File file, String str, byte[] bArr) throws Exception {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                byte[] a = a(bArr, str);
                if (a == null || a.length == 0) {
                    throw new Exception("encode failed p = " + com.transsion.athena.config.data.model.anehat.c(bArr) + ", m = " + str.length());
                }
                if (file.exists()) {
                    fileOutputStream = new FileOutputStream(file);
                } else {
                    if (!file.createNewFile()) {
                        throw new IOException("createNewFile failed");
                    }
                    fileOutputStream = new FileOutputStream(file);
                }
                FileOutputStream fileOutputStream3 = fileOutputStream;
                fileOutputStream3.write(a);
                fileOutputStream3.flush();
                try {
                    fileOutputStream3.close();
                } catch (IOException unused) {
                }
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                throw e;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(ehanat.o));
        try {
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(ehanat.o));
        try {
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            throw e;
        }
    }
}
