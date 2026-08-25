package ff;

import android.content.Context;
import com.transsion.baseui.dialog.BaseDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    public static final c a = new c();
    private static final List b = new ArrayList();
    private static final Map c = new LinkedHashMap();

    private c() {
    }

    public final void a() {
        b.clear();
        c.clear();
    }

    public final boolean b(BaseDialog baseDialog, String str) {
        Intrinsics.h(baseDialog, "dialog");
        Intrinsics.h(str, "tag");
        List list = b;
        if (list.isEmpty()) {
            list.add(baseDialog);
            return true;
        }
        c.put(str, baseDialog);
        return false;
    }

    public final void c(Context context) {
        Intrinsics.h(context, "context");
        b.clear();
        Map map = c;
        if (map.isEmpty()) {
            return;
        }
        String str = (String) CollectionsKt.h0(map.keySet());
        BaseDialog baseDialog = (BaseDialog) map.remove(str);
        if (baseDialog == null || !a.b(baseDialog, str)) {
            return;
        }
        baseDialog.k0(context, str);
    }
}
