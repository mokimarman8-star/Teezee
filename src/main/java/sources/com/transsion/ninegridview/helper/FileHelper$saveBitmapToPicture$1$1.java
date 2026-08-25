package com.transsion.ninegridview.helper;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1", f = "FileHelper.kt", l = {340, 347}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileHelper$saveBitmapToPicture$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Function2<Boolean, File, Unit> $callback;
    final /* synthetic */ String $fileName;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$1", f = "FileHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, File, Unit> $callback;
        final /* synthetic */ File $imgFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super Boolean, ? super File, Unit> function2, File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function2;
            this.$imgFile = file;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$imgFile, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function2<Boolean, File, Unit> function2 = this.$callback;
            if (function2 == null) {
                return null;
            }
            function2.invoke(Boxing.a(true), this.$imgFile);
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$2", f = "FileHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.ninegridview.helper.FileHelper$saveBitmapToPicture$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, File, Unit> $callback;
        final /* synthetic */ File $imgFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Boolean, ? super File, Unit> function2, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function2;
            this.$imgFile = file;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, this.$imgFile, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function2<Boolean, File, Unit> function2 = this.$callback;
            if (function2 != null) {
                function2.invoke(Boxing.a(false), this.$imgFile);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FileHelper$saveBitmapToPicture$1$1(String str, Bitmap bitmap, AppCompatActivity appCompatActivity, Function2<? super Boolean, ? super File, Unit> function2, Continuation<? super FileHelper$saveBitmapToPicture$1$1> continuation) {
        super(2, continuation);
        this.$fileName = str;
        this.$bitmap = bitmap;
        this.$activity = appCompatActivity;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileHelper$saveBitmapToPicture$1$1(this.$fileName, this.$bitmap, this.$activity, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.b(obj);
                return Unit.a;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.a;
        }
        ResultKt.b(obj);
        FileHelper fileHelper = FileHelper.a;
        File m = fileHelper.m(this.$fileName);
        if (m.exists()) {
            a2 c = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, m, null);
            this.label = 1;
            if (i.g(c, anonymousClass1, this) == f) {
                return f;
            }
            return Unit.a;
        }
        FileHelper.v(fileHelper, this.$bitmap, this.$activity, this.$fileName, null, 0, 12, null);
        a2 c2 = y0.c();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, m, null);
        this.label = 2;
        if (i.g(c2, anonymousClass2, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
