package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface MenuHost {
    void addMenuProvider(MenuProvider menuProvider);

    void addMenuProvider(MenuProvider menuProvider, u uVar);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(MenuProvider menuProvider, u uVar, Lifecycle.State state);

    void invalidateMenu();

    void removeMenuProvider(MenuProvider menuProvider);
}
