package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class n extends c implements Menu {

    /* renamed from: d, reason: collision with root package name */
    private final b1.a f672d;

    public n(Context context, b1.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f672d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i5) {
        return c(this.f672d.add(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, int i8) {
        return c(this.f672d.add(i5, i6, i7, i8));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return c(this.f672d.add(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f672d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f672d.addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr[i9] = c(menuItemArr2[i9]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5) {
        return d(this.f672d.addSubMenu(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return d(this.f672d.addSubMenu(i5, i6, i7, i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return d(this.f672d.addSubMenu(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f672d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.f672d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f672d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i5) {
        return c(this.f672d.findItem(i5));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i5) {
        return c(this.f672d.getItem(i5));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f672d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return this.f672d.isShortcutKey(i5, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i5, int i6) {
        return this.f672d.performIdentifierAction(i5, i6);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return this.f672d.performShortcut(i5, keyEvent, i6);
    }

    @Override // android.view.Menu
    public void removeGroup(int i5) {
        f(i5);
        this.f672d.removeGroup(i5);
    }

    @Override // android.view.Menu
    public void removeItem(int i5) {
        g(i5);
        this.f672d.removeItem(i5);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i5, boolean z5, boolean z6) {
        this.f672d.setGroupCheckable(i5, z5, z6);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i5, boolean z5) {
        this.f672d.setGroupEnabled(i5, z5);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i5, boolean z5) {
        this.f672d.setGroupVisible(i5, z5);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f672d.setQwertyMode(z5);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f672d.size();
    }
}
