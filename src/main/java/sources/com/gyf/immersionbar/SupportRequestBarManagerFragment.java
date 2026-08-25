package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class SupportRequestBarManagerFragment extends Fragment {
    private ImmersionDelegate a;

    public ImmersionBar V(Activity activity, Dialog dialog) {
        if (this.a == null) {
            this.a = new ImmersionDelegate(activity, dialog);
        }
        return this.a.get();
    }

    public ImmersionBar W(Object obj) {
        if (this.a == null) {
            this.a = new ImmersionDelegate(obj);
        }
        return this.a.get();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.a = null;
        }
    }

    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.a;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }
}
