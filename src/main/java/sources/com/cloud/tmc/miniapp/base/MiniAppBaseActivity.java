package com.cloud.tmc.miniapp.base;

import android.R;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class MiniAppBaseActivity extends BaseActivity {
    private final Lazy taskTag$delegate = LazyKt.b(new Function0<String>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseActivity$taskTag$2
        {
            super(0);
        }

        public final String invoke() {
            String stringExtra = MiniAppBaseActivity.this.getIntent().getStringExtra(TmcConstants.EXTRA_APP_ID);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat fitsSystemWindows$lambda$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        z0.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.g(insets, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.d);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void fitsSystemWindows() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView().findViewById(R.id.content), new OnApplyWindowInsetsListener() { // from class: com.cloud.tmc.miniapp.base.d
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat fitsSystemWindows$lambda$0;
                fitsSystemWindows$lambda$0 = MiniAppBaseActivity.fitsSystemWindows$lambda$0(view, windowInsetsCompat);
                return fitsSystemWindows$lambda$0;
            }
        });
    }

    public final String getTaskTag() {
        return (String) this.taskTag$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initLayout() {
        super.initLayout();
        if (getLayoutId() > 0) {
            MiniBarUtils.transparentStatusBar(this);
        }
    }
}
