package gn;

import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p003enum.PlayMimeType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sn.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final String a;
    private final String b;
    private final int c;
    private PlayMimeType d;
    private final MediaItem e;
    private String f;
    private final Lazy g;
    private boolean h;
    private boolean i;
    private Map j;

    public e(String str, String str2, int i, PlayMimeType playMimeType, MediaItem mediaItem) {
        Intrinsics.h(str2, "url");
        Intrinsics.h(playMimeType, "mimeType");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = playMimeType;
        this.e = mediaItem;
        this.g = LazyKt.b(new Function0() { // from class: gn.d
            public final Object invoke() {
                String n;
                n = e.n(e.this);
                return n;
            }
        });
    }

    public /* synthetic */ e(String str, String str2, int i, PlayMimeType playMimeType, MediaItem mediaItem, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? PlayMimeType.DEFAULT : playMimeType, (i2 & 16) != 0 ? null : mediaItem);
    }

    private final String b() {
        int o0 = StringsKt.o0(this.b, "?", 0, false, 6, (Object) null);
        if (o0 < 0) {
            return sn.d.a.a(this.b);
        }
        d.a aVar = sn.d.a;
        String substring = this.b.substring(0, o0);
        Intrinsics.g(substring, "substring(...)");
        return aVar.a(substring);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String n(e eVar) {
        return eVar.b();
    }

    public final boolean c() {
        return this.h;
    }

    public final Map d() {
        return this.j;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.a, eVar.a) && Intrinsics.c(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d && Intrinsics.c(this.e, eVar.e);
    }

    public final String f() {
        return (String) this.g.getValue();
    }

    public final String g() {
        return this.f;
    }

    public final MediaItem h() {
        return this.e;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        MediaItem mediaItem = this.e;
        return hashCode + (mediaItem != null ? mediaItem.hashCode() : 0);
    }

    public final PlayMimeType i() {
        return this.d;
    }

    public final String j() {
        return this.b;
    }

    public final int k() {
        return this.c;
    }

    public final boolean l() {
        return this.i;
    }

    public final boolean m() {
        PlayMimeType playMimeType = this.d;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS || StringsKt.c0(this.b, ".mpd", false, 2, (Object) null) || StringsKt.c0(this.b, ".m3u8", false, 2, (Object) null);
    }

    public final void o(Map map) {
        this.j = map;
    }

    public final void p(String str) {
        this.f = str;
    }

    public final void q(PlayMimeType playMimeType) {
        Intrinsics.h(playMimeType, "<set-?>");
        this.d = playMimeType;
    }

    public String toString() {
        return "MediaSource(id=" + this.a + ", url=" + this.b + ", weights=" + this.c + ", mimeType=" + this.d + ", mediaItem=" + this.e + ")";
    }
}
