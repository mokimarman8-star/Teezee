package com.transsion.push.notification;

import com.blankj.utilcode.util.o;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.push.bean.ToolbarNoticeConfig;
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
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$checkNotice$1", f = "ToolbarNotificationUtils.kt", l = {111}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ToolbarNotificationUtils$checkNotice$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    ToolbarNotificationUtils$checkNotice$1(Continuation<? super ToolbarNotificationUtils$checkNotice$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToolbarNotificationUtils$checkNotice$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: all -> 0x000f, TRY_ENTER, TryCatch #1 {all -> 0x000f, blocks: (B:5:0x000b, B:6:0x0073, B:14:0x001c, B:17:0x002b, B:19:0x003b, B:21:0x0041, B:23:0x004d, B:24:0x0053, B:26:0x0061), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:5:0x000b, B:6:0x0073, B:14:0x001c, B:17:0x002b, B:19:0x003b, B:21:0x0041, B:23:0x004d, B:24:0x0053, B:26:0x0061), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ToolbarNoticeConfig toolbarNoticeConfig;
        boolean s;
        ConfigBean d;
        String value;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                Result.Companion companion = Result.Companion;
                a.a.v(wf.a.a, "ToolbarNo", "checkNotice-----", false, 4, (Object) null);
                try {
                    d = cm.f.d(cm.f.c.a(), "sa_toolbar_notice", false, 2, (Object) null);
                } catch (Exception unused) {
                }
                if (d != null && (value = d.getValue()) != null) {
                    toolbarNoticeConfig = (ToolbarNoticeConfig) o.d(value, ToolbarNoticeConfig.class);
                    int days = toolbarNoticeConfig == null ? toolbarNoticeConfig.getDays() : 3;
                    ToolbarNotificationUtils.e = toolbarNoticeConfig;
                    ToolbarNotificationUtils toolbarNotificationUtils = ToolbarNotificationUtils.a;
                    toolbarNotificationUtils.w(toolbarNoticeConfig);
                    s = toolbarNotificationUtils.s(days);
                    if (s) {
                        a2 c = y0.c();
                        ToolbarNotificationUtils$checkNotice$1$1$1 toolbarNotificationUtils$checkNotice$1$1$1 = new ToolbarNotificationUtils$checkNotice$1$1$1(null);
                        this.label = 1;
                        if (kotlinx.coroutines.i.g(c, toolbarNotificationUtils$checkNotice$1$1$1, this) == f) {
                            return f;
                        }
                    }
                }
                toolbarNoticeConfig = null;
                if (toolbarNoticeConfig == null) {
                }
                ToolbarNotificationUtils.e = toolbarNoticeConfig;
                ToolbarNotificationUtils toolbarNotificationUtils2 = ToolbarNotificationUtils.a;
                toolbarNotificationUtils2.w(toolbarNoticeConfig);
                s = toolbarNotificationUtils2.s(days);
                if (s) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }
}
