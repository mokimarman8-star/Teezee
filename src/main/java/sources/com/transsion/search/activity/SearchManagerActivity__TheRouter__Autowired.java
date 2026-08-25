package com.transsion.search.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class SearchManagerActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof SearchManagerActivity) {
            SearchManagerActivity searchManagerActivity = (SearchManagerActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", searchManagerActivity, new b("boolean", "back_exit", 0, BuildConfig.FLAVOR, "com.transsion.search.activity.SearchManagerActivity", "backExitSearch", false, "No desc."));
                    if (bool != null) {
                        searchManagerActivity.backExitSearch = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", searchManagerActivity, new b("int", "type", 0, BuildConfig.FLAVOR, "com.transsion.search.activity.SearchManagerActivity", "searchType", false, "No desc."));
                    if (num != null) {
                        searchManagerActivity.searchType = num.intValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", searchManagerActivity, new b("java.lang.String", "keyword", 0, BuildConfig.FLAVOR, "com.transsion.search.activity.SearchManagerActivity", "keyWord", false, "No desc."));
                    if (str != null) {
                        searchManagerActivity.keyWord = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
