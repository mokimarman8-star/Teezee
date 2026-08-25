package com.transsion.search.fragment.result;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.net.RequestSearchResultEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.fragment.result.SearchResultViewModel$requestSearchResult$1", f = "SearchResultViewModel.kt", l = {56}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchResultViewModel$requestSearchResult$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $tabId;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SearchResultViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchResultViewModel$requestSearchResult$1(SearchResultViewModel searchResultViewModel, String str, String str2, boolean z, Continuation<? super SearchResultViewModel$requestSearchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = searchResultViewModel;
        this.$keyword = str;
        this.$tabId = str2;
        this.$isLoadMore = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchResultViewModel$requestSearchResult$1 searchResultViewModel$requestSearchResult$1 = new SearchResultViewModel$requestSearchResult$1(this.this$0, this.$keyword, this.$tabId, this.$isLoadMore, continuation);
        searchResultViewModel$requestSearchResult$1.L$0 = obj;
        return searchResultViewModel$requestSearchResult$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i;
        SearchResultViewModel searchResultViewModel;
        cq.a l;
        boolean z;
        int i2;
        List<ResultWrapData> h;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                i = this.this$0.f;
                RequestSearchResultEntity requestSearchResultEntity = new RequestSearchResultEntity(i, 10, this.$keyword);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("page", Boxing.d(requestSearchResultEntity.getPage()));
                jsonObject.addProperty("perPage", Boxing.d(requestSearchResultEntity.getPerPage()));
                jsonObject.addProperty("keyword", requestSearchResultEntity.getKeyword());
                String str = this.$tabId;
                if (str != null && str.length() != 0) {
                    jsonObject.addProperty("tabId", this.$tabId);
                }
                RequestBody.Companion companion = RequestBody.Companion;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                RequestBody create = companion.create(jsonElement, MediaType.Companion.parse("application/json"));
                searchResultViewModel = this.this$0;
                boolean z2 = this.$isLoadMore;
                Result.Companion companion2 = Result.Companion;
                l = searchResultViewModel.l();
                String l2 = CacheIpPool.a.l();
                this.L$0 = searchResultViewModel;
                this.Z$0 = z2;
                this.label = 1;
                obj = l.c(l2, create, this);
                if (obj == f) {
                    return f;
                }
                z = z2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.Z$0;
                searchResultViewModel = (SearchResultViewModel) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            SearchResultEntity searchResultEntity = (SearchResultEntity) baseDto.getData();
            if (searchResultEntity != null) {
                SearchResultEntity searchResultEntity2 = (SearchResultEntity) baseDto.getData();
                h = searchResultViewModel.h(searchResultEntity2 != null ? searchResultEntity2.getResults() : null);
                searchResultEntity.setConvertData(h);
            }
            if (z) {
                searchResultViewModel.j().n(baseDto.getData());
            } else {
                searchResultViewModel.k().n(baseDto.getData());
            }
            i2 = searchResultViewModel.f;
            searchResultViewModel.f = 1 + i2;
            obj2 = Result.constructor-impl(Boxing.d(i2));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        SearchResultViewModel searchResultViewModel2 = this.this$0;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            searchResultViewModel2.k().n((Object) null);
            a.a.l(wf.a.a, "SearchResultViewModel", "requestSearchResult error: " + th3.getMessage(), false, 4, (Object) null);
        }
        return Unit.a;
    }
}
