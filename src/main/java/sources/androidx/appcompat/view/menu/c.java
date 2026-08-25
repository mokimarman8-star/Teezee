package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.x0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f570a;

    /* renamed from: b, reason: collision with root package name */
    private x0 f571b;

    /* renamed from: c, reason: collision with root package name */
    private x0 f572c;

    c(Context context) {
        this.f570a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b1.b)) {
            return menuItem;
        }
        b1.b bVar = (b1.b) menuItem;
        if (this.f571b == null) {
            this.f571b = new x0();
        }
        MenuItem menuItem2 = (MenuItem) this.f571b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        i iVar = new i(this.f570a, bVar);
        this.f571b.put(bVar, iVar);
        return iVar;
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    final void e() {
        x0 x0Var = this.f571b;
        if (x0Var != null) {
            x0Var.clear();
        }
        x0 x0Var2 = this.f572c;
        if (x0Var2 != null) {
            x0Var2.clear();
        }
    }

    final void f(int i5) {
        if (this.f571b == null) {
            return;
        }
        int i6 = 0;
        while (i6 < this.f571b.size()) {
            if (((b1.b) this.f571b.keyAt(i6)).getGroupId() == i5) {
                this.f571b.removeAt(i6);
                i6--;
            }
            i6++;
        }
    }

    final void g(int i5) {
        if (this.f571b == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f571b.size(); i6++) {
            if (((b1.b) this.f571b.keyAt(i6)).getItemId() == i5) {
                this.f571b.removeAt(i6);
                return;
            }
        }
    }
}
