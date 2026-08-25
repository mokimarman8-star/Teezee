package com.transsion.baseui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.transsion.baselib.report.g;
import f4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qi.b;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u001b\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0006J\u0019\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u0006R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\n\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001d\u0010A\u001a\u0004\u0018\u00010<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/transsion/baseui/fragment/BaseFragment;", "Lf4/a;", "T", "Landroidx/fragment/app/Fragment;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "X", "Y", "Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "getViewBinding", "(Landroid/view/LayoutInflater;)Lf4/a;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "initData", "initListener", "lazyLoadData", "startLoading", "hideLoading", "onDestroyView", "Landroid/content/Intent;", "intent", "newIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "logResume", "logPause", "Lyg/m;", "netListener", "Lyg/m;", "getNetListener", "()Lyg/m;", "setNetListener", "(Lyg/m;)V", "mViewBinding", "Lf4/a;", "getMViewBinding", "()Lf4/a;", "setMViewBinding", "(Lf4/a;)V", "", "isFirst", "()Z", "setFirst", "(Z)V", "Lqi/b;", "logViewConfig$delegate", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseFragment<T extends f4.a> extends Fragment implements g {
    public static final int $stable = 8;
    private boolean isFirst = true;

    /* renamed from: logViewConfig$delegate, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.baseui.fragment.a
        public final Object invoke() {
            b W;
            W = BaseFragment.W(BaseFragment.this);
            return W;
        }
    });
    private T mViewBinding;
    private m netListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final b W(BaseFragment baseFragment) {
        return baseFragment.newLogViewConfig();
    }

    private final void X() {
        if (this.isFirst) {
            this.isFirst = false;
            lazyLoadData();
        }
    }

    private final void Y() {
        l.a.l(this.netListener);
    }

    private final void Z() {
        l.a.m(this.netListener);
    }

    public b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    public final T getMViewBinding() {
        return this.mViewBinding;
    }

    public final m getNetListener() {
        return this.netListener;
    }

    public abstract f4.a getViewBinding(LayoutInflater inflater);

    public void hideLoading() {
    }

    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void initListener() {
    }

    public abstract void initView(View view, Bundle savedInstanceState);

    /* renamed from: isFirst, reason: from getter */
    public final boolean getIsFirst() {
        return this.isFirst;
    }

    public abstract void lazyLoadData();

    public void logPause() {
        g.a.b(this);
    }

    public void logResume() {
        g.a.c(this);
    }

    public void newIntent(Intent intent) {
    }

    public b newLogViewConfig() {
        return g.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isFirst = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        T t = (T) getViewBinding(inflater);
        this.mViewBinding = t;
        if (t != null) {
            return t.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mViewBinding = null;
        Z();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        logResume();
        X();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
        initData(view, savedInstanceState);
        initListener();
        Y();
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }

    public final void setMViewBinding(T t) {
        this.mViewBinding = t;
    }

    public final void setNetListener(m mVar) {
        this.netListener = mVar;
    }

    public void startLoading() {
    }
}
