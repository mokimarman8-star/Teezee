package xq;

import android.content.Context;
import android.view.View;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.Subject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    public static final void a(View view) {
        Intrinsics.h(view, "<this>");
        view.setPadding(view.getPaddingStart(), cr.a.a(36), view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static final int b(Context context) {
        Intrinsics.h(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            identifier = cr.a.a(24);
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static final void c(Subject subject) {
        if (subject == null) {
            return;
        }
        hr.c.k(TheRouter.c(pr.a.a.b()).K("id", subject.getSubjectId()).F("ep", 1).K("ops", subject.getOps()));
    }

    public static final void d(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str2);
        if (str3 != null) {
            hashMap.put("group_id", str3);
        }
        if (str4 != null) {
            hashMap.put("subject_id", str4);
        }
        if (str5 != null) {
            hashMap.put("post_id", str5);
        }
        if (str6 != null) {
            hashMap.put("ops", str6);
        }
        h.a.o(str, hashMap);
    }

    public static /* synthetic */ void e(String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        String str7 = (i & 4) != 0 ? BuildConfig.FLAVOR : str3;
        String str8 = (i & 8) != 0 ? BuildConfig.FLAVOR : str4;
        String str9 = (i & 16) != 0 ? BuildConfig.FLAVOR : str5;
        if ((i & 32) != 0) {
            str6 = null;
        }
        d(str, str2, str7, str8, str9, str6);
    }

    public static final void f(String str, String str2, String str3) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "pageFrom");
        Intrinsics.h(str3, "duration");
        HashMap hashMap = new HashMap();
        hashMap.put("page_from", str2);
        hashMap.put("duration", str3);
        h.a.q(str, "pt", hashMap);
    }
}
