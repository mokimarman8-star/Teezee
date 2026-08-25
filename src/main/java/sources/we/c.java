package we;

import android.view.View;
import com.iab.omid.library.vungle.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;
import we.a;
import xe.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // we.a
    public JSONObject a(View view) {
        JSONObject b = xe.c.b(0, 0, 0, 0);
        xe.c.e(b, e.a());
        return b;
    }

    @Override // we.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0202a interfaceC0202a, boolean z, boolean z2) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0202a.a((View) it.next(), this.a, jSONObject, z2);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.vungle.internal.c e = com.iab.omid.library.vungle.internal.c.e();
        if (e != null) {
            Collection a = e.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a.size() * 2) + 3);
            Iterator it = a.iterator();
            while (it.hasNext()) {
                View l = ((h) it.next()).l();
                if (l != null && xe.h.g(l) && (rootView = l.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d = xe.h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && xe.h.d((View) arrayList.get(size - 1)) > d) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
