package com.transsnet.downloader.viewmodel;

import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private final int a;
    private final String b;
    private final DownloadBean c;
    private final boolean d;

    public b(int i, String formatSize, DownloadBean downloadBean, boolean z) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        this.a = i;
        this.b = formatSize;
        this.c = downloadBean;
        this.d = z;
    }

    public final int a() {
        return this.a;
    }

    public final DownloadBean b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final boolean d() {
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
        return this.a == bVar.a && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && this.d == bVar.d;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + e.a(this.d);
    }

    public String toString() {
        return "Download2ResultContent(count=" + this.a + ", formatSize=" + this.b + ", downloadBean=" + this.c + ", isCancel=" + this.d + ")";
    }
}
