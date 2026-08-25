package ls;

import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv_pugc.utils.h;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final boolean a() {
        return !h.a.g().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
