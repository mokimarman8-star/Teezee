package com.transsion.search_pugc.fragment.result;

import android.util.Log;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.search_pugc.bean.SecondTab;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search_pugc.fragment.result.SearchResultViewModel$requestUGCSearchResult$1", f = "SearchResultViewModel.kt", l = {68}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchResultViewModel$requestUGCSearchResult$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $pageFrom;
    final /* synthetic */ SecondTab $secondTab;
    final /* synthetic */ String $tabId;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SearchResultViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchResultViewModel$requestUGCSearchResult$1(SearchResultViewModel searchResultViewModel, String str, String str2, String str3, SecondTab secondTab, boolean z, Continuation<? super SearchResultViewModel$requestUGCSearchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = searchResultViewModel;
        this.$keyword = str;
        this.$pageFrom = str2;
        this.$tabId = str3;
        this.$secondTab = secondTab;
        this.$isLoadMore = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchResultViewModel$requestUGCSearchResult$1 searchResultViewModel$requestUGCSearchResult$1 = new SearchResultViewModel$requestUGCSearchResult$1(this.this$0, this.$keyword, this.$pageFrom, this.$tabId, this.$secondTab, this.$isLoadMore, continuation);
        searchResultViewModel$requestUGCSearchResult$1.L$0 = obj;
        return searchResultViewModel$requestUGCSearchResult$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i;
        SearchResultViewModel searchResultViewModel;
        jq.a j;
        boolean z;
        int i2;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                JsonObject jsonObject = new JsonObject();
                SearchResultViewModel searchResultViewModel2 = this.this$0;
                String str = this.$keyword;
                String str2 = this.$pageFrom;
                String str3 = this.$tabId;
                SecondTab secondTab = this.$secondTab;
                i = searchResultViewModel2.h;
                jsonObject.addProperty("page", Boxing.d(i));
                jsonObject.addProperty("perPage", Boxing.d(20));
                jsonObject.addProperty("keyword", str);
                jsonObject.addProperty("pageFrom", str2);
                if (str3 != null && str3.length() != 0) {
                    jsonObject.addProperty("tabId", str3);
                }
                String g = searchResultViewModel2.g();
                if (g != null && g.length() != 0) {
                    jsonObject.addProperty("ugcVideoId", searchResultViewModel2.g());
                }
                if (secondTab != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("tagType", secondTab.getTagType());
                    jsonObject2.addProperty("tagValue", secondTab.getTagValue());
                    jsonObject.add("secondTab", jsonObject2);
                }
                RequestBody.Companion companion = RequestBody.Companion;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                RequestBody create = companion.create(jsonElement, MediaType.Companion.parse("application/json"));
                searchResultViewModel = this.this$0;
                boolean z2 = this.$isLoadMore;
                Result.Companion companion2 = Result.Companion;
                j = searchResultViewModel.j();
                String a = gg.a.a.a();
                this.L$0 = searchResultViewModel;
                this.Z$0 = z2;
                this.label = 1;
                obj = j.b(a, create, this);
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
            if (z) {
                searchResultViewModel.k().n(baseDto.getData());
            } else {
                searchResultViewModel.l().n(baseDto.getData());
            }
            i2 = searchResultViewModel.h;
            searchResultViewModel.h = 1 + i2;
            obj2 = Result.constructor-impl(Boxing.d(i2));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        boolean z3 = this.$isLoadMore;
        SearchResultViewModel searchResultViewModel3 = this.this$0;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            if (z3) {
                searchResultViewModel3.k().n((Object) null);
            } else {
                searchResultViewModel3.l().n((Object) null);
            }
            Log.e("SearchResultViewModel", "getUGCSearchResult error: " + th3.getMessage(), th3);
        }
        return Unit.a;
    }
}
