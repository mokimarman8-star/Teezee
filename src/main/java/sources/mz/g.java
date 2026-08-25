package mz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.tools.ant.types.u;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class g extends a {
    private static u n(Iterator it) {
        return (u) it.next();
    }

    @Override // mz.a
    protected Collection g() {
        return l(false);
    }

    protected Collection l(boolean z) {
        List i = i();
        if (i.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(i.size() * 2);
        HashSet hashSet = new HashSet(i.size() * 2);
        Iterator it = i.iterator();
        while (it.hasNext()) {
            Iterator it2 = n(it).iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (z) {
                    next = next.toString();
                }
                if (hashSet.add(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public String[] m() {
        if (isReference()) {
            return ((g) getCheckedRef()).m();
        }
        Collection l = l(true);
        return (String[]) l.toArray(new String[l.size()]);
    }
}
