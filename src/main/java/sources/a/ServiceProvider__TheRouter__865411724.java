package a;

import android.content.Context;
import androidx.annotation.Keep;
import bw.c;
import com.therouter.inject.b;
import wv.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ServiceProvider__TheRouter__865411724 implements b {
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
            return (T) c.a();
        }
        return null;
    }
}
