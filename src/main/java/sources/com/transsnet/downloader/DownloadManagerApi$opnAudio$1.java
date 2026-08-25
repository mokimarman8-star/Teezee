package com.transsnet.downloader;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import ep.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$opnAudio$1", f = "DownloadManagerApi.kt", l = {945, 945}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerApi$opnAudio$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerApi$opnAudio$1(DownloadManagerApi downloadManagerApi, Context context, Continuation<? super DownloadManagerApi$opnAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerApi;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$opnAudio$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$opnAudio$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AppCompatActivity appCompatActivity;
        Object d;
        AudioBean audioBean;
        Object c;
        AppCompatActivity appCompatActivity2;
        ep.b C;
        ep.a B;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (DownloadManagerApi.w(this.this$0) == null) {
                return Unit.a;
            }
            AppCompatActivity appCompatActivity3 = this.$context;
            appCompatActivity = appCompatActivity3 instanceof AppCompatActivity ? appCompatActivity3 : null;
            if (appCompatActivity == null) {
                return Unit.a;
            }
            com.transsnet.downloader.manager.g z = DownloadManagerApi.z(this.this$0);
            DownloadBean w = DownloadManagerApi.w(this.this$0);
            Intrinsics.e(w);
            z.l(w);
            si.a v = DownloadManagerApi.v(this.this$0);
            DownloadBean w2 = DownloadManagerApi.w(this.this$0);
            Intrinsics.e(w2);
            String resourceId = w2.getResourceId();
            if (resourceId == null) {
                DownloadBean w3 = DownloadManagerApi.w(this.this$0);
                Intrinsics.e(w3);
                resourceId = w3.getUrl();
            }
            this.L$0 = appCompatActivity;
            this.label = 1;
            d = v.d(resourceId, this);
            if (d == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appCompatActivity2 = (AppCompatActivity) this.L$0;
                ResultKt.b(obj);
                c = obj;
                audioBean = (AudioBean) c;
                appCompatActivity = appCompatActivity2;
                if (audioBean == null) {
                    DownloadBean w4 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w4);
                    String url = w4.getUrl();
                    DownloadBean w5 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w5);
                    String cover = w5.getCover();
                    Long e = Boxing.e(0L);
                    DownloadBean w6 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w6);
                    Long size = w6.getSize();
                    DownloadBean w7 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w7);
                    String url2 = w7.getUrl();
                    DownloadBean w8 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w8);
                    String name = w8.getName();
                    DownloadBean w9 = DownloadManagerApi.w(this.this$0);
                    int se = w9 != null ? w9.getSe() : 0;
                    DownloadBean w10 = DownloadManagerApi.w(this.this$0);
                    audioBean = new AudioBean(url, cover, e, size, url2, name, (String) null, (Integer) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, se, w10 != null ? w10.getEp() : 0, 262080, (DefaultConstructorMarker) null);
                    DownloadBean w11 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w11);
                    audioBean.setPostId(w11.getPostId());
                    DownloadBean w12 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w12);
                    audioBean.setResourceId(w12.getResourceId());
                    DownloadBean w13 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w13);
                    audioBean.setSubjectId(w13.getSubjectId());
                    DownloadBean w14 = DownloadManagerApi.w(this.this$0);
                    Intrinsics.e(w14);
                    audioBean.setGroupId(w14.getGroupId());
                }
                C = DownloadManagerApi.C(this.this$0);
                if (C != null) {
                    C.a(new WeakReference(appCompatActivity), audioBean);
                }
                B = DownloadManagerApi.B(this.this$0);
                if (B != null) {
                    a.a.a(B, audioBean, false, 2, (Object) null);
                }
                return Unit.a;
            }
            appCompatActivity = (AppCompatActivity) this.L$0;
            ResultKt.b(obj);
            d = obj;
        }
        audioBean = (AudioBean) d;
        if (audioBean == null) {
            si.a v2 = DownloadManagerApi.v(this.this$0);
            DownloadBean w15 = DownloadManagerApi.w(this.this$0);
            Intrinsics.e(w15);
            String url3 = w15.getUrl();
            this.L$0 = appCompatActivity;
            this.label = 2;
            c = v2.c(url3, this);
            if (c == f) {
                return f;
            }
            appCompatActivity2 = appCompatActivity;
            audioBean = (AudioBean) c;
            appCompatActivity = appCompatActivity2;
        }
        if (audioBean == null) {
        }
        C = DownloadManagerApi.C(this.this$0);
        if (C != null) {
        }
        B = DownloadManagerApi.B(this.this$0);
        if (B != null) {
        }
        return Unit.a;
    }
}
