package com.transsion.audio.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$drawable;
import com.transsion.audio.R$id;
import com.transsion.audio.R$string;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.adapter.SubjectListAdapter$refresh$1", f = "SubjectListAdapter.kt", l = {75}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListAdapter$refresh$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $download;
    final /* synthetic */ BaseViewHolder $holder;
    int label;
    final /* synthetic */ SubjectListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListAdapter$refresh$1(DownloadItem downloadItem, BaseViewHolder baseViewHolder, SubjectListAdapter subjectListAdapter, Continuation<? super SubjectListAdapter$refresh$1> continuation) {
        super(2, continuation);
        this.$download = downloadItem;
        this.$holder = baseViewHolder;
        this.this$0 = subjectListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DownloadItem downloadItem, ImageView imageView, SubjectListAdapter subjectListAdapter, View view) {
        Integer status = downloadItem.getStatus();
        if (status != null && status.intValue() == 3) {
            imageView.setImageResource(R$drawable.play_progress_bg);
        } else {
            imageView.setImageResource(R$drawable.playing_progress_bg);
        }
        SubjectListAdapter.a optionClickListener = subjectListAdapter.getOptionClickListener();
        if (optionClickListener != null) {
            optionClickListener.a(downloadItem);
        }
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListAdapter$refresh$1(this.$download, this.$holder, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0023, code lost:
    
        r1 = r12.this$0.G1();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AudioBean audioBean;
        si.a G1;
        TextView textView;
        int longValue;
        ProgressBar progressBar;
        final ImageView imageView;
        Integer status;
        Long duration;
        Long readProcess;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        Integer num = null;
        if (i == 0) {
            ResultKt.b(obj);
            String url = this.$download.getUrl();
            if (url == null || G1 == null) {
                audioBean = null;
                textView = (TextView) this.$holder.getView(R$id.tv_process);
                longValue = (int) (((((audioBean != null || (readProcess = audioBean.getReadProcess()) == null) ? 0L : readProcess.longValue()) * 1.0f) / (((audioBean != null || (duration = audioBean.getDuration()) == null) ? 1L : duration.longValue()) > 0 ? r10 : 1L)) * 100);
                if (longValue >= 0 && longValue < 101) {
                    textView.setText(longValue + this.this$0.getContext().getString(R$string.listened));
                }
                progressBar = (ProgressBar) this.$holder.getView(R$id.pb_subject);
                imageView = (ImageView) this.$holder.getView(R$id.iv_subject);
                imageView.setVisibility(0);
                progressBar.setVisibility(8);
                imageView.setImageResource(R$drawable.play_progress_bg);
                status = this.$download.getStatus();
                if (status == null) {
                    num = status;
                } else if (audioBean != null) {
                    num = Boxing.d(audioBean.getStatus());
                }
                if (num != null && num.intValue() == 1) {
                    textView.setText("Not open");
                    progressBar.setVisibility(8);
                    imageView.setVisibility(0);
                } else if (num != null && num.intValue() == 6) {
                    textView.setText("Finished");
                    progressBar.setVisibility(8);
                    imageView.setVisibility(0);
                } else if (num != null && num.intValue() == 7) {
                    textView.setText("ERROR");
                    progressBar.setVisibility(8);
                    imageView.setVisibility(0);
                } else {
                    progressBar.setVisibility(0);
                    if (num != null && num.intValue() == 3) {
                        imageView.setImageResource(R$drawable.playing_progress_bg);
                    } else {
                        imageView.setImageResource(R$drawable.play_progress_bg);
                    }
                    progressBar.setProgress(longValue);
                }
                final DownloadItem downloadItem = this.$download;
                final SubjectListAdapter subjectListAdapter = this.this$0;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectListAdapter$refresh$1.d(downloadItem, imageView, subjectListAdapter, view);
                    }
                });
                return Unit.a;
            }
            this.label = 1;
            obj = G1.c(url, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        audioBean = (AudioBean) obj;
        textView = (TextView) this.$holder.getView(R$id.tv_process);
        if (audioBean != null) {
        }
        if (audioBean != null) {
        }
        longValue = (int) (((((audioBean != null || (readProcess = audioBean.getReadProcess()) == null) ? 0L : readProcess.longValue()) * 1.0f) / (((audioBean != null || (duration = audioBean.getDuration()) == null) ? 1L : duration.longValue()) > 0 ? r10 : 1L)) * 100);
        if (longValue >= 0) {
            textView.setText(longValue + this.this$0.getContext().getString(R$string.listened));
        }
        progressBar = (ProgressBar) this.$holder.getView(R$id.pb_subject);
        imageView = (ImageView) this.$holder.getView(R$id.iv_subject);
        imageView.setVisibility(0);
        progressBar.setVisibility(8);
        imageView.setImageResource(R$drawable.play_progress_bg);
        status = this.$download.getStatus();
        if (status == null) {
        }
        if (num != null) {
            textView.setText("Not open");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
            final DownloadItem downloadItem2 = this.$download;
            final SubjectListAdapter subjectListAdapter2 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListAdapter$refresh$1.d(downloadItem2, imageView, subjectListAdapter2, view);
                }
            });
            return Unit.a;
        }
        if (num != null) {
            textView.setText("Finished");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
            final DownloadItem downloadItem22 = this.$download;
            final SubjectListAdapter subjectListAdapter22 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListAdapter$refresh$1.d(downloadItem22, imageView, subjectListAdapter22, view);
                }
            });
            return Unit.a;
        }
        if (num != null) {
            textView.setText("ERROR");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
            final DownloadItem downloadItem222 = this.$download;
            final SubjectListAdapter subjectListAdapter222 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListAdapter$refresh$1.d(downloadItem222, imageView, subjectListAdapter222, view);
                }
            });
            return Unit.a;
        }
        progressBar.setVisibility(0);
        if (num != null) {
            imageView.setImageResource(R$drawable.playing_progress_bg);
            progressBar.setProgress(longValue);
            final DownloadItem downloadItem2222 = this.$download;
            final SubjectListAdapter subjectListAdapter2222 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListAdapter$refresh$1.d(downloadItem2222, imageView, subjectListAdapter2222, view);
                }
            });
            return Unit.a;
        }
        imageView.setImageResource(R$drawable.play_progress_bg);
        progressBar.setProgress(longValue);
        final DownloadItem downloadItem22222 = this.$download;
        final SubjectListAdapter subjectListAdapter22222 = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectListAdapter$refresh$1.d(downloadItem22222, imageView, subjectListAdapter22222, view);
            }
        });
        return Unit.a;
    }
}
