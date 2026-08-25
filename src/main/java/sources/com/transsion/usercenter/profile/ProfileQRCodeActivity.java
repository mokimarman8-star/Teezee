package com.transsion.usercenter.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.usercenter.profile.dialog.ProfileCameraPermissionDialog;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u001aJ\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/transsion/usercenter/profile/ProfileQRCodeActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lxu/l;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "H0", "O0", HttpUrl.FRAGMENT_ENCODE_SET, "openSetting", "Q0", "(Z)V", "M0", HttpUrl.FRAGMENT_ENCODE_SET, "scannedText", "L0", "(Ljava/lang/String;)V", WebConstants.FIELD_URL, "K0", "(Ljava/lang/String;)Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "n0", "()Z", "onPause", "onDestroy", "I0", "()Lxu/l;", "f0", "()Ljava/lang/String;", "setImmersionStatusBar", "l0", "m0", "k0", "p0", "q0", "retryLoadData", "Landroidx/activity/result/b;", "i", "Landroidx/activity/result/b;", "requestCameraPermissionLauncher", "Laf/a;", "j", "Laf/a;", "callback", "k", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileQRCodeActivity extends BaseNewActivity<xu.l> {

    /* renamed from: i, reason: from kotlin metadata */
    private final androidx.activity.result.b requestCameraPermissionLauncher = registerForActivityResult(new f.i(), new androidx.activity.result.a() { // from class: com.transsion.usercenter.profile.g0
        public final void a(Object obj) {
            ProfileQRCodeActivity.P0(ProfileQRCodeActivity.this, ((Boolean) obj).booleanValue());
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    private final af.a callback = new b();

    public static final class b implements af.a {
        b() {
        }

        public void a(List resultPoints) {
            Intrinsics.h(resultPoints, "resultPoints");
        }

        public void b(af.c result) {
            Intrinsics.h(result, "result");
            if (result.e() != null) {
                ((xu.l) ProfileQRCodeActivity.this.getMViewBinding()).e.pause();
                String e = result.e();
                ProfileQRCodeActivity profileQRCodeActivity = ProfileQRCodeActivity.this;
                Intrinsics.e(e);
                profileQRCodeActivity.L0(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H0() {
        if (androidx.core.content.b.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            return;
        }
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(ProfileQRCodeActivity profileQRCodeActivity, View view) {
        profileQRCodeActivity.finish();
    }

    private final boolean K0(String url) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("oneroom://com.community.oneroom");
        arrayList.add("oneroom://com.community.moviebox");
        arrayList.add("https://v.aoneroom.com");
        arrayList.add("https://h5.aoneroom.com");
        arrayList.add("https://m.mvbrowse.com");
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (StringsKt.W(url, (String) it.next(), false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void L0(String scannedText) {
        if (K0(scannedText)) {
            ij.k.h(scannedText, (String) null, 1, (Object) null);
        } else {
            Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, scannedText + (StringsKt.c0(scannedText, "?", false, 2, null) ? "&" : "?") + "web_unlock_key=web_unlock_value"), this, (mf.c) null, 2, (Object) null);
        }
        finish();
    }

    private final void M0() {
        ActivityPermissionUtil.a.c("android.settings.APPLICATION_DETAILS_SETTINGS", 1023, new Function0() { // from class: com.transsion.usercenter.profile.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N0;
                N0 = ProfileQRCodeActivity.N0(ProfileQRCodeActivity.this);
                return N0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit N0(ProfileQRCodeActivity profileQRCodeActivity) {
        if (androidx.core.content.b.checkSelfPermission(profileQRCodeActivity, "android.permission.CAMERA") == 0) {
            return Unit.a;
        }
        profileQRCodeActivity.Q0(true);
        return Unit.a;
    }

    private final void O0() {
        this.requestCameraPermissionLauncher.a("android.permission.CAMERA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P0(ProfileQRCodeActivity profileQRCodeActivity, boolean z) {
        if (z) {
            ((xu.l) profileQRCodeActivity.getMViewBinding()).e.resume();
        } else if (profileQRCodeActivity.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            profileQRCodeActivity.Q0(false);
        } else {
            profileQRCodeActivity.Q0(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q0(final boolean openSetting) {
        ProfileCameraPermissionDialog profileCameraPermissionDialog = new ProfileCameraPermissionDialog();
        profileCameraPermissionDialog.u0(new Function1() { // from class: com.transsion.usercenter.profile.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = ProfileQRCodeActivity.R0(openSetting, this, ((Boolean) obj).booleanValue());
                return R0;
            }
        });
        profileCameraPermissionDialog.k0(this, "ProfileCameraPermissionDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(boolean z, ProfileQRCodeActivity profileQRCodeActivity, boolean z2) {
        if (!z2) {
            profileQRCodeActivity.finish();
        } else if (z) {
            profileQRCodeActivity.M0();
        } else {
            profileQRCodeActivity.O0();
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public xu.l getViewBinding() {
        xu.l c = xu.l.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void k0() {
        ((xu.l) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileQRCodeActivity.J0(ProfileQRCodeActivity.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        ((xu.l) getMViewBinding()).e.setDecoderFactory(new af.k(CollectionsKt.o(new BarcodeFormat[]{BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39})));
        ((xu.l) getMViewBinding()).e.initializeFromIntent(getIntent());
        ((xu.l) getMViewBinding()).e.decodeContinuous(this.callback);
        ImageView vStatusSpace = ((xu.l) getMViewBinding()).d;
        Intrinsics.g(vStatusSpace, "vStatusSpace");
        uf.c.e(vStatusSpace);
    }

    public void m0() {
    }

    public boolean n0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(128);
        ImmersionBar.with(this).transparentBar().init();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        ((xu.l) getMViewBinding()).e.pause();
    }

    public void onResume() {
        super.onResume();
        ((xu.l) getMViewBinding()).e.resume();
    }

    public void p0() {
    }

    public void q0() {
        super.q0();
        H0();
    }

    public void retryLoadData() {
    }

    public boolean setImmersionStatusBar() {
        return false;
    }
}
