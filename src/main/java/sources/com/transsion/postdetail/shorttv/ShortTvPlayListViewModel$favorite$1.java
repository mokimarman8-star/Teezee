package com.transsion.postdetail.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.shorttv.a;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import hx.c;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.shorttv.ShortTvPlayListViewModel$favorite$1", f = "ShortTvPlayListViewModel.kt", l = {250}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvPlayListViewModel$favorite$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $favorite;
    final /* synthetic */ ShortTVFavInfo $favoriteInfo;
    final /* synthetic */ Subject $shortTvInfo;
    int label;
    final /* synthetic */ ShortTvPlayListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvPlayListViewModel$favorite$1(Subject subject, boolean z, ShortTvPlayListViewModel shortTvPlayListViewModel, ShortTVFavInfo shortTVFavInfo, Continuation<? super ShortTvPlayListViewModel$favorite$1> continuation) {
        super(2, continuation);
        this.$shortTvInfo = subject;
        this.$favorite = z;
        this.this$0 = shortTvPlayListViewModel;
        this.$favoriteInfo = shortTVFavInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvPlayListViewModel$favorite$1(this.$shortTvInfo, this.$favorite, this.this$0, this.$favoriteInfo, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                Subject subject = this.$shortTvInfo;
                boolean z = this.$favorite;
                ShortTvPlayListViewModel shortTvPlayListViewModel = this.this$0;
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectId", subject.getSubjectId());
                jSONObject.put("action", !z ? 1 : 0);
                a g = shortTvPlayListViewModel.g();
                RequestBody.Companion companion2 = RequestBody.Companion;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.g(jSONObject2, "toString(...)");
                RequestBody create = companion2.create(jSONObject2, MediaType.Companion.parse("application/json"));
                this.label = 1;
                obj = a.C0051a.a(g, create, null, this, 2, null);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            obj2 = Result.constructor-impl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        ShortTVFavInfo shortTVFavInfo = this.$favoriteInfo;
        boolean z2 = this.$favorite;
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.this$0;
        Subject subject2 = this.$shortTvInfo;
        if (Result.isSuccess-impl(obj2)) {
            if (shortTVFavInfo.getHasFavorite() != (!z2)) {
                shortTVFavInfo.setHasFavorite(!z2);
                if (z2) {
                    String favoriteNum = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum != null ? Long.parseLong(favoriteNum) : 1L) - 1));
                } else {
                    String favoriteNum2 = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum2 != null ? Long.parseLong(favoriteNum2) : 0L) + 1));
                }
                shortTvPlayListViewModel2.e().q(Boxing.a(!z2));
                shortTvPlayListViewModel2.f().q(!z2 ? "favorite_add" : "favorite_cancel");
                String subjectId = subject2.getSubjectId();
                if (subjectId == null) {
                    subjectId = BuildConfig.FLAVOR;
                }
                c cVar = new c(subjectId, true ^ z2, String.valueOf(shortTVFavInfo.getFavoriteNum()));
                FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = c.class.getName();
                Intrinsics.g(name, "getName(...)");
                applicationScopeViewModel.postEvent(name, cVar, 0L);
                shortTvPlayListViewModel2.k(subject2);
            }
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel3 = this.this$0;
        boolean z3 = this.$favorite;
        if (Result.exceptionOrNull-impl(obj2) != null) {
            shortTvPlayListViewModel3.e().q(Boxing.a(z3));
            shortTvPlayListViewModel3.f().q("favorite_fail");
        }
        return Unit.a;
    }
}
