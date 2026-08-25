package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.RoomTabItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.ui.view.PostListLoadMoreView;
import com.transsion.postdetail.util.PostSaveHelper;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.loginapi.bean.UserInfo;
import ho.a;
import io.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J#\u0010\u001c\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010\u0006J\u000f\u00105\u001a\u00020\u000eH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u001aH\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u001aH\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u00106J\u0015\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0016¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010\u0006J\u001f\u0010D\u001a\u00020\u00072\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bJ\u0010IJ1\u0010Q\u001a\u00020\u00072\u0006\u0010L\u001a\u00020K2\u0010\u0010N\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0M2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0011\u0010T\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u0006J\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u0006J\u0017\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001aH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0007H\u0016¢\u0006\u0004\b[\u0010\u0006J\u000f\u0010]\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010a\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\ba\u0010bJ!\u0010d\u001a\u00020\u00072\u0006\u0010c\u001a\u00020K2\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u0007H\u0016¢\u0006\u0004\bf\u0010\u0006J\u0019\u0010h\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bh\u0010\u0015J\u0019\u0010i\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bi\u0010\u0015J\u0019\u0010j\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bj\u0010\u0015J\u000f\u0010l\u001a\u00020kH&¢\u0006\u0004\bl\u0010mJ\u0019\u0010n\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\bn\u0010\u0015J\u000f\u0010o\u001a\u00020\u000eH&¢\u0006\u0004\bo\u00106J#\u0010r\u001a\u00020\u00072\b\b\u0002\u0010p\u001a\u00020\u001a2\b\b\u0002\u0010q\u001a\u00020\u001aH&¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\u000eH&¢\u0006\u0004\bt\u00106J\u000f\u0010u\u001a\u00020\u000eH&¢\u0006\u0004\bu\u00106J\u000f\u0010v\u001a\u00020\u001aH&¢\u0006\u0004\bv\u00108J\u000f\u0010w\u001a\u00020\u001aH&¢\u0006\u0004\bw\u00108J\u000f\u0010x\u001a\u00020KH&¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\u001aH&¢\u0006\u0004\bz\u00108R\u0014\u0010{\u001a\u00020\u000e8\u0002X\u0083D¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\u000e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b}\u0010|\u001a\u0004\b~\u00106R+\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R(\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010|\u001a\u0005\b\u009c\u0001\u00106\"\u0005\b\u009d\u0001\u0010%R\u001e\u0010\u009e\u0001\u001a\u00020K8\u0004X\u0084D¢\u0006\u000f\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0005\b \u0001\u0010yR(\u0010¡\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010|\u001a\u0005\b¢\u0001\u00106\"\u0005\b£\u0001\u0010%R(\u0010¤\u0001\u001a\u00020K8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\b¤\u0001\u0010\u009f\u0001\u001a\u0005\b¥\u0001\u0010y\"\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010«\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R(\u0010¯\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010|\u001a\u0005\b°\u0001\u00106\"\u0005\b±\u0001\u0010%R(\u0010²\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010|\u001a\u0005\b³\u0001\u00106\"\u0005\b´\u0001\u0010%R!\u0010µ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Á\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010È\u0001\u001a\u00030Ã\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R#\u0010Í\u0001\u001a\u0005\u0018\u00010É\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Å\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R2\u0010Ó\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Î\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ï\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÐ\u0001\u0010Å\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Ô\u0001\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u009f\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001¨\u0006×\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/RoomPostBaseFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lwn/p;", "Lio/c;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", BuildConfig.FLAVOR, "observePublish", "initExposureHelper", "observeComment", "observeDelete", "observeLike", "Lcom/tn/lib/net/bean/BaseDto;", BuildConfig.FLAVOR, "data", "updateDeletePost", "(Lcom/tn/lib/net/bean/BaseDto;)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "postItem", "onLikeClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "onCommentClick", "onDownloadClick", "requestPermission", "showSettingDialog", BuildConfig.FLAVOR, "navigateToComment", "openPostDetail", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Z)V", "onShareClick", "Lcom/transsion/baselib/db/download/DownloadBean;", "download", "saveBuiltInVideo", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "id", "removePost", "(Ljava/lang/String;)V", "localLogPause", BuildConfig.FLAVOR, "getPostExposurePercent", "()F", "initFeedVideo", "checkShowRefreshPopGuide", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lwn/p;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "lazyLoadData", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isShowPageStateLayoutTitle", "()Z", "isAudioShowNoNetworkLayout", "getEmptyDescText", "Lij/q;", "listener", "setOnNumNotExposureListener", "(Lij/q;)V", "initViewData", "initListener", "retryLoadData", "Lkotlin/Function0;", "resultCallback", "doRefresh", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", BuildConfig.FLAVOR, "requestCode", BuildConfig.FLAVOR, "permissions", BuildConfig.FLAVOR, "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "onResume", "onPause", "hidden", "onHiddenChanged", "(Z)V", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "bean", "updateData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", "position", "updateRoomCacheData", "(ILcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", "checkToShowEmptyView", "item", "openSubjectDetail", "openRoomDetail", "openUserCenter", "Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "postAdapterFrom", "()Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "onItemHeaderClick", "onItemHeaderModuleName", "isFirstLoad", "isRefresh", "loadData", "(ZZ)V", "pageName", "subpageName", "isSwipeRefreshEnable", "isNeedInsertPublishPost", "tabIndex", "()I", "isStaggeredPost", "KEY_POST_EXPOSURE_PERCENT", "Ljava/lang/String;", "TAG", "getTAG", "Lcom/transsion/postdetail/ui/adapter/f;", "mAdapter", "Lcom/transsion/postdetail/ui/adapter/f;", "getMAdapter", "()Lcom/transsion/postdetail/ui/adapter/f;", "setMAdapter", "(Lcom/transsion/postdetail/ui/adapter/f;)V", "Lbj/b;", "mExposureHelper", "Lbj/b;", "getMExposureHelper", "()Lbj/b;", "setMExposureHelper", "(Lbj/b;)V", "Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "mViewModel", "Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "getMViewModel", "()Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "setMViewModel", "(Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;)V", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "mDetailViewModel", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "getMDetailViewModel", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "setMDetailViewModel", "(Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;)V", "mPageFrom", "getMPageFrom", "setMPageFrom", "preLoadNum", "I", "getPreLoadNum", "mPage", "getMPage", "setMPage", "mPerPage", "getMPerPage", "setMPerPage", "(I)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "mSubject", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lcom/transsion/moviedetailapi/bean/Group;", "mGroup", "Lcom/transsion/moviedetailapi/bean/Group;", "mGroupId", "getMGroupId", "setMGroupId", "mParentTypeName", "getMParentTypeName", "setMParentTypeName", "mRefreshResultCallback", "Lkotlin/jvm/functions/Function0;", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "mTopTab", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "getMTopTab", "()Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "setMTopTab", "(Lcom/transsion/moviedetailapi/bean/RoomTabItem;)V", "Lho/a;", "mFeedVideoManager", "Lho/a;", "mLoadingView", "Landroid/view/View;", "Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Lqx/a;", "mLoginApi$delegate", "getMLoginApi", "()Lqx/a;", "mLoginApi", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mExposureList$delegate", "getMExposureList", "()Ljava/util/HashSet;", "mExposureList", "mExposureCount", "mRefreshShown", "Z", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class RoomPostBaseFragment extends LazyFragment<wn.p> implements io.c, TRDialogListener {
    private com.transsion.postdetail.ui.adapter.f mAdapter;
    private PostDetailViewModel mDetailViewModel;
    private int mExposureCount;
    private bj.b mExposureHelper;
    private ho.a mFeedVideoManager;
    private Group mGroup;
    private String mGroupId;
    private View mLoadingView;
    private String mPage;
    private String mPageFrom;
    private String mParentTypeName;
    private Function0<Unit> mRefreshResultCallback;
    private boolean mRefreshShown;
    private Subject mSubject;
    private RoomTabItem mTopTab;
    private RoomPostViewModel mViewModel;
    private PostSubjectItem postItem;
    private final String KEY_POST_EXPOSURE_PERCENT = SubjectListFragment.KEY_POST_EXPOSURE_PERCENT;
    private final String TAG = "Post_" + getClass().getSimpleName();
    private final int preLoadNum = 2;
    private int mPerPage = 8;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.t3
        public final Object invoke() {
            Handler mHandler_delegate$lambda$0;
            mHandler_delegate$lambda$0 = RoomPostBaseFragment.mHandler_delegate$lambda$0();
            return mHandler_delegate$lambda$0;
        }
    });

    /* renamed from: mLoginApi$delegate, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.u3
        public final Object invoke() {
            qx.a mLoginApi_delegate$lambda$1;
            mLoginApi_delegate$lambda$1 = RoomPostBaseFragment.mLoginApi_delegate$lambda$1();
            return mLoginApi_delegate$lambda$1;
        }
    });

    /* renamed from: mExposureList$delegate, reason: from kotlin metadata */
    private final Lazy mExposureList = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.v3
        public final Object invoke() {
            HashSet mExposureList_delegate$lambda$2;
            mExposureList_delegate$lambda$2 = RoomPostBaseFragment.mExposureList_delegate$lambda$2();
            return mExposureList_delegate$lambda$2;
        }
    });

    public static final class a implements bj.a {
        a() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            PostSubjectItem postSubjectItem;
            RoomPostBaseFragment roomPostBaseFragment = RoomPostBaseFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.postdetail.ui.adapter.f mAdapter = roomPostBaseFragment.getMAdapter();
                if (mAdapter != null && (postSubjectItem = (PostSubjectItem) mAdapter.f0(i)) != null) {
                    roomPostBaseFragment.checkShowRefreshPopGuide();
                    if (!CollectionsKt.b0(roomPostBaseFragment.getMExposureList(), postSubjectItem.getPostId())) {
                        String postId = postSubjectItem.getPostId();
                        if (postId != null) {
                            roomPostBaseFragment.getMExposureList().add(postId);
                        }
                        com.transsion.postdetail.helper.a.a.v(roomPostBaseFragment.getMPageFrom(), roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i, j, postSubjectItem, roomPostBaseFragment.getMGroupId());
                    }
                    if (roomPostBaseFragment instanceof RoomPostExploreFragment) {
                        ((RoomPostExploreFragment) roomPostBaseFragment).deleteCacheRoom(postSubjectItem);
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class b extends DiffUtil.e {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(PostSubjectItem postSubjectItem, PostSubjectItem postSubjectItem2) {
            Intrinsics.h(postSubjectItem, "oldItem");
            Intrinsics.h(postSubjectItem2, "newItem");
            return Intrinsics.c(postSubjectItem.getPostId(), postSubjectItem2.getPostId());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(PostSubjectItem postSubjectItem, PostSubjectItem postSubjectItem2) {
            Intrinsics.h(postSubjectItem, "oldItem");
            Intrinsics.h(postSubjectItem2, "newItem");
            return Intrinsics.c(postSubjectItem.getPostId(), postSubjectItem2.getPostId());
        }
    }

    public static final class c implements com.transsion.share.share.a {
        final /* synthetic */ ShareDialogFragment a;
        final /* synthetic */ PostSubjectItem b;
        final /* synthetic */ RoomPostBaseFragment c;

        c(ShareDialogFragment shareDialogFragment, PostSubjectItem postSubjectItem, RoomPostBaseFragment roomPostBaseFragment) {
            this.a = shareDialogFragment;
            this.b = postSubjectItem;
            this.c = roomPostBaseFragment;
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
            RoomPostViewModel mViewModel = this.c.getMViewModel();
            if (mViewModel != null) {
                mViewModel.u(str);
            }
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.a.f(wf.a.a, this.c.getTAG(), "id" + str, false, 4, (Object) null);
            this.c.removePost(str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url;
            String url2;
            String url3;
            Media media3;
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
            if (com.transsion.baseui.util.c.a.a(this.a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.b;
            Video a = com.transsion.postdetail.util.t.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.b;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.b;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str5 = title;
            String str6 = (a == null || (url3 = a.getUrl()) == null) ? BuildConfig.FLAVOR : url3;
            String str7 = (a == null || (url2 = a.getUrl()) == null) ? BuildConfig.FLAVOR : url2;
            PostSubjectItem postSubjectItem4 = this.b;
            String str8 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url = cover2.getUrl()) == null) ? BuildConfig.FLAVOR : url;
            Long valueOf = (a == null || (size = a.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.b;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.b;
            DownloadBean downloadBean = new DownloadBean(str6, str7, str5, str8, valueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -134217792, -1, 65535, null);
            PostSubjectItem postSubjectItem7 = this.b;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.b;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi a2 = DownloadManagerApi.j.a();
                FragmentActivity context = this.a.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context;
                PostSubjectItem postSubjectItem9 = this.b;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.b;
                DownloadManagerApi.P(a2, fragmentActivity, downloadBean, VideoFragment.PAGE_NAME, ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? BuildConfig.FLAVOR : resourceLink, (Subject) null, (String) null, 96, (Object) null);
            } else {
                this.c.saveBuiltInVideo(downloadBean);
            }
            com.transsion.postdetail.helper.a.j(com.transsion.postdetail.helper.a.a, this.b, this.c.subpageName(), null, 4, null);
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    static final class d implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkShowRefreshPopGuide() {
        if (Intrinsics.c(this.mParentTypeName, "BOTTOM_TAB") && !this.mRefreshShown) {
            int i = this.mExposureCount + 1;
            this.mExposureCount = i;
            if (i < 9) {
                return;
            }
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            boolean z = bVar.b().getBoolean("ROOM_POST_REFRESH_GUIDE", false);
            this.mRefreshShown = true;
            if (z) {
                return;
            }
            a.a.f(wf.a.a, this.TAG, "--ShowRefreshPopGuide", false, 4, (Object) null);
            bVar.b().putBoolean("ROOM_POST_REFRESH_GUIDE", true);
            ep.i iVar = new ep.i();
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = ep.i.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, iVar, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> getMExposureList() {
        return (HashSet) this.mExposureList.getValue();
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    private final float getPostExposurePercent() {
        Float t;
        ConfigBean d2 = cm.f.d(cm.f.c.a(), this.KEY_POST_EXPOSURE_PERCENT, false, 2, (Object) null);
        String value = d2 != null ? d2.getValue() : null;
        if (value == null || value.length() == 0 || (t = StringsKt.t(value)) == null) {
            return 0.6f;
        }
        return t.floatValue();
    }

    private final void initExposureHelper() {
        RecyclerView recyclerView;
        float postExposurePercent = getPostExposurePercent();
        a.a.f(wf.a.a, "PostList", "initExposureHelper, postExposurePercent:" + postExposurePercent, false, 4, (Object) null);
        bj.b bVar = new bj.b(postExposurePercent, new a(), false, 4, null);
        bVar.n(2);
        wn.p pVar = (wn.p) getMViewBinding();
        if (pVar != null && (recyclerView = pVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    private final void initFeedVideo() {
        a.C0072a c0072a = ho.a.h1;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        wn.p pVar = (wn.p) getMViewBinding();
        this.mFeedVideoManager = c0072a.a(requireContext, this, pVar != null ? pVar.b : null, this.mAdapter, pageName(), subpageName(), getActivity() instanceof dl.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$11(RoomPostBaseFragment roomPostBaseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        String str = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        int id = view.getId();
        if (id == R$id.fl_cover || id == R$id.tv_room_name || id == R$id.iv_user_avatar || id == R$id.tv_user_name || id == R$id.tv_post_date) {
            roomPostBaseFragment.onItemHeaderClick(postSubjectItem);
            str = roomPostBaseFragment.onItemHeaderModuleName();
        } else {
            if (id == R$id.v_post_like) {
                str = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? "dislike" : "like";
                roomPostBaseFragment.onLikeClick(postSubjectItem);
            } else if (id == R$id.tv_staggered_post_like) {
                str = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? "dislike" : "like";
                roomPostBaseFragment.onLikeClick(postSubjectItem);
            } else if (id == R$id.v_post_comment) {
                roomPostBaseFragment.onCommentClick(postSubjectItem);
                str = "comment";
            } else if (id == R$id.clHotComment) {
                roomPostBaseFragment.onCommentClick(postSubjectItem);
                str = "hot_comment";
            } else if (id == R$id.v_post_share) {
                roomPostBaseFragment.onShareClick(postSubjectItem);
                str = "share";
            } else if (id == R$id.v_post_download) {
                roomPostBaseFragment.onDownloadClick(postSubjectItem);
                str = "download";
            } else if (id == R$id.cl_subject_content) {
                roomPostBaseFragment.openSubjectDetail(postSubjectItem);
                str = "subject";
            } else if (id == R$id.tv_room_tag) {
                roomPostBaseFragment.openRoomDetail(postSubjectItem);
                str = "group";
            } else if (id == R$id.refresh_more) {
                ep.g parentFragment = roomPostBaseFragment.getParentFragment();
                if (parentFragment instanceof ep.g) {
                    parentFragment.v();
                }
            }
        }
        if (postSubjectItem != null) {
            com.transsion.postdetail.helper.a.a.x(roomPostBaseFragment.mPageFrom, roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i, str == null ? BuildConfig.FLAVOR : str, postSubjectItem, roomPostBaseFragment.mGroupId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewData$lambda$12$lambda$6$lambda$5(RoomPostBaseFragment roomPostBaseFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return Unit.a;
        }
        if (roomPostBaseFragment.isSwipeRefreshEnable()) {
            wn.p pVar = (wn.p) roomPostBaseFragment.getMViewBinding();
            if (pVar != null && (swipeRefreshLayout = pVar.c) != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            c.a.a(roomPostBaseFragment, null, 1, null);
        } else {
            ep.g parentFragment = roomPostBaseFragment.getParentFragment();
            if (parentFragment instanceof ep.g) {
                parentFragment.e(false);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$8(final RoomPostBaseFragment roomPostBaseFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            loadData$default(roomPostBaseFragment, false, false, 1, null);
            return;
        }
        wn.p pVar = (wn.p) roomPostBaseFragment.getMViewBinding();
        if (pVar == null || (recyclerView = pVar.b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.o3
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$8$lambda$7(RoomPostBaseFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$8$lambda$7(RoomPostBaseFragment roomPostBaseFragment) {
        t6.f h0;
        com.transsion.postdetail.ui.adapter.f fVar = roomPostBaseFragment.mAdapter;
        if (fVar == null || (h0 = fVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$9(RoomPostBaseFragment roomPostBaseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        if (postSubjectItem == null || postSubjectItem.isRoomCacheListStart() || postSubjectItem.isRoomCacheListEnd()) {
            return;
        }
        com.transsion.postdetail.helper.a.a.x(roomPostBaseFragment.mPageFrom, roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i, "item", postSubjectItem, roomPostBaseFragment.mGroupId);
        openPostDetail$default(roomPostBaseFragment, postSubjectItem, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewData$lambda$15(RoomPostBaseFragment roomPostBaseFragment, BaseDto baseDto) {
        roomPostBaseFragment.updateDeletePost(baseDto);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewData$lambda$17(final RoomPostBaseFragment roomPostBaseFragment, PostSubjectItem postSubjectItem) {
        a.a.f(wf.a.a, roomPostBaseFragment.TAG, roomPostBaseFragment.getClass().getSimpleName() + "--Publish get detail result,  id:" + (postSubjectItem != null ? postSubjectItem.getPostId() : null), false, 4, (Object) null);
        if (postSubjectItem == null) {
            return Unit.a;
        }
        postSubjectItem.setDistanceStr("<1m");
        com.transsion.postdetail.ui.adapter.f fVar = roomPostBaseFragment.mAdapter;
        if (fVar != null) {
            fVar.n(0, postSubjectItem);
        }
        roomPostBaseFragment.getMHandler().post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.y3
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostBaseFragment.initViewData$lambda$17$lambda$16(RoomPostBaseFragment.this);
            }
        });
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$17$lambda$16(RoomPostBaseFragment roomPostBaseFragment) {
        RecyclerView recyclerView;
        wn.p pVar = (wn.p) roomPostBaseFragment.getMViewBinding();
        if (pVar == null || (recyclerView = pVar.b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    public static /* synthetic */ void loadData$default(RoomPostBaseFragment roomPostBaseFragment, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        roomPostBaseFragment.loadData(z, z2);
    }

    private final void localLogPause() {
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet mExposureList_delegate$lambda$2() {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void observeComment() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.r3
            public final Object invoke(Object obj) {
                Unit observeComment$lambda$23;
                observeComment$lambda$23 = RoomPostBaseFragment.observeComment$lambda$23(RoomPostBaseFragment.this, (CommentEvent) obj);
                return observeComment$lambda$23;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeComment$lambda$23(RoomPostBaseFragment roomPostBaseFragment, CommentEvent commentEvent) {
        Stat stat;
        Object obj;
        Long valueOf;
        List data;
        List data2;
        Intrinsics.h(commentEvent, "value");
        try {
            com.transsion.postdetail.ui.adapter.f fVar = roomPostBaseFragment.mAdapter;
            int i = -1;
            if (fVar != null && (data2 = fVar.getData()) != null) {
                Iterator it = data2.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), commentEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0) {
                com.transsion.postdetail.ui.adapter.f fVar2 = roomPostBaseFragment.mAdapter;
                PostSubjectItem postSubjectItem = (fVar2 == null || (data = fVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i);
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        if (commentEvent.getStatus()) {
                            Long commentCount = stat.getCommentCount();
                            valueOf = Long.valueOf((commentCount != null ? commentCount.longValue() : 0L) + 1);
                        } else {
                            Long commentCount2 = stat.getCommentCount();
                            valueOf = Long.valueOf((commentCount2 != null ? commentCount2.longValue() : 1L) - 1);
                        }
                        stat.setCommentCount(valueOf);
                        obj = Result.constructor-impl(Unit.a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th2));
                    }
                    Result.box-impl(obj);
                }
                com.transsion.postdetail.ui.adapter.f fVar3 = roomPostBaseFragment.mAdapter;
                if (fVar3 != null) {
                    fVar3.notifyItemChanged(i);
                }
            }
        } catch (Exception e) {
            a.a.g(wf.a.a, " callback change data fail " + e.getMessage(), false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void observeDelete() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.a4
            public final Object invoke(Object obj) {
                Unit observeDelete$lambda$25;
                observeDelete$lambda$25 = RoomPostBaseFragment.observeDelete$lambda$25(RoomPostBaseFragment.this, (hx.b) obj);
                return observeDelete$lambda$25;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = hx.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeDelete$lambda$25(RoomPostBaseFragment roomPostBaseFragment, hx.b bVar) {
        com.transsion.postdetail.ui.adapter.f fVar;
        List data;
        Intrinsics.h(bVar, "value");
        try {
            com.transsion.postdetail.ui.adapter.f fVar2 = roomPostBaseFragment.mAdapter;
            int i = -1;
            if (fVar2 != null && (data = fVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), bVar.a())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (fVar = roomPostBaseFragment.mAdapter) != null) {
                fVar.G0(i);
            }
            roomPostBaseFragment.checkToShowEmptyView();
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void observeLike() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.s3
            public final Object invoke(Object obj) {
                Unit observeLike$lambda$29;
                observeLike$lambda$29 = RoomPostBaseFragment.observeLike$lambda$29(RoomPostBaseFragment.this, (LikeEvent) obj);
                return observeLike$lambda$29;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeLike$lambda$29(RoomPostBaseFragment roomPostBaseFragment, LikeEvent likeEvent) {
        int i;
        Stat stat;
        Object obj;
        List data;
        List data2;
        int i2 = 1;
        Intrinsics.h(likeEvent, "value");
        try {
            com.transsion.postdetail.ui.adapter.f fVar = roomPostBaseFragment.mAdapter;
            if (fVar != null && (data2 = fVar.getData()) != null) {
                Iterator it = data2.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), likeEvent.getSubjectId())) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            if (i >= 0) {
                com.transsion.postdetail.ui.adapter.f fVar2 = roomPostBaseFragment.mAdapter;
                PostSubjectItem postSubjectItem = (fVar2 == null || (data = fVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i);
                if (postSubjectItem != null) {
                    postSubjectItem.setHasLike(Boolean.valueOf(likeEvent.getLike()));
                }
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Long likeCount = stat.getLikeCount();
                        long longValue = likeCount != null ? likeCount.longValue() : 0L;
                        if (!likeEvent.getLike()) {
                            i2 = -1;
                        }
                        stat.setLikeCount(Long.valueOf(longValue + i2));
                        obj = Result.constructor-impl(Unit.a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th2));
                    }
                    Result.box-impl(obj);
                }
                com.transsion.postdetail.ui.adapter.f fVar3 = roomPostBaseFragment.mAdapter;
                if (fVar3 != null) {
                    fVar3.notifyItemChanged(i, Boolean.valueOf(likeEvent.getLike()));
                }
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void observePublish() {
        if (isNeedInsertPublishPost()) {
            a.a.f(wf.a.a, this.TAG, getClass().getSimpleName() + "--observePublish", false, 4, (Object) null);
            Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.x3
                public final Object invoke(Object obj) {
                    Unit observePublish$lambda$18;
                    observePublish$lambda$18 = RoomPostBaseFragment.observePublish$lambda$18(RoomPostBaseFragment.this, (PublishEvent) obj);
                    return observePublish$lambda$18;
                }
            };
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observePublish$lambda$18(RoomPostBaseFragment roomPostBaseFragment, PublishEvent publishEvent) {
        PostDetailViewModel postDetailViewModel;
        Intrinsics.h(publishEvent, "value");
        ep.g parentFragment = roomPostBaseFragment.getParentFragment();
        if (!(parentFragment instanceof ep.g)) {
            return Unit.a;
        }
        int B = parentFragment.B();
        a.a.f(wf.a.a, roomPostBaseFragment.TAG, roomPostBaseFragment.getClass().getSimpleName() + "--publishevent curTab:" + B + ", fTab:" + roomPostBaseFragment.tabIndex(), false, 4, (Object) null);
        if (roomPostBaseFragment.tabIndex() == B && (postDetailViewModel = roomPostBaseFragment.mDetailViewModel) != null) {
            postDetailViewModel.x(publishEvent.getPostId());
        }
        return Unit.a;
    }

    private final void onCommentClick(PostSubjectItem postItem) {
        openPostDetail(postItem, true);
    }

    private final void onDownloadClick(PostSubjectItem postItem) {
        this.postItem = postItem;
        if (Build.VERSION.SDK_INT >= 29) {
            PostSaveHelper.a.e(postItem);
            return;
        }
        Context context = getContext();
        if (context == null) {
            context = Utils.a();
        }
        if (androidx.core.content.b.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Context context2 = getContext();
            if (context2 == null) {
                context2 = Utils.a();
            }
            if (androidx.core.content.b.checkSelfPermission(context2, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                PostSaveHelper.a.e(postItem);
                return;
            }
        }
        requestPermission();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onLikeClick(PostSubjectItem postItem) {
        int c2 = postItem != null ? Intrinsics.c(postItem.getHasLike(), Boolean.TRUE) : 0;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_tips);
            return;
        }
        RoomPostViewModel roomPostViewModel = this.mViewModel;
        if (roomPostViewModel != null) {
            roomPostViewModel.R(postItem != null ? postItem.getPostId() : null, c2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onShareClick(PostSubjectItem postItem) {
        boolean z;
        ShareDialogFragment a2;
        User user;
        User user2;
        qx.a mLoginApi = getMLoginApi();
        UserInfo i = mLoginApi != null ? mLoginApi.i() : null;
        if ((i != null ? i.getUserId() : null) != null) {
            if (Intrinsics.c(i.getUserId(), (postItem == null || (user2 = postItem.getUser()) == null) ? null : user2.getUserId())) {
                z = true;
                boolean z2 = z;
                ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
                PostType postType = PostType.POST_TYPE;
                String postId = postItem == null ? postItem.getPostId() : null;
                String userId = (postItem != null || (user = postItem.getUser()) == null) ? null : user.getUserId();
                String value = ReportType.POST.getValue();
                String title = postItem == null ? postItem.getTitle() : null;
                Context context = getContext();
                a2 = companion.a(postType, postId, userId, value, (r29 & 16) != 0 ? BuildConfig.FLAVOR : title, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z2, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : context != null ? context.getString(com.transsion.postdetail.R.string.save_video) : null);
                a2.G0(new c(a2, postItem, this));
                a2.show(getChildFragmentManager(), "share");
            }
        }
        z = false;
        boolean z22 = z;
        ShareDialogFragment.Companion companion2 = ShareDialogFragment.INSTANCE;
        PostType postType2 = PostType.POST_TYPE;
        if (postItem == null) {
        }
        if (postItem != null) {
        }
        String value2 = ReportType.POST.getValue();
        if (postItem == null) {
        }
        Context context2 = getContext();
        a2 = companion2.a(postType2, postId, userId, value2, (r29 & 16) != 0 ? BuildConfig.FLAVOR : title, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z22, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : context2 != null ? context2.getString(com.transsion.postdetail.R.string.save_video) : null);
        a2.G0(new c(a2, postItem, this));
        a2.show(getChildFragmentManager(), "share");
    }

    private final void openPostDetail(PostSubjectItem postItem, boolean navigateToComment) {
        if (postItem != null) {
            io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
            if (bVar != null) {
                bVar.i(postItem);
            }
            Media media = postItem.getMedia();
            Navigator K = TheRouter.c(Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").K("page_from", pageName()).z("from_comment", navigateToComment).J("item_object", postItem).K("id", postItem.getPostId()).K("rec_ops", postItem.getOps()).K("item_type", postItem.getItemType());
            Media media2 = postItem.getMedia();
            Navigator.x(K.K("media_type", media2 != null ? media2.getMediaType() : null).z("is_build_in", postItem.getBuiltIn()), requireContext(), (mf.c) null, 2, (Object) null);
        }
    }

    static /* synthetic */ void openPostDetail$default(RoomPostBaseFragment roomPostBaseFragment, PostSubjectItem postSubjectItem, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPostDetail");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        roomPostBaseFragment.openPostDetail(postSubjectItem, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePost(String id) {
        List data;
        com.transsion.postdetail.ui.adapter.f fVar;
        com.transsion.postdetail.ui.adapter.f fVar2 = this.mAdapter;
        if (fVar2 == null || (data = fVar2.getData()) == null) {
            return;
        }
        Iterator it = data.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), id)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0 && (fVar = this.mAdapter) != null) {
            fVar.G0(i);
        }
    }

    private final void requestPermission() {
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, FileHelper.a.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveBuiltInVideo(DownloadBean download) {
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new RoomPostBaseFragment$saveBuiltInVideo$1(download, null), 3, (Object) null);
    }

    private final void showSettingDialog() {
        String string = Utils.a().getString(R$string.permission_deny_down_tip, "\"" + Utils.a().getString(com.transsion.baseui.R.string.base_app_name) + "\"", "\"" + Utils.a().getString(R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        TRDialog.a g = new TRDialog.a().g(string);
        String string2 = Utils.a().getString(R$string.cancel);
        Intrinsics.g(string2, "getString(...)");
        TRDialog.a e = g.e(string2);
        String string3 = Utils.a().getString(R$string.system_settings);
        Intrinsics.g(string3, "getString(...)");
        e.j(string3).f(this).a().show(getChildFragmentManager(), "settings");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$38(RoomPostBaseFragment roomPostBaseFragment) {
        ho.a aVar = roomPostBaseFragment.mFeedVideoManager;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void updateDeletePost(BaseDto<String> data) {
        Object obj;
        List data2;
        com.transsion.postdetail.ui.adapter.f fVar;
        Unit unit = null;
        if (!Intrinsics.c(data != null ? data.getCode() : null, "0")) {
            fh.b.a.e(getString(com.transsion.postdetail.R.string.delete_post_failed));
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.postdetail.ui.adapter.f fVar2 = this.mAdapter;
            if (fVar2 != null && (data2 = fVar2.getData()) != null) {
                Iterator it = data2.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), data.getData())) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && (fVar = this.mAdapter) != null) {
                    fVar.G0(i);
                }
                unit = Unit.a;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Result.box-impl(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRoomCacheData$lambda$46(RoomPostBaseFragment roomPostBaseFragment) {
        ho.a aVar = roomPostBaseFragment.mFeedVideoManager;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void checkToShowEmptyView() {
        if (getContext() == null) {
            return;
        }
        if (yg.l.a.e()) {
            com.transsion.postdetail.ui.adapter.f fVar = this.mAdapter;
            if (fVar != null) {
                fVar.Y0(getEmptyView(false));
                return;
            }
            return;
        }
        com.transsion.postdetail.ui.adapter.f fVar2 = this.mAdapter;
        if (fVar2 != null) {
            fVar2.Y0(getLocalNoNetworkView(false));
        }
    }

    @Override // io.c
    public void doRefresh(Function0<Unit> resultCallback) {
        wn.p pVar;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            wn.p pVar2 = (wn.p) getMViewBinding();
            if (pVar2 == null || (swipeRefreshLayout = pVar2.c) == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        this.mRefreshResultCallback = resultCallback;
        this.mPage = null;
        com.transsion.postdetail.ui.adapter.f fVar = this.mAdapter;
        List data = fVar != null ? fVar.getData() : null;
        if (data != null && !data.isEmpty() && (pVar = (wn.p) getMViewBinding()) != null && (recyclerView = pVar.b) != null) {
            recyclerView.scrollToPosition(0);
        }
        loadData$default(this, false, false, 3, null);
    }

    public String getEmptyDescText() {
        String string = getString(com.transsion.usercenter.R.string.profile_not_content);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public View getLoadingView() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return new View(Utils.a());
        }
        if (this.mLoadingView == null) {
            this.mLoadingView = LayoutInflater.from(activity).inflate(R$layout.layout_room_post_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.mLoadingView;
    }

    protected final com.transsion.postdetail.ui.adapter.f getMAdapter() {
        return this.mAdapter;
    }

    protected final PostDetailViewModel getMDetailViewModel() {
        return this.mDetailViewModel;
    }

    protected final bj.b getMExposureHelper() {
        return this.mExposureHelper;
    }

    protected final String getMGroupId() {
        return this.mGroupId;
    }

    protected final String getMPage() {
        return this.mPage;
    }

    protected final String getMPageFrom() {
        return this.mPageFrom;
    }

    protected final String getMParentTypeName() {
        return this.mParentTypeName;
    }

    protected final int getMPerPage() {
        return this.mPerPage;
    }

    protected final RoomTabItem getMTopTab() {
        return this.mTopTab;
    }

    protected final RoomPostViewModel getMViewModel() {
        return this.mViewModel;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    protected final int getPreLoadNum() {
        return this.preLoadNum;
    }

    protected final String getTAG() {
        return this.TAG;
    }

    public wn.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.p c2 = wn.p.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initListener() {
        observeComment();
        observeDelete();
        observeLike();
        observePublish();
    }

    public void initViewData() {
        SwipeRefreshLayout swipeRefreshLayout;
        com.transsion.postdetail.ui.adapter.f fVar;
        LiveData A;
        androidx.lifecycle.b0 x;
        RecyclerView recyclerView;
        StaggeredGridLayoutManager npaLinearLayoutManager;
        wn.p pVar;
        RecyclerView recyclerView2;
        wn.p pVar2;
        RecyclerView recyclerView3;
        SwipeRefreshLayout swipeRefreshLayout2;
        initExposureHelper();
        if (isSwipeRefreshEnable()) {
            wn.p pVar3 = (wn.p) getMViewBinding();
            if (pVar3 != null && (swipeRefreshLayout2 = pVar3.c) != null) {
                swipeRefreshLayout2.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R.color.bg_01));
                swipeRefreshLayout2.setColorSchemeColors(new int[]{androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R.color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R.color.main_gradient_start)});
                swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.postdetail.ui.fragment.b4
                    public final void a() {
                        c.a.a(RoomPostBaseFragment.this, null, 1, null);
                    }
                });
            }
        } else {
            wn.p pVar4 = (wn.p) getMViewBinding();
            if (pVar4 != null && (swipeRefreshLayout = pVar4.c) != null) {
                swipeRefreshLayout.setEnabled(false);
            }
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.transsion.postdetail.ui.adapter.f fVar2 = new com.transsion.postdetail.ui.adapter.f(requireContext, postAdapterFrom(), this.mExposureHelper, pageName(), this.mPageFrom);
        fVar2.h0().z(true);
        fVar2.h0().y(true);
        fVar2.h0().E(this.preLoadNum);
        t6.f h0 = fVar2.h0();
        PostListLoadMoreView postListLoadMoreView = new PostListLoadMoreView();
        postListLoadMoreView.setOnFailClickCallback(new Function0() { // from class: com.transsion.postdetail.ui.fragment.c4
            public final Object invoke() {
                Unit initViewData$lambda$12$lambda$6$lambda$5;
                initViewData$lambda$12$lambda$6$lambda$5 = RoomPostBaseFragment.initViewData$lambda$12$lambda$6$lambda$5(RoomPostBaseFragment.this);
                return initViewData$lambda$12$lambda$6$lambda$5;
            }
        });
        h0.C(postListLoadMoreView);
        fVar2.h0().D(new r6.f() { // from class: com.transsion.postdetail.ui.fragment.d4
            public final void a() {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$8(RoomPostBaseFragment.this);
            }
        });
        fVar2.R0(new b());
        fVar2.w1(new r6.d() { // from class: com.transsion.postdetail.ui.fragment.e4
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$9(RoomPostBaseFragment.this, baseQuickAdapter, view, i);
            }
        });
        fVar2.l(new int[]{R$id.fl_cover, R$id.tv_room_name, R$id.tv_post_date, R$id.v_post_like, R$id.v_post_comment, R$id.v_post_share, R$id.v_post_download, R$id.cl_subject_content, R$id.tv_room_tag, R$id.clHotComment, R$id.tv_staggered_post_like, R$id.iv_user_avatar, R$id.tv_user_name, R$id.refresh_more});
        fVar2.s1(new r6.b() { // from class: com.transsion.postdetail.ui.fragment.f4
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$11(RoomPostBaseFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = fVar2;
        wn.p pVar5 = (wn.p) getMViewBinding();
        if (pVar5 != null && (recyclerView = pVar5.b) != null) {
            if (isStaggeredPost()) {
                npaLinearLayoutManager = new StaggeredGridLayoutManager(2, 1);
                npaLinearLayoutManager.f0(2);
            } else {
                npaLinearLayoutManager = new NpaLinearLayoutManager(recyclerView.getContext());
            }
            recyclerView.setLayoutManager(npaLinearLayoutManager);
            if (isStaggeredPost() && (pVar = (wn.p) getMViewBinding()) != null && (recyclerView2 = pVar.b) != null && recyclerView2.getItemDecorationCount() == 0 && (pVar2 = (wn.p) getMViewBinding()) != null && (recyclerView3 = pVar2.b) != null) {
                recyclerView3.addItemDecoration(new tf.g(com.blankj.utilcode.util.a0.a(6.0f), true));
            }
            recyclerView.setAdapter(this.mAdapter);
        }
        RoomPostViewModel roomPostViewModel = this.mViewModel;
        if (roomPostViewModel != null && (x = roomPostViewModel.x()) != null) {
            x.j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.p3
                public final Object invoke(Object obj) {
                    Unit initViewData$lambda$15;
                    initViewData$lambda$15 = RoomPostBaseFragment.initViewData$lambda$15(RoomPostBaseFragment.this, (BaseDto) obj);
                    return initViewData$lambda$15;
                }
            }));
        }
        PostDetailViewModel postDetailViewModel = this.mDetailViewModel;
        if (postDetailViewModel != null && (A = postDetailViewModel.A()) != null) {
            A.j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.q3
                public final Object invoke(Object obj) {
                    Unit initViewData$lambda$17;
                    initViewData$lambda$17 = RoomPostBaseFragment.initViewData$lambda$17(RoomPostBaseFragment.this, (PostSubjectItem) obj);
                    return initViewData$lambda$17;
                }
            }));
        }
        if (yg.l.a.e() || (fVar = this.mAdapter) == null) {
            return;
        }
        fVar.Y0(getLocalNoNetworkView(false));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public abstract boolean isNeedInsertPublishPost();

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    public abstract boolean isStaggeredPost();

    public abstract boolean isSwipeRefreshEnable();

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        showLoadingView();
        loadData$default(this, true, false, 2, null);
        com.transsion.postdetail.util.g.a.d(true);
        initFeedVideo();
    }

    public abstract void loadData(boolean isFirstLoad, boolean isRefresh);

    public qi.b newLogViewConfig() {
        return new qi.b(pageName(), false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        HashMap g;
        super.onCreate(savedInstanceState);
        this.mViewModel = (RoomPostViewModel) new androidx.lifecycle.v0(this).a(RoomPostViewModel.class);
        this.mDetailViewModel = (PostDetailViewModel) new androidx.lifecycle.v0(this).a(PostDetailViewModel.class);
        this.mPageFrom = qi.h.a.h();
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        getMHandler().removeCallbacksAndMessages(null);
        ho.a aVar = this.mFeedVideoManager;
        if (aVar != null) {
            aVar.onPageDestroy();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                localLogPause();
                ho.a aVar = this.mFeedVideoManager;
                if (aVar != null) {
                    aVar.b();
                }
            } else {
                logResume();
                ho.a aVar2 = this.mFeedVideoManager;
                if (aVar2 != null) {
                    aVar2.c();
                }
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public abstract void onItemHeaderClick(PostSubjectItem item);

    public abstract String onItemHeaderModuleName();

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    public void onPause() {
        super.onPause();
        localLogPause();
        ho.a aVar = this.mFeedVideoManager;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FileHelper.a.l()) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                PostSaveHelper.a.e(this.postItem);
                return;
            }
            FragmentActivity activity = getActivity();
            Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
            if (ActivityCompat.j(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return;
            }
            showSettingDialog();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onResume() {
        ho.a aVar;
        super.onResume();
        if (!isVisible() || (aVar = this.mFeedVideoManager) == null) {
            return;
        }
        aVar.c();
    }

    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b bVar = com.transsion.ninegridview.helper.b.a;
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
        bVar.a(activity, 101);
    }

    public void openRoomDetail(PostSubjectItem item) {
        Group group;
        String groupId;
        if (item == null || (group = item.getGroup()) == null || (groupId = group.getGroupId()) == null) {
            return;
        }
        Navigator.x(TheRouter.c("/room/detail").K("id", groupId), requireContext(), (mf.c) null, 2, (Object) null);
    }

    public void openSubjectDetail(PostSubjectItem item) {
        Subject subject;
        if (item == null || (subject = item.getSubject()) == null) {
            return;
        }
        Navigator c2 = TheRouter.c("/movie/detail");
        Integer subjectType = subject.getSubjectType();
        Navigator.x(c2.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("ops", subject.getOps()), requireContext(), (mf.c) null, 2, (Object) null);
    }

    public void openUserCenter(PostSubjectItem item) {
        User user;
        if (item == null || (user = item.getUser()) == null) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setAvatar(user.getAvatar());
        userInfo.setUsername(user.getUsername());
        userInfo.setNickname(user.getNickname());
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), requireContext(), (mf.c) null, 2, (Object) null);
    }

    public abstract String pageName();

    public abstract PostAdapterFrom postAdapterFrom();

    public void retryLoadData() {
        com.transsion.postdetail.ui.adapter.f fVar = this.mAdapter;
        List data = fVar != null ? fVar.getData() : null;
        boolean z = data == null || data.isEmpty();
        if (z) {
            showLoadingView();
        }
        loadData$default(this, false, z, 1, null);
    }

    protected final void setMAdapter(com.transsion.postdetail.ui.adapter.f fVar) {
        this.mAdapter = fVar;
    }

    protected final void setMDetailViewModel(PostDetailViewModel postDetailViewModel) {
        this.mDetailViewModel = postDetailViewModel;
    }

    protected final void setMExposureHelper(bj.b bVar) {
        this.mExposureHelper = bVar;
    }

    protected final void setMGroupId(String str) {
        this.mGroupId = str;
    }

    protected final void setMPage(String str) {
        this.mPage = str;
    }

    protected final void setMPageFrom(String str) {
        this.mPageFrom = str;
    }

    protected final void setMParentTypeName(String str) {
        this.mParentTypeName = str;
    }

    protected final void setMPerPage(int i) {
        this.mPerPage = i;
    }

    protected final void setMTopTab(RoomTabItem roomTabItem) {
        this.mTopTab = roomTabItem;
    }

    protected final void setMViewModel(RoomPostViewModel roomPostViewModel) {
        this.mViewModel = roomPostViewModel;
    }

    public final void setOnNumNotExposureListener(ij.q listener) {
        Intrinsics.h(listener, "listener");
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.p(listener);
        }
    }

    public abstract String subpageName();

    public abstract int tabIndex();

    public void updateData(PostSubjectBean bean) {
        List<PostSubjectItem> items;
        PostSubjectItem postSubjectItem;
        String ops;
        HashMap g;
        HashMap g2;
        List arrayList;
        t6.f h0;
        t6.f h02;
        t6.f h03;
        t6.f h04;
        List<PostSubjectItem> items2;
        t6.f h05;
        com.transsion.postdetail.ui.adapter.f fVar;
        t6.f h06;
        t6.f h07;
        com.transsion.postdetail.ui.adapter.f fVar2;
        t6.f h08;
        FrameLayout root;
        SwipeRefreshLayout swipeRefreshLayout;
        wn.p pVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        HashMap g3;
        qi.b logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || (g3 = logViewConfig.g()) == null || !g3.containsKey("ops")) && bean != null && (items = bean.getItems()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(items)) != null && (ops = postSubjectItem.getOps()) != null) {
            qi.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
            }
            if (getParentFragment() instanceof PageStatusFragment) {
                PageStatusFragment parentFragment = getParentFragment();
                Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.baseui.fragment.PageStatusFragment<*>");
                qi.b logViewConfig3 = parentFragment.getLogViewConfig();
                if (logViewConfig3 != null && (g = logViewConfig3.g()) != null) {
                }
            }
        }
        Function0<Unit> function0 = this.mRefreshResultCallback;
        if (function0 != null) {
            function0.invoke();
        }
        showContentView();
        wn.p pVar2 = (wn.p) getMViewBinding();
        if (pVar2 != null && (swipeRefreshLayout = pVar2.c) != null && swipeRefreshLayout.isRefreshing() && (pVar = (wn.p) getMViewBinding()) != null && (swipeRefreshLayout2 = pVar.c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        com.transsion.postdetail.ui.adapter.f fVar3 = this.mAdapter;
        if (fVar3 == null || (arrayList = fVar3.getData()) == null) {
            arrayList = new ArrayList();
        }
        if (bean == null || (items2 = bean.getItems()) == null || items2.isEmpty()) {
            if (arrayList.isEmpty()) {
                checkToShowEmptyView();
                return;
            }
            com.transsion.postdetail.ui.adapter.f fVar4 = this.mAdapter;
            if ((fVar4 == null || (h04 = fVar4.h0()) == null || !h04.r()) ? false : true) {
                PostSubjectItem postSubjectItem2 = (PostSubjectItem) CollectionsKt.v0(arrayList);
                if (postSubjectItem2 != null && postSubjectItem2.isRoomCache()) {
                    com.transsion.postdetail.ui.adapter.f fVar5 = this.mAdapter;
                    if (fVar5 == null || (h03 = fVar5.h0()) == null) {
                        return;
                    }
                    h03.s();
                    return;
                }
                if ((bean != null ? bean.getPager() : null) != null) {
                    Pager pager = bean.getPager();
                    if (!(pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false)) {
                        com.transsion.postdetail.ui.adapter.f fVar6 = this.mAdapter;
                        if (fVar6 == null || (h02 = fVar6.h0()) == null) {
                            return;
                        }
                        t6.f.u(h02, false, 1, (Object) null);
                        return;
                    }
                }
                com.transsion.postdetail.ui.adapter.f fVar7 = this.mAdapter;
                if (fVar7 == null || (h0 = fVar7.h0()) == null) {
                    return;
                }
                h0.v();
                return;
            }
            return;
        }
        ep.g parentFragment2 = getParentFragment();
        if (parentFragment2 instanceof ep.g) {
            parentFragment2.P();
        }
        qi.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            logViewConfig4.k(true);
        }
        Pager pager2 = bean.getPager();
        this.mPage = pager2 != null ? pager2.getNextPage() : null;
        if (bean.getSubject() != null) {
            this.mSubject = bean.getSubject();
        }
        if (bean.getGroup() != null) {
            this.mGroup = bean.getGroup();
        }
        if (bean.getIsRefresh()) {
            com.transsion.postdetail.ui.adapter.f fVar8 = this.mAdapter;
            if (fVar8 != null) {
                fVar8.n1(bean.getItems());
            }
            wn.p pVar3 = (wn.p) getMViewBinding();
            if (pVar3 != null && (root = pVar3.getRoot()) != null) {
                root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.w3
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomPostBaseFragment.updateData$lambda$38(RoomPostBaseFragment.this);
                    }
                });
            }
        } else {
            List<PostSubjectItem> items3 = bean.getItems();
            if (items3 != null) {
                if (this instanceof RoomPostExploreFragment) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : items3) {
                        PostSubjectItem postSubjectItem3 = (PostSubjectItem) obj;
                        if (postSubjectItem3.getGroup() != null || postSubjectItem3.isRoomCacheListStart() || postSubjectItem3.isRoomCacheListEnd()) {
                            arrayList2.add(obj);
                        }
                    }
                    items3 = arrayList2;
                }
                ArrayList arrayList3 = new ArrayList();
                if (arrayList.isEmpty()) {
                    for (PostSubjectItem postSubjectItem4 : items3) {
                        Subject subject = this.mSubject;
                        if (subject != null) {
                            postSubjectItem4.setSubject(subject);
                        }
                        Group group = this.mGroup;
                        if (group != null) {
                            postSubjectItem4.setGroup(group);
                        }
                    }
                    arrayList3.addAll(items3);
                } else {
                    for (PostSubjectItem postSubjectItem5 : items3) {
                        if (!arrayList.contains(postSubjectItem5)) {
                            Subject subject2 = this.mSubject;
                            if (subject2 != null) {
                                postSubjectItem5.setSubject(subject2);
                            }
                            Group group2 = this.mGroup;
                            if (group2 != null) {
                                postSubjectItem5.setGroup(group2);
                            }
                            arrayList3.add(postSubjectItem5);
                        }
                    }
                }
                if (arrayList3.isEmpty()) {
                    com.transsion.postdetail.ui.adapter.f fVar9 = this.mAdapter;
                    if (fVar9 != null && (h05 = fVar9.h0()) != null) {
                        t6.f.u(h05, false, 1, (Object) null);
                    }
                    if (arrayList.isEmpty()) {
                        checkToShowEmptyView();
                    }
                } else {
                    com.transsion.postdetail.ui.adapter.f fVar10 = this.mAdapter;
                    if (fVar10 != null) {
                        fVar10.q(arrayList3);
                    }
                }
            }
        }
        com.transsion.postdetail.ui.adapter.f fVar11 = this.mAdapter;
        if (fVar11 != null && (h07 = fVar11.h0()) != null && h07.r() && (fVar2 = this.mAdapter) != null && (h08 = fVar2.h0()) != null) {
            h08.s();
        }
        if (bean.getPager() != null) {
            Pager pager3 = bean.getPager();
            if ((pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false) || (fVar = this.mAdapter) == null || (h06 = fVar.h0()) == null) {
                return;
            }
            t6.f.u(h06, false, 1, (Object) null);
        }
    }

    public void updateRoomCacheData(int position, PostSubjectBean bean) {
        List arrayList;
        t6.f h0;
        t6.f h02;
        Pager pager;
        t6.f h03;
        List<PostSubjectItem> items;
        t6.f h04;
        com.transsion.postdetail.ui.adapter.f fVar;
        t6.f h05;
        t6.f h06;
        com.transsion.postdetail.ui.adapter.f fVar2;
        t6.f h07;
        FrameLayout root;
        SwipeRefreshLayout swipeRefreshLayout;
        wn.p pVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        Function0<Unit> function0 = this.mRefreshResultCallback;
        if (function0 != null) {
            function0.invoke();
        }
        showContentView();
        wn.p pVar2 = (wn.p) getMViewBinding();
        if (pVar2 != null && (swipeRefreshLayout = pVar2.c) != null && swipeRefreshLayout.isRefreshing() && (pVar = (wn.p) getMViewBinding()) != null && (swipeRefreshLayout2 = pVar.c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        com.transsion.postdetail.ui.adapter.f fVar3 = this.mAdapter;
        if (fVar3 == null || (arrayList = fVar3.getData()) == null) {
            arrayList = new ArrayList();
        }
        if (bean == null || (items = bean.getItems()) == null || items.isEmpty()) {
            if (arrayList.isEmpty()) {
                checkToShowEmptyView();
                return;
            }
            com.transsion.postdetail.ui.adapter.f fVar4 = this.mAdapter;
            if ((fVar4 == null || (h03 = fVar4.h0()) == null || !h03.r()) ? false : true) {
                if ((bean == null || (pager = bean.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                    com.transsion.postdetail.ui.adapter.f fVar5 = this.mAdapter;
                    if (fVar5 == null || (h0 = fVar5.h0()) == null) {
                        return;
                    }
                    h0.v();
                    return;
                }
                com.transsion.postdetail.ui.adapter.f fVar6 = this.mAdapter;
                if (fVar6 == null || (h02 = fVar6.h0()) == null) {
                    return;
                }
                t6.f.u(h02, false, 1, (Object) null);
                return;
            }
            return;
        }
        Pager pager2 = bean.getPager();
        this.mPage = pager2 != null ? pager2.getNextPage() : null;
        if (bean.getSubject() != null) {
            this.mSubject = bean.getSubject();
        }
        if (bean.getGroup() != null) {
            this.mGroup = bean.getGroup();
        }
        if (bean.getIsRefresh()) {
            com.transsion.postdetail.ui.adapter.f fVar7 = this.mAdapter;
            if (fVar7 != null) {
                fVar7.n1(bean.getItems());
            }
            wn.p pVar3 = (wn.p) getMViewBinding();
            if (pVar3 != null && (root = pVar3.getRoot()) != null) {
                root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.z3
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomPostBaseFragment.updateRoomCacheData$lambda$46(RoomPostBaseFragment.this);
                    }
                });
            }
        } else {
            List<PostSubjectItem> items2 = bean.getItems();
            if (items2 != null) {
                if (this instanceof RoomPostExploreFragment) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : items2) {
                        PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
                        if (postSubjectItem.getGroup() != null || postSubjectItem.isRoomCacheListStart() || postSubjectItem.isRoomCacheListEnd()) {
                            arrayList2.add(obj);
                        }
                    }
                    items2 = arrayList2;
                }
                if (items2.isEmpty()) {
                    com.transsion.postdetail.ui.adapter.f fVar8 = this.mAdapter;
                    if (fVar8 != null && (h04 = fVar8.h0()) != null) {
                        t6.f.u(h04, false, 1, (Object) null);
                    }
                    if (arrayList.isEmpty()) {
                        checkToShowEmptyView();
                    }
                } else {
                    int i = position + 1;
                    com.transsion.postdetail.ui.adapter.f fVar9 = this.mAdapter;
                    if (i < (fVar9 != null ? fVar9.getItemCount() : 0)) {
                        com.transsion.postdetail.ui.adapter.f fVar10 = this.mAdapter;
                        if (fVar10 != null) {
                            fVar10.o(i, items2);
                        }
                    } else {
                        com.transsion.postdetail.ui.adapter.f fVar11 = this.mAdapter;
                        if (fVar11 != null) {
                            if (position < 0) {
                                position = 0;
                            }
                            fVar11.o(position, items2);
                        }
                    }
                }
            }
        }
        com.transsion.postdetail.ui.adapter.f fVar12 = this.mAdapter;
        if (fVar12 != null && (h06 = fVar12.h0()) != null && h06.r() && (fVar2 = this.mAdapter) != null && (h07 = fVar2.h0()) != null) {
            h07.s();
        }
        Pager pager3 = bean.getPager();
        if ((pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false) || (fVar = this.mAdapter) == null || (h05 = fVar.h0()) == null) {
            return;
        }
        t6.f.u(h05, false, 1, (Object) null);
    }
}
