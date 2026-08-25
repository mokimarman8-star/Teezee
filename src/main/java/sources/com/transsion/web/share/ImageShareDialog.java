package com.transsion.web.share;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.R;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;
import com.transsion.web.R$string;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import oq.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/transsion/web/share/ImageShareDialog;", "Lcom/transsion/baseui/dialog/BaseDialogFragment;", "Liw/b;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", "backUpName", HttpUrl.FRAGMENT_ENCODE_SET, "q0", "(Ljava/lang/String;Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "result", "pageName", "t0", "(ZLjava/lang/String;)V", "backUpPackageName", "m0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/web/share/ImageShareDialog$c;", "n0", "()Ljava/util/List;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "initView", "c0", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroid/net/Uri;", "e", "Landroid/net/Uri;", "imageUri", "f", "a", "c", "b", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ImageShareDialog extends BaseDialogFragment<iw.b> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: from kotlin metadata */
    private Uri imageUri;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* renamed from: com.transsion.web.share.ImageShareDialog$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, iw.b> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, iw.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/web/databinding/DialogImgeShareBinding;", 0);
        }

        public final iw.b invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.h(p0, "p0");
            return iw.b.c(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
        }
    }

    /* renamed from: com.transsion.web.share.ImageShareDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageShareDialog a(Uri imageUrl) {
            Intrinsics.h(imageUrl, "imageUrl");
            ImageShareDialog imageShareDialog = new ImageShareDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("imageUrl", imageUrl);
            imageShareDialog.setArguments(bundle);
            return imageShareDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/web/share/ImageShareDialog$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/web/share/ImageShareDialog$c;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/web/share/ImageShareDialog$c;)V", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class b extends BaseQuickAdapter {
        public b() {
            super(R$layout.item_share, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, c item) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            TextView textView = (TextView) holder.getView(R$id.tv_share);
            textView.setText(item.a());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, item.c(), 0, 0);
        }
    }

    public static final class c {
        private final int a;
        private final int b;
        private final String c;
        private final String d;
        private final String e;

        public c(int i, int i2, String txt, String packageName, String str) {
            Intrinsics.h(txt, "txt");
            Intrinsics.h(packageName, "packageName");
            this.a = i;
            this.b = i2;
            this.c = txt;
            this.d = packageName;
            this.e = str;
        }

        public /* synthetic */ c(int i, int i2, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, str, str2, (i3 & 16) != 0 ? null : str3);
        }

        public final int a() {
            return this.b;
        }

        public final String b() {
            return this.e;
        }

        public final int c() {
            return this.a;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && Intrinsics.c(this.c, cVar.c) && Intrinsics.c(this.d, cVar.d) && Intrinsics.c(this.e, cVar.e);
        }

        public int hashCode() {
            int hashCode = ((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String str = this.e;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ShareItem(iconRes=" + this.a + ", appNameRes=" + this.b + ", txt=" + this.c + ", packageName=" + this.d + ", backPackageName=" + this.e + ")";
        }
    }

    public ImageShareDialog() {
        super(AnonymousClass1.INSTANCE);
    }

    private final String m0(String packageName, String backUpPackageName) {
        if (packageName != null && com.transsion.baseui.util.a.a.c(getContext(), packageName)) {
            return packageName;
        }
        if (backUpPackageName == null || !com.transsion.baseui.util.a.a.c(getContext(), backUpPackageName)) {
            return null;
        }
        return backUpPackageName;
    }

    private final List n0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(R.mipmap.player_ic_whatsapp, R$string.whatsapp, "whatsup", "com.whatsapp", null, 16, null));
        arrayList.add(new c(R.mipmap.player_ic_telegram, R$string.telegram, "Telegram", "org.telegram.messenger", "org.telegram.messenger.web"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ImageShareDialog imageShareDialog, View view) {
        imageShareDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(List list, ImageShareDialog imageShareDialog, b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        c cVar = (c) list.get(i);
        imageShareDialog.q0(cVar.d(), cVar.b());
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", bVar.getContext().getString(cVar.a()));
        qi.h hVar = qi.h.a;
        hashMap.put("source", hVar.h());
        hVar.o("web_share_panel", hashMap);
        imageShareDialog.dismiss();
    }

    private final void q0(String packageName, String backUpName) {
        final String m0 = m0(packageName, backUpName);
        if (Intrinsics.c(packageName, "org.telegram.messenger")) {
            p pVar = p.a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            pVar.b(requireActivity, this.imageUri, new Function1() { // from class: com.transsion.web.share.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit r0;
                    r0 = ImageShareDialog.r0(ImageShareDialog.this, m0, ((Boolean) obj).booleanValue());
                    return r0;
                }
            });
            return;
        }
        if (Intrinsics.c(packageName, "com.whatsapp")) {
            p pVar2 = p.a;
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.g(requireActivity2, "requireActivity(...)");
            pVar2.a(requireActivity2, m0, this.imageUri, new Function1() { // from class: com.transsion.web.share.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s0;
                    s0 = ImageShareDialog.s0(ImageShareDialog.this, m0, ((Boolean) obj).booleanValue());
                    return s0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(ImageShareDialog imageShareDialog, String str, boolean z) {
        imageShareDialog.t0(z, str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(ImageShareDialog imageShareDialog, String str, boolean z) {
        imageShareDialog.t0(z, str);
        return Unit.a;
    }

    private final void t0(boolean result, String pageName) {
        if (result) {
            return;
        }
        if (pageName == null || pageName.length() == 0) {
            com.tn.lib.widget.toast.core.h.a.k(R$string.web_app_not_exist);
        } else {
            com.tn.lib.widget.toast.core.h.a.k(R$string.share_failed_tips);
        }
    }

    public void c0() {
    }

    public void initView() {
        Bundle arguments = getArguments();
        this.imageUri = arguments != null ? (Uri) arguments.getParcelable("imageUrl") : null;
        ShapeableImageView ivShare = ((iw.b) getMViewBinding()).c;
        Intrinsics.g(ivShare, "ivShare");
        cp.a.a(ivShare, this.imageUri, 4.0f);
        ((iw.b) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.web.share.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageShareDialog.o0(ImageShareDialog.this, view);
            }
        });
        RecyclerView recyclerView = ((iw.b) getMViewBinding()).d;
        recyclerView.addItemDecoration(new tf.d(a0.a(16.0f)));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        final List n0 = n0();
        final b bVar = new b();
        bVar.q1(n0);
        bVar.w1(new r6.d() { // from class: com.transsion.web.share.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ImageShareDialog.p0(n0, this, bVar, baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(bVar);
    }

    public qi.b newLogViewConfig() {
        return new qi.b("share_panel", false, 2, (DefaultConstructorMarker) null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomDialogTheme);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = a0.a(287.0f);
        attributes.width = -1;
        window.setGravity(80);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(Z());
        }
        window.setAttributes(attributes);
    }
}
