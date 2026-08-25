package zm;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.i;
import com.therouter.TheRouter;
import com.transsion.baseui.R;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.flow.bean.SubjectPostCount;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.viewmodel.PlayDetailViewModel;
import com.transsion.play.detail.widget.PlayDetailResTabTitleView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import zm.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final a q = new a(null);
    private final Fragment a;
    private final Subject b;
    private final MagicIndicator c;
    private final ViewPager2 d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final Function1 h;
    private ORCommonNavigator i;
    private b j;
    private FragmentStateAdapter k;
    private int l;
    private long m;
    private boolean n;
    private final Lazy o;
    private final Lazy p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class b extends qj.a {
        private final ViewPager2 b;
        private final List c;
        private final boolean d;
        private final boolean e;
        final /* synthetic */ e f;

        public b(e eVar, ViewPager2 viewPager2, List list, boolean z, boolean z2) {
            Intrinsics.h(list, "tabList");
            this.f = eVar;
            this.b = viewPager2;
            this.c = list;
            this.d = z;
            this.e = z2;
        }

        private final LinearLayout.LayoutParams j() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(lj.a.b(6));
            layoutParams.setMarginEnd(lj.a.b(2));
            return layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(int i, e eVar, PlayDetailResTabTitleView playDetailResTabTitleView, b bVar, View view) {
            if (i == 1 && eVar.n) {
                eVar.n = false;
                playDetailResTabTitleView.setDotVisibility(false);
                com.transsion.baselib.report.launch.b.a.b().putBoolean("key_subj_comment_dot", false);
            }
            ViewPager2 viewPager2 = bVar.b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i, true);
            }
        }

        public int a() {
            return (this.d && this.e) ? this.c.size() - 1 : this.c.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setLineHeight(i.e(3.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(new Integer[]{-1, -1, -1});
            return linePagerIndicator;
        }

        public xy.d c(Context context, final int i) {
            Intrinsics.h(context, "context");
            final PlayDetailResTabTitleView playDetailResTabTitleView = new PlayDetailResTabTitleView(context);
            final e eVar = this.f;
            if (i == 1) {
                playDetailResTabTitleView.setDotVisibility(eVar.n);
            }
            Object obj = this.c.get(i);
            Intrinsics.g(obj, "get(...)");
            playDetailResTabTitleView.setTitle((String) obj);
            playDetailResTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: zm.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.b.k(i, eVar, playDetailResTabTitleView, this, view);
                }
            });
            return playDetailResTabTitleView;
        }

        @Override // qj.a
        public LinearLayout.LayoutParams h(Context context, int i) {
            Intrinsics.h(context, "context");
            return j();
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            MagicIndicator magicIndicator = e.this.c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            MagicIndicator magicIndicator = e.this.c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            Function1 function1 = e.this.h;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
            MagicIndicator magicIndicator = e.this.c;
            if (magicIndicator != null) {
                magicIndicator.onPageSelected(i);
            }
            e.this.l = i;
        }
    }

    public static final class d extends FragmentStateAdapter {
        final /* synthetic */ wv.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(wv.a aVar, Fragment fragment) {
            super(fragment);
            this.b = aVar;
        }

        public Fragment createFragment(int i) {
            if (i == 0) {
                wv.a aVar = this.b;
                Subject subject = e.this.b;
                Subject subject2 = e.this.b;
                return aVar.d(subject, subject2 != null ? subject2.getOps() : null, e.this.e, e.this.f, e.this.g);
            }
            wv.a aVar2 = this.b;
            Subject subject3 = e.this.b;
            String subjectId = subject3 != null ? subject3.getSubjectId() : null;
            Subject subject4 = e.this.b;
            return aVar2.a(subjectId, subject4 != null ? subject4.getOps() : null, e.this.e);
        }

        public int getItemCount() {
            return (e.this.f && e.this.g) ? e.this.q().size() - 1 : e.this.q().size();
        }
    }

    /* renamed from: zm.e$e, reason: collision with other inner class name */
    static final class C0106e implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        C0106e(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public e(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z, boolean z2, Function1 function1) {
        Intrinsics.h(fragment, "fragment");
        this.a = fragment;
        this.b = subject;
        this.c = magicIndicator;
        this.d = viewPager2;
        this.e = str;
        this.f = z;
        this.g = z2;
        this.h = function1;
        this.o = LazyKt.b(new Function0() { // from class: zm.a
            public final Object invoke() {
                PlayDetailViewModel y;
                y = e.y(e.this);
                return y;
            }
        });
        this.p = LazyKt.b(new Function0() { // from class: zm.b
            public final Object invoke() {
                List z3;
                z3 = e.z(e.this);
                return z3;
            }
        });
        r();
        u();
        t();
        s();
    }

    public /* synthetic */ e(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z, boolean z2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, subject, magicIndicator, viewPager2, str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : function1);
    }

    private final void o() {
        ViewPager2 viewPager2 = this.d;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new c());
        }
        ViewPager2 viewPager22 = this.d;
        if (viewPager22 != null) {
            viewPager22.setCurrentItem(this.l, false);
        }
    }

    private final PlayDetailViewModel p() {
        return (PlayDetailViewModel) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List q() {
        return (List) this.p.getValue();
    }

    private final void r() {
        this.n = com.transsion.baselib.report.launch.b.a.b().getBoolean("key_subj_comment_dot", true);
    }

    private final void s() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(this.a.requireContext());
        oRCommonNavigator.setFollowTouch(true);
        b bVar = new b(this, this.d, q(), this.f, this.g);
        this.j = bVar;
        oRCommonNavigator.setAdapter(bVar);
        this.i = oRCommonNavigator;
        MagicIndicator magicIndicator = this.c;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(oRCommonNavigator);
        }
    }

    private final void t() {
        wv.a aVar = (wv.a) TheRouter.d(wv.a.class, new Object[0]);
        if (aVar == null) {
            return;
        }
        d dVar = new d(aVar, this.a);
        this.k = dVar;
        ViewPager2 viewPager2 = this.d;
        if (viewPager2 != null) {
            viewPager2.setAdapter(dVar);
        }
        o();
    }

    private final void u() {
        String subjectId;
        Fragment fragment = this.a;
        Function1 function1 = new Function1() { // from class: zm.c
            public final Object invoke(Object obj) {
                Unit v;
                v = e.v(e.this, (PublishEvent) obj);
                return v;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(fragment, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
        p().g().j(this.a, new C0106e(new Function1() { // from class: zm.d
            public final Object invoke(Object obj) {
                Unit w;
                w = e.w(e.this, (SubjectPostCount) obj);
                return w;
            }
        }));
        Subject subject = this.b;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        p().f(subjectId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(e eVar, PublishEvent publishEvent) {
        String str;
        Intrinsics.h(publishEvent, "it");
        long j = eVar.m + 1;
        eVar.m = j;
        String valueOf = j > 99 ? "99+" : String.valueOf(j);
        Object obj = eVar.q().get(1);
        if (valueOf.length() == 0) {
            str = BuildConfig.FLAVOR;
        } else {
            str = "(" + valueOf + ")";
        }
        String str2 = obj + str;
        ORCommonNavigator oRCommonNavigator = eVar.i;
        xy.d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
        PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
        if (playDetailResTabTitleView != null) {
            playDetailResTabTitleView.setTitle(str2);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        if (r1 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit w(e eVar, SubjectPostCount subjectPostCount) {
        String count;
        String count2 = subjectPostCount != null ? subjectPostCount.getCount() : null;
        if (count2 == null || count2.length() == 0) {
            return Unit.a;
        }
        String count3 = subjectPostCount != null ? subjectPostCount.getCount() : null;
        Intrinsics.e(count3);
        Long x = StringsKt.x(count3);
        String str = BuildConfig.FLAVOR;
        if (x != null) {
            long longValue = x.longValue();
            eVar.m = longValue;
            count = longValue > 99 ? "99+" : longValue <= 0 ? BuildConfig.FLAVOR : String.valueOf(longValue);
        }
        count = subjectPostCount.getCount();
        Object obj = eVar.q().get(1);
        if (count != null && count.length() != 0) {
            str = "(" + count + ")";
        }
        String str2 = obj + str;
        if (!eVar.f || !eVar.g) {
            ORCommonNavigator oRCommonNavigator = eVar.i;
            xy.d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
            PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
            if (playDetailResTabTitleView != null) {
                playDetailResTabTitleView.setTitle(str2);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayDetailViewModel y(e eVar) {
        return (PlayDetailViewModel) new v0(eVar.a).a(PlayDetailViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z(e eVar) {
        return CollectionsKt.o(new String[]{eVar.a.requireContext().getString(R.string.for_you), eVar.a.requireContext().getString(R.string.name_comments)});
    }

    public final void x(boolean z) {
        if (com.transsion.baseui.util.c.a.a(90991, 500L) || !this.a.isAdded() || this.a.isDetached() || this.a.isRemoving()) {
            return;
        }
        List<wv.b> y0 = this.a.getChildFragmentManager().y0();
        Intrinsics.g(y0, "getFragments(...)");
        for (wv.b bVar : y0) {
            if (bVar instanceof wv.b) {
                bVar.onScreenChange(z);
            }
        }
    }
}
