package com.transsion.moviedetail.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.baselib.report.k;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.fragment.MovieDetailFragment;
import com.transsion.videofloat.manager.c;
import cw.e;
import im.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lm.a;
import yg.l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001>B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0005R\u0018\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010%R\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010%R\u0016\u00104\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u00103R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/transsion/moviedetail/activity/MovieDetailActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Llm/a;", "Lcom/transsion/videofloat/manager/c;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", BuildConfig.FLAVOR, "o0", "()Z", "n0", "isMonitorNetworkState", "l0", "m0", "k0", "p0", "retryLoadData", "D0", "()Llm/a;", "isTranslucent", "isStatusDark", "isChangeStatusBar", BuildConfig.FLAVOR, "statusColor", "()I", "getPageName", "isMusicFloatingAttach", "onPause", "h", "i", "Ljava/lang/String;", "id", "j", "ops", "k", "Z", "autoDownload", "l", "autoPlay", "m", "autoPlayResourceId", "n", "moduleName", "o", "I", "preloadId", "p", "curSeason", "q", "subjectYpe", "Landroidx/fragment/app/Fragment;", "r", "Landroidx/fragment/app/Fragment;", "mFragment", "s", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieDetailActivity extends BaseNewActivity<a> implements c {

    /* renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: from kotlin metadata */
    public String id;

    /* renamed from: j, reason: from kotlin metadata */
    public String ops;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean autoDownload;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean autoPlay;

    /* renamed from: m, reason: from kotlin metadata */
    public String autoPlayResourceId;

    /* renamed from: n, reason: from kotlin metadata */
    public String moduleName;

    /* renamed from: o, reason: from kotlin metadata */
    public int preloadId;

    /* renamed from: p, reason: from kotlin metadata */
    public int curSeason = 1;

    /* renamed from: q, reason: from kotlin metadata */
    public int subjectYpe = -1;

    /* renamed from: r, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: com.transsion.moviedetail.activity.MovieDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String str) {
            Intrinsics.h(str, "msg");
            Log.w("zxb_log_movie_detail", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0() {
        b bVar = (b) TheRouter.d(b.class, new Object[0]);
        if (bVar != null) {
            bVar.w(0.0f);
        }
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
        return "subjectdetail";
    }

    public void h() {
        MovieDetailFragment movieDetailFragment = this.mFragment;
        if (movieDetailFragment instanceof MovieDetailFragment) {
            MovieDetailFragment movieDetailFragment2 = movieDetailFragment instanceof MovieDetailFragment ? movieDetailFragment : null;
            if (movieDetailFragment2 != null) {
                movieDetailFragment2.x1();
            }
        }
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public boolean isMusicFloatingAttach() {
        return false;
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
        s0();
        ((a) getMViewBinding()).getRoot().post(new Runnable() { // from class: jm.a
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailActivity.E0();
            }
        });
    }

    public void m0() {
    }

    public boolean n0() {
        return true;
    }

    public boolean o0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        k.a.w(3, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            MovieDetailFragment movieDetailFragment = this.mFragment;
            MovieDetailFragment movieDetailFragment2 = movieDetailFragment instanceof MovieDetailFragment ? movieDetailFragment : null;
            if (movieDetailFragment2 != null) {
                movieDetailFragment2.x1();
            }
            e.a.b().j(this);
        }
    }

    public void p0() {
        if (this.mFragment == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            w p = supportFragmentManager.p();
            Intrinsics.g(p, "beginTransaction()");
            MovieDetailFragment a = MovieDetailFragment.INSTANCE.a();
            Bundle bundle = new Bundle();
            bundle.putString("id", this.id);
            bundle.putString("ops", this.ops);
            bundle.putBoolean("auto_download", this.autoDownload);
            bundle.putBoolean("auto_play", this.autoPlay);
            bundle.putString("auto_play_resource_id", this.autoPlayResourceId);
            bundle.putString("module_name", this.moduleName);
            bundle.putInt("season", this.curSeason);
            bundle.putInt("subject_type", this.subjectYpe);
            bundle.putInt("yy_preload_id", this.preloadId);
            a.setArguments(bundle);
            p.s(R$id.container, a);
            this.mFragment = a;
            p.j();
        }
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

    public int statusColor() {
        return R.color.black;
    }
}
