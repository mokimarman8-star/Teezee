package com.cloud.tmc.miniapp.defaultimpl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.proxy.OnKeyboardListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class KeyboardImpl implements IKeyboardProxy {
    public static final OooO00o Companion = new OooO00o();
    public OnKeyboardListener OooO00o;
    public int OooO0O0;
    public boolean OooO0OO;
    public final Handler OooO0Oo;

    public static final class OooO00o {
    }

    public static final class OooO0O0 implements OnKeyboardListener {
        public OooO0O0() {
        }

        public void onKeyBoardAnimEnd() {
            if (KeyboardImpl.this.OooO0OO) {
                KeyboardImpl.this.OooO0OO = false;
                KeyboardImpl.this.OooO0Oo.sendEmptyMessage(3);
            }
        }

        public void onKeyBoardAnimStart() {
            if (KeyboardImpl.this.OooO0OO) {
                return;
            }
            KeyboardImpl.this.OooO0OO = true;
            KeyboardImpl.this.OooO0Oo.sendEmptyMessage(1);
        }

        public void onKeyBoardHeightChange(int i) {
            if (i != KeyboardImpl.this.OooO0O0) {
                KeyboardImpl.this.OooO0O0 = i;
                Handler handler = KeyboardImpl.this.OooO0Oo;
                handler.sendMessage(handler.obtainMessage(2, Integer.valueOf(i)));
            }
        }
    }

    public KeyboardImpl() {
        Looper myLooper = Looper.myLooper();
        this.OooO0Oo = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper, new Handler.Callback() { // from class: com.cloud.tmc.miniapp.defaultimpl.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return KeyboardImpl.OooO00o(KeyboardImpl.this, message);
            }
        });
    }

    public static final void OooO00o(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static final boolean OooO00o(KeyboardImpl keyboardImpl, Message message) {
        OnKeyboardListener onKeyboardListener;
        Intrinsics.h(keyboardImpl, "this$0");
        Intrinsics.h(message, "it");
        int i = message.what;
        if (i == 1) {
            OnKeyboardListener onKeyboardListener2 = keyboardImpl.OooO00o;
            if (onKeyboardListener2 != null) {
                onKeyboardListener2.onKeyBoardAnimStart();
            }
        } else if (i == 2) {
            OnKeyboardListener onKeyboardListener3 = keyboardImpl.OooO00o;
            if (onKeyboardListener3 != null) {
                Object obj = message.obj;
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Int");
                onKeyboardListener3.onKeyBoardHeightChange(((Integer) obj).intValue());
            }
        } else if (i == 3 && (onKeyboardListener = keyboardImpl.OooO00o) != null) {
            onKeyboardListener.onKeyBoardAnimEnd();
        }
        return true;
    }

    public static final void OooO0O0(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 2);
        }
    }

    public static final void OooO0OO(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }

    public void hideKeyboard(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.c
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO00o(view);
                }
            });
        }
    }

    public void initKeyBoardChange(View view) {
        if (view != null) {
            ViewCompat.setWindowInsetsAnimationCallback(view, new OooO(WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime(), new OooO0O0()));
        }
    }

    public void releaseKeyBoardChange(View view) {
        if (view != null) {
            ViewCompat.setWindowInsetsAnimationCallback(view, (WindowInsetsAnimationCompat.Callback) null);
        }
        this.OooO0Oo.removeCallbacksAndMessages(null);
    }

    public void setKeyBoardListener(OnKeyboardListener onKeyboardListener) {
        this.OooO00o = onKeyboardListener;
    }

    public void showKeyboard(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.e
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO0O0(view);
                }
            });
        }
    }

    public void toggleSoftInput(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.d
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO0OO(view);
                }
            });
        }
    }
}
