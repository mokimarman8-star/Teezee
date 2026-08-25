package wj;

import androidx.fragment.app.FragmentActivity;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface f {
    Object a(String str, String str2, boolean z, Continuation continuation);

    void b(String str, MemberCheckResult memberCheckResult, g gVar);

    void c(FragmentActivity fragmentActivity, Function1 function1);

    void d(g gVar);

    void e(Integer num, String str, g gVar, MemberSceneType memberSceneType);

    Object f(Continuation continuation);
}
