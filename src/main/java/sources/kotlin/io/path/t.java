package kotlin.io.path;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class t extends PathsKt__PathRecursiveFunctionsKt {
    public static final String b(Path path) {
        Path fileName;
        Intrinsics.h(path, "<this>");
        fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj == null ? HttpUrl.FRAGMENT_ENCODE_SET : obj;
    }

    public static final List c(Path path, String glob) {
        DirectoryStream newDirectoryStream;
        Intrinsics.h(path, "<this>");
        Intrinsics.h(glob, "glob");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a = s.a(newDirectoryStream);
            Intrinsics.e(a);
            List R0 = CollectionsKt.R0(a);
            CloseableKt.a(newDirectoryStream, null);
            return R0;
        } finally {
        }
    }

    public static /* synthetic */ List d(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "*";
        }
        return c(path, str);
    }
}
