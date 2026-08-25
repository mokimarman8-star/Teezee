package hr;

import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.utils.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final boolean a() {
        return !h.a.e().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
