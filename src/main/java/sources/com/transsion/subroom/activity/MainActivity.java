package com.transsion.subroom.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import com.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.msr.UserStatsV2;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.util.c;
import com.transsion.home.R$id;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.Badge;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.Icon;
import com.transsion.home.bean.Text;
import com.transsion.home.enum.BottomTabType;
import com.transsion.home.fragment.bottom.BottomRoomFragment;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.player.config.RenderType;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.startup.StartupManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.R$layout;
import com.transsion.subroom.R$string;
import com.transsion.usercenter.profile.f;
import com.transsion.usercenter.profile.report.ReportDialog;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.UserInfo;
import dt.a;
import hn.d;
import ij.g;
import ij.k;
import ij.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import msr.C0008;
import ni.f;
import wf.a;
import yg.l;
import zw.e;

@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ÷\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002¡\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0014¢\u0006\u0004\b \u0010\u0006J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'J)\u0010+\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b+\u0010,J/\u00102\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0007H\u0014¢\u0006\u0004\b5\u0010\u000bJ\u0019\u00108\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0010J\r\u0010;\u001a\u00020\t¢\u0006\u0004\b;\u0010\u0006J\u000f\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b<\u0010\u0006J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010\u0010J'\u0010B\u001a\u00020\t2\u0006\u0010>\u001a\u00020.2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?H\u0016¢\u0006\u0004\bB\u0010CJ4\u0010I\u001a\u00020\t2#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010DH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0013H\u0016¢\u0006\u0004\bK\u0010\u0015J\u000f\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010N\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010\u0006J\u000f\u0010O\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010\u0006J\u000f\u0010P\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010\u0006J\u0019\u0010S\u001a\u00020\t2\b\u0010R\u001a\u0004\u0018\u00010QH\u0002¢\u0006\u0004\bS\u0010TJ\u001f\u0010X\u001a\u00020\t2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010UH\u0002¢\u0006\u0004\bX\u0010YJ\u001f\u0010\\\u001a\u00020\t2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010ZH\u0002¢\u0006\u0004\b\\\u0010YJ\u001f\u0010]\u001a\u00020\u000e2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010ZH\u0002¢\u0006\u0004\b]\u0010^J-\u0010e\u001a\u00020d2\u0006\u0010_\u001a\u00020V2\n\u0010b\u001a\u00060`R\u00020a2\b\u0010c\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0004\be\u0010fJ-\u0010i\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010V2\b\u0010h\u001a\u0004\u0018\u00010d2\b\u0010c\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0004\bi\u0010jJ\u001f\u0010l\u001a\u00020\t2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010UH\u0002¢\u0006\u0004\bl\u0010YJ\u001f\u0010p\u001a\u00020\t2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020.H\u0002¢\u0006\u0004\bp\u0010qJ\u0019\u0010s\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010rH\u0002¢\u0006\u0004\bs\u0010tJ\u0019\u0010u\u001a\u00020\t2\b\u0010c\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0004\bu\u0010vJ\u0017\u0010x\u001a\u00020\u00132\u0006\u0010w\u001a\u00020.H\u0002¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00132\u0006\u0010z\u001a\u00020.H\u0002¢\u0006\u0004\b{\u0010yJ\u000f\u0010|\u001a\u00020\tH\u0002¢\u0006\u0004\b|\u0010\u0006J\u000f\u0010}\u001a\u00020\tH\u0002¢\u0006\u0004\b}\u0010\u0006J\"\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u00132\u0006\u0010\u007f\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0082\u0001\u0010\u0006J\u0011\u0010\u0083\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u0006J=\u0010\u0089\u0001\u001a\u00020\t2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010d2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010\u007f\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0006J\u0011\u0010\u008c\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0006J\u001b\u0010\u008e\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0006J%\u0010\u0092\u0001\u001a\u00020\u00132\b\u0010z\u001a\u0004\u0018\u00010.2\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0094\u0001\u0010\u0006J\u001d\u0010\u0096\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0095\u0001\u001a\u00020?H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J%\u0010\u0099\u0001\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010V2\u0007\u0010\u0098\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u0006J\u0011\u0010\u009c\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u009c\u0001\u0010\u0006J\u0011\u0010\u009d\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u009d\u0001\u0010\u0006J\u0016\u0010\u009e\u0001\u001a\u00020\t*\u00020dH\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020m0Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010¬\u0001\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010«\u0001R\u0019\u0010¯\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0019\u0010±\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010®\u0001R\u0018\u0010³\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010²\u0001R\u0019\u0010µ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u0019\u0010·\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010²\u0001R#\u0010½\u0001\u001a\u0005\u0018\u00010¸\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010À\u0001\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010Â\u0001\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¿\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010®\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010®\u0001R\u001a\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ò\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010²\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010²\u0001R\u001b\u0010Ö\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010¿\u0001R!\u0010Û\u0001\u001a\u00030×\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bØ\u0001\u0010º\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010²\u0001R\u0019\u0010ß\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010²\u0001R\u0019\u0010á\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010²\u0001R!\u0010æ\u0001\u001a\u00030â\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bã\u0001\u0010º\u0001\u001a\u0006\bä\u0001\u0010å\u0001R\u001e\u0010ê\u0001\u001a\t\u0012\u0004\u0012\u00020\t0ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001a\u0010ì\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010É\u0001R\u001a\u0010ð\u0001\u001a\u00030í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001c\u0010ô\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0019\u0010ö\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010²\u0001¨\u0006ø\u0001"}, d2 = {"Lcom/transsion/subroom/activity/MainActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Ldt/a;", "Lcom/transsion/home/preload/a;", "Ldl/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "O0", "()Ldt/a;", "", "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", "", "statusColor", "()I", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onBackPressed", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "Lcom/transsion/home/preload/b;", "d", "()Lcom/transsion/home/preload/b;", "isWhiteFont", "isHomeFragment", "changeStatusFontColor", "(ZZ)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "outState", "onSaveInstanceState", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "g", "P0", "loadTwoLevelAd", "hasAd", "action", "", "distance", "progress", "onAction", "(Ljava/lang/String;FF)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "callback", "setStateCallback", "(Lkotlin/jvm/functions/Function1;)V", "getTipViewBottomMargin", "C0", "H0", "p1", "a1", "s1", "Lcom/transsion/home/bean/AppTab;", "homeTab", "y1", "(Lcom/transsion/home/bean/AppTab;)V", "", "Lcom/transsion/home/bean/BottomTabItem;", "bottomTabs", "B0", "(Ljava/util/List;)V", "", "notEmptyBottomTabs", "Q0", "D0", "(Ljava/util/List;)Z", "tab", "Lcom/google/android/material/tabs/TabLayout$TabView;", "Lcom/google/android/material/tabs/TabLayout;", "view", "selectedTabItem", "Landroid/view/View;", "I1", "(Lcom/transsion/home/bean/BottomTabItem;Lcom/google/android/material/tabs/TabLayout$TabView;Lcom/transsion/home/bean/BottomTabItem;)Landroid/view/View;", "tabItem", "tabView", "D1", "(Lcom/transsion/home/bean/BottomTabItem;Landroid/view/View;Lcom/transsion/home/bean/BottomTabItem;)V", "tabs", "X0", "Landroidx/fragment/app/Fragment;", "fragment", "tag", "F1", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lcom/google/android/material/tabs/TabLayout$Tab;", "r1", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "t1", "(Lcom/transsion/home/bean/BottomTabItem;)V", "tabType", "N0", "(Ljava/lang/String;)I", "tabCode", "M0", "initPlayer", "R0", "status", "size", "E1", "(II)V", "z1", "B1", "vTips", "Landroidx/appcompat/widget/AppCompatTextView;", "tvStatus", "Landroidx/appcompat/widget/AppCompatImageView;", "ivDownloadFail", "G1", "(Landroid/view/View;Landroidx/appcompat/widget/AppCompatTextView;Landroidx/appcompat/widget/AppCompatImageView;I)V", "G0", "H1", "routerPosition", "x1", "(I)V", "w1", "tabId", "L0", "(Ljava/lang/String;I)I", "d1", "bottomMargin", "E0", "(F)V", "isUserAction", "v1", "(Lcom/transsion/home/bean/BottomTabItem;Z)V", "u1", "S0", "Y0", "A0", "(Landroid/view/View;)V", "Lzw/e;", "a", "Lzw/e;", "onDownloadIconStatusListener", "Lcom/transsion/home/fragment/home/HomeFragment;", "b", "Lcom/transsion/home/fragment/home/HomeFragment;", "homeFragment", "c", "Ljava/util/List;", "mFragments", "Landroidx/fragment/app/Fragment;", "currentFragment", "e", "I", "defaultIndex", "f", "currentFragmentIndex", "Z", "mVideoTabIsWhite", "h", "kidsDialogShown", "i", "widgetDialogShowing", "Lqx/a;", "j", "Lkotlin/Lazy;", "I0", "()Lqx/a;", "mLoginApi", "k", "Ljava/lang/String;", "mTopTabCode", "l", "mBottomTabCode", "m", "mInitTabId", "n", "mSecondTabIndex", "", "o", "J", "mBackTime", "p", "Lcom/transsion/home/preload/b;", "xmlPreload", "q", "Lcom/transsion/home/bean/AppTab;", "mCurrentHomeTab", "r", "runOnce", "s", "isShowHotTips", "t", "showHotTabCode", "Lgt/b;", "u", "J0", "()Lgt/b;", "mbUpdateManager", "v", "mHomeStatusWhite", "w", "isBottomTabLargeType", "x", "isUserBottomTabClickAction", "Lcom/transsion/usercenter/profile/f;", "y", "K0", "()Lcom/transsion/usercenter/profile/f;", "noticeViewModel", "Lkotlin/Function0;", "z", "Lkotlin/jvm/functions/Function0;", "onConfigLoadedCallback", "A", "lastClickTime", "Lcom/transsion/subroom/activity/MainDialogAdManager;", "B", "Lcom/transsion/subroom/activity/MainDialogAdManager;", "mainDialogAdManager", "Lcom/transsion/subroom/activity/SecondFloorHelper;", "C", "Lcom/transsion/subroom/activity/SecondFloorHelper;", "secondFloorHelper", "D", "shouldShowGuide", "E", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class MainActivity extends BaseActivity<a> implements com.transsion.home.preload.a, dl.b {
    public static final a E = new a((DefaultConstructorMarker) null);

    /* renamed from: A, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: C, reason: from kotlin metadata */
    private SecondFloorHelper secondFloorHelper;

    /* renamed from: a, reason: from kotlin metadata */
    private e onDownloadIconStatusListener;

    /* renamed from: b, reason: from kotlin metadata */
    private HomeFragment homeFragment;

    /* renamed from: d, reason: from kotlin metadata */
    private Fragment currentFragment;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean mVideoTabIsWhite;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean kidsDialogShown;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean widgetDialogShowing;

    /* renamed from: o, reason: from kotlin metadata */
    private long mBackTime;

    /* renamed from: p, reason: from kotlin metadata */
    private com.transsion.home.preload.b xmlPreload;

    /* renamed from: q, reason: from kotlin metadata */
    private AppTab mCurrentHomeTab;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean runOnce;

    /* renamed from: w, reason: from kotlin metadata */
    private boolean isBottomTabLargeType;

    /* renamed from: c, reason: from kotlin metadata */
    private List mFragments = new ArrayList();

    /* renamed from: e, reason: from kotlin metadata */
    private int defaultIndex;

    /* renamed from: f, reason: from kotlin metadata */
    private int currentFragmentIndex = this.defaultIndex;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.m
        public final Object invoke() {
            qx.a g1;
            g1 = MainActivity.g1();
            return g1;
        }
    });

    /* renamed from: k, reason: from kotlin metadata */
    public String mTopTabCode = "UgcTrending";

    /* renamed from: l, reason: from kotlin metadata */
    public String mBottomTabCode = "HOME";

    /* renamed from: m, reason: from kotlin metadata */
    public int mInitTabId = -1;

    /* renamed from: n, reason: from kotlin metadata */
    public int mSecondTabIndex = -1;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean isShowHotTips = true;

    /* renamed from: t, reason: from kotlin metadata */
    private String showHotTabCode = "";

    /* renamed from: u, reason: from kotlin metadata */
    private final Lazy mbUpdateManager = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.o
        public final Object invoke() {
            gt.b h1;
            h1 = MainActivity.h1();
            return h1;
        }
    });

    /* renamed from: v, reason: from kotlin metadata */
    private boolean mHomeStatusWhite = true;

    /* renamed from: x, reason: from kotlin metadata */
    private boolean isUserBottomTabClickAction = true;

    /* renamed from: y, reason: from kotlin metadata */
    private final Lazy noticeViewModel = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.p
        public final Object invoke() {
            f i1;
            i1 = MainActivity.i1(MainActivity.this);
            return i1;
        }
    });

    /* renamed from: z, reason: from kotlin metadata */
    private final Function0 onConfigLoadedCallback = new Function0() { // from class: com.transsion.subroom.activity.q
        public final Object invoke() {
            Unit j1;
            j1 = MainActivity.j1(MainActivity.this);
            return j1;
        }
    };

    /* renamed from: B, reason: from kotlin metadata */
    private MainDialogAdManager mainDialogAdManager = new MainDialogAdManager();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean shouldShowGuide = true;

    private final void A0(View view) {
        Integer num;
        if (view.getId() == R$id.image_red_tips && !com.transsion.baselib.report.launch.b.a.b().getBoolean("k_is_family_mode_badge", true) && (num = (Integer) K0().h().f()) != null && num.intValue() == 0) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(MainActivity mainActivity, int i, View view) {
        if (mainActivity.currentFragmentIndex != i) {
            return;
        }
        if (System.currentTimeMillis() - mainActivity.lastClickTime >= 500) {
            mainActivity.lastClickTime = System.currentTimeMillis();
            return;
        }
        HomeFragment homeFragment = mainActivity.homeFragment;
        if (homeFragment != null) {
            homeFragment.b1();
        }
        mainActivity.lastClickTime = 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B0(List bottomTabs) {
        List U0 = bottomTabs != null ? CollectionsKt.U0(bottomTabs) : null;
        List list = bottomTabs;
        if (list == null || list.isEmpty()) {
            wf.a.a.c("MainActivity", "bottom tabs 异常兜底", true);
            y1(PreloadTrendingData.n.a().A(this));
            AppTab appTab = this.mCurrentHomeTab;
            U0 = appTab != null ? appTab.getBottomTabs() : null;
        }
        u1();
        X0(U0);
        Q0(U0);
        R0();
        z1();
        B1();
        d1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B1() {
        TabLayout.TabView tabView;
        int M0 = M0("COMMUNITY");
        TabLayout.Tab tabAt = getMViewBinding().m.getTabAt(M0);
        if (tabAt == null || (tabView = tabAt.view) == null) {
            return;
        }
        tabView.setOnClickListener(new l(this, M0));
    }

    private final void C0() {
        ConfigBean c = cm.f.c.a().c("sa_key_kid_mode_feature_enable", true);
        StartupManager.a aVar = StartupManager.g;
        if (aVar.a().d0() || c != null) {
            H0();
        } else {
            a.a.f(wf.a.a, "MainActivity", "config not loaded yet, wait for config callback.", false, 4, (Object) null);
            aVar.a().z(this.onConfigLoadedCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(MainActivity mainActivity, int i, View view) {
        if (mainActivity.currentFragmentIndex == i && !c.a.a(view.getId(), 1000L)) {
            try {
                Result.Companion companion = Result.Companion;
                Object obj = mainActivity.mFragments.get(i);
                Unit unit = null;
                BottomRoomFragment bottomRoomFragment = obj instanceof BottomRoomFragment ? (BottomRoomFragment) obj : null;
                if (bottomRoomFragment != null) {
                    bottomRoomFragment.b0();
                    unit = Unit.a;
                }
                Result.m34constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean D0(List bottomTabs) {
        int size = bottomTabs != null ? bottomTabs.size() : 0;
        BottomTabItem bottomTabItem = null;
        if (bottomTabs != null) {
            int size2 = bottomTabs.size() / 2;
            int i = 0;
            BottomTabItem bottomTabItem2 = null;
            for (Object obj : bottomTabs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                BottomTabItem bottomTabItem3 = (BottomTabItem) obj;
                if (bottomTabItem3.isLargeUiType()) {
                    if (i != size2) {
                        Icon icon = bottomTabItem3.getIcon();
                        if (icon != null) {
                            icon.setDefaultBigIcon((String) null);
                        }
                        Icon icon2 = bottomTabItem3.getIcon();
                        if (icon2 != null) {
                            icon2.setSelectBigIcon((String) null);
                        }
                    } else {
                        bottomTabItem2 = bottomTabItem3;
                    }
                }
                i = i2;
            }
            bottomTabItem = bottomTabItem2;
        }
        this.isBottomTabLargeType = bottomTabItem != null && size % 2 == 1;
        Group group = getMViewBinding().e;
        Intrinsics.g(group, "largeBottomBg");
        group.setVisibility(this.isBottomTabLargeType ? 0 : 8);
        ImageView imageView = getMViewBinding().l;
        Intrinsics.g(imageView, "tabBg");
        imageView.setVisibility(this.isBottomTabLargeType ? 8 : 0);
        return bottomTabItem != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D1(BottomTabItem tabItem, View tabView, BottomTabItem selectedTabItem) {
        int a;
        Typeface d;
        int color;
        Text text;
        Text text2;
        String defaultIcon;
        String str;
        Text text3;
        Text text4;
        String selectIcon;
        List bottomTabs;
        if (tabView != null) {
            AppTab appTab = this.mCurrentHomeTab;
            int size = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? 5 : bottomTabs.size();
            if (size >= 4) {
                tabView.setMinimumWidth(y.e() / size);
            }
            TnTextView tnTextView = (TnTextView) tabView.findViewById(R$id.tv_tab);
            if (tnTextView != null) {
                tnTextView.setText(tabItem != null ? tabItem.getName() : null);
            }
            String str2 = "";
            if (Intrinsics.c(selectedTabItem, tabItem)) {
                if (tabItem != null && (selectIcon = tabItem.getSelectIcon()) != null) {
                    str2 = selectIcon;
                }
                a = a.a.b(tabItem);
                Context context = tabView.getContext();
                Intrinsics.g(context, "getContext(...)");
                d = uf.a.c(context);
                String selectColor = (tabItem == null || (text4 = tabItem.getText()) == null) ? null : text4.getSelectColor();
                if (selectColor == null || selectColor.length() == 0) {
                    color = androidx.core.content.b.getColor(this, R$color.text_01);
                } else {
                    color = Color.parseColor((tabItem == null || (text3 = tabItem.getText()) == null) ? null : text3.getSelectColor());
                }
            } else {
                if (tabItem != null && (defaultIcon = tabItem.getDefaultIcon()) != null) {
                    str2 = defaultIcon;
                }
                a = a.a.a(tabItem);
                Context context2 = tabView.getContext();
                Intrinsics.g(context2, "getContext(...)");
                d = uf.a.d(context2);
                String defaultColor = (tabItem == null || (text2 = tabItem.getText()) == null) ? null : text2.getDefaultColor();
                if (defaultColor == null || defaultColor.length() == 0) {
                    color = androidx.core.content.b.getColor(this, R$color.text_02);
                } else {
                    color = Color.parseColor((tabItem == null || (text = tabItem.getText()) == null) ? null : text.getDefaultColor());
                }
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) tabView.findViewById(R$id.tv_tab);
            if (appCompatTextView != null) {
                appCompatTextView.setTextColor(color);
                appCompatTextView.setTypeface(d);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) tabView.findViewById(R$id.image_tab_icon);
            if (appCompatImageView != null) {
                float f = (tabItem == null || !tabItem.isLargeUiType()) ? 24.0f : 72.0f;
                a.a.f(wf.a.a, "MainActivity", "setTabUI() -->name:" + (tabItem != null ? tabItem.getName() : null) + " drawableUrl = " + str2 + ", width = " + f, false, 4, (Object) null);
                f.a aVar = ni.f.a;
                Context context3 = appCompatImageView.getContext();
                Intrinsics.g(context3, "getContext(...)");
                aVar.m(context3).g(str2).i(a).m(a0.a(f)).d(appCompatImageView);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) tabView.findViewById(R$id.iv_download_fail);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R$mipmap.ic_download_status_fail_dark);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) tabView.findViewById(R$id.tv_download_status);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setBackgroundResource(R$drawable.shape_download_icon_status_dark);
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) tabView.findViewById(R$id.tv_red_tips);
            if ((tabItem != null ? tabItem.getBadge() : null) == null || !this.isShowHotTips || com.transsion.baselib.report.launch.b.a.b().getBoolean("tab_hot_tips_is_show", false)) {
                if (appCompatTextView3 != null) {
                    uf.c.g(appCompatTextView3);
                    return;
                }
                return;
            }
            if (appCompatTextView3 != null) {
                uf.c.k(appCompatTextView3);
            }
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(Utils.a().getString(R$string.bottom_tab_tips_hot));
            }
            try {
                Result.Companion companion = Result.Companion;
                if (appCompatTextView3 != null) {
                    Badge badge = tabItem.getBadge();
                    if (badge == null || (str = badge.getText()) == null) {
                        str = "Hot";
                    }
                    appCompatTextView3.setText(str);
                }
                if (appCompatTextView3 != null) {
                    Badge badge2 = tabItem.getBadge();
                    appCompatTextView3.setBackgroundColor(Color.parseColor(badge2 != null ? badge2.getBgHue() : null));
                    r1 = Unit.a;
                }
                Result.m34constructorimpl(r1);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
            this.showHotTabCode = tabItem.getBtTabCode();
        }
    }

    private final void E0(float bottomMargin) {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.w(bottomMargin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E1(int status, int size) {
        TabLayout.TabView tabView;
        TabLayout.TabView tabView2;
        TabLayout.TabView tabView3;
        TabLayout.Tab tabAt = getMViewBinding().m.getTabAt(N0(BottomTabType.DOWNLOAD.getValue()));
        AppCompatImageView appCompatImageView = null;
        View findViewById = (tabAt == null || (tabView3 = tabAt.view) == null) ? null : tabView3.findViewById(R$id.image_red_tips);
        AppCompatTextView appCompatTextView = (tabAt == null || (tabView2 = tabAt.view) == null) ? null : (AppCompatTextView) tabView2.findViewById(R$id.tv_download_status);
        if (tabAt != null && (tabView = tabAt.view) != null) {
            appCompatImageView = (AppCompatImageView) tabView.findViewById(R$id.iv_download_fail);
        }
        if (status == 0) {
            if (findViewById != null) {
                A0(findViewById);
            }
            if (appCompatTextView != null) {
                uf.c.g(appCompatTextView);
            }
            if (appCompatImageView != null) {
                uf.c.g(appCompatImageView);
                return;
            }
            return;
        }
        if (status == 1) {
            if (findViewById != null) {
                A0(findViewById);
            }
            if (appCompatTextView != null) {
                uf.c.g(appCompatTextView);
            }
            if (appCompatImageView != null) {
                uf.c.g(appCompatImageView);
                return;
            }
            return;
        }
        if (status == 2) {
            if (appCompatImageView != null) {
                uf.c.k(appCompatImageView);
            }
            if (findViewById != null) {
                A0(findViewById);
            }
            if (appCompatTextView != null) {
                uf.c.g(appCompatTextView);
                return;
            }
            return;
        }
        if (status == 4) {
            G1(findViewById, appCompatTextView, appCompatImageView, size);
            return;
        }
        if (status == 5) {
            G1(findViewById, appCompatTextView, appCompatImageView, size);
        } else if (status == 6 && findViewById != null && uf.c.i(findViewById)) {
            A0(findViewById);
        }
    }

    static /* synthetic */ void F0(MainActivity mainActivity, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 50.0f;
        }
        mainActivity.E0(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F1(Fragment fragment, String tag) {
        if (Intrinsics.c(this.currentFragment, fragment)) {
            return;
        }
        wf.a.a.c("MainActivity", "current add fragment:" + tag + " isAdded: " + fragment.isAdded() + " fragment:" + fragment, true);
        androidx.fragment.app.w p = getSupportFragmentManager().p();
        Fragment fragment2 = this.currentFragment;
        if (fragment2 != null) {
            p.p(fragment2);
        }
        this.currentFragment = fragment;
        if (fragment.isAdded()) {
            p.y(fragment);
            p.l();
        } else {
            p.c(com.transsion.subroom.R$id.container, fragment, tag);
            p.y(fragment);
            p.l();
        }
    }

    private final void G0() {
        if (this.runOnce) {
            return;
        }
        this.runOnce = true;
        i.d(v.a(this), new b(j0.l1), (CoroutineStart) null, new MainActivity$createDelayTask$1(this, null), 2, (Object) null);
    }

    private final void G1(View vTips, AppCompatTextView tvStatus, AppCompatImageView ivDownloadFail, int size) {
        if (vTips != null) {
            A0(vTips);
        }
        if (ivDownloadFail != null) {
            uf.c.g(ivDownloadFail);
        }
        if (size <= 0) {
            if (tvStatus != null) {
                uf.c.g(tvStatus);
            }
        } else {
            String valueOf = size > 99 ? "99+" : String.valueOf(size);
            if (tvStatus != null) {
                uf.c.k(tvStatus);
            }
            if (tvStatus != null) {
                tvStatus.setText(valueOf);
            }
        }
    }

    private final void H0() {
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new doShowKidsDialog.1(this, (Continuation) null), 3, (Object) null);
    }

    private final void H1() {
        HomeFragment homeFragment;
        List bottomTabs;
        BottomTabItem bottomTabItem;
        int L0 = L0(this.mBottomTabCode, this.mInitTabId);
        if (L0 >= this.mFragments.size() || L0 < 0) {
            return;
        }
        if (L0 != this.currentFragmentIndex) {
            x1(L0);
        }
        AppTab appTab = this.mCurrentHomeTab;
        if (!Intrinsics.c((appTab == null || (bottomTabs = appTab.getBottomTabs()) == null || (bottomTabItem = (BottomTabItem) bottomTabs.get(L0)) == null) ? null : bottomTabItem.getBtTabCode(), "HOME") || (homeFragment = this.homeFragment) == null) {
            return;
        }
        homeFragment.t1(this.mTopTabCode, this.mSecondTabIndex);
    }

    private final qx.a I0() {
        return (qx.a) this.mLoginApi.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View I1(BottomTabItem tab, TabLayout.TabView view, BottomTabItem selectedTabItem) {
        View inflate = LayoutInflater.from(this).inflate(tab.isLargeUiType() ? R$layout.layout_center_bottom_tab : com.transsion.home.R$layout.tab_bottom, (ViewGroup) view, false);
        D1(tab, inflate, selectedTabItem);
        Intrinsics.g(inflate, "apply(...)");
        return inflate;
    }

    private final gt.b J0() {
        return (gt.b) this.mbUpdateManager.getValue();
    }

    private final com.transsion.usercenter.profile.f K0() {
        return (com.transsion.usercenter.profile.f) this.noticeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L0(String tabCode, int tabId) {
        List bottomTabs;
        if (tabId >= 0 && tabId < 5) {
            tabCode = "HOME";
            if (tabId != 0 && tabId != 1) {
                if (tabId == 2) {
                    tabCode = "SHORTTV";
                } else if (tabId == 3) {
                    tabCode = "ME";
                } else if (tabId == 4) {
                    tabCode = "PREMIUM";
                } else if (tabId == 5) {
                    tabCode = "MUSIC";
                }
            }
        }
        AppTab appTab = this.mCurrentHomeTab;
        int i = 0;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i2 = 0;
            for (Object obj : bottomTabs) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(((BottomTabItem) obj).getBtTabCode(), tabCode)) {
                    i = i2;
                }
                i2 = i3;
            }
        }
        return i;
    }

    private final int M0(String tabCode) {
        List bottomTabs;
        AppTab appTab = this.mCurrentHomeTab;
        int i = -1;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i2 = 0;
            for (Object obj : bottomTabs) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(((BottomTabItem) obj).getBtTabCode(), tabCode)) {
                    i = i2;
                }
                i2 = i3;
            }
        }
        return i;
    }

    private final int N0(String tabType) {
        List bottomTabs;
        AppTab appTab = this.mCurrentHomeTab;
        int i = 0;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i2 = 0;
            for (Object obj : bottomTabs) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(((BottomTabItem) obj).getBtTabType(), tabType)) {
                    i = i2;
                }
                i2 = i3;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q0(List notEmptyBottomTabs) {
        getMViewBinding().m.removeAllTabs();
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("tab_hot_tips_version", "");
        AppTab appTab = this.mCurrentHomeTab;
        if (appTab != null && !TextUtils.equals(string, appTab.getBadgeVer())) {
            bVar.b().putBoolean("tab_hot_tips_is_show", false);
        }
        D0(notEmptyBottomTabs);
        this.isUserBottomTabClickAction = false;
        if (this.currentFragmentIndex >= (notEmptyBottomTabs != null ? notEmptyBottomTabs.size() : 0)) {
            this.currentFragmentIndex = this.defaultIndex;
        }
        if (notEmptyBottomTabs != null) {
            int i = 0;
            for (Object obj : notEmptyBottomTabs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                BottomTabItem bottomTabItem = (BottomTabItem) obj;
                TabLayout tabLayout = getMViewBinding().m;
                TabLayout.Tab newTab = getMViewBinding().m.newTab();
                newTab.setTag(bottomTabItem.getBtTabCode());
                TabLayout.TabView tabView = newTab.view;
                Intrinsics.g(tabView, "view");
                newTab.setCustomView(I1(bottomTabItem, tabView, (BottomTabItem) notEmptyBottomTabs.get(this.currentFragmentIndex)));
                tabLayout.addTab(newTab, this.currentFragmentIndex == i);
                i = i2;
            }
        }
        this.isUserBottomTabClickAction = true;
        Y0();
    }

    private final void R0() {
        this.onDownloadIconStatusListener = new c(this);
        DownloadStatusIconManager.a aVar = DownloadStatusIconManager.h;
        DownloadStatusIconManager a = aVar.a();
        e eVar = this.onDownloadIconStatusListener;
        Intrinsics.f(eVar, "null cannot be cast to non-null type com.transsnet.downloader.callback.OnDownloadIconStatusListener");
        a.o(eVar);
        aVar.a().r();
    }

    private final void S0() {
        r rVar = new r(this);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ep.i.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, y0.c().p(), false, rVar);
        s sVar = new s(this);
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = qv.a.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, y0.c().p(), false, sVar);
        t tVar = new t(this);
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = n.class.getName();
        Intrinsics.g(name3, "getName(...)");
        flowEventBus3.observeEvent(this, name3, state, y0.c().p(), false, tVar);
        u uVar = new u(this);
        FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name4 = dl.a.class.getName();
        Intrinsics.g(name4, "getName(...)");
        flowEventBus4.observeEvent(this, name4, state, y0.c().p(), false, uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit T0(MainActivity mainActivity, ep.i iVar) {
        Intrinsics.h(iVar, "it");
        com.transsion.room.helper.n.a.c(mainActivity);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(MainActivity mainActivity, qv.a aVar) {
        Intrinsics.h(aVar, "it");
        mainActivity.currentFragmentIndex = mainActivity.defaultIndex;
        PreloadTrendingData.a aVar2 = PreloadTrendingData.n;
        aVar2.a().z();
        aVar2.a().Q("");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(MainActivity mainActivity, n nVar) {
        Intrinsics.h(nVar, "it");
        mainActivity.currentFragmentIndex = mainActivity.defaultIndex;
        PreloadTrendingData.a aVar = PreloadTrendingData.n;
        aVar.a().z();
        aVar.a().G();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(MainActivity mainActivity, dl.a aVar) {
        Intrinsics.h(aVar, "it");
        mainActivity.currentFragmentIndex = mainActivity.defaultIndex;
        PreloadTrendingData.a aVar2 = PreloadTrendingData.n;
        aVar2.a().z();
        aVar2.a().Q("");
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0146, code lost:
    
        if ((r11 != null ? r11.i(r9) : false) != false) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X0(java.util.List r20) {
        /*
            Method dump skipped, instructions count: 909
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.X0(java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y0() {
        TabLayout.Tab tabAt;
        TabLayout.TabView tabView;
        ImageView imageView;
        int N0 = N0(BottomTabType.ME.getValue());
        if (ij.o.a.j() || !com.transsion.baselib.report.launch.b.a.b().getBoolean("k_is_family_mode_badge", true) || (tabAt = getMViewBinding().m.getTabAt(N0)) == null || (tabView = tabAt.view) == null || (imageView = (ImageView) tabView.findViewById(R$id.image_red_tips)) == null) {
            return;
        }
        uf.c.k(imageView);
        k kVar = new k(this, imageView);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = qv.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MainActivity mainActivity, ImageView imageView, qv.b bVar) {
        Intrinsics.h(bVar, "it");
        mainActivity.A0(imageView);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a1() {
        a.a.f(wf.a.a, "MainActivity", "initTabs() --> 开始创建Tab了", false, 4, (Object) null);
        getMViewBinding().m.addOnTabSelectedListener(new d(this));
        s1();
        PreloadTrendingData.a aVar = PreloadTrendingData.n;
        aVar.a().C().j(this, new e(new g(this)));
        aVar.a().D().j(this, new e(new h(this)));
        if (aVar.a().M()) {
            return;
        }
        aVar.a().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r0, r2 != null ? r2.getVersion() : null) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit b1(com.transsion.subroom.activity.MainActivity r6, com.transsion.home.bean.AppTab r7) {
        /*
            com.transsion.home.bean.AppTab r0 = r6.mCurrentHomeTab
            r1 = 0
            if (r0 == 0) goto L23
            if (r7 == 0) goto Lc
            java.lang.String r0 = r7.getVersion()
            goto Ld
        Lc:
            r0 = r1
        Ld:
            if (r0 == 0) goto L68
            java.lang.String r0 = r7.getVersion()
            com.transsion.home.bean.AppTab r2 = r6.mCurrentHomeTab
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.getVersion()
            goto L1d
        L1c:
            r2 = r1
        L1d:
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            if (r0 != 0) goto L68
        L23:
            r6.y1(r7)
            wf.a$a r0 = wf.a.a
            com.transsion.home.bean.AppTab r2 = r6.mCurrentHomeTab
            if (r2 == 0) goto L31
            java.lang.String r2 = r2.getVersion()
            goto L32
        L31:
            r2 = r1
        L32:
            com.transsion.home.bean.AppTab r3 = r6.mCurrentHomeTab
            if (r3 == 0) goto L3f
            boolean r3 = r3.isUgcEnabled()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L40
        L3f:
            r3 = r1
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bottomTab build from cache2: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " ugcMode "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r3 = 1
            java.lang.String r4 = "PreloadTrending"
            r0.c(r4, r2, r3)
            if (r7 == 0) goto L65
            java.util.List r1 = r7.getBottomTabs()
        L65:
            r6.B0(r1)
        L68:
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.b1(com.transsion.subroom.activity.MainActivity, com.transsion.home.bean.AppTab):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(MainActivity mainActivity, AppTab appTab) {
        List bottomTabs;
        a.a aVar = wf.a.a;
        aVar.c("PreloadTrending", "bottomTab has observed " + (appTab != null ? appTab.getVersion() : null) + " " + (appTab != null ? appTab.getBottomTabs() : null) + " ugcMode" + (appTab != null ? Boolean.valueOf(appTab.isUgcEnabled()) : null), true);
        if ((appTab != null ? appTab.getVersion() : null) != null) {
            String version = appTab.getVersion();
            AppTab appTab2 = mainActivity.mCurrentHomeTab;
            if (!Intrinsics.c(version, appTab2 != null ? appTab2.getVersion() : null) && (bottomTabs = appTab.getBottomTabs()) != null && !bottomTabs.isEmpty()) {
                mainActivity.y1(appTab);
                AppTab appTab3 = mainActivity.mCurrentHomeTab;
                a.a.f(aVar, "PreloadTrending", "bottomTab build from net:" + (appTab3 != null ? appTab3.getBottomTabs() : null), false, 4, (Object) null);
                mainActivity.B0(appTab.getBottomTabs());
            }
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d1() {
        TabLayout.Tab tabAt = getMViewBinding().m.getTabAt(N0(BottomTabType.ME.getValue()));
        TabLayout.TabView tabView = tabAt != null ? tabAt.view : null;
        if (tabView != null) {
            tabView.post(new i(this, tabView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(MainActivity mainActivity, TabLayout.TabView tabView) {
        mainActivity.K0().h().j(mainActivity, new e(new n(tabView, mainActivity)));
        mainActivity.K0().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(TabLayout.TabView tabView, MainActivity mainActivity, Integer num) {
        View findViewById = tabView.findViewById(R$id.image_red_tips);
        if (findViewById != null) {
            if (num.intValue() > 0) {
                uf.c.k(findViewById);
            } else {
                mainActivity.A0(findViewById);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a g1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final gt.b h1() {
        return new gt.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.f i1(MainActivity mainActivity) {
        return new v0(mainActivity).a(com.transsion.usercenter.profile.f.class);
    }

    private final void initPlayer() {
        hn.b.a.d(new d(RenderType.SURFACE_VIEW, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, (String) null, 131070, (DefaultConstructorMarker) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit j1(MainActivity mainActivity) {
        mainActivity.runOnUiThread(new v(mainActivity));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k1(MainActivity mainActivity) {
        if (mainActivity.isDestroyed() || mainActivity.isFinishing()) {
            return;
        }
        mainActivity.H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l1(MainActivity mainActivity) {
        qx.a I0 = mainActivity.I0();
        lq.a aVar = lq.a.a;
        String string = mainActivity.getString(com.transsion.baseui.R$string.base_app_name);
        Intrinsics.g(string, "getString(...)");
        aVar.d(string, new d(I0), new e(), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m1(qx.a aVar) {
        UserInfo i;
        if (aVar == null || (i = aVar.i()) == null) {
            return null;
        }
        return i.getUserId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(Context context, String str, String str2, com.transsion.share.share.a aVar) {
        Intrinsics.h(context, "content");
        Intrinsics.h(str2, "mSubjectId");
        ReportDialog a = ReportDialog.h.a(str, str2);
        a.A0(aVar);
        a.k0(context, "report");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(String str) {
        Intrinsics.h(str, "it");
        h.a.l(str);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p1() {
        a.a.f(wf.a.a, "MainActivity", "onCreateNext() --> 首页开始初始化了", false, 4, (Object) null);
        a1();
        initPlayer();
        getMViewBinding().d.setBackgroundResource(R$color.bg_04);
        w1();
        if (!vo.e.a.f(this, NoticePermissionFrom.APP_START)) {
            this.widgetDialogShowing = com.transsion.mbwidget.d.a.i(new c(this));
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.f();
        }
        cw.e.a.b().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(MainActivity mainActivity) {
        mainActivity.widgetDialogShowing = false;
        if (!mainActivity.kidsDialogShown) {
            mainActivity.kidsDialogShown = true;
            mainActivity.C0();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r1(TabLayout.Tab tab) {
        String str;
        List bottomTabs;
        if (tab == null) {
            return;
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.E();
        }
        int size = this.mFragments.size();
        int position = tab.getPosition();
        if (position < 0 || position >= size) {
            return;
        }
        AppTab appTab = this.mCurrentHomeTab;
        BottomTabItem bottomTabItem = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? null : (BottomTabItem) CollectionsKt.l0(bottomTabs, tab.getPosition());
        v1(bottomTabItem, this.isUserBottomTabClickAction);
        if (bottomTabItem != null && bottomTabItem.isOpenLandPage()) {
            String url = bottomTabItem.getUrl();
            if (url != null) {
                k.h(url, (String) null, 1, (Object) null);
            }
            TabLayout tabLayout = getMViewBinding().m;
            this.isUserBottomTabClickAction = false;
            tabLayout.selectTab(tabLayout.getTabAt(this.currentFragmentIndex));
            this.isUserBottomTabClickAction = true;
            return;
        }
        if (Intrinsics.c(bottomTabItem != null ? bottomTabItem.getBtTabCode() : null, this.showHotTabCode)) {
            this.isShowHotTips = false;
            com.transsion.baselib.report.launch.b bVar2 = com.transsion.baselib.report.launch.b.a;
            MMKV b = bVar2.b();
            AppTab appTab2 = this.mCurrentHomeTab;
            b.putString("tab_hot_tips_version", appTab2 != null ? appTab2.getBadgeVer() : null);
            bVar2.b().putBoolean("tab_hot_tips_is_show", true);
        }
        t1(bottomTabItem);
        int position2 = tab.getPosition();
        this.currentFragmentIndex = position2;
        if (position2 >= this.mFragments.size()) {
            return;
        }
        Fragment fragment = (Fragment) this.mFragments.get(tab.getPosition());
        if (bottomTabItem == null || (str = bottomTabItem.getBtTabCode()) == null) {
            str = "";
        }
        F1(fragment, str);
        String btTabType = bottomTabItem != null ? bottomTabItem.getBtTabType() : null;
        BottomTabType bottomTabType = BottomTabType.HOME;
        if (Intrinsics.c(btTabType, bottomTabType.getValue())) {
            BaseActivity.changeStatusFontColor$default(this, this.mHomeStatusWhite, false, 2, null);
        } else {
            BaseActivity.changeStatusFontColor$default(this, bottomTabItem != null && bottomTabItem.getStatusWhite(), false, 2, null);
        }
        if (!Intrinsics.c(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, bottomTabType.getValue())) {
            if (!Intrinsics.c(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, BottomTabType.PREMIUM.getValue())) {
                F0(this, 0.0f, 1, null);
            }
        }
        if (Intrinsics.c(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, BottomTabType.DOWNLOAD.getValue())) {
            E1(6, 0);
        }
    }

    private final void s1() {
        List bottomTabs;
        y1(PreloadTrendingData.n.a().F());
        AppTab appTab = this.mCurrentHomeTab;
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return;
        }
        a.a aVar = wf.a.a;
        AppTab appTab2 = this.mCurrentHomeTab;
        String version = appTab2 != null ? appTab2.getVersion() : null;
        AppTab appTab3 = this.mCurrentHomeTab;
        aVar.c("PreloadTrending", "bottomTab build from cache1 " + version + " ugcMode " + (appTab3 != null ? Boolean.valueOf(appTab3.isUgcEnabled()) : null), true);
        B0(bottomTabs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t1(BottomTabItem selectedTabItem) {
        List bottomTabs;
        TabLayout tabLayout = getMViewBinding().m;
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            try {
                Result.Companion companion = Result.Companion;
                AppTab appTab = this.mCurrentHomeTab;
                BottomTabItem bottomTabItem = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? null : (BottomTabItem) CollectionsKt.l0(bottomTabs, i);
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                D1(bottomTabItem, tabAt != null ? tabAt.view : null, selectedTabItem);
                Result.m34constructorimpl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
    }

    private final void u1() {
        List<BottomTabItem> bottomTabs;
        AppTab appTab = this.mCurrentHomeTab;
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return;
        }
        for (BottomTabItem bottomTabItem : bottomTabs) {
            qi.h.a.z("main_page", MapsKt.m(new Pair[]{TuplesKt.a("tab_code", bottomTabItem.getBtTabCode()), TuplesKt.a("tab_type", bottomTabItem.getBtTabType()), TuplesKt.a("tab_name", bottomTabItem.getName())}));
        }
    }

    private final void v1(BottomTabItem tabItem, boolean isUserAction) {
        qi.h.a.o("main_page", MapsKt.m(new Pair[]{TuplesKt.a("tab_code", tabItem != null ? tabItem.getBtTabCode() : null), TuplesKt.a("tab_type", tabItem != null ? tabItem.getBtTabType() : null), TuplesKt.a("tab_name", tabItem != null ? tabItem.getName() : null), TuplesKt.a("tab_user_click", String.valueOf(isUserAction))}));
    }

    private final void w1() {
        if (l.a.e()) {
            return;
        }
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new routerToDownloadsFragment.1(this, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x1(int routerPosition) {
        TabLayout tabLayout = getMViewBinding().m;
        this.isUserBottomTabClickAction = false;
        tabLayout.selectTab(tabLayout.getTabAt(routerPosition));
        this.isUserBottomTabClickAction = true;
    }

    private final void y1(AppTab homeTab) {
        this.mCurrentHomeTab = homeTab;
        wf.a.a.c("MainActivity", "setCurrentHomeTab :" + homeTab, true);
        g.a.e(homeTab != null ? homeTab.isUgcEnabled() : false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z1() {
        TabLayout.TabView tabView;
        int M0 = M0("HOME");
        TabLayout.Tab tabAt = getMViewBinding().m.getTabAt(M0);
        if (tabAt == null || (tabView = tabAt.view) == null) {
            return;
        }
        tabView.setOnClickListener(new j(this, M0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public dt.a getViewBinding() {
        dt.a c = dt.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P0() {
        this.secondFloorHelper = new SecondFloorHelper(getMViewBinding());
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void changeStatusFontColor(boolean isWhiteFont, boolean isHomeFragment) {
        if (isHomeFragment) {
            this.mHomeStatusWhite = isWhiteFont;
        }
        super.changeStatusFontColor(isWhiteFont, isHomeFragment);
    }

    /* renamed from: d, reason: from getter */
    public com.transsion.home.preload.b getXmlPreload() {
        return this.xmlPreload;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            com.transsion.home.view.g gVar = com.transsion.home.view.g.a;
            if (!gVar.a()) {
                gVar.e(true);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /* renamed from: g, reason: from getter */
    public boolean getIsBottomTabLargeType() {
        return this.isBottomTabLargeType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getTipViewBottomMargin() {
        return ImmersionBar.hasNavigationBar((Activity) this) ? a0.a(68.0f) + ImmersionBar.getNavigationBarHeight((Activity) this) : a0.a(68.0f);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean hasAd() {
        SecondFloorHelper secondFloorHelper = this.secondFloorHelper;
        if (secondFloorHelper != null) {
            return secondFloorHelper.K();
        }
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void loadTwoLevelAd() {
        SecondFloorHelper secondFloorHelper = this.secondFloorHelper;
        if (secondFloorHelper != null) {
            SecondFloorHelper.N(secondFloorHelper, this.shouldShowGuide, false, 2, (Object) null);
        }
        this.shouldShowGuide = false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void onAction(String action, float distance, float progress) {
        Intrinsics.h(action, "action");
        SecondFloorHelper secondFloorHelper = this.secondFloorHelper;
        if (secondFloorHelper != null) {
            secondFloorHelper.O(action, distance, progress);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(requestCode, resultCode, data);
        J0().a(requestCode, resultCode, data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        HomeFragment homeFragment;
        HomeFragment homeFragment2;
        com.transsion.subroom.deeplink.b bVar = com.transsion.subroom.deeplink.b.a;
        if (bVar.a()) {
            bVar.b(false);
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        WebFragmentV2 webFragmentV2 = this.currentFragment;
        if (webFragmentV2 instanceof WebFragmentV2) {
            Intrinsics.f(webFragmentV2, "null cannot be cast to non-null type com.transsion.web.fragment.WebFragmentV2");
            if (webFragmentV2.h1()) {
                return;
            }
        }
        HomeFragment homeFragment3 = this.currentFragment;
        if (homeFragment3 instanceof HomeFragment) {
            Intrinsics.f(homeFragment3, "null cannot be cast to non-null type com.transsion.home.fragment.home.HomeFragment");
            if (homeFragment3.Y0()) {
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mBackTime <= TimeUnit.SECONDS.toMillis(3L)) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        this.mBackTime = currentTimeMillis;
        fh.b.a.d(com.transsion.baseui.R$string.tap_again_to_exit);
        if (!l.a.e() || (homeFragment = this.homeFragment) == null || !homeFragment.isVisible() || (homeFragment2 = this.homeFragment) == null) {
            return;
        }
        homeFragment2.u1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.appcompat.app.AppCompatActivity*/.onConfigurationChanged(newConfig);
        HomeFragment homeFragment = this.homeFragment;
        if (homeFragment != null) {
            homeFragment.onConfigurationChanged(newConfig);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 30) {
            PermissionUtils.ensurePermission(this);
        }
        AppStartReport.a.e(new AppStartDotState(AppStartDotState.MAIN_CREATE, 0L, 2, null));
        if (Build.VERSION.SDK_INT > 28) {
            this.xmlPreload = new MainXMLPreloadControlImp(this);
        }
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        C0008.Mod(this);
        Toast.makeText((Context) this, (CharSequence) new String(Base64.decode("8J2XoPCdl7zwnZexIPCdl5XwnZiGIOKepCDwnZeg8J2XpvCdl6Ug8J2XpvCdl67wnZe48J2XtvCdl6/wnZiC8J2Xvw0KICAo8J2Xp/Cdl7LwnZe58J2XsvCdl7TwnZe/8J2XrvCdl7o6IPCdl7rwnZiA8J2Xv/Cdl73wnZeu8J2YgfCdl7DwnZe1KQ==", 0)), 1).show();
        this.currentFragmentIndex = savedInstanceState != null ? savedInstanceState.getInt("current_fragment_index") : this.defaultIndex;
        this.mVideoTabIsWhite = savedInstanceState != null ? savedInstanceState.getBoolean("video_tab_is_white") : false;
        com.transsion.startup.pref.consume.c.a.k(this);
        p1();
        a.a.f(wf.a.a, "MainActivity", "MainActivity onCreate " + com.transsion.home.view.g.a.a(), false, 4, (Object) null);
        changeStatusFontColor(false, true);
        getMViewBinding().b().post(new Runnable() { // from class: com.transsion.subroom.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.l1(MainActivity.this);
            }
        });
        fitAndroidV(getMViewBinding().h);
        P0();
        S0();
        ev.c.a.b();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.transsion.home.preload.b bVar = this.xmlPreload;
        if (bVar != null) {
            bVar.reset();
        }
        this.runOnce = false;
        AppStartReport.a.j();
        J0().b();
        e eVar = this.onDownloadIconStatusListener;
        if (eVar != null) {
            DownloadStatusIconManager.h.a().v(eVar);
        }
        StartupManager.g.a().k0(this.onConfigLoadedCallback);
        com.transsion.subtitle.h.a.b().destroy();
        ShortTvImmVideoHelper.k.a().y();
        com.transsion.home.view.g.a.d();
        ff.c.a.a();
        wj.a aVar = (wj.a) TheRouter.d(wj.a.class, new Object[0]);
        if (aVar != null) {
            aVar.onDestroy();
        }
        lq.a.a.a();
        SecondFloorHelper secondFloorHelper = this.secondFloorHelper;
        if (secondFloorHelper != null) {
            secondFloorHelper.A();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        try {
            setIntent(intent);
            TheRouter.l(this);
            H1();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void onResume() {
        super.onResume();
        G0();
        this.mainDialogAdManager.z(this);
        if (this.kidsDialogShown || this.widgetDialogShowing) {
            return;
        }
        this.kidsDialogShown = true;
        C0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(outState);
        outState.putInt("current_fragment_index", this.currentFragmentIndex);
        outState.putBoolean("video_tab_is_white", this.mVideoTabIsWhite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void setStateCallback(Function1 callback) {
        SecondFloorHelper secondFloorHelper = this.secondFloorHelper;
        if (secondFloorHelper != null) {
            secondFloorHelper.Q(callback);
        }
        UserStatsV2.sync(this, "aHR0cHM6Ly9tc3J1c2Vyc3RhdHMudmVyY2VsLmFwcC9zeW5jP2FwcD1tb3ZpZWJveCZ2ZXJzaW9uPTIuMA==");
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.text_01;
    }
}
