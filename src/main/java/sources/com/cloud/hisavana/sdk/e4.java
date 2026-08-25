package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class e4 implements x3 {
    protected a a;
    protected volatile int b = 1;
    protected int c;
    protected int d;

    public interface a {
        void a(TaErrorCode taErrorCode, Bundle bundle);

        void a(List list);

        void b(List list, Bundle bundle);

        void c(TaErrorCode taErrorCode, Bundle bundle);
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(a aVar) {
        this.a = aVar;
    }

    public void e(int i) {
        this.c = i;
    }
}
