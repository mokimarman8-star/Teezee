package nh;

import android.content.Context;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import gj.b;
import ij.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mf.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements b {
    private final String f() {
        return g.a.b() ? "/ugc_search/search_manager" : "/search/activity/search_manager";
    }

    public void a(String str, String str2, List list, Context context) {
        Intrinsics.h(str, "keyword");
        Intrinsics.h(str2, "hotWord");
        Intrinsics.h(list, "searchHotWords");
        Intrinsics.h(context, "context");
        Navigator.x(TheRouter.c(f()).F(NativeComponentConstants.KEY_COMPONENT_TYPE, 3).K("hot_search_word", str2).K("keyword", str), context, (c) null, 2, (Object) null);
        up.c.a.c(list);
    }

    public void b(String str, List list, Context context) {
        Intrinsics.h(str, "hotWord");
        Intrinsics.h(list, "searchHotWords");
        Intrinsics.h(context, "context");
        Navigator.x(TheRouter.c(f()).F(NativeComponentConstants.KEY_COMPONENT_TYPE, 3).K("hot_search_word", str), context, (c) null, 2, (Object) null);
        up.c.a.c(list);
    }

    public void c(String str, Context context) {
        Intrinsics.h(str, "hotWord");
        Intrinsics.h(context, "context");
        Navigator.x(TheRouter.c(f()).F(NativeComponentConstants.KEY_COMPONENT_TYPE, 3).K("hot_search_word", str), context, (c) null, 2, (Object) null);
    }

    public void d(String str, Context context) {
        Intrinsics.h(str, "hotWord");
        Intrinsics.h(context, "context");
        Navigator.x(TheRouter.c(f()).F(NativeComponentConstants.KEY_COMPONENT_TYPE, 1).K("hot_search_word", str), context, (c) null, 2, (Object) null);
    }

    public void e(Context context) {
        Intrinsics.h(context, "context");
        Navigator.x(TheRouter.c("/search/activity/search_manager").F(NativeComponentConstants.KEY_COMPONENT_TYPE, 1).j(268435456), context, (c) null, 2, (Object) null);
    }
}
