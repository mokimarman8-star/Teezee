package com.transsion.ad.test.ad_config;

import android.os.Bundle;
import ci.p;
import com.transsion.ad.strategy.u;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh.r;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdOtherConfigActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Lsh/r;", "a", "Lsh/r;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdOtherConfigActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private r binding;

    @Override // xh.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        r c = r.c(getLayoutInflater());
        this.binding = c;
        r rVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        StringBuilder sb = new StringBuilder();
        sb.append("genre = " + com.transsion.ad.strategy.c.a.b());
        sb.append("\n");
        sb.append("\n");
        p pVar = p.a;
        u uVar = u.a;
        String str = "userCreateTime = " + pVar.a(Long.valueOf(uVar.b()), "yyyy-MM-dd HH:mm:ss");
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "currentDate = " + pVar.a(Long.valueOf(currentTimeMillis), "yyyy-MM-dd HH:mm:ss");
        String str3 = "newUserAdShieldHour = " + uVar.a() + " h";
        String str4 = "相差 = " + pVar.e(uVar.b(), currentTimeMillis);
        String str5 = "isNewUser = " + uVar.c();
        sb.append(str);
        sb.append("\n");
        sb.append(str2);
        sb.append("\n");
        sb.append(str3);
        sb.append("\n");
        sb.append(str4);
        sb.append("\n");
        sb.append(str5);
        sb.append("\n");
        r rVar2 = this.binding;
        if (rVar2 == null) {
            Intrinsics.y("binding");
        } else {
            rVar = rVar2;
        }
        rVar.b.setText(sb.toString());
    }
}
