package pb;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Locale;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class e implements a.b {
    private rb.b a;
    private rb.b b;

    e() {
    }

    private static void b(rb.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.c(str, bundle);
    }

    private void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.a : this.b, str, bundle);
    }

    @Override // mb.a.b
    public void a(int i, Bundle bundle) {
        String string;
        qb.g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i), bundle));
        if (bundle == null || (string = bundle.getString(RewardPlus.NAME)) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public void d(rb.b bVar) {
        this.b = bVar;
    }

    public void e(rb.b bVar) {
        this.a = bVar;
    }
}
