package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f8153a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f8154b;

    /* renamed from: c, reason: collision with root package name */
    private Context f8155c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentManager f8156d;

    /* renamed from: e, reason: collision with root package name */
    private int f8157e;

    /* renamed from: f, reason: collision with root package name */
    private TabHost.OnTabChangeListener f8158f;

    /* renamed from: g, reason: collision with root package name */
    private b f8159g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8160h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f8161a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f8161a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f8161a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.f8161a);
        }
    }

    static class a implements TabHost.TabContentFactory {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8162a;

        public a(Context context) {
            this.f8162a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f8162a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f8163a;

        /* renamed from: b, reason: collision with root package name */
        final Class f8164b;

        /* renamed from: c, reason: collision with root package name */
        final Bundle f8165c;

        /* renamed from: d, reason: collision with root package name */
        Fragment f8166d;

        b(String str, Class cls, Bundle bundle) {
            this.f8163a = str;
            this.f8164b = cls;
            this.f8165c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.f8153a = new ArrayList();
        e(context, null);
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8153a = new ArrayList();
        e(context, attributeSet);
    }

    private w a(String str, w wVar) {
        Fragment fragment;
        b d5 = d(str);
        if (this.f8159g != d5) {
            if (wVar == null) {
                wVar = this.f8156d.p();
            }
            b bVar = this.f8159g;
            if (bVar != null && (fragment = bVar.f8166d) != null) {
                wVar.m(fragment);
            }
            if (d5 != null) {
                Fragment fragment2 = d5.f8166d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f8156d.w0().instantiate(this.f8155c.getClassLoader(), d5.f8164b.getName());
                    d5.f8166d = instantiate;
                    instantiate.setArguments(d5.f8165c);
                    wVar.c(this.f8157e, d5.f8166d, d5.f8163a);
                } else {
                    wVar.h(fragment2);
                }
            }
            this.f8159g = d5;
        }
        return wVar;
    }

    private void b() {
        if (this.f8154b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f8157e);
            this.f8154b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f8157e);
        }
    }

    private void c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f8154b = frameLayout2;
            frameLayout2.setId(this.f8157e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private b d(String str) {
        int size = this.f8153a.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.f8153a.get(i5);
            if (bVar.f8163a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f8157e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new a(this.f8155c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f8160h) {
            Fragment k02 = this.f8156d.k0(tag);
            bVar.f8166d = k02;
            if (k02 != null && !k02.isDetached()) {
                w p5 = this.f8156d.p();
                p5.m(bVar.f8166d);
                p5.i();
            }
        }
        this.f8153a.add(bVar);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f8153a.size();
        w wVar = null;
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.f8153a.get(i5);
            Fragment k02 = this.f8156d.k0(bVar.f8163a);
            bVar.f8166d = k02;
            if (k02 != null && !k02.isDetached()) {
                if (bVar.f8163a.equals(currentTabTag)) {
                    this.f8159g = bVar;
                } else {
                    if (wVar == null) {
                        wVar = this.f8156d.p();
                    }
                    wVar.m(bVar.f8166d);
                }
            }
        }
        this.f8160h = true;
        w a5 = a(currentTabTag, wVar);
        if (a5 != null) {
            a5.i();
            this.f8156d.g0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8160h = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f8161a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8161a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        w a5;
        if (this.f8160h && (a5 = a(str, null)) != null) {
            a5.i();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f8158f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f8158f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.f8155c = context;
        this.f8156d = fragmentManager;
        b();
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i5) {
        c(context);
        super.setup();
        this.f8155c = context;
        this.f8156d = fragmentManager;
        this.f8157e = i5;
        b();
        this.f8154b.setId(i5);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
