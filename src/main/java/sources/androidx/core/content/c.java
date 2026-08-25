package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f6995a;

    /* renamed from: b, reason: collision with root package name */
    private final LocusId f6996b;

    private static class a {
        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public c(String str) {
        this.f6995a = (String) i.j(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6996b = a.a(str);
        } else {
            this.f6996b = null;
        }
    }

    private String a() {
        return this.f6995a.length() + "_chars";
    }

    public static c c(LocusId locusId) {
        i.h(locusId, "locusId cannot be null");
        return new c((String) i.j(a.b(locusId), "id cannot be empty"));
    }

    public LocusId b() {
        return this.f6996b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f6995a;
        return str == null ? cVar.f6995a == null : str.equals(cVar.f6995a);
    }

    public int hashCode() {
        String str = this.f6995a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
