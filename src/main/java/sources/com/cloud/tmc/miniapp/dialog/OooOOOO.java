package com.cloud.tmc.miniapp.dialog;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooOOOO extends com.cloud.tmc.miniapp.dialog.OooO0O0 implements View.OnTouchListener, View.OnClickListener {
    public boolean OooO0o;
    public final BottomSheetBehavior<FrameLayout> OooO0o0;
    public boolean OooO0oO;
    public boolean OooO0oo;

    public final class OooO00o extends AccessibilityDelegateCompat {
        public OooO00o() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Intrinsics.h(view, "host");
            Intrinsics.h(accessibilityNodeInfoCompat, "info");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!OooOOOO.this.OooO0o) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(MemoryConstants.MB);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            Intrinsics.h(view, "host");
            if (i == 1048576) {
                OooOOOO oooOOOO = OooOOOO.this;
                if (oooOOOO.OooO0o) {
                    oooOOOO.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    public final class OooO0O0 extends BottomSheetBehavior.f {
        public OooO0O0() {
        }

        public void onSlide(View view, float f) {
            Intrinsics.h(view, "bottomSheet");
        }

        public void onStateChanged(View view, int i) {
            Intrinsics.h(view, "bottomSheet");
            if (i == 5) {
                OooOOOO.this.cancel();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OooOOOO(Context context, int i) {
        super(context, i);
        Intrinsics.h(context, "context");
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = new BottomSheetBehavior<>(getContext(), (AttributeSet) null);
        this.OooO0o0 = bottomSheetBehavior;
        this.OooO0o = true;
        this.OooO0oO = true;
        bottomSheetBehavior.Y(new OooO0O0());
        bottomSheetBehavior.M0(this.OooO0o);
        supportRequestWindowFeature(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View OooO00o(View view) {
        CoordinatorLayout coordinatorLayout = new CoordinatorLayout(getContext());
        coordinatorLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view2 = new View(getContext());
        view2.setSoundEffectsEnabled(false);
        view2.setImportantForAccessibility(2);
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        CoordinatorLayout.f fVar = new CoordinatorLayout.f(-1, -2);
        fVar.c = 49;
        fVar.o(this.OooO0o0);
        frameLayout.setLayoutParams(fVar);
        ViewExtKt.removeSelf(view);
        frameLayout.addView(view);
        ViewExtKt.removeSelf(view2);
        coordinatorLayout.addView(view2);
        ViewExtKt.removeSelf(frameLayout);
        coordinatorLayout.addView(frameLayout);
        view2.setOnClickListener(this);
        ViewCompat.setAccessibilityDelegate(frameLayout, new OooO00o());
        frameLayout.setOnTouchListener(this);
        return coordinatorLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void cancel() {
        if (this.OooO0o0.q0() == 5) {
            super/*android.app.Dialog*/.cancel();
        } else {
            this.OooO0o0.U0(5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.h(view, "view");
        if (this.OooO0o && isShowing()) {
            if (!this.OooO0oo) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…ndowCloseOnTouchOutside))");
                this.OooO0oO = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                this.OooO0oo = true;
            }
            if (this.OooO0oO) {
                cancel();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        Intrinsics.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4098);
        window.setLayout(-1, -1);
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0
    public void onStart() {
        super.onStart();
        if (this.OooO0o0.q0() != 5) {
            return;
        }
        this.OooO0o0.U0(4);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCancelable(boolean z) {
        super/*android.app.Dialog*/.setCancelable(z);
        if (this.OooO0o == z) {
            return;
        }
        this.OooO0o = z;
        this.OooO0o0.M0(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCanceledOnTouchOutside(boolean z) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(z);
        if (z && !this.OooO0o) {
            this.OooO0o = true;
        }
        this.OooO0oO = z;
        this.OooO0oo = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentView(int i) {
        View inflate = getLayoutInflater().inflate(i, (ViewGroup) null, false);
        Intrinsics.g(inflate, "layoutInflater.inflate(layoutResId, null, false)");
        super.setContentView(OooO00o(inflate));
    }

    public void setContentView(View view) {
        Intrinsics.h(view, "view");
        super.setContentView(OooO00o(view));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.h(view, "view");
        view.setLayoutParams(layoutParams);
        super.setContentView(OooO00o(view));
    }
}
