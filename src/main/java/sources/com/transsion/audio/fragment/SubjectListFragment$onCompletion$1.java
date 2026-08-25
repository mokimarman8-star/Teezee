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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onCompletion$1", f = "SubjectListFragment.kt", l = {428}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$onCompletion$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
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
    SubjectListFragment$onCompletion$1(gn.e eVar, SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$onCompletion$1> continuation) {
        super(2, continuation);
        this.$mediaSource = eVar;
        this.this$0 = subjectListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onCompletion$1(this.$mediaSource, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        r9 = r7.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0086 -> B:5:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SubjectListAdapter subjectListAdapter;
        List data;
        String str;
        Iterator it;
        SubjectListFragment subjectListFragment;
        int i;
        si.a v0;
        SubjectListAdapter subjectListAdapter2;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            gn.e eVar = this.$mediaSource;
            String j = eVar != null ? eVar.j() : null;
            subjectListAdapter = this.this$0.mAdapter;
            if (subjectListAdapter == null || (data = subjectListAdapter.getData()) == null) {
                return null;
            }
            SubjectListFragment subjectListFragment2 = this.this$0;
            str = j;
            it = data.iterator();
            subjectListFragment = subjectListFragment2;
            i = 0;
            if (!it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            int i3 = this.I$0;
            DownloadItem downloadItem = (DownloadItem) this.L$3;
            it = (Iterator) this.L$2;
            subjectListFragment = (SubjectListFragment) this.L$1;
            str = (String) this.L$0;
            ResultKt.b(obj);
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.equals(str, audioBean != null ? audioBean.getAudioUrl() : null)) {
                if (audioBean != null) {
                    audioBean.setStatus(6);
                }
                downloadItem.setStatus(Boxing.d(6));
                subjectListAdapter2 = subjectListFragment.mAdapter;
                if (subjectListAdapter2 != null) {
                    subjectListAdapter2.notifyItemChanged(i, downloadItem);
                }
                subjectListFragment.previousUrl = str;
            }
            i = i3;
            if (!it.hasNext()) {
                Object next = it.next();
                i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                downloadItem = (DownloadItem) next;
                String url = downloadItem.getUrl();
                if (url == null || v0 == null) {
                    audioBean = null;
                    if (TextUtils.equals(str, audioBean != null ? audioBean.getAudioUrl() : null)) {
                    }
                    i = i3;
                    if (!it.hasNext()) {
                        return Unit.a;
                    }
                } else {
                    this.L$0 = str;
                    this.L$1 = subjectListFragment;
                    this.L$2 = it;
                    this.L$3 = downloadItem;
                    this.I$0 = i3;
                    this.I$1 = i;
                    this.label = 1;
                    obj = v0.c(url, this);
                    if (obj == f) {
                        return f;
                    }
                    AudioBean audioBean2 = (AudioBean) obj;
                    if (TextUtils.equals(str, audioBean2 != null ? audioBean2.getAudioUrl() : null)) {
                    }
                    i = i3;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
    }
}
