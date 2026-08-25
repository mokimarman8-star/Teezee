package com.bytedance.adsdk.sP.EjP;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg {
    private final HiB Sj;

    public Jcg(HiB hiB) {
        this.Sj = hiB;
    }

    private File Sj() {
        File Sj = this.Sj.Sj();
        if (Sj.isFile()) {
            Sj.delete();
        }
        if (!Sj.exists()) {
            Sj.mkdirs();
        }
        return Sj;
    }

    private static String Sj(String str, TKC tkc, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? tkc.Sj() : tkc.TKC);
        return sb.toString();
    }

    private File sP(String str) throws FileNotFoundException {
        File file = new File(Sj(), Sj(str, TKC.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(Sj(), Sj(str, TKC.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    Pair<TKC, InputStream> Sj(String str) {
        try {
            File sP = sP(str);
            if (sP == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(sP);
            TKC tkc = sP.getAbsolutePath().endsWith(".zip") ? TKC.ZIP : TKC.JSON;
            sP.getAbsolutePath();
            return new Pair<>(tkc, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File Sj(String str, InputStream inputStream, TKC tkc) throws IOException {
        File file = new File(Sj(), Sj(str, tkc, true));
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

    void Sj(String str, TKC tkc) {
        File file = new File(Sj(), Sj(str, tkc, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        file2.toString();
        if (renameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }
}
