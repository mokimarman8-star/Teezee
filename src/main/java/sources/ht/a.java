package ht;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private SubtitleDownloadTable a;
    private boolean b;
    private String c;
    private String d;
    private boolean e;
    private String f;

    public a(SubtitleDownloadTable bean) {
        Intrinsics.h(bean, "bean");
        this.a = bean;
        this.c = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public final String a() {
        return this.f;
    }

    public final SubtitleDownloadTable b() {
        return this.a;
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        return this.a.getStatus() == 5;
    }

    public final boolean e() {
        return this.e;
    }

    public final boolean f() {
        return this.b;
    }

    public final void g(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f = str;
    }

    public final void h(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "<set-?>");
        this.a = subtitleDownloadTable;
    }

    public final void i(String str) {
        this.d = str;
    }

    public final void j(boolean z) {
        this.e = z;
    }

    public final void k(String str) {
        Intrinsics.h(str, "<set-?>");
        this.c = str;
    }

    public final void l(boolean z) {
        this.b = z;
    }
}
