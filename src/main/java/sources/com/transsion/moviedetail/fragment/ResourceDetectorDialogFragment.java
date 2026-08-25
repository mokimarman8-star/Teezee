package com.transsion.moviedetail.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.R;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0003J!\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/transsion/moviedetail/fragment/ResourceDetectorDialogFragment;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "p0", "()I", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "r0", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "original", "Landroid/text/SpannableString;", "q0", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onResume", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/transsion/moviedetailapi/bean/ResourceDetectors;", "c", "Lcom/transsion/moviedetailapi/bean/ResourceDetectors;", "mResourceDetector", "d", "Ljava/lang/String;", "mTitle", "e", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResourceDetectorDialogFragment extends BaseDialog {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private ResourceDetectors mResourceDetector;

    /* renamed from: d, reason: from kotlin metadata */
    private String mTitle;

    /* renamed from: com.transsion.moviedetail.fragment.ResourceDetectorDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResourceDetectorDialogFragment a(String str, ResourceDetectors resourceDetectors) {
            Intrinsics.h(str, "title");
            Intrinsics.h(resourceDetectors, "resourceDetectors");
            ResourceDetectorDialogFragment resourceDetectorDialogFragment = new ResourceDetectorDialogFragment();
            resourceDetectorDialogFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("arguments_resource_detectors_title", str), TuplesKt.a("arguments_resource_detectors", resourceDetectors)}));
            return resourceDetectorDialogFragment;
        }
    }

    public ResourceDetectorDialogFragment() {
        super(R$layout.dialog_resource_detector_layout);
        this.mTitle = BuildConfig.FLAVOR;
    }

    private final int p0() {
        int i = getResources().getDisplayMetrics().heightPixels;
        return i - (i / 3);
    }

    private final SpannableString q0(String original) {
        SpannableString spannableString = new SpannableString(original);
        if (StringsKt.c0(original, "etc", false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1FBDFF")), 0, StringsKt.o0(original, "etc", 0, false, 6, (Object) null), 17);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
            return spannableString;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1FBDFF")), 0, spannableString.length(), 17);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th3));
        }
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r0(View view) {
        String str;
        String uploadTime;
        TextView textView;
        Long firstSize;
        long longValue;
        Integer type;
        Long totalSize;
        String str2;
        ((ImageView) view.findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ResourceDetectorDialogFragment.s0(ResourceDetectorDialogFragment.this, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tvTitle)).setText(this.mTitle);
        TextView textView2 = (TextView) view.findViewById(R$id.tvUrl);
        if (textView2 != null) {
            ResourceDetectors resourceDetectors = this.mResourceDetector;
            textView2.setText(resourceDetectors != null ? resourceDetectors.getResourceLink() : null);
        }
        TextView textView3 = (TextView) view.findViewById(R$id.tvSourceData);
        String str3 = BuildConfig.FLAVOR;
        if (textView3 != null) {
            ResourceDetectors resourceDetectors2 = this.mResourceDetector;
            if (resourceDetectors2 == null || (str2 = resourceDetectors2.getSource()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            textView3.setText(q0(str2));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResourceDetectorDialogFragment.t0(ResourceDetectorDialogFragment.this, view2);
                }
            });
        }
        TextView textView4 = (TextView) view.findViewById(R$id.tvSizeData);
        long j = 0;
        if (textView4 != null) {
            ResourceDetectors resourceDetectors3 = this.mResourceDetector;
            if (resourceDetectors3 == null || (type = resourceDetectors3.getType()) == null || type.intValue() != 0) {
                ResourceDetectors resourceDetectors4 = this.mResourceDetector;
                if (resourceDetectors4 != null && (firstSize = resourceDetectors4.getFirstSize()) != null) {
                    longValue = firstSize.longValue();
                    textView4.setText(zg.b.a(longValue, 1));
                }
                longValue = 0;
                textView4.setText(zg.b.a(longValue, 1));
            } else {
                ResourceDetectors resourceDetectors5 = this.mResourceDetector;
                if (resourceDetectors5 != null && (totalSize = resourceDetectors5.getTotalSize()) != null) {
                    longValue = totalSize.longValue();
                    textView4.setText(zg.b.a(longValue, 1));
                }
                longValue = 0;
                textView4.setText(zg.b.a(longValue, 1));
            }
        }
        TextView textView5 = (TextView) view.findViewById(R$id.tvDateData);
        if (textView5 != null) {
            try {
                Result.Companion companion = Result.Companion;
                ResourceDetectors resourceDetectors6 = this.mResourceDetector;
                if (resourceDetectors6 != null && (uploadTime = resourceDetectors6.getUploadTime()) != null) {
                    j = Long.parseLong(uploadTime) * 1000;
                }
                str = com.blankj.utilcode.util.c0.b(com.blankj.utilcode.util.c0.g(j), "yyyy-MM-dd");
                Intrinsics.g(str, "date2String(...)");
                try {
                    Result.constructor-impl(Unit.a);
                } catch (Throwable th2) {
                    th = th2;
                    str3 = str;
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.a(th));
                    str = str3;
                    textView5.setText(str);
                    textView = (TextView) view.findViewById(R$id.tvUploadedBy);
                    if (textView == null) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            textView5.setText(str);
        }
        textView = (TextView) view.findViewById(R$id.tvUploadedBy);
        if (textView == null) {
            String string = textView.getContext().getString(R.string.base_ui_uploaded_by);
            ResourceDetectors resourceDetectors7 = this.mResourceDetector;
            textView.setText(string + " " + (resourceDetectors7 != null ? resourceDetectors7.getUploadBy() : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ResourceDetectorDialogFragment resourceDetectorDialogFragment, View view) {
        resourceDetectorDialogFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ResourceDetectorDialogFragment resourceDetectorDialogFragment, View view) {
        Navigator c = TheRouter.c("/web/web");
        ResourceDetectors resourceDetectors = resourceDetectorDialogFragment.mResourceDetector;
        Navigator.x(c.K("url", resourceDetectors != null ? resourceDetectors.getResourceLink() : null).z("load_url_only", true), resourceDetectorDialogFragment.requireContext(), (mf.c) null, 2, (Object) null);
        resourceDetectorDialogFragment.dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mResourceDetector = arguments.getSerializable("arguments_resource_detectors");
            this.mTitle = arguments.getString("arguments_resource_detectors_title");
        }
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
            attributes.height = p0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return cVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onResume() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
        }
        super.onResume();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        r0(view);
    }
}
