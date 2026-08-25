package com.transsion.lib_web.download_render.init;

import cm.f;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.transsion.base.report.athena.sampler.EventConfig;
import com.transsion.base.report.athena.sampler.EventStrategyBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ConfigTask implements c {
    public static final a a = new a(null);
    private static final String b = "(event =='files_download')";
    private static final String c = "(event =='render')";
    private static final String d = "(event =='pages_download')";
    private static final EventStrategyBean e = new EventStrategyBean("(event =='files_download')", "pre_download", 1);
    private static final EventStrategyBean f = new EventStrategyBean("(event =='render')", "pre_download", 1);
    private static final EventStrategyBean g = new EventStrategyBean("(event =='pages_download')", "pre_download", 1);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:3:0x0007, B:5:0x0016, B:8:0x0022, B:10:0x003e, B:11:0x00b4, B:15:0x004f), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #1 {all -> 0x001d, blocks: (B:3:0x0007, B:5:0x0016, B:8:0x0022, B:10:0x003e, B:11:0x00b4, B:15:0x004f), top: B:2:0x0007 }] */
    @Override // com.transsion.lib_web.download_render.init.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke() {
        String str;
        List arrayList = new ArrayList();
        try {
            boolean z = true;
            ConfigBean c2 = f.c.a().c("point_config", true);
            if (c2 != null) {
                str = c2.getValue();
                if (str == null) {
                }
                h.a.a("DR_Config", "remote point config: " + str);
                if (StringsKt.q0(str)) {
                    List<EventStrategyBean> list = (List) o.e(str, new TypeToken<List<EventStrategyBean>>() { // from class: com.transsion.lib_web.download_render.init.ConfigTask$invoke$type$1
                    }.getType());
                    try {
                        boolean z2 = true;
                        boolean z3 = true;
                        for (EventStrategyBean eventStrategyBean : list) {
                            if (Intrinsics.c(eventStrategyBean.getEventExpr(), b)) {
                                z = false;
                            }
                            if (Intrinsics.c(eventStrategyBean.getEventExpr(), c)) {
                                z2 = false;
                            }
                            if (Intrinsics.c(eventStrategyBean.getEventExpr(), d)) {
                                z3 = false;
                            }
                        }
                        if (z) {
                            list.add(e);
                        }
                        if (z2) {
                            list.add(f);
                        }
                        if (z3) {
                            list.add(g);
                        }
                        arrayList = list;
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList = list;
                        arrayList.clear();
                        arrayList.add(e);
                        arrayList.add(f);
                        arrayList.add(g);
                        String j = o.j(arrayList);
                        h.a.a("DR_Config", "fail: " + th + ", point config: " + j);
                        EventConfig.a.j(j);
                        return;
                    }
                } else {
                    arrayList.add(e);
                    arrayList.add(f);
                    arrayList.add(g);
                }
                String j2 = o.j(arrayList);
                h.a.a("DR_Config", "point config: " + j2);
                EventConfig.a.j(j2);
            }
            str = BuildConfig.FLAVOR;
            h.a.a("DR_Config", "remote point config: " + str);
            if (StringsKt.q0(str)) {
            }
            String j22 = o.j(arrayList);
            h.a.a("DR_Config", "point config: " + j22);
            EventConfig.a.j(j22);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
