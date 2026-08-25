package com.transsion.baselib.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.gslb.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ActivityPermissionUtil {
    public static final ActivityPermissionUtil a = new ActivityPermissionUtil();
    private static Function0 b;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/transsion/baselib/utils/ActivityPermissionUtil$PermissionTransActivityImpl;", "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;", "<init>", "()V", "Lcom/blankj/utilcode/util/UtilsTransActivity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreated", "(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(Lcom/blankj/utilcode/util/UtilsTransActivity;IILandroid/content/Intent;)V", "onDestroy", "(Lcom/blankj/utilcode/util/UtilsTransActivity;)V", "Companion", "a", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionTransActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static final String ACTION = "extra_action";
        private static final String ACTION_2 = "extra_action2";
        private static final String REQUEST_CODE = "extra_request_code";

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<PermissionTransActivityImpl> instance$delegate = LazyKt.b(new Function0() { // from class: ij.b
            public final Object invoke() {
                ActivityPermissionUtil.PermissionTransActivityImpl instance_delegate$lambda$0;
                instance_delegate$lambda$0 = ActivityPermissionUtil.PermissionTransActivityImpl.instance_delegate$lambda$0();
                return instance_delegate$lambda$0;
            }
        });

        /* renamed from: com.transsion.baselib.utils.ActivityPermissionUtil$PermissionTransActivityImpl$a, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(String str, String str2, int i, Intent intent) {
                intent.putExtra(PermissionTransActivityImpl.ACTION, str);
                intent.putExtra(PermissionTransActivityImpl.ACTION_2, str2);
                intent.putExtra(PermissionTransActivityImpl.REQUEST_CODE, i);
            }

            public final PermissionTransActivityImpl b() {
                return (PermissionTransActivityImpl) PermissionTransActivityImpl.instance$delegate.getValue();
            }

            public final void c(final String str, final String str2, final int i) {
                Intrinsics.h(str, "action");
                UtilsTransActivity.P(new Utils.b() { // from class: ij.c
                    public final void accept(Object obj) {
                        ActivityPermissionUtil.PermissionTransActivityImpl.Companion.d(str, str2, i, (Intent) obj);
                    }
                }, b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PermissionTransActivityImpl instance_delegate$lambda$0() {
            return new PermissionTransActivityImpl();
        }

        public void onActivityResult(UtilsTransActivity activity, int requestCode, int resultCode, Intent data) {
            Intrinsics.h(activity, "activity");
            activity.finish();
        }

        public void onCreated(UtilsTransActivity activity, Bundle savedInstanceState) {
            Intrinsics.h(activity, "activity");
            activity.getWindow().addFlags(262160);
            String stringExtra = activity.getIntent().getStringExtra(ACTION);
            String stringExtra2 = activity.getIntent().getStringExtra(ACTION_2);
            int intExtra = activity.getIntent().getIntExtra(REQUEST_CODE, 10000);
            if (stringExtra == null || stringExtra.length() == 0) {
                activity.finish();
                return;
            }
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            try {
                activity.startActivityForResult(new Intent(stringExtra, Uri.parse("package:" + activity.getPackageName())), intExtra);
            } catch (Throwable unused) {
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    activity.finish();
                    return;
                }
                try {
                    activity.startActivityForResult(new Intent(stringExtra2, Uri.parse("package:" + activity.getPackageName())), intExtra);
                } catch (Throwable unused2) {
                    activity.finish();
                }
            }
        }

        public void onDestroy(UtilsTransActivity activity) {
            Intrinsics.h(activity, "activity");
            Function0 function0 = ActivityPermissionUtil.b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private ActivityPermissionUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0) {
        function0.invoke();
        b = null;
        return Unit.a;
    }

    public final void c(String str, int i, Function0 function0) {
        Intrinsics.h(str, "action");
        Intrinsics.h(function0, "callback");
        d(str, null, i, function0);
    }

    public final void d(String str, String str2, int i, final Function0 function0) {
        Intrinsics.h(str, "action");
        Intrinsics.h(function0, "callback");
        b = new Function0() { // from class: ij.a
            public final Object invoke() {
                Unit e;
                e = ActivityPermissionUtil.e(function0);
                return e;
            }
        };
        PermissionTransActivityImpl.INSTANCE.c(str, str2, i);
    }
}
