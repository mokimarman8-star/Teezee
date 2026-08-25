package dr;

import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.Subject;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a;
    private static final String b;

    static {
        b bVar = new b();
        a = bVar;
        b = bVar.getClass().getSimpleName();
    }

    private b() {
    }

    private final boolean a(Subject subject, ShortTVItem shortTVItem) {
        return (subject == null || subject.getNeedPaid() == 0 || subject.getIsPaid() == 1 || shortTVItem == null || shortTVItem.getNeedPaid() == 0 || subject.getAdUnlockedEps().contains(Integer.valueOf(shortTVItem.getEp()))) ? false : true;
    }

    public final String b(Subject subject, int i) {
        Set<Integer> adUnlockedEps;
        return (subject == null || (adUnlockedEps = subject.getAdUnlockedEps()) == null || !adUnlockedEps.contains(Integer.valueOf(i))) ? (subject == null || subject.getIsPaid() != 1) ? BuildConfig.FLAVOR : "buy" : "ad";
    }

    public final boolean c(Subject subject, ShortTVItem shortTVItem) {
        return a(subject, shortTVItem);
    }

    public final void d(ShortTVItem shortTVItem) {
        Intrinsics.h(shortTVItem, "item");
    }

    public final void e(Subject subject) {
    }

    public final void f(Subject subject) {
        Intrinsics.h(subject, "subject");
        int i = 1;
        int max = Math.max(subject.getTotalEpisode(), 1);
        if (1 > max) {
            return;
        }
        while (true) {
            subject.getAdUnlockedEps().add(Integer.valueOf(i));
            if (i == max) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void g(Subject subject, ShortTVItem shortTVItem, int i) {
        Intrinsics.h(subject, "subject");
        Intrinsics.h(shortTVItem, "epInfo");
        for (int i2 = 0; i2 < i; i2++) {
            int ep2 = shortTVItem.getEp() + i2;
            if (ep2 <= subject.getTotalEpisode()) {
                subject.getAdUnlockedEps().add(Integer.valueOf(ep2));
            }
        }
    }
}
