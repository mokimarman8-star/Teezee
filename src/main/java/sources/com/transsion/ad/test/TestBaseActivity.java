package com.transsion.ad.test;

import androidx.appcompat.app.AppCompatActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import xh.b;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/ad/test/TestBaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lxh/b;", "<init>", "()V", BuildConfig.FLAVOR, "getSceneId", "()Ljava/lang/String;", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class TestBaseActivity extends AppCompatActivity implements b {
    @Override // xh.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // xh.b
    public String getSceneId() {
        return BuildConfig.FLAVOR;
    }

    @Override // xh.b
    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }
}
