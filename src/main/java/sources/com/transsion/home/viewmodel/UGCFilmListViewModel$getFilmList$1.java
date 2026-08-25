package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.FilmListRequest;
import com.transsion.home.bean.FilmListResponse;
import com.transsion.home.bean.UgcGenreTopRespGenreItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilmListViewModel$getFilmList$1", f = "UGCFilmListViewModel.kt", l = {127}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCFilmListViewModel$getFilmList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentPage;
    int label;
    final /* synthetic */ UGCFilmListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UGCFilmListViewModel$getFilmList$1(UGCFilmListViewModel uGCFilmListViewModel, int i, Continuation<? super UGCFilmListViewModel$getFilmList$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCFilmListViewModel;
        this.$currentPage = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilmListViewModel$getFilmList$1(this.this$0, this.$currentPage, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        yk.b bVar;
        List<UgcGenreTopRespGenreItem> l;
        Pager pager;
        Pager pager2;
        boolean z;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                str = this.this$0.c;
                FilmListRequest filmListRequest = new FilmListRequest(str, this.$currentPage, 20);
                String j = com.blankj.utilcode.util.o.j(filmListRequest);
                a.a.f(wf.a.a, "FilmListViewModel", "getFilmList: request params=" + j, false, 4, (Object) null);
                bVar = this.this$0.b;
                String a = gg.a.a.a();
                String type = filmListRequest.getType();
                int page = filmListRequest.getPage();
                int perPage = filmListRequest.getPerPage();
                this.label = 1;
                obj = bVar.b(a, type, page, perPage, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.a aVar = wf.a.a;
            a.a.f(aVar, "FilmListViewModel", "getFilmList: response code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), false, 4, (Object) null);
            if (!Intrinsics.c(baseDto.getCode(), "0") || baseDto.getData() == null) {
                this.this$0.k().n((Object) null);
                a.a.l(aVar, "FilmListViewModel", "getFilmList failed: code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), false, 4, (Object) null);
            } else {
                FilmListResponse filmListResponse = (FilmListResponse) baseDto.getData();
                this.this$0.e = filmListResponse != null ? filmListResponse.getPager() : null;
                if (filmListResponse == null || (l = filmListResponse.getItems()) == null) {
                    l = CollectionsKt.l();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : l) {
                    UGCContent ugcContent = ((UgcGenreTopRespGenreItem) obj2).getUgcContent();
                    if (Intrinsics.c(ugcContent != null ? ugcContent.getTopicType() : null, "UGC_VIDEO") && ugcContent.getVideo() != null) {
                        arrayList.add(obj2);
                    }
                }
                a.a aVar2 = wf.a.a;
                int size = arrayList.size();
                pager = this.this$0.e;
                Boolean hasMore = pager != null ? pager.getHasMore() : null;
                pager2 = this.this$0.e;
                a.a.f(aVar2, "FilmListViewModel", "getFilmList success, size=" + size + ", hasMore=" + hasMore + ", nextPage=" + (pager2 != null ? pager2.getNextPage() : null), false, 4, (Object) null);
                this.this$0.k().n(arrayList);
                String desc = filmListResponse != null ? filmListResponse.getDesc() : null;
                z = this.this$0.i;
                if (!z && this.$currentPage == 1 && desc != null && desc.length() != 0) {
                    a.a.f(aVar2, "FilmListViewModel", "getFilmList: emit title desc='" + desc + "' for first load", false, 4, (Object) null);
                    this.this$0.j().n(desc);
                    this.this$0.i = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            wf.a.a.i("FilmListViewModel", "getFilmList exception: " + e.getMessage(), true);
            this.this$0.k().n((Object) null);
        }
        return Unit.a;
    }
}
