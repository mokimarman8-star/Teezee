package com.transsnet.downloader;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/baselib/db/download/DownloadBean;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$fetchLatestDownloadData$2", f = "DownloadManagerApi.kt", l = {108, Sdk$SDKError.Reason.TEMPLATE_UNZIP_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerApi$fetchLatestDownloadData$2 extends SuspendLambda implements Function2<n0, Continuation<? super Pair<? extends Integer, ? extends List<? extends DownloadBean>>>, Object> {
    Object L$0;
    int label;

    DownloadManagerApi$fetchLatestDownloadData$2(Continuation<? super DownloadManagerApi$fetchLatestDownloadData$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$fetchLatestDownloadData$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Pair<Integer, ? extends List<? extends DownloadBean>>> continuation) {
        return ((DownloadManagerApi$fetchLatestDownloadData$2) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadListManager a = DownloadListManager.m.a();
            this.label = 1;
            obj = a.J(3, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.b(obj);
                List list2 = (List) obj;
                Integer d = Boxing.d(list2 == null ? list2.size() : 0);
                if (list == null) {
                    list = new ArrayList();
                }
                return new Pair(d, list);
            }
            ResultKt.b(obj);
        }
        List list3 = (List) obj;
        DownloadListManager a2 = DownloadListManager.m.a();
        this.L$0 = list3;
        this.label = 2;
        Object O = a2.O(this);
        if (O == f) {
            return f;
        }
        list = list3;
        obj = O;
        List list22 = (List) obj;
        Integer d2 = Boxing.d(list22 == null ? list22.size() : 0);
        if (list == null) {
        }
        return new Pair(d2, list);
    }
}
