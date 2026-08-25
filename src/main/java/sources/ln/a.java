package ln;

import androidx.collection.s;
import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.p003enum.PlayMimeType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final String a;
    private final PlayMimeType b;
    private long c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final List j;
    private final String k;
    private final String l;
    private final String m;
    private final int n;
    private final Integer o;
    private final boolean p;
    private final String q;
    private final String r;
    private UGCVideo s;
    private DownloadBean t;
    private Subject u;
    private final List v;

    public a(String str, PlayMimeType playMimeType, long j, int i, int i2, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i3, Integer num, boolean z, String str9, String str10) {
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(playMimeType, "videoFormat");
        Intrinsics.h(str2, "subjectName");
        Intrinsics.h(str4, "pageFrom");
        Intrinsics.h(str5, "pageName");
        Intrinsics.h(list, "playSteams");
        Intrinsics.h(str6, "cover");
        Intrinsics.h(str7, "thumbnail");
        Intrinsics.h(str8, "averageHueLight");
        this.a = str;
        this.b = playMimeType;
        this.c = j;
        this.d = i;
        this.e = i2;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = list;
        this.k = str6;
        this.l = str7;
        this.m = str8;
        this.n = i3;
        this.o = num;
        this.p = z;
        this.q = str9;
        this.r = str10;
        this.v = new ArrayList();
    }

    public /* synthetic */ a(String str, PlayMimeType playMimeType, long j, int i, int i2, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i3, Integer num, boolean z, String str9, String str10, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, playMimeType, (i4 & 4) != 0 ? 0L : j, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, str2, (i4 & 64) != 0 ? null : str3, str4, str5, (i4 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? new ArrayList() : list, str6, str7, str8, i3, (i4 & 16384) != 0 ? 1 : num, (32768 & i4) != 0 ? false : z, str9, (i4 & 131072) != 0 ? null : str10);
    }

    public final void A(UGCVideo uGCVideo) {
        this.s = uGCVideo;
    }

    public final List a() {
        return this.v;
    }

    public final String b() {
        return this.m;
    }

    public final String c() {
        return this.k;
    }

    public final DownloadBean d() {
        return this.t;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.c(this.f, aVar.f) && Intrinsics.c(this.g, aVar.g) && Intrinsics.c(this.h, aVar.h) && Intrinsics.c(this.i, aVar.i) && Intrinsics.c(this.j, aVar.j) && Intrinsics.c(this.k, aVar.k) && Intrinsics.c(this.l, aVar.l) && Intrinsics.c(this.m, aVar.m) && this.n == aVar.n && Intrinsics.c(this.o, aVar.o) && this.p == aVar.p && Intrinsics.c(this.q, aVar.q) && Intrinsics.c(this.r, aVar.r);
    }

    public final String f() {
        return this.g;
    }

    public final boolean g() {
        return this.p;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + s.a(this.c)) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int hashCode2 = (((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n) * 31;
        Integer num = this.o;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + e.a(this.p)) * 31;
        String str2 = this.q;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.r;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String i() {
        return this.i;
    }

    public final List j() {
        return this.j;
    }

    public final long k() {
        return this.c;
    }

    public final int l() {
        return this.e;
    }

    public final Subject m() {
        return this.u;
    }

    public final int n() {
        return this.n;
    }

    public final String o() {
        return this.a;
    }

    public final String p() {
        return this.f;
    }

    public final String q() {
        return this.r;
    }

    public final Integer r() {
        return this.o;
    }

    public final String s() {
        return this.l;
    }

    public final String t() {
        return this.q;
    }

    public String toString() {
        return "LongVdPlayerBean(subjectId=" + this.a + ", videoFormat=" + this.b + ", progress=" + this.c + ", ep=" + this.d + ", se=" + this.e + ", subjectName=" + this.f + ", episodeTitle=" + this.g + ", pageFrom=" + this.h + ", pageName=" + this.i + ", playSteams=" + this.j + ", cover=" + this.k + ", thumbnail=" + this.l + ", averageHueLight=" + this.m + ", subjectDurationSeconds=" + this.n + ", subjectType=" + this.o + ", hasDelete=" + this.p + ", titleName=" + this.q + ", subjectOps=" + this.r + ")";
    }

    public final UGCVideo u() {
        return this.s;
    }

    public final PlayMimeType v() {
        return this.b;
    }

    public final boolean w() {
        PlayMimeType playMimeType = this.b;
        if (playMimeType != PlayMimeType.DEFAULT) {
            return playMimeType == PlayMimeType.HLS && this.j.size() > 1;
        }
        return true;
    }

    public final void x(DownloadBean downloadBean) {
        this.t = downloadBean;
    }

    public final void y(long j) {
        this.c = j;
    }

    public final void z(Subject subject) {
        this.u = subject;
    }
}
