package ok;

import com.transsion.home.bean.HomePreferencesConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final int a;
    private final HomePreferencesConfig b;

    public a(int i, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        this.a = i;
        this.b = homePreferencesConfig;
    }

    public final HomePreferencesConfig a() {
        return this.b;
    }

    public final int b() {
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
        return this.a == aVar.a && Intrinsics.c(this.b, aVar.b);
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "HomePreferencesInsertInstruction(position=" + this.a + ", config=" + this.b + ")";
    }
}
