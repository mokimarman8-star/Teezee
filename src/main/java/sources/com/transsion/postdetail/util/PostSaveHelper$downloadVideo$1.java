package com.transsion.postdetail.util;

import android.app.Application;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.PostSaveHelper$downloadVideo$1", f = "PostSaveHelper.kt", l = {46}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PostSaveHelper$downloadVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostSubjectItem $item;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostSaveHelper$downloadVideo$1(PostSubjectItem postSubjectItem, Continuation<? super PostSaveHelper$downloadVideo$1> continuation) {
        super(2, continuation);
        this.$item = postSubjectItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostSaveHelper$downloadVideo$1(this.$item, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Media media;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return Unit.a;
            }
            fh.b.a.d(com.transsion.baseui.R.string.post_start_saving);
            PostSubjectItem postSubjectItem = this.$item;
            Video a = t.a((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getVideo());
            if (a == null || (str = a.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = "MB_" + System.currentTimeMillis() + ".mp4";
            VideoSaver videoSaver = VideoSaver.a;
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            this.label = 1;
            obj = videoSaver.c(a2, str, str2, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Uri) obj) != null) {
            fh.b.a.d(com.transsion.baseui.R.string.post_saved_to_gallery);
        }
        return Unit.a;
    }
}
