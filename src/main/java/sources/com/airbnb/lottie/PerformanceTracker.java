package com.airbnb.lottie;

import android.support.v4.media.session.c;
import androidx.collection.b;
import androidx.core.util.e;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import x4.j;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PerformanceTracker {
    private boolean a = false;
    private final Set b = new b();
    private final Map c = new HashMap();
    private final Comparator d = new Comparator<e>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        public int compare(e eVar, e eVar2) {
            float floatValue = ((Float) eVar.b).floatValue();
            float floatValue2 = ((Float) eVar2.b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public void a(String str, float f) {
        if (this.a) {
            j jVar = (j) this.c.get(str);
            if (jVar == null) {
                jVar = new j();
                this.c.put(str, jVar);
            }
            jVar.a(f);
            if (str.equals("__container")) {
                Iterator it = this.b.iterator();
                if (it.hasNext()) {
                    c.a(it.next());
                    throw null;
                }
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
