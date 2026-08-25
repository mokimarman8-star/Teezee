package com.cloud.hisavana.sdk.common.http.listener;

import android.os.Handler;
import android.util.Log;
import com.cloud.hisavana.sdk.b4;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.c;
import com.hisavana.common.constant.ComConstants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CommonResponseListener<E> extends ResponseBaseListener {
    protected CommonResponseListener() {
    }

    protected CommonResponseListener(boolean z) {
        super(z);
    }

    private void j(final int i, final String str) {
        final Object obj;
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                throw new RuntimeException("Missing type parameter.");
            }
            try {
                obj = GsonUtil.b(str, ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            } catch (Exception e) {
                b4.b().e(ComConstants.PLATFORM_SSP, "GsonUtil parseResponse " + Log.getStackTraceString(e));
                obj = null;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CommonResponseListener.this.h(i, obj, str);
                    }
                });
            } else {
                h(i, obj, str);
            }
        } catch (Throwable th) {
            b4.b().e(ComConstants.PLATFORM_SSP, "parseResponse " + Log.getStackTraceString(th));
            c.netLog("CommonResponseListener --> 解析网络请求数据异常 --> parseResponse --> catch " + Log.getStackTraceString(th));
            a(TaErrorCode.ERROR_RESPONSE_PARSING_FAILED);
        }
    }

    protected abstract void g(int i, Object obj);

    public void h(int i, Object obj, String str) {
        g(i, obj);
    }

    public void i(int i, String str) {
        j(i, str);
    }
}
