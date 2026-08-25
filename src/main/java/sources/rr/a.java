package rr;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.ui.dialog.ShortTvDownloadResDialog;
import kotlin.jvm.internal.Intrinsics;
import mf.c;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final void a(FragmentActivity fragmentActivity, String str, String str2, String str3, boolean z, Subject subject, String str4, Boolean bool) {
        String str5 = str2;
        Intrinsics.h(fragmentActivity, "activity");
        if (!z && Intrinsics.c(bool, Boolean.FALSE)) {
            Navigator.x(TheRouter.c(pr.a.a.b()).z("download", true).K("id", str4 == null ? subject != null ? subject.getSubjectId() : null : str4).K("ops", str2), fragmentActivity, (c) null, 2, (Object) null);
            return;
        }
        if (str5 == null || str2.length() == 0) {
            Bundle extras = fragmentActivity.getIntent().getExtras();
            str5 = extras != null ? extras.getString("ops") : null;
        }
        String str6 = str5;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        ShortTvDownloadResDialog.i.a(str, h.a.h(), subject, str6, str3, z).show(supportFragmentManager, "download");
    }
}
