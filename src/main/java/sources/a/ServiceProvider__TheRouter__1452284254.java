package a;

import android.content.Context;
import androidx.annotation.Keep;
import com.therouter.inject.b;
import com.transsion.commercialization.gameres.c;
import com.transsion.commercialization.task.q;
import tj.d;
import wj.a;
import wj.e;
import wj.f;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ServiceProvider__TheRouter__1452284254 implements b {
    public static final String FLOW_TASK_JSON = "{}";
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void addFlowTask(Context context, jf.b bVar) {
    }

    public void initFlowTask(Context context, jf.b bVar) {
        addFlowTask(context, bVar);
    }

    public <T> T interception(Class<T> cls, Object... objArr) {
        if (a.class.equals(cls) && objArr.length == 0) {
            return (T) d.a();
        }
        if (wj.b.class.equals(cls) && objArr.length == 0) {
            return (T) c.a();
        }
        if (wj.d.class.equals(cls) && objArr.length == 0) {
            return (T) rj.c.a();
        }
        if (e.class.equals(cls) && objArr.length == 0) {
            return (T) com.transsion.commercialization.pslink.e.a();
        }
        if (f.class.equals(cls) && objArr.length == 0) {
            return (T) q.a();
        }
        return null;
    }
}
