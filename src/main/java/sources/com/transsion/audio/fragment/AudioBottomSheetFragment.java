package com.transsion.audio.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.therouter.TheRouter;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$string;
import com.transsion.audio.adapter.dialog.ClearTipsDialog;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.audio.viewmodel.SubjectListViewModel;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.RoomSimplePagerTitleView;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.Collection;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R \u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R \u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010I\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "E0", "Landroid/view/View;", "view", "H0", "(Landroid/view/View;)V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "subjectInfo", "G0", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", "C0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "D0", "()I", "c", "I", "mSelectTabIndex", "Lcom/tn/lib/view/GradientLinePagerIndicator;", "d", "Lcom/tn/lib/view/GradientLinePagerIndicator;", "linePagerIndicator", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/CommonNavigator;", "e", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/CommonNavigator;", "commonNavigator", "Lcom/transsion/audio/fragment/SubjectListFragment;", "f", "Lcom/transsion/audio/fragment/SubjectListFragment;", "subjectListFragment", "Lcom/transsion/audio/fragment/RecentListFragment;", "g", "Lcom/transsion/audio/fragment/RecentListFragment;", "recentListFragment", "Lki/a;", "h", "Lki/a;", "mBindView", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "i", "[Ljava/lang/String;", "titleData", "Lcom/transsion/baseui/widget/RoomSimplePagerTitleView;", "j", "[Lcom/transsion/baseui/widget/RoomSimplePagerTitleView;", "titleViews", "Lcom/transsion/audio/adapter/c;", "k", "Lcom/transsion/audio/adapter/c;", "mAdapter", "Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "l", "Lkotlin/Lazy;", "getSubjectListViewModel", "()Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "subjectListViewModel", "Lep/a;", "m", "getMAudioApi", "()Lep/a;", "mAudioApi", "n", "a", "Audio_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AudioBottomSheetFragment extends BaseDialog {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private int mSelectTabIndex;

    /* renamed from: d, reason: from kotlin metadata */
    private GradientLinePagerIndicator linePagerIndicator;

    /* renamed from: e, reason: from kotlin metadata */
    private CommonNavigator commonNavigator;

    /* renamed from: f, reason: from kotlin metadata */
    private SubjectListFragment subjectListFragment;

    /* renamed from: g, reason: from kotlin metadata */
    private RecentListFragment recentListFragment;

    /* renamed from: h, reason: from kotlin metadata */
    private ki.a mBindView;

    /* renamed from: i, reason: from kotlin metadata */
    private String[] titleData;

    /* renamed from: j, reason: from kotlin metadata */
    private RoomSimplePagerTitleView[] titleViews;

    /* renamed from: k, reason: from kotlin metadata */
    private com.transsion.audio.adapter.c mAdapter;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy subjectListViewModel;

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy mAudioApi;

    /* renamed from: com.transsion.audio.fragment.AudioBottomSheetFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioBottomSheetFragment a(AudioBean audioBean) {
            Intrinsics.h(audioBean, "audioBean");
            AudioBottomSheetFragment audioBottomSheetFragment = new AudioBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("field_item", audioBean);
            audioBottomSheetFragment.setArguments(bundle);
            return audioBottomSheetFragment;
        }
    }

    public static final class b extends xy.a {

        public static final class a extends com.transsion.baseui.util.f {
            final /* synthetic */ AudioBottomSheetFragment e;
            final /* synthetic */ int f;

            a(AudioBottomSheetFragment audioBottomSheetFragment, int i) {
                this.e = audioBottomSheetFragment;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ViewPager2 viewPager2;
                ki.a aVar = this.e.mBindView;
                if (aVar == null || (viewPager2 = aVar.g) == null) {
                    return;
                }
                viewPager2.setCurrentItem(this.f, true);
            }
        }

        b() {
        }

        public int a() {
            String[] strArr = AudioBottomSheetFragment.this.titleData;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        public xy.c b(Context context) {
            if (AudioBottomSheetFragment.this.linePagerIndicator != null) {
                GradientLinePagerIndicator gradientLinePagerIndicator = AudioBottomSheetFragment.this.linePagerIndicator;
                ViewParent parent = gradientLinePagerIndicator != null ? gradientLinePagerIndicator.getParent() : null;
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(AudioBottomSheetFragment.this.linePagerIndicator);
                }
                GradientLinePagerIndicator gradientLinePagerIndicator2 = AudioBottomSheetFragment.this.linePagerIndicator;
                Intrinsics.e(gradientLinePagerIndicator2);
                return gradientLinePagerIndicator2;
            }
            AudioBottomSheetFragment audioBottomSheetFragment = AudioBottomSheetFragment.this;
            Context requireContext = AudioBottomSheetFragment.this.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            GradientLinePagerIndicator gradientLinePagerIndicator3 = new GradientLinePagerIndicator(requireContext);
            AudioBottomSheetFragment audioBottomSheetFragment2 = AudioBottomSheetFragment.this;
            gradientLinePagerIndicator3.setMode(2);
            gradientLinePagerIndicator3.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator3.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator3.setRoundRadius(com.blankj.utilcode.util.i.e(1.0f));
            gradientLinePagerIndicator3.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator3.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator3.setColors(androidx.core.content.b.getColor(audioBottomSheetFragment2.requireContext(), R.color.brand_gradient_start), androidx.core.content.b.getColor(audioBottomSheetFragment2.requireContext(), R.color.brand_gradient_center), androidx.core.content.b.getColor(audioBottomSheetFragment2.requireContext(), R.color.brand_gradient_end));
            audioBottomSheetFragment.linePagerIndicator = gradientLinePagerIndicator3;
            GradientLinePagerIndicator gradientLinePagerIndicator4 = AudioBottomSheetFragment.this.linePagerIndicator;
            Intrinsics.e(gradientLinePagerIndicator4);
            return gradientLinePagerIndicator4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.transsion.baseui.widget.RoomSimplePagerTitleView[]] */
        /* JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, android.widget.TextView, xy.d] */
        /* JADX WARN: Type inference failed for: r3v7 */
        public xy.d c(Context context, int i) {
            String str;
            RoomSimplePagerTitleView[] roomSimplePagerTitleViewArr = AudioBottomSheetFragment.this.titleViews;
            ?? r3 = roomSimplePagerTitleViewArr != null ? roomSimplePagerTitleViewArr[i] : 0;
            if (r3 != 0) {
                ViewParent parent = r3.getParent();
                Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(r3);
                String[] strArr = AudioBottomSheetFragment.this.titleData;
                if (strArr == null || (str = strArr[i]) == null) {
                    str = BuildConfig.FLAVOR;
                }
                r3.setText(str);
                return r3;
            }
            Context requireContext = AudioBottomSheetFragment.this.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            SimplePagerTitleView roomSimplePagerTitleView = new RoomSimplePagerTitleView(requireContext);
            AudioBottomSheetFragment audioBottomSheetFragment = AudioBottomSheetFragment.this;
            roomSimplePagerTitleView.setSingleLine(false);
            CharSequence[] charSequenceArr = audioBottomSheetFragment.titleData;
            if (charSequenceArr != null) {
                roomSimplePagerTitleView.setText(charSequenceArr[i]);
            }
            roomSimplePagerTitleView.setOnClickListener(new a(audioBottomSheetFragment, i));
            ?? r0 = AudioBottomSheetFragment.this.titleViews;
            if (r0 != 0) {
                r0[i] = roomSimplePagerTitleView;
            }
            return roomSimplePagerTitleView;
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            ki.a aVar = AudioBottomSheetFragment.this.mBindView;
            if (aVar == null || (magicIndicator = aVar.e) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            ki.a aVar = AudioBottomSheetFragment.this.mBindView;
            if (aVar == null || (magicIndicator = aVar.e) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            AppCompatImageView appCompatImageView;
            AppCompatImageView appCompatImageView2;
            MagicIndicator magicIndicator;
            super.onPageSelected(i);
            ki.a aVar = AudioBottomSheetFragment.this.mBindView;
            if (aVar != null && (magicIndicator = aVar.e) != null) {
                magicIndicator.onPageSelected(i);
            }
            AudioBottomSheetFragment.this.mSelectTabIndex = i;
            if (AudioBottomSheetFragment.this.titleViews == null || i != r0.length - 1) {
                ki.a aVar2 = AudioBottomSheetFragment.this.mBindView;
                if (aVar2 == null || (appCompatImageView = aVar2.b) == null) {
                    return;
                }
                appCompatImageView.setVisibility(8);
                return;
            }
            ki.a aVar3 = AudioBottomSheetFragment.this.mBindView;
            if (aVar3 == null || (appCompatImageView2 = aVar3.b) == null) {
                return;
            }
            appCompatImageView2.setVisibility(0);
        }
    }

    public static final class d extends FragmentStateAdapter {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(AudioBottomSheetFragment.this);
            this.b = str;
        }

        public Fragment createFragment(int i) {
            if (AudioBottomSheetFragment.this.titleData == null || i != r0.length - 1) {
                AudioBottomSheetFragment.this.subjectListFragment = SubjectListFragment.INSTANCE.b(this.b);
                SubjectListFragment subjectListFragment = AudioBottomSheetFragment.this.subjectListFragment;
                Intrinsics.e(subjectListFragment);
                return subjectListFragment;
            }
            AudioBottomSheetFragment.this.recentListFragment = new RecentListFragment();
            RecentListFragment recentListFragment = AudioBottomSheetFragment.this.recentListFragment;
            Intrinsics.e(recentListFragment);
            return recentListFragment;
        }

        public int getItemCount() {
            String[] strArr = AudioBottomSheetFragment.this.titleData;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }
    }

    public static final class e implements ji.a {
        final /* synthetic */ ClearTipsDialog a;
        final /* synthetic */ AudioBottomSheetFragment b;

        e(ClearTipsDialog clearTipsDialog, AudioBottomSheetFragment audioBottomSheetFragment) {
            this.a = clearTipsDialog;
            this.b = audioBottomSheetFragment;
        }

        @Override // ji.a
        public void a() {
            com.transsion.audio.adapter.c cVar = this.b.mAdapter;
            if (cVar != null) {
                cVar.n1((Collection) null);
            }
            HistoryListManager.e.b().n();
            this.b.dismissAllowingStateLoss();
        }

        @Override // ji.a
        public void b() {
            this.a.dismissAllowingStateLoss();
        }
    }

    static final class f implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
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

    public AudioBottomSheetFragment() {
        super(R$layout.fragment_bottom_dialog_audio);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m0invoke() {
                return this;
            }
        };
        this.subjectListViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(SubjectListViewModel.class), new Function0<x0>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m1invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m2invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.d
            public final Object invoke() {
                ep.a mAudioApi_delegate$lambda$0;
                mAudioApi_delegate$lambda$0 = AudioBottomSheetFragment.mAudioApi_delegate$lambda$0();
                return mAudioApi_delegate$lambda$0;
            }
        });
    }

    private final void C0() {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        CommonNavigator commonNavigator = new CommonNavigator(requireContext());
        this.commonNavigator = commonNavigator;
        commonNavigator.setAdapter(new b());
        ki.a aVar = this.mBindView;
        if (aVar != null && (magicIndicator = aVar.e) != null) {
            magicIndicator.setNavigator(this.commonNavigator);
        }
        ki.a aVar2 = this.mBindView;
        if (aVar2 == null || (viewPager2 = aVar2.g) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new c());
    }

    private final void E0() {
        HistoryListManager.e.b().v().j(this, new f(new Function1() { // from class: com.transsion.audio.fragment.c
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = AudioBottomSheetFragment.F0(AudioBottomSheetFragment.this, (DownloadListBean) obj);
                return F0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(AudioBottomSheetFragment audioBottomSheetFragment, DownloadListBean downloadListBean) {
        audioBottomSheetFragment.G0(downloadListBean);
        return Unit.a;
    }

    private final void G0(DownloadListBean subjectInfo) {
        ViewPager2 viewPager2;
        String valueOf;
        String str = null;
        String subjectTitle = subjectInfo != null ? subjectInfo.getSubjectTitle() : null;
        Integer totalEpisode = subjectInfo != null ? subjectInfo.getTotalEpisode() : null;
        String subjectId = subjectInfo != null ? subjectInfo.getSubjectId() : null;
        if (subjectInfo != null) {
            this.titleData = new String[2];
            if (subjectTitle != null && subjectTitle.length() > 27) {
                String substring = subjectTitle.substring(0, 27);
                Intrinsics.g(substring, "substring(...)");
                subjectTitle = substring + "...";
            }
            if (totalEpisode != null) {
                int intValue = totalEpisode.intValue();
                if (intValue > 0) {
                    valueOf = ((Object) subjectTitle) + "(" + intValue + ")";
                } else {
                    valueOf = String.valueOf(subjectTitle);
                }
                str = valueOf;
            }
            String[] strArr = this.titleData;
            if (strArr != null) {
                strArr[0] = str;
            }
            if (strArr != null) {
                strArr[1] = getString(R$string.str_recently);
            }
        } else {
            this.titleData = new String[]{getString(R$string.str_recently)};
        }
        String[] strArr2 = this.titleData;
        this.titleViews = new RoomSimplePagerTitleView[strArr2 != null ? strArr2.length : 0];
        ki.a aVar = this.mBindView;
        if (aVar != null && (viewPager2 = aVar.g) != null) {
            viewPager2.setAdapter(new d(subjectId));
        }
        C0();
    }

    private final void H0(View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        ki.a a = ki.a.a(view);
        this.mBindView = a;
        if (a != null && (appCompatImageView = a.b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AudioBottomSheetFragment.I0(AudioBottomSheetFragment.this, view2);
                }
            });
        }
        ki.a aVar = this.mBindView;
        if (aVar == null || (textView = aVar.f) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AudioBottomSheetFragment.J0(AudioBottomSheetFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(AudioBottomSheetFragment audioBottomSheetFragment, View view) {
        ClearTipsDialog a = ClearTipsDialog.INSTANCE.a();
        FragmentManager childFragmentManager = audioBottomSheetFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a.show(childFragmentManager, "dialog");
        a.s0(new e(a, audioBottomSheetFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(AudioBottomSheetFragment audioBottomSheetFragment, View view) {
        audioBottomSheetFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    public final int D0() {
        int i = getResources().getDisplayMetrics().heightPixels;
        return i - (i / 3);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext, getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = cVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.a.b(requireContext);
            attributes.height = D0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return cVar;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        H0(view);
        E0();
    }
}
