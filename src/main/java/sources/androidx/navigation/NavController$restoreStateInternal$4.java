package androidx.navigation;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class NavController$restoreStateInternal$4 extends Lambda implements Function1<NavBackStackEntry, Unit> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ List<NavBackStackEntry> $entries;
    final /* synthetic */ Ref.IntRef $lastNavigatedIndex;
    final /* synthetic */ Ref.BooleanRef $navigated;
    final /* synthetic */ NavController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavController$restoreStateInternal$4(Ref.BooleanRef booleanRef, List<NavBackStackEntry> list, Ref.IntRef intRef, NavController navController, Bundle bundle) {
        super(1);
        this.$navigated = booleanRef;
        this.$entries = list;
        this.$lastNavigatedIndex = intRef;
        this.this$0 = navController;
        this.$args = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.a;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        List<NavBackStackEntry> l5;
        Intrinsics.h(navBackStackEntry, "entry");
        this.$navigated.element = true;
        int indexOf = this.$entries.indexOf(navBackStackEntry);
        if (indexOf != -1) {
            int i5 = indexOf + 1;
            l5 = this.$entries.subList(this.$lastNavigatedIndex.element, i5);
            this.$lastNavigatedIndex.element = i5;
        } else {
            l5 = CollectionsKt.l();
        }
        NavController.b(this.this$0, navBackStackEntry.f(), this.$args, navBackStackEntry, l5);
    }
}
