package com.transsion.audio.fragment;

import android.text.TextUtils;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onPrepare$1", f = "SubjectListFragment.kt", l = {356}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$onPrepare$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ gn.e $mediaSource;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListFragment$onPrepare$1(gn.e eVar, SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$onPrepare$1> continuation) {
        super(2, continuation);
        this.$mediaSource = eVar;
        this.this$0 = subjectListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onPrepare$1(this.$mediaSource, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
    
        r11 = r8.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008c -> B:5:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SubjectListAdapter subjectListAdapter;
        List data;
        String str;
        SubjectListFragment subjectListFragment;
        int i;
        Iterator it;
        si.a v0;
        String str2;
        String str3;
        SubjectListAdapter subjectListAdapter2;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.b(obj);
            gn.e eVar = this.$mediaSource;
            String j = eVar != null ? eVar.j() : null;
            subjectListAdapter = this.this$0.mAdapter;
            if (subjectListAdapter == null || (data = subjectListAdapter.getData()) == null) {
                return null;
            }
            str = j;
            subjectListFragment = this.this$0;
            i = 0;
            it = data.iterator();
            if (!it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            int i4 = this.I$0;
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
            a.a aVar = wf.a.a;
            String a = SubjectListFragment.INSTANCE.a();
            str2 = subjectListFragment.previousUrl;
            boolean equals = TextUtils.equals(str2, audioBean != null ? audioBean.getAudioUrl() : null);
            str3 = subjectListFragment.previousUrl;
            a.a.f(aVar, a, "onPrepare forEachIndexed  " + equals + "  previousUrl " + str3 + " url " + (audioBean != null ? audioBean.getAudioUrl() : null), false, 4, (Object) null);
            if (!TextUtils.equals(str, audioBean != null ? audioBean.getAudioUrl() : null)) {
                if (audioBean != null) {
                    audioBean.setStatus(4);
                }
                downloadItem3.setStatus(Boxing.d(4));
                subjectListAdapter2 = subjectListFragment.mAdapter;
                if (subjectListAdapter2 != null) {
                    subjectListAdapter2.notifyItemChanged(i, downloadItem3);
                }
                subjectListFragment.previousUrl = str;
            }
            i = i5;
            i3 = 1;
            if (!it.hasNext()) {
                Object next = it.next();
                i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                downloadItem3 = (DownloadItem) next;
                String url = downloadItem3.getUrl();
                if (url == null || v0 == null) {
                    audioBean = null;
                    a.a aVar2 = wf.a.a;
                    String a2 = SubjectListFragment.INSTANCE.a();
                    str2 = subjectListFragment.previousUrl;
                    boolean equals2 = TextUtils.equals(str2, audioBean != null ? audioBean.getAudioUrl() : null);
                    str3 = subjectListFragment.previousUrl;
                    if (audioBean != null) {
                    }
                    a.a.f(aVar2, a2, "onPrepare forEachIndexed  " + equals2 + "  previousUrl " + str3 + " url " + (audioBean != null ? audioBean.getAudioUrl() : null), false, 4, (Object) null);
                    if (!TextUtils.equals(str, audioBean != null ? audioBean.getAudioUrl() : null)) {
                    }
                    i = i5;
                    i3 = 1;
                    if (!it.hasNext()) {
                        return Unit.a;
                    }
                } else {
                    this.L$0 = str;
                    this.L$1 = subjectListFragment;
                    this.L$2 = it;
                    this.L$3 = downloadItem3;
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
                    a.a aVar22 = wf.a.a;
                    String a22 = SubjectListFragment.INSTANCE.a();
                    str2 = subjectListFragment.previousUrl;
                    boolean equals22 = TextUtils.equals(str2, audioBean2 != null ? audioBean2.getAudioUrl() : null);
                    str3 = subjectListFragment.previousUrl;
                    if (audioBean2 != null) {
                    }
                    a.a.f(aVar22, a22, "onPrepare forEachIndexed  " + equals22 + "  previousUrl " + str3 + " url " + (audioBean2 != null ? audioBean2.getAudioUrl() : null), false, 4, (Object) null);
                    if (!TextUtils.equals(str, audioBean2 != null ? audioBean2.getAudioUrl() : null)) {
                    }
                    i = i52;
                    i3 = 1;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
    }
}
