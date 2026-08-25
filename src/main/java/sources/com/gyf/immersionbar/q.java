package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class q implements Handler.Callback {
    private final String a;
    private final String b;
    private final Handler c;
    private final Map d;
    private final Map e;
    private final Map f;
    private final Map g;

    private static class b {
        private static final q a = new q();
    }

    private q() {
        this.a = ImmersionBar.class.getName() + ".";
        this.b = ".tag.notOnly.";
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.c = new Handler(Looper.getMainLooper(), this);
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private o g(FragmentManager fragmentManager, String str) {
        return h(fragmentManager, str, false);
    }

    private o h(FragmentManager fragmentManager, String str, boolean z) {
        List<Fragment> fragments;
        o oVar = (o) fragmentManager.findFragmentByTag(str);
        if (oVar == null && (oVar = (o) this.d.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                fragments = fragmentManager.getFragments();
                for (Fragment fragment : fragments) {
                    if (fragment instanceof o) {
                        String tag = fragment.getTag();
                        if (tag == null) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        } else if (tag.contains(".tag.notOnly.")) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        }
                    }
                }
            }
            oVar = new o();
            this.d.put(fragmentManager, oVar);
            fragmentManager.beginTransaction().add(oVar, str).commitAllowingStateLoss();
            this.c.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return oVar;
        }
        if (this.f.get(str) == null) {
            this.f.put(str, oVar);
            fragmentManager.beginTransaction().remove(oVar).commitAllowingStateLoss();
            this.c.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    static q i() {
        return b.a;
    }

    private SupportRequestBarManagerFragment j(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return k(fragmentManager, str, false);
    }

    private SupportRequestBarManagerFragment k(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.k0(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) this.e.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.y0()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.p().r(fragment).j();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.p().r(fragment).j();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.e.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.p().e(supportRequestBarManagerFragment, str).j();
            this.c.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestBarManagerFragment;
        }
        if (this.g.get(str) == null) {
            this.g.put(str, supportRequestBarManagerFragment);
            fragmentManager.p().r(supportRequestBarManagerFragment).j();
            this.c.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }

    public void b(Activity activity, Dialog dialog, boolean z) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.a + dialog.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            k(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
        } else {
            h(activity.getFragmentManager(), str, true);
        }
    }

    public ImmersionBar c(Activity activity, Dialog dialog, boolean z) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        String str = this.a + dialog.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).V(activity, dialog) : g(activity.getFragmentManager(), str).a(activity, dialog);
    }

    public ImmersionBar d(Activity activity, boolean z) {
        a(activity, "activity is null");
        String str = this.a + activity.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).W(activity) : g(activity.getFragmentManager(), str).b(activity);
    }

    public ImmersionBar e(Fragment fragment, boolean z) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.a + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return g(fragment.getChildFragmentManager(), str).b(fragment);
    }

    public ImmersionBar f(androidx.fragment.app.Fragment fragment, boolean z) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof androidx.fragment.app.DialogFragment) {
            a(((androidx.fragment.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.a + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return j(fragment.getChildFragmentManager(), str).W(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.d.remove((FragmentManager) message.obj);
            return true;
        }
        if (i == 2) {
            this.e.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i == 3) {
            this.f.remove((String) message.obj);
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.g.remove((String) message.obj);
        return true;
    }
}
