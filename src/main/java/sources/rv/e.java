package rv;

import com.transsion.baselib.helper.a;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    private final HashSet a = new HashSet();

    public final void a(String pageName, String moduleName, String str, Integer num, boolean z) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        hashMap.put("subject_id", str);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        hashMap.put("position", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        hashMap.put("has_resource", sb2.toString());
        a.a.i(pageName, hashMap);
    }
}
