package com.noober.background;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class BackgroundFactory$a implements View.OnClickListener {
    final /* synthetic */ Method a;
    final /* synthetic */ Context b;

    BackgroundFactory$a(Method method, Context context) {
        this.a = method;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.a.invoke(this.b, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }
}
