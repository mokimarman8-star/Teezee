package com.transsion.shorttv.subtitle;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.subtitle.manager.b;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import nr.e;
import qi.h;
import qr.k0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVSubtitleControlImp implements com.transsion.shorttv.subtitle.a, zr.a {
    private final FragmentActivity b;
    private final k0 c;
    private final ShortTvViewModel d;
    private final e e;
    private final String f;
    private final String g;
    private final as.a h;
    private Function1 i;
    private Function1 j;
    private boolean k;
    private long l;
    private float m;
    private final ShortTVSubtitleControlImp$downloadListener$1 n;

    public static final class a implements k5.a {
        a() {
        }

        public long getCurrentPosition() {
            return ShortTVSubtitleControlImp.this.l;
        }

        public Float getSpeed() {
            return Float.valueOf(ShortTVSubtitleControlImp.this.m);
        }

        public boolean isPlaying() {
            return ShortTVSubtitleControlImp.this.k;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public ShortTVSubtitleControlImp(FragmentActivity fragmentActivity, k0 k0Var, ShortTvViewModel shortTvViewModel, e eVar, String str) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(k0Var, "viewBinding");
        Intrinsics.h(eVar, "epItem");
        this.b = fragmentActivity;
        this.c = k0Var;
        this.d = shortTvViewModel;
        this.e = eVar;
        this.f = str;
        this.g = "ShortTVSubtitleCtr";
        as.a aVar = (as.a) new v0(fragmentActivity).a(as.a.class);
        this.h = aVar;
        this.k = true;
        this.m = 1.0f;
        ShortTVSubtitleControlImp$downloadListener$1 shortTVSubtitleControlImp$downloadListener$1 = new ShortTVSubtitleControlImp$downloadListener$1(this);
        this.n = shortTVSubtitleControlImp$downloadListener$1;
        aVar.b();
        aVar.e().j(fragmentActivity, new b(new Function1() { // from class: com.transsion.shorttv.subtitle.b
            public final Object invoke(Object obj) {
                Unit k;
                k = ShortTVSubtitleControlImp.k(ShortTVSubtitleControlImp.this, (xr.b) obj);
                return k;
            }
        }));
        b.a aVar2 = com.transsion.shorttv.subtitle.manager.b.a;
        aVar2.b().b(shortTVSubtitleControlImp$downloadListener$1);
        aVar2.b().f(this);
        z(k0Var.K);
    }

    private final void A(boolean z) {
        a.a.g(wf.a.a, this.g + " --> onSubtitleSwitchClick() --> turnOn = " + z + " --> 字幕开关状态变化", false, 2, (Object) null);
        if (z) {
            E();
        } else {
            x();
        }
        this.h.f().q(Boolean.valueOf(!z));
    }

    private final void B(xr.b bVar) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.e.e());
        ShortTVItem d = this.e.d();
        String str3 = BuildConfig.FLAVOR;
        if (d == null || (str = d.getId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("mini_id", str);
        ShortTVItem d2 = this.e.d();
        hashMap.put("se", String.valueOf(d2 != null ? Integer.valueOf(d2.getSe()) : null));
        hashMap.put("ep", String.valueOf(this.e.c()));
        ShortTVItem d3 = this.e.d();
        if (d3 == null || (str2 = d3.getVideoId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("video_id", str2);
        hashMap.put("opt_type", "subtitle_select");
        String ops = bVar.a().getOps();
        if (ops != null) {
            hashMap.put("ops", ops);
        }
        hashMap.put("name", bVar.a().getName());
        String lan = bVar.a().getLan();
        if (lan == null) {
            lan = BuildConfig.FLAVOR;
        }
        hashMap.put("lan", lan);
        String lanName = bVar.a().getLanName();
        if (lanName != null) {
            str3 = lanName;
        }
        hashMap.put("lan_name", str3);
        h.a.o("minitv_play", hashMap);
    }

    private final void C() {
        this.h.d().q((Object) null);
        this.h.e().q((Object) null);
        this.c.K.reset();
        a.a.g(wf.a.a, this.g + " --> reset() --> 重置资源", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(boolean z) {
    }

    private final void E() {
        this.c.K.turnOff(false);
        FrameLayout frameLayout = this.c.f;
        Intrinsics.g(frameLayout, "flSubtitle");
        cr.b.e(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ShortTVSubtitleControlImp shortTVSubtitleControlImp, xr.b bVar) {
        if (bVar == null) {
            return Unit.a;
        }
        if (bVar.c()) {
            jr.b.a.d(R.string.short_tv_subtitle_turn_off_toast);
        }
        shortTVSubtitleControlImp.A(!bVar.c());
        if (!bVar.c()) {
            shortTVSubtitleControlImp.h(bVar);
        }
        return Unit.a;
    }

    private final void x() {
        this.c.K.turnOff(true);
        FrameLayout frameLayout = this.c.f;
        Intrinsics.g(frameLayout, "flSubtitle");
        cr.b.b(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021c A[LOOP:1: B:51:0x0216->B:53:0x021c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(List list, String str) {
        Object obj;
        Locale a2 = yr.a.a();
        a.a aVar = wf.a.a;
        Object obj2 = null;
        a.a.g(aVar, this.g + " --> initDefaultSubtitle() --> cur language = " + a2.getLanguage() + " -- country = " + a2.getCountry(), false, 2, (Object) null);
        MMKV d = com.transsion.shorttv.utils.h.a.d();
        String str2 = BuildConfig.FLAVOR;
        String string = d.getString("k_subtitle_language", BuildConfig.FLAVOR);
        com.transsion.subtitle_download.utils.d.a.b().getString("k_subtitle_select_lan", BuildConfig.FLAVOR);
        if (Intrinsics.c(string, "off")) {
            Function1 function1 = this.i;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            this.h.f().q(Boolean.TRUE);
            this.h.g("OFF");
            return;
        }
        a.a.g(aVar, this.g + " --> initDefaultSubtitle() --> savedDiffId = " + str + " -- savedLan = " + string + ", subListSize:" + list.size(), false, 2, (Object) null);
        Iterator it = list.iterator();
        xr.b bVar = null;
        xr.b bVar2 = null;
        xr.b bVar3 = null;
        xr.b bVar4 = null;
        while (it.hasNext()) {
            xr.b bVar5 = (xr.b) it.next();
            if (bVar == null && string != null && string.length() != 0 && Intrinsics.c(bVar5.a().getLanName(), string)) {
                bVar = bVar5;
            }
            if (bVar2 == null && Intrinsics.c(bVar5.a().getLanAbbr(), a2.getLanguage())) {
                bVar2 = bVar5;
            }
            if (bVar5.b()) {
                if (Intrinsics.c(bVar5.a().getLan(), "en")) {
                    bVar3 = bVar5;
                }
                if (Intrinsics.c(bVar5.a().getId(), str)) {
                    str2 = bVar5.a().getId();
                    a.a.g(wf.a.a, this.g + " --> initDefaultSubtitle() --> 使用之前选择的字幕 saved flag = " + str2, false, 2, (Object) null);
                    bVar4 = bVar5;
                }
            }
        }
        if (str2.length() == 0) {
            if (bVar != null) {
                str2 = bVar.a().getId();
                a.a.g(wf.a.a, this.g + " --> initDefaultSubtitle() --> 使用之前选择的语言 local set savedLan = " + string, false, 2, (Object) null);
            } else if (bVar2 != null) {
                str2 = bVar2.a().getId();
                a.a.g(wf.a.a, this.g + " --> initDefaultSubtitle() --> 没有自己选择的默认语言，使用手机语言 -- phone set def language = " + str2, false, 2, (Object) null);
                bVar = bVar2;
            }
            if (str2.length() == 0) {
                if (bVar3 != null && bVar3.b()) {
                    String id = bVar3.a().getId();
                    a.a.g(wf.a.a, this.g + " --> initDefaultSubtitle() --> 没有设置默认语言 --> english set def language = " + id, false, 2, (Object) null);
                } else if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            bVar3 = bVar;
                            break;
                        }
                        xr.b bVar6 = (xr.b) it2.next();
                        if (bVar6.b()) {
                            str2 = bVar6.a().getId();
                            bVar3 = bVar6;
                            break;
                        }
                    }
                    if (str2.length() == 0) {
                        a.a.g(wf.a.a, this.g + " --> initDefaultSubtitle() --> 可能外部只读取到了数据库前面没下载的字幕 --> 没有对应的语言，不设置，需要用户手动设置或当前下载后自动设置上", false, 2, (Object) null);
                        return;
                    }
                }
                List<xr.b> list2 = list;
                for (xr.b bVar7 : list2) {
                    this.c.K.setSubtitlePath(bVar7.a().getPath(), yr.a.b(bVar7));
                }
                if (bVar3 != null || bVar3.b()) {
                    h(bVar3);
                    if (bVar3 != null) {
                        bVar3.f(true);
                    }
                    this.h.f().q(Boolean.FALSE);
                    if (bVar3 != null) {
                        this.h.g(bVar3.a().getId());
                        return;
                    } else {
                        this.h.g("OFF");
                        return;
                    }
                }
                bVar3.a().setAutoDownload(false);
                bVar3.a().setSetImmediately(true);
                com.transsion.shorttv.subtitle.manager.b.a.b().d(bVar3);
                Iterator it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it3.next();
                    xr.b bVar8 = (xr.b) obj;
                    if (bVar8.b() && Intrinsics.c(bVar8.a().getLan(), "en")) {
                        break;
                    }
                }
                xr.b bVar9 = (xr.b) obj;
                if (bVar9 == null) {
                    Iterator it4 = list2.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        Object next = it4.next();
                        if (((xr.b) next).b()) {
                            obj2 = next;
                            break;
                        }
                    }
                    bVar9 = (xr.b) obj2;
                }
                if (bVar9 != null) {
                    h(bVar9);
                    bVar9.f(true);
                    this.h.f().q(Boolean.FALSE);
                    if (bVar9.a().getId().length() > 0) {
                        this.h.g(bVar9.a().getId());
                        return;
                    }
                    return;
                }
                return;
            }
            bVar3 = bVar;
            List<xr.b> list22 = list;
            while (r2.hasNext()) {
            }
            if (bVar3 != null) {
            }
            h(bVar3);
            if (bVar3 != null) {
            }
            this.h.f().q(Boolean.FALSE);
            if (bVar3 != null) {
            }
        }
        bVar = bVar4;
        if (str2.length() == 0) {
        }
        bVar3 = bVar;
        List<xr.b> list222 = list;
        while (r2.hasNext()) {
        }
        if (bVar3 != null) {
        }
        h(bVar3);
        if (bVar3 != null) {
        }
        this.h.f().q(Boolean.FALSE);
        if (bVar3 != null) {
        }
    }

    private final void z(SimpleSubtitleView simpleSubtitleView) {
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgColor(Utils.a().getResources().getColor(R.color.short_tv_black_80));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgdRadius(cr.a.a(8));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.initSubtitle(new a(), false);
            return;
        }
        a.a.g(wf.a.a, this.g + " --> vdSubtitle --> initSubtitle() --> null", false, 2, (Object) null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void a(Function1 function1) {
        this.i = function1;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void b(Function1 function1) {
        this.j = function1;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void c(boolean z) {
        this.k = z;
        if (z) {
            this.c.K.resume();
        } else {
            this.c.K.pause();
        }
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void d(long j) {
        this.l = j;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void e() {
        i.d(v.a(this.b), (CoroutineContext) null, (CoroutineStart) null, new ShortTVSubtitleControlImp$checkSubtitle$1(this, null), 3, (Object) null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void f() {
        x();
        List list = (List) this.h.d().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((xr.b) it.next()).f(false);
            }
        }
        this.h.f().q(Boolean.TRUE);
        com.transsion.shorttv.utils.h.a.d().putString("k_subtitle_language", "off");
        com.transsion.subtitle_download.utils.d.a.b().putString("k_subtitle_select_lan", "off");
        if (pq.a.a.c()) {
            return;
        }
        jr.b.a.e(Utils.a().getString(R.string.short_tv_subtitles_off));
    }

    @Override // zr.a
    public void g(boolean z) {
        a.a.g(wf.a.a, this.g + " --> checkResult --> " + z, false, 2, (Object) null);
        Function1 function1 = this.i;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void h(xr.b bVar) {
        SubtitleDownloadTable a2;
        SubtitleDownloadTable a3;
        Long delay;
        SubtitleDownloadTable a4;
        SubtitleDownloadTable a5;
        SubtitleDownloadTable a6;
        SubtitleDownloadTable a7;
        String path;
        SubtitleDownloadTable a8;
        List<xr.b> list = (List) this.h.d().f();
        if (list != null) {
            for (xr.b bVar2 : list) {
                bVar2.f(Intrinsics.c(bVar2.a().getId(), (bVar == null || (a8 = bVar.a()) == null) ? null : a8.getId()));
            }
        }
        Function1 function1 = this.j;
        if (function1 != null) {
            function1.invoke(bVar);
        }
        if (bVar != null && (a7 = bVar.a()) != null && (path = a7.getPath()) != null) {
            E();
            this.c.K.selectSubtitle(path, yr.a.b(bVar), new k5.b() { // from class: com.transsion.shorttv.subtitle.c
                public final void a(boolean z) {
                    ShortTVSubtitleControlImp.D(z);
                }
            });
        }
        wf.a.a.c("short_tv_subtitle", "selectSubtitle delayDuration:" + ((bVar == null || (a6 = bVar.a()) == null) ? null : a6.getDelay()) + ", name:" + ((bVar == null || (a5 = bVar.a()) == null) ? null : a5.getLanName()) + ", isAutoDownload:" + ((bVar == null || (a4 = bVar.a()) == null) ? null : Boolean.valueOf(a4.isAutoDownload())), true);
        if (bVar != null && (a3 = bVar.a()) != null && (delay = a3.getDelay()) != null) {
            this.c.K.subtitleDelay(delay.longValue());
        }
        if (bVar != null && (a2 = bVar.a()) != null) {
            if (!a2.isAutoDownload()) {
                com.transsion.shorttv.utils.h.a.d().putString("k_subtitle_language", a2.getLanName());
                com.transsion.subtitle_download.utils.d.a.b().putString("k_subtitle_select_lan", a2.getLan());
            }
            if (!pq.a.a.c()) {
                jr.b.a.e(Utils.a().getString(R.string.short_tv_subtitle_enable_toast, a2.getName()));
            }
        }
        if (bVar != null) {
            B(bVar);
        }
        i.d(v.a(this.b), (CoroutineContext) null, (CoroutineStart) null, new ShortTVSubtitleControlImp$selectSubtitle$6(bVar, this, null), 3, (Object) null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void onDestroy() {
        C();
        FrameLayout frameLayout = this.c.f;
        Intrinsics.g(frameLayout, "flSubtitle");
        cr.b.b(frameLayout);
        this.c.K.stop();
        this.c.K.destroy();
        b.a aVar = com.transsion.shorttv.subtitle.manager.b.a;
        aVar.b().g(this);
        aVar.b().c(this.n);
        a.a.g(wf.a.a, this.g + " --> onDestroy()", false, 2, (Object) null);
    }
}
