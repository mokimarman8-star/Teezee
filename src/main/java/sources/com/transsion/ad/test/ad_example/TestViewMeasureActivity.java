package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import android.view.View;
import com.transsion.ad.strategy.t;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xh.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestViewMeasureActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "Lcom/transsion/ad/strategy/t$a;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", BuildConfig.FLAVOR, "isVisible", "onVisibilityChanged", "(Z)V", "Landroid/view/View;", "getVisibilityView", "()Landroid/view/View;", "Lsh/y;", "a", "Lsh/y;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestViewMeasureActivity extends TestBaseActivity implements t.a {

    /* renamed from: a, reason: from kotlin metadata */
    private sh.y binding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(TestViewMeasureActivity testViewMeasureActivity, View view) {
        sh.y yVar = testViewMeasureActivity.binding;
        if (yVar == null) {
            Intrinsics.y("binding");
            yVar = null;
        }
        yVar.c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TestViewMeasureActivity testViewMeasureActivity, View view) {
        sh.y yVar = testViewMeasureActivity.binding;
        if (yVar == null) {
            Intrinsics.y("binding");
            yVar = null;
        }
        yVar.c.setVisibility(0);
    }

    @Override // xh.b
    public String getLogTag() {
        return "view_measure";
    }

    @Override // com.transsion.ad.strategy.t.a
    public double getVisibilityThreshold() {
        return t.a.C0005a.a(this);
    }

    @Override // com.transsion.ad.strategy.t.a
    public View getVisibilityView() {
        sh.y yVar = this.binding;
        if (yVar == null) {
            Intrinsics.y("binding");
            yVar = null;
        }
        View view = yVar.b;
        Intrinsics.g(view, "viewBottom");
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.y c = sh.y.c(getLayoutInflater());
        this.binding = c;
        sh.y yVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        com.transsion.ad.strategy.t.a.j(this);
        sh.y yVar2 = this.binding;
        if (yVar2 == null) {
            Intrinsics.y("binding");
            yVar2 = null;
        }
        yVar2.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestViewMeasureActivity.Q(TestViewMeasureActivity.this, view);
            }
        });
        sh.y yVar3 = this.binding;
        if (yVar3 == null) {
            Intrinsics.y("binding");
        } else {
            yVar = yVar3;
        }
        yVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestViewMeasureActivity.R(TestViewMeasureActivity.this, view);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        com.transsion.ad.strategy.t.a.v(this);
    }

    @Override // com.transsion.ad.strategy.t.a
    public void onVisibilityChanged(boolean isVisible) {
        b.a.c(this, 0, getClassTag() + " --> onVisibilityChanged() --> isVisible = " + isVisible, null, false, 13, null);
    }
}
