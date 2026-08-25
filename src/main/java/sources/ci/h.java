package ci;

import java.io.File;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final void a(String str) {
        Intrinsics.h(str, "directoryPath");
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        xh.a.c(xh.a.a, h.class.getSimpleName() + " --> createDirectoryIfNotExists() --> 目标文件夹 创建成功 --> directoryPath = " + str, 0, false, 6, null);
    }

    public final void b(File file, HashSet hashSet) {
        File[] listFiles;
        Intrinsics.h(file, "file");
        Intrinsics.h(hashSet, "set");
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        if (listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                h hVar = a;
                Intrinsics.e(file2);
                hVar.b(file2, hashSet);
            } else if (file2.isFile() && !hashSet.contains(file2.getPath())) {
                file2.delete();
            }
        }
    }

    public final boolean c(String str) {
        Intrinsics.h(str, "filePath");
        return new File(str).exists();
    }
}
