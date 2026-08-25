package yh;

import android.text.TextUtils;
import com.transsion.ad.monopoly.model.AdPlans;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public @interface b {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final boolean a(AdPlans adPlans) {
            return TextUtils.equals("AdShowFinal", adPlans != null ? adPlans.getAdShowLevel() : null);
        }
    }
}
