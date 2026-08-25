package zk;

import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.home.bean.LayoutStyle;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l {
    public static final l a = new l();

    private l() {
    }

    public final k a(int i, LayoutStyle layoutStyle, String str) {
        int a2 = a0.a(((i - 1) * 8.0f) + 24.0f);
        int e = (y.e() - a2) / i;
        return new k(e, (int) (e * ((a0.a(92.0f) * 1.0f) / a0.a(164.0f))));
    }
}
