package com.transsion.home.fragment.hashtag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.fragment.hashtag.HashTagPageFragment;
import com.transsion.home.hashtag.HashTagViewModel;
import com.transsion.home.hashtag.model.HashTagTab;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import wf.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/transsion/home/fragment/hashtag/UGCHashTagFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/n;", "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tabTitles", BuildConfig.FLAVOR, "j0", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "h0", "(Landroid/view/LayoutInflater;)Lqk/n;", "lazyLoadData", "onResume", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoHashTag;", "a", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoHashTag;", "mainHasTag", "b", "Ljava/util/List;", "hasTagList", "Lcom/transsion/home/hashtag/HashTagViewModel;", "c", "Lkotlin/Lazy;", "i0", "()Lcom/transsion/home/hashtag/HashTagViewModel;", "viewModel", "Lcom/transsion/home/fragment/hashtag/UGCHashTagFragment$b;", "d", "Lcom/transsion/home/fragment/hashtag/UGCHashTagFragment$b;", "titleUpdateCallback", "e", "Ljava/lang/String;", "fromOptId", "f", "ugcVideoId", BuildConfig.FLAVOR, "g", "I", "tabId", "h", "Z", "hasMarkLoadResult", "i", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCHashTagFragment extends BaseFragment<qk.n> {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private UGCVideoHashTag mainHasTag;

    /* renamed from: b, reason: from kotlin metadata */
    private List hasTagList;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(HashTagViewModel.class), new Function0<x0>() { // from class: com.transsion.home.fragment.hashtag.UGCHashTagFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final x0 m13invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.home.fragment.hashtag.UGCHashTagFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m14invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    private b titleUpdateCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private String fromOptId;

    /* renamed from: f, reason: from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: g, reason: from kotlin metadata */
    private int tabId;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean hasMarkLoadResult;

    /* renamed from: com.transsion.home.fragment.hashtag.UGCHashTagFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCHashTagFragment a(UGCVideoHashTag uGCVideoHashTag, ArrayList arrayList, String str, String str2, int i) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("hash_tag", uGCVideoHashTag);
            bundle.putParcelableArrayList("hash_tags", arrayList);
            bundle.putString("fromOptId", str);
            bundle.putString("UGCVideoId", str2);
            bundle.putInt("tabId", i);
            UGCHashTagFragment uGCHashTagFragment = new UGCHashTagFragment();
            uGCHashTagFragment.setArguments(bundle);
            return uGCHashTagFragment;
        }

        public final UGCHashTagFragment b(String str, String str2, String str3, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("hashtag", str);
            bundle.putString("fromOptId", str2);
            bundle.putString("UGCVideoId", str3);
            bundle.putInt("tabId", i);
            UGCHashTagFragment uGCHashTagFragment = new UGCHashTagFragment();
            uGCHashTagFragment.setArguments(bundle);
            return uGCHashTagFragment;
        }
    }

    public interface b {
        void j(String str);
    }

    public static final class c extends xy.a {
        final /* synthetic */ List b;
        final /* synthetic */ UGCHashTagFragment c;

        public static final class a extends com.transsion.baseui.util.f {
            final /* synthetic */ UGCHashTagFragment e;
            final /* synthetic */ int f;

            a(UGCHashTagFragment uGCHashTagFragment, int i) {
                this.e = uGCHashTagFragment;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                MagicIndicator magicIndicator;
                ViewPager2 viewPager2;
                qk.n nVar = (qk.n) this.e.getMViewBinding();
                if (nVar != null && (viewPager2 = nVar.d) != null) {
                    viewPager2.setCurrentItem(this.f, true);
                }
                qk.n nVar2 = (qk.n) this.e.getMViewBinding();
                if (nVar2 == null || (magicIndicator = nVar2.c) == null) {
                    return;
                }
                magicIndicator.onPageScrolled(this.f, 0.0f, 0);
            }
        }

        c(List list, UGCHashTagFragment uGCHashTagFragment) {
            this.b = list;
            this.c = uGCHashTagFragment;
        }

        public int a() {
            return this.b.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(2.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = androidx.core.content.b.getColor(context, R.color.text_01);
            linePagerIndicator.setColors(new Integer[]{Integer.valueOf(color), Integer.valueOf(color), Integer.valueOf(color)});
            return linePagerIndicator;
        }

        public xy.d c(Context context, int i) {
            Intrinsics.h(context, "context");
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(10.0f));
            List list = this.b;
            UGCHashTagFragment uGCHashTagFragment = this.c;
            customPagerTitleView.setText((CharSequence) list.get(i));
            customPagerTitleView.setTextSize(16.0f);
            customPagerTitleView.setOnClickListener(new a(uGCHashTagFragment, i));
            return customPagerTitleView;
        }
    }

    public static final class d extends FragmentStateAdapter {
        final /* synthetic */ List b;

        public static final class a implements HashTagPageFragment.b {
            final /* synthetic */ List a;
            final /* synthetic */ UGCHashTagFragment b;

            a(List list, UGCHashTagFragment uGCHashTagFragment) {
                this.a = list;
                this.b = uGCHashTagFragment;
            }

            @Override // com.transsion.home.fragment.hashtag.HashTagPageFragment.b
            public void a(String str, Long l, String str2) {
                HashMap g;
                String str3;
                Intrinsics.h(str, "tabId");
                HashTagTab hashTagTab = (HashTagTab) CollectionsKt.l0(this.a, 0);
                if (Intrinsics.c(str, hashTagTab != null ? hashTagTab.getId() : null) && !this.b.hasMarkLoadResult) {
                    this.b.hasMarkLoadResult = true;
                    qi.b logViewConfig = this.b.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.k(true);
                    }
                    qi.b logViewConfig2 = this.b.getLogViewConfig();
                    if (logViewConfig2 == null || (g = logViewConfig2.g()) == null) {
                        return;
                    }
                    if (l == null || (str3 = l.toString()) == null) {
                        str3 = BuildConfig.FLAVOR;
                    }
                    g.put("load_duration", str3);
                    if (str2 == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    g.put("ops", str2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list) {
            super(UGCHashTagFragment.this);
            this.b = list;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public HashTagPageFragment createFragment(int i) {
            String str;
            HashTagPageFragment.Companion companion = HashTagPageFragment.INSTANCE;
            String id = ((HashTagTab) this.b.get(i)).getId();
            String str2 = UGCHashTagFragment.this.fromOptId;
            UGCVideoHashTag uGCVideoHashTag = UGCHashTagFragment.this.mainHasTag;
            if (uGCVideoHashTag == null || (str = uGCVideoHashTag.getTitle()) == null) {
                str = BuildConfig.FLAVOR;
            }
            HashTagPageFragment a2 = companion.a(id, str2, str, UGCHashTagFragment.this.ugcVideoId);
            a2.F0(new a(this.b, UGCHashTagFragment.this));
            return a2;
        }

        public int getItemCount() {
            return this.b.size();
        }
    }

    public static final class e extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ List a;
        final /* synthetic */ UGCHashTagFragment b;

        e(List list, UGCHashTagFragment uGCHashTagFragment) {
            this.a = list;
            this.b = uGCHashTagFragment;
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            qk.n nVar = (qk.n) this.b.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.c) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            qk.n nVar = (qk.n) this.b.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.c) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i);
            String id = ((HashTagTab) this.a.get(i)).getId();
            a.a.f(wf.a.a, "/home/hashtag", "onPageSelected: position=" + i + ", filterId=" + id, false, 4, (Object) null);
            this.b.i0().w(id);
            qk.n nVar = (qk.n) this.b.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.c) == null) {
                return;
            }
            magicIndicator.onPageSelected(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashTagViewModel i0() {
        return (HashTagViewModel) this.viewModel.getValue();
    }

    private final void j0(List tabTitles) {
        MagicIndicator magicIndicator;
        CommonNavigator commonNavigator = new CommonNavigator(requireContext());
        commonNavigator.setAdapter(new c(tabTitles, this));
        qk.n nVar = (qk.n) getMViewBinding();
        if (nVar == null || (magicIndicator = nVar.c) == null) {
            return;
        }
        magicIndicator.setNavigator(commonNavigator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(UGCHashTagFragment uGCHashTagFragment) {
        MagicIndicator magicIndicator;
        qk.n nVar = (qk.n) uGCHashTagFragment.getMViewBinding();
        if (nVar == null || (magicIndicator = nVar.c) == null) {
            return;
        }
        magicIndicator.onPageSelected(0);
    }

    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public qk.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.n c2 = qk.n.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initView(View view, Bundle savedInstanceState) {
        String str;
        String stringExtra;
        Intent intent;
        Intent intent2;
        Uri data;
        ViewPager2 viewPager2;
        UGCVideoHashTag uGCVideoHashTag;
        String tag;
        MagicIndicator magicIndicator;
        HashMap g;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("hashtag") : null;
        Bundle arguments2 = getArguments();
        String str2 = BuildConfig.FLAVOR;
        if (arguments2 == null || (str = arguments2.getString("fromOptId")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.fromOptId = str;
        Bundle arguments3 = getArguments();
        this.ugcVideoId = arguments3 != null ? arguments3.getString("UGCVideoId") : null;
        Bundle arguments4 = getArguments();
        this.tabId = arguments4 != null ? arguments4.getInt("tabId", 0) : 0;
        if (string == null || string.length() == 0) {
            FragmentActivity activity = getActivity();
            if (activity == null || (intent2 = activity.getIntent()) == null || (data = intent2.getData()) == null || (stringExtra = data.getQueryParameter("hashtag")) == null) {
                FragmentActivity activity2 = getActivity();
                stringExtra = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getStringExtra("hashtag");
            }
            if (stringExtra == null || stringExtra.length() == 0) {
                Bundle arguments5 = getArguments();
                this.mainHasTag = arguments5 != null ? (UGCVideoHashTag) arguments5.getParcelable("hash_tag") : null;
                Bundle arguments6 = getArguments();
                this.hasTagList = arguments6 != null ? arguments6.getParcelableArrayList("hash_tags") : null;
            } else {
                Pair y = i0().y(stringExtra);
                this.mainHasTag = (UGCVideoHashTag) y.getFirst();
                this.hasTagList = (List) y.getSecond();
            }
        } else {
            Pair y2 = i0().y(string);
            this.mainHasTag = (UGCVideoHashTag) y2.getFirst();
            this.hasTagList = (List) y2.getSecond();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            g.put("page_from", qi.h.a.h());
            g.put("from_opt_id", this.fromOptId);
        }
        a.a aVar = wf.a.a;
        UGCVideoHashTag uGCVideoHashTag2 = this.mainHasTag;
        String title = uGCVideoHashTag2 != null ? uGCVideoHashTag2.getTitle() : null;
        List list = this.hasTagList;
        a.a.f(aVar, "/home/hashtag", "initView: hashTag=" + title + ", hashTags size=" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, (Object) null);
        i0().r(this.mainHasTag, this.hasTagList, this.tabId, this.ugcVideoId);
        List m = i0().m();
        a.a.f(aVar, "/home/hashtag", "initView: filters size=" + m.size(), false, 4, (Object) null);
        qk.n nVar = (qk.n) getMViewBinding();
        if (nVar == null || (viewPager2 = nVar.d) == null) {
            return;
        }
        viewPager2.setAdapter(new d(m));
        List list2 = m;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((HashTagTab) it.next()).getName());
        }
        j0(arrayList);
        viewPager2.registerOnPageChangeCallback(new e(m, this));
        viewPager2.setUserInputEnabled(true);
        viewPager2.setCurrentItem(0, false);
        qk.n nVar2 = (qk.n) getMViewBinding();
        if (nVar2 != null && (magicIndicator = nVar2.c) != null) {
            magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.hashtag.n
                @Override // java.lang.Runnable
                public final void run() {
                    UGCHashTagFragment.k0(UGCHashTagFragment.this);
                }
            });
        }
        UGCVideoHashTag uGCVideoHashTag3 = this.mainHasTag;
        if ((uGCVideoHashTag3 != null && (tag = uGCVideoHashTag3.getTitle()) != null) || ((uGCVideoHashTag = this.mainHasTag) != null && (tag = uGCVideoHashTag.getTag()) != null)) {
            str2 = tag;
        }
        if (!StringsKt.c0(str2, Utils.SEPARATOR, false, 2, (Object) null)) {
            str2 = getString(com.transsion.home.R.string.ugc_hashtag_page_title, new Object[]{str2});
            Intrinsics.e(str2);
        }
        b bVar = this.titleUpdateCallback;
        if (bVar != null) {
            bVar.j(str2);
        }
    }

    public void lazyLoadData() {
    }

    public qi.b newLogViewConfig() {
        return new qi.b("/home/hashtag", false, 2, null);
    }

    public void onAttach(Context context) {
        Intrinsics.h(context, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(context);
        b activity = getActivity();
        this.titleUpdateCallback = activity instanceof b ? activity : null;
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    public void onResume() {
        super.onResume();
        a.a aVar = wf.a.a;
        UGCVideoHashTag uGCVideoHashTag = this.mainHasTag;
        a.a.f(aVar, "/home/hashtag", "resume hashtag: " + (uGCVideoHashTag != null ? uGCVideoHashTag.getTitle() : null), false, 4, (Object) null);
    }
}
