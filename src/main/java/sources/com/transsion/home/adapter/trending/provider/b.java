package com.transsion.home.adapter.trending.provider;

import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.home.R;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(b bVar, com.transsion.home.adapter.trending.adapter.a aVar, Subject subject, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        bVar.C(view, (ExplainBean) CollectionsKt.l0(aVar.getData(), i), subject);
    }

    private final void C(View view, ExplainBean explainBean, Subject subject) {
        String deeplink;
        Uri g;
        if (explainBean == null || (deeplink = explainBean.getDeeplink()) == null || (g = com.transsion.baselib.helper.b.a.g(Uri.parse(deeplink))) == null) {
            return;
        }
        String queryParameter = g.getQueryParameter("type");
        if (queryParameter == null) {
            queryParameter = g.getPath();
        }
        Navigator c = TheRouter.c(queryParameter);
        Set<String> keySet = c.m().keySet();
        Intrinsics.g(keySet, "keySet(...)");
        for (String str : keySet) {
            Intrinsics.e(str);
            if (StringsKt.c0(str, "/movie/detail", false, 2, (Object) null) || StringsKt.c0(str, "/playvideo/detail", false, 2, (Object) null)) {
                c.K("ops", z("EXP", explainBean.getType(), subject));
            }
            c.K(str, c.m().getString(str));
        }
        Navigator.x(c, view.getContext(), (mf.c) null, 2, (Object) null);
    }

    private final String z(String str, String str2, Subject subject) {
        String ops;
        JSONObject jSONObject;
        String ops2;
        if (subject != null) {
            try {
                ops = subject.getOps();
            } catch (Exception e) {
                e.printStackTrace();
                return subject != null ? subject.getOps() : null;
            }
        } else {
            ops = null;
        }
        if (ops != null && ops.length() != 0) {
            jSONObject = (subject == null || (ops2 = subject.getOps()) == null) ? new JSONObject() : new JSONObject(ops2);
            jSONObject.put("rec_type", str);
            jSONObject.put("label", str2);
            return jSONObject.toString();
        }
        jSONObject = new JSONObject();
        jSONObject.put("rec_type", str);
        jSONObject.put("label", str2);
        return jSONObject.toString();
    }

    public final void A(BaseViewHolder baseViewHolder, final Subject subject) {
        String postTitle;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(subject, "item");
        LinearLayoutCompat viewOrNull = baseViewHolder.getViewOrNull(R.id.post_title_container);
        if (viewOrNull != null) {
            String postTitle2 = subject.getPostTitle();
            if (postTitle2 == null || postTitle2.length() == 0 || ((postTitle = subject.getPostTitle()) != null && StringsKt.W(postTitle, "Trailer-", false, 2, (Object) null))) {
                uf.c.g(viewOrNull);
                View viewOrNull2 = baseViewHolder.getViewOrNull(R.id.tag_divider);
                if (viewOrNull2 != null) {
                    uf.c.g(viewOrNull2);
                }
            } else {
                uf.c.k(viewOrNull);
                View viewOrNull3 = baseViewHolder.getViewOrNull(R.id.tag_divider);
                if (viewOrNull3 != null) {
                    uf.c.k(viewOrNull3);
                }
            }
        }
        AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.postTitle);
        if (viewOrNull4 != null) {
            viewOrNull4.setText(subject.getPostTitle());
        }
        RecyclerView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.tag_list);
        if (viewOrNull5 != null) {
            List explains = subject.getExplains();
            if (explains == null || explains.isEmpty()) {
                uf.c.g(viewOrNull5);
                View viewOrNull6 = baseViewHolder.getViewOrNull(R.id.tag_divider);
                if (viewOrNull6 != null) {
                    uf.c.g(viewOrNull6);
                    return;
                }
                return;
            }
            uf.c.k(viewOrNull5);
            List explains2 = subject.getExplains();
            if (explains2 != null) {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(viewOrNull5.getContext());
                if (viewOrNull5.getItemDecorationCount() == 0) {
                    com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(viewOrNull5.getContext());
                    dVar.i(androidx.core.content.b.getDrawable(viewOrNull5.getContext(), com.tn.lib.widget.R.drawable.divider_flexbox));
                    viewOrNull5.addItemDecoration(dVar);
                }
                flexboxLayoutManager.b0(0);
                flexboxLayoutManager.d0(1);
                flexboxLayoutManager.c0(0);
                viewOrNull5.setLayoutManager(flexboxLayoutManager);
                final com.transsion.home.adapter.trending.adapter.a aVar = new com.transsion.home.adapter.trending.adapter.a(explains2);
                aVar.w1(new r6.d() { // from class: com.transsion.home.adapter.trending.provider.a
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        b.B(b.this, aVar, subject, baseQuickAdapter, view, i);
                    }
                });
                viewOrNull5.setAdapter(aVar);
            }
        }
    }
}
