package androidx.compose.foundation.selection;

import androidx.compose.ui.platform.z0;
import androidx.compose.ui.semantics.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/z0;", "", "invoke", "(Landroidx/compose/ui/platform/z0;)V", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@SourceDebugExtension
/* renamed from: androidx.compose.foundation.selection.SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<z0, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ f $role$inlined;
    final /* synthetic */ boolean $selected$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(boolean z5, boolean z6, f fVar, Function0 function0) {
        super(1);
        this.$selected$inlined = z5;
        this.$enabled$inlined = z6;
        this.$role$inlined = fVar;
        this.$onClick$inlined = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((z0) obj);
        return Unit.a;
    }

    public final void invoke(z0 z0Var) {
        z0Var.b("selectable");
        z0Var.a().b("selected", Boolean.valueOf(this.$selected$inlined));
        z0Var.a().b("enabled", Boolean.valueOf(this.$enabled$inlined));
        z0Var.a().b("role", this.$role$inlined);
        z0Var.a().b("onClick", this.$onClick$inlined);
    }
}
