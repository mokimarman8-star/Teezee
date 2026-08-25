package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/z0;", "", "invoke", "(Landroidx/compose/ui/platform/z0;)V", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@SourceDebugExtension
/* renamed from: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<z0, Unit> {
    final /* synthetic */ float $maxHeight$inlined;
    final /* synthetic */ float $maxWidth$inlined;
    final /* synthetic */ float $minHeight$inlined;
    final /* synthetic */ float $minWidth$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(float f5, float f6, float f7, float f8) {
        super(1);
        this.$minWidth$inlined = f5;
        this.$minHeight$inlined = f6;
        this.$maxWidth$inlined = f7;
        this.$maxHeight$inlined = f8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((z0) obj);
        return Unit.a;
    }

    public final void invoke(z0 z0Var) {
        z0Var.b("sizeIn");
        z0Var.a().b("minWidth", o0.i.d(this.$minWidth$inlined));
        z0Var.a().b("minHeight", o0.i.d(this.$minHeight$inlined));
        z0Var.a().b("maxWidth", o0.i.d(this.$maxWidth$inlined));
        z0Var.a().b("maxHeight", o0.i.d(this.$maxHeight$inlined));
    }
}
