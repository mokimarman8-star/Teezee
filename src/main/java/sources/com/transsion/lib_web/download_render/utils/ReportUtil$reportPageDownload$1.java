package com.transsion.lib_web.download_render.utils;

import android.os.Bundle;
import com.blankj.utilcode.util.o;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import qi.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.download_render.utils.ReportUtil$reportPageDownload$1", f = "ReportUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ReportUtil$reportPageDownload$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $copyFiles;
    final /* synthetic */ long $costTime;
    final /* synthetic */ int $deleteFiles;
    final /* synthetic */ long $downloadFileSize;
    final /* synthetic */ int $downloadFiles;
    final /* synthetic */ int $downloadedFiles;
    final /* synthetic */ boolean $isInterceptor;
    final /* synthetic */ long $totalFileSize;
    final /* synthetic */ int $totalFiles;
    final /* synthetic */ String $url;
    final /* synthetic */ String $versionCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReportUtil$reportPageDownload$1(String str, String str2, int i, int i2, int i3, int i4, long j, boolean z, int i5, long j2, long j3, Continuation<? super ReportUtil$reportPageDownload$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$versionCode = str2;
        this.$deleteFiles = i;
        this.$copyFiles = i2;
        this.$downloadFiles = i3;
        this.$totalFiles = i4;
        this.$costTime = j;
        this.$isInterceptor = z;
        this.$downloadedFiles = i5;
        this.$totalFileSize = j2;
        this.$downloadFileSize = j3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportUtil$reportPageDownload$1(this.$url, this.$versionCode, this.$deleteFiles, this.$copyFiles, this.$downloadFiles, this.$totalFiles, this.$costTime, this.$isInterceptor, this.$downloadedFiles, this.$totalFileSize, this.$downloadFileSize, continuation);
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
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.$url;
        String str2 = this.$versionCode;
        int i = this.$deleteFiles;
        int i2 = this.$copyFiles;
        int i3 = this.$downloadFiles;
        int i4 = this.$totalFiles;
        long j = this.$costTime;
        boolean z = this.$isInterceptor;
        int i5 = this.$downloadedFiles;
        long j2 = this.$totalFileSize;
        long j3 = this.$downloadFileSize;
        linkedHashMap.put("url", str);
        linkedHashMap.put("version", str2);
        linkedHashMap.put("rfs", Boxing.d(i));
        linkedHashMap.put("cfs", Boxing.d(i2));
        linkedHashMap.put("dfs", Boxing.d(i3));
        linkedHashMap.put("tfs", Boxing.d(i4));
        linkedHashMap.put("ct", Boxing.e(j));
        linkedHashMap.put("intercept", Boxing.a(z));
        linkedHashMap.put("dedfs", Boxing.d(i5));
        linkedHashMap.put("tfsize", Boxing.e(j2));
        linkedHashMap.put("dedfsize", Boxing.e(j3));
        Bundle bundle = new Bundle();
        bundle.putString("ext", o.j(linkedHashMap));
        h.a.g("files_download", bundle, 2337);
        return Unit.a;
    }
}
