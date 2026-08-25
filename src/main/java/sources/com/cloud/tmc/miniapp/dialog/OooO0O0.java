package com.cloud.tmc.miniapp.dialog;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.j0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.action.ActivityAction;
import com.cloud.tmc.miniapp.action.AnimAction;
import com.cloud.tmc.miniapp.action.ClickAction;
import com.cloud.tmc.miniapp.action.HandlerAction;
import com.cloud.tmc.miniapp.action.KeyboardAction;
import com.cloud.tmc.miniapp.action.ResourcesAction;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO0O0 extends androidx.appcompat.app.w implements ActivityAction, ResourcesAction, HandlerAction, ClickAction, AnimAction, KeyboardAction, DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public final OooOO0O<OooO0O0> OooO00o;
    public List<Oooo000> OooO0O0;
    public List<OooOOO0> OooO0OO;
    public List<OooOo00> OooO0Oo;

    public interface OooO {
    }

    public static class OooO00o<B extends OooO00o<B>> implements ActivityAction, ResourcesAction, ClickAction, KeyboardAction {
        private int animStyle;
        private float backgroundDimAmount;
        private boolean backgroundDimEnabled;
        private final Lazy cancelListeners$delegate;
        private boolean cancelable;
        private boolean canceledOnTouchOutside;
        private SparseArray<OooOOO<View>> clickArray;
        private View contentView;
        private final Context context;
        private OooOOOO createListener;
        private OooO0O0 dialog;
        private final Lazy dismissListeners$delegate;
        private OooO extendToEdgesListener;
        private int gravity;
        private int height;
        private OooOo keyListener;
        private final Lazy showListeners$delegate;
        private int themeId;
        private int width;
        private int xOffset;
        private int yOffset;

        /* renamed from: com.cloud.tmc.miniapp.dialog.OooO0O0$OooO00o$OooO00o, reason: collision with other inner class name */
        public static final class C0005OooO00o extends Lambda implements Function0<ArrayList<OooOOO0>> {
            public static final C0005OooO00o OooO00o = new C0005OooO00o();

            public C0005OooO00o() {
                super(0);
            }

            public Object invoke() {
                return new ArrayList();
            }
        }

        /* renamed from: com.cloud.tmc.miniapp.dialog.OooO0O0$OooO00o$OooO0O0, reason: collision with other inner class name */
        public static final class C0006OooO0O0 extends Lambda implements Function0<ArrayList<OooOo00>> {
            public static final C0006OooO0O0 OooO00o = new C0006OooO0O0();

            public C0006OooO0O0() {
                super(0);
            }

            public Object invoke() {
                return new ArrayList();
            }
        }

        public static final class OooO0OO extends Lambda implements Function0<ArrayList<Oooo000>> {
            public static final OooO0OO OooO00o = new OooO0OO();

            public OooO0OO() {
                super(0);
            }

            public Object invoke() {
                return new ArrayList();
            }
        }

        public OooO00o(Context context) {
            Intrinsics.h(context, "context");
            this.context = context;
            this.themeId = R.style.MiniSDKDialogTheme;
            this.animStyle = -1;
            this.width = -2;
            this.height = -2;
            this.cancelable = true;
            this.canceledOnTouchOutside = true;
            this.backgroundDimEnabled = true;
            this.backgroundDimAmount = 0.5f;
            this.showListeners$delegate = LazyKt.b(OooO0OO.OooO00o);
            this.cancelListeners$delegate = LazyKt.b(C0005OooO00o.OooO00o);
            this.dismissListeners$delegate = LazyKt.b(C0006OooO0O0.OooO00o);
        }

        private final List<OooOOO0> getCancelListeners() {
            return (List) this.cancelListeners$delegate.getValue();
        }

        private final List<OooOo00> getDismissListeners() {
            return (List) this.dismissListeners$delegate.getValue();
        }

        private final List<Oooo000> getShowListeners() {
            return (List) this.showListeners$delegate.getValue();
        }

        public B addOnCancelListener(OooOOO0 oooOOO0) {
            Intrinsics.h(oooOOO0, "listener");
            getCancelListeners().add(oooOOO0);
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B addOnDismissListener(OooOo00 oooOo00) {
            Intrinsics.h(oooOo00, "listener");
            getDismissListeners().add(oooOo00);
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B addOnShowListener(Oooo000 oooo000) {
            Intrinsics.h(oooo000, "listener");
            getShowListeners().add(oooo000);
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Dialog, androidx.appcompat.app.w, com.cloud.tmc.miniapp.dialog.OooO0O0, java.lang.Object] */
        public OooO0O0 create() {
            if (this.contentView == null) {
                throw new IllegalArgumentException("are you ok?");
            }
            if (isShowing()) {
                dismiss();
            }
            if (this.gravity == 0) {
                this.gravity = 17;
            }
            int i = -1;
            if (this.animStyle == -1) {
                int i2 = this.gravity;
                if (i2 == 3) {
                    i = AnimAction.Companion.getANIM_LEFT();
                } else if (i2 == 5) {
                    i = AnimAction.Companion.getANIM_RIGHT();
                } else if (i2 == 48) {
                    i = AnimAction.Companion.getANIM_TOP();
                } else if (i2 == 80) {
                    i = AnimAction.Companion.getANIM_BOTTOM();
                }
                this.animStyle = i;
            }
            ?? createDialog = createDialog(this.context, this.themeId);
            this.dialog = createDialog;
            Intrinsics.e((Object) createDialog);
            View view = this.contentView;
            Intrinsics.e(view);
            createDialog.setContentView(view);
            createDialog.setCancelable(this.cancelable);
            if (this.cancelable) {
                createDialog.setCanceledOnTouchOutside(this.canceledOnTouchOutside);
            }
            OooO0O0.OooO0OO(createDialog, getShowListeners());
            OooO0O0.OooO00o(createDialog, getCancelListeners());
            OooO0O0.OooO0O0(createDialog, getDismissListeners());
            createDialog.OooO00o(this.keyListener);
            Window window = createDialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Intrinsics.g(attributes, "window.attributes");
                attributes.width = this.width;
                attributes.height = this.height;
                attributes.gravity = this.gravity;
                attributes.x = this.xOffset;
                attributes.y = this.yOffset;
                attributes.windowAnimations = this.animStyle;
                if (this.backgroundDimEnabled) {
                    window.addFlags(2);
                    window.setDimAmount(this.backgroundDimAmount);
                } else {
                    window.clearFlags(2);
                }
                window.setAttributes(attributes);
            }
            SparseArray<OooOOO<View>> sparseArray = this.clickArray;
            if (sparseArray != null) {
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    View view2 = this.contentView;
                    Intrinsics.e(view2);
                    View findViewById = view2.findViewById(sparseArray.keyAt(i3));
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new o00Oo0(createDialog, sparseArray.valueAt(i3)));
                    }
                }
            }
            Activity activity = getActivity();
            if (activity != null) {
                Intrinsics.h(activity, "activity");
                new OooO0OO(activity, createDialog);
            }
            OooOOOO oooOOOO = this.createListener;
            if (oooOOOO != 0) {
                oooOOOO.onCreate(createDialog);
            }
            OooO0O0 oooO0O0 = this.dialog;
            Intrinsics.e(oooO0O0);
            return oooO0O0;
        }

        public OooO0O0 createDialog(Context context, int i) {
            Intrinsics.h(context, "context");
            return new OooO0O0(context, i);
        }

        public void dismiss() {
            OooO0O0 oooO0O0;
            try {
                Activity activity = getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed() || (oooO0O0 = this.dialog) == null) {
                    return;
                }
                oooO0O0.dismiss();
            } catch (Throwable th) {
                TmcLogger.e("BaseDialog", "dismiss ->" + th);
            }
        }

        @Override // com.cloud.tmc.miniapp.action.ClickAction
        public <V extends View> V findViewById(int i) {
            View view = this.contentView;
            if (view != null) {
                return (V) view.findViewById(i);
            }
            throw new IllegalStateException("are you ok?");
        }

        @Override // com.cloud.tmc.miniapp.action.ActivityAction
        public Activity getActivity() {
            return ActivityAction.DefaultImpls.getActivity(this);
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public int getColor(int i) {
            return ResourcesAction.DefaultImpls.getColor(this, i);
        }

        public View getContentView() {
            return this.contentView;
        }

        @Override // com.cloud.tmc.miniapp.action.ActivityAction
        public Context getContext() {
            return this.context;
        }

        public OooO0O0 getDialog() {
            return this.dialog;
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public Drawable getDrawable(int i) {
            return ResourcesAction.DefaultImpls.getDrawable(this, i);
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public Resources getResources() {
            return ResourcesAction.DefaultImpls.getResources(this);
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public String getString(int i) {
            return ResourcesAction.DefaultImpls.getString(this, i);
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public String getString(int i, Object... objArr) {
            return ResourcesAction.DefaultImpls.getString(this, i, objArr);
        }

        @Override // com.cloud.tmc.miniapp.action.ResourcesAction
        public <S> S getSystemService(Class<S> cls) {
            return (S) ResourcesAction.DefaultImpls.getSystemService(this, cls);
        }

        @Override // com.cloud.tmc.miniapp.action.KeyboardAction
        public void hideKeyboard(View view) {
            KeyboardAction.DefaultImpls.hideKeyboard(this, view);
        }

        public boolean isCreated() {
            return this.dialog != null;
        }

        public boolean isShowing() {
            androidx.appcompat.app.w wVar;
            return isCreated() && (wVar = this.dialog) != null && wVar.isShowing();
        }

        public void onClick(View view) {
            ClickAction.DefaultImpls.onClick(this, view);
        }

        public void post(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            if (!isShowing()) {
                addOnShowListener(new o00O0O(runnable));
                return;
            }
            OooO0O0 oooO0O0 = this.dialog;
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.post(oooO0O0, runnable);
            }
        }

        public void postAtTime(Runnable runnable, long j) {
            Intrinsics.h(runnable, "runnable");
            if (!isShowing()) {
                addOnShowListener(new o000oOoO(runnable, j));
                return;
            }
            OooO0O0 oooO0O0 = this.dialog;
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.postAtTime(oooO0O0, runnable, j);
            }
        }

        public void postDelayed(Runnable runnable, long j) {
            Intrinsics.h(runnable, "runnable");
            if (!isShowing()) {
                addOnShowListener(new o0OoOo0(runnable, j));
                return;
            }
            OooO0O0 oooO0O0 = this.dialog;
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.postDelayed(oooO0O0, runnable, j);
            }
        }

        public B setAnimStyle(int i) {
            androidx.appcompat.app.w wVar;
            Window window;
            this.animStyle = i;
            if (isCreated() && (wVar = this.dialog) != null && (window = wVar.getWindow()) != null) {
                window.setWindowAnimations(i);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setBackground(int i, int i2) {
            return setBackground(i, androidx.core.content.b.getDrawable(this.context, i2));
        }

        public B setBackground(int i, Drawable drawable) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                findViewById.setBackground(drawable);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setBackgroundDimAmount(float f) {
            androidx.appcompat.app.w wVar;
            Window window;
            this.backgroundDimAmount = f;
            if (isCreated() && (wVar = this.dialog) != null && (window = wVar.getWindow()) != null) {
                window.setDimAmount(f);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setBackgroundDimEnabled(boolean z) {
            androidx.appcompat.app.w wVar;
            this.backgroundDimEnabled = z;
            if (isCreated() && (wVar = this.dialog) != null) {
                if (z) {
                    Window window = wVar.getWindow();
                    if (window != null) {
                        window.addFlags(2);
                    }
                } else {
                    Window window2 = wVar.getWindow();
                    if (window2 != null) {
                        window2.clearFlags(2);
                    }
                }
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setCancelable(boolean z) {
            androidx.appcompat.app.w wVar;
            this.cancelable = z;
            if (isCreated() && (wVar = this.dialog) != null) {
                wVar.setCancelable(z);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setCanceledOnTouchOutside(boolean z) {
            androidx.appcompat.app.w wVar;
            this.canceledOnTouchOutside = z;
            if (isCreated() && this.cancelable && (wVar = this.dialog) != null) {
                wVar.setCanceledOnTouchOutside(z);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setContentView(int i) {
            return setContentView(LayoutInflater.from(this.context).inflate(i, (ViewGroup) new FrameLayout(this.context), false));
        }

        public B setContentView(View view) {
            int i;
            if (view == null) {
                throw new IllegalArgumentException("are you ok?");
            }
            this.contentView = view;
            if (isCreated()) {
                OooO0O0 oooO0O0 = this.dialog;
                if (oooO0O0 != null) {
                    oooO0O0.setContentView(view);
                }
                Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                return this;
            }
            View view2 = this.contentView;
            ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
            if (layoutParams != null && this.width == -2 && this.height == -2) {
                setWidth(layoutParams.width);
                setHeight(layoutParams.height);
            }
            if (this.gravity == 0) {
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    int i2 = ((FrameLayout.LayoutParams) layoutParams).gravity;
                    if (i2 != -1) {
                        setGravity(i2);
                    }
                } else if ((layoutParams instanceof LinearLayout.LayoutParams) && (i = ((LinearLayout.LayoutParams) layoutParams).gravity) != 0) {
                    setGravity(i);
                }
                if (this.gravity == 0) {
                    setGravity(17);
                }
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public void setExtendToEdgesListener(OooO oooO) {
            Intrinsics.h(oooO, "listener");
            this.extendToEdgesListener = oooO;
        }

        public B setGravity(int i) {
            androidx.appcompat.app.w wVar;
            Window window;
            this.gravity = Gravity.getAbsoluteGravity(i, getResources().getConfiguration().getLayoutDirection());
            if (isCreated() && (wVar = this.dialog) != null && (window = wVar.getWindow()) != null) {
                window.setGravity(i);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setHeight(int i) {
            Window window;
            this.height = i;
            if (isCreated()) {
                androidx.appcompat.app.w wVar = this.dialog;
                if (wVar != null && (window = wVar.getWindow()) != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        attributes.height = i;
                    }
                    window.setAttributes(attributes);
                }
                Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                return this;
            }
            View view = this.contentView;
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = i;
                View view2 = this.contentView;
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setHint(int i, int i2) {
            return setHint(i, getString(i2));
        }

        public B setHint(int i, CharSequence charSequence) {
            TextView textView = (TextView) findViewById(i);
            if (textView != null) {
                textView.setHint(charSequence);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setImageDrawable(int i, int i2) {
            return setBackground(i, androidx.core.content.b.getDrawable(this.context, i2));
        }

        public B setImageDrawable(int i, Drawable drawable) {
            ImageView imageView = (ImageView) findViewById(i);
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setOnClickListener(int i, OooOOO<? extends View> oooOOO) {
            OooO0O0 oooO0O0;
            View findViewById;
            Intrinsics.h(oooOOO, "listener");
            if (this.clickArray == null) {
                this.clickArray = new SparseArray<>();
            }
            SparseArray<OooOOO<View>> sparseArray = this.clickArray;
            Intrinsics.e(sparseArray);
            sparseArray.put(i, oooOOO);
            if (isCreated() && (oooO0O0 = this.dialog) != null && (findViewById = oooO0O0.findViewById(i)) != null) {
                findViewById.setOnClickListener(new o00Oo0(this.dialog, oooOOO));
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        @Override // com.cloud.tmc.miniapp.action.ClickAction
        public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
            ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, iArr);
        }

        @Override // com.cloud.tmc.miniapp.action.ClickAction
        public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
            ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, viewArr);
        }

        @Override // com.cloud.tmc.miniapp.action.ClickAction
        public void setOnClickListener(int... iArr) {
            ClickAction.DefaultImpls.setOnClickListener(this, iArr);
        }

        @Override // com.cloud.tmc.miniapp.action.ClickAction
        public void setOnClickListener(View... viewArr) {
            ClickAction.DefaultImpls.setOnClickListener(this, viewArr);
        }

        public B setOnCreateListener(OooOOOO oooOOOO) {
            Intrinsics.h(oooOOOO, "listener");
            this.createListener = oooOOOO;
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setOnKeyListener(OooOo oooOo) {
            OooO0O0 oooO0O0;
            Intrinsics.h(oooOo, "listener");
            this.keyListener = oooOo;
            if (isCreated() && (oooO0O0 = this.dialog) != null) {
                oooO0O0.OooO00o(oooOo);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setText(int i, int i2) {
            return setText(i, getString(i2));
        }

        public B setText(int i, CharSequence charSequence) {
            TextView textView = (TextView) findViewById(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setTextColor(int i, int i2) {
            TextView textView = (TextView) findViewById(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setThemeStyle(int i) {
            this.themeId = i;
            if (isCreated()) {
                throw new IllegalStateException("are you ok?");
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setVisibility(int i, int i2) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                findViewById.setVisibility(i2);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setWidth(int i) {
            Window window;
            this.width = i;
            if (isCreated()) {
                androidx.appcompat.app.w wVar = this.dialog;
                if (wVar != null && (window = wVar.getWindow()) != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        attributes.width = i;
                    }
                    window.setAttributes(attributes);
                }
                Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
                return this;
            }
            View view = this.contentView;
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.width = i;
                View view2 = this.contentView;
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setXOffset(int i) {
            androidx.appcompat.app.w wVar;
            Window window;
            this.xOffset = i;
            if (isCreated() && (wVar = this.dialog) != null && (window = wVar.getWindow()) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (attributes != null) {
                    attributes.x = i;
                }
                window.setAttributes(attributes);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public B setYOffset(int i) {
            androidx.appcompat.app.w wVar;
            Window window;
            this.yOffset = i;
            if (isCreated() && (wVar = this.dialog) != null && (window = wVar.getWindow()) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (attributes != null) {
                    attributes.y = i;
                }
                window.setAttributes(attributes);
            }
            Intrinsics.f(this, "null cannot be cast to non-null type B of com.cloud.tmc.miniapp.dialog.BaseDialog.Builder");
            return this;
        }

        public void show() {
            androidx.appcompat.app.w wVar;
            try {
                Activity activity = getActivity();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    if (!isCreated()) {
                        create();
                    }
                    if (isShowing() || (wVar = this.dialog) == null) {
                        return;
                    }
                    wVar.show();
                }
            } catch (Throwable th) {
                TmcLogger.e("BaseDialog", "show ->" + th);
            }
        }

        @Override // com.cloud.tmc.miniapp.action.KeyboardAction
        public void showKeyboard(View view) {
            KeyboardAction.DefaultImpls.showKeyboard(this, view);
        }

        @Override // com.cloud.tmc.miniapp.action.KeyboardAction
        public void toggleSoftInput(View view) {
            KeyboardAction.DefaultImpls.toggleSoftInput(this, view);
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.dialog.OooO0O0$OooO0O0, reason: collision with other inner class name */
    public static final class C0007OooO0O0 extends SoftReference<DialogInterface.OnCancelListener> implements OooOOO0 {
        public C0007OooO0O0(DialogInterface.OnCancelListener onCancelListener) {
            super(onCancelListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOOO0
        public void OooO00o(OooO0O0 oooO0O0) {
            DialogInterface.OnCancelListener onCancelListener = get();
            if (onCancelListener != null) {
                onCancelListener.onCancel(oooO0O0);
            }
        }
    }

    public static final class OooO0OO implements Application.ActivityLifecycleCallbacks, Oooo000, OooOo00 {
        public Activity OooO00o;
        public OooO0O0 OooO0O0;
        public int OooO0OO;

        public OooO0OO(Activity activity, OooO0O0 oooO0O0) {
            this.OooO00o = activity;
            this.OooO0O0 = oooO0O0;
            if (oooO0O0 != null) {
                oooO0O0.OooO00o((Oooo000) this);
            }
            OooO0O0 oooO0O02 = this.OooO0O0;
            if (oooO0O02 != null) {
                oooO0O02.OooO00o((OooOo00) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void OooO00o(OooO0O0 oooO0O0, OooO0OO oooO0OO) {
            Intrinsics.h(oooO0O0, "$it");
            Intrinsics.h(oooO0OO, "this$0");
            if (oooO0O0.isShowing()) {
                oooO0O0.OooO00o(oooO0OO.OooO0OO);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.h(activity, "activity");
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Dialog, com.cloud.tmc.miniapp.dialog.OooO0O0] */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.h(activity, "activity");
            Activity activity2 = this.OooO00o;
            if (activity2 != activity) {
                return;
            }
            if (activity2 != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity2.unregisterActivityLifecycleCallbacks(this);
                } else {
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }
            }
            this.OooO00o = null;
            ?? r0 = this.OooO0O0;
            if (r0 != 0) {
                List<Oooo000> list = r0.OooO0O0;
                if (list != null) {
                    list.remove(this);
                }
                List<OooOo00> list2 = r0.OooO0Oo;
                if (list2 != null) {
                    list2.remove(this);
                }
                if (r0.isShowing()) {
                    r0.dismiss();
                }
            }
            this.OooO0O0 = null;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.app.Dialog, com.cloud.tmc.miniapp.dialog.OooO0O0] */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ?? r2;
            Intrinsics.h(activity, "activity");
            if (this.OooO00o == activity && (r2 = this.OooO0O0) != 0 && r2.isShowing()) {
                Window window = r2.getWindow();
                this.OooO0OO = window == null ? -1 : window.getAttributes().windowAnimations;
                r2.OooO00o(0);
            }
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.cloud.tmc.miniapp.action.HandlerAction, com.cloud.tmc.miniapp.dialog.OooO0O0] */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            final ?? r4;
            Intrinsics.h(activity, "activity");
            if (this.OooO00o == activity && (r4 = this.OooO0O0) != 0 && r4.isShowing()) {
                HandlerAction.DefaultImpls.postDelayed(r4, new Runnable() { // from class: com.cloud.tmc.miniapp.dialog.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0O0.OooO0OO.OooO00o(OooO0O0.this, this);
                    }
                }, 100L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.h(activity, "activity");
            Intrinsics.h(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.h(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.h(activity, "activity");
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(OooO0O0 oooO0O0) {
            this.OooO0O0 = null;
            Activity activity = this.OooO00o;
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    activity.unregisterActivityLifecycleCallbacks(this);
                } else {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                }
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(OooO0O0 oooO0O0) {
            this.OooO0O0 = oooO0O0;
            Activity activity = this.OooO00o;
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    j0.a(activity, this);
                } else {
                    activity.getApplication().registerActivityLifecycleCallbacks(this);
                }
            }
        }
    }

    public static final class OooO0o extends SoftReference<DialogInterface.OnDismissListener> implements OooOo00 {
        public OooO0o(DialogInterface.OnDismissListener onDismissListener) {
            super(onDismissListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(OooO0O0 oooO0O0) {
            DialogInterface.OnDismissListener onDismissListener = get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(oooO0O0);
            }
        }
    }

    public static final class OooOO0 implements DialogInterface.OnKeyListener {
        public final OooOo OooO00o;

        public OooOO0(OooOo oooOo) {
            this.OooO00o = oooOo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            OooOo oooOo = this.OooO00o;
            if (oooOo == null || !(dialogInterface instanceof OooO0O0)) {
                return false;
            }
            return oooOo.OooO00o((OooO0O0) dialogInterface, i, keyEvent);
        }
    }

    public static final class OooOO0O<T extends DialogInterface.OnShowListener & DialogInterface.OnCancelListener & DialogInterface.OnDismissListener> extends SoftReference<T> implements DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
        public OooOO0O(T t) {
            super(t);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = (DialogInterface.OnShowListener) get();
            if (onShowListener != null) {
                ((DialogInterface.OnCancelListener) onShowListener).onCancel(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = (DialogInterface.OnShowListener) get();
            if (onShowListener != null) {
                ((DialogInterface.OnDismissListener) onShowListener).onDismiss(dialogInterface);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = (DialogInterface.OnShowListener) get();
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    public interface OooOOO<V extends View> {
        void OooO00o(OooO0O0 oooO0O0, V v);
    }

    public interface OooOOO0 {
        void OooO00o(OooO0O0 oooO0O0);
    }

    public interface OooOOOO {
        void onCreate(OooO0O0 oooO0O0);
    }

    public interface OooOo {
        boolean OooO00o(OooO0O0 oooO0O0, int i, KeyEvent keyEvent);
    }

    public interface OooOo00 {
        void onDismiss(OooO0O0 oooO0O0);
    }

    public static final class Oooo0 extends SoftReference<DialogInterface.OnShowListener> implements Oooo000 {
        public Oooo0(DialogInterface.OnShowListener onShowListener) {
            super(onShowListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(OooO0O0 oooO0O0) {
            DialogInterface.OnShowListener onShowListener = get();
            if (onShowListener != null) {
                onShowListener.onShow(oooO0O0);
            }
        }
    }

    public interface Oooo000 {
        void onShow(OooO0O0 oooO0O0);
    }

    public static final class o000oOoO implements Oooo000 {
        public final Runnable OooO00o;
        public final long OooO0O0;

        public o000oOoO(Runnable runnable, long j) {
            Intrinsics.h(runnable, "runnable");
            this.OooO00o = runnable;
            this.OooO0O0 = j;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(OooO0O0 oooO0O0) {
            List<Oooo000> list;
            if (oooO0O0 != null && (list = oooO0O0.OooO0O0) != null) {
                list.remove(this);
            }
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.postAtTime(oooO0O0, this.OooO00o, this.OooO0O0);
            }
        }
    }

    public static final class o00O0O implements Oooo000 {
        public final Runnable OooO00o;

        public o00O0O(Runnable runnable) {
            this.OooO00o = runnable;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(OooO0O0 oooO0O0) {
            List<Oooo000> list;
            if (this.OooO00o == null) {
                return;
            }
            if (oooO0O0 != null && (list = oooO0O0.OooO0O0) != null) {
                list.remove(this);
            }
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.post(oooO0O0, this.OooO00o);
            }
        }
    }

    public static final class o00Oo0 implements View.OnClickListener {
        public final OooO0O0 OooO00o;
        public final OooOOO<View> OooO0O0;

        public o00Oo0(OooO0O0 oooO0O0, OooOOO<View> oooOOO) {
            this.OooO00o = oooO0O0;
            this.OooO0O0 = oooOOO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.h(view, "view");
            OooOOO<View> oooOOO = this.OooO0O0;
            if (oooOOO != null) {
                oooOOO.OooO00o(this.OooO00o, view);
            }
        }
    }

    public static final class o0OoOo0 implements Oooo000 {
        public final Runnable OooO00o;
        public final long OooO0O0;

        public o0OoOo0(Runnable runnable, long j) {
            this.OooO00o = runnable;
            this.OooO0O0 = j;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(OooO0O0 oooO0O0) {
            List<Oooo000> list;
            if (this.OooO00o == null) {
                return;
            }
            if (oooO0O0 != null && (list = oooO0O0.OooO0O0) != null) {
                list.remove(this);
            }
            if (oooO0O0 != null) {
                HandlerAction.DefaultImpls.postDelayed(oooO0O0, this.OooO00o, this.OooO0O0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0O0(Context context, int i) {
        super(context, i);
        Intrinsics.h(context, "context");
        this.OooO00o = new OooOO0O<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(OooO0O0 oooO0O0, List list) {
        super/*android.app.Dialog*/.setOnCancelListener(oooO0O0.OooO00o);
        oooO0O0.OooO0OO = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO0O0(OooO0O0 oooO0O0, List list) {
        super/*android.app.Dialog*/.setOnDismissListener(oooO0O0.OooO00o);
        oooO0O0.OooO0Oo = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO0OO(OooO0O0 oooO0O0, List list) {
        super/*android.app.Dialog*/.setOnShowListener(oooO0O0.OooO00o);
        oooO0O0.OooO0O0 = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OooO00o(int i) {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OooO00o(OooOo00 oooOo00) {
        if (this.OooO0Oo == null) {
            this.OooO0Oo = new ArrayList();
            super/*android.app.Dialog*/.setOnDismissListener(this.OooO00o);
        }
        List<OooOo00> list = this.OooO0Oo;
        if (list != null) {
            list.add(oooOo00);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OooO00o(OooOo oooOo) {
        super/*android.app.Dialog*/.setOnKeyListener(new OooOO0(oooOo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OooO00o(Oooo000 oooo000) {
        if (this.OooO0O0 == null) {
            this.OooO0O0 = new ArrayList();
            super/*android.app.Dialog*/.setOnShowListener(this.OooO00o);
        }
        List<Oooo000> list = this.OooO0O0;
        if (list != null) {
            list.add(oooo000);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dismiss() {
        HandlerAction.DefaultImpls.removeCallbacks(this);
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) ResourcesAction.DefaultImpls.getSystemService(this, InputMethodManager.class)).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        super.dismiss();
    }

    @Override // com.cloud.tmc.miniapp.action.ActivityAction
    public Activity getActivity() {
        return ActivityAction.DefaultImpls.getActivity(this);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public int getColor(int i) {
        return ResourcesAction.DefaultImpls.getColor(this, i);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public Drawable getDrawable(int i) {
        return ResourcesAction.DefaultImpls.getDrawable(this, i);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public Handler getHandler() {
        return HandlerAction.DefaultImpls.getHandler(this);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public Resources getResources() {
        return ResourcesAction.DefaultImpls.getResources(this);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public String getString(int i) {
        return ResourcesAction.DefaultImpls.getString(this, i);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public String getString(int i, Object... objArr) {
        return ResourcesAction.DefaultImpls.getString(this, i, objArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public <S> S getSystemService(Class<S> cls) {
        return (S) ResourcesAction.DefaultImpls.getSystemService(this, cls);
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void hideKeyboard(View view) {
        KeyboardAction.DefaultImpls.hideKeyboard(this, view);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        List<OooOOO0> list = this.OooO0OO;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OooOOO0 oooOOO0 = list.get(i);
                if (oooOOO0 != null) {
                    oooOOO0.OooO00o(this);
                }
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        ClickAction.DefaultImpls.onClick(this, view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        List<OooOo00> list = this.OooO0Oo;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OooOo00 oooOo00 = list.get(i);
                if (oooOo00 != null) {
                    oooOo00.onDismiss(this);
                }
            }
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        List<Oooo000> list = this.OooO0O0;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Oooo000 oooo000 = list.get(i);
                if (oooo000 != null) {
                    oooo000.onShow(this);
                }
            }
        }
    }

    public void onStart() {
        super/*androidx.activity.q*/.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean post(Runnable runnable) {
        return HandlerAction.DefaultImpls.post(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postAtTime(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postAtTime(this, runnable, j);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Object obj, long j, Runnable runnable) {
        return HandlerAction.DefaultImpls.postDelayed(this, obj, j, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postDelayed(this, runnable, j);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks() {
        HandlerAction.DefaultImpls.removeCallbacks(this);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks(Runnable runnable) {
        HandlerAction.DefaultImpls.removeCallbacks(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacksAndMessages(Object obj) {
        HandlerAction.DefaultImpls.removeCallbacksAndMessages(this, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener == null) {
            return;
        }
        C0007OooO0O0 c0007OooO0O0 = new C0007OooO0O0(onCancelListener);
        if (this.OooO0OO == null) {
            this.OooO0OO = new ArrayList();
            super/*android.app.Dialog*/.setOnCancelListener(this.OooO00o);
        }
        List<OooOOO0> list = this.OooO0OO;
        if (list != null) {
            list.add(c0007OooO0O0);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, iArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, viewArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(int... iArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, iArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View... viewArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, viewArr);
    }

    @Deprecated
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            return;
        }
        OooO00o(new OooO0o(onDismissListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        super/*android.app.Dialog*/.setOnKeyListener(onKeyListener);
    }

    @Deprecated
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        if (onShowListener == null) {
            return;
        }
        OooO00o(new Oooo0(onShowListener));
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void showKeyboard(View view) {
        KeyboardAction.DefaultImpls.showKeyboard(this, view);
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void toggleSoftInput(View view) {
        KeyboardAction.DefaultImpls.toggleSoftInput(this, view);
    }
}
