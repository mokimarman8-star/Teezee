package ke;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import ke.a;
import le.e;
import le.i;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // ke.a
    public JSONObject a(View view) {
        JSONObject c = le.c.c(0, 0, 0, 0);
        le.c.e(c, e.a());
        return c;
    }

    @Override // ke.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0190a interfaceC0190a, boolean z, boolean z2) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0190a.a((View) it.next(), this.a, jSONObject, z2);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.hisavana.internal.c e = com.iab.omid.library.hisavana.internal.c.e();
        if (e != null) {
            Collection a = e.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a.size() * 2) + 3);
            Iterator it = a.iterator();
            while (it.hasNext()) {
                View m = ((h) it.next()).m();
                if (m != null && i.g(m) && (rootView = m.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d = i.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && i.d((View) arrayList.get(size - 1)) > d) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
