package hi;

import android.os.Bundle;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.athena;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    private final TrackData a;
    private String b;
    private long c;

    public a(String str) {
        long b = athena.b();
        this.c = b;
        if (b == 0) {
            aethna.b("FAILED! You should init Athena first before track the event " + str);
        }
        this.b = str;
        this.a = new TrackData();
    }

    public a(String str, int i) {
        this.c = i;
        this.b = str;
        this.a = new TrackData();
    }

    private void a(String str, Bundle bundle) {
        if (bundle != null) {
            this.a.add(str, bundle);
        }
    }

    public void b() {
        AthenaAnalytics.L(this.c).h0(this.b, this.a, this.c);
    }

    public a c(Bundle bundle, Bundle bundle2) {
        a("eparam", bundle);
        a("ext", bundle2);
        return this;
    }
}
