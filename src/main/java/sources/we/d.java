package we;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import we.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d implements a {
    private final int[] a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0202a interfaceC0202a, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            interfaceC0202a.a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }

    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0202a interfaceC0202a, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0202a.a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    @Override // we.a
    public JSONObject a(View view) {
        if (view == null) {
            return xe.c.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] iArr = this.a;
        return xe.c.b(iArr[0], iArr[1], width, height);
    }

    @Override // we.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0202a interfaceC0202a, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z) {
                c(viewGroup, jSONObject, interfaceC0202a, z2);
            } else {
                b(viewGroup, jSONObject, interfaceC0202a, z2);
            }
        }
    }
}
