package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/activity/s;", "invoke", "()Landroidx/activity/s;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class ComponentActivity$fullyDrawnReporter$2 extends Lambda implements Function0<s> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final s m7invoke() {
        ComponentActivity$e access$getReportFullyDrawnExecutor$p = ComponentActivity.access$getReportFullyDrawnExecutor$p(this.this$0);
        final ComponentActivity componentActivity = this.this$0;
        return new s(access$getReportFullyDrawnExecutor$p, new Function0<Unit>() { // from class: androidx.activity.ComponentActivity$fullyDrawnReporter$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m8invoke();
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m8invoke() {
                componentActivity.reportFullyDrawn();
            }
        });
    }
}
