package com.transsion.edcation.history;

import android.widget.TextView;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.R$string;
import com.transsion.gslb.BuildConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryAdapter$calculateProgress$1", f = "EducationHistoryAdapter.kt", l = {54, 64}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class EducationHistoryAdapter$calculateProgress$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoDetailPlayBean $item;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ EducationHistoryAdapter this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryAdapter$calculateProgress$1$1", f = "EducationHistoryAdapter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.history.EducationHistoryAdapter$calculateProgress$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $percentStr;
        final /* synthetic */ TextView $textView;
        int label;
        final /* synthetic */ EducationHistoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, EducationHistoryAdapter educationHistoryAdapter, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$textView = textView;
            this.this$0 = educationHistoryAdapter;
            this.$percentStr = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$textView, this.this$0, this.$percentStr, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$textView.setText(this.this$0.getContext().getString(R$string.course_learn_progress, this.$percentStr));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EducationHistoryAdapter$calculateProgress$1(EducationHistoryAdapter educationHistoryAdapter, VideoDetailPlayBean videoDetailPlayBean, TextView textView, Continuation<? super EducationHistoryAdapter$calculateProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = educationHistoryAdapter;
        this.$item = videoDetailPlayBean;
        this.$textView = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EducationHistoryAdapter$calculateProgress$1(this.this$0, this.$item, this.$textView, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao H1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            H1 = this.this$0.H1();
            String subjectId = this.$item.getSubjectId();
            this.label = 1;
            obj = H1.g(subjectId, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        Long l = (Long) obj;
        long longValue = l != null ? l.longValue() : 0L;
        Long subjectDurationSeconds = this.$item.getSubjectDurationSeconds();
        float f2 = (subjectDurationSeconds != null ? subjectDurationSeconds.longValue() : 0L) > 0 ? (longValue / r8) / 10.0f : 0.0f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%.0f", Arrays.copyOf(new Object[]{Boxing.c(RangesKt.g(f2, 100.0f))}, 1));
        Intrinsics.g(format, "format(...)");
        a2 c = y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$textView, this.this$0, format, null);
        this.label = 2;
        if (i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
