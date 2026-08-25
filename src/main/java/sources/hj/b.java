package hj;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wf.a;
import wj.f;
import wj.g;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    public static final class a implements g {
        a(c cVar) {
        }

        @Override // wj.g
        public void a(boolean z) {
            g.a.a(this, z);
        }

        @Override // wj.g
        public void onFail() {
        }

        @Override // wj.g
        public void onSuccess() {
        }
    }

    private b() {
    }

    private final boolean b(String str) {
        return TextUtils.equals("/common/dialog", Uri.parse(str).getQueryParameter("type"));
    }

    public static /* synthetic */ void d(b bVar, Context context, String str, c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            cVar = null;
        }
        bVar.c(context, str, cVar);
    }

    private final void e(FragmentActivity fragmentActivity, String str, final c cVar) {
        String queryParameter = Uri.parse(str).getQueryParameter("name");
        if (Intrinsics.c(queryParameter, "MemberPageVideoTaskDialog")) {
            f fVar = (f) TheRouter.d(f.class, new Object[0]);
            if (fVar != null) {
                fVar.c(fragmentActivity, new Function1(cVar) { // from class: hj.a
                    public final Object invoke(Object obj) {
                        Unit f;
                        f = b.f(null, ((Boolean) obj).booleanValue());
                        return f;
                    }
                });
                return;
            }
            return;
        }
        if (Intrinsics.c(queryParameter, "DownloadInterceptDialog")) {
            f fVar2 = (f) TheRouter.d(f.class, new Object[0]);
            if (fVar2 != null) {
                fVar2.d(new a(cVar));
                return;
            }
            return;
        }
        a.a.l(wf.a.a, "cm_dialog", "name = " + queryParameter + " --> 没有匹配到", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(c cVar, boolean z) {
        if (cVar != null) {
            cVar.a(z);
        }
        return Unit.a;
    }

    public final void c(Context context, String str, c cVar) {
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "deeplink");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b(str)) {
            if (context instanceof FragmentActivity) {
                e((FragmentActivity) context, str, cVar);
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(str);
            Intrinsics.g(parse, "parse(...)");
            hr.c.j(parse);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Result.box-impl(obj);
    }
}
