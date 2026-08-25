package tl;

import com.transsion.lib_web.download_render.data.PageData;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final long a;
    private final PageData b;

    public a(long j, PageData pageData) {
        Intrinsics.h(pageData, "remotePageData");
        this.a = j;
        this.b = pageData;
    }

    public final PageData a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final void c() {
        Iterator it = CollectionsKt.o(new d[]{new e(this.a, this.b), new c(this.a, this.b)}).iterator();
        while (it.hasNext()) {
            ((d) it.next()).start();
        }
    }
}
