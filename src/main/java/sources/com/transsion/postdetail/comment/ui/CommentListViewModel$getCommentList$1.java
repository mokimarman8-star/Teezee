package com.transsion.postdetail.comment.ui;

import androidx.lifecycle.b0;
import ao.a;
import com.blankj.utilcode.util.o;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.bean.MyCommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsion.postdetail.bean.PagerBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.comment.ui.CommentListViewModel$getCommentList$1", f = "CommentListViewModel.kt", l = {49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CommentListViewModel$getCommentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommentListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommentListViewModel$getCommentList$1(CommentListViewModel commentListViewModel, Continuation<? super CommentListViewModel$getCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = commentListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommentListViewModel$getCommentList$1 commentListViewModel$getCommentList$1 = new CommentListViewModel$getCommentList$1(this.this$0, continuation);
        commentListViewModel$getCommentList$1.L$0 = obj;
        return commentListViewModel$getCommentList$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        String str;
        int i;
        ao.a l;
        CommentListViewModel commentListViewModel;
        List list;
        List list2;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            CommentListViewModel commentListViewModel2 = this.this$0;
            Result.Companion companion2 = Result.Companion;
            b.a aVar = mg.b.a;
            str = commentListViewModel2.e;
            i = commentListViewModel2.f;
            String j = o.j(new PagerBody(str, Boxing.d(i)));
            Intrinsics.g(j, "toJson(...)");
            RequestBody a = aVar.a(j);
            if (a == null) {
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("error:");
                    sb.append(th2);
                }
                return Unit.a;
            }
            l = commentListViewModel2.l();
            this.L$0 = commentListViewModel2;
            this.label = 1;
            Object a2 = a.C0000a.a(l, a, null, this, 2, null);
            if (a2 == f) {
                return f;
            }
            commentListViewModel = commentListViewModel2;
            obj = a2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            commentListViewModel = (CommentListViewModel) this.L$0;
            ResultKt.b(obj);
        }
        MyCommentListBean myCommentListBean = (MyCommentListBean) ((BaseDto) obj).getData();
        if (myCommentListBean != null) {
            Pager pager = myCommentListBean.getPager();
            if (pager != null) {
                commentListViewModel.e = String.valueOf(pager.getNextPage());
                pager.getNextPage();
                commentListViewModel.g = Intrinsics.c(pager.getHasMore(), Boxing.a(true));
            }
            list = commentListViewModel.d;
            List<CommentBean> commentList = myCommentListBean.getCommentList();
            if (commentList == null) {
                commentList = CollectionsKt.l();
            }
            list.addAll(commentList);
            b0 m = commentListViewModel.m();
            list2 = commentListViewModel.d;
            m.n(list2);
        }
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
