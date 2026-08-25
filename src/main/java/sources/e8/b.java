package e8;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b {
    public static void a(File file, h8.a aVar) {
        String name = file.getName();
        String parent = file.getParent();
        int a = aVar.a();
        if (a <= 0) {
            if (a == 0) {
                for (int i = 1; i < Integer.MAX_VALUE; i++) {
                    File file2 = new File(parent, aVar.c(name, i));
                    if (!file2.exists()) {
                        file.renameTo(file2);
                        return;
                    }
                }
                return;
            }
            return;
        }
        File file3 = new File(parent, aVar.c(name, a));
        if (file3.exists()) {
            file3.delete();
        }
        for (int i2 = a - 1; i2 > 0; i2--) {
            File file4 = new File(parent, aVar.c(name, i2));
            if (file4.exists()) {
                file4.renameTo(new File(parent, aVar.c(name, i2 + 1)));
            }
        }
        file.renameTo(new File(parent, aVar.c(name, 1)));
    }

    public static void b(h8.a aVar) {
        int a = aVar.a();
        if (a < 0) {
            throw new IllegalArgumentException("Max backup index should not be less than 0");
        }
        if (a != Integer.MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException("Max backup index too big: " + a);
    }
}
