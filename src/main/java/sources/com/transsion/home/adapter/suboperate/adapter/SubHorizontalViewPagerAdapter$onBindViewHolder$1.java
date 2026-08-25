package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter$onBindViewHolder$1", f = "SubHorizontalViewPagerAdapter.kt", l = {67}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubHorizontalViewPagerAdapter$onBindViewHolder$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BannerData $bannerData;
    final /* synthetic */ SubHorizontalViewPagerAdapter.a $holder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubHorizontalViewPagerAdapter$onBindViewHolder$1(BannerData bannerData, SubHorizontalViewPagerAdapter.a aVar, Continuation<? super SubHorizontalViewPagerAdapter$onBindViewHolder$1> continuation) {
        super(2, continuation);
        this.$bannerData = bannerData;
        this.$holder = aVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubHorizontalViewPagerAdapter$onBindViewHolder$1(this.$bannerData, this.$holder, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String url;
        AssetManager assets;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            Image image = this.$bannerData.getImage();
            if (image != null && (url = image.getUrl()) != null) {
                SubHorizontalViewPagerAdapter.a aVar = this.$holder;
                Context context = aVar.getImageView().getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                a2 c = y0.c();
                SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 = new SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1(aVar, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c, subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1, this) == f) {
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
