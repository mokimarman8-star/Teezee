package com.transsion.audio.fragment;

import com.therouter.TheRouter;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$initView$1$3$onPlayItem$1", f = "SubjectListFragment.kt", l = {147}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListFragment$initView$1$3$onPlayItem$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $download;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListFragment$initView$1$3$onPlayItem$1(DownloadItem downloadItem, SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$initView$1$3$onPlayItem$1> continuation) {
        super(2, continuation);
        this.$download = downloadItem;
        this.this$0 = subjectListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$initView$1$3$onPlayItem$1(this.$download, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0027, code lost:
    
        r5 = r31.this$0.v0();
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AudioBean audioBean;
        si.a v0;
        Object c;
        String str;
        String str2;
        String str3;
        String str4;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String url = this.$download.getUrl();
            audioBean = null;
            if (url != null && v0 != null) {
                this.label = 1;
                c = v0.c(url, this);
                if (c == f) {
                    return f;
                }
            }
            if (audioBean != null) {
                String url2 = this.$download.getUrl();
                if (url2 == null) {
                    url2 = BuildConfig.FLAVOR;
                }
                str = this.this$0.subjectCover;
                Long e = Boxing.e(0L);
                Long size = this.$download.getSize();
                String url3 = this.$download.getUrl();
                String name = this.$download.getName();
                Integer d = Boxing.d(0);
                String resourceId = this.$download.getResourceId();
                String postId = this.$download.getPostId();
                str2 = this.this$0.subjectId;
                str3 = this.this$0.groupId;
                str4 = this.this$0.subjectTitle;
                audioBean = new AudioBean(url2, str, e, size, url3, name, BuildConfig.FLAVOR, d, (Long) null, (Long) null, (String) null, BuildConfig.FLAVOR, resourceId, postId, str2, str3, 0, str4, this.$download.getSe(), this.$download.getEp(), 67328, (DefaultConstructorMarker) null);
                this.$download.setStatus(Boxing.d(3));
                ep.a aVar = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar != null) {
                    aVar.d(audioBean, false);
                }
            } else if (!AudioPlayer.i.a().y(audioBean)) {
                Long readProcess = audioBean.getReadProcess();
                long longValue = readProcess != null ? readProcess.longValue() : 0L;
                Long duration = audioBean.getDuration();
                boolean z = longValue >= (duration != null ? duration.longValue() : -500L);
                if (audioBean.getStatus() == 6 || z) {
                    audioBean.setReadProcess(Boxing.e(0L));
                }
                atomicBoolean = this.this$0.mIsStop;
                atomicBoolean.set(false);
                audioBean.setStatus(3);
                this.$download.setStatus(Boxing.d(3));
                ep.a aVar2 = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar2 != null) {
                    aVar2.d(audioBean, false);
                }
            } else if (audioBean.getStatus() == 3) {
                atomicBoolean3 = this.this$0.mIsStop;
                atomicBoolean3.set(true);
                audioBean.setStatus(4);
                this.$download.setStatus(Boxing.d(4));
                ep.a aVar3 = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar3 != null) {
                    aVar3.stop();
                }
            } else {
                atomicBoolean2 = this.this$0.mIsStop;
                atomicBoolean2.set(false);
                audioBean.setStatus(3);
                this.$download.setStatus(Boxing.d(3));
                ep.a aVar4 = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar4 != null) {
                    aVar4.prepare();
                }
            }
            this.this$0.H0(this.$download, audioBean);
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        c = obj;
        audioBean = (AudioBean) c;
        if (audioBean != null) {
        }
        this.this$0.H0(this.$download, audioBean);
        return Unit.a;
    }
}
