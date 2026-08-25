package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ListFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f8167a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f8168b = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f8171e;
            listView.focusableViewAvailable(listView);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f8169c = new a();

    /* renamed from: d, reason: collision with root package name */
    ListAdapter f8170d;

    /* renamed from: e, reason: collision with root package name */
    ListView f8171e;

    /* renamed from: f, reason: collision with root package name */
    View f8172f;

    /* renamed from: g, reason: collision with root package name */
    TextView f8173g;

    /* renamed from: h, reason: collision with root package name */
    View f8174h;

    /* renamed from: i, reason: collision with root package name */
    View f8175i;

    /* renamed from: j, reason: collision with root package name */
    CharSequence f8176j;

    /* renamed from: k, reason: collision with root package name */
    boolean f8177k;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
            ListFragment.this.W((ListView) adapterView, view, i5, j5);
        }
    }

    private void V() {
        if (this.f8171e != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f8171e = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.f8173g = textView;
            if (textView == null) {
                this.f8172f = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.f8174h = view.findViewById(16711682);
            this.f8175i = view.findViewById(16711683);
            View findViewById = view.findViewById(R.id.list);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) findViewById;
            this.f8171e = listView;
            View view2 = this.f8172f;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.f8176j;
                if (charSequence != null) {
                    this.f8173g.setText(charSequence);
                    this.f8171e.setEmptyView(this.f8173g);
                }
            }
        }
        this.f8177k = true;
        this.f8171e.setOnItemClickListener(this.f8169c);
        ListAdapter listAdapter = this.f8170d;
        if (listAdapter != null) {
            this.f8170d = null;
            X(listAdapter);
        } else if (this.f8174h != null) {
            Y(false, false);
        }
        this.f8167a.post(this.f8168b);
    }

    private void Y(boolean z5, boolean z6) {
        V();
        View view = this.f8174h;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f8177k == z5) {
            return;
        }
        this.f8177k = z5;
        if (z5) {
            if (z6) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.f8175i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f8175i.clearAnimation();
            }
            this.f8174h.setVisibility(8);
            this.f8175i.setVisibility(0);
            return;
        }
        if (z6) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.f8175i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f8175i.clearAnimation();
        }
        this.f8174h.setVisibility(0);
        this.f8175i.setVisibility(8);
    }

    public void W(ListView listView, View view, int i5, long j5) {
    }

    public void X(ListAdapter listAdapter) {
        boolean z5 = this.f8170d != null;
        this.f8170d = listAdapter;
        ListView listView = this.f8171e;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f8177k || z5) {
                return;
            }
            Y(true, requireView().getWindowToken() != null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f8167a.removeCallbacks(this.f8168b);
        this.f8171e = null;
        this.f8177k = false;
        this.f8175i = null;
        this.f8174h = null;
        this.f8172f = null;
        this.f8173g = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        V();
    }
}
