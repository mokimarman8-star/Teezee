package ls;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e {
    public static final String a(long j) {
        if (j < 0) {
            a.a.f(wf.a.a, MRAIDPresenter.ERROR, "formatNumber count< 0", false, 4, (Object) null);
            return "0";
        }
        if (j < 1000) {
            return String.valueOf(j);
        }
        if (j < 1000000) {
            BigDecimal divide = new BigDecimal(j).divide(new BigDecimal(1000), 1, 4);
            Intrinsics.g(divide, "divide(...)");
            return divide + " k";
        }
        BigDecimal divide2 = new BigDecimal(j).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.g(divide2, "divide(...)");
        return divide2 + " m";
    }
}
