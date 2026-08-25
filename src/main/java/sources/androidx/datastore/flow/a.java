package androidx.datastore.flow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7462a = new a();

    private a() {
    }

    public final boolean a(File file, File file2) {
        Intrinsics.h(file, "srcFile");
        Intrinsics.h(file2, "dstFile");
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
