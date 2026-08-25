package jp;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.transsion.room.activity.RoomDetailActivity;
import com.transsion.room.api.RoomsViewType;
import com.transsion.room.helper.LocationPlaceHelper;
import com.transsion.room.widget.RecommendRoomsView;
import com.transsion.room.widget.SubjectDetailRoomsView;
import com.transsion.room.widget.TrendingRoomsView;
import ep.c;
import ep.e;
import ep.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a implements f {
    @Override // ep.f
    public void a(FragmentActivity fragmentActivity, boolean z, Function1 function1) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(function1, "callback");
        LocationPlaceHelper.a.t(fragmentActivity, z, function1);
    }

    @Override // ep.f
    public void b(FragmentActivity fragmentActivity, Function1 function1) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(function1, "callback");
        LocationPlaceHelper.a.n(fragmentActivity, function1);
    }

    @Override // ep.f
    public e c(Context context, RoomsViewType roomsViewType) {
        Intrinsics.h(context, "context");
        Intrinsics.h(roomsViewType, "type");
        int i = a.a[roomsViewType.ordinal()];
        if (i == 1) {
            return new RecommendRoomsView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        if (i == 2) {
            return new TrendingRoomsView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        if (i == 3) {
            return new SubjectDetailRoomsView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ep.f
    public String d() {
        return String.valueOf(Reflection.b(RoomDetailActivity.class).g());
    }

    @Override // ep.f
    public void e(double d, double d2, Function1 function1) {
        Intrinsics.h(function1, "callback");
        LocationPlaceHelper.a.p(d, d2, function1);
    }

    @Override // ep.f
    public c f(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        return new com.transsion.room.helper.e(fragment);
    }
}
