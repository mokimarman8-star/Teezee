package ij;

import com.blankj.utilcode.util.Utils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y {
    public static final y a = new y();

    private y() {
    }

    public final boolean a() {
        return !com.transsion.baselib.report.launch.b.a.b().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
