package e6;

import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b {
    public static long a(String str, String str2) {
        File c = c(str, str2);
        if (c.exists()) {
            return c.length();
        }
        File d = d(str, str2);
        if (d.exists()) {
            return d.length();
        }
        return 0L;
    }

    public static void b(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2, String str) {
        try {
            randomAccessFile.seek(i);
            randomAccessFile.write(bArr, 0, i2);
        } catch (Throwable unused) {
        }
    }

    public static File c(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static File d(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }
}
