package xr;

import com.transsion.gslb.BuildConfig;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private SubtitleDownloadTable a;
    private boolean b;
    private String c;
    private boolean d;

    public b(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "bean");
        this.a = subtitleDownloadTable;
        this.c = BuildConfig.FLAVOR;
    }

    public final SubtitleDownloadTable a() {
        return this.a;
    }

    public final boolean b() {
        return this.a.getStatus() == 5;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.b;
    }

    public final void e(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "<set-?>");
        this.a = subtitleDownloadTable;
    }

    public final void f(boolean z) {
        this.b = z;
    }
}
