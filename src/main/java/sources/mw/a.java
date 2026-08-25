package mw;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import ci.p;
import com.transsion.ad.bidding.base.v;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.ad.ps.activate.PsActivateBean;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.MemberSource;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONObject;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();
    private static PsActivateBean b;

    /* renamed from: mw.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0081a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MemberSource.values().length];
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_TIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private a() {
    }

    private final boolean c(Activity activity) {
        if (v.a.b()) {
            a.a.g(wf.a.a, "ActivateAdManager --> canShow(" + activity.getClass().getSimpleName() + ") --> 当前Activity广告正在展示", false, 2, (Object) null);
            return false;
        }
        if (i()) {
            a.a.g(wf.a.a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 配置已关闭", false, 2, (Object) null);
            return false;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("activate_show_date", HttpUrl.FRAGMENT_ENCODE_SET);
        String c = p.a.c();
        if (!TextUtils.equals(string, c)) {
            bVar.b().putInt("activate_show_times", 0);
            a.a.g(wf.a.a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 新的一天重置次数 --> curDate = " + c + " --> lastShowDate = " + string, false, 2, (Object) null);
        }
        int i = bVar.b().getInt("activate_show_times", 0);
        int h = h();
        if (i >= h) {
            a.a.g(wf.a.a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 展示次数已达上限 --> showTimes = " + i + " --> limit = " + h, false, 2, (Object) null);
            return false;
        }
        long g = g();
        long j = bVar.b().getLong("activate_show_timestamp", 0L);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - j;
        if (j2 >= g) {
            return true;
        }
        a.a.g(wf.a.a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 展示间隔未到 --> lastShowTimestamp = " + j + " --> cur = " + elapsedRealtime + " --> interval = " + g + " --> gap = " + j2, false, 2, (Object) null);
        return false;
    }

    private final String f() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final SpannableStringBuilder a(Context context, String rawTitle) {
        Intrinsics.h(context, "context");
        Intrinsics.h(rawTitle, "rawTitle");
        String o = o(rawTitle);
        String p = p(j(), "notificationStyleTitle", o);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(p);
        int o0 = StringsKt.o0(p, o, 0, false, 6, null);
        spannableStringBuilder.setSpan(new StyleSpan(2), o0, o.length() + o0, 33);
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder b(Context context, String name, String fullText) {
        Intrinsics.h(context, "context");
        Intrinsics.h(name, "name");
        Intrinsics.h(fullText, "fullText");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fullText);
        int o0 = StringsKt.o0(fullText, name, 0, false, 6, null);
        spannableStringBuilder.setSpan(new StyleSpan(2), o0, name.length() + o0, 33);
        return spannableStringBuilder;
    }

    public final void d(boolean z) {
        PsActivateBean psActivateBean;
        a.a.g(wf.a.a, "ActivateAdManager --> consumeActivateAd() --> 广告被消费 --> bestAd = " + b, false, 2, (Object) null);
        if (z && (psActivateBean = b) != null) {
            PSActivateManager.a.a(psActivateBean);
        }
        b = null;
    }

    public final PsActivateBean e(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (!c(activity)) {
            return null;
        }
        if (b == null) {
            PsActivateBean b2 = PSActivateManager.a.b();
            b = b2;
            if (b2 != null) {
                q();
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long g() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Long.valueOf(new JSONObject(str).optLong("notificationStyleIntervalMinutes") * 60 * 1000));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = 1000L;
            }
            return ((Number) obj).longValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Long.valueOf(new JSONObject(str).optLong("notificationStyleIntervalMinutes") * 60 * 1000));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Number) obj).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int h() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("notificationStyleLimit")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = 3;
            }
            return ((Number) obj).intValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("notificationStyleLimit")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Number) obj).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("notificationStyleOff")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.TRUE;
            }
            return ((Boolean) obj).booleanValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("notificationStyleOff")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j() {
        Object obj;
        ConfigBean c;
        String str;
        Object obj2 = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(new JSONObject(str).optString("notificationStyleTitle"));
            if (Result.exceptionOrNull-impl(obj) == null) {
                obj2 = obj;
            }
            return (String) obj2;
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(new JSONObject(str).optString("notificationStyleTitle"));
        if (Result.exceptionOrNull-impl(obj) == null) {
        }
        return (String) obj2;
    }

    public final boolean k(MemberSource sceneId) {
        Object obj;
        String value;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result$Companion result$Companion = Result.Companion;
            int i = C0081a.a[sceneId.ordinal()];
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            String str2 = i != 1 ? i != 2 ? i != 3 ? HttpUrl.FRAGMENT_ENCODE_SET : "activateDialogNoResolutionOff" : "activateDialogTipResolutionOff" : "activateDialogResolutionOff";
            ConfigBean c = cm.f.c.a().c("activate_config", true);
            if (c != null && (value = c.getValue()) != null) {
                str = value;
            }
            obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean(str2)));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("installedGuideTipViewAutoCloseTime")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = 10;
            }
            return ((Number) obj).intValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("installedGuideTipViewAutoCloseTime")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Number) obj).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isAutoOpenApp")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isAutoOpenApp")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result$Companion result$Companion = Result.Companion;
            c = cm.f.c.a().c("activate_config", true);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isShowInstalledGuideTipView")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
        str = HttpUrl.FRAGMENT_ENCODE_SET;
        obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isShowInstalledGuideTipView")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Boolean) obj).booleanValue();
    }

    public final String o(String text) {
        Intrinsics.h(text, "text");
        if (text.length() <= 10) {
            return text;
        }
        String substring = text.substring(0, 9);
        Intrinsics.g(substring, "substring(...)");
        return substring + "…";
    }

    public final String p(String text, String placeholder, String target) {
        Intrinsics.h(text, "text");
        Intrinsics.h(placeholder, "placeholder");
        Intrinsics.h(target, "target");
        return StringsKt.c0(text, placeholder, false, 2, null) ? StringsKt.Q(text, placeholder, target, false, 4, null) : text;
    }

    public final void q() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("activate_show_date", HttpUrl.FRAGMENT_ENCODE_SET);
        p pVar = p.a;
        if (!TextUtils.equals(string, pVar.c())) {
            bVar.b().putString("activate_show_date", pVar.c());
            bVar.b().putInt("activate_show_times", 0);
            a.a.g(wf.a.a, "ActivateAdManager --> showActivateAd() --> 广告展示 --> bestAd = " + b + " --> 日期重置", false, 2, (Object) null);
        }
        int i = bVar.b().getInt("activate_show_times", 0) + 1;
        bVar.b().putInt("activate_show_times", i);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bVar.b().putLong("activate_show_timestamp", elapsedRealtime);
        a.a.g(wf.a.a, "ActivateAdManager --> showActivateAd() --> 广告展示 --> bestAd = " + b + " --> cur = " + elapsedRealtime + " --> showTimes = " + i, false, 2, (Object) null);
    }
}
