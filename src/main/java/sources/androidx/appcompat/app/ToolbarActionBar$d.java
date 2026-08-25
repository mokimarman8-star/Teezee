package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ToolbarActionBar$d implements AppCompatDelegateImpl$e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolbarActionBar f255a;

    ToolbarActionBar$d(ToolbarActionBar toolbarActionBar) {
        this.f255a = toolbarActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$e
    public boolean a(int i5) {
        if (i5 != 0) {
            return false;
        }
        ToolbarActionBar toolbarActionBar = this.f255a;
        if (toolbarActionBar.d) {
            return false;
        }
        toolbarActionBar.a.setMenuPrepared();
        this.f255a.d = true;
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$e
    public View onCreatePanelView(int i5) {
        if (i5 == 0) {
            return new View(this.f255a.a.getContext());
        }
        return null;
    }
}
