package com.transsion.lib_web.download_render;

import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.PageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import pl.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.download_render.FileDownloadTaskManager$executeTask$2$1", f = "FileDownloadTaskManager.kt", l = {130}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileDownloadTaskManager$executeTask$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PageData> $pages;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileDownloadTaskManager$executeTask$2$1(List<PageData> list, Continuation<? super FileDownloadTaskManager$executeTask$2$1> continuation) {
        super(2, continuation);
        this.$pages = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDownloadTaskManager$executeTask$2$1(this.$pages, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object m;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                h.a.a("DR_FileDownloadTaskManager", "<executeTask> start");
                FileDownloadTaskManager fileDownloadTaskManager = FileDownloadTaskManager.a;
                List<PageData> list = this.$pages;
                this.label = 1;
                m = fileDownloadTaskManager.m(list, this);
                if (m == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Throwable unused) {
        }
        return Unit.a;
    }
}
