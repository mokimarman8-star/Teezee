package androidx.datastore.flow;

import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j {
    public static final boolean a(File file, File file2) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(file2, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? a.f7462a.a(file, file2) : file.renameTo(file2);
    }
}
