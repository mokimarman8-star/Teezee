package com.transsion.home.category;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class CategoryActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof CategoryActivity) {
            CategoryActivity categoryActivity = (CategoryActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", categoryActivity, new b("java.lang.String", "categoryType", 0, BuildConfig.FLAVOR, "com.transsion.home.category.CategoryActivity", "categoryType", false, "No desc."));
                    if (str != null) {
                        categoryActivity.categoryType = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", categoryActivity, new b("java.lang.String", "showType", 0, BuildConfig.FLAVOR, "com.transsion.home.category.CategoryActivity", "showType", false, "No desc."));
                    if (str2 != null) {
                        categoryActivity.showType = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
