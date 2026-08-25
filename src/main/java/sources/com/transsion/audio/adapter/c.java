package com.transsion.audio.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$drawable;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$string;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001fB\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0018¨\u0006 "}, d2 = {"Lcom/transsion/audio/adapter/c;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/baselib/db/audio/AudioBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "K1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/baselib/db/audio/AudioBean;)V", "G1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/baselib/db/audio/AudioBean;Ljava/util/List;)V", "D1", "Lcom/transsion/audio/adapter/c$a;", "listener", "I1", "(Lcom/transsion/audio/adapter/c$a;)V", "F", "Lcom/transsion/audio/adapter/c$a;", "F1", "()Lcom/transsion/audio/adapter/c$a;", "J1", "optionClickListener", "a", "Audio_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private a optionClickListener;

    public interface a {
        void a(AudioBean audioBean);

        void b(AudioBean audioBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<AudioBean> list) {
        super(R$layout.adapter_item_bottom_dialog, list);
        Intrinsics.h(list, "dataList");
    }

    private final void G1(BaseViewHolder holder, final AudioBean item) {
        TextView textView = (TextView) holder.getView(R$id.tv_process);
        Long readProcess = item.getReadProcess();
        long longValue = readProcess != null ? readProcess.longValue() : 0L;
        Long duration = item.getDuration();
        int i = (int) (((longValue * 1.0f) / ((duration != null ? duration.longValue() : 1L) > 0 ? r8 : 1L)) * 100);
        if (i >= 0 && i < 101) {
            textView.setText(i + getContext().getString(R$string.listened));
        }
        ProgressBar progressBar = (ProgressBar) holder.getView(R$id.pb_subject);
        final ImageView imageView = (ImageView) holder.getView(R$id.iv_subject);
        imageView.setVisibility(0);
        progressBar.setVisibility(8);
        imageView.setImageResource(R$drawable.play_progress_bg);
        int status = item.getStatus();
        if (status == 1) {
            String string = getContext().getString(R$string.not_open);
            Intrinsics.g(string, "getString(...)");
            textView.setText(string);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (status == 6) {
            String string2 = getContext().getString(R$string.finished);
            Intrinsics.g(string2, "getString(...)");
            textView.setText(string2);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (status != 7) {
            progressBar.setVisibility(0);
            if (item.getStatus() == 3) {
                imageView.setImageResource(R$drawable.playing_progress_bg);
            } else {
                imageView.setImageResource(R$drawable.play_progress_bg);
            }
            progressBar.setProgress(i);
        } else {
            String string3 = getContext().getString(R$string.error);
            Intrinsics.g(string3, "getString(...)");
            textView.setText(string3);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.H1(item, imageView, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(AudioBean audioBean, ImageView imageView, c cVar, View view) {
        if (audioBean.getStatus() == 3) {
            imageView.setImageResource(R$drawable.play_progress_bg);
        } else {
            imageView.setImageResource(R$drawable.playing_progress_bg);
        }
        a aVar = cVar.optionClickListener;
        if (aVar != null) {
            aVar.b(audioBean);
        }
    }

    private final void K1(BaseViewHolder holder, final AudioBean item) {
        String title = item.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = item.getDesc();
        }
        holder.setText(R$id.tv_name, title);
        int i = R$id.tv_size;
        Long size = item.getSize();
        holder.setText(i, size != null ? zg.b.a(size.longValue(), 1) : null);
        holder.getView(R$id.iv_del).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.L1(c.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(c cVar, AudioBean audioBean, View view) {
        a aVar = cVar.optionClickListener;
        if (aVar != null) {
            aVar.a(audioBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, AudioBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        K1(holder, item);
        G1(holder, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, AudioBean item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        G1(holder, item);
    }

    /* renamed from: F1, reason: from getter */
    public final a getOptionClickListener() {
        return this.optionClickListener;
    }

    public final void I1(a listener) {
        Intrinsics.h(listener, "listener");
        this.optionClickListener = listener;
    }

    public final void J1(a aVar) {
        this.optionClickListener = aVar;
    }

    public /* bridge */ /* synthetic */ f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
