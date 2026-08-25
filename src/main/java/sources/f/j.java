package f;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15194a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "input");
        return intent;
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i5, Intent intent) {
        return new ActivityResult(i5, intent);
    }
}
