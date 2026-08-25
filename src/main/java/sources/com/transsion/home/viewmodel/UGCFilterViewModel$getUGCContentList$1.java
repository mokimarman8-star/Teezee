package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilterViewModel$getUGCContentList$1", f = "UGCFilterViewModel.kt", l = {102}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCFilterViewModel$getUGCContentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $categoryLve2;
    final /* synthetic */ Integer $categoryLve3;
    final /* synthetic */ Integer $categoryLve4;
    final /* synthetic */ String $finallyCateGory;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ int $perPage;
    final /* synthetic */ String $selectGrade;
    final /* synthetic */ String $sort;
    int label;
    final /* synthetic */ UGCFilterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UGCFilterViewModel$getUGCContentList$1(String str, int i, String str2, Integer num, Integer num2, Integer num3, boolean z, UGCFilterViewModel uGCFilterViewModel, int i2, String str3, Continuation<? super UGCFilterViewModel$getUGCContentList$1> continuation) {
        super(2, continuation);
        this.$finallyCateGory = str;
        this.$page = i;
        this.$sort = str2;
        this.$categoryLve2 = num;
        this.$categoryLve3 = num2;
        this.$categoryLve4 = num3;
        this.$isRefresh = z;
        this.this$0 = uGCFilterViewModel;
        this.$perPage = i2;
        this.$selectGrade = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilterViewModel$getUGCContentList$1(this.$finallyCateGory, this.$page, this.$sort, this.$categoryLve2, this.$categoryLve3, this.$categoryLve4, this.$isRefresh, this.this$0, this.$perPage, this.$selectGrade, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        yk.c cVar;
        Object d;
        List items;
        List list;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        ?? r11 = ", sort=";
        String str3 = "UGCFilterViewModel";
        try {
            if (i == 0) {
                ResultKt.b(obj);
                wf.a.a.c("UGCFilterViewModel", "getUGCContentList: category=" + this.$finallyCateGory + ", page=" + this.$page + ", sort=" + this.$sort + ", lv2=" + this.$categoryLve2 + ", lv3=" + this.$categoryLve3 + ", lv4=" + this.$categoryLve4 + ", isRefresh=" + this.$isRefresh, false);
                cVar = this.this$0.e;
                String a = gg.a.a.a();
                String str4 = this.$finallyCateGory;
                int i2 = this.$page;
                int i3 = this.$perPage;
                String str5 = this.$sort;
                Integer num = this.$categoryLve2;
                Integer num2 = this.$categoryLve3;
                Integer num3 = this.$categoryLve4;
                String str6 = this.$selectGrade;
                this.label = 1;
                str = "UGCFilterViewModel";
                str3 = str6;
                str2 = ", sort=";
                UGCFilterViewModel$getUGCContentList$1 uGCFilterViewModel$getUGCContentList$1 = this;
                try {
                    d = cVar.d(a, str4, i2, i3, str5, num, num2, num3, str3, uGCFilterViewModel$getUGCContentList$1);
                    r11 = uGCFilterViewModel$getUGCContentList$1;
                    if (d == f) {
                        return f;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    this.this$0.o().n((Object) null);
                    wf.a.a.i(str, "getUGCContentList error: " + e.getMessage() + ", page=" + this.$page + str2 + this.$sort, true);
                    return Unit.a;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                d = obj;
                str = "UGCFilterViewModel";
                str2 = ", sort=";
                r11 = r11;
            }
            BaseDto baseDto = (BaseDto) d;
            UGCContentList uGCContentList = (UGCContentList) baseDto.getData();
            if (uGCContentList != null) {
                List items2 = uGCContentList.getItems();
                if (items2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : items2) {
                        UGCContent uGCContent = (UGCContent) obj2;
                        if (Intrinsics.c(uGCContent.getTopicType(), "UGC_VIDEO") && uGCContent.getVideo() != null) {
                            arrayList.add(obj2);
                        }
                    }
                    list = CollectionsKt.U0(arrayList);
                } else {
                    list = null;
                }
                uGCContentList.setItems(list);
            }
            String msg = baseDto.getMsg();
            String str7 = msg == null ? BuildConfig.FLAVOR : msg;
            String code = baseDto.getCode();
            String str8 = code == null ? BuildConfig.FLAVOR : code;
            String reason = baseDto.getReason();
            this.this$0.o().n(new RefreshBaseDto(str7, str8, uGCContentList, reason == null ? BuildConfig.FLAVOR : reason, this.$isRefresh));
            a.a aVar = wf.a.a;
            int i4 = this.$page;
            String str9 = this.$sort;
            UGCContentList uGCContentList2 = (UGCContentList) baseDto.getData();
            aVar.c(str, "getUGCContentList success: page=" + i4 + str2 + str9 + ", size=" + ((uGCContentList2 == null || (items = uGCContentList2.getItems()) == null) ? 0 : items.size()), false);
        } catch (Exception e2) {
            e = e2;
            str = str3;
            str2 = r11;
        }
        return Unit.a;
    }
}
