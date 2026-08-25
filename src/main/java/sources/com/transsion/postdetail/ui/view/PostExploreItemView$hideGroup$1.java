package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.User;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.view.PostExploreItemView$hideGroup$1", f = "PostExploreItemView.kt", l = {92}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PostExploreItemView$hideGroup$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostSubjectItem $item;
    int label;
    final /* synthetic */ PostExploreItemView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostExploreItemView$hideGroup$1(PostSubjectItem postSubjectItem, PostExploreItemView postExploreItemView, Continuation<? super PostExploreItemView$hideGroup$1> continuation) {
        super(2, continuation);
        this.$item = postSubjectItem;
        this.this$0 = postExploreItemView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostExploreItemView$hideGroup$1(this.$item, this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.transsion.postdetail.ui.view.PostExploreItemView] */
    public final Object invokeSuspend(Object obj) {
        String avatar;
        AssetManager assets;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            User user = this.$item.getUser();
            if (user != null && (avatar = user.getAvatar()) != null) {
                ?? r1 = this.this$0;
                Context context = r1.getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(avatar));
                kotlinx.coroutines.a2 c = kotlinx.coroutines.y0.c();
                PostExploreItemView$hideGroup$1$1$1 postExploreItemView$hideGroup$1$1$1 = new PostExploreItemView$hideGroup$1$1$1(r1, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c, postExploreItemView$hideGroup$1$1$1, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
