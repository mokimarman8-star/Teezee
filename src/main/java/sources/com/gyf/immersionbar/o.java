package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class o extends Fragment {
    private ImmersionDelegate a;

    public ImmersionBar a(Activity activity, Dialog dialog) {
        if (this.a == null) {
            this.a = new ImmersionDelegate(activity, dialog);
        }
        return this.a.get();
    }

    public ImmersionBar b(Object obj) {
        if (this.a == null) {
            this.a = new ImmersionDelegate(obj);
        }
        return this.a.get();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.a = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }
}
