package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.view.PostBaseItemView$setBottomRoomModuleData$1", f = "PostBaseItemView.kt", l = {730}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PostBaseItemView$setBottomRoomModuleData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostSubjectItem $item;
    int label;
    final /* synthetic */ PostBaseItemView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostBaseItemView$setBottomRoomModuleData$1(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, Continuation<? super PostBaseItemView$setBottomRoomModuleData$1> continuation) {
        super(2, continuation);
        this.$item = postSubjectItem;
        this.this$0 = postBaseItemView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostBaseItemView$setBottomRoomModuleData$1(this.$item, this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.transsion.postdetail.ui.view.PostBaseItemView] */
    public final Object invokeSuspend(Object obj) {
        Group group;
        Cover cover;
        String url;
        AssetManager assets;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            Group group2 = this.$item.getGroup();
            if ((group2 == null || group2.getAvatar() == null) && (group = this.$item.getGroup()) != null && (cover = group.getCover()) != null && (url = cover.getUrl()) != null) {
                ?? r1 = this.this$0;
                Context context = r1.getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                kotlinx.coroutines.a2 c = kotlinx.coroutines.y0.c();
                PostBaseItemView$setBottomRoomModuleData$1$1$1 postBaseItemView$setBottomRoomModuleData$1$1$1 = new PostBaseItemView$setBottomRoomModuleData$1$1$1(r1, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c, postBaseItemView$setBottomRoomModuleData$1$1$1, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Unit unit = Unit.a;
        return Unit.a;
    }
}
