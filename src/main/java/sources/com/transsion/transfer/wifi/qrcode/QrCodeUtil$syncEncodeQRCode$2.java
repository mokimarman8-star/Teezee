package com.transsion.transfer.wifi.qrcode;

import af.b;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.qrcode.QrCodeUtil$syncEncodeQRCode$2", f = "QrCodeUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class QrCodeUtil$syncEncodeQRCode$2 extends SuspendLambda implements Function2<n0, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ String $text;
    final /* synthetic */ int $width;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QrCodeUtil$syncEncodeQRCode$2(String str, int i, int i2, Continuation<? super QrCodeUtil$syncEncodeQRCode$2> continuation) {
        super(2, continuation);
        this.$text = str;
        this.$width = i;
        this.$height = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrCodeUtil$syncEncodeQRCode$2(this.$text, this.$width, this.$height, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Bitmap> continuation) {
        return ((QrCodeUtil$syncEncodeQRCode$2) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.$text;
        int i = this.$width;
        int i2 = this.$height;
        try {
            Result$Companion result$Companion = Result.Companion;
            b bVar = new b();
            obj2 = Result.constructor-impl(bVar.a(bVar.b(str, BarcodeFormat.QR_CODE, i, i2)));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj2) == null) {
            return obj2;
        }
        return null;
    }
}
