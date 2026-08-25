package com.transsion.lib_web.download_render;

import android.app.Application;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.init.ConfigTask;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import qi.h;
import qi.i;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.download_render.FileDownloadTaskManager$init$1", f = "FileDownloadTaskManager.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileDownloadTaskManager$init$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $api;
    final /* synthetic */ boolean $athenaIsDebug;
    final /* synthetic */ Application $context;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileDownloadTaskManager$init$1(String str, Application application, boolean z, i iVar, Continuation<? super FileDownloadTaskManager$init$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$context = application;
        this.$athenaIsDebug = z;
        this.$api = iVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDownloadTaskManager$init$1(this.$path, this.$context, this.$athenaIsDebug, this.$api, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            FileRemoteDataManager.a.l(this.$path);
            MMKV.C(this.$context);
            h hVar = h.a;
            Application application = this.$context;
            boolean z = this.$athenaIsDebug;
            i iVar = this.$api;
            String packageName = application.getPackageName();
            Intrinsics.g(packageName, "getPackageName(...)");
            hVar.j(application, z, iVar, packageName, 2337, (r20 & 32) != 0, (r20 & 64) != 0 ? null : null, (r20 & 128) != 0 ? false : false);
            list = FileDownloadTaskManager.k;
            list.add(new ConfigTask());
            list2 = FileDownloadTaskManager.k;
            list2.add(new com.transsion.lib_web.download_render.init.d(this.$context));
            list3 = FileDownloadTaskManager.k;
            list3.add(new com.transsion.lib_web.download_render.init.e());
            list4 = FileDownloadTaskManager.k;
            list4.add(new com.transsion.lib_web.download_render.init.a());
            list5 = FileDownloadTaskManager.k;
            list5.add(new com.transsion.lib_web.download_render.init.b());
            list6 = FileDownloadTaskManager.k;
            Iterator it = list6.iterator();
            while (it.hasNext()) {
                ((com.transsion.lib_web.download_render.init.c) it.next()).invoke();
            }
            FileRemoteDataManager.a.m();
        } catch (Throwable th2) {
            pl.h.a.f("DR_FileDownloadTaskManager", "<init> fail:" + th2);
        }
        return Unit.a;
    }
}
