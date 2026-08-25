package vo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$mipmap;
import com.transsion.lib.push.R$string;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.push.utils.u;
import gf.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NoticePermissionFrom.values().length];
            try {
                iArr[NoticePermissionFrom.APP_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoticePermissionFrom.DOWNLOAD_RES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoticePermissionFrom.PLAY_MUSIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NoticePermissionFrom noticePermissionFrom, f fVar, List list, boolean z, boolean z2) {
        Intrinsics.h(fVar, "scope");
        Intrinsics.h(list, "deniedList");
        if (!z) {
            a.a.f(wf.a.a, "NoticePer", "请求权限之后，无需弹窗", false, 4, (Object) null);
            return;
        }
        if (z2) {
            a.a.f(wf.a.a, "NoticePer", noticePermissionFrom + " 请求权限，需要跳到设置页，先展示提示弹窗", false, 4, (Object) null);
            fVar.c(list, new ff.a((String) null, a.i(noticePermissionFrom), Utils.a().getString(R$string.permission_notice_turn_on), Integer.valueOf(R$mipmap.ic_notification_permission_tips), Integer.valueOf(R.color.white_20), 1, (DefaultConstructorMarker) null));
            return;
        }
        if (noticePermissionFrom == NoticePermissionFrom.APP_START) {
            a.a.f(wf.a.a, "NoticePer", "app 启动 直接请求权限", false, 4, (Object) null);
            fVar.b(list);
            return;
        }
        a.a.f(wf.a.a, "NoticePer", noticePermissionFrom + " 请求权限前，提示弹窗", false, 4, (Object) null);
        fVar.e(list, new ff.a((String) null, a.i(noticePermissionFrom), Utils.a().getString(R$string.permission_notice_turn_on), Integer.valueOf(R$mipmap.ic_notification_permission_tips), Integer.valueOf(R.color.white_20), 1, (DefaultConstructorMarker) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(boolean z, List list, List list2) {
        Intrinsics.h(list, "grantedList");
        Intrinsics.h(list2, "deniedList");
        a.a.f(wf.a.a, "NoticePer", "通知权限 请求权限结果:" + z, false, 4, (Object) null);
    }

    private final boolean j(NoticePermissionFrom noticePermissionFrom) {
        int i = a.a[noticePermissionFrom.ordinal()];
        if (i == 1) {
            return k();
        }
        if (i != 2) {
            return true;
        }
        u uVar = u.a;
        boolean z = uVar.b().getBoolean("key_notification_permission_download", true);
        uVar.b().putBoolean("key_notification_permission_download", false);
        return z;
    }

    private final boolean k() {
        u uVar = u.a;
        long j = uVar.b().getLong("key_notification_permission_app_start_count", 0L);
        long j2 = uVar.b().getLong("key_notification_permission_app_start_last_time", 0L);
        Integer remindTime = PushConfigHelper.INSTANCE.getRemindTime();
        int e = remindTime != null ? RangesKt.e(remindTime.intValue(), 1) : 48;
        if (!l() || System.currentTimeMillis() - j2 < 3600000 * e) {
            a.a.f(wf.a.a, "NoticePer", "app启动，小于" + e + "小时，不请求 count:" + j, false, 4, (Object) null);
            return false;
        }
        wf.a.a.c("NoticePer", "app启动 超过" + e + "小时，再次请求  count:" + j, true);
        uVar.b().putLong("key_notification_permission_app_start_last_time", System.currentTimeMillis());
        uVar.b().putLong("key_notification_permission_app_start_count", j + 1);
        n();
        return true;
    }

    private final boolean l() {
        List U0;
        try {
            Result.Companion companion = Result.Companion;
            long currentTimeMillis = System.currentTimeMillis();
            String string = u.a.b().getString("key_notice_permission_app_start_limit_time", BuildConfig.FLAVOR);
            String str = string == null ? BuildConfig.FLAVOR : string;
            if (str.length() == 0) {
                U0 = new ArrayList();
            } else {
                List R0 = StringsKt.R0(str, new char[]{','}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                Iterator it = R0.iterator();
                while (it.hasNext()) {
                    Long x = StringsKt.x((String) it.next());
                    if (x != null) {
                        arrayList.add(x);
                    }
                }
                U0 = CollectionsKt.U0(arrayList);
            }
            final long j = currentTimeMillis - 604800000;
            CollectionsKt.I(U0, new Function1() { // from class: vo.d
                public final Object invoke(Object obj) {
                    boolean m;
                    m = e.m(j, ((Long) obj).longValue());
                    return Boolean.valueOf(m);
                }
            });
            return U0.size() < 2;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(long j, long j2) {
        return j2 < j;
    }

    private final void n() {
        List U0;
        try {
            Result.Companion companion = Result.Companion;
            long currentTimeMillis = System.currentTimeMillis();
            String string = u.a.b().getString("key_notice_permission_app_start_limit_time", BuildConfig.FLAVOR);
            String str = string == null ? BuildConfig.FLAVOR : string;
            if (str.length() == 0) {
                U0 = new ArrayList();
            } else {
                List R0 = StringsKt.R0(str, new char[]{','}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                Iterator it = R0.iterator();
                while (it.hasNext()) {
                    Long x = StringsKt.x((String) it.next());
                    if (x != null) {
                        arrayList.add(x);
                    }
                }
                U0 = CollectionsKt.U0(arrayList);
            }
            final long j = currentTimeMillis - 604800000;
            CollectionsKt.I(U0, new Function1() { // from class: vo.c
                public final Object invoke(Object obj) {
                    boolean o;
                    o = e.o(j, ((Long) obj).longValue());
                    return Boolean.valueOf(o);
                }
            });
            U0.add(Long.valueOf(currentTimeMillis));
            Result.constructor-impl(u.a.b().putString("key_notice_permission_app_start_limit_time", CollectionsKt.s0(U0, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(long j, long j2) {
        return j2 < j;
    }

    public final boolean e(Fragment fragment, NoticePermissionFrom noticePermissionFrom) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(noticePermissionFrom, "from");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return a.f(activity, noticePermissionFrom);
        }
        return false;
    }

    public final boolean f(FragmentActivity fragmentActivity, final NoticePermissionFrom noticePermissionFrom) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(noticePermissionFrom, "from");
        if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return false;
        }
        cf.c cVar = cf.c.a;
        if (cVar.b(fragmentActivity)) {
            a.a.v(wf.a.a, "NoticePer", "checkRequestPermission , 权限已开启, from:" + noticePermissionFrom, false, 4, (Object) null);
            return false;
        }
        if (!j(noticePermissionFrom)) {
            a.a.v(wf.a.a, "NoticePer", "checkRequestPermission 不请求权限, from:" + noticePermissionFrom, false, 4, (Object) null);
            return false;
        }
        a.a.f(wf.a.a, "NoticePer", "checkRequestPermission from:" + noticePermissionFrom, false, 4, (Object) null);
        cVar.e(fragmentActivity).b(new String[]{"android.permission.POST_NOTIFICATIONS"}).b().a(new df.b() { // from class: vo.a
            public final void a(f fVar, List list, boolean z, boolean z2) {
                e.g(NoticePermissionFrom.this, fVar, list, z, z2);
            }
        }).d(new df.c() { // from class: vo.b
            public final void a(boolean z, List list, List list2) {
                e.h(z, list, list2);
            }
        });
        return true;
    }

    public final String i(NoticePermissionFrom noticePermissionFrom) {
        Intrinsics.h(noticePermissionFrom, "from");
        if (a.a[noticePermissionFrom.ordinal()] == 3) {
            String string = Utils.a().getString(R$string.permission_notice_tips_music);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        String string2 = Utils.a().getString(R$string.permission_notice_tips_normal);
        Intrinsics.g(string2, "getString(...)");
        return string2;
    }
}
