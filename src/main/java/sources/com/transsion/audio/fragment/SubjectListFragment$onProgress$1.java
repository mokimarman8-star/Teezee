package com.transsion.audio.fragment;

import android.text.TextUtils;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onProgress$1", f = "SubjectListFragment.kt", l = {378}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$onProgress$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ gn.e $mediaSource;
    final /* synthetic */ long $progress;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListFragment$onProgress$1(gn.e eVar, SubjectListFragment subjectListFragment, long j, Continuation<? super SubjectListFragment$onProgress$1> continuation) {
        super(2, continuation);
        this.$mediaSource = eVar;
        this.this$0 = subjectListFragment;
        this.$progress = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onProgress$1(this.$mediaSource, this.this$0, this.$progress, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0076, code lost:
    
        r14 = r11.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0093 -> B:5:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SubjectListAdapter subjectListAdapter;
        List data;
        String str;
        Iterator it;
        SubjectListFragment subjectListFragment;
        long j;
        int i;
        si.a v0;
        String str2;
        String str3;
        boolean z;
        AtomicBoolean atomicBoolean;
        SubjectListAdapter subjectListAdapter2;
        SubjectListAdapter subjectListAdapter3;
        String str4;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.b(obj);
            gn.e eVar = this.$mediaSource;
            String j2 = eVar != null ? eVar.j() : null;
            subjectListAdapter = this.this$0.mAdapter;
            if (subjectListAdapter == null || (data = subjectListAdapter.getData()) == null) {
                return null;
            }
            SubjectListFragment subjectListFragment2 = this.this$0;
            long j3 = this.$progress;
            str = j2;
            it = data.iterator();
            subjectListFragment = subjectListFragment2;
            j = j3;
            i = 0;
            if (!it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            int i4 = this.I$0;
            j = this.J$0;
            DownloadItem downloadItem = (DownloadItem) this.L$3;
            it = (Iterator) this.L$2;
            subjectListFragment = (SubjectListFragment) this.L$1;
            str = (String) this.L$0;
            ResultKt.b(obj);
            Object c = obj;
            AudioBean audioBean = (AudioBean) c;
            DownloadItem downloadItem2 = downloadItem;
            int i5 = i4;
            DownloadItem downloadItem3 = downloadItem2;
            str2 = subjectListFragment.previousUrl;
            if (TextUtils.isEmpty(str2)) {
                subjectListFragment.previousUrl = str;
            }
            str3 = subjectListFragment.previousUrl;
            if (!TextUtils.equals(str3, str)) {
                str4 = subjectListFragment.previousUrl;
                if (TextUtils.equals(str4, audioBean != null ? audioBean.getAudioUrl() : null)) {
                    z = i3;
                    a.a.f(wf.a.a, SubjectListFragment.INSTANCE.a(), "STATUS_PAUSED  index " + i + " needPause " + z, false, 4, (Object) null);
                    if (z != 0) {
                        if (audioBean != null) {
                            audioBean.setStatus(4);
                        }
                        downloadItem3.setStatus(Boxing.d(4));
                        subjectListAdapter3 = subjectListFragment.mAdapter;
                        if (subjectListAdapter3 != null) {
                            subjectListAdapter3.notifyItemChanged(i, downloadItem3);
                        }
                        subjectListFragment.previousUrl = str;
                    }
                    if (TextUtils.equals(str, audioBean == null ? audioBean.getAudioUrl() : null)) {
                        atomicBoolean = subjectListFragment.mIsStop;
                        if (!atomicBoolean.get()) {
                            if (audioBean != null) {
                                audioBean.setReadProcess(Boxing.e(j));
                            }
                            if (audioBean != null) {
                                audioBean.setStatus(3);
                            }
                            downloadItem3.setStatus(Boxing.d(3));
                            subjectListAdapter2 = subjectListFragment.mAdapter;
                            if (subjectListAdapter2 != null) {
                                subjectListAdapter2.notifyItemChanged(i, downloadItem3);
                            }
                        }
                    }
                    i = i5;
                    i3 = 1;
                    if (!it.hasNext()) {
                        return Unit.a;
                    }
                    Object next = it.next();
                    i5 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    downloadItem3 = (DownloadItem) next;
                    String url = downloadItem3.getUrl();
                    if (url == null || v0 == null) {
                        audioBean = null;
                        str2 = subjectListFragment.previousUrl;
                        if (TextUtils.isEmpty(str2)) {
                        }
                        str3 = subjectListFragment.previousUrl;
                        if (!TextUtils.equals(str3, str)) {
                        }
                    } else {
                        this.L$0 = str;
                        this.L$1 = subjectListFragment;
                        this.L$2 = it;
                        this.L$3 = downloadItem3;
                        this.J$0 = j;
                        this.I$0 = i5;
                        this.I$1 = i;
                        this.label = i3;
                        c = v0.c(url, this);
                        if (c == f) {
                            return f;
                        }
                        downloadItem = downloadItem3;
                        i4 = i5;
                        AudioBean audioBean2 = (AudioBean) c;
                        DownloadItem downloadItem22 = downloadItem;
                        int i52 = i4;
                        DownloadItem downloadItem32 = downloadItem22;
                        str2 = subjectListFragment.previousUrl;
                        if (TextUtils.isEmpty(str2)) {
                        }
                        str3 = subjectListFragment.previousUrl;
                        if (!TextUtils.equals(str3, str)) {
                        }
                    }
                }
            }
            z = 0;
            a.a.f(wf.a.a, SubjectListFragment.INSTANCE.a(), "STATUS_PAUSED  index " + i + " needPause " + z, false, 4, (Object) null);
            if (z != 0) {
            }
            if (TextUtils.equals(str, audioBean2 == null ? audioBean2.getAudioUrl() : null)) {
            }
            i = i52;
            i3 = 1;
            if (!it.hasNext()) {
            }
        }
    }
}
