package com.transsion.ad;

import androidx.compose.foundation.e;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.strategy.AppManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class MBAd {
    public static final MBAd a = new MBAd();
    private static a b;

    public static final class a {
        private final String a;
        private final boolean b;
        private final boolean c;
        private final AppManager.AppEnum d;
        private final String e;
        private final String f;
        private final boolean g;
        private final rh.a h;
        private final boolean i;
        private final boolean j;
        private final boolean k;

        public a(String str, boolean z, boolean z2, AppManager.AppEnum appEnum, String str2, String str3, boolean z3, rh.a aVar, boolean z4, boolean z5, boolean z6) {
            Intrinsics.h(str, "hisavanaAppId");
            Intrinsics.h(appEnum, "appEnum");
            Intrinsics.h(str2, "hotSceneId");
            Intrinsics.h(str3, "adConfigUrl");
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = appEnum;
            this.e = str2;
            this.f = str3;
            this.g = z3;
            this.h = aVar;
            this.i = z4;
            this.j = z5;
            this.k = z6;
        }

        public final String a() {
            return this.f;
        }

        public final boolean b() {
            return this.b;
        }

        public final AppManager.AppEnum c() {
            return this.d;
        }

        public final rh.a d() {
            return this.h;
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && Intrinsics.c(this.e, aVar.e) && Intrinsics.c(this.f, aVar.f) && this.g == aVar.g && Intrinsics.c(this.h, aVar.h) && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k;
        }

        public final String f() {
            return this.e;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.i;
        }

        public int hashCode() {
            int hashCode = ((((((((((((this.a.hashCode() * 31) + e.a(this.b)) * 31) + e.a(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + e.a(this.g)) * 31;
            rh.a aVar = this.h;
            return ((((((hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + e.a(this.i)) * 31) + e.a(this.j)) * 31) + e.a(this.k);
        }

        public final boolean i() {
            return this.k;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.c;
        }

        public final String l() {
            return StringsKt.n("\n                AdInitParams {\n                    hisavanaAppId = " + this.a + "\n                    adTestDevice = " + this.b + "\n                    isDebug = " + this.c + "\n                    appEnum = " + this.d.getValue() + "\n                    hotSceneId = " + this.e + "\n                    adConfigUrl = " + this.f + "\n                    mediaDisposeAppForeground = " + this.g + "\n                    businessBridge = " + this.h + "\n                    mediaDisposeH5Url = " + this.i + "\n                    skipHiSdkInitDelay = " + this.j + "\n                    openPsActivateAd = " + this.k + "\n                }\n            ");
        }

        public String toString() {
            return "AdInitParams(hisavanaAppId=" + this.a + ", adTestDevice=" + this.b + ", isDebug=" + this.c + ", appEnum=" + this.d + ", hotSceneId=" + this.e + ", adConfigUrl=" + this.f + ", mediaDisposeAppForeground=" + this.g + ", businessBridge=" + this.h + ", mediaDisposeH5Url=" + this.i + ", skipHiSdkInitDelay=" + this.j + ", openPsActivateAd=" + this.k + ")";
        }
    }

    public static final class b {
        private boolean b;
        private boolean c;
        private boolean g;
        private rh.a h;
        private boolean i;
        private boolean j;
        private boolean k;
        private String a = TtmlNode.ANONYMOUS_REGION_ID;
        private AppManager.AppEnum d = AppManager.AppEnum.APP_MOVIE_BOX;
        private String e = TtmlNode.ANONYMOUS_REGION_ID;
        private String f = TtmlNode.ANONYMOUS_REGION_ID;

        public final a a() {
            if (this.a.length() == 0) {
                throw new IllegalArgumentException("HiSavana App ID must not be empty");
            }
            if (this.f.length() != 0) {
                return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
            }
            throw new IllegalArgumentException("AdConfigUrl must not be empty");
        }

        public final b b(String str) {
            Intrinsics.h(str, "adConfigUrl");
            this.f = str;
            return this;
        }

        public final b c(boolean z) {
            this.b = z;
            return this;
        }

        public final b d(AppManager.AppEnum appEnum) {
            Intrinsics.h(appEnum, "appEnum");
            this.d = appEnum;
            return this;
        }

        public final b e(rh.a aVar) {
            this.h = aVar;
            return this;
        }

        public final b f(String str) {
            Intrinsics.h(str, "hisavanaAppId");
            this.a = str;
            return this;
        }

        public final b g(String str) {
            Intrinsics.h(str, "hotSceneId");
            this.e = str;
            return this;
        }

        public final b h(boolean z) {
            this.c = z;
            return this;
        }

        public final b i(boolean z) {
            this.g = z;
            return this;
        }

        public final b j(boolean z) {
            this.i = z;
            return this;
        }

        public final b k(boolean z) {
            this.k = z;
            return this;
        }

        public final b l(boolean z) {
            this.j = z;
            return this;
        }
    }

    private MBAd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        String simpleName = MBAd.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final a b() {
        return b;
    }

    public final Object d(a aVar, Continuation continuation) {
        if (b == null) {
            b = aVar;
            Object g = i.g(y0.b(), new MBAd$initAd$2(aVar, null), continuation);
            return g == IntrinsicsKt.f() ? g : Unit.a;
        }
        xh.a.c(xh.a.a, c() + " --> initAd() --> 广告SDK，已经初始化", 6, false, 4, (Object) null);
        return Unit.a;
    }

    public final Object e(String str, Continuation continuation) {
        Object g = i.g(y0.b(), new MBAd$initNonAd$2(str, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
