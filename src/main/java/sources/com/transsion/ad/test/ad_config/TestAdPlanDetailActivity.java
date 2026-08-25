package com.transsion.ad.test.ad_config;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.ad.view.JsonViewer;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh.s;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPlanDetailActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Lsh/s;", "a", "Lsh/s;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdPlanDetailActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private s binding;

    @Override // xh.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        Serializable serializableExtra;
        Serializable serializableExtra2;
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        s c = s.c(getLayoutInflater());
        this.binding = c;
        s sVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        if (Build.VERSION.SDK_INT >= 33) {
            Intent intent = getIntent();
            if (intent != null) {
                serializableExtra2 = intent.getSerializableExtra("MbAdDbPlans", MbAdDbPlans.class);
                serializableExtra = (MbAdDbPlans) serializableExtra2;
            }
            serializableExtra = null;
        } else {
            Intent intent2 = getIntent();
            if (intent2 != null) {
                serializableExtra = intent2.getSerializableExtra("MbAdDbPlans");
            }
            serializableExtra = null;
        }
        s sVar2 = this.binding;
        if (sVar2 == null) {
            Intrinsics.y("binding");
        } else {
            sVar = sVar2;
        }
        JsonViewer jsonViewer = sVar.b;
        String json = o.f().toJson(serializableExtra);
        Intrinsics.g(json, "toJson(...)");
        jsonViewer.setJson(json, 4);
    }
}
