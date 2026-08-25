package com.transsion.moviedetail.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.usercenter.R;
import eh.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import uf.c;
import yg.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\nR*\u0010,\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00102\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/transsion/moviedetail/activity/SubjectListActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Leh/a;", "<init>", "()V", BuildConfig.FLAVOR, "C0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "D0", "()Leh/a;", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", "l0", "m0", "k0", "p0", "retryLoadData", BuildConfig.FLAVOR, "isTranslucent", "()Z", "o0", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "getPageName", "i", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "setParams", "params", "Ljava/lang/Class;", "Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "j", "Ljava/lang/Class;", "getTypeClass", "()Ljava/lang/Class;", "setTypeClass", "(Ljava/lang/Class;)V", "typeClass", "k", "Ljava/lang/String;", "getMTitle", "setMTitle", "(Ljava/lang/String;)V", "mTitle", "Landroidx/fragment/app/Fragment;", "l", "Landroidx/fragment/app/Fragment;", "mFragment", "m", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectListActivity extends BaseNewActivity<a> {

    /* renamed from: m, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: from kotlin metadata */
    private Bundle params;

    /* renamed from: j, reason: from kotlin metadata */
    private Class typeClass;

    /* renamed from: k, reason: from kotlin metadata */
    private String mTitle;

    /* renamed from: l, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: com.transsion.moviedetail.activity.SubjectListActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Bundle bundle, Class cls, String str) {
            Intrinsics.h(context, "context");
            Intrinsics.h(bundle, "params");
            Intrinsics.h(cls, "type");
            Intent intent = new Intent(context, (Class<?>) SubjectListActivity.class);
            intent.putExtra("subject_params_key", bundle);
            intent.putExtra("view_model_type", cls);
            intent.putExtra("subject_params_title", str);
            context.startActivity(intent);
        }
    }

    private final void C0() {
        SubjectListFragment a;
        Class cls = this.typeClass;
        if (cls == null) {
            finish();
            return;
        }
        SubjectListFragment k0 = getSupportFragmentManager().k0("subject_fragment_tag");
        if (k0 instanceof SubjectListFragment) {
            a = k0;
        } else {
            SubjectListFragment.Companion companion = SubjectListFragment.INSTANCE;
            Bundle bundle = this.params;
            if (bundle == null) {
                bundle = new Bundle();
            }
            a = companion.a(bundle, cls);
        }
        this.mFragment = a;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            p.t(R.id.container, fragment, "subject_fragment_tag");
        }
        p.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public String getPageName() {
        return "post_list";
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        if (this.typeClass == null) {
            Intent intent = getIntent();
            Serializable serializableExtra = intent.getSerializableExtra("view_model_type");
            this.typeClass = serializableExtra instanceof Class ? (Class) serializableExtra : null;
            this.params = intent.getBundleExtra("subject_params_key");
            this.mTitle = intent.getStringExtra("subject_params_title");
        }
        ConstraintLayout b = getMViewBinding().b();
        Intrinsics.g(b, "getRoot(...)");
        c.e(b);
        TitleLayout titleLayout = getMViewBinding().c;
        String str = this.mTitle;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        titleLayout.setTitleText(str);
    }

    public void m0() {
    }

    public boolean o0() {
        return false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        setIntent(intent);
        C0();
    }

    public void p0() {
        C0();
    }

    public void retryLoadData() {
        w0();
        if (!l.a.e()) {
            y0();
        } else {
            u0();
            p0();
        }
    }
}
