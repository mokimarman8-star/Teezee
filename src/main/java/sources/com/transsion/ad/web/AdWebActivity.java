package com.transsion.ad.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import ci.i;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a;
import com.transsion.ad.R;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/transsion/ad/web/AdWebActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "a", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdWebActivity extends AppCompatActivity {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.ad.web.AdWebActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.transsion.ad.web.AdWebActivity$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0008a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum.values().length];
                try {
                    iArr[AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum.OVERRIDE_PENDING_TRANSITION_1.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum, String str2) {
            Activity b = a.b();
            if (b == null) {
                return;
            }
            Intent intent = new Intent(b, (Class<?>) AdWebActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("web_activity_extra_log_tag_key", str2);
            intent.addFlags(268435456);
            Utils.a().startActivity(intent);
            if ((adOverridePendingTransitionEnum == null ? -1 : C0008a.a[adOverridePendingTransitionEnum.ordinal()]) == 1) {
                b.overridePendingTransition(R.anim.slide_in_from_top, R.anim.no_anim);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        String str;
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.a c = sh.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        setContentView(c.b());
        AdWebFragment adWebFragment = new AdWebFragment();
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        bundle.putString("url", intent != null ? intent.getStringExtra("url") : null);
        Intent intent2 = getIntent();
        bundle.putString("web_activity_extra_log_tag_key", intent2 != null ? intent2.getStringExtra("web_activity_extra_log_tag_key") : null);
        adWebFragment.setArguments(bundle);
        i iVar = i.a;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        i.b(iVar, supportFragmentManager, R.id.flContain, adWebFragment, false, null, 24, null);
        xh.a aVar = xh.a.a;
        Intent intent3 = getIntent();
        if (intent3 == null || (str = intent3.getStringExtra("web_activity_extra_log_tag_key")) == null) {
            str = "ad_";
        }
        xh.a.m(aVar, str, "AdWebActivity --> onCreate() --> 内置WebView处理广告落地页", 0, false, 12, null);
    }
}
