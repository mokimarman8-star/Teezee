package com.transsion.mbwidget.data;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import com.transsion.mbwidget.PlayWidgetProvider;
import com.transsion.mbwidget.R$string;
import com.transsion.mbwidget.data.a;
import com.transsion.mbwidget.utils.BitmapUtils;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WidgetDataManager {
    private static volatile long b;
    private static VideoDetailPlayBean f;
    private static String i;
    public static final WidgetDataManager a = new WidgetDataManager();
    private static long c = 3540000;
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.k
        public final Object invoke() {
            a x;
            x = WidgetDataManager.x();
            return x;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.l
        public final Object invoke() {
            VideoDetailPlayDao C;
            C = WidgetDataManager.C();
            return C;
        }
    });
    private static final CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private static final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    private static volatile CopyOnWriteArrayList j = new CopyOnWriteArrayList();

    private WidgetDataManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:76|77))(7:78|79|(1:81)(1:90)|82|(1:84)(1:89)|85|(1:87)(1:88))|13|(9:17|(7:20|(1:37)(1:24)|25|(1:36)(1:29)|(3:31|32|33)(1:35)|34|18)|38|39|(7:42|(1:59)(1:46)|47|(1:58)(1:51)|(3:53|54|55)(1:57)|56|40)|60|61|(1:66)|67)|68|69|(1:71)|72|73))|93|6|7|8|(0)(0)|13|(10:15|17|(1:18)|38|39|(1:40)|60|61|(2:63|66)|67)|68|69|(0)|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0032, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x016e, code lost:
    
        r0 = kotlin.Result.Companion;
        r11 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r11));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0077, B:15:0x0085, B:17:0x008d, B:18:0x009e, B:20:0x00a4, B:22:0x00b1, B:24:0x00b7, B:25:0x00bd, B:27:0x00c3, B:29:0x00c9, B:32:0x00d1, B:39:0x00d5, B:40:0x00e9, B:42:0x00ef, B:44:0x00fc, B:46:0x0102, B:47:0x0108, B:49:0x010e, B:51:0x0114, B:54:0x011c, B:61:0x0120, B:63:0x0129, B:66:0x0130, B:67:0x0136, B:68:0x0167, B:79:0x0040, B:82:0x004f, B:85:0x005c), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0077, B:15:0x0085, B:17:0x008d, B:18:0x009e, B:20:0x00a4, B:22:0x00b1, B:24:0x00b7, B:25:0x00bd, B:27:0x00c3, B:29:0x00c9, B:32:0x00d1, B:39:0x00d5, B:40:0x00e9, B:42:0x00ef, B:44:0x00fc, B:46:0x0102, B:47:0x0108, B:49:0x010e, B:51:0x0114, B:54:0x011c, B:61:0x0120, B:63:0x0129, B:66:0x0130, B:67:0x0136, B:68:0x0167, B:79:0x0040, B:82:0x004f, B:85:0x005c), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(Continuation continuation) {
        WidgetDataManager$requestData$1 widgetDataManager$requestData$1;
        int i2;
        Throwable th2;
        WidgetDataManager widgetDataManager;
        BaseDto baseDto;
        DeskWidgetResp deskWidgetResp;
        String searchBarText;
        Integer height;
        Integer width;
        Integer height2;
        Integer width2;
        if (continuation instanceof WidgetDataManager$requestData$1) {
            widgetDataManager$requestData$1 = (WidgetDataManager$requestData$1) continuation;
            int i3 = widgetDataManager$requestData$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                widgetDataManager$requestData$1.label = i3 - Integer.MIN_VALUE;
                WidgetDataManager$requestData$1 widgetDataManager$requestData$12 = widgetDataManager$requestData$1;
                Object obj = widgetDataManager$requestData$12.result;
                Object f2 = IntrinsicsKt.f();
                i2 = widgetDataManager$requestData$12.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    Result.Companion companion = Result.Companion;
                    int i4 = g.size() < 2 ? 8 : 0;
                    int i5 = h.size() < 3 ? 16 : 0;
                    a l = l();
                    WidgetRequestBody widgetRequestBody = new WidgetRequestBody(i4, i5);
                    widgetDataManager$requestData$12.L$0 = this;
                    widgetDataManager$requestData$12.label = 1;
                    obj = a.C0037a.b(l, widgetRequestBody, null, widgetDataManager$requestData$12, 2, null);
                    if (obj == f2) {
                        return f2;
                    }
                    widgetDataManager = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    widgetDataManager = (WidgetDataManager) widgetDataManager$requestData$12.L$0;
                    ResultKt.b(obj);
                }
                baseDto = (BaseDto) obj;
                if (Intrinsics.c(baseDto.getCode(), "0") && (deskWidgetResp = (DeskWidgetResp) baseDto.getData()) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = g;
                    List<Subject> hotList = deskWidgetResp.getHotList();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : hotList) {
                        Subject subject = (Subject) obj2;
                        Cover cover = subject.getCover();
                        int intValue = (cover == null || (width2 = cover.getWidth()) == null) ? 0 : width2.intValue();
                        Cover cover2 = subject.getCover();
                        if (intValue <= ((cover2 == null || (height2 = cover2.getHeight()) == null) ? 0 : height2.intValue())) {
                            arrayList.add(obj2);
                        }
                    }
                    copyOnWriteArrayList.addAll(arrayList);
                    CopyOnWriteArrayList copyOnWriteArrayList2 = h;
                    List<Subject> interestList = deskWidgetResp.getInterestList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : interestList) {
                        Subject subject2 = (Subject) obj3;
                        Cover cover3 = subject2.getCover();
                        int intValue2 = (cover3 == null || (width = cover3.getWidth()) == null) ? 0 : width.intValue();
                        Cover cover4 = subject2.getCover();
                        if (intValue2 <= ((cover4 == null || (height = cover4.getHeight()) == null) ? 0 : height.intValue())) {
                            arrayList2.add(obj3);
                        }
                    }
                    copyOnWriteArrayList2.addAll(arrayList2);
                    searchBarText = deskWidgetResp.getSearchBarText();
                    if (searchBarText != null && searchBarText.length() != 0) {
                        i = deskWidgetResp.getSearchBarText();
                    }
                    wf.a.a.c("DeskWidget_", "RequestList: hot:" + deskWidgetResp.getHotList().size() + ", in:" + deskWidgetResp.getInterestList().size(), true);
                    widgetDataManager.B(deskWidgetResp);
                }
                Object obj4 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj4);
                if (th2 != null) {
                    wf.a.a.c("DeskWidget_", "requestData -onFailure: " + th2, true);
                }
                f();
                return Unit.a;
            }
        }
        widgetDataManager$requestData$1 = new WidgetDataManager$requestData$1(this, continuation);
        WidgetDataManager$requestData$1 widgetDataManager$requestData$122 = widgetDataManager$requestData$1;
        Object obj5 = widgetDataManager$requestData$122.result;
        Object f22 = IntrinsicsKt.f();
        i2 = widgetDataManager$requestData$122.label;
        if (i2 != 0) {
        }
        baseDto = (BaseDto) obj5;
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            CopyOnWriteArrayList copyOnWriteArrayList3 = g;
            List<Subject> hotList2 = deskWidgetResp.getHotList();
            ArrayList arrayList3 = new ArrayList();
            while (r2.hasNext()) {
            }
            copyOnWriteArrayList3.addAll(arrayList3);
            CopyOnWriteArrayList copyOnWriteArrayList22 = h;
            List<Subject> interestList2 = deskWidgetResp.getInterestList();
            ArrayList arrayList22 = new ArrayList();
            while (r2.hasNext()) {
            }
            copyOnWriteArrayList22.addAll(arrayList22);
            searchBarText = deskWidgetResp.getSearchBarText();
            if (searchBarText != null) {
                i = deskWidgetResp.getSearchBarText();
            }
            wf.a.a.c("DeskWidget_", "RequestList: hot:" + deskWidgetResp.getHotList().size() + ", in:" + deskWidgetResp.getInterestList().size(), true);
            widgetDataManager.B(deskWidgetResp);
        }
        Object obj42 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj42);
        if (th2 != null) {
        }
        f();
        return Unit.a;
    }

    private final void B(DeskWidgetResp deskWidgetResp) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new WidgetDataManager$saveToCache$1(deskWidgetResp, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao C() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).C1();
    }

    private final void f() {
        DeskWidgetResp i2;
        CopyOnWriteArrayList copyOnWriteArrayList = h;
        if ((copyOnWriteArrayList.isEmpty() || g.isEmpty()) && (i2 = i()) != null) {
            if (copyOnWriteArrayList.isEmpty() && !i2.getInterestList().isEmpty()) {
                copyOnWriteArrayList.addAll(i2.getInterestList());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = g;
            if (!copyOnWriteArrayList2.isEmpty() || i2.getHotList().isEmpty()) {
                return;
            }
            copyOnWriteArrayList2.addAll(i2.getHotList());
        }
    }

    private final Object g(List list, Continuation continuation) {
        Object A;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            g.remove(bVar.b());
            h.remove(bVar.b());
        }
        return ((g.isEmpty() || h.isEmpty()) && (A = A(continuation)) == IntrinsicsKt.f()) ? A : Unit.a;
    }

    private final DeskWidgetResp i() {
        String string = com.transsion.mbwidget.d.a.k().getString("hot_widget_cache_key", (String) null);
        wf.a.a.c("DeskWidget_", "widget load cache:" + (string == null), true);
        try {
            Result.Companion companion = Result.Companion;
            return (DeskWidgetResp) o.d(string, DeskWidgetResp.class);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
            return null;
        }
    }

    private final a l() {
        return (a) d.getValue();
    }

    private final PendingIntent n(Context context, boolean z, String str, Integer num, String str2, String str3, String str4) {
        Intent intent = new Intent(context, (Class<?>) (z ? HotSubjectWidgetProvider.class : PlayWidgetProvider.class));
        int i2 = Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
        intent.putExtra("appWidgetId", num);
        intent.putExtra("key_deeplink_widget", str);
        intent.putExtra("key_subject_id_widget", str2);
        intent.putExtra("key_module_name", str3);
        if (str4 == null) {
            str4 = z ? "com.transsion.mbwidget.hot.ACTION_CLICK" : "com.transsion.mbwidget.play.ACTION_CLICK";
        }
        intent.setAction(str4);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, i2);
        Intrinsics.g(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    static /* synthetic */ PendingIntent o(WidgetDataManager widgetDataManager, Context context, boolean z, String str, Integer num, String str2, String str3, String str4, int i2, Object obj) {
        return widgetDataManager.n(context, z, str, num, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4);
    }

    private final Subject r(int i2, HashSet hashSet) {
        List m = j.a.m();
        Collections.shuffle(m);
        if (i2 == 0) {
            return z(h, m, hashSet);
        }
        if (i2 == 1) {
            return z(g, m, hashSet);
        }
        if (i2 != 2) {
            return null;
        }
        return z(h, m, hashSet);
    }

    private final VideoDetailPlayDao w() {
        return (VideoDetailPlayDao) e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a x() {
        return (a) kg.c.e.a().h(a.class);
    }

    private final Subject z(List list, List list2, Set set) {
        Object obj;
        Object obj2;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (set.add(((Subject) obj2).getSubjectId())) {
                break;
            }
        }
        Subject subject = (Subject) obj2;
        if (subject != null) {
            return subject;
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (set.add(((Subject) next).getSubjectId())) {
                obj = next;
                break;
            }
        }
        return (Subject) obj;
    }

    public final Subject h(String str) {
        Object obj;
        if (str == null) {
            return null;
        }
        Iterator it = j.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((b) obj).b().getSubjectId(), str)) {
                break;
            }
        }
        b bVar = (b) obj;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public final VideoDetailPlayBean j() {
        String str;
        Subject subject = (Subject) CollectionsKt.v0(g);
        if (subject == null) {
            subject = (Subject) CollectionsKt.u0(j.a.m());
        }
        String subjectId = subject.getSubjectId();
        String str2 = subjectId == null ? BuildConfig.FLAVOR : subjectId;
        String subjectId2 = subject.getSubjectId();
        String str3 = subjectId2 == null ? BuildConfig.FLAVOR : subjectId2;
        String title = subject.getTitle();
        Cover cover = subject.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        return new VideoDetailPlayBean(str2, str3, 0, 0, 0L, title, str, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217628, null);
    }

    public final Object k(String str, int i2, Continuation continuation) {
        Integer n = j.a.n(str);
        if (n != null) {
            return BitmapUtils.a.b(n.intValue());
        }
        BitmapUtils bitmapUtils = BitmapUtils.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return bitmapUtils.d(a2, str, i2, continuation);
    }

    public final PendingIntent m(Context context, boolean z, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z, "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&channel=desk_widget", num, null, "root", null, 80, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Continuation continuation) {
        WidgetDataManager$getPlayHistory$1 widgetDataManager$getPlayHistory$1;
        int i2;
        List list;
        if (continuation instanceof WidgetDataManager$getPlayHistory$1) {
            widgetDataManager$getPlayHistory$1 = (WidgetDataManager$getPlayHistory$1) continuation;
            int i3 = widgetDataManager$getPlayHistory$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                widgetDataManager$getPlayHistory$1.label = i3 - Integer.MIN_VALUE;
                Object obj = widgetDataManager$getPlayHistory$1.result;
                Object f2 = IntrinsicsKt.f();
                i2 = widgetDataManager$getPlayHistory$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    if (f != null && !y()) {
                        return f;
                    }
                    VideoDetailPlayDao w = w();
                    widgetDataManager$getPlayHistory$1.label = 1;
                    obj = w.d(0, 50, widgetDataManager$getPlayHistory$1);
                    if (obj == f2) {
                        return f2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                list = (List) obj;
                VideoDetailPlayBean videoDetailPlayBean = null;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) next;
                        Long totalDuration = videoDetailPlayBean2.getTotalDuration();
                        long progress = (videoDetailPlayBean2.getProgress() * 100) / (totalDuration != null ? RangesKt.f(totalDuration.longValue(), 1L) : 1L);
                        if (TextUtils.isDigitsOnly(videoDetailPlayBean2.getId()) && progress <= 80) {
                            videoDetailPlayBean = next;
                            break;
                        }
                    }
                    videoDetailPlayBean = videoDetailPlayBean;
                }
                f = videoDetailPlayBean;
                wf.a.a.i("DeskWidget_", "getPlayHistory curHistory: " + f, true);
                return f;
            }
        }
        widgetDataManager$getPlayHistory$1 = new WidgetDataManager$getPlayHistory$1(this, continuation);
        Object obj2 = widgetDataManager$getPlayHistory$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = widgetDataManager$getPlayHistory$1.label;
        if (i2 != 0) {
        }
        list = (List) obj2;
        VideoDetailPlayBean videoDetailPlayBean3 = null;
        if (list != null) {
        }
        f = videoDetailPlayBean3;
        wf.a.a.i("DeskWidget_", "getPlayHistory curHistory: " + f, true);
        return f;
    }

    public final PendingIntent q(Context context, boolean z, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z, "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&channel=desk_widget", num, "refresh_all", "refresh", null, 64, null);
    }

    public final PendingIntent s(Context context, boolean z, Integer num) {
        Intrinsics.h(context, "context");
        return o(this, context, z, "oneroom://com.community.oneroom?type=/search/activity/search_manager&type=3&channel=desk_widget", num, null, "search", null, 80, null);
    }

    public final String t() {
        String str = i;
        if (str != null) {
            return str;
        }
        String string = Utils.a().getString(R$string.widget_search_tips);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[LOOP:0: B:27:0x00db->B:29:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(String str, String str2, Continuation continuation) {
        WidgetDataManager$getShowList$1 widgetDataManager$getShowList$1;
        Object f2;
        int i2;
        boolean y;
        Object obj;
        b bVar;
        CopyOnWriteArrayList copyOnWriteArrayList;
        Iterator it;
        Subject r;
        Subject r2;
        Subject r3;
        Subject r4;
        if (continuation instanceof WidgetDataManager$getShowList$1) {
            widgetDataManager$getShowList$1 = (WidgetDataManager$getShowList$1) continuation;
            int i3 = widgetDataManager$getShowList$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                widgetDataManager$getShowList$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = widgetDataManager$getShowList$1.result;
                f2 = IntrinsicsKt.f();
                i2 = widgetDataManager$getShowList$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj2);
                    y = y();
                    wf.a.a.c("DeskWidget_", "refreshId:" + str2 + "，historyId:" + str + ", size:" + g.size() + ", in:" + h.size(), true);
                    if (str2 != null) {
                        Iterator it2 = j.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            if (Intrinsics.c(((b) obj).b().getSubjectId(), str2)) {
                                break;
                            }
                        }
                        bVar = (b) obj;
                        if (bVar != null) {
                            List e2 = CollectionsKt.e(bVar);
                            widgetDataManager$getShowList$1.L$0 = str;
                            widgetDataManager$getShowList$1.L$1 = str2;
                            widgetDataManager$getShowList$1.L$2 = bVar;
                            widgetDataManager$getShowList$1.label = 1;
                            if (g(e2, widgetDataManager$getShowList$1) == f2) {
                                return f2;
                            }
                        }
                        y = Intrinsics.c(str2, "refresh_all");
                    }
                    if (j.size() < 3 && !y) {
                        return j;
                    }
                    copyOnWriteArrayList = j;
                    widgetDataManager$getShowList$1.L$0 = str;
                    widgetDataManager$getShowList$1.L$1 = null;
                    widgetDataManager$getShowList$1.L$2 = null;
                    widgetDataManager$getShowList$1.label = 2;
                    if (g(copyOnWriteArrayList, widgetDataManager$getShowList$1) == f2) {
                        return f2;
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.add(str);
                    ArrayList arrayList = new ArrayList();
                    r2 = r(0, hashSet);
                    if (r2 != null) {
                    }
                    r3 = r(1, hashSet);
                    if (r3 != null) {
                    }
                    r4 = r(2, hashSet);
                    if (r4 != null) {
                    }
                    b = System.currentTimeMillis();
                    wf.a.a.c("DeskWidget_", "showList:" + hashSet, true);
                    j = new CopyOnWriteArrayList(arrayList);
                    return arrayList;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) widgetDataManager$getShowList$1.L$0;
                    ResultKt.b(obj2);
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(str);
                    ArrayList arrayList2 = new ArrayList();
                    r2 = r(0, hashSet2);
                    if (r2 != null) {
                        arrayList2.add(new b(0, r2));
                        Boxing.a(hashSet2.add(r2.getSubjectId()));
                    }
                    r3 = r(1, hashSet2);
                    if (r3 != null) {
                        arrayList2.add(new b(1, r3));
                        Boxing.a(hashSet2.add(r3.getSubjectId()));
                    }
                    r4 = r(2, hashSet2);
                    if (r4 != null) {
                        arrayList2.add(new b(2, r4));
                        Boxing.a(hashSet2.add(r4.getSubjectId()));
                    }
                    b = System.currentTimeMillis();
                    wf.a.a.c("DeskWidget_", "showList:" + hashSet2, true);
                    j = new CopyOnWriteArrayList(arrayList2);
                    return arrayList2;
                }
                b bVar2 = (b) widgetDataManager$getShowList$1.L$2;
                str2 = (String) widgetDataManager$getShowList$1.L$1;
                String str3 = (String) widgetDataManager$getShowList$1.L$0;
                ResultKt.b(obj2);
                bVar = bVar2;
                str = str3;
                HashSet hashSet3 = new HashSet();
                hashSet3.add(str);
                it = j.iterator();
                while (it.hasNext()) {
                    hashSet3.add(((b) it.next()).b().getSubjectId());
                }
                r = r(bVar.a(), hashSet3);
                if (r != null) {
                    List U0 = CollectionsKt.U0(j);
                    U0.set(bVar.a(), new b(bVar.a(), r));
                    j = new CopyOnWriteArrayList(U0);
                    return U0;
                }
                y = Intrinsics.c(str2, "refresh_all");
                if (j.size() < 3) {
                }
                copyOnWriteArrayList = j;
                widgetDataManager$getShowList$1.L$0 = str;
                widgetDataManager$getShowList$1.L$1 = null;
                widgetDataManager$getShowList$1.L$2 = null;
                widgetDataManager$getShowList$1.label = 2;
                if (g(copyOnWriteArrayList, widgetDataManager$getShowList$1) == f2) {
                }
                HashSet hashSet22 = new HashSet();
                hashSet22.add(str);
                ArrayList arrayList22 = new ArrayList();
                r2 = r(0, hashSet22);
                if (r2 != null) {
                }
                r3 = r(1, hashSet22);
                if (r3 != null) {
                }
                r4 = r(2, hashSet22);
                if (r4 != null) {
                }
                b = System.currentTimeMillis();
                wf.a.a.c("DeskWidget_", "showList:" + hashSet22, true);
                j = new CopyOnWriteArrayList(arrayList22);
                return arrayList22;
            }
        }
        widgetDataManager$getShowList$1 = new WidgetDataManager$getShowList$1(this, continuation);
        Object obj22 = widgetDataManager$getShowList$1.result;
        f2 = IntrinsicsKt.f();
        i2 = widgetDataManager$getShowList$1.label;
        if (i2 != 0) {
        }
        HashSet hashSet32 = new HashSet();
        hashSet32.add(str);
        it = j.iterator();
        while (it.hasNext()) {
        }
        r = r(bVar.a(), hashSet32);
        if (r != null) {
        }
        y = Intrinsics.c(str2, "refresh_all");
        if (j.size() < 3) {
        }
        copyOnWriteArrayList = j;
        widgetDataManager$getShowList$1.L$0 = str;
        widgetDataManager$getShowList$1.L$1 = null;
        widgetDataManager$getShowList$1.L$2 = null;
        widgetDataManager$getShowList$1.label = 2;
        if (g(copyOnWriteArrayList, widgetDataManager$getShowList$1) == f2) {
        }
        HashSet hashSet222 = new HashSet();
        hashSet222.add(str);
        ArrayList arrayList222 = new ArrayList();
        r2 = r(0, hashSet222);
        if (r2 != null) {
        }
        r3 = r(1, hashSet222);
        if (r3 != null) {
        }
        r4 = r(2, hashSet222);
        if (r4 != null) {
        }
        b = System.currentTimeMillis();
        wf.a.a.c("DeskWidget_", "showList:" + hashSet222, true);
        j = new CopyOnWriteArrayList(arrayList222);
        return arrayList222;
    }

    public final PendingIntent v(Context context, boolean z, Integer num, String str) {
        Intrinsics.h(context, "context");
        return o(this, context, z, "oneroom://com.community.oneroom?type=/movie/detail&channel=desk_widget&id=" + str + "&ops=%7B%22trace_id%22%3A%226516b509cfdb36d11f9026a5b2981871%22%7D", num, str, "subject", null, 64, null);
    }

    public final boolean y() {
        return System.currentTimeMillis() - b > c;
    }
}
