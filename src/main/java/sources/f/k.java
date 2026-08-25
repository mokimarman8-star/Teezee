package f;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15195a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intentSenderRequest, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
        Intrinsics.g(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return putExtra;
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i5, Intent intent) {
        return new ActivityResult(i5, intent);
    }
}
