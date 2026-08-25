package com.transsion.commercialization.aha.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends BaseItemProvider {
    private final rj.a e;
    private final int f;

    public f(rj.a aVar) {
        Intrinsics.h(aVar, "gameDotHelper");
        this.e = aVar;
        this.f = GameLayoutType.PEOPLE_PLAYING.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(d dVar, f fVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        String link = ((AhaGameAllGames) dVar.getItem(i)).getLink();
        if (link != null) {
            Navigator.x(TheRouter.c("/web/web").K("url", link).K("page_from", "game_center"), view.getContext(), (mf.c) null, 2, (Object) null);
        }
        fVar.e.b((AhaGameAllGames) dVar.getItem(i), i, GameLayoutType.PEOPLE_PLAYING);
    }

    public int l() {
        return this.f;
    }

    public int m() {
        return R$layout.item_people_playing;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, AhaGameAllGames ahaGameAllGames) {
        RecyclerView viewOrNull;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(ahaGameAllGames, "item");
        List peoplePlaying = ahaGameAllGames.getPeoplePlaying();
        if (peoplePlaying == null || (viewOrNull = baseViewHolder.getViewOrNull(R$id.people_playing_recycler_view)) == null) {
            return;
        }
        viewOrNull.setLayoutManager(new NpaGridLayoutManager(viewOrNull.getContext(), 4));
        if (viewOrNull.getItemDecorationCount() <= 0) {
            viewOrNull.addItemDecoration(new tf.b(a0.a(4.0f), a0.a(4.0f), 0, 0));
        }
        if (peoplePlaying.size() >= 4) {
            peoplePlaying = peoplePlaying.subList(0, 4);
        }
        final d dVar = new d(peoplePlaying);
        dVar.w1(new r6.d() { // from class: com.transsion.commercialization.aha.adapter.e
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                f.A(d.this, this, baseQuickAdapter, view, i);
            }
        });
        viewOrNull.setAdapter(dVar);
    }
}
