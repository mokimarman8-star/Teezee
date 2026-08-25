package qu;

import android.content.Context;
import com.transsion.gslb.GslbSdk;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import tu.i;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final a d = new a();
    public static volatile c e;
    public final String[] a = new String[3];
    public String b;
    public String c;

    public c() {
        a();
    }

    public final void a() {
        if (f.o.a().d) {
            this.a[0] = "https://test-upgrade-api.palmplaystore.com/";
        } else {
            this.a[0] = "https://app-manage-api.shalltry.com/";
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        this.b = i.b.a(context).a("KV_UPGRADE_GSLB_COUNTRY", HttpUrl.FRAGMENT_ENCODE_SET);
        GslbSdk.init(context, this.a, new b(this, context));
    }
}
