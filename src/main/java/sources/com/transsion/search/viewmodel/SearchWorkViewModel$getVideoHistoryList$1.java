package com.transsion.search.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.b0;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.viewmodel.SearchWorkViewModel$getVideoHistoryList$1", f = "SearchWorkViewModel.kt", l = {44}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchWorkViewModel$getVideoHistoryList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefreshAll;
    int label;
    final /* synthetic */ SearchWorkViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchWorkViewModel$getVideoHistoryList$1(boolean z, SearchWorkViewModel searchWorkViewModel, Continuation<? super SearchWorkViewModel$getVideoHistoryList$1> continuation) {
        super(2, continuation);
        this.$isRefreshAll = z;
        this.this$0 = searchWorkViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchWorkViewModel$getVideoHistoryList$1(this.$isRefreshAll, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0065, code lost:
    
        if (r0 < r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao j;
        int i;
        List list;
        ArrayList arrayList;
        List list2;
        List list3;
        int i2;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.$isRefreshAll) {
                this.this$0.m(0);
                this.this$0.a = true;
                list = this.this$0.c;
                list.clear();
            }
            j = this.this$0.j();
            int i4 = this.this$0.i();
            i = this.this$0.f;
            this.label = 1;
            obj = j.d(i4, i, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list4 = (List) obj;
        List list5 = list4;
        if (list5 != null && !list5.isEmpty()) {
            int size = list4.size();
            i2 = this.this$0.f;
        }
        this.this$0.a = false;
        if (list4 != null) {
            arrayList = new ArrayList();
            for (Object obj2 : list4) {
                if (TextUtils.isDigitsOnly(((VideoDetailPlayBean) obj2).getId())) {
                    arrayList.add(obj2);
                }
            }
        } else {
            arrayList = null;
        }
        Integer d = arrayList != null ? Boxing.d(arrayList.size()) : null;
        Log.e("SearchWork", "获取视频播放记录 数量： " + d + "，hasMore:" + this.this$0.g());
        if (arrayList == null) {
            return Unit.a;
        }
        list2 = this.this$0.c;
        list2.addAll(arrayList);
        SearchWorkViewModel searchWorkViewModel = this.this$0;
        searchWorkViewModel.m(searchWorkViewModel.i() + arrayList.size());
        b0 h = this.this$0.h();
        list3 = this.this$0.c;
        h.n(CollectionsKt.U0(list3));
        return Unit.a;
    }
}
