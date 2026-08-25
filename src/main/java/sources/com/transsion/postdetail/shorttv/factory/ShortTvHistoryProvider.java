package com.transsion.postdetail.shorttv.factory;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInnerPlayBean;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.Video;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvHistoryProvider implements ur.h {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // ur.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Subject subject, ShortTVItem shortTVItem, long j, Continuation continuation) {
        ShortTvHistoryProvider$saveHistory$1 shortTvHistoryProvider$saveHistory$1;
        int i;
        Video videoAddress;
        if (continuation instanceof ShortTvHistoryProvider$saveHistory$1) {
            shortTvHistoryProvider$saveHistory$1 = (ShortTvHistoryProvider$saveHistory$1) continuation;
            int i2 = shortTvHistoryProvider$saveHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTvHistoryProvider$saveHistory$1.label = i2 - Integer.MIN_VALUE;
                Object obj = shortTvHistoryProvider$saveHistory$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTvHistoryProvider$saveHistory$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String subjectId = subject.getSubjectId();
                    String str = subjectId == null ? BuildConfig.FLAVOR : subjectId;
                    String id = shortTVItem.getId();
                    String str2 = id == null ? BuildConfig.FLAVOR : id;
                    int ep2 = shortTVItem.getEp();
                    int se = shortTVItem.getSe();
                    int totalEpisode = subject.getTotalEpisode();
                    String title = subject.getTitle();
                    String description = subject.getDescription();
                    Cover cover = subject.getCover();
                    String url = cover != null ? cover.getUrl() : null;
                    Cover cover2 = subject.getCover();
                    String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
                    String videoId = shortTVItem.getVideoId();
                    Media video = shortTVItem.getVideo();
                    ShortTVPlayBean shortTVPlayBean = new ShortTVPlayBean(str, str2, ep2, se, totalEpisode, j, title, description, url, thumbnail, videoId, (video == null || (videoAddress = video.getVideoAddress()) == null) ? null : videoAddress.getUrl(), System.currentTimeMillis(), null, 8192, null);
                    AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
                    Application a = Utils.a();
                    Intrinsics.g(a, "getApp(...)");
                    ShortTVPlayDao w1 = appDatabase$f1.b(a).w1();
                    shortTvHistoryProvider$saveHistory$1.label = 1;
                    if (w1.g(shortTVPlayBean, shortTvHistoryProvider$saveHistory$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                yw.e eVar = new yw.e(true, false);
                FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = yw.e.class.getName();
                Intrinsics.g(name, "getName(...)");
                applicationScopeViewModel.postEvent(name, eVar, 0L);
                return Unit.a;
            }
        }
        shortTvHistoryProvider$saveHistory$1 = new ShortTvHistoryProvider$saveHistory$1(this, continuation);
        Object obj2 = shortTvHistoryProvider$saveHistory$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTvHistoryProvider$saveHistory$1.label;
        if (i != 0) {
        }
        yw.e eVar2 = new yw.e(true, false);
        FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = yw.e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.postEvent(name2, eVar2, 0L);
        return Unit.a;
    }

    @Override // ur.h
    public Object b(String str, String str2, Continuation continuation) {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        Object b = appDatabase$f1.b(a).w1().b(str, str2, continuation);
        return b == IntrinsicsKt.f() ? b : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // ur.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(String str, Continuation continuation) {
        ShortTvHistoryProvider$getHistory$1 shortTvHistoryProvider$getHistory$1;
        int i;
        ShortTVPlayBean shortTVPlayBean;
        if (continuation instanceof ShortTvHistoryProvider$getHistory$1) {
            shortTvHistoryProvider$getHistory$1 = (ShortTvHistoryProvider$getHistory$1) continuation;
            int i2 = shortTvHistoryProvider$getHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTvHistoryProvider$getHistory$1.label = i2 - Integer.MIN_VALUE;
                Object obj = shortTvHistoryProvider$getHistory$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTvHistoryProvider$getHistory$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
                    Application a = Utils.a();
                    Intrinsics.g(a, "getApp(...)");
                    ShortTVPlayDao w1 = appDatabase$f1.b(a).w1();
                    shortTvHistoryProvider$getHistory$1.label = 1;
                    obj = w1.e(str, shortTvHistoryProvider$getHistory$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                shortTVPlayBean = (ShortTVPlayBean) obj;
                if (shortTVPlayBean != null) {
                    return null;
                }
                return new ShortTvInnerPlayBean(shortTVPlayBean.getSubjectId(), shortTVPlayBean.getId(), shortTVPlayBean.getEp(), shortTVPlayBean.getSe(), shortTVPlayBean.getTotalEp(), shortTVPlayBean.getProgress(), shortTVPlayBean.getTitle(), shortTVPlayBean.getDescription(), shortTVPlayBean.getCoverUrl(), shortTVPlayBean.getThumbnail(), shortTVPlayBean.getVideoId(), shortTVPlayBean.getVideoUrl(), shortTVPlayBean.getTimeStamp(), shortTVPlayBean.getSubtitleSelectId());
            }
        }
        shortTvHistoryProvider$getHistory$1 = new ShortTvHistoryProvider$getHistory$1(this, continuation);
        Object obj2 = shortTvHistoryProvider$getHistory$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTvHistoryProvider$getHistory$1.label;
        if (i != 0) {
        }
        shortTVPlayBean = (ShortTVPlayBean) obj2;
        if (shortTVPlayBean != null) {
        }
    }
}
