package com.wecloud.load.lib;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.wecloud.load.lib.bean.SoLoadControlConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.y0;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/wecloud/load/lib/ExitCheckWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/i$a;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "a", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ExitCheckWorker extends CoroutineWorker {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.wecloud.load.lib.ExitCheckWorker$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            Intrinsics.h(context, "context");
            String l = tx.b.a.b().l("so_load_control_config", (String) null);
            if (l == null || StringsKt.q0(l)) {
                a.a.f(wf.a.a, "ExitCheckWorker", "ExitCheckWorker: MMKV 中无配置，跳过", false, 4, (Object) null);
                return false;
            }
            SoLoadControlConfig soLoadControlConfig = (SoLoadControlConfig) new Gson().fromJson(l, SoLoadControlConfig.class);
            if (soLoadControlConfig == null || !soLoadControlConfig.getExitProcess()) {
                a.a.f(wf.a.a, "ExitCheckWorker", "ExitCheckWorker: exitProcess 为 false，跳过", false, 4, (Object) null);
                return false;
            }
            a.a aVar = wf.a.a;
            a.a.f(aVar, "ExitCheckWorker", "ExitCheckWorker: 检测到 exitProcess 为 true，清空配置并尝试通知 SoLoadService 退出", false, 4, (Object) null);
            DySoLoadManager.a.i(context, HttpUrl.FRAGMENT_ENCODE_SET);
            p pVar = p.a;
            if (!pVar.a()) {
                a.a.f(aVar, "ExitCheckWorker", "ExitCheckWorker: SoLoadService 已停止，跳过", false, 4, (Object) null);
                return false;
            }
            a.a.f(aVar, "ExitCheckWorker", "ExitCheckWorker: SoLoadService 存活，触发退出检查", false, 4, (Object) null);
            pVar.c();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitCheckWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.wecloud.load.lib.ExitCheckWorker$doWork$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object r(Continuation continuation) {
        ?? r0;
        int i;
        if (continuation instanceof ExitCheckWorker$doWork$1) {
            ExitCheckWorker$doWork$1 exitCheckWorker$doWork$1 = (ExitCheckWorker$doWork$1) continuation;
            int i2 = exitCheckWorker$doWork$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                exitCheckWorker$doWork$1.label = i2 - Integer.MIN_VALUE;
                r0 = exitCheckWorker$doWork$1;
                Object obj = r0.result;
                Object f = IntrinsicsKt.f();
                i = r0.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    i0 b = y0.b();
                    ExitCheckWorker$doWork$2 exitCheckWorker$doWork$2 = new ExitCheckWorker$doWork$2(this, null);
                    r0.label = 1;
                    obj = kotlinx.coroutines.i.g(b, exitCheckWorker$doWork$2, r0);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                Intrinsics.g(obj, "withContext(...)");
                return obj;
            }
        }
        r0 = new ExitCheckWorker$doWork$1(this, continuation);
        Object obj2 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
        if (i != 0) {
        }
        Intrinsics.g(obj2, "withContext(...)");
        return obj2;
    }
}
