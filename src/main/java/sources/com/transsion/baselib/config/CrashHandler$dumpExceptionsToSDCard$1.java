package com.transsion.baselib.config;

import android.app.Application;
import com.transsion.gslb.BuildConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baselib.config.CrashHandler$dumpExceptionsToSDCard$1", f = "CrashHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CrashHandler$dumpExceptionsToSDCard$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $e;
    int label;
    final /* synthetic */ CrashHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CrashHandler$dumpExceptionsToSDCard$1(CrashHandler crashHandler, Throwable th2, Continuation<? super CrashHandler$dumpExceptionsToSDCard$1> continuation) {
        super(2, continuation);
        this.this$0 = crashHandler;
        this.$e = th2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CrashHandler$dumpExceptionsToSDCard$1(this.this$0, this.$e, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00af, code lost:
    
        if (r8 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b1, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c1, code lost:
    
        return kotlin.Unit.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        if (r8 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PrintWriter printWriter;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            try {
                Application d = CrashHandler.d(this.this$0);
                if (d != null) {
                    Throwable th2 = this.$e;
                    String c = xf.c.a.c(d);
                    File file = new File(c);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    Date date = new Date(System.currentTimeMillis());
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                    PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(new File(c + File.separator + "crash" + format + ".txt"), true)));
                    objectRef.element = printWriter2;
                    String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
                    StringBuilder sb = new StringBuilder();
                    sb.append("begin crash ");
                    sb.append(format2);
                    printWriter2.println(sb.toString());
                    th2.printStackTrace((PrintWriter) objectRef.element);
                }
                printWriter = (PrintWriter) objectRef.element;
            } catch (Exception e) {
                e.printStackTrace();
                printWriter = (PrintWriter) objectRef.element;
            }
        } catch (Throwable th3) {
            PrintWriter printWriter3 = (PrintWriter) objectRef.element;
            if (printWriter3 != null) {
                printWriter3.close();
            }
            throw th3;
        }
    }
}
