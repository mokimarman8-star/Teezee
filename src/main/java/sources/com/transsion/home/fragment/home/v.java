package com.transsion.home.fragment.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tn.lib.widget.R;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v {
    public static final a b = new a(null);
    public static final int c = 8;
    private final ImageView a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v(ImageView imageView) {
        Intrinsics.h(imageView, "ivNovelIcon");
        this.a = imageView;
        b();
    }

    private final void b() {
        ConfigBean d = cm.f.d(cm.f.c.a(), "sa_novel_icon_config", false, 2, (Object) null);
        String value = d != null ? d.getValue() : null;
        if (value == null || value.length() == 0) {
            uf.c.g(this.a);
            return;
        }
        try {
            final HomeNovelIconBean homeNovelIconBean = (HomeNovelIconBean) com.blankj.utilcode.util.o.d(value, HomeNovelIconBean.class);
            String deeplink = homeNovelIconBean.getDeeplink();
            if (deeplink != null && deeplink.length() != 0) {
                String icUrl = homeNovelIconBean.getIcUrl();
                if (icUrl != null) {
                    f.a aVar = ni.f.a;
                    Context context = this.a.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    aVar.m(context).g(icUrl).i(R.color.transparent).d(this.a);
                }
                uf.c.k(this.a);
                d();
                this.a.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        v.c(v.this, homeNovelIconBean, view);
                    }
                });
                return;
            }
            uf.c.g(this.a);
        } catch (Throwable unused) {
            uf.c.g(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(v vVar, HomeNovelIconBean homeNovelIconBean, View view) {
        vVar.e();
        ij.k.h(homeNovelIconBean.getDeeplink(), null, 1, null);
    }

    private final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "icon");
        linkedHashMap.put("item_type", "novel");
        qi.h.a.z("Trending", linkedHashMap);
    }

    private final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "icon");
        linkedHashMap.put("item_type", "novel");
        qi.h.a.o("Trending", linkedHashMap);
    }
}
