package yf;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c implements i8.a {
    private final long a = 5242880;
    private final int b = 86400000;
    private final long c = System.currentTimeMillis();

    private final boolean b(File file) {
        if (file == null) {
            return false;
        }
        return (this.c - file.lastModified()) / ((long) this.b) >= 15;
    }

    public boolean a(File file) {
        if (file == null || !file.isFile()) {
            return false;
        }
        return b(file) || file.length() > this.a;
    }
}
