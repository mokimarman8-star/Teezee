package a;

import android.content.Context;
import androidx.annotation.Keep;
import com.therouter.inject.b;
import com.transsion.push.utils.f0;
import wo.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ServiceProvider__TheRouter__978335634 implements b {
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
            return (T) f0.a();
        }
        return null;
    }
}
