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
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$fetchRec$1", f = "MovieDetailViewModel.kt", l = {193}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieDetailViewModel$fetchRec$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTablet;
    final /* synthetic */ int $page;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ Integer $subjectType;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieDetailViewModel$fetchRec$1(String str, Integer num, int i, boolean z, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$fetchRec$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$subjectType = num;
        this.$page = i;
        this.$isTablet = z;
        this.this$0 = movieDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$fetchRec$1(this.$subjectId, this.$subjectType, this.$page, this.$isTablet, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        if (r1.intValue() != r4) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:5:0x000c, B:6:0x00be, B:8:0x00c2, B:10:0x00ce, B:12:0x00d8, B:13:0x00de, B:23:0x001c, B:26:0x0065, B:29:0x0077, B:32:0x007d, B:34:0x00a9, B:38:0x0070, B:41:0x005f), top: B:2:0x0008 }] */
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
            a.a.f(wf.a.a, "MovieDetailViewModel", "fetchRec,subjectId:" + this.$subjectId + ", subjectType:" + this.$subjectType + ",page: " + this.$page, false, 4, (Object) null);
            JsonObject jsonObject = new JsonObject();
            Integer num = this.$subjectType;
            int value = SubjectType.MUSIC.getValue();
            int i2 = 8;
            if (num != null) {
            }
            Integer num2 = this.$subjectType;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 != null && num2.intValue() == value2) {
                jsonObject.addProperty("subjectId", this.$subjectId);
                jsonObject.addProperty("perPage", Boxing.d(i2));
                jsonObject.addProperty("page", Boxing.d(this.$page));
                b.a aVar = mg.b.a;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                a = aVar.a(jsonElement);
                if (a != null) {
                    N = this.this$0.N();
                    String a2 = gg.a.a.a();
                    this.label = 1;
                    obj = N.d(a2, a, this);
                    if (obj == f) {
                        return f;
                    }
                }
                list = null;
                b0Var2 = this.this$0.j;
                b0Var2.n(list);
                return Unit.a;
            }
            if (!this.$isTablet) {
                i2 = 6;
            }
            jsonObject.addProperty("subjectId", this.$subjectId);
            jsonObject.addProperty("perPage", Boxing.d(i2));
            jsonObject.addProperty("page", Boxing.d(this.$page));
            b.a aVar2 = mg.b.a;
            String jsonElement2 = jsonObject.toString();
            Intrinsics.g(jsonElement2, "toString(...)");
            a = aVar2.a(jsonElement2);
            if (a != null) {
            }
            list = null;
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
                b0Var2 = this.this$0.j;
                b0Var2.n(list);
                return Unit.a;
            }
        }
        list = null;
        b0Var2 = this.this$0.j;
        b0Var2.n(list);
        return Unit.a;
    }
}
