package com.transsion.lib_web.download_render;

import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import pl.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.download_render.FileDownloadTaskManager$startDownloadExecution$1", f = "FileDownloadTaskManager.kt", l = {257}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileDownloadTaskManager$startDownloadExecution$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    FileDownloadTaskManager$startDownloadExecution$1(Continuation<? super FileDownloadTaskManager$startDownloadExecution$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDownloadTaskManager$startDownloadExecution$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:8:0x003c, B:10:0x0053), top: B:7:0x003c, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #2 {all -> 0x0019, blocks: (B:6:0x0015, B:11:0x0065, B:13:0x006a, B:19:0x0081, B:20:0x002d, B:26:0x0085, B:27:0x0088, B:31:0x0026, B:8:0x003c, B:10:0x0053), top: B:2:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[Catch: all -> 0x0019, TRY_ENTER, TryCatch #2 {all -> 0x0019, blocks: (B:6:0x0015, B:11:0x0065, B:13:0x006a, B:19:0x0081, B:20:0x002d, B:26:0x0085, B:27:0x0088, B:31:0x0026, B:8:0x003c, B:10:0x0053), top: B:2:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0039 -> B:7:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        kotlinx.coroutines.sync.a aVar;
        LinkedHashMap linkedHashMap;
        Map.Entry entry;
        tl.a aVar2;
        LinkedHashMap linkedHashMap2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            try {
                h hVar = h.a;
                hVar.b("DR_FileDownloadTaskManager", "<startDownloadExecution> fail: " + th2);
                hVar.a("DR_FileDownloadTaskManager", "<startDownloadExecution> 设置下载状态为false");
            } catch (Throwable th3) {
                h.a.a("DR_FileDownloadTaskManager", "<startDownloadExecution> 设置下载状态为false");
                atomicBoolean = FileDownloadTaskManager.h;
                atomicBoolean.set(false);
                com.transsion.lib_web.download_render.utils.a.a.b();
                throw th3;
            }
        }
        if (i == 0) {
            ResultKt.b(obj);
            h.a.a("DR_FileDownloadTaskManager", "<startDownloadExecution> 执行下载任务");
            aVar = FileDownloadTaskManager.d;
            this.L$0 = aVar;
            this.label = 1;
            if (aVar.f((Object) null, this) == f) {
            }
            linkedHashMap = FileDownloadTaskManager.g;
            Set entrySet = linkedHashMap.entrySet();
            Intrinsics.g(entrySet, "<get-entries>(...)");
            entry = (Map.Entry) CollectionsKt.j0(entrySet);
            if (entry != null) {
            }
            if (aVar2 == null) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.b(obj);
            try {
                linkedHashMap = FileDownloadTaskManager.g;
                Set entrySet2 = linkedHashMap.entrySet();
                Intrinsics.g(entrySet2, "<get-entries>(...)");
                entry = (Map.Entry) CollectionsKt.j0(entrySet2);
                if (entry != null) {
                    linkedHashMap2 = FileDownloadTaskManager.g;
                    aVar2 = (tl.a) linkedHashMap2.remove(entry.getKey());
                } else {
                    aVar2 = null;
                }
                if (aVar2 == null) {
                    h hVar2 = h.a;
                    hVar2.f("DR_FileDownloadTaskManager", "<startDownloadExecution> get fileDownloadTask is null, finish all downlaodTask");
                    hVar2.a("DR_FileDownloadTaskManager", "<startDownloadExecution> 设置下载状态为false");
                    atomicBoolean2 = FileDownloadTaskManager.h;
                    atomicBoolean2.set(false);
                    com.transsion.lib_web.download_render.utils.a.a.b();
                    return Unit.a;
                }
                aVar2.c();
                aVar = FileDownloadTaskManager.d;
                this.L$0 = aVar;
                this.label = 1;
                if (aVar.f((Object) null, this) == f) {
                    return f;
                }
                linkedHashMap = FileDownloadTaskManager.g;
                Set entrySet22 = linkedHashMap.entrySet();
                Intrinsics.g(entrySet22, "<get-entries>(...)");
                entry = (Map.Entry) CollectionsKt.j0(entrySet22);
                if (entry != null) {
                }
                if (aVar2 == null) {
                }
            } finally {
                aVar.unlock((Object) null);
            }
        }
    }
}
