package q8;

import android.content.Context;
import android.support.v4.media.session.c;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b {
    private static AdvertisingIdClient.Info a(Context context) {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (GooglePlayServicesRepairableException e) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e);
            return null;
        } catch (GooglePlayServicesNotAvailableException e2) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e2);
            return null;
        } catch (Exception e3) {
            com.facebook.biddingkit.logging.b.d("Utils", "Failed to get AdvertisingIdClient: ", e3);
            return null;
        }
    }

    public static r8.b[] b(r8.a aVar) {
        r8.b[] bVarArr = new r8.b[2];
        if (aVar == null) {
            return bVarArr;
        }
        Iterator it = aVar.entries().iterator();
        if (!it.hasNext()) {
            return bVarArr;
        }
        c.a(it.next());
        throw null;
    }

    public static String c(Context context) {
        AdvertisingIdClient.Info a = a(context);
        return a != null ? a.getId() : "";
    }
}
