package com.transsion.ninegridview.preview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.photoview.PhotoView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ninegridview.preview.GifImagePreviewFragment$initView$5", f = "GifImagePreviewFragment.kt", l = {139}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GifImagePreviewFragment$initView$5 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PhotoView $pv;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GifImagePreviewFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GifImagePreviewFragment$initView$5(GifImagePreviewFragment gifImagePreviewFragment, PhotoView photoView, Continuation<? super GifImagePreviewFragment$initView$5> continuation) {
        super(2, continuation);
        this.this$0 = gifImagePreviewFragment;
        this.$pv = photoView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GifImagePreviewFragment$initView$5 gifImagePreviewFragment$initView$5 = new GifImagePreviewFragment$initView$5(this.this$0, this.$pv, continuation);
        gifImagePreviewFragment$initView$5.L$0 = obj;
        return gifImagePreviewFragment$initView$5;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.transsion.photoview.PhotoView] */
    public final Object invokeSuspend(Object obj) {
        Image image;
        String url;
        AssetManager assets;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        if (i == 0) {
            ResultKt.b(obj);
            image = this.this$0.image;
            if (image != null && (url = image.getUrl()) != null) {
                ?? r1 = this.$pv;
                Result.Companion companion2 = Result.Companion;
                Context context = r1.getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                a2 c = y0.c();
                GifImagePreviewFragment$initView$5$1$1$1 gifImagePreviewFragment$initView$5$1$1$1 = new GifImagePreviewFragment$initView$5$1$1$1(r1, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c, gifImagePreviewFragment$initView$5$1$1$1, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Result.constructor-impl(Unit.a);
        return Unit.a;
    }
}
