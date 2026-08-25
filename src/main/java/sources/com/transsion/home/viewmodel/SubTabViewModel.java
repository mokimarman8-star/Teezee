package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.u0;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.DisplayMeta;
import com.transsion.home.bean.FeedsLayoutType;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.bean.TrendingRespItemType;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import yk.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubTabViewModel extends androidx.lifecycle.b {
    public static final a h = new a(null);
    public static final int i = 8;
    private final androidx.lifecycle.b0 b;
    private final androidx.lifecycle.b0 c;
    private final Lazy d;
    private final yk.e e;
    private int f;
    private boolean g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new androidx.lifecycle.b0();
        this.c = new androidx.lifecycle.b0();
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.n
            public final Object invoke() {
                androidx.lifecycle.b0 x;
                x = SubTabViewModel.x();
                return x;
            }
        });
        this.e = (yk.e) kg.c.e.a().h(yk.e.class);
        this.f = 1;
        this.g = ij.g.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List l(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            Integer type = trendingRespItem.getType();
            int value = TrendingRespItemType.SUBJECT.getValue();
            if (type != null && type.intValue() == value && trendingRespItem.getSubject() != null) {
                OperateItem operateItem = new OperateItem(null, PostItemType.SUBJECT.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null);
                operateItem.setFeedsSubject(trendingRespItem.getSubject());
                arrayList.add(operateItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List m(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            UGCContent content = trendingRespItem.getContent();
            if ((content != null ? content.getVideo() : null) != null) {
                DisplayMeta displayMeta = trendingRespItem.getDisplayMeta();
                if (Intrinsics.c(displayMeta != null ? displayMeta.getLayoutType() : null, FeedsLayoutType.FULL.getValue())) {
                    String value = PostItemType.TRENDING_FEES_BIG.getValue();
                    UGCContent content2 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content2 != null ? content2.getVideo() : null, null, null, null, null, null, null, null, null, 535822333, null));
                } else {
                    String value2 = PostItemType.TRENDING_FEES_GRID.getValue();
                    UGCContent content3 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content3 != null ? content3.getVideo() : null, null, null, null, null, null, null, null, null, 535822333, null));
                }
            }
        }
        return arrayList;
    }

    private final String o(String str, int i2) {
        return str + "_" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(int i2, String str, Continuation continuation) {
        SubTabViewModel$getSubOperation$1 subTabViewModel$getSubOperation$1;
        int i3;
        int i4;
        String str2;
        BaseDto baseDto;
        SubOperateData subOperateData;
        List<OperateItem> items;
        SubOperateData subOperateData2;
        List<OperateItem> items2;
        SubOperateData subOperateData3;
        String version;
        if (continuation instanceof SubTabViewModel$getSubOperation$1) {
            subTabViewModel$getSubOperation$1 = (SubTabViewModel$getSubOperation$1) continuation;
            int i5 = subTabViewModel$getSubOperation$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                subTabViewModel$getSubOperation$1.label = i5 - Integer.MIN_VALUE;
                SubTabViewModel$getSubOperation$1 subTabViewModel$getSubOperation$12 = subTabViewModel$getSubOperation$1;
                Object obj = subTabViewModel$getSubOperation$12.result;
                Object f = IntrinsicsKt.f();
                i3 = subTabViewModel$getSubOperation$12.label;
                if (i3 != 0) {
                    ResultKt.b(obj);
                    String string = zk.e.a.b().getString(o("sub_operation_version_prefix", i2), BuildConfig.FLAVOR);
                    if (this.g) {
                        yk.e eVar = this.e;
                        subTabViewModel$getSubOperation$12.L$0 = string;
                        subTabViewModel$getSubOperation$12.I$0 = i2;
                        subTabViewModel$getSubOperation$12.label = 1;
                        obj = e.a.f(eVar, null, i2, string, str, subTabViewModel$getSubOperation$12, 1, null);
                        if (obj == f) {
                            return f;
                        }
                        i4 = i2;
                        str2 = string;
                        baseDto = (BaseDto) obj;
                    } else {
                        yk.e eVar2 = this.e;
                        subTabViewModel$getSubOperation$12.L$0 = string;
                        subTabViewModel$getSubOperation$12.I$0 = i2;
                        subTabViewModel$getSubOperation$12.label = 2;
                        obj = e.a.d(eVar2, null, i2, string, subTabViewModel$getSubOperation$12, 1, null);
                        if (obj == f) {
                            return f;
                        }
                        i4 = i2;
                        str2 = string;
                        baseDto = (BaseDto) obj;
                    }
                } else if (i3 == 1) {
                    i4 = subTabViewModel$getSubOperation$12.I$0;
                    str2 = (String) subTabViewModel$getSubOperation$12.L$0;
                    ResultKt.b(obj);
                    baseDto = (BaseDto) obj;
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i4 = subTabViewModel$getSubOperation$12.I$0;
                    str2 = (String) subTabViewModel$getSubOperation$12.L$0;
                    ResultKt.b(obj);
                    baseDto = (BaseDto) obj;
                }
                if (str2 != null || str2.length() == 0 || (subOperateData2 = (SubOperateData) baseDto.getData()) == null || (items2 = subOperateData2.getItems()) == null || !items2.isEmpty() || (subOperateData3 = (SubOperateData) baseDto.getData()) == null || (version = subOperateData3.getVersion()) == null || version.length() <= 0) {
                    subOperateData = (SubOperateData) baseDto.getData();
                    if (subOperateData != null && (items = subOperateData.getItems()) != null && (!items.isEmpty())) {
                        String json = new Gson().toJson(baseDto.getData());
                        zk.e eVar3 = zk.e.a;
                        eVar3.b().putString(o("sub_operation_prefix", i4), json);
                        MMKV b = eVar3.b();
                        String o = o("sub_operation_version_prefix", i4);
                        SubOperateData subOperateData4 = (SubOperateData) baseDto.getData();
                        b.putString(o, subOperateData4 == null ? subOperateData4.getVersion() : null);
                    }
                } else {
                    baseDto.setData(com.blankj.utilcode.util.o.d(zk.e.a.b().getString(o("sub_operation_prefix", i4), BuildConfig.FLAVOR), SubOperateData.class));
                }
                return baseDto.getData();
            }
        }
        subTabViewModel$getSubOperation$1 = new SubTabViewModel$getSubOperation$1(this, continuation);
        SubTabViewModel$getSubOperation$1 subTabViewModel$getSubOperation$122 = subTabViewModel$getSubOperation$1;
        Object obj2 = subTabViewModel$getSubOperation$122.result;
        Object f2 = IntrinsicsKt.f();
        i3 = subTabViewModel$getSubOperation$122.label;
        if (i3 != 0) {
        }
        if (str2 != null) {
        }
        subOperateData = (SubOperateData) baseDto.getData();
        if (subOperateData != null) {
            String json2 = new Gson().toJson(baseDto.getData());
            zk.e eVar32 = zk.e.a;
            eVar32.b().putString(o("sub_operation_prefix", i4), json2);
            MMKV b2 = eVar32.b();
            String o2 = o("sub_operation_version_prefix", i4);
            SubOperateData subOperateData42 = (SubOperateData) baseDto.getData();
            b2.putString(o2, subOperateData42 == null ? subOperateData42.getVersion() : null);
        }
        return baseDto.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(SubOperateData subOperateData) {
        List<OperateItem> items;
        if (subOperateData == null || (items = subOperateData.getItems()) == null) {
            return;
        }
        for (OperateItem operateItem : items) {
            if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_SUBJECT_LIST.getValue()) && Intrinsics.c(operateItem.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.O)) {
                operateItem.setType(PostItemType.UGC_VERTICAL_OPT_LIST.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i2, SubOperateData subOperateData) {
        List<OperateItem> items;
        List<OperateItem> items2;
        if (HomeTabId.INSTANCE.h(Integer.valueOf(i2), true) && !ij.o.a.i()) {
            CourseManager.r(CourseManager.a, null, null, 3, null);
            if (subOperateData != null && (items2 = subOperateData.getItems()) != null) {
                items2.add(1, new OperateItem(null, PostItemType.MY_COURSE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null));
            }
        }
        String trendingTitle = subOperateData != null ? subOperateData.getTrendingTitle() : null;
        if (trendingTitle == null || trendingTitle.length() == 0 || subOperateData == null || (items = subOperateData.getItems()) == null) {
            return;
        }
        items.add(new OperateItem(subOperateData.getTrendingTitle(), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870908, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 x() {
        return new androidx.lifecycle.b0();
    }

    public final void n(int i2, boolean z, String str) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SubTabViewModel$fetchOperateData$1(z, this, new Ref.ObjectRef(), i2, str, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 p() {
        return this.b;
    }

    public final androidx.lifecycle.b0 q() {
        return this.c;
    }

    public final androidx.lifecycle.b0 s() {
        return (androidx.lifecycle.b0) this.d.getValue();
    }

    public final void t(int i2, String str, boolean z) {
        String str2;
        if (z) {
            this.f = 1;
        }
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        int i3 = this.f;
        this.f = i3 + 1;
        trendingRequestEntity.setPage(String.valueOf(i3));
        trendingRequestEntity.setPerPage(this.g ? 14 : 12);
        trendingRequestEntity.setSessionId(jg.b.a.h());
        Uri b = com.transsion.baselib.report.h.a.b();
        if (b == null || (str2 = b.toString()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        trendingRequestEntity.setDeepLink(str2);
        trendingRequestEntity.setLatest_events(new ej.a(ej.b.a.e()));
        ij.o oVar = ij.o.a;
        if (oVar.i()) {
            trendingRequestEntity.setGrade(oVar.e());
        }
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SubTabViewModel$getTrendingList$1(trendingRequestEntity, this, str, i2, null), 2, (Object) null);
    }

    public final void w(boolean z) {
        this.g = z;
    }
}
