package ue;

import android.content.Context;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.internal.j;
import xe.e;
import xe.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
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
        com.iab.omid.library.vungle.internal.b.k().a(context);
        xe.a.b(context);
        xe.c.d(context);
        e.c(context);
        com.iab.omid.library.vungle.internal.g.c().b(context);
        com.iab.omid.library.vungle.internal.a.a().b(context);
        j.f().b(context);
    }

    void b(boolean z) {
        this.a = z;
    }

    boolean d() {
        return this.a;
    }
}
