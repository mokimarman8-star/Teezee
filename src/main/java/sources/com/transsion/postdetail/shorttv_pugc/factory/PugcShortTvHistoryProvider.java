package com.transsion.postdetail.shorttv_pugc.factory;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.bean.Cover;
import com.transsion.shorttv_pugc.bean.ShortTvInnerPlayBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import ij.o;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PugcShortTvHistoryProvider implements vs.f {
    public Object a(String str, List list, Continuation continuation) {
        if (list.isEmpty()) {
            return Unit.a;
        }
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        Object a2 = appDatabase$f1.b(a).A1().a(str, list, continuation);
        return a2 == IntrinsicsKt.f() ? a2 : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(ShorttvModel.UGCVideo uGCVideo, long j, Continuation continuation) {
        PugcShortTvHistoryProvider$saveHistory$1 pugcShortTvHistoryProvider$saveHistory$1;
        Object obj;
        int i;
        String str;
        String str2;
        long j2;
        ShorttvModel.UGCVideo uGCVideo2;
        if (continuation instanceof PugcShortTvHistoryProvider$saveHistory$1) {
            pugcShortTvHistoryProvider$saveHistory$1 = (PugcShortTvHistoryProvider$saveHistory$1) continuation;
            int i2 = pugcShortTvHistoryProvider$saveHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pugcShortTvHistoryProvider$saveHistory$1.label = i2 - Integer.MIN_VALUE;
                PugcShortTvHistoryProvider$saveHistory$1 pugcShortTvHistoryProvider$saveHistory$12 = pugcShortTvHistoryProvider$saveHistory$1;
                obj = pugcShortTvHistoryProvider$saveHistory$12.result;
                Object f = IntrinsicsKt.f();
                i = pugcShortTvHistoryProvider$saveHistory$12.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String ugcVideoId = uGCVideo.getUgcVideoId();
                    ShorttvModel.UGCVideoCollection belongToCollection = uGCVideo.getBelongToCollection();
                    String collectionId = belongToCollection != null ? belongToCollection.getCollectionId() : null;
                    if (ugcVideoId == null || ugcVideoId.length() == 0 || collectionId == null || collectionId.length() == 0) {
                        return Unit.a;
                    }
                    AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
                    Application a = Utils.a();
                    Intrinsics.g(a, "getApp(...)");
                    UGCVideoDetailPlayDao B1 = appDatabase$f1.b(a).B1();
                    pugcShortTvHistoryProvider$saveHistory$12.L$0 = uGCVideo;
                    pugcShortTvHistoryProvider$saveHistory$12.L$1 = ugcVideoId;
                    pugcShortTvHistoryProvider$saveHistory$12.L$2 = collectionId;
                    pugcShortTvHistoryProvider$saveHistory$12.J$0 = j;
                    pugcShortTvHistoryProvider$saveHistory$12.label = 1;
                    Object c = B1.c(collectionId, pugcShortTvHistoryProvider$saveHistory$12);
                    if (c == f) {
                        return f;
                    }
                    str = ugcVideoId;
                    str2 = collectionId;
                    obj = c;
                    j2 = j;
                    uGCVideo2 = uGCVideo;
                } else {
                    if (i != 1) {
                        if (i != 2 && i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        yw.e eVar = new yw.e(true, false);
                        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                        String name = yw.e.class.getName();
                        Intrinsics.g(name, "getName(...)");
                        applicationScopeViewModel.postEvent(name, eVar, 0L);
                        return Unit.a;
                    }
                    long j3 = pugcShortTvHistoryProvider$saveHistory$12.J$0;
                    String str3 = (String) pugcShortTvHistoryProvider$saveHistory$12.L$2;
                    String str4 = (String) pugcShortTvHistoryProvider$saveHistory$12.L$1;
                    uGCVideo2 = (ShorttvModel.UGCVideo) pugcShortTvHistoryProvider$saveHistory$12.L$0;
                    ResultKt.b(obj);
                    str2 = str3;
                    j2 = j3;
                    str = str4;
                }
                if (((UGCVideoDetailPlayBean) obj) != null) {
                    long durationMillis = uGCVideo2.getDurationMillis();
                    String title = uGCVideo2.getTitle();
                    long currentTimeMillis = System.currentTimeMillis();
                    Cover cover = uGCVideo2.getCover();
                    String url = cover != null ? cover.getUrl() : null;
                    Cover cover2 = uGCVideo2.getCover();
                    String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
                    UGCVideoDetailPlayBean uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(str2, str, j2, title, url, thumbnail, uGCVideo2.getEp(), uGCVideo2.getCategory(), null, null, null, null, currentTimeMillis, null, Boxing.e(durationMillis), null, null, null, false, PlayMode.STREAM.getValue(), null, null, null, 0L, null, null, false, false, false, uGCVideo2.getOps(), null, null, null, null, null, o.a.d(), -537415936, 7, null);
                    AppDatabase$f1 appDatabase$f12 = AppDatabase.p;
                    Application a2 = Utils.a();
                    Intrinsics.g(a2, "getApp(...)");
                    UGCVideoDetailPlayDao B12 = appDatabase$f12.b(a2).B1();
                    pugcShortTvHistoryProvider$saveHistory$12.L$0 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.L$1 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.L$2 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.label = 2;
                    if (B12.n(uGCVideoDetailPlayBean, pugcShortTvHistoryProvider$saveHistory$12) == f) {
                        return f;
                    }
                } else {
                    AppDatabase$f1 appDatabase$f13 = AppDatabase.p;
                    Application a3 = Utils.a();
                    Intrinsics.g(a3, "getApp(...)");
                    UGCVideoDetailPlayDao B13 = appDatabase$f13.b(a3).B1();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    int ep2 = uGCVideo2.getEp();
                    pugcShortTvHistoryProvider$saveHistory$12.L$0 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.L$1 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.L$2 = null;
                    pugcShortTvHistoryProvider$saveHistory$12.label = 3;
                    if (B13.e(str2, str, currentTimeMillis2, j2, ep2, pugcShortTvHistoryProvider$saveHistory$12) == f) {
                        return f;
                    }
                }
                yw.e eVar2 = new yw.e(true, false);
                FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = yw.e.class.getName();
                Intrinsics.g(name2, "getName(...)");
                applicationScopeViewModel2.postEvent(name2, eVar2, 0L);
                return Unit.a;
            }
        }
        pugcShortTvHistoryProvider$saveHistory$1 = new PugcShortTvHistoryProvider$saveHistory$1(this, continuation);
        PugcShortTvHistoryProvider$saveHistory$1 pugcShortTvHistoryProvider$saveHistory$122 = pugcShortTvHistoryProvider$saveHistory$1;
        obj = pugcShortTvHistoryProvider$saveHistory$122.result;
        Object f2 = IntrinsicsKt.f();
        i = pugcShortTvHistoryProvider$saveHistory$122.label;
        if (i != 0) {
        }
        if (((UGCVideoDetailPlayBean) obj) != null) {
        }
        yw.e eVar22 = new yw.e(true, false);
        FlowEventBus applicationScopeViewModel22 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name22 = yw.e.class.getName();
        Intrinsics.g(name22, "getName(...)");
        applicationScopeViewModel22.postEvent(name22, eVar22, 0L);
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(String str, Continuation continuation) {
        PugcShortTvHistoryProvider$getHistory$1 pugcShortTvHistoryProvider$getHistory$1;
        int i;
        AppDatabase b;
        Object r;
        UGCVideoDetailPlayBean uGCVideoDetailPlayBean;
        AppDatabase appDatabase;
        String str2;
        String str3 = str;
        if (continuation instanceof PugcShortTvHistoryProvider$getHistory$1) {
            pugcShortTvHistoryProvider$getHistory$1 = (PugcShortTvHistoryProvider$getHistory$1) continuation;
            int i2 = pugcShortTvHistoryProvider$getHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pugcShortTvHistoryProvider$getHistory$1.label = i2 - Integer.MIN_VALUE;
                Object obj = pugcShortTvHistoryProvider$getHistory$1.result;
                Object f = IntrinsicsKt.f();
                i = pugcShortTvHistoryProvider$getHistory$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (str3 == null) {
                        return null;
                    }
                    AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
                    Application a = Utils.a();
                    Intrinsics.g(a, "getApp(...)");
                    b = appDatabase$f1.b(a);
                    UGCVideoDetailPlayDao B1 = b.B1();
                    pugcShortTvHistoryProvider$getHistory$1.L$0 = str3;
                    pugcShortTvHistoryProvider$getHistory$1.L$1 = b;
                    pugcShortTvHistoryProvider$getHistory$1.label = 1;
                    r = B1.r(str3, pugcShortTvHistoryProvider$getHistory$1);
                    if (r == f) {
                        return f;
                    }
                } else if (i == 1) {
                    AppDatabase appDatabase2 = (AppDatabase) pugcShortTvHistoryProvider$getHistory$1.L$1;
                    String str4 = (String) pugcShortTvHistoryProvider$getHistory$1.L$0;
                    ResultKt.b(obj);
                    b = appDatabase2;
                    str3 = str4;
                    r = obj;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                        if (uGCVideoDetailPlayBean != null) {
                            return new ShortTvInnerPlayBean(uGCVideoDetailPlayBean.getCollectionId(), uGCVideoDetailPlayBean.getUgcVideoId(), uGCVideoDetailPlayBean.getProgress(), uGCVideoDetailPlayBean.getTitle(), uGCVideoDetailPlayBean.getCoverUrl(), uGCVideoDetailPlayBean.getThumbnail(), uGCVideoDetailPlayBean.getPosition(), uGCVideoDetailPlayBean.getType(), uGCVideoDetailPlayBean.getTimeStamp(), uGCVideoDetailPlayBean.getSubtitleSelectId(), uGCVideoDetailPlayBean.getTotalDuration(), uGCVideoDetailPlayBean.getSubjectDurationSeconds(), uGCVideoDetailPlayBean.getAverageHueLight(), uGCVideoDetailPlayBean.getSubjectType(), uGCVideoDetailPlayBean.getHasDelete(), uGCVideoDetailPlayBean.getDownloadUrl(), uGCVideoDetailPlayBean.getDownloadResid(), uGCVideoDetailPlayBean.getDownloadFilePath(), uGCVideoDetailPlayBean.getDownloadSize(), uGCVideoDetailPlayBean.getLastAdStartTimeStamp(), uGCVideoDetailPlayBean.getLastAdEndTimeStamp(), uGCVideoDetailPlayBean.getRewardPlayed(), uGCVideoDetailPlayBean.getRewardUnlock(), uGCVideoDetailPlayBean.getRewardFree());
                        }
                        return null;
                    }
                    appDatabase = (AppDatabase) pugcShortTvHistoryProvider$getHistory$1.L$0;
                    ResultKt.b(obj);
                    str2 = (String) obj;
                    if (str2 == null) {
                        UGCVideoDetailPlayDao B12 = appDatabase.B1();
                        pugcShortTvHistoryProvider$getHistory$1.L$0 = null;
                        pugcShortTvHistoryProvider$getHistory$1.label = 3;
                        obj = B12.c(str2, pugcShortTvHistoryProvider$getHistory$1);
                        if (obj == f) {
                            return f;
                        }
                        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                        if (uGCVideoDetailPlayBean != null) {
                        }
                    } else {
                        uGCVideoDetailPlayBean = null;
                        if (uGCVideoDetailPlayBean != null) {
                        }
                    }
                }
                uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) r;
                if (uGCVideoDetailPlayBean == null) {
                    UGCCollectionVideoGroupDao A1 = b.A1();
                    pugcShortTvHistoryProvider$getHistory$1.L$0 = b;
                    pugcShortTvHistoryProvider$getHistory$1.L$1 = null;
                    pugcShortTvHistoryProvider$getHistory$1.label = 2;
                    Object c = A1.c(str3, pugcShortTvHistoryProvider$getHistory$1);
                    if (c == f) {
                        return f;
                    }
                    AppDatabase appDatabase3 = b;
                    obj = c;
                    appDatabase = appDatabase3;
                    str2 = (String) obj;
                    if (str2 == null) {
                    }
                }
                if (uGCVideoDetailPlayBean != null) {
                }
            }
        }
        pugcShortTvHistoryProvider$getHistory$1 = new PugcShortTvHistoryProvider$getHistory$1(this, continuation);
        Object obj2 = pugcShortTvHistoryProvider$getHistory$1.result;
        Object f2 = IntrinsicsKt.f();
        i = pugcShortTvHistoryProvider$getHistory$1.label;
        if (i != 0) {
        }
        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) r;
        if (uGCVideoDetailPlayBean == null) {
        }
        if (uGCVideoDetailPlayBean != null) {
        }
    }
}
