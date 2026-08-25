package androidx.coroutines;

import androidx.coroutines.C0210d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class OverwritingInputMerger extends AbstractC0213g {
    @Override // androidx.coroutines.AbstractC0213g
    public C0210d b(List list) {
        C0210d.a aVar = new C0210d.a();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashMap.putAll(((C0210d) it.next()).h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
