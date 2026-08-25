package ka;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.g3;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b {
    private static final Pattern d = Pattern.compile("\\s+");
    private static final ImmutableSet e = ImmutableSet.of("auto", NetworkUtil.NETWORK_TYPE_NOT_REACHABLE);
    private static final ImmutableSet f = ImmutableSet.of("dot", "sesame", "circle");
    private static final ImmutableSet g = ImmutableSet.of("filled", "open");
    private static final ImmutableSet h = ImmutableSet.of("after", "before", "outside");
    public final int a;
    public final int b;
    public final int c;

    private b(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        String e2 = com.google.common.base.a.e(str.trim());
        if (e2.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(e2, d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
    
        if (r9.equals("dot") != false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b b(ImmutableSet immutableSet) {
        boolean z;
        int i;
        int hashCode;
        String str = (String) g3.f(Sets.e(h, immutableSet), "outside");
        int hashCode2 = str.hashCode();
        boolean z2 = false;
        int i2 = -1;
        if (hashCode2 == -1392885889) {
            if (str.equals("before")) {
                z = 2;
            }
            z = -1;
        } else if (hashCode2 != -1106037339) {
            if (hashCode2 == 92734940 && str.equals("after")) {
                z = false;
            }
            z = -1;
        } else {
            if (str.equals("outside")) {
                z = true;
            }
            z = -1;
        }
        int i3 = z ? !z ? 1 : -2 : 2;
        Sets.f e2 = Sets.e(e, immutableSet);
        if (!e2.isEmpty()) {
            String str2 = (String) e2.iterator().next();
            int hashCode3 = str2.hashCode();
            if (hashCode3 == 3005871) {
                str2.equals("auto");
            } else if (hashCode3 == 3387192 && str2.equals(NetworkUtil.NETWORK_TYPE_NOT_REACHABLE)) {
                i2 = 0;
            }
            return new b(i2, 0, i3);
        }
        Sets.f e3 = Sets.e(g, immutableSet);
        Sets.f e4 = Sets.e(f, immutableSet);
        if (e3.isEmpty() && e4.isEmpty()) {
            return new b(-1, 0, i3);
        }
        String str3 = (String) g3.f(e3, "filled");
        int hashCode4 = str3.hashCode();
        if (hashCode4 == -1274499742) {
            str3.equals("filled");
        } else if (hashCode4 == 3417674 && str3.equals("open")) {
            i = 2;
            String str4 = (String) g3.f(e4, "circle");
            hashCode = str4.hashCode();
            if (hashCode != -1360216880) {
                if (str4.equals("circle")) {
                    z2 = 2;
                }
                z2 = -1;
            } else if (hashCode != -905816648) {
                if (hashCode == 99657) {
                }
                z2 = -1;
            } else {
                if (str4.equals("sesame")) {
                    z2 = true;
                }
                z2 = -1;
            }
            return new b(z2 ? !z2 ? 1 : 3 : 2, i, i3);
        }
        i = 1;
        String str42 = (String) g3.f(e4, "circle");
        hashCode = str42.hashCode();
        if (hashCode != -1360216880) {
        }
        return new b(z2 ? !z2 ? 1 : 3 : 2, i, i3);
    }
}
