package im;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.OpType;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.h1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface b {
    void A(Function0 function0);

    int B();

    void C(Activity activity, String str, String str2, j jVar);

    void D(f fVar);

    void E();

    h1 a();

    Object b(MemberSceneType memberSceneType, Integer num, Function1 function1, Continuation continuation);

    boolean c();

    void d(MemberSceneType memberSceneType, Integer num, a aVar);

    boolean e();

    void f();

    void g(Integer num, a aVar);

    void h();

    boolean i(Fragment fragment);

    void j(MemberDetail memberDetail);

    void k(MemberTaskItem memberTaskItem, Function2 function2, Function1 function1);

    MemberDetail l();

    boolean m();

    void n(OpType opType, Function1 function1);

    void o();

    void p(d dVar);

    void q();

    Fragment r();

    void s(d dVar);

    void t();

    void u(Activity activity, MemberSource memberSource, c cVar, boolean z, String str);

    void v(f fVar);

    void w(float f);

    void x(Activity activity, MemberSource memberSource, MemberCheckResult memberCheckResult, c cVar);

    void y(Function2 function2, Function0 function0);

    boolean z();
}
