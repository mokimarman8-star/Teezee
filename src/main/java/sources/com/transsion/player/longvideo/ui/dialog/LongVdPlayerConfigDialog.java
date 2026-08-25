package com.transsion.player.longvideo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.a0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import com.transsion.player.longvideo.member.LongVodResolutionMemberView;
import com.transsion.player.longvideo.member.ResolutionMemberManager;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsnet.downloader.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0019\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,R0\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0:j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;`<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/transsion/player/longvideo/ui/dialog/LongVdPlayerConfigDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Lln/b;", "config", BuildConfig.FLAVOR, "w0", "(Lln/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "A0", "(Lln/b;)V", BuildConfig.FLAVOR, "dialogName", "u0", "(Ljava/lang/String;)V", "pageName", "Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;", "configType", BuildConfig.FLAVOR, "dataList", "Lln/a;", "longVdPlayerBean", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", "longVodPlayerView", "B0", "(Ljava/lang/String;Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;Ljava/util/List;Lln/a;Lcom/transsion/player/longvideo/ui/LongVodPlayerView;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "c", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", "d", "Lln/a;", "e", "Ljava/lang/String;", "f", "Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;", "g", "Ljava/util/List;", "Lcom/transsion/player/longvideo/ui/dialog/a;", "h", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/player/longvideo/ui/dialog/a;", "configViewModel", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "i", "[Ljava/lang/Float;", "speedConfigs", "j", "configs", "Ljava/util/HashMap;", "Lcom/transsion/player/longvideo/member/LongVodResolutionMemberView;", "Lkotlin/collections/HashMap;", "k", "Ljava/util/HashMap;", "itemViewMap", "l", "Lln/b;", "curConfig", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVdPlayerConfigDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private LongVodPlayerView longVodPlayerView;

    /* renamed from: d, reason: from kotlin metadata */
    private ln.a longVdPlayerBean;

    /* renamed from: e, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: f, reason: from kotlin metadata */
    private LongVodPlayerConfigType configType;

    /* renamed from: g, reason: from kotlin metadata */
    private List dataList;

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy configViewModel;

    /* renamed from: i, reason: from kotlin metadata */
    private final Float[] speedConfigs;

    /* renamed from: j, reason: from kotlin metadata */
    private List configs;

    /* renamed from: k, reason: from kotlin metadata */
    private final HashMap itemViewMap;

    /* renamed from: l, reason: from kotlin metadata */
    private ln.b curConfig;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LongVodPlayerConfigType.values().length];
            try {
                iArr[LongVodPlayerConfigType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodPlayerConfigType.BITRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public LongVdPlayerConfigDialog() {
        super(R$layout.long_vod_dialog_player_config);
        this.configType = LongVodPlayerConfigType.BITRATE;
        this.configViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.ui.dialog.a.class), new Function0<x0>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m71invoke() {
                x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m72invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.speedConfigs = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f)};
        this.configs = new ArrayList();
        this.itemViewMap = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(ln.b config) {
        if (config.e()) {
            return;
        }
        LongVodResolutionMemberView longVodResolutionMemberView = (LongVodResolutionMemberView) this.itemViewMap.get(this.curConfig);
        if (longVodResolutionMemberView != null) {
            longVodResolutionMemberView.setTextColor(-1);
        }
        LongVodResolutionMemberView longVodResolutionMemberView2 = (LongVodResolutionMemberView) this.itemViewMap.get(config);
        if (longVodResolutionMemberView2 != null) {
            longVodResolutionMemberView2.setGradientColorsV2(config);
        }
        this.curConfig = config;
        v0().c(config);
        dismiss();
    }

    private final void u0(String dialogName) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", dialogName);
        String str = this.pageName;
        if (str != null) {
            qi.h.a.p(str, hashMap);
        }
    }

    private final com.transsion.player.longvideo.ui.dialog.a v0() {
        return (com.transsion.player.longvideo.ui.dialog.a) this.configViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w0(ln.b bVar, Continuation continuation) {
        LongVdPlayerConfigDialog$isIntercept$1 longVdPlayerConfigDialog$isIntercept$1;
        int i;
        boolean booleanValue;
        if (continuation instanceof LongVdPlayerConfigDialog$isIntercept$1) {
            longVdPlayerConfigDialog$isIntercept$1 = (LongVdPlayerConfigDialog$isIntercept$1) continuation;
            int i2 = longVdPlayerConfigDialog$isIntercept$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                longVdPlayerConfigDialog$isIntercept$1.label = i2 - Integer.MIN_VALUE;
                Object obj = longVdPlayerConfigDialog$isIntercept$1.result;
                Object f = IntrinsicsKt.f();
                i = longVdPlayerConfigDialog$isIntercept$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (this.configType != LongVodPlayerConfigType.BITRATE) {
                        return Boxing.a(false);
                    }
                    ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
                    ln.a aVar = this.longVdPlayerBean;
                    longVdPlayerConfigDialog$isIntercept$1.L$0 = bVar;
                    longVdPlayerConfigDialog$isIntercept$1.label = 1;
                    obj = resolutionMemberManager.f(aVar, longVdPlayerConfigDialog$isIntercept$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (ln.b) longVdPlayerConfigDialog$isIntercept$1.L$0;
                    ResultKt.b(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                com.transsion.player.longvideo.member.k.a.a("LongVdPlayerConfigDialog --> 分辨率面板点击 --> isIntercept() --> isUnlock = " + booleanValue);
                if (!booleanValue) {
                    return Boxing.a(false);
                }
                LongVodPlayerView longVodPlayerView = this.longVodPlayerView;
                if (longVodPlayerView != null) {
                    longVodPlayerView.showResolutionIntercept(bVar);
                }
                return Boxing.a(true);
            }
        }
        longVdPlayerConfigDialog$isIntercept$1 = new LongVdPlayerConfigDialog$isIntercept$1(this, continuation);
        Object obj2 = longVdPlayerConfigDialog$isIntercept$1.result;
        Object f2 = IntrinsicsKt.f();
        i = longVdPlayerConfigDialog$isIntercept$1.label;
        if (i != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        com.transsion.player.longvideo.member.k.a.a("LongVdPlayerConfigDialog --> 分辨率面板点击 --> isIntercept() --> isUnlock = " + booleanValue);
        if (!booleanValue) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable x0(ln.b bVar) {
        Intrinsics.h(bVar, "it");
        return Integer.valueOf(bVar.d().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable y0(ln.b bVar) {
        Intrinsics.h(bVar, "it");
        return bVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LongVdPlayerConfigDialog longVdPlayerConfigDialog, ln.b bVar, View view) {
        LifecycleCoroutineScope a2;
        AppCompatActivity activity = longVdPlayerConfigDialog.getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? activity : null;
        if (appCompatActivity == null || (a2 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.i.d(a2, (CoroutineContext) null, (CoroutineStart) null, new LongVdPlayerConfigDialog$onViewCreated$1$1$1(bVar, longVdPlayerConfigDialog, null), 3, (Object) null);
    }

    public final void B0(String pageName, LongVodPlayerConfigType configType, List dataList, ln.a longVdPlayerBean, LongVodPlayerView longVodPlayerView) {
        Intrinsics.h(configType, "configType");
        Intrinsics.h(longVodPlayerView, "longVodPlayerView");
        this.pageName = pageName;
        this.configType = configType;
        this.dataList = dataList;
        this.longVdPlayerBean = longVdPlayerBean;
        this.longVodPlayerView = longVodPlayerView;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.DownloadBottomDialogTheme);
        int i = a.a[this.configType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            u0("dialog_stream_resolution");
            List<ln.b> list = this.dataList;
            if (list != null) {
                for (ln.b bVar : list) {
                    this.configs.add(bVar);
                    if (bVar.e()) {
                        this.curConfig = bVar;
                    }
                }
                CollectionsKt.A(this.configs, ComparisonsKt.b(new Function1[]{new Function1() { // from class: com.transsion.player.longvideo.ui.dialog.c
                    public final Object invoke(Object obj) {
                        Comparable x0;
                        x0 = LongVdPlayerConfigDialog.x0((ln.b) obj);
                        return x0;
                    }
                }, new Function1() { // from class: com.transsion.player.longvideo.ui.dialog.d
                    public final Object invoke(Object obj) {
                        Comparable y0;
                        y0 = LongVdPlayerConfigDialog.y0((ln.b) obj);
                        return y0;
                    }
                }}));
                return;
            }
            return;
        }
        u0("dialog_stream_speed");
        float a2 = com.transsion.player.longvideo.helper.v.a.a();
        this.configs.clear();
        for (Float f : this.speedConfigs) {
            float floatValue = f.floatValue();
            ln.b bVar2 = new ln.b(a2 == floatValue, String.valueOf(floatValue), LongVodPlayerConfigType.SPEED);
            this.configs.add(bVar2);
            if (bVar2.e()) {
                this.curConfig = bVar2;
            }
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_root);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.blankj.utilcode.util.i.e(48.0f));
        for (final ln.b bVar : this.configs) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            LongVodResolutionMemberView longVodResolutionMemberView = new LongVodResolutionMemberView(context, null, 2, null);
            longVodResolutionMemberView.setConfig(bVar, this.longVdPlayerBean);
            longVodResolutionMemberView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LongVdPlayerConfigDialog.z0(LongVdPlayerConfigDialog.this, bVar, view2);
                }
            });
            linearLayout.addView(longVodResolutionMemberView, layoutParams);
            this.itemViewMap.put(bVar, longVodResolutionMemberView);
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(uf.c.f() ? com.tn.lib.widget.R.style.ActionSheetDialogLeft : com.tn.lib.widget.R.style.ActionSheetDialogRight);
        window.setGravity(uf.c.f() ? 8388611 : 8388613);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(null);
        window.setLayout(a0.a(140.0f), -1);
        ImmersionBar with = ImmersionBar.with(this);
        with.hideBar(BarHide.FLAG_HIDE_BAR);
        with.init();
    }
}
