package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class h {
    private final Path a;
    private final Object b;
    private final h c;
    private Iterator d;

    public h(Path path, Object obj, h hVar) {
        Intrinsics.h(path, "path");
        this.a = path;
        this.b = obj;
        this.c = hVar;
    }

    public final Iterator a() {
        return this.d;
    }

    public final Object b() {
        return this.b;
    }

    public final h c() {
        return this.c;
    }

    public final Path d() {
        return this.a;
    }

    public final void e(Iterator it) {
        this.d = it;
    }
}
