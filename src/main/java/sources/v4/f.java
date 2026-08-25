package v4;

import android.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final d f18074a;

    public f(d dVar) {
        this.f18074a = dVar;
    }

    private static String b(String str, FileExtension fileExtension, boolean z5) {
        String tempExtension = z5 ? fileExtension.tempExtension() : fileExtension.extension;
        String replaceAll = str.replaceAll("\\W+", "");
        int length = 242 - tempExtension.length();
        if (replaceAll.length() > length) {
            replaceAll = d(replaceAll, length);
        }
        return "lottie_cache_" + replaceAll + tempExtension;
    }

    private File c(String str) {
        File file = new File(e(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(e(), b(str, FileExtension.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    private static String d(String str, int i5) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b5 : digest) {
                sb.append(String.format("%02x", Byte.valueOf(b5)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str.substring(0, i5);
        }
    }

    private File e() {
        File a5 = this.f18074a.a();
        if (a5.isFile()) {
            a5.delete();
        }
        if (!a5.exists()) {
            a5.mkdirs();
        }
        return a5;
    }

    Pair a(String str) {
        try {
            File c5 = c(str);
            if (c5 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c5);
            FileExtension fileExtension = c5.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : c5.getAbsolutePath().endsWith(".gz") ? FileExtension.GZIP : FileExtension.JSON;
            x4.f.a("Cache hit for " + str + " at " + c5.getAbsolutePath());
            return new Pair(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void f(String str, FileExtension fileExtension) {
        File file = new File(e(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        x4.f.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        x4.f.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    File g(String str, InputStream inputStream, FileExtension fileExtension) {
        File file = new File(e(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
