package com.transsion.web.share;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.util.q;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;
import com.transsion.web.R$string;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 52\u00020\u0001:\u00036\u001e7B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\bR\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'Rk\u00104\u001aK\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b*\u0012\b\b\u0005\u0012\u0004\b\b(+\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b*\u0012\b\b\u0005\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b*\u0012\b\b\u0005\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0006\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/transsion/web/share/WebShareDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "s0", "(Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "isShow", "t0", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "c", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "setSource", "source", "d", "dialogName", "e", "Z", "isShowTitle", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "packageName", "backUpPackageName", "txt", "f", "Lkotlin/jvm/functions/Function3;", "getClickCallback", "()Lkotlin/jvm/functions/Function3;", "r0", "(Lkotlin/jvm/functions/Function3;)V", "clickCallback", "g", "a", "b", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class WebShareDialog extends BaseDialog {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private String source;

    /* renamed from: d, reason: from kotlin metadata */
    private String dialogName = "web_share_panel";

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isShowTitle = true;

    /* renamed from: f, reason: from kotlin metadata */
    private Function3 clickCallback;

    /* renamed from: com.transsion.web.share.WebShareDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebShareDialog a(String jsonObject) {
            Intrinsics.h(jsonObject, "jsonObject");
            WebShareDialog webShareDialog = new WebShareDialog();
            Bundle bundle = new Bundle();
            bundle.putString("json", jsonObject);
            webShareDialog.setArguments(bundle);
            return webShareDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/web/share/WebShareDialog$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/web/share/WebShareDialog$c;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/web/share/WebShareDialog$c;)V", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
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

        public final String e() {
            return this.c;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(WebShareDialog webShareDialog, View view) {
        webShareDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(List list, WebShareDialog webShareDialog, b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        c cVar = (c) list.get(i);
        Function3 function3 = webShareDialog.clickCallback;
        if (function3 != null) {
            function3.invoke(cVar.d(), cVar.b(), cVar.e());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", bVar.getContext().getString(cVar.a()));
        String str = webShareDialog.source;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("source", str);
        hashMap.put("dialog_name", webShareDialog.dialogName);
        qi.h.a.o("MbShareDialog", hashMap);
        webShareDialog.dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomDialogTheme);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext);
        Window window = cVar.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.a.b(requireContext);
            attributes.height = -2;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return cVar;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_share, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        View findViewById;
        HashMap g;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("json") : null;
        if (TextUtils.isEmpty(string)) {
            string = "{}";
        }
        JSONObject jSONObject = new JSONObject(string);
        String optString = jSONObject.optString("title");
        this.source = jSONObject.optString("H5Source");
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            String str = this.source;
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            g.put("source", str);
        }
        if (!this.isShowTitle && (findViewById = view.findViewById(R$id.ll_title)) != null) {
            findViewById.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_title);
        if (textView != null) {
            textView.setText(optString);
        }
        final ArrayList arrayList = new ArrayList();
        String optString2 = jSONObject.optString("WhatsApp");
        Intrinsics.e(optString2);
        if (optString2.length() > 0) {
            arrayList.add(new c(R.mipmap.player_ic_whatsapp, R$string.whatsapp, optString2, "com.whatsapp", null, 16, null));
        }
        String optString3 = jSONObject.optString("Telegram");
        Intrinsics.e(optString3);
        if (optString3.length() > 0) {
            arrayList.add(new c(R.mipmap.player_ic_telegram, R$string.telegram, optString3, "org.telegram.messenger", "org.telegram.messenger.web"));
        }
        String optString4 = jSONObject.optString("CopyLink");
        Intrinsics.e(optString4);
        if (optString4.length() > 0) {
            arrayList.add(new c(R.mipmap.player_ic_copy_link, R$string.copy_link, optString4, HttpUrl.FRAGMENT_ENCODE_SET, null, 16, null));
        }
        View findViewById2 = view.findViewById(R$id.ll_title);
        if (findViewById2 != null) {
            q.c(findViewById2, com.blankj.utilcode.util.i.e(6.0f));
        }
        View findViewById3 = view.findViewById(R$id.iv_close);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.web.share.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WebShareDialog.p0(WebShareDialog.this, view2);
                }
            });
        }
        RecyclerView findViewById4 = view.findViewById(R$id.share_list);
        if (findViewById4 != null) {
            findViewById4.addItemDecoration(new tf.d(a0.a(16.0f)));
            findViewById4.setLayoutManager(new LinearLayoutManager(findViewById4.getContext(), 0, false));
            final b bVar = new b();
            bVar.q1(arrayList);
            bVar.w1(new r6.d() { // from class: com.transsion.web.share.f
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    WebShareDialog.q0(arrayList, this, bVar, baseQuickAdapter, view2, i);
                }
            });
            findViewById4.setAdapter(bVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", this.dialogName);
        qi.h.a.p("MbShareDialog", hashMap);
    }

    public final void r0(Function3 function3) {
        this.clickCallback = function3;
    }

    public final void s0(String name) {
        Intrinsics.h(name, "name");
        this.dialogName = name;
    }

    public final void t0(boolean isShow) {
        this.isShowTitle = isShow;
    }
}
