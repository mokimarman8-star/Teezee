package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class OnBackPressedDispatcher$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OnBackPressedDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnBackPressedDispatcher$3(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.this$0 = onBackPressedDispatcher;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m11invoke();
        return Unit.a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m11invoke() {
        this.this$0.l();
    }
}
