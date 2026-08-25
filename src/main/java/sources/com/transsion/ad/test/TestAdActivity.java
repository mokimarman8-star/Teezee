package com.transsion.ad.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.strategy.e;
import com.transsion.ad.test.TestAdActivity;
import com.transsion.ad.test.ad_config.TestAdOtherConfigActivity;
import com.transsion.ad.test.ad_config.TestAdPlansActivity;
import com.transsion.ad.test.ad_config.TestAdPsOfferActivity;
import com.transsion.ad.test.ad_config.TestAdSceneActivity;
import com.transsion.ad.test.ad_example.TestAdAExampleActivity;
import com.transsion.core.utils.ToastUtil;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rh.f;
import sh.m;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/transsion/ad/test/TestAdActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "f0", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lsh/m;", "a", "Lsh/m;", "binding", "b", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdActivity extends TestBaseActivity {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private m binding;

    /* renamed from: com.transsion.ad.test.TestAdActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(AppCompatActivity appCompatActivity) {
            Intrinsics.h(appCompatActivity, "activity");
            appCompatActivity.startActivity(new Intent((Context) appCompatActivity, (Class<?>) TestAdActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(TestAdActivity testAdActivity, View view) {
        f.a.f(!r2.b());
        testAdActivity.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(View view) {
        e eVar = e.a;
        eVar.c().putString("non_ad_scene_version", BuildConfig.FLAVOR);
        eVar.c().putString("non_ad_plan_version", BuildConfig.FLAVOR);
        ToastUtil.f("已重置版本号缓存，请重启应用测试效果。");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Button button, View view) {
        f fVar = f.a;
        fVar.g(fVar.c() != null ? Boolean.valueOf(!r0.booleanValue()) : null);
        button.setText("未命中的广告计划 输出日志 = " + fVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a0(TestAdActivity testAdActivity, View view) {
        testAdActivity.startActivity(new Intent((Context) testAdActivity, (Class<?>) TestAdSceneActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b0(TestAdActivity testAdActivity, View view) {
        testAdActivity.startActivity(new Intent((Context) testAdActivity, (Class<?>) TestAdPlansActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c0(TestAdActivity testAdActivity, View view) {
        testAdActivity.startActivity(new Intent((Context) testAdActivity, (Class<?>) TestAdPsOfferActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void d0(TestAdActivity testAdActivity, View view) {
        testAdActivity.startActivity(new Intent((Context) testAdActivity, (Class<?>) TestAdOtherConfigActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e0(TestAdActivity testAdActivity, View view) {
        testAdActivity.startActivity(new Intent((Context) testAdActivity, (Class<?>) TestAdAExampleActivity.class));
    }

    private final void f0() {
        m mVar = this.binding;
        if (mVar == null) {
            Intrinsics.y("binding");
            mVar = null;
        }
        mVar.d.setText(f.a.b() ? "isGlobalAdOff = true" : "isGlobalAdOff = false");
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        m c = m.c(getLayoutInflater());
        this.binding = c;
        m mVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        m mVar2 = this.binding;
        if (mVar2 == null) {
            Intrinsics.y("binding");
            mVar2 = null;
        }
        Button button = mVar2.d;
        f0();
        button.setOnClickListener(new View.OnClickListener() { // from class: bi.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.X(TestAdActivity.this, view);
            }
        });
        m mVar3 = this.binding;
        if (mVar3 == null) {
            Intrinsics.y("binding");
            mVar3 = null;
        }
        mVar3.h.setOnClickListener(new View.OnClickListener() { // from class: bi.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.Y(view);
            }
        });
        m mVar4 = this.binding;
        if (mVar4 == null) {
            Intrinsics.y("binding");
            mVar4 = null;
        }
        final Button button2 = mVar4.e;
        button2.setOnClickListener(new View.OnClickListener() { // from class: bi.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.Z(button2, view);
            }
        });
        button2.setText("未命中的广告计划 输出日志 = " + f.a.c());
        m mVar5 = this.binding;
        if (mVar5 == null) {
            Intrinsics.y("binding");
            mVar5 = null;
        }
        mVar5.i.setOnClickListener(new View.OnClickListener() { // from class: bi.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.a0(TestAdActivity.this, view);
            }
        });
        m mVar6 = this.binding;
        if (mVar6 == null) {
            Intrinsics.y("binding");
            mVar6 = null;
        }
        mVar6.c.setOnClickListener(new View.OnClickListener() { // from class: bi.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.b0(TestAdActivity.this, view);
            }
        });
        m mVar7 = this.binding;
        if (mVar7 == null) {
            Intrinsics.y("binding");
            mVar7 = null;
        }
        mVar7.g.setOnClickListener(new View.OnClickListener() { // from class: bi.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.c0(TestAdActivity.this, view);
            }
        });
        m mVar8 = this.binding;
        if (mVar8 == null) {
            Intrinsics.y("binding");
            mVar8 = null;
        }
        mVar8.f.setOnClickListener(new View.OnClickListener() { // from class: bi.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.d0(TestAdActivity.this, view);
            }
        });
        m mVar9 = this.binding;
        if (mVar9 == null) {
            Intrinsics.y("binding");
        } else {
            mVar = mVar9;
        }
        mVar.b.setOnClickListener(new View.OnClickListener() { // from class: bi.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.e0(TestAdActivity.this, view);
            }
        });
    }
}
