package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m extends BaseItemProvider {
    private final MemberTaskAdHelper e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private final int j = AdTaskType.REGULAR_AD.getValue();
    private final int k = R$layout.member_task_regular_item_layout;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdTaskState.values().length];
            try {
                iArr[AdTaskState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTaskState.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdTaskState.PLAYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdTaskState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdTaskState.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdTaskState.PLAYING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public m(MemberTaskAdHelper memberTaskAdHelper) {
        this.e = memberTaskAdHelper;
    }

    private final void C(v.a aVar) {
        NativeWrapperAdView h = aVar.h();
        if (h != null) {
            NativeWrapperAdView.simulatingClick$default(h, aVar.c(), null, aVar.j(), 2, null);
        }
    }

    private final void D(v.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_regular");
        hashMap.put("ad_state", aVar.e().name());
        hashMap.put("pull_new", String.valueOf(aVar.k()));
        qi.h.a.o("MemberAdTask", hashMap);
    }

    private final void E() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_regular");
        qi.h.a.z("MemberAdTask", hashMap);
    }

    private final void F(BaseViewHolder baseViewHolder, v.a aVar) {
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R$id.ad_container);
        MemberTaskAdHelper memberTaskAdHelper = this.e;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Q(aVar);
        }
        NativeWrapperAdView h = aVar.h();
        if (h != null) {
            ViewParent parent = h.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(h);
            }
            frameLayout.removeAllViews();
            frameLayout.addView(h);
        }
    }

    private final void G(v.a aVar) {
        u.a.v(aVar.i(), aVar.e());
    }

    private final void H(BaseViewHolder baseViewHolder, v.a aVar, boolean z) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.btn_action);
        int i = a.a[aVar.e().ordinal()];
        if (i == 1) {
            textView.setText("Downloading...");
            textView.setTextColor(this.h);
            return;
        }
        if (i == 2 || i == 3) {
            textView.setText("Claim");
            textView.setTextColor(this.g);
        } else if (i != 4) {
            textView.setText(z ? "Install" : "Open");
            textView.setTextColor(this.g);
        } else {
            textView.setText("Completed");
            textView.setTextColor(this.i);
        }
    }

    static /* synthetic */ void I(m mVar, BaseViewHolder baseViewHolder, v.a aVar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        mVar.H(baseViewHolder, aVar, z);
    }

    private final void J(final BaseViewHolder baseViewHolder, final v.a aVar, final boolean z) {
        uf.c.c((TextView) baseViewHolder.getView(R$id.btn_action), 0L, new Function1() { // from class: com.transsion.rewardscenter.task.ad.j
            public final Object invoke(Object obj) {
                Unit K;
                K = m.K(m.this, aVar, z, baseViewHolder, (View) obj);
                return K;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final m mVar, final v.a aVar, boolean z, final BaseViewHolder baseViewHolder, View view) {
        Intrinsics.h(view, "it");
        mVar.D(aVar);
        int i = a.a[aVar.e().ordinal()];
        if (i == 2) {
            MemberTaskAdHelper memberTaskAdHelper = mVar.e;
            if (memberTaskAdHelper != null) {
                memberTaskAdHelper.z(aVar, new Function0() { // from class: com.transsion.rewardscenter.task.ad.k
                    public final Object invoke() {
                        Unit L;
                        L = m.L(v.a.this, mVar, baseViewHolder);
                        return L;
                    }
                });
            }
        } else if (i == 3) {
            MemberTaskAdHelper memberTaskAdHelper2 = mVar.e;
            if (memberTaskAdHelper2 != null) {
                memberTaskAdHelper2.z(aVar, new Function0() { // from class: com.transsion.rewardscenter.task.ad.l
                    public final Object invoke() {
                        Unit M;
                        M = m.M(v.a.this, mVar, baseViewHolder);
                        return M;
                    }
                });
            }
        } else if (i == 5) {
            if (z) {
                aVar.m(AdTaskState.DOWNLOADING);
                aVar.o(System.currentTimeMillis());
            } else {
                aVar.m(AdTaskState.PLAYING);
            }
            I(mVar, baseViewHolder, aVar, false, 4, null);
            mVar.G(aVar);
            mVar.C(aVar);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(v.a aVar, m mVar, BaseViewHolder baseViewHolder) {
        aVar.m(AdTaskState.COMPLETED);
        I(mVar, baseViewHolder, aVar, false, 4, null);
        mVar.G(aVar);
        mVar.e.y(aVar.i(), Integer.valueOf(mVar.e.q(aVar.c().getSceneId())));
        u.a.q(aVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(v.a aVar, m mVar, BaseViewHolder baseViewHolder) {
        aVar.m(AdTaskState.COMPLETED);
        I(mVar, baseViewHolder, aVar, false, 4, null);
        mVar.G(aVar);
        return Unit.a;
    }

    private final void N(BaseViewHolder baseViewHolder, boolean z) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.member_point);
        if (z) {
            MemberTaskItem h = u.a.h();
            textView.setText("+" + (h != null ? h.getRewardAmount() : null) + " points");
            return;
        }
        MemberTaskItem g = u.a.g();
        textView.setText("+" + (g != null ? g.getRewardAmount() : null) + " points");
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, v vVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(vVar, "item");
        if (vVar instanceof v.a) {
            v.a aVar = (v.a) vVar;
            F(baseViewHolder, aVar);
            boolean k = aVar.k();
            N(baseViewHolder, k);
            if (!k && aVar.e() == AdTaskState.COMPLETED) {
                aVar.m(AdTaskState.NORMAL);
            }
            H(baseViewHolder, aVar, k);
            J(baseViewHolder, aVar, k);
            if (this.f) {
                return;
            }
            this.f = true;
            E();
        }
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(m(), viewGroup, false);
        this.g = androidx.core.content.b.getColor(viewGroup.getContext(), R.color.white);
        this.h = androidx.core.content.b.getColor(viewGroup.getContext(), R.color.white_50);
        this.i = androidx.core.content.b.getColor(viewGroup.getContext(), R.color.white_40);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
