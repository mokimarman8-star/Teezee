package com.transsion.home.hashtag;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.RequestBody;
import yk.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.hashtag.HashTagViewModel$loadHashTagList$1", f = "HashTagViewModel.kt", l = {312}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HashTagViewModel$loadHashTagList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<UGCVideoHashTag> $currentSelectedTags;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ String $tabSort;
    int label;
    final /* synthetic */ HashTagViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HashTagViewModel$loadHashTagList$1(HashTagViewModel hashTagViewModel, String str, int i, Set<UGCVideoHashTag> set, boolean z, Continuation<? super HashTagViewModel$loadHashTagList$1> continuation) {
        super(2, continuation);
        this.this$0 = hashTagViewModel;
        this.$tabSort = str;
        this.$page = i;
        this.$currentSelectedTags = set;
        this.$isRefresh = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HashTagViewModel$loadHashTagList$1(this.this$0, this.$tabSort, this.$page, this.$currentSelectedTags, this.$isRefresh, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        RequestBody l;
        a aVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            wf.a.a.i("HashTagViewModel", "loadHashTagList exception: " + e.getMessage() + ", tabSort=" + this.$tabSort + ", page=" + this.$page, true);
            HashTagViewModel hashTagViewModel = this.this$0;
            String str = this.$tabSort;
            Set<UGCVideoHashTag> set = this.$currentSelectedTags;
            boolean z = this.$isRefresh;
            String message = e.getMessage();
            if (message == null) {
                message = BuildConfig.FLAVOR;
            }
            hashTagViewModel.n(str, set, z, message, "-1");
        }
        if (i == 0) {
            ResultKt.b(obj);
            l = this.this$0.l(this.$tabSort, this.$page, this.$currentSelectedTags);
            if (l == null) {
                this.this$0.n(this.$tabSort, this.$currentSelectedTags, this.$isRefresh, "Request body create failed", "-1");
                return Unit.a;
            }
            aVar = this.this$0.c;
            String a = gg.a.a.a();
            this.label = 1;
            obj = aVar.a(a, l, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.this$0.o(this.$tabSort, this.$page, this.$currentSelectedTags, this.$isRefresh, (BaseDto) obj);
        return Unit.a;
    }
}
