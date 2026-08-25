package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.postdetail.R$dimen;
import com.transsion.postdetail.R$drawable;
import ep.a$a;
import ep.b$a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u0005J!\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010 J\u0019\u0010\"\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u0005J\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\u0005R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00105\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108¨\u0006>"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostAudioDetailFragment;", "Lcom/transsion/postdetail/ui/fragment/PostDetailCommonFragment;", "Lcom/transsion/player/orplayer/e;", "Lep/b$a;", "<init>", "()V", BuildConfig.FLAVOR, "id", "Lcom/transsion/baselib/db/audio/AudioBean;", "audioBean", BuildConfig.FLAVOR, "q1", "(Ljava/lang/String;Lcom/transsion/baselib/db/audio/AudioBean;)V", "r1", BuildConfig.FLAVOR, "progress", "s1", "(J)V", "l1", "n1", "m1", "getPageName", "()Ljava/lang/String;", "G0", "initAudioListener", "F0", "onDestroy", "Lgn/e;", "mediaSource", "onProgress", "(JLgn/e;)V", "onVideoStart", "(Lgn/e;)V", "onVideoPause", "onCompletion", "onRemove", "p1", "k", "Lcom/transsion/baselib/db/audio/AudioBean;", "mAudioBean", "l", "J", "realDuration", "Lep/a;", "m", "Lkotlin/Lazy;", "getMAudioApi", "()Lep/a;", "mAudioApi", "Lep/b;", "n", "getMFloatApi", "()Lep/b;", "mFloatApi", BuildConfig.FLAVOR, "o", "Z", "dealWith80", "p", "dealWithElse", "q", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostAudioDetailFragment extends PostDetailCommonFragment implements com.transsion.player.orplayer.e, b$a {

    /* renamed from: q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    private AudioBean mAudioBean;

    /* renamed from: l, reason: from kotlin metadata */
    private long realDuration;

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.d1
        public final Object invoke() {
            ep.a mAudioApi_delegate$lambda$0;
            mAudioApi_delegate$lambda$0 = PostAudioDetailFragment.mAudioApi_delegate$lambda$0();
            return mAudioApi_delegate$lambda$0;
        }
    });

    /* renamed from: n, reason: from kotlin metadata */
    private final Lazy mFloatApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.e1
        public final Object invoke() {
            ep.b o1;
            o1 = PostAudioDetailFragment.o1();
            return o1;
        }
    });

    /* renamed from: o, reason: from kotlin metadata */
    private boolean dealWith80;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean dealWithElse;

    /* renamed from: com.transsion.postdetail.ui.fragment.PostAudioDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostAudioDetailFragment a(String str, boolean z, String str2, PostSubjectItem postSubjectItem) {
            PostAudioDetailFragment postAudioDetailFragment = new PostAudioDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putBoolean("from_comment", z);
            bundle.putString("rec_ops", str2);
            postAudioDetailFragment.setArguments(bundle);
            return postAudioDetailFragment;
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ Ref.LongRef a;
        final /* synthetic */ PostAudioDetailFragment b;

        b(Ref.LongRef longRef, PostAudioDetailFragment postAudioDetailFragment) {
            this.a = longRef;
            this.b = postAudioDetailFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.a.element = (long) (this.b.realDuration * 1000 * (i / 100));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ep.a mAudioApi = this.b.getMAudioApi();
            if (mAudioApi != null) {
                mAudioApi.seekTo(this.a.element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    private final ep.b getMFloatApi() {
        return (ep.b) this.mFloatApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(float f, PostAudioDetailFragment postAudioDetailFragment, AppBarLayout appBarLayout, int i) {
        if (i == 0 || Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            return;
        }
        if (Math.abs(i) <= f) {
            if (postAudioDetailFragment.dealWithElse) {
                return;
            }
            postAudioDetailFragment.dealWithElse = true;
            postAudioDetailFragment.dealWith80 = false;
            postAudioDetailFragment.r1();
            return;
        }
        if (postAudioDetailFragment.dealWith80) {
            return;
        }
        postAudioDetailFragment.dealWith80 = true;
        postAudioDetailFragment.dealWithElse = false;
        wn.m mVar = (wn.m) postAudioDetailFragment.getMViewBinding();
        if (mVar != null) {
            if (ij.y.a.a()) {
                mVar.u.setBackgroundResource(R.color.bg_01);
                mVar.o.setImageResource(R.mipmap.icon_white_back);
                mVar.A.setTextColor(androidx.core.content.b.getColor(postAudioDetailFragment.requireActivity(), R.color.cl38));
            } else {
                mVar.u.setBackgroundResource(R.color.bg_01);
                mVar.o.setImageResource(R.mipmap.libui_ic_back_black);
                mVar.A.setTextColor(androidx.core.content.b.getColor(postAudioDetailFragment.requireActivity(), R.color.text_01));
                mVar.u.setBackgroundResource(R.color.white);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(PostAudioDetailFragment postAudioDetailFragment, AppCompatImageView appCompatImageView, View view) {
        ep.a mAudioApi;
        ep.a mAudioApi2;
        ep.a mAudioApi3;
        AudioBean audioBean = postAudioDetailFragment.mAudioBean;
        if (audioBean == null) {
            ep.a mAudioApi4 = postAudioDetailFragment.getMAudioApi();
            if (mAudioApi4 != null && mAudioApi4.f()) {
                ep.a mAudioApi5 = postAudioDetailFragment.getMAudioApi();
                if (mAudioApi5 != null) {
                    mAudioApi5.pause();
                }
                appCompatImageView.setImageResource(R$drawable.post_icon_pro_play);
                com.transsion.postdetail.helper.a.s(com.transsion.postdetail.helper.a.a, postAudioDetailFragment.getMPostDetailBean(), postAudioDetailFragment.getPageName(), null, 4, null);
                return;
            }
            ep.a mAudioApi6 = postAudioDetailFragment.getMAudioApi();
            if (mAudioApi6 == null || !mAudioApi6.c()) {
                ep.a mAudioApi7 = postAudioDetailFragment.getMAudioApi();
                if (mAudioApi7 != null) {
                    mAudioApi7.prepare();
                }
            } else {
                AudioBean audioBean2 = postAudioDetailFragment.mAudioBean;
                if (audioBean2 != null && (mAudioApi = postAudioDetailFragment.getMAudioApi()) != null) {
                    a$a.a(mAudioApi, audioBean2, false, 2, null);
                }
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
            com.transsion.postdetail.helper.a.u(com.transsion.postdetail.helper.a.a, postAudioDetailFragment.getMPostDetailBean(), postAudioDetailFragment.getPageName(), null, 4, null);
            return;
        }
        ep.a mAudioApi8 = postAudioDetailFragment.getMAudioApi();
        boolean b2 = mAudioApi8 != null ? mAudioApi8.b(audioBean) : false;
        ep.b mFloatApi = postAudioDetailFragment.getMFloatApi();
        if (mFloatApi != null) {
            mFloatApi.a(new WeakReference(postAudioDetailFragment.getActivity()), audioBean);
        }
        if (!b2) {
            AudioBean audioBean3 = postAudioDetailFragment.mAudioBean;
            if (audioBean3 != null && (mAudioApi2 = postAudioDetailFragment.getMAudioApi()) != null) {
                a$a.a(mAudioApi2, audioBean3, false, 2, null);
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
            com.transsion.postdetail.helper.a.u(com.transsion.postdetail.helper.a.a, postAudioDetailFragment.getMPostDetailBean(), postAudioDetailFragment.getPageName(), null, 4, null);
            return;
        }
        ep.a mAudioApi9 = postAudioDetailFragment.getMAudioApi();
        if (mAudioApi9 != null && mAudioApi9.f()) {
            ep.a mAudioApi10 = postAudioDetailFragment.getMAudioApi();
            if (mAudioApi10 != null) {
                mAudioApi10.pause();
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_pro_play);
            com.transsion.postdetail.helper.a.s(com.transsion.postdetail.helper.a.a, postAudioDetailFragment.getMPostDetailBean(), postAudioDetailFragment.getPageName(), null, 4, null);
            return;
        }
        ep.a mAudioApi11 = postAudioDetailFragment.getMAudioApi();
        if (mAudioApi11 == null || !mAudioApi11.c()) {
            ep.a mAudioApi12 = postAudioDetailFragment.getMAudioApi();
            if (mAudioApi12 != null) {
                mAudioApi12.prepare();
            }
        } else {
            AudioBean audioBean4 = postAudioDetailFragment.mAudioBean;
            if (audioBean4 != null && (mAudioApi3 = postAudioDetailFragment.getMAudioApi()) != null) {
                a$a.a(mAudioApi3, audioBean4, false, 2, null);
            }
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
        com.transsion.postdetail.helper.a.u(com.transsion.postdetail.helper.a.a, postAudioDetailFragment.getMPostDetailBean(), postAudioDetailFragment.getPageName(), null, 4, null);
    }

    private final void l1() {
        Media media;
        List audio;
        Group group;
        Subject subject;
        Subject subject2;
        PostSubjectItem mPostDetailBean = getMPostDetailBean();
        if (mPostDetailBean == null || (media = mPostDetailBean.getMedia()) == null || (audio = media.getAudio()) == null || audio.size() <= 0) {
            return;
        }
        Audio audio2 = (Audio) audio.get(0);
        Long duration = audio2.getDuration();
        this.realDuration = duration != null ? duration.longValue() : 0L;
        String url = audio2.getUrl();
        if (url == null) {
            url = BuildConfig.FLAVOR;
        }
        String str = url;
        PostSubjectItem mPostDetailBean2 = getMPostDetailBean();
        String coverUrl$default = mPostDetailBean2 != null ? PostSubjectItem.getCoverUrl$default(mPostDetailBean2, false, 1, (Object) null) : null;
        Long duration2 = audio2.getDuration();
        Long valueOf = audio2.getSize() != null ? Long.valueOf(r3.intValue()) : null;
        String url2 = audio2.getUrl();
        PostSubjectItem mPostDetailBean3 = getMPostDetailBean();
        String title = mPostDetailBean3 != null ? mPostDetailBean3.getTitle() : null;
        PostSubjectItem mPostDetailBean4 = getMPostDetailBean();
        String content = mPostDetailBean4 != null ? mPostDetailBean4.getContent() : null;
        Integer bitrate = audio2.getBitrate();
        PostSubjectItem mPostDetailBean5 = getMPostDetailBean();
        String rec_ops = mPostDetailBean5 != null ? mPostDetailBean5.getRec_ops() : null;
        PostSubjectItem mPostDetailBean6 = getMPostDetailBean();
        String postId = mPostDetailBean6 != null ? mPostDetailBean6.getPostId() : null;
        PostSubjectItem mPostDetailBean7 = getMPostDetailBean();
        String subjectId = (mPostDetailBean7 == null || (subject2 = mPostDetailBean7.getSubject()) == null) ? null : subject2.getSubjectId();
        PostSubjectItem mPostDetailBean8 = getMPostDetailBean();
        String title2 = (mPostDetailBean8 == null || (subject = mPostDetailBean8.getSubject()) == null) ? null : subject.getTitle();
        PostSubjectItem mPostDetailBean9 = getMPostDetailBean();
        AudioBean audioBean = new AudioBean(str, coverUrl$default, duration2, valueOf, url2, title, content, bitrate, (Long) null, (Long) null, (String) null, rec_ops, (String) null, postId, subjectId, (mPostDetailBean9 == null || (group = mPostDetailBean9.getGroup()) == null) ? null : group.getGroupId(), 0, title2, 0, 0, 857856, (DefaultConstructorMarker) null);
        this.mAudioBean = audioBean;
        ep.b mFloatApi = getMFloatApi();
        if (mFloatApi != null) {
            mFloatApi.a(new WeakReference(getActivity()), audioBean);
        }
        ep.b mFloatApi2 = getMFloatApi();
        if (mFloatApi2 != null) {
            mFloatApi2.h();
        }
        ep.b mFloatApi3 = getMFloatApi();
        if (mFloatApi3 != null) {
            mFloatApi3.d(this);
        }
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            a$a.a(mAudioApi, audioBean, false, 2, null);
        }
        com.transsion.postdetail.helper.a.b(com.transsion.postdetail.helper.a.a, getMPostDetailBean(), getPageName(), null, 4, null);
    }

    private final void m1() {
        AppCompatSeekBar appCompatSeekBar;
        Ref.LongRef longRef = new Ref.LongRef();
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (appCompatSeekBar = mVar.e) == null) {
            return;
        }
        appCompatSeekBar.setOnSeekBarChangeListener(new b(longRef, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    private final void n1() {
        String str;
        Integer num;
        String str2;
        ImageView imageView;
        Media media;
        Subject subject;
        Cover cover;
        Subject subject2;
        Cover cover2;
        Subject subject3;
        Cover cover3;
        Subject subject4;
        Cover cover4;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        PostSubjectItem mPostDetailBean = getMPostDetailBean();
        Integer num2 = null;
        if (TextUtils.isEmpty(mPostDetailBean != null ? PostSubjectItem.getCoverUrl$default(mPostDetailBean, false, 1, (Object) null) : null)) {
            wn.m mVar = (wn.m) getMViewBinding();
            if (mVar != null && (appCompatImageView2 = mVar.p) != null) {
                appCompatImageView2.setImageResource(com.transsion.baseui.R.mipmap.default_audio_ic_9_16);
            }
            wn.m mVar2 = (wn.m) getMViewBinding();
            if (mVar2 == null || (appCompatImageView = mVar2.m) == null) {
                return;
            }
            uf.c.g(appCompatImageView);
            return;
        }
        PostSubjectItem mPostDetailBean2 = getMPostDetailBean();
        String str3 = BuildConfig.FLAVOR;
        if (mPostDetailBean2 == null || (media = mPostDetailBean2.getMedia()) == null) {
            str = BuildConfig.FLAVOR;
            num = 0;
            num2 = null;
            str2 = str;
        } else {
            Cover cover5 = media.getCover();
            str2 = cover5 != null ? cover5.getUrl() : null;
            Cover cover6 = media.getCover();
            str = cover6 != null ? cover6.getThumbnail() : null;
            Cover cover7 = media.getCover();
            Integer width = cover7 != null ? cover7.getWidth() : null;
            Cover cover8 = media.getCover();
            Integer height = cover8 != null ? cover8.getHeight() : null;
            if (TextUtils.isEmpty(str2)) {
                PostSubjectItem mPostDetailBean3 = getMPostDetailBean();
                str2 = (mPostDetailBean3 == null || (subject4 = mPostDetailBean3.getSubject()) == null || (cover4 = subject4.getCover()) == null) ? null : cover4.getUrl();
                PostSubjectItem mPostDetailBean4 = getMPostDetailBean();
                str = (mPostDetailBean4 == null || (subject3 = mPostDetailBean4.getSubject()) == null || (cover3 = subject3.getCover()) == null) ? null : cover3.getThumbnail();
                PostSubjectItem mPostDetailBean5 = getMPostDetailBean();
                num = (mPostDetailBean5 == null || (subject2 = mPostDetailBean5.getSubject()) == null || (cover2 = subject2.getCover()) == null) ? null : cover2.getWidth();
                PostSubjectItem mPostDetailBean6 = getMPostDetailBean();
                if (mPostDetailBean6 != null && (subject = mPostDetailBean6.getSubject()) != null && (cover = subject.getCover()) != null) {
                    num2 = cover.getHeight();
                }
            } else {
                num2 = height;
                num = width;
            }
        }
        wn.m mVar3 = (wn.m) getMViewBinding();
        if (mVar3 == null || (imageView = mVar3.p) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        f.b c = m.g(str2).i(R.color.cl37).m(num != null ? num.intValue() : aVar.c()).c(num2 != null ? num2.intValue() : aVar.c());
        if (str != null) {
            str3 = str;
        }
        c.l(str3).d(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.b o1() {
        return (ep.b) TheRouter.d(ep.b.class, new Object[0]);
    }

    private final void q1(String id, AudioBean audioBean) {
        Intent intent = new Intent();
        intent.putExtra("audio", (Serializable) audioBean);
        intent.putExtra("id", id);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
    }

    private final void r1() {
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null) {
            mVar.o.setImageResource(R.mipmap.icon_white_back);
            mVar.A.setTextColor(androidx.core.content.b.getColor(requireActivity(), R.color.cl38));
            mVar.u.setBackgroundResource(R.drawable.libui_mask_cl45_0p_to_30p);
        }
    }

    private final void s1(long progress) {
        AppCompatImageView appCompatImageView;
        TextView textView;
        AppCompatSeekBar appCompatSeekBar;
        AppCompatSeekBar appCompatSeekBar2;
        long j = this.realDuration * 1000;
        int i = (int) ((progress / j) * 100);
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (appCompatSeekBar2 = mVar.e) != null) {
            appCompatSeekBar2.setProgress(i);
        }
        wn.m mVar2 = (wn.m) getMViewBinding();
        if (mVar2 != null && (appCompatSeekBar = mVar2.e) != null) {
            appCompatSeekBar.setProgress(i);
        }
        String str = com.transsion.postdetail.util.m.d(progress) + "/" + com.transsion.postdetail.util.m.d(j);
        wn.m mVar3 = (wn.m) getMViewBinding();
        if (mVar3 != null && (textView = mVar3.b) != null) {
            textView.setText(str);
        }
        wn.m mVar4 = (wn.m) getMViewBinding();
        if (mVar4 == null || (appCompatImageView = mVar4.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void F0() {
        View view;
        Media media;
        List audio;
        AppCompatImageView appCompatImageView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (appCompatImageView = mVar.p) != null) {
            uf.c.k(appCompatImageView);
        }
        PostSubjectItem mPostDetailBean = getMPostDetailBean();
        if (mPostDetailBean != null && (media = mPostDetailBean.getMedia()) != null && (audio = media.getAudio()) != null && (!audio.isEmpty())) {
            l1();
            n1();
        }
        wn.m mVar2 = (wn.m) getMViewBinding();
        if (mVar2 == null || (view = mVar2.C) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void G0() {
        AppBarLayout appBarLayout;
        androidx.constraintlayout.widget.Group group;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (group = mVar.l) != null) {
            group.setVisibility(0);
        }
        r1();
        final float dimension = getResources().getDimension(R$dimen.post_surface_height);
        wn.m mVar2 = (wn.m) getMViewBinding();
        if (mVar2 == null || (appBarLayout = mVar2.f) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.postdetail.ui.fragment.b1
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                PostAudioDetailFragment.j1(dimension, this, appBarLayout2, i);
            }
        });
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public String getPageName() {
        return "postdetail_audio";
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void initAudioListener() {
        final AppCompatImageView appCompatImageView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (appCompatImageView = mVar.d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.c1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostAudioDetailFragment.k1(PostAudioDetailFragment.this, appCompatImageView, view);
                }
            });
        }
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.addPlayerListener(this);
        }
        m1();
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        boolean z;
        wn.m mVar;
        AppCompatImageView appCompatImageView;
        e.a.e(this, mediaSource);
        AudioBean audioBean = this.mAudioBean;
        if (audioBean != null) {
            ep.a mAudioApi = getMAudioApi();
            z = Intrinsics.c(mAudioApi != null ? Boolean.valueOf(mAudioApi.b(audioBean)) : null, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z || (mVar = (wn.m) getMViewBinding()) == null || (appCompatImageView = mVar.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_play);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void onDestroy() {
        super.onDestroy();
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.removePlayerListener(this);
        }
        ep.b mFloatApi = getMFloatApi();
        if (mFloatApi != null) {
            mFloatApi.j(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        e.a.q(this, playError, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        boolean z;
        AppCompatImageView appCompatImageView;
        e.a.y(this, progress, mediaSource);
        AudioBean audioBean = this.mAudioBean;
        if (audioBean != null) {
            ep.a mAudioApi = getMAudioApi();
            z = Intrinsics.c(mAudioApi != null ? Boolean.valueOf(mAudioApi.b(audioBean)) : null, Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            s1(progress);
            return;
        }
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (appCompatImageView = mVar.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_play);
    }

    @Override // ep.b$a
    public void onRemove() {
        AppCompatImageView appCompatImageView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (appCompatImageView = mVar.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_play);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e mediaSource) {
        boolean z;
        wn.m mVar;
        AppCompatImageView appCompatImageView;
        e.a.F(this, mediaSource);
        AudioBean audioBean = this.mAudioBean;
        if (audioBean != null) {
            ep.a mAudioApi = getMAudioApi();
            z = Intrinsics.c(mAudioApi != null ? Boolean.valueOf(mAudioApi.b(audioBean)) : null, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z || (mVar = (wn.m) getMViewBinding()) == null || (appCompatImageView = mVar.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_play);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        boolean z;
        wn.m mVar;
        AppCompatImageView appCompatImageView;
        e.a.I(this, mediaSource);
        AudioBean audioBean = this.mAudioBean;
        if (audioBean != null) {
            ep.a mAudioApi = getMAudioApi();
            z = Intrinsics.c(mAudioApi != null ? Boolean.valueOf(mAudioApi.b(audioBean)) : null, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z || (mVar = (wn.m) getMViewBinding()) == null || (appCompatImageView = mVar.d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
    }

    public final void p1() {
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi == null || !mAudioApi.f()) {
            return;
        }
        q1(null, this.mAudioBean);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }
}
