package il;

import android.content.Context;
import com.transsion.http.d.h;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d extends c {
    private boolean l;
    private Context m;

    public d(Context context, String str, boolean z, Object obj, h hVar, Map map, boolean z2, int i, int i2, boolean z3, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        super(str, obj, hVar, map, z2, i, i2, z3, sSLSocketFactory, hostnameVerifier);
        this.l = z;
        this.m = context;
        jl.a.a.d("image", "origin image url:" + str);
    }

    @Override // il.c
    protected e b() {
        return this.k.m(this.l).c(this.m).j();
    }
}
