package tj;

import android.app.Activity;
import android.text.TextUtils;
import ci.p;
import com.blankj.utilcode.util.o;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.bean.HomePopupRequestEntity;
import com.transsion.commercialization.dialog.TaskCommonDialog;
import com.transsion.commercialization.dialog.TrendingFloatView;
import com.transsion.gslb.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements wj.a {
    public static final a d = new a(null);
    private TrendingFloatView a;
    private final Lazy b = LazyKt.b(new Function0() { // from class: tj.a
        public final Object invoke() {
            c.d();
            return null;
        }
    });
    private WeakReference c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ e d() {
        i();
        return null;
    }

    private final String e() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final List f(HomePopupEntity homePopupEntity, boolean z, String str) {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("global_dialog_date", BuildConfig.FLAVOR);
        String b = p.b(p.a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null);
        if (TextUtils.equals(b, string) || !z) {
            String string2 = Intrinsics.c(str, "popup") ? bVar.b().getString("global_dialog_history", (String) null) : bVar.b().getString("global_widget_history", (String) null);
            if (string2 == null) {
                return new ArrayList();
            }
            Object e = o.e(string2, o.g(HomePopupRequestEntity.class));
            Intrinsics.g(e, "fromJson(...)");
            return (List) e;
        }
        a.a.l(wf.a.a, "zxb_popup", e() + " --> getDialogRecord() --> 不是同一天数据，return mutableListOf() --> currentDate = " + b + " -- globalDialogDate = " + string + " --> 不是同一天数据，需要清空本地保存的数据", false, 4, (Object) null);
        if (Intrinsics.c(str, "popup")) {
            bVar.b().putString("global_dialog_history", (String) null);
        } else {
            bVar.b().putString("global_widget_history", (String) null);
        }
        return new ArrayList();
    }

    static /* synthetic */ List g(c cVar, HomePopupEntity homePopupEntity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = "popup";
        }
        return cVar.f(homePopupEntity, z, str);
    }

    private final void h(HomePopupEntity homePopupEntity, String str) {
        HomePopupInfo widget;
        HomePopupInfo homePopupInfo;
        if (Intrinsics.c(str, "popup")) {
            if (homePopupEntity != null) {
                widget = homePopupEntity.getPopup();
                homePopupInfo = widget;
            }
            homePopupInfo = null;
        } else {
            if (homePopupEntity != null) {
                widget = homePopupEntity.getWidget();
                homePopupInfo = widget;
            }
            homePopupInfo = null;
        }
        if (homePopupInfo == null) {
            a.a.l(wf.a.a, "zxb_popup", e() + " --> saveDialogRecord() --> popup == null --> 保存数据异常 -- type = " + str, false, 4, (Object) null);
            return;
        }
        List<HomePopupRequestEntity> g = g(this, homePopupEntity, false, str, 2, null);
        HomePopupRequestEntity homePopupRequestEntity = null;
        for (HomePopupRequestEntity homePopupRequestEntity2 : g) {
            if (homePopupRequestEntity2 != null && homePopupRequestEntity2.getId() == homePopupInfo.getId()) {
                homePopupRequestEntity = homePopupRequestEntity2;
            }
        }
        if (homePopupRequestEntity == null) {
            g.add(new HomePopupRequestEntity(homePopupInfo.getId(), Long.valueOf(homePopupEntity != null ? homePopupEntity.getTs() : 0L), 1));
        } else {
            homePopupRequestEntity.setCount(homePopupRequestEntity.getCount() + 1);
            homePopupRequestEntity.setTs(homePopupEntity != null ? Long.valueOf(homePopupEntity.getTs()) : null);
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        bVar.b().putString(Intrinsics.c(str, "popup") ? "global_dialog_history" : "global_widget_history", o.j(g));
        bVar.b().putString("global_dialog_date", p.b(p.a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null));
        a.a.f(wf.a.a, "zxb_popup", e() + " --> saveDialogRecord() --> type = " + str + " --> 展示记录保存 --> homePopup = " + homePopupEntity, false, 4, (Object) null);
    }

    private static final e i() {
        android.support.v4.media.session.c.a(kg.c.e.a().h(e.class));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(HomePopupEntity homePopupEntity, Function1 function1, Activity activity) {
        new TaskCommonDialog().x0(homePopupEntity).w0(function1).k0(activity, "TaskCommonDialog");
    }

    @Override // wj.a
    public void a(HomePopupEntity homePopupEntity) {
        h(homePopupEntity, "widget");
    }

    @Override // wj.a
    public void b(final HomePopupEntity homePopupEntity, final Function1 function1) {
        Intrinsics.h(function1, "callback");
        final Activity b = com.blankj.utilcode.util.a.b();
        if (b != null) {
            b.runOnUiThread(new Runnable() { // from class: tj.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.j(HomePopupEntity.this, function1, b);
                }
            });
        }
    }

    @Override // wj.a
    public void onDestroy() {
        this.a = null;
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.c = null;
    }
}
