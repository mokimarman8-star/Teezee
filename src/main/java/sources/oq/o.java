package oq;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.app.c;
import com.transsion.share.R$string;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    public static final o a = new o();
    private static final String[] b;
    private static long c;
    private static int d;

    static {
        b = Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    private o() {
    }

    public static /* synthetic */ boolean e(o oVar, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 2000;
        }
        return oVar.d(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 function0, DialogInterface dialogInterface, int i) {
        function0.invoke();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void j(o oVar, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 14;
        }
        oVar.i(activity, i);
    }

    public final String[] c() {
        return b;
    }

    public final boolean d(int i, long j) {
        if (d != i) {
            d = i;
            c = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - c <= j) {
            return true;
        }
        d = i;
        c = System.currentTimeMillis();
        return false;
    }

    public final void f(Context context, String str, String str2, final Function0 function0) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "title");
        Intrinsics.h(str2, "message");
        Intrinsics.h(function0, "onConfirm");
        c.a aVar = new c.a(context);
        aVar.setTitle(str);
        aVar.d(str2);
        aVar.g(context.getString(R$string.system_settings), new DialogInterface.OnClickListener() { // from class: oq.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                o.g(function0, dialogInterface, i);
            }
        });
        aVar.e(context.getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: oq.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                o.h(dialogInterface, i);
            }
        });
        androidx.appcompat.app.c create = aVar.create();
        Intrinsics.g(create, "create(...)");
        create.show();
    }

    public final void i(Activity activity, int i) {
        Intrinsics.h(activity, "activity");
        String packageName = activity.getPackageName();
        Intrinsics.g(packageName, "getPackageName(...)");
        Intent intent = new Intent("com.android.setting.ACTION_GET_PERMISSION_DETAILS");
        intent.putExtra("packagename", packageName);
        intent.addFlags(268435456);
        try {
            try {
                try {
                    if (i > 0) {
                        activity.startActivityForResult(intent, i);
                    } else {
                        activity.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                intent2.addFlags(268435456);
                if (i > 0) {
                    activity.startActivityForResult(intent2, i);
                } else {
                    activity.startActivity(intent2);
                }
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.parse("package:" + packageName));
            intent3.addFlags(268435456);
            if (i > 0) {
                activity.startActivityForResult(intent3, i);
            } else {
                activity.startActivity(intent3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean k(int[] iArr) {
        Intrinsics.h(iArr, "grantResults");
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}
