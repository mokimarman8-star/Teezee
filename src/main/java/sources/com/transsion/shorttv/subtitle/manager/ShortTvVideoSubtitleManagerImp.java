package com.transsion.shorttv.subtitle.manager;

import com.transsion.shorttv.utils.h;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.bean.SubtitleAppType;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvVideoSubtitleManagerImp implements b {
    public static final a g = new a(null);
    private Set b = new CopyOnWriteArraySet();
    private final String c = ShortTvVideoSubtitleManagerImp.class.getSimpleName();
    private final n0 d = o0.a(y0.c());
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.d
        public final Object invoke() {
            ur.d r;
            r = ShortTvVideoSubtitleManagerImp.r();
            return r;
        }
    });
    private final ShortTvVideoSubtitleManagerImp$resDownloadListener$1 f = new ShortTvVideoSubtitleManagerImp$resDownloadListener$1(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void m(xr.a aVar, final Function1 function1) {
        String d = aVar.d();
        if (d == null || d.length() == 0) {
            a.a.f(wf.a.a, "short_tv_subtitle", this.c + " checkDownloadSubtitle fail， has no shorTvId", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (StringsKt.x(aVar.d()) == null) {
            a.a.x(wf.a.a, "short_tv_subtitle", this.c + " checkDownloadSubtitle ,shorTvId is abnormal", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!l.a.e()) {
            wf.a.a.w("short_tv_subtitle", this.c + " checkDownloadSubtitle ,无网络不做检测", true);
            return;
        }
        wf.a.a.c("short_tv_subtitle", this.c + " checkDownloadSubtitle, name = " + aVar.h() + " subjectId:" + aVar.e() + " subtitleResId:" + aVar.g(), true);
        SubtitleDownloadManager.a.e(aVar.e(), aVar.g(), (String) null, aVar.d(), aVar.f(), 3, 0, aVar.a(), aVar.c(), aVar.b(), new Function1() { // from class: com.transsion.shorttv.subtitle.manager.e
            public final Object invoke(Object obj) {
                Unit o;
                o = ShortTvVideoSubtitleManagerImp.o(ShortTvVideoSubtitleManagerImp.this, function1, ((Boolean) obj).booleanValue());
                return o;
            }
        });
    }

    static /* synthetic */ void n(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, xr.a aVar, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        shortTvVideoSubtitleManagerImp.m(aVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, Function1 function1, boolean z) {
        i.d(shortTvVideoSubtitleManagerImp.d, (CoroutineContext) null, (CoroutineStart) null, new ShortTvVideoSubtitleManagerImp$checkDownloadSubtitle$1$1(function1, z, shortTvVideoSubtitleManagerImp, null), 3, (Object) null);
        return Unit.a;
    }

    private final ur.d p() {
        return (ur.d) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q() {
        return h.a.e().getString("k_language_short_name", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ur.d r() {
        vr.a c = pq.c.a.c();
        if (c != null) {
            return c.b();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.shorttv.subtitle.manager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Continuation continuation) {
        ShortTvVideoSubtitleManagerImp$getSubtitleList$1 shortTvVideoSubtitleManagerImp$getSubtitleList$1;
        int i;
        List list;
        List list2;
        if (continuation instanceof ShortTvVideoSubtitleManagerImp$getSubtitleList$1) {
            shortTvVideoSubtitleManagerImp$getSubtitleList$1 = (ShortTvVideoSubtitleManagerImp$getSubtitleList$1) continuation;
            int i2 = shortTvVideoSubtitleManagerImp$getSubtitleList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTvVideoSubtitleManagerImp$getSubtitleList$1.label = i2 - Integer.MIN_VALUE;
                Object obj = shortTvVideoSubtitleManagerImp$getSubtitleList$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTvVideoSubtitleManagerImp$getSubtitleList$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    ArrayList arrayList = new ArrayList();
                    SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.a;
                    shortTvVideoSubtitleManagerImp$getSubtitleList$1.L$0 = arrayList;
                    shortTvVideoSubtitleManagerImp$getSubtitleList$1.label = 1;
                    Object j = subtitleDownloadManager.j(str, shortTvVideoSubtitleManagerImp$getSubtitleList$1);
                    if (j == f) {
                        return f;
                    }
                    obj = j;
                    list = arrayList;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) shortTvVideoSubtitleManagerImp$getSubtitleList$1.L$0;
                    ResultKt.b(obj);
                }
                list2 = (List) obj;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        list.add(new xr.b((SubtitleDownloadTable) it.next()));
                    }
                }
                return list;
            }
        }
        shortTvVideoSubtitleManagerImp$getSubtitleList$1 = new ShortTvVideoSubtitleManagerImp$getSubtitleList$1(this, continuation);
        Object obj2 = shortTvVideoSubtitleManagerImp$getSubtitleList$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTvVideoSubtitleManagerImp$getSubtitleList$1.label;
        if (i != 0) {
        }
        list2 = (List) obj2;
        if (list2 != null) {
        }
        return list;
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void b(com.transsion.subtitle_download.a aVar) {
        Intrinsics.h(aVar, "listener");
        SubtitleDownloadManager.a.b(aVar);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void c(com.transsion.subtitle_download.a aVar) {
        Intrinsics.h(aVar, "listener");
        SubtitleDownloadManager.a.s(aVar);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void d(xr.b bVar) {
        Intrinsics.h(bVar, "bean");
        SubtitleDownloadManager.a.d(bVar.a());
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void e(xr.a aVar, Function1 function1) {
        Intrinsics.h(aVar, "bean");
        m(aVar, function1);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void f(zr.a aVar) {
        Intrinsics.h(aVar, "listener");
        this.b.add(aVar);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void g(zr.a aVar) {
        Intrinsics.h(aVar, "listener");
        this.b.remove(aVar);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void init() {
        SubtitleAppType subtitleAppType = SubtitleAppType.NOVEL;
        if (!Intrinsics.c("mb", subtitleAppType.getValue())) {
            subtitleAppType = SubtitleAppType.MB;
        }
        SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.a;
        subtitleDownloadManager.k(subtitleAppType);
        subtitleDownloadManager.l(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.c
            public final Object invoke() {
                String q;
                q = ShortTvVideoSubtitleManagerImp.q();
                return q;
            }
        });
        ur.d p = p();
        if (p != null) {
            p.l(this.f);
        }
    }
}
