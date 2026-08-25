package yw;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements p6.a {
    public static final a h = new a(null);
    private final String a;
    private final String b;
    private final String c;
    private final int d;
    private final long e;
    private final int f;
    private boolean g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(String downloadPath, String downloadShowPath, String pathName, int i, long j, int i2) {
        Intrinsics.h(downloadPath, "downloadPath");
        Intrinsics.h(downloadShowPath, "downloadShowPath");
        Intrinsics.h(pathName, "pathName");
        this.a = downloadPath;
        this.b = downloadShowPath;
        this.c = pathName;
        this.d = i;
        this.e = j;
        this.f = i2;
    }

    public final long a() {
        return this.e;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
    }

    public final boolean f() {
        return this.g;
    }

    public final void g(boolean z) {
        this.g = z;
    }

    public int getItemType() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + s.a(this.e)) * 31) + this.f;
    }

    public String toString() {
        return "DownloadSDCardPathInfo(downloadPath=" + this.a + ", downloadShowPath=" + this.b + ", pathName=" + this.c + ", pathType=" + this.d + ", availableSize=" + this.e + ", itemType=" + this.f + ")";
    }
}
