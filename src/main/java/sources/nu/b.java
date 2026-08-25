package nu;

import android.graphics.drawable.Drawable;
import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public String a;
    public Drawable b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    public b(String packageName, Drawable drawable, String appName, long j, String versionName, String lan, String appKey, String countryCode, String brand, String model, String originModel, String androidVersion, String defaultLocal) {
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(appName, "appName");
        Intrinsics.h(versionName, "versionName");
        Intrinsics.h(lan, "lan");
        Intrinsics.h(appKey, "appKey");
        Intrinsics.h(countryCode, "countryCode");
        Intrinsics.h(brand, "brand");
        Intrinsics.h(model, "model");
        Intrinsics.h(originModel, "originModel");
        Intrinsics.h(androidVersion, "androidVersion");
        Intrinsics.h(defaultLocal, "defaultLocal");
        this.a = packageName;
        this.b = drawable;
        this.c = appName;
        this.d = j;
        this.e = versionName;
        this.f = lan;
        this.g = appKey;
        this.h = countryCode;
        this.i = brand;
        this.j = model;
        this.k = originModel;
        this.l = androidVersion;
        this.m = defaultLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && this.d == bVar.d && Intrinsics.c(this.e, bVar.e) && Intrinsics.c(this.f, bVar.f) && Intrinsics.c(this.g, bVar.g) && Intrinsics.c(this.h, bVar.h) && Intrinsics.c(this.i, bVar.i) && Intrinsics.c(this.j, bVar.j) && Intrinsics.c(this.k, bVar.k) && Intrinsics.c(this.l, bVar.l) && Intrinsics.c(this.m, bVar.m);
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Drawable drawable = this.b;
        return this.m.hashCode() + a.a(this.l, a.a(this.k, a.a(this.j, a.a(this.i, a.a(this.h, a.a(this.g, a.a(this.f, a.a(this.e, (s.a(this.d) + a.a(this.c, (hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "CurrentPackageInfo(packageName=" + this.a + ", iconDrawable=" + this.b + ", appName=" + this.c + ", currentVersion=" + this.d + ", versionName=" + this.e + ", lan=" + this.f + ", appKey=" + this.g + ", countryCode=" + this.h + ", brand=" + this.i + ", model=" + this.j + ", originModel=" + this.k + ", androidVersion=" + this.l + ", defaultLocal=" + this.m + ')';
    }
}
