package com.transsion.moviedetail.viewmodel;

import androidx.lifecycle.b0;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.bean.ForYouBean;
import java.util.List;
import kotlin.Metadata;
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
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchLocalRec$1", f = "MovieDetailViewModel.kt", l = {227}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieDetailViewModel$fetchLocalRec$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTablet;
    final /* synthetic */ int $page;
    final /* synthetic */ String $requestKey;
    final /* synthetic */ Integer $subjectType;
    final /* synthetic */ boolean $useName;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieDetailViewModel$fetchLocalRec$1(boolean z, String str, Integer num, int i, boolean z2, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$fetchLocalRec$1> continuation) {
        super(2, continuation);
        this.$useName = z;
        this.$requestKey = str;
        this.$subjectType = num;
        this.$page = i;
        this.$isTablet = z2;
        this.this$0 = movieDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$fetchLocalRec$1(this.$useName, this.$requestKey, this.$subjectType, this.$page, this.$isTablet, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x006a, code lost:
    
        if (r12.intValue() != r1) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:5:0x000e, B:6:0x00de, B:8:0x00e2, B:10:0x00ec, B:12:0x00f6, B:13:0x00fc, B:23:0x001e, B:26:0x006c, B:29:0x007e, B:32:0x0084, B:35:0x0093, B:37:0x009c, B:38:0x00a1, B:40:0x00c9, B:44:0x0091, B:46:0x0077, B:49:0x0066), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        b0 b0Var;
        RequestBody a;
        om.a N;
        List<Subject> list;
        b0 b0Var2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception unused) {
            b0Var = this.this$0.j;
            b0Var.n((Object) null);
        }
        if (i == 0) {
            ResultKt.b(obj);
            a.a.f(wf.a.a, "MovieDetailViewModel", "fetchLocalRec,useName:" + this.$useName + ", requestKey:" + this.$requestKey + ",subjectType" + this.$subjectType + ", page:" + this.$page, false, 4, (Object) null);
            Integer num = this.$subjectType;
            int value = SubjectType.MUSIC.getValue();
            int i2 = 8;
            if (num != null) {
            }
            Integer num2 = this.$subjectType;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 != null && num2.intValue() == value2) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("subjectId", !this.$useName ? "0" : this.$requestKey);
                jsonObject.addProperty("name", !this.$useName ? this.$requestKey : BuildConfig.FLAVOR);
                jsonObject.addProperty("page", Boxing.d(this.$page));
                jsonObject.addProperty("perPage", Boxing.d(i2));
                b.a aVar = mg.b.a;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                a = aVar.a(jsonElement);
                if (a != null) {
                    N = this.this$0.N();
                    String a2 = gg.a.a.a();
                    this.label = 1;
                    obj = N.h(a2, a, this);
                    if (obj == f) {
                        return f;
                    }
                }
                list = null;
                a.a.f(wf.a.a, "MovieDetailViewModel", "fetchLocalRec,items: " + list, false, 4, (Object) null);
                b0Var2 = this.this$0.j;
                b0Var2.n(list);
                return Unit.a;
            }
            if (!this.$isTablet) {
                i2 = 6;
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("subjectId", !this.$useName ? "0" : this.$requestKey);
            jsonObject2.addProperty("name", !this.$useName ? this.$requestKey : BuildConfig.FLAVOR);
            jsonObject2.addProperty("page", Boxing.d(this.$page));
            jsonObject2.addProperty("perPage", Boxing.d(i2));
            b.a aVar2 = mg.b.a;
            String jsonElement2 = jsonObject2.toString();
            Intrinsics.g(jsonElement2, "toString(...)");
            a = aVar2.a(jsonElement2);
            if (a != null) {
            }
            list = null;
            a.a.f(wf.a.a, "MovieDetailViewModel", "fetchLocalRec,items: " + list, false, 4, (Object) null);
            b0Var2 = this.this$0.j;
            b0Var2.n(list);
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        if (baseDto != null) {
            ForYouBean forYouBean = Intrinsics.c(baseDto.getCode(), "0") ? (ForYouBean) baseDto.getData() : null;
            if (forYouBean != null) {
                list = forYouBean.getItems();
                a.a.f(wf.a.a, "MovieDetailViewModel", "fetchLocalRec,items: " + list, false, 4, (Object) null);
                b0Var2 = this.this$0.j;
                b0Var2.n(list);
                return Unit.a;
            }
        }
        list = null;
        a.a.f(wf.a.a, "MovieDetailViewModel", "fetchLocalRec,items: " + list, false, 4, (Object) null);
        b0Var2 = this.this$0.j;
        b0Var2.n(list);
        return Unit.a;
    }
}
