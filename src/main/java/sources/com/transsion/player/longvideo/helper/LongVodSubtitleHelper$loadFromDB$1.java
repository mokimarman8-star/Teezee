package com.transsion.player.longvideo.helper;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.subtitle.VideoSubtitleControl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1", f = "LongVodSubtitleHelper.kt", l = {186, 189, 193, 201}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodSubtitleHelper$loadFromDB$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LongVodSubtitleHelper this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$3", f = "LongVodSubtitleHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $bean;
        final /* synthetic */ List<ht.a> $list;
        int label;
        final /* synthetic */ LongVodSubtitleHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<ht.a> list, LongVodSubtitleHelper longVodSubtitleHelper, DownloadBean downloadBean, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = longVodSubtitleHelper;
            this.$bean = downloadBean;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$list, this.this$0, this.$bean, continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            List list;
            List list2;
            VideoSubtitleControl videoSubtitleControl;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<ht.a> list3 = this.$list;
            if (list3 != null && !list3.isEmpty()) {
                list = this.this$0.g;
                list.clear();
                list2 = this.this$0.g;
                list2.addAll(this.$list);
                videoSubtitleControl = this.this$0.h;
                videoSubtitleControl.f0(this.$list);
            }
            if (yg.l.a.e()) {
                this.this$0.F(this.$bean);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodSubtitleHelper$loadFromDB$1(DownloadBean downloadBean, LongVodSubtitleHelper longVodSubtitleHelper, Continuation<? super LongVodSubtitleHelper$loadFromDB$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
        this.this$0 = longVodSubtitleHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodSubtitleHelper$loadFromDB$1(this.$bean, this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        VideoDetailPlayDao O;
        List list2;
        DownloadBean downloadBean;
        UGCVideoDetailPlayDao N;
        DownloadBean downloadBean2;
        w wVar;
        a2 c;
        AnonymousClass3 anonymousClass3;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            com.transsion.subtitle.h b = com.transsion.subtitle.h.a.b();
            String subtitleResId = this.$bean.getSubtitleResId();
            this.label = 1;
            obj = b.a(subtitleResId, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    downloadBean2 = (DownloadBean) this.L$1;
                    list2 = (List) this.L$0;
                    ResultKt.b(obj);
                    UGCVideoDetailPlayBean uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                    downloadBean2.setSubtitleSelectId(uGCVideoDetailPlayBean == null ? uGCVideoDetailPlayBean.getSubtitleSelectId() : null);
                    list = list2;
                    wVar = this.this$0.d;
                    wVar.f(this.$bean.getSubtitleSelectId());
                    if (list != null) {
                    }
                    a.a.f(wf.a.a, LongVodPlayerView.TAG, "loadFromDB ,isUGCVideo:" + this.$bean.isUGCVideo() + ",subtitleSelectId:" + this.$bean.getSubtitleSelectId() + ", subjectId:" + this.$bean.getSubjectId() + ", id:" + this.$bean.getSubtitleResId() + ", size:" + (list != null ? Boxing.d(list.size()) : null), false, 4, (Object) null);
                    c = y0.c();
                    anonymousClass3 = new AnonymousClass3(list, this.this$0, this.$bean, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 4;
                    if (kotlinx.coroutines.i.g(c, anonymousClass3, this) == f) {
                    }
                    return Unit.a;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                downloadBean = (DownloadBean) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.b(obj);
                VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) obj;
                downloadBean.setSubtitleSelectId(videoDetailPlayBean == null ? videoDetailPlayBean.getSubtitleSelectId() : null);
                list = list2;
                wVar = this.this$0.d;
                wVar.f(this.$bean.getSubtitleSelectId());
                a.a.f(wf.a.a, LongVodPlayerView.TAG, "loadFromDB ,isUGCVideo:" + this.$bean.isUGCVideo() + ",subtitleSelectId:" + this.$bean.getSubtitleSelectId() + ", subjectId:" + this.$bean.getSubjectId() + ", id:" + this.$bean.getSubtitleResId() + ", size:" + (list != null ? Boxing.d(list.size()) : null), false, 4, (Object) null);
                c = y0.c();
                anonymousClass3 = new AnonymousClass3(list, this.this$0, this.$bean, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
                if (kotlinx.coroutines.i.g(c, anonymousClass3, this) == f) {
                    return f;
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        list = (List) obj;
        if (this.$bean.isUGCVideo()) {
            String ugcVideoCollectionId = this.$bean.getUgcVideoCollectionId();
            if (ugcVideoCollectionId != null) {
                DownloadBean downloadBean3 = this.$bean;
                N = this.this$0.N();
                this.L$0 = list;
                this.L$1 = downloadBean3;
                this.label = 2;
                Object c2 = N.c(ugcVideoCollectionId, this);
                if (c2 == f) {
                    return f;
                }
                list2 = list;
                obj = c2;
                downloadBean2 = downloadBean3;
                UGCVideoDetailPlayBean uGCVideoDetailPlayBean2 = (UGCVideoDetailPlayBean) obj;
                downloadBean2.setSubtitleSelectId(uGCVideoDetailPlayBean2 == null ? uGCVideoDetailPlayBean2.getSubtitleSelectId() : null);
                list = list2;
            }
        } else {
            String subjectId = this.$bean.getSubjectId();
            if (subjectId != null) {
                DownloadBean downloadBean4 = this.$bean;
                O = this.this$0.O();
                this.L$0 = list;
                this.L$1 = downloadBean4;
                this.label = 3;
                Object c3 = O.c(subjectId, this);
                if (c3 == f) {
                    return f;
                }
                list2 = list;
                obj = c3;
                downloadBean = downloadBean4;
                VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) obj;
                downloadBean.setSubtitleSelectId(videoDetailPlayBean2 == null ? videoDetailPlayBean2.getSubtitleSelectId() : null);
                list = list2;
            }
        }
        wVar = this.this$0.d;
        wVar.f(this.$bean.getSubtitleSelectId());
        if (list != null) {
        }
        a.a.f(wf.a.a, LongVodPlayerView.TAG, "loadFromDB ,isUGCVideo:" + this.$bean.isUGCVideo() + ",subtitleSelectId:" + this.$bean.getSubtitleSelectId() + ", subjectId:" + this.$bean.getSubjectId() + ", id:" + this.$bean.getSubtitleResId() + ", size:" + (list != null ? Boxing.d(list.size()) : null), false, 4, (Object) null);
        c = y0.c();
        anonymousClass3 = new AnonymousClass3(list, this.this$0, this.$bean, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 4;
        if (kotlinx.coroutines.i.g(c, anonymousClass3, this) == f) {
        }
        return Unit.a;
    }
}
