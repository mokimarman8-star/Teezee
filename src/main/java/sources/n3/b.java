package n3;

import android.text.TextUtils;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.g3;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f16567d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    private static final ImmutableSet f16568e = ImmutableSet.of("auto", "none");

    /* renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f16569f = ImmutableSet.of("dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    private static final ImmutableSet f16570g = ImmutableSet.of("filled", "open");

    /* renamed from: h, reason: collision with root package name */
    private static final ImmutableSet f16571h = ImmutableSet.of("after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f16572a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16573b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16574c;

    private b(int i5, int i6, int i7) {
        this.f16572a = i5;
        this.f16573b = i6;
        this.f16574c = i7;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        String e5 = com.google.common.base.a.e(str.trim());
        if (e5.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(e5, f16567d)));
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
        boolean z5;
        int i5;
        int hashCode;
        String str = (String) g3.f(Sets.e(f16571h, immutableSet), "outside");
        int hashCode2 = str.hashCode();
        boolean z6 = false;
        int i6 = -1;
        if (hashCode2 == -1392885889) {
            if (str.equals("before")) {
                z5 = 2;
            }
            z5 = -1;
        } else if (hashCode2 != -1106037339) {
            if (hashCode2 == 92734940 && str.equals("after")) {
                z5 = false;
            }
            z5 = -1;
        } else {
            if (str.equals("outside")) {
                z5 = true;
            }
            z5 = -1;
        }
        int i7 = z5 ? !z5 ? 1 : -2 : 2;
        Sets.f e5 = Sets.e(f16568e, immutableSet);
        if (!e5.isEmpty()) {
            String str2 = (String) e5.iterator().next();
            int hashCode3 = str2.hashCode();
            if (hashCode3 == 3005871) {
                str2.equals("auto");
            } else if (hashCode3 == 3387192 && str2.equals("none")) {
                i6 = 0;
            }
            return new b(i6, 0, i7);
        }
        Sets.f e6 = Sets.e(f16570g, immutableSet);
        Sets.f e7 = Sets.e(f16569f, immutableSet);
        if (e6.isEmpty() && e7.isEmpty()) {
            return new b(-1, 0, i7);
        }
        String str3 = (String) g3.f(e6, "filled");
        int hashCode4 = str3.hashCode();
        if (hashCode4 == -1274499742) {
            str3.equals("filled");
        } else if (hashCode4 == 3417674 && str3.equals("open")) {
            i5 = 2;
            String str4 = (String) g3.f(e7, "circle");
            hashCode = str4.hashCode();
            if (hashCode != -1360216880) {
                if (str4.equals("circle")) {
                    z6 = 2;
                }
                z6 = -1;
            } else if (hashCode != -905816648) {
                if (hashCode == 99657) {
                }
                z6 = -1;
            } else {
                if (str4.equals("sesame")) {
                    z6 = true;
                }
                z6 = -1;
            }
            return new b(z6 ? !z6 ? 1 : 3 : 2, i5, i7);
        }
        i5 = 1;
        String str42 = (String) g3.f(e7, "circle");
        hashCode = str42.hashCode();
        if (hashCode != -1360216880) {
        }
        return new b(z6 ? !z6 ? 1 : 3 : 2, i5, i7);
    }
}
