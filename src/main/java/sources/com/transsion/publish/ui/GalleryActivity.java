package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager.widget.ViewPager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$string;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import wf.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u0019\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0014¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010\u0018J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0018J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0018J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:¨\u0006?"}, d2 = {"Lcom/transsion/publish/ui/GalleryActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/c;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "Lcom/transsion/publish/api/PhotoEntity;", "photoEntity", "t0", "(Lcom/transsion/publish/api/PhotoEntity;)V", "v0", "s0", "initData", "o0", "info", BuildConfig.FLAVOR, "refresh", "q0", "(Lcom/transsion/publish/api/PhotoEntity;Z)V", "i0", "u0", "w0", "r0", "()Z", BuildConfig.FLAVOR, "position", "h0", "(I)V", BuildConfig.FLAVOR, "j0", "(Lcom/transsion/publish/api/PhotoEntity;)Ljava/lang/String;", "g0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "k0", "()Llo/c;", "onDestroy", "isTranslucent", "isStatusDark", "isChangeStatusBar", "onBackPressed", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "a", "Ljava/util/List;", "photos", "b", "select", "Lcom/transsion/publish/adapter/o0;", "c", "Lcom/transsion/publish/adapter/o0;", "travelsGalleryAdapter", "d", "I", "from", "e", "limit", "f", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GalleryActivity extends BaseActivity<lo.c> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.publish.adapter.o0 travelsGalleryAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private int from;

    /* renamed from: a, reason: from kotlin metadata */
    private List photos = new ArrayList();

    /* renamed from: b, reason: from kotlin metadata */
    private List select = new ArrayList();

    /* renamed from: e, reason: from kotlin metadata */
    private int limit = 1;

    /* renamed from: com.transsion.publish.ui.GalleryActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, List list, int i, int i2, int i3) {
            Intrinsics.h(context, "context");
            Intrinsics.h(list, "select");
            Intent intent = new Intent(context, (Class<?>) GalleryActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("select", (Serializable) list);
            intent.putExtra("index", i);
            intent.putExtra("from", i2);
            intent.putExtra("key_list", i3);
            context.startActivity(intent);
        }
    }

    public static final class b implements ViewPager.h {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            GalleryActivity.this.h0(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        TextView textView = ((lo.c) getMViewBinding()).j;
        Intrinsics.g(textView, "selectNumTV");
        textView.setVisibility(this.select.size() > 0 ? 0 : 8);
        ((lo.c) getMViewBinding()).j.setText(getString(R$string.image_select_num_tips, Integer.valueOf(this.select.size()), Integer.valueOf(this.limit)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(int position) {
        try {
            int i = this.from;
            if (2 != i) {
                if (3 == i) {
                    if (((PhotoEntity) this.photos.get(position)).getEnableSelect()) {
                        ((lo.c) getMViewBinding()).l.setText(MsgStyle.CUSTOM_LEFT_PIC);
                        ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.bg_linear_r16);
                        return;
                    } else {
                        ((lo.c) getMViewBinding()).l.setText(BuildConfig.FLAVOR);
                        ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.ic_select_number_bro);
                        return;
                    }
                }
                PhotoEntity photoEntity = (PhotoEntity) this.photos.get(position);
                if (photoEntity.getEnableSelect()) {
                    ((lo.c) getMViewBinding()).l.setText(j0(photoEntity));
                    ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.bg_linear_r16);
                    return;
                } else {
                    ((lo.c) getMViewBinding()).l.setText(BuildConfig.FLAVOR);
                    ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.ic_select_number_bro);
                    return;
                }
            }
            int i2 = position + 1;
            if (i2 > this.photos.size()) {
                ((lo.c) getMViewBinding()).k.setText(position + "/" + this.photos.size());
                return;
            }
            ((lo.c) getMViewBinding()).k.setText(i2 + "/" + this.photos.size());
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "checkStatus", message, false, 4, (Object) null);
            }
        }
    }

    private final void i0(PhotoEntity info) {
        if (!info.getEnableSelect()) {
            this.select.add(info);
            info.setEnableSelect(true);
        }
        ((lo.c) getMViewBinding()).l.setText(j0(info));
        ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.bg_linear_r16);
        w0();
        g0();
    }

    private final void initData() {
        o0();
    }

    private final void initView() {
        ((lo.c) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryActivity.l0(GalleryActivity.this, view);
            }
        });
        ((lo.c) getMViewBinding()).i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryActivity.m0(GalleryActivity.this, view);
            }
        });
        TextView textView = ((lo.c) getMViewBinding()).g;
        Intrinsics.g(textView, "confirmTV");
        uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.publish.ui.h0
            public final Object invoke(Object obj) {
                Unit n0;
                n0 = GalleryActivity.n0(GalleryActivity.this, (View) obj);
                return n0;
            }
        }, 1, (Object) null);
    }

    private final String j0(PhotoEntity info) {
        int i = 0;
        for (Object obj : this.select) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(info.getLocalPath(), ((PhotoEntity) obj).getLocalPath())) {
                return String.valueOf(i2);
            }
            i = i2;
        }
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(GalleryActivity galleryActivity, View view) {
        galleryActivity.w0();
        galleryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(GalleryActivity galleryActivity, View view) {
        int currentItem = ((lo.c) galleryActivity.getMViewBinding()).n.getCurrentItem();
        if (!galleryActivity.photos.isEmpty() && currentItem <= galleryActivity.photos.size()) {
            PhotoEntity photoEntity = (PhotoEntity) galleryActivity.photos.get(currentItem);
            try {
                int i = galleryActivity.from;
                if (i == 1) {
                    galleryActivity.s0(photoEntity);
                } else if (i == 2) {
                    galleryActivity.t0(photoEntity);
                } else if (i == 3) {
                    galleryActivity.v0(photoEntity);
                }
            } catch (Exception e) {
                a.a.g(wf.a.a, "ext:" + e.getMessage(), false, 2, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(GalleryActivity galleryActivity, View view) {
        Intrinsics.h(view, "it");
        PreviewMediaConfirmEvent previewMediaConfirmEvent = new PreviewMediaConfirmEvent(0, 1, null);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, previewMediaConfirmEvent, 0L);
        galleryActivity.finish();
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o0() {
        List e;
        ProgressBar progressBar = ((lo.c) getMViewBinding()).f;
        Intrinsics.g(progressBar, "clipLoading");
        uf.c.k(progressBar);
        if (getIntent().hasExtra("list")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("list");
            Intrinsics.f(serializableExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            e = TypeIntrinsics.c(serializableExtra);
        } else {
            e = com.transsion.publish.n.b.a().e();
        }
        this.photos = e;
        if (getIntent().hasExtra("select")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("select");
            Intrinsics.f(serializableExtra2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            this.select = TypeIntrinsics.c(serializableExtra2);
        }
        this.from = getIntent().getIntExtra("from", 1);
        this.limit = getIntent().getIntExtra("key_list", 1);
        int intExtra = getIntent().getIntExtra("index", 0);
        this.travelsGalleryAdapter = new com.transsion.publish.adapter.o0(this.photos);
        ((lo.c) getMViewBinding()).n.setAdapter(this.travelsGalleryAdapter);
        ProgressBar progressBar2 = ((lo.c) getMViewBinding()).f;
        Intrinsics.g(progressBar2, "clipLoading");
        uf.c.g(progressBar2);
        ((lo.c) getMViewBinding()).n.addOnPageChangeListener(new b());
        ((lo.c) getMViewBinding()).n.setCurrentItem(intExtra);
        int i = this.from;
        if (2 == i) {
            ((lo.c) getMViewBinding()).k.getVisibility();
            ImageView imageView = ((lo.c) getMViewBinding()).h;
            Intrinsics.g(imageView, "ivDelete");
            uf.c.k(imageView);
            LinearLayout linearLayout = ((lo.c) getMViewBinding()).i;
            Intrinsics.g(linearLayout, "llSelect");
            uf.c.g(linearLayout);
            Group group = ((lo.c) getMViewBinding()).b;
            Intrinsics.g(group, "bottomGroup");
            uf.c.g(group);
            ((lo.c) getMViewBinding()).h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GalleryActivity.p0(GalleryActivity.this, view);
                }
            });
        } else if (4 == i) {
            ((lo.c) getMViewBinding()).k.getVisibility();
            ImageView imageView2 = ((lo.c) getMViewBinding()).h;
            Intrinsics.g(imageView2, "ivDelete");
            uf.c.g(imageView2);
            LinearLayout linearLayout2 = ((lo.c) getMViewBinding()).i;
            Intrinsics.g(linearLayout2, "llSelect");
            uf.c.g(linearLayout2);
            Group group2 = ((lo.c) getMViewBinding()).b;
            Intrinsics.g(group2, "bottomGroup");
            uf.c.g(group2);
        } else {
            g0();
            Group group3 = ((lo.c) getMViewBinding()).b;
            Intrinsics.g(group3, "bottomGroup");
            uf.c.k(group3);
            TextView textView = ((lo.c) getMViewBinding()).k;
            Intrinsics.g(textView, "tvNum");
            uf.c.g(textView);
            ImageView imageView3 = ((lo.c) getMViewBinding()).h;
            Intrinsics.g(imageView3, "ivDelete");
            uf.c.g(imageView3);
        }
        h0(intExtra);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(GalleryActivity galleryActivity, View view) {
        int currentItem = ((lo.c) galleryActivity.getMViewBinding()).n.getCurrentItem();
        if (!galleryActivity.photos.isEmpty() && currentItem <= galleryActivity.photos.size()) {
            try {
                galleryActivity.t0((PhotoEntity) galleryActivity.photos.get(currentItem));
            } catch (Exception e) {
                a.a.g(wf.a.a, "ext:" + e.getMessage(), false, 2, (Object) null);
            }
        }
    }

    private final void q0(PhotoEntity info, boolean refresh) {
        if (info.getEnableSelect()) {
            u0(info);
            info.setEnableSelect(false);
            ((lo.c) getMViewBinding()).l.setText(BuildConfig.FLAVOR);
            ((lo.c) getMViewBinding()).l.setBackgroundResource(R$drawable.ic_select_number_bro);
        }
    }

    private final boolean r0() {
        return this.select.size() >= this.limit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s0(PhotoEntity photoEntity) {
        if (r0()) {
            if (photoEntity.getEnableSelect()) {
                q0(photoEntity, true);
                return;
            } else {
                com.tn.lib.widget.toast.core.h.a.l(getString(R$string.add_img_max_tips, Integer.valueOf(this.limit)));
                return;
            }
        }
        if (photoEntity.getEnableSelect()) {
            q0(photoEntity, false);
        } else {
            i0(photoEntity);
        }
    }

    private final void t0(PhotoEntity photoEntity) {
        if (photoEntity.getEnableSelect()) {
            PhotoEntity photoEntity2 = null;
            int i = 0;
            int i2 = 0;
            for (Object obj : this.photos) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                PhotoEntity photoEntity3 = (PhotoEntity) obj;
                if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                    i2 = i;
                    photoEntity2 = photoEntity3;
                }
                i = i3;
            }
            if (photoEntity2 == null) {
                return;
            }
            this.photos.remove(photoEntity2);
            com.transsion.publish.adapter.o0 o0Var = this.travelsGalleryAdapter;
            if (o0Var != null) {
                o0Var.c(this.photos);
            }
            u0(photoEntity);
            if (this.photos.isEmpty()) {
                w0();
                finish();
                return;
            }
            ViewPager viewPager = ((lo.c) getMViewBinding()).n;
            Intrinsics.g(viewPager, "vp");
            if (i2 > viewPager.getChildCount()) {
                ((lo.c) getMViewBinding()).n.setCurrentItem(0, false);
            } else {
                ((lo.c) getMViewBinding()).n.setCurrentItem(i2, false);
            }
            h0(i2);
        }
    }

    private final void u0(PhotoEntity info) {
        PhotoEntity photoEntity = null;
        for (PhotoEntity photoEntity2 : this.select) {
            if (TextUtils.equals(photoEntity2.getLocalPath(), info.getLocalPath())) {
                photoEntity2.setEnableSelect(false);
                photoEntity = photoEntity2;
            }
        }
        if (photoEntity != null) {
            this.select.remove(photoEntity);
        }
        w0();
        g0();
    }

    private final void v0(PhotoEntity photoEntity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(photoEntity);
        BigImageBean bigImageBean = new BigImageBean();
        bigImageBean.setFrom(Integer.valueOf(this.from));
        bigImageBean.setSelect(arrayList);
        if (photoEntity.getEnableSelect()) {
            photoEntity.setEnableSelect(false);
            bigImageBean.setOperator(2);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = BigImageBean.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bigImageBean, 0L);
            return;
        }
        photoEntity.setEnableSelect(true);
        bigImageBean.setOperator(1);
        FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = BigImageBean.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.postEvent(name2, bigImageBean, 0L);
        finish();
    }

    private final void w0() {
        BigImageBean bigImageBean = new BigImageBean();
        bigImageBean.setFrom(Integer.valueOf(this.from));
        bigImageBean.setSelect(this.select);
        bigImageBean.setOperator(1);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = BigImageBean.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bigImageBean, 0L);
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public lo.c getViewBinding() {
        lo.c c = lo.c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("gallery_page", false, 2, null);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        w0();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected void onDestroy() {
        super.onDestroy();
        ProgressBar progressBar = ((lo.c) getMViewBinding()).f;
        Intrinsics.g(progressBar, "clipLoading");
        uf.c.g(progressBar);
    }
}
