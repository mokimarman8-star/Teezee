package androidx.datastore.flow;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o {
    public static final m a(File file) {
        Intrinsics.h(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        Intrinsics.g(absolutePath, "file.canonicalFile.absolutePath");
        return n.a(absolutePath);
    }
}
