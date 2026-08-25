package com.transsion.publish.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.view.CustomPublishHeader;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ro.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J#\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J1\u0010\"\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005J\u0015\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0017¢\u0006\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/transsion/publish/ui/FilmReviewActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Llo/b;", "Lro/a;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "Lcom/transsion/publish/api/GroupBean;", "groupBean", "i0", "(Lcom/transsion/moviedetailapi/bean/Subject;Lcom/transsion/publish/api/GroupBean;)V", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "e0", "()Llo/b;", "onBackPressed", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", BuildConfig.FLAVOR, "p0", BuildConfig.FLAVOR, "p1", "p2", "p3", "onTextChanged", "(Ljava/lang/CharSequence;III)V", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onResume", "enable", "j0", "(Z)V", "Lcom/transsion/publish/ui/FilmReviewFragment;", "a", "Lcom/transsion/publish/ui/FilmReviewFragment;", "fragment", "b", "I", "sourceType", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "getSubject", "()Lcom/transsion/moviedetailapi/bean/Subject;", "setSubject", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FilmReviewActivity extends BaseActivity<lo.b> implements ro.a {

    /* renamed from: a, reason: from kotlin metadata */
    private FilmReviewFragment fragment;

    /* renamed from: b, reason: from kotlin metadata */
    private int sourceType;

    /* renamed from: c, reason: from kotlin metadata */
    private Subject subject;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(FilmReviewActivity filmReviewActivity, View view) {
        FilmReviewFragment filmReviewFragment = filmReviewActivity.fragment;
        if (filmReviewFragment != null) {
            filmReviewFragment.closeAffirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(FilmReviewActivity filmReviewActivity, View view) {
        FilmReviewFragment filmReviewFragment = filmReviewActivity.fragment;
        if (filmReviewFragment != null) {
            filmReviewFragment.checkPost();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0() {
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.c();
        }
    }

    private final void i0(Subject subject, GroupBean groupBean) {
        if (subject != null) {
            CustomPublishHeader customPublishHeader = ((lo.b) getMViewBinding()).c;
            String title = subject.getTitle();
            Cover cover = subject.getCover();
            customPublishHeader.setHeader(title, cover != null ? cover.getUrl() : null);
        }
        if (groupBean != null) {
            ((lo.b) getMViewBinding()).c.setHeader(groupBean.getName(), groupBean.getAvatar());
        }
    }

    private final void initData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        GroupBean groupBean;
        ((lo.b) getMViewBinding()).c.setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilmReviewActivity.f0(FilmReviewActivity.this, view);
            }
        });
        ((lo.b) getMViewBinding()).c.setOnEditClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilmReviewActivity.g0(FilmReviewActivity.this, view);
            }
        });
        this.sourceType = getIntent().getIntExtra("sourceType", 1);
        int intExtra = getIntent().getIntExtra("sourceMode", 0);
        if (getIntent().hasExtra("subject")) {
            Subject serializableExtra = getIntent().getSerializableExtra("subject");
            Intrinsics.f(serializableExtra, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
            this.subject = serializableExtra;
        }
        if (getIntent().hasExtra("group")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("group");
            Intrinsics.f(serializableExtra2, "null cannot be cast to non-null type com.transsion.publish.api.GroupBean");
            groupBean = (GroupBean) serializableExtra2;
        } else {
            groupBean = null;
        }
        if (this.sourceType == 2) {
            i0(this.subject, groupBean);
        } else {
            ((lo.b) getMViewBinding()).c.setTitle(getString(R$string.film_review_title));
        }
        this.fragment = FilmReviewFragment.INSTANCE.a(this.sourceType, this.subject, intExtra, groupBean);
        androidx.fragment.app.w p = getSupportFragmentManager().p();
        int i = R$id.fl_content;
        FilmReviewFragment filmReviewFragment = this.fragment;
        Intrinsics.e(filmReviewFragment);
        p.s(i, filmReviewFragment).j();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    @Override // ro.a, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        a.C0091a.a(this, editable);
    }

    @Override // ro.a, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        a.C0091a.b(this, charSequence, i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public lo.b getViewBinding() {
        lo.b c = lo.b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return this.sourceType == 2 ? "create_post" : "create_review";
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isStatusDark() {
        return !ij.y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public final void j0(boolean enable) {
        CustomPublishHeader customPublishHeader = ((lo.b) getMViewBinding()).c;
        if (customPublishHeader != null) {
            customPublishHeader.setPostEnable(enable);
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void onBackPressed() {
        FilmReviewFragment filmReviewFragment = this.fragment;
        if (filmReviewFragment != null) {
            filmReviewFragment.closeAffirm();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        ((lo.b) getMViewBinding()).b.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewActivity.h0();
            }
        }, 100L);
    }

    protected void onDestroy() {
        super.onDestroy();
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.e();
        }
    }

    public void onResume() {
        super.onResume();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
    }
}
