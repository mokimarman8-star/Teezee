package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    final Window.Callback f476a;

    static class a {
        static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i5) {
            return callback.onWindowStartingActionMode(callback2, i5);
        }
    }

    static class b {
        static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i5) {
            callback.onProvideKeyboardShortcuts(list, menu, i5);
        }
    }

    static class c {
        static void a(Window.Callback callback, boolean z5) {
            callback.onPointerCaptureChanged(z5);
        }
    }

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f476a = callback;
    }

    public final Window.Callback a() {
        return this.f476a;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f476a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f476a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f476a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f476a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f476a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f476a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f476a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f476a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f476a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        return this.f476a.onCreatePanelMenu(i5, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i5) {
        return this.f476a.onCreatePanelView(i5);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f476a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        return this.f476a.onMenuItemSelected(i5, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i5, Menu menu) {
        return this.f476a.onMenuOpened(i5, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        this.f476a.onPanelClosed(i5, menu);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z5) {
        c.a(this.f476a, z5);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        return this.f476a.onPreparePanel(i5, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i5) {
        b.a(this.f476a, list, menu, i5);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f476a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f476a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f476a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        this.f476a.onWindowFocusChanged(z5);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
        return a.b(this.f476a, callback, i5);
    }
}
