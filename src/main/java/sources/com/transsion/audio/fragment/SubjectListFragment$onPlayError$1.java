package com.transsion.audio.fragment;

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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onPlayError$1", f = "SubjectListFragment.kt", l = {412}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$onPlayError$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListFragment$onPlayError$1(SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$onPlayError$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onPlayError$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        r8 = r7.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0075 -> B:5:0x0078). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SubjectListAdapter subjectListAdapter;
        List data;
        int i;
        Iterator it;
        SubjectListFragment subjectListFragment;
        si.a v0;
        SubjectListAdapter subjectListAdapter2;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            subjectListAdapter = this.this$0.mAdapter;
            if (subjectListAdapter == null || (data = subjectListAdapter.getData()) == null) {
                return null;
            }
            SubjectListFragment subjectListFragment2 = this.this$0;
            i = 0;
            it = data.iterator();
            subjectListFragment = subjectListFragment2;
            r1 = i;
            if (!it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$1;
            i = this.I$0;
            DownloadItem downloadItem = (DownloadItem) this.L$2;
            it = (Iterator) this.L$1;
            subjectListFragment = (SubjectListFragment) this.L$0;
            ResultKt.b(obj);
            AudioBean audioBean = (AudioBean) obj;
            if (audioBean != null && audioBean.getStatus() == 3) {
                if (audioBean != null) {
                    audioBean.setStatus(7);
                }
                subjectListAdapter2 = subjectListFragment.mAdapter;
                if (subjectListAdapter2 != null) {
                    subjectListAdapter2.notifyItemChanged(i3, downloadItem);
                }
            }
            i3 = i;
            if (!it.hasNext()) {
                Object next = it.next();
                i = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.u();
                }
                downloadItem = (DownloadItem) next;
                String url = downloadItem.getUrl();
                if (url == null || v0 == null) {
                    audioBean = null;
                    if (audioBean != null) {
                        if (audioBean != null) {
                        }
                        subjectListAdapter2 = subjectListFragment.mAdapter;
                        if (subjectListAdapter2 != null) {
                        }
                    }
                    i3 = i;
                    if (!it.hasNext()) {
                        return Unit.a;
                    }
                } else {
                    this.L$0 = subjectListFragment;
                    this.L$1 = it;
                    this.L$2 = downloadItem;
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.label = 1;
                    obj = v0.c(url, this);
                    if (obj == f) {
                        return f;
                    }
                    AudioBean audioBean2 = (AudioBean) obj;
                    if (audioBean2 != null) {
                    }
                    i3 = i;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
    }
}
