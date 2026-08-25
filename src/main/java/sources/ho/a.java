package ho;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {
    public static final C0072a h1 = C0072a.a;

    /* renamed from: ho.a$a, reason: collision with other inner class name */
    public static final class C0072a {
        static final /* synthetic */ C0072a a = new C0072a();

        private C0072a() {
        }

        public final a a(Context context, Fragment fragment, RecyclerView recyclerView, com.transsion.postdetail.ui.adapter.f fVar, String str, String str2, boolean z) {
            Intrinsics.h(context, "context");
            Intrinsics.h(fragment, "fragment");
            Intrinsics.h(str, "pageName");
            Intrinsics.h(str2, "subpageName");
            return new e(context, fragment, recyclerView, fVar, str, str2, z);
        }
    }

    void a();

    void b();

    void c();

    void onPageDestroy();
}
