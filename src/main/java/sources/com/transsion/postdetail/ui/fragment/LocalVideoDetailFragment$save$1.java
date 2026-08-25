package com.transsion.postdetail.ui.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
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
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$save$1", f = "LocalVideoDetailFragment.kt", l = {1545, 1546}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocalVideoDetailFragment$save$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $completed;
    final /* synthetic */ DownloadBean $cvideoBean;
    final /* synthetic */ long $playProgress;
    long J$0;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalVideoDetailFragment$save$1(boolean z, LocalVideoDetailFragment localVideoDetailFragment, long j, DownloadBean downloadBean, Continuation<? super LocalVideoDetailFragment$save$1> continuation) {
        super(2, continuation);
        this.$completed = z;
        this.this$0 = localVideoDetailFragment;
        this.$playProgress = j;
        this.$cvideoBean = downloadBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$save$1(this.$completed, this.this$0, this.$playProgress, this.$cvideoBean, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        DownloadBean downloadBean;
        long j3;
        int i;
        DownloadBean downloadBean2;
        long j4;
        int i2;
        int i3;
        int i4;
        DownloadBean downloadBean3;
        long j5;
        long j6;
        Object t3;
        long j7;
        DownloadBean downloadBean4;
        long j8;
        boolean z;
        DownloadBean downloadBean5;
        boolean z2;
        Object f = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            if (this.$completed) {
                j6 = this.this$0.duration;
                if (j6 > 0) {
                    j = this.this$0.duration;
                    a.a aVar = wf.a.a;
                    String str = this.this$0.TAG;
                    boolean z3 = this.$completed;
                    j2 = this.this$0.duration;
                    long j9 = this.$playProgress;
                    DownloadBean downloadBean6 = this.$cvideoBean;
                    aVar.u(str, "save completed = " + z3 + ", duration = " + j2 + ", playProgress= " + j9 + ", cur epse = " + (downloadBean6 == null ? Boxing.d(downloadBean6.getEpse()) : null) + " ", true);
                    downloadBean = this.$cvideoBean;
                    if (downloadBean != null) {
                        downloadBean.setReadProgress(j);
                    }
                    j3 = this.this$0.duration;
                    if (j3 > 0 && (downloadBean3 = this.$cvideoBean) != null) {
                        j5 = this.this$0.duration;
                        downloadBean3.setDuration(Boxing.e(j5));
                    }
                    i = this.this$0.videoHeight;
                    if (i > 0) {
                        i2 = this.this$0.videoWidth;
                        if (i2 > 0) {
                            DownloadBean downloadBean7 = this.$cvideoBean;
                            if (downloadBean7 != null) {
                                i4 = this.this$0.videoWidth;
                                downloadBean7.setVideoWidth(i4);
                            }
                            DownloadBean downloadBean8 = this.$cvideoBean;
                            if (downloadBean8 != null) {
                                i3 = this.this$0.videoHeight;
                                downloadBean8.setVideoHeight(i3);
                            }
                        }
                    }
                    downloadBean2 = this.$cvideoBean;
                    if (downloadBean2 != null) {
                        downloadBean2.setLastPlayTimeStamp(System.currentTimeMillis());
                    }
                    if (this.$cvideoBean != null) {
                        j4 = j;
                        downloadBean4 = this.$cvideoBean;
                        if (downloadBean4 != null) {
                        }
                        String str2 = BuildConfig.FLAVOR;
                        String str3 = str2;
                        j8 = this.this$0.duration;
                        z = this.this$0.isSeries;
                        LocalVideoEvent localVideoEvent = new LocalVideoEvent(str3, j4, j8, z, false, 16, (DefaultConstructorMarker) null);
                        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                        FlowEventBus applicationScopeViewModel = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                        String name = LocalVideoEvent.class.getName();
                        Intrinsics.g(name, "getName(...)");
                        applicationScopeViewModel.postEvent(name, localVideoEvent, 0L);
                        downloadBean5 = this.$cvideoBean;
                        z2 = false;
                        if (downloadBean5 != null) {
                            z2 = true;
                        }
                        yw.e eVar = new yw.e(true, z2);
                        FlowEventBus applicationScopeViewModel2 = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                        String name2 = yw.e.class.getName();
                        Intrinsics.g(name2, "getName(...)");
                        applicationScopeViewModel2.postEvent(name2, eVar, 0L);
                        return Unit.a;
                    }
                    a.a.f(aVar, this.this$0.TAG, "---------update name = " + this.$cvideoBean.getName() + " , playProgress = " + j, false, 4, (Object) null);
                    DownloadEsHelper a = DownloadEsHelper.m.a();
                    DownloadBean downloadBean9 = this.$cvideoBean;
                    this.J$0 = j;
                    this.label = 1;
                    if (a.b0(downloadBean9, this) == f) {
                        return f;
                    }
                }
            }
            j = this.$playProgress;
            a.a aVar2 = wf.a.a;
            String str4 = this.this$0.TAG;
            boolean z32 = this.$completed;
            j2 = this.this$0.duration;
            long j92 = this.$playProgress;
            DownloadBean downloadBean62 = this.$cvideoBean;
            if (downloadBean62 == null) {
            }
            aVar2.u(str4, "save completed = " + z32 + ", duration = " + j2 + ", playProgress= " + j92 + ", cur epse = " + (downloadBean62 == null ? Boxing.d(downloadBean62.getEpse()) : null) + " ", true);
            downloadBean = this.$cvideoBean;
            if (downloadBean != null) {
            }
            j3 = this.this$0.duration;
            if (j3 > 0) {
                j5 = this.this$0.duration;
                downloadBean3.setDuration(Boxing.e(j5));
            }
            i = this.this$0.videoHeight;
            if (i > 0) {
            }
            downloadBean2 = this.$cvideoBean;
            if (downloadBean2 != null) {
            }
            if (this.$cvideoBean != null) {
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j7 = this.J$0;
                ResultKt.b(obj);
                j4 = j7;
                downloadBean4 = this.$cvideoBean;
                if (downloadBean4 != null || (str2 = downloadBean4.getResourceId()) == null) {
                    String str22 = BuildConfig.FLAVOR;
                }
                String str32 = str22;
                j8 = this.this$0.duration;
                z = this.this$0.isSeries;
                LocalVideoEvent localVideoEvent2 = new LocalVideoEvent(str32, j4, j8, z, false, 16, (DefaultConstructorMarker) null);
                AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
                FlowEventBus applicationScopeViewModel3 = appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                String name3 = LocalVideoEvent.class.getName();
                Intrinsics.g(name3, "getName(...)");
                applicationScopeViewModel3.postEvent(name3, localVideoEvent2, 0L);
                downloadBean5 = this.$cvideoBean;
                z2 = false;
                if (downloadBean5 != null && downloadBean5.isOutside()) {
                    z2 = true;
                }
                yw.e eVar2 = new yw.e(true, z2);
                FlowEventBus applicationScopeViewModel22 = appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                String name22 = yw.e.class.getName();
                Intrinsics.g(name22, "getName(...)");
                applicationScopeViewModel22.postEvent(name22, eVar2, 0L);
                return Unit.a;
            }
            j = this.J$0;
            ResultKt.b(obj);
        }
        LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
        DownloadBean downloadBean10 = this.$cvideoBean;
        this.J$0 = j;
        this.label = 2;
        t3 = localVideoDetailFragment.t3(downloadBean10, this);
        if (t3 == f) {
            return f;
        }
        j7 = j;
        j4 = j7;
        downloadBean4 = this.$cvideoBean;
        if (downloadBean4 != null) {
        }
        String str222 = BuildConfig.FLAVOR;
        String str322 = str222;
        j8 = this.this$0.duration;
        z = this.this$0.isSeries;
        LocalVideoEvent localVideoEvent22 = new LocalVideoEvent(str322, j4, j8, z, false, 16, (DefaultConstructorMarker) null);
        AppScopeVMlProvider appScopeVMlProvider22 = AppScopeVMlProvider.INSTANCE;
        FlowEventBus applicationScopeViewModel32 = appScopeVMlProvider22.getApplicationScopeViewModel(FlowEventBus.class);
        String name32 = LocalVideoEvent.class.getName();
        Intrinsics.g(name32, "getName(...)");
        applicationScopeViewModel32.postEvent(name32, localVideoEvent22, 0L);
        downloadBean5 = this.$cvideoBean;
        z2 = false;
        if (downloadBean5 != null) {
        }
        yw.e eVar22 = new yw.e(true, z2);
        FlowEventBus applicationScopeViewModel222 = appScopeVMlProvider22.getApplicationScopeViewModel(FlowEventBus.class);
        String name222 = yw.e.class.getName();
        Intrinsics.g(name222, "getName(...)");
        applicationScopeViewModel222.postEvent(name222, eVar22, 0L);
        return Unit.a;
    }
}
