package ri;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public final String a(ArrayList arrayList) {
        if (arrayList != null) {
            return CollectionsKt.s0(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }

    public final ArrayList b(String str) {
        List S0;
        if (str == null || (S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        return new ArrayList(S0);
    }
}
