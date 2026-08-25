package oe;

import android.content.Context;
import com.iab.omid.library.mmadbridge.internal.i;
import com.iab.omid.library.mmadbridge.internal.j;
import re.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    private boolean a;

    private void c(Context context) {
        g.d(context, "Application Context cannot be null");
    }

    void a(Context context) {
        c(context);
        if (d()) {
            return;
        }
        b(true);
        i.d().b(context);
        com.iab.omid.library.mmadbridge.internal.b.k().a(context);
        re.a.b(context);
        re.c.d(context);
        re.e.c(context);
        com.iab.omid.library.mmadbridge.internal.g.c().b(context);
        com.iab.omid.library.mmadbridge.internal.a.a().b(context);
        j.f().b(context);
    }

    void b(boolean z) {
        this.a = z;
    }

    boolean d() {
        return this.a;
    }
}
