package qe;

import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;
import qe.a;
import re.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // qe.a
    public JSONObject a(View view) {
        JSONObject b = re.c.b(0, 0, 0, 0);
        re.c.e(b, e.a());
        return b;
    }

    @Override // qe.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0197a interfaceC0197a, boolean z, boolean z2) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0197a.a((View) it.next(), this.a, jSONObject, z2);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.mmadbridge.internal.c e = com.iab.omid.library.mmadbridge.internal.c.e();
        if (e != null) {
            Collection a = e.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a.size() * 2) + 3);
            Iterator it = a.iterator();
            while (it.hasNext()) {
                View n = ((h) it.next()).n();
                if (n != null && re.h.g(n) && (rootView = n.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d = re.h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && re.h.d((View) arrayList.get(size - 1)) > d) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
