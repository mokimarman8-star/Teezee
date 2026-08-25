package com.transsion.postdetail.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.DefaultView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsion.postdetail.comment.CommentDeleteDialogFragment;
import com.transsion.postdetail.comment.SocialStatus;
import com.transsion.postdetail.comment.g;
import com.transsion.postdetail.comment.i0;
import com.transsion.postdetail.util.l;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.postdetailapi.CommentTopicType;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.push.bean.MsgStyle;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ë\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002x{B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0007J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0007J#\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0007J\u0019\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b!\u0010\u0013J'\u0010&\u001a\u00020\b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u0007J#\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102JO\u00109\u001a\u00020\b2\u0006\u00103\u001a\u00020\u001026\u00108\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b04H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u00020C2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020(H\u0016¢\u0006\u0004\bI\u0010*J\u0017\u0010L\u001a\u00020\b2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ%\u0010O\u001a\u00020\b2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0018\u00010NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0016¢\u0006\u0004\bQ\u0010\u0007J\u0017\u0010S\u001a\u00020(2\b\u0010R\u001a\u0004\u0018\u00010#¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\bH\u0016¢\u0006\u0004\bU\u0010\u0007J\u000f\u0010V\u001a\u00020\bH\u0016¢\u0006\u0004\bV\u0010\u0007J\u0017\u0010W\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bW\u0010\u0013J#\u0010[\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010Z\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\bH\u0016¢\u0006\u0004\b]\u0010\u0007J1\u0010c\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_2\u0006\u0010b\u001a\u00020_H\u0016¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\be\u0010fJ\u0019\u0010g\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bg\u0010fJI\u0010i\u001a\u00020\b2:\u00108\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\b04¢\u0006\u0004\bi\u0010jJ\u0019\u0010k\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bk\u0010fJ\u0019\u0010l\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bl\u0010fJ\u001f\u0010o\u001a\u00020\b2\u0006\u0010n\u001a\u00020m2\u0006\u0010b\u001a\u00020_H\u0016¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#¢\u0006\u0004\bq\u0010fJ\u000f\u0010r\u001a\u00020\bH\u0016¢\u0006\u0004\br\u0010\u0007J\u0017\u0010t\u001a\u00020\b2\u0006\u0010s\u001a\u00020(H\u0016¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020\bH\u0016¢\u0006\u0004\bv\u0010\u0007R\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bo\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0099\u0001\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bO\u0010\u0098\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009b\u0001R\u0019\u0010¡\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0019\u0010£\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010 \u0001R\u0019\u0010¦\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010¨\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010|R\u0018\u0010ª\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010|R\u0018\u0010¬\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010|R\u001a\u0010Z\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0017\u0010¯\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010|R\u0019\u0010±\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010 \u0001R\u0018\u0010²\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bG\u0010¥\u0001R#\u0010¸\u0001\u001a\u0005\u0018\u00010³\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R*\u0010½\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¹\u0001\u0010\u009b\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0005\b¼\u0001\u0010\u0013R,\u0010Å\u0001\u001a\u0005\u0018\u00010¾\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001e\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010 \u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bg\u0010\u009b\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u009b\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u009b\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010\u009b\u0001R\u001b\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u009b\u0001R\u001a\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010\u009b\u0001R\u001b\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010\u009b\u0001R\u001a\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bk\u0010\u009b\u0001R#\u0010Ý\u0001\u001a\f\u0012\u0005\u0012\u00030Û\u0001\u0018\u00010Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010Ü\u0001R\u0018\u0010Þ\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010|R\u001b\u0010á\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0019\u0010ã\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010¥\u0001R3\u0010æ\u0001\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001c\u0010ê\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001¨\u0006ì\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/CommentFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lwn/h;", "Lcom/transsion/postdetail/comment/i0;", "Lcom/transsion/postdetail/comment/g0;", "Lio/a;", "<init>", "()V", BuildConfig.FLAVOR, "initAdapter", "initExposureHelper", "I0", "initViewModel", "j1", "loadData", "W0", BuildConfig.FLAVOR, "txt", "S0", "(Ljava/lang/String;)V", "showEmpty", "f1", "Lcom/transsion/postdetail/bean/CommentListBean;", "data", "B0", "(Lcom/transsion/postdetail/bean/CommentListBean;)V", "F0", "postId", "a1", "(Ljava/lang/String;Lcom/transsion/postdetail/bean/CommentListBean;)V", "k1", "R0", "commentId", "i1", "Ljava/util/ArrayList;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "Lkotlin/collections/ArrayList;", "list", "D0", "(Ljava/util/ArrayList;)V", BuildConfig.FLAVOR, "checkLogin", "()Z", "h1", "moduleName", "X0", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljo/b;", "operationMenu", "C0", "(Ljo/b;)V", "path", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bucket", "callback", "l1", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lwn/h;", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "u", "(Landroid/view/View;)V", "s", BuildConfig.FLAVOR, "commentCount", "updateCommentCount", "(J)V", "Lkotlin/Function1;", "i", "(Lkotlin/jvm/functions/Function1;)V", "lazyLoadData", "item", "d1", "(Lcom/transsion/moviedetailapi/bean/CommentBean;)Z", "startLoading", "hideLoading", "E0", "Landroid/text/Editable;", "text", "replyItem", "T", "(Landroid/text/Editable;Lcom/transsion/moviedetailapi/bean/CommentBean;)V", "F", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "start", "before", "count", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "R", "(Lcom/transsion/moviedetailapi/bean/CommentBean;)V", "A", "likeStatu", "Z0", "(Lkotlin/jvm/functions/Function2;)V", "H", "Q", "Lun/a;", "info", "f", "(Lun/a;I)V", "c1", "onPause", "hidden", "onHiddenChanged", "(Z)V", "onDestroyView", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mCommentList", "b", "Z", "mNeedUpdate", "Lcom/transsion/postdetail/comment/n;", "c", "Lcom/transsion/postdetail/comment/n;", "mCommentExpandAdapter", "Lcom/transsion/postdetail/comment/m;", "d", "Lcom/transsion/postdetail/comment/m;", "getMCommentEditInputViewHelper", "()Lcom/transsion/postdetail/comment/m;", "setMCommentEditInputViewHelper", "(Lcom/transsion/postdetail/comment/m;)V", "mCommentEditInputViewHelper", "Lcom/transsion/postdetail/util/l;", "e", "Lcom/transsion/postdetail/util/l;", "mSoftKeyBoardListener", "Lcom/transsion/postdetail/comment/g;", "Lcom/transsion/postdetail/comment/g;", "mCommentEditInputDialog", "g", "Lcom/transsion/postdetail/bean/CommentListBean;", "mMsgData", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "h", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", "Lkotlin/jvm/functions/Function1;", "loadResultCallback", "j", "Ljava/lang/String;", "topicId", "k", "topicType", "l", "I", "page", "m", "mPerPage", "n", "J", "mCommentCount", "o", "mShowDownload", "p", "mFromDetail", "q", "isNeedCloseInput", "r", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "replyLoading", "t", "showCommentCount", "lastCreatedTime", "Lqx/a;", "v", "Lkotlin/Lazy;", "getLoginApi", "()Lqx/a;", "loginApi", "w", "getImagePath", "()Ljava/lang/String;", "setImagePath", "imagePath", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "x", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "getOnCommentCountChangedListener", "()Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "b1", "(Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;)V", "onCommentCountChangedListener", "Lbj/b;", "y", "Lbj/b;", "exposureHelper", BuildConfig.FLAVOR, "z", "Ljava/util/Set;", "exposedCommentIds", "B", "pageFrom", "C", "trackId", "D", "previousTrackId", "E", "previousPageVideoId", "ugcVideoId", "G", "pageName", "collectionId", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "Landroidx/activity/result/b;", "loginLaunch", "isNeedShowLoginActivity", "K", "Landroid/text/Editable;", "mText", "L", "mPostClickTime", "M", "Lkotlin/jvm/functions/Function2;", "mCommentCallback", "Lcom/transsion/postdetail/comment/CommentDeleteDialogFragment;", "N", "Lcom/transsion/postdetail/comment/CommentDeleteDialogFragment;", "mCommentDeleteDialog", "O", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentFragment extends BaseFragment<wn.h> implements com.transsion.postdetail.comment.i0, com.transsion.postdetail.comment.g0, io.a {

    /* renamed from: O, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private String commentId;

    /* renamed from: B, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: C, reason: from kotlin metadata */
    private String trackId;

    /* renamed from: D, reason: from kotlin metadata */
    private String previousTrackId;

    /* renamed from: E, reason: from kotlin metadata */
    private String previousPageVideoId;

    /* renamed from: F, reason: from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: G, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: H, reason: from kotlin metadata */
    private String collectionId;

    /* renamed from: I, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isNeedShowLoginActivity;

    /* renamed from: K, reason: from kotlin metadata */
    private Editable mText;

    /* renamed from: L, reason: from kotlin metadata */
    private long mPostClickTime;

    /* renamed from: M, reason: from kotlin metadata */
    private Function2 mCommentCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private CommentDeleteDialogFragment mCommentDeleteDialog;

    /* renamed from: a, reason: from kotlin metadata */
    private RecyclerView mCommentList;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean mNeedUpdate;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.n mCommentExpandAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.m mCommentEditInputViewHelper;

    /* renamed from: e, reason: from kotlin metadata */
    private com.transsion.postdetail.util.l mSoftKeyBoardListener;

    /* renamed from: f, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.g mCommentEditInputDialog;

    /* renamed from: g, reason: from kotlin metadata */
    private CommentListBean mMsgData;

    /* renamed from: h, reason: from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: i, reason: from kotlin metadata */
    private Function1 loadResultCallback;

    /* renamed from: j, reason: from kotlin metadata */
    private String topicId;

    /* renamed from: n, reason: from kotlin metadata */
    private long mCommentCount;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean mFromDetail;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isNeedCloseInput;

    /* renamed from: r, reason: from kotlin metadata */
    private CommentBean replyItem;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean replyLoading;

    /* renamed from: t, reason: from kotlin metadata */
    private int showCommentCount;

    /* renamed from: u, reason: from kotlin metadata */
    private long lastCreatedTime;

    /* renamed from: w, reason: from kotlin metadata */
    private String imagePath;

    /* renamed from: x, reason: from kotlin metadata */
    private b onCommentCountChangedListener;

    /* renamed from: y, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: k, reason: from kotlin metadata */
    private String topicType = CommentTopicType.POST.getValue();

    /* renamed from: l, reason: from kotlin metadata */
    private int page = 1;

    /* renamed from: m, reason: from kotlin metadata */
    private int mPerPage = 10;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean mShowDownload = true;

    /* renamed from: v, reason: from kotlin metadata */
    private final Lazy loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.a
        public final Object invoke() {
            qx.a T0;
            T0 = CommentFragment.T0();
            return T0;
        }
    });

    /* renamed from: z, reason: from kotlin metadata */
    private final Set exposedCommentIds = new LinkedHashSet();

    /* renamed from: com.transsion.postdetail.ui.fragment.CommentFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommentFragment a(String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            Intrinsics.h(str3, "commentId");
            CommentFragment commentFragment = new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString(GifImagePreviewActivity.POST_ID, str);
            bundle.putString("TOPIC_TYPE", str2);
            bundle.putLong("comment_count", j);
            bundle.putBoolean("show_download", z);
            bundle.putBoolean("from_detail", z2);
            bundle.putString("page_from", str4);
            if (str3.length() > 0) {
                bundle.putString("comment_id", str3);
            }
            bundle.putString("TRACK_ID", str5);
            bundle.putString("PREVIOUS_TRACK_ID", str6);
            bundle.putString("PREVIOUS_PAGE_VIDEO_ID", str7);
            bundle.putString("UGC_VIDEO_ID", str8);
            bundle.putString("PAGE_NAME", str9);
            bundle.putString("COLLECTION_ID", str10);
            commentFragment.setArguments(bundle);
            return commentFragment;
        }
    }

    public interface b {
        void a(long j);
    }

    public static final class c implements bj.a {
        final /* synthetic */ String b;

        c(String str) {
            this.b = str;
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            String commentId;
            CommentFragment commentFragment = CommentFragment.this;
            String str = this.b;
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.postdetail.comment.n nVar = commentFragment.mCommentExpandAdapter;
                if (nVar != null && i >= 0 && i < nVar.getItemCount()) {
                    Object f0 = nVar.f0(i);
                    CommentBean commentBean = f0 instanceof CommentBean ? (CommentBean) f0 : null;
                    if (commentBean != null && (commentId = commentBean.getCommentId()) != null && !commentFragment.exposedCommentIds.contains(commentId)) {
                        commentFragment.exposedCommentIds.add(commentId);
                        com.transsion.postdetail.helper.a.a.g(str, i, j, commentId, commentFragment.topicId, commentBean.isSubComment() ? "reply" : "main", commentFragment.pageFrom, commentFragment.trackId, commentFragment.previousTrackId, commentFragment.previousPageVideoId, commentFragment.ugcVideoId, commentFragment.collectionId);
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class d implements yg.m {
        d() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            com.transsion.postdetail.comment.n nVar = CommentFragment.this.mCommentExpandAdapter;
            if (nVar == null || !nVar.q0()) {
                return;
            }
            CommentFragment.this.loadData();
        }

        public void onDisconnected() {
        }
    }

    public static final class e implements l.a {
        e() {
        }

        @Override // com.transsion.postdetail.util.l.a
        public void a(int i) {
            androidx.appcompat.app.w wVar = CommentFragment.this.mCommentEditInputDialog;
            if (wVar != null) {
                CommentFragment commentFragment = CommentFragment.this;
                if (wVar.isShowing() && commentFragment.isNeedCloseInput) {
                    wVar.dismiss();
                }
            }
        }

        @Override // com.transsion.postdetail.util.l.a
        public void b(int i) {
        }
    }

    public static final class f implements CommentDeleteDialogFragment.b {
        f() {
        }

        @Override // com.transsion.postdetail.comment.CommentDeleteDialogFragment.b
        public void a(String str) {
            CommentFragment.this.E0(str);
            CommentFragment.this.X0("delete_comment", str);
        }
    }

    public static final class g implements uu.a {
        final /* synthetic */ Function2 a;

        g(Function2 function2) {
            this.a = function2;
        }

        public void a(String str, long j, long j2) {
            Intrinsics.h(str, "localFilePath");
        }

        public void b(String str, String str2, String str3) {
            Intrinsics.h(str, "localFilePath");
            Intrinsics.h(str2, "url");
            Intrinsics.h(str3, "bucket");
            this.a.invoke(str2, str3);
        }

        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            a.a.g(wf.a.a, "uploadKey: " + str + "; clientMessage:" + str2 + "; serviceMessage: " + str3, false, 2, (Object) null);
        }
    }

    private final void B0(CommentListBean data) {
        List<CommentBean> commentList;
        Pager pager;
        Pager pager2;
        Integer perPage;
        k1(this.mMsgData);
        this.mPerPage = (data == null || (pager2 = data.getPager()) == null || (perPage = pager2.getPerPage()) == null) ? 10 : perPage.intValue();
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        boolean z = false;
        if (nVar != null) {
            if (nVar.h0().r()) {
                nVar.h0().s();
            }
            if ((data == null || (pager = data.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
                nVar.h0().t(false);
            }
        }
        if (data != null && (commentList = data.getCommentList()) != null) {
            for (CommentBean commentBean : commentList) {
                this.showCommentCount += commentBean.getSubCommentCnt() + 1;
                Long createdAt = commentBean.getCreatedAt();
                this.lastCreatedTime = createdAt != null ? createdAt.longValue() : 0L;
            }
        }
        com.transsion.postdetail.comment.n nVar2 = this.mCommentExpandAdapter;
        if (nVar2 != null && nVar2.getItemCount() == 0) {
            z = true;
        }
        if (z) {
            showEmpty();
        } else {
            F0();
        }
    }

    private final void C0(jo.b operationMenu) {
        com.transsion.postdetail.comment.m h;
        List h2 = operationMenu.h();
        if (h2 == null || h2.isEmpty()) {
            return;
        }
        this.imagePath = ((PhotoEntity) h2.get(0)).getLocalPath();
        PhotoEntity photoEntity = (PhotoEntity) h2.get(0);
        com.transsion.postdetail.comment.g gVar = this.mCommentEditInputDialog;
        if (gVar == null || (h = gVar.h()) == null) {
            return;
        }
        h.w(photoEntity);
    }

    private final void D0(ArrayList list) {
        int i;
        int i2;
        List<CommentBean> subComments;
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        List<CommentBean> commentList3;
        List<CommentBean> commentList4;
        List<CommentBean> commentList5;
        List<CommentBean> commentList6;
        CommentListBean commentListBean = this.mMsgData;
        if (commentListBean != null) {
            if ((commentListBean != null && (commentList6 = commentListBean.getCommentList()) != null && commentList6.isEmpty()) || list == null || list.isEmpty()) {
                return;
            }
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.u();
                }
                CommentBean commentBean = (CommentBean) obj;
                CommentListBean commentListBean2 = this.mMsgData;
                if (commentListBean2 == null || (commentList5 = commentListBean2.getCommentList()) == null) {
                    i = -1;
                    i2 = -1;
                } else {
                    int i5 = 0;
                    i = -1;
                    i2 = -1;
                    for (Object obj2 : commentList5) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.u();
                        }
                        CommentBean commentBean2 = (CommentBean) obj2;
                        String commentId = commentBean.getCommentId();
                        if (TextUtils.equals(commentBean2.getCommentId(), commentId)) {
                            i = i5;
                        } else {
                            List<CommentBean> subComments2 = commentBean2.getSubComments();
                            if (subComments2 != null) {
                                int i7 = 0;
                                for (Object obj3 : subComments2) {
                                    int i8 = i7 + 1;
                                    if (i7 < 0) {
                                        CollectionsKt.u();
                                    }
                                    CommentBean commentBean3 = (CommentBean) obj3;
                                    if (TextUtils.equals(commentId, commentBean3 != null ? commentBean3.getCommentId() : null)) {
                                        i = i5;
                                        i2 = i7;
                                    }
                                    i7 = i8;
                                }
                            }
                        }
                        i5 = i6;
                    }
                }
                if (i != -1 || i2 != -1) {
                    if (i == -1 || i2 != -1) {
                        CommentListBean commentListBean3 = this.mMsgData;
                        Integer valueOf = (commentListBean3 == null || (commentList2 = commentListBean3.getCommentList()) == null) ? null : Integer.valueOf(commentList2.size());
                        Intrinsics.e(valueOf);
                        if (valueOf.intValue() >= i) {
                            CommentListBean commentListBean4 = this.mMsgData;
                            CommentBean commentBean4 = (commentListBean4 == null || (commentList = commentListBean4.getCommentList()) == null) ? null : commentList.get(i);
                            CommentBean remove = (commentBean4 == null || (subComments = commentBean4.getSubComments()) == null) ? null : subComments.remove(i2);
                            a.a.f(wf.a.a, "deleteComment list:", "remove childMsg:" + (remove != null ? remove.getContent() : null), false, 4, (Object) null);
                        } else {
                            a.a.f(wf.a.a, "deleteComment list:", "remove childMsg: index ", false, 4, (Object) null);
                        }
                    } else {
                        CommentListBean commentListBean5 = this.mMsgData;
                        Integer valueOf2 = (commentListBean5 == null || (commentList4 = commentListBean5.getCommentList()) == null) ? null : Integer.valueOf(commentList4.size());
                        Intrinsics.e(valueOf2);
                        if (valueOf2.intValue() >= i) {
                            CommentListBean commentListBean6 = this.mMsgData;
                            CommentBean remove2 = (commentListBean6 == null || (commentList3 = commentListBean6.getCommentList()) == null) ? null : commentList3.remove(i);
                            a.a.f(wf.a.a, "deleteComment list:", "remove parentsMsg:" + (remove2 != null ? remove2.getContent() : null), false, 4, (Object) null);
                        } else {
                            a.a.f(wf.a.a, "deleteComment list:", "remove parentsMsg: index ", false, 4, (Object) null);
                        }
                    }
                }
                i3 = i4;
            }
        }
    }

    private final void F0() {
        LinearLayout linearLayout;
        wn.h hVar = (wn.h) getMViewBinding();
        if (hVar == null || (linearLayout = hVar.d) == null) {
            return;
        }
        uf.c.g(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(CommentFragment commentFragment) {
        commentFragment.R0();
    }

    private final void I0() {
        setNetListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(CommentFragment commentFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() != -1) {
            a.a.f(wf.a.a, "loginStatus", "登录失败或者取消", false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "loginStatus", "登录成功", false, 4, (Object) null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
        qx.a loginApi = commentFragment.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(CommentFragment commentFragment, un.b bVar) {
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        commentFragment.hideLoading();
        if (bVar == null) {
            commentFragment.k1(commentFragment.mMsgData);
            return Unit.a;
        }
        CommentListBean commentListBean = commentFragment.mMsgData;
        if (commentListBean == null) {
            commentFragment.k1(commentListBean);
            return Unit.a;
        }
        if (commentListBean != null) {
            CommentListBean b2 = bVar.b();
            commentListBean.setPager(b2 != null ? b2.getPager() : null);
        }
        CommentListBean commentListBean2 = commentFragment.mMsgData;
        if (commentListBean2 != null && (commentList = commentListBean2.getCommentList()) != null) {
            Iterator<T> it = commentList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommentBean commentBean = (CommentBean) it.next();
                if (Intrinsics.c(commentBean.getCommentId(), bVar.a().a())) {
                    CommentListBean b3 = bVar.b();
                    if (b3 != null && (commentList2 = b3.getCommentList()) != null) {
                        List<CommentBean> subComments = commentBean.getSubComments();
                        List<CommentBean> U0 = subComments != null ? CollectionsKt.U0(subComments) : null;
                        if (U0 != null) {
                            U0.addAll(commentList2);
                        }
                        commentBean.setSubComments(U0);
                    }
                }
            }
        }
        commentFragment.k1(commentFragment.mMsgData);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(final CommentFragment commentFragment, CommentBean commentBean) {
        List<CommentBean> commentList;
        List data;
        List<CommentBean> arrayList;
        com.transsion.postdetail.comment.m h;
        com.transsion.postdetail.comment.m h2;
        Editable h3;
        final int i = 0;
        commentFragment.replyLoading = false;
        com.transsion.postdetail.comment.g gVar = commentFragment.mCommentEditInputDialog;
        if (gVar != null) {
            gVar.f();
        }
        if (commentBean == null) {
            fh.b.a.d(R.string.comment_failed);
            return Unit.a;
        }
        fh.b.a.d(R.string.comment_success);
        com.transsion.postdetail.comment.g gVar2 = commentFragment.mCommentEditInputDialog;
        if (gVar2 != null && (h2 = gVar2.h()) != null && (h3 = h2.h()) != null) {
            h3.clear();
        }
        com.transsion.postdetail.comment.g gVar3 = commentFragment.mCommentEditInputDialog;
        if (gVar3 != null && (h = gVar3.h()) != null) {
            h.u();
        }
        com.transsion.postdetail.comment.g gVar4 = commentFragment.mCommentEditInputDialog;
        if (gVar4 != null) {
            gVar4.dismiss();
        }
        if (commentFragment.replyItem == null) {
            CommentListBean commentListBean = commentFragment.mMsgData;
            if (commentListBean == null) {
                commentFragment.mMsgData = new CommentListBean(CollectionsKt.h(new CommentBean[]{commentBean}), new Pager(Boolean.FALSE, "2", MsgStyle.CUSTOM_LEFT_PIC, 10, 1));
            } else {
                if (commentListBean != null) {
                    if (commentListBean == null || (arrayList = commentListBean.getCommentList()) == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(0, commentBean);
                    commentListBean.setCommentList(arrayList);
                }
                commentFragment.mCommentCount++;
            }
            commentFragment.j1();
            commentFragment.k1(commentFragment.mMsgData);
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentFragment.M0(CommentFragment.this);
                    }
                });
            }
        } else {
            commentFragment.mCommentCount++;
            CommentListBean commentListBean2 = commentFragment.mMsgData;
            if (commentListBean2 != null && (commentList = commentListBean2.getCommentList()) != null) {
                Iterator<T> it = commentList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CommentBean commentBean2 = (CommentBean) it.next();
                    if (Intrinsics.c(commentBean2.getCommentId(), commentBean.getRootCommentId())) {
                        List<CommentBean> subComments = commentBean2.getSubComments();
                        if (subComments != null) {
                            subComments.add(commentBean);
                        }
                        commentBean2.setSubCommentCnt(commentBean2.getSubCommentCnt() + 1);
                        commentFragment.j1();
                        commentFragment.k1(commentFragment.mMsgData);
                        com.transsion.postdetail.comment.n nVar = commentFragment.mCommentExpandAdapter;
                        if (nVar != null && (data = nVar.getData()) != null) {
                            Iterator it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next = it2.next();
                                int i2 = i + 1;
                                if (i < 0) {
                                    CollectionsKt.u();
                                }
                                if (Intrinsics.c((p6.a) next, commentBean)) {
                                    RecyclerView recyclerView2 = commentFragment.mCommentList;
                                    if (recyclerView2 != null) {
                                        recyclerView2.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.d
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                CommentFragment.N0(CommentFragment.this, i);
                                            }
                                        });
                                    }
                                } else {
                                    i = i2;
                                }
                            }
                        }
                    }
                }
            }
        }
        gx.b a = gx.b.a.a();
        String commentId = commentBean.getCommentId();
        if (commentId == null) {
            commentId = BuildConfig.FLAVOR;
        }
        a.d(1, commentId, String.valueOf(commentFragment.mCommentCount), commentFragment.topicId);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(CommentFragment commentFragment) {
        RecyclerView.m layoutManager;
        try {
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(CommentFragment commentFragment, int i) {
        RecyclerView.m layoutManager;
        try {
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(i);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(CommentLikeBean commentLikeBean) {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(CommentFragment commentFragment, BaseDto baseDto) {
        commentFragment.E0(baseDto != null ? (String) baseDto.getData() : null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(CommentFragment commentFragment, CommentListBean commentListBean) {
        com.transsion.postdetail.comment.n nVar;
        t6.f h0;
        commentFragment.hideLoading();
        if (commentListBean != null || (((nVar = commentFragment.mCommentExpandAdapter) != null && (nVar == null || nVar.getItemCount() != 0)) || yg.l.a.e())) {
            commentFragment.a1(commentFragment.topicId, commentListBean);
            commentFragment.B0(commentListBean);
            Function1 function1 = commentFragment.loadResultCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            return Unit.a;
        }
        commentFragment.f1();
        com.transsion.postdetail.comment.n nVar2 = commentFragment.mCommentExpandAdapter;
        if (nVar2 != null && (h0 = nVar2.h0()) != null) {
            h0.s();
        }
        Function1 function12 = commentFragment.loadResultCallback;
        if (function12 != null) {
            function12.invoke(Boolean.FALSE);
        }
        return Unit.a;
    }

    private final void R0() {
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            String str = this.topicId;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = this.topicType;
            int i = this.page + 1;
            this.page = i;
            commentViewModel.h(str, str2, "0", String.valueOf(i), this.mPerPage, BuildConfig.FLAVOR);
        }
    }

    private final void S0(String txt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a T0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(CommentFragment commentFragment, jo.b bVar) {
        Intrinsics.h(bVar, "it");
        Integer e2 = bVar.e();
        if (e2 != null && e2.intValue() == 0) {
            commentFragment.C0(bVar);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(CommentBody commentBody, CommentFragment commentFragment, String str, String str2) {
        Intrinsics.h(str, "data");
        Intrinsics.h(str2, "bucket");
        if (str.length() > 0) {
            List<String> imageList = commentBody.getImageList();
            if (imageList != null) {
                imageList.clear();
            }
            List<String> imageList2 = commentBody.getImageList();
            if (imageList2 != null) {
                imageList2.add(str);
            }
            commentBody.setBucket(str2);
            CommentViewModel commentViewModel = commentFragment.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.s(commentFragment.topicType, commentBody);
            }
        }
        return Unit.a;
    }

    private final void W0() {
        if (this.mSoftKeyBoardListener == null) {
            this.mSoftKeyBoardListener = new com.transsion.postdetail.util.l();
        }
        com.transsion.postdetail.util.l lVar = this.mSoftKeyBoardListener;
        if (lVar != null) {
            lVar.d(getActivity(), new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(String moduleName, String commentId) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        String str = this.topicId;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("post_id", str);
        if (commentId == null) {
            commentId = BuildConfig.FLAVOR;
        }
        hashMap.put("comment_id", commentId);
        String str2 = this.pageFrom;
        if (str2 != null && str2.length() != 0) {
            String str3 = this.pageFrom;
            Intrinsics.e(str3);
            hashMap.put("page_from", str3);
        }
        String str4 = this.trackId;
        if (str4 != null) {
            hashMap.put("track_id", str4);
        }
        String str5 = this.previousTrackId;
        if (str5 != null) {
            hashMap.put("parent_track_id", str5);
        }
        String str6 = this.previousPageVideoId;
        if (str6 != null) {
            hashMap.put("parent_content_id", str6);
        }
        String str7 = this.ugcVideoId;
        if (str7 != null) {
            hashMap.put("content_id", str7);
        }
        String str8 = this.pageName;
        if (str8 == null) {
            str8 = this.mFromDetail ? PostDetailFragment.PAGE_NAME : VideoFragment.PAGE_NAME;
        }
        com.transsion.baselib.helper.a.a.i(str8, hashMap);
    }

    static /* synthetic */ void Y0(CommentFragment commentFragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        commentFragment.X0(str, str2);
    }

    private final void a1(String postId, CommentListBean data) {
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        HashMap<String, CommentBean> G1;
        if (this.mMsgData == null) {
            this.topicId = postId;
            this.mMsgData = data;
            return;
        }
        if (data == null || (commentList = data.getCommentList()) == null) {
            return;
        }
        for (CommentBean commentBean : commentList) {
            com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
            if (nVar != null && (G1 = nVar.G1()) != null) {
                if (G1.containsKey(commentBean != null ? commentBean.getCommentId() : null)) {
                }
            }
            CommentListBean commentListBean = this.mMsgData;
            if (commentListBean != null && (commentList2 = commentListBean.getCommentList()) != null) {
                commentList2.add(commentBean);
            }
        }
    }

    private final boolean checkLogin() {
        qx.a loginApi = getLoginApi();
        if (loginApi != null && !loginApi.a()) {
            if (this.loginLaunch == null) {
                this.isNeedShowLoginActivity = true;
            }
            if (isAdded() && !isDetached() && !isRemoving()) {
                androidx.activity.result.b bVar = this.loginLaunch;
                if (bVar == null) {
                    return false;
                }
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                Intent p = loginApi.p(requireContext);
                p.putExtra("title_name", getString(R.string.comment_login_title));
                bVar.a(p);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e1(CommentFragment commentFragment, DialogInterface dialogInterface) {
        if (dialogInterface instanceof com.transsion.postdetail.comment.g) {
            com.transsion.postdetail.comment.m h = ((com.transsion.postdetail.comment.g) dialogInterface).h();
            Editable h2 = h != null ? h.h() : null;
            commentFragment.mText = h2;
            a.a.f(wf.a.a, "CommentFragment", "text=" + ((Object) h2), false, 4, (Object) null);
        }
    }

    private final void f1() {
        TextView textView;
        TextView textView2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.post_detail_no_comment, (ViewGroup) null);
        if (inflate != null && (textView2 = (TextView) inflate.findViewById(R$id.tv_status)) != null) {
            textView2.setText(R.string.base_net_err);
            textView2.setTextSize(12.0f);
            textView2.setVisibility(0);
        }
        if (inflate != null && (textView = (TextView) inflate.findViewById(R$id.tv_retry)) != null) {
            textView.setText(R.string.comment_retry);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.g1(CommentFragment.this, view);
                }
            });
        }
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            Intrinsics.e(inflate);
            nVar.Y0(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(CommentFragment commentFragment, View view) {
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.base_net_err);
        } else {
            commentFragment.loadData();
            Y0(commentFragment, "retry", null, 2, null);
        }
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    private final void h1() {
        com.blankj.utilcode.util.f0.b(300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i1(String commentId) {
        com.transsion.postdetail.comment.n nVar;
        List<p6.a> data;
        List data2;
        List<p6.a> data3;
        String str = commentId;
        ArrayList<CommentBean> arrayList = new ArrayList();
        com.transsion.postdetail.comment.n nVar2 = this.mCommentExpandAdapter;
        if (nVar2 != null && (data3 = nVar2.getData()) != null) {
            for (p6.a aVar : data3) {
                if (aVar instanceof CommentBean) {
                    CommentBean commentBean = (CommentBean) aVar;
                    if (TextUtils.equals(commentBean.getCommentId(), str)) {
                        arrayList.add(aVar);
                    }
                    if (TextUtils.equals(commentBean.getRootCommentId(), str)) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        a.a aVar2 = wf.a.a;
        String obj = arrayList.toString();
        Intrinsics.g(obj, "toString(...)");
        a.a.f(aVar2, "deleteComment list:", obj, false, 4, (Object) null);
        if (!arrayList.isEmpty()) {
            this.mNeedUpdate = true;
            for (CommentBean commentBean2 : arrayList) {
                com.transsion.postdetail.comment.n nVar3 = this.mCommentExpandAdapter;
                if (nVar3 != null && (data2 = nVar3.getData()) != null) {
                    data2.remove(commentBean2);
                }
            }
            com.transsion.postdetail.comment.n nVar4 = this.mCommentExpandAdapter;
            if ((nVar4 != null ? nVar4.getData() : null) != null) {
                com.transsion.postdetail.comment.n nVar5 = this.mCommentExpandAdapter;
                List data4 = nVar5 != null ? nVar5.getData() : null;
                if (data4 != null && !data4.isEmpty()) {
                    com.transsion.postdetail.comment.n nVar6 = this.mCommentExpandAdapter;
                    if (nVar6 != null && (data = nVar6.getData()) != null) {
                        for (p6.a aVar3 : data) {
                            if (aVar3 instanceof CommentBean) {
                                Long createdAt = ((CommentBean) aVar3).getCreatedAt();
                                long longValue = createdAt != null ? createdAt.longValue() : 0L;
                                this.lastCreatedTime = longValue;
                                a.a.f(wf.a.a, "deleteComment list:", "mCommentExpandAdapter createdTime:" + longValue, false, 4, (Object) null);
                            }
                        }
                    }
                    nVar = this.mCommentExpandAdapter;
                    if (nVar != null) {
                        nVar.notifyDataSetChanged();
                    }
                    this.mCommentCount -= arrayList.size();
                    j1();
                    D0(arrayList);
                }
            }
            this.lastCreatedTime = 0L;
            a.a.f(wf.a.a, "deleteComment list:", "mCommentExpandAdapter null", false, 4, (Object) null);
            nVar = this.mCommentExpandAdapter;
            if (nVar != null) {
            }
            this.mCommentCount -= arrayList.size();
            j1();
            D0(arrayList);
        }
        gx.b a = gx.b.a.a();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        a.d(2, str, String.valueOf(this.mCommentCount), this.topicId);
    }

    private final void initAdapter() {
        Context context;
        if (this.mCommentExpandAdapter != null || (context = getContext()) == null) {
            return;
        }
        com.transsion.postdetail.comment.n nVar = new com.transsion.postdetail.comment.n(this);
        t6.f h0 = nVar.h0();
        h0.z(true);
        h0.y(true);
        h0.D(new r6.f() { // from class: com.transsion.postdetail.ui.fragment.i
            public final void a() {
                CommentFragment.H0(CommentFragment.this);
            }
        });
        this.mCommentExpandAdapter = nVar;
        RecyclerView recyclerView = this.mCommentList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        RecyclerView recyclerView2 = this.mCommentList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mCommentExpandAdapter);
        }
        RecyclerView recyclerView3 = this.mCommentList;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new com.transsion.postdetail.comment.u());
        }
    }

    private final void initExposureHelper() {
        if (this.exposureHelper != null) {
            return;
        }
        String str = this.pageName;
        if (str == null) {
            str = this.mFromDetail ? PostDetailFragment.PAGE_NAME : VideoFragment.PAGE_NAME;
        }
        bj.b bVar = new bj.b(0.6f, new c(str), false, 4, null);
        bVar.n(2);
        this.exposureHelper = bVar;
        RecyclerView recyclerView = this.mCommentList;
        if (recyclerView != null) {
            Intrinsics.e(bVar);
            recyclerView.addOnScrollListener(bVar);
        }
    }

    private final void initViewModel() {
        CommentViewModel a = new androidx.lifecycle.v0(this).a(CommentViewModel.class);
        a.k().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.k
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = CommentFragment.Q0(CommentFragment.this, (CommentListBean) obj);
                return Q0;
            }
        }));
        a.l().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.l
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = CommentFragment.K0(CommentFragment.this, (un.b) obj);
                return K0;
            }
        }));
        a.n().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.m
            public final Object invoke(Object obj) {
                Unit L0;
                L0 = CommentFragment.L0(CommentFragment.this, (CommentBean) obj);
                return L0;
            }
        }));
        a.m().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.n
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = CommentFragment.O0((CommentLikeBean) obj);
                return O0;
            }
        }));
        a.j().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.b
            public final Object invoke(Object obj) {
                Unit P0;
                P0 = CommentFragment.P0(CommentFragment.this, (BaseDto) obj);
                return P0;
            }
        }));
        this.mCommentViewModel = a;
    }

    private final void j1() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        wn.h hVar = (wn.h) getMViewBinding();
        if (hVar != null && (appCompatTextView2 = hVar.e) != null) {
            appCompatTextView2.setVisibility(this.mFromDetail ? 8 : 0);
        }
        wn.h hVar2 = (wn.h) getMViewBinding();
        if (hVar2 != null && (appCompatTextView = hVar2.e) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = getString(R.string.comments);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{com.transsion.baseui.util.j.a(this.mCommentCount)}, 1));
            Intrinsics.g(format, "format(...)");
            appCompatTextView.setText(format);
        }
        b bVar = this.onCommentCountChangedListener;
        if (bVar != null) {
            bVar.a(this.mCommentCount);
        }
    }

    private final void k1(CommentListBean data) {
        initAdapter();
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            nVar.K1(data);
        }
    }

    private final void l1(String path, Function2 callback) {
        uu.c.a.f(path, UploadFileType.OBJECT_NAME_IMAGE, true, new g(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        com.transsion.postdetail.comment.n nVar;
        if (this.mMsgData == null && (((nVar = this.mCommentExpandAdapter) == null || (nVar != null && nVar.getItemCount() == 0)) && !yg.l.a.e())) {
            f1();
            return;
        }
        startLoading();
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            String str = this.topicId;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = this.topicType;
            String valueOf = String.valueOf(this.page);
            int i = this.mPerPage;
            String str3 = this.commentId;
            commentViewModel.h(str, str2, "0", valueOf, i, str3 == null ? BuildConfig.FLAVOR : str3);
        }
    }

    private final void showEmpty() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        DefaultView defaultView = new DefaultView(requireContext);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DES);
        String string = getString(R.string.comment_empty);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setDefaultImage(R$drawable.icon_comment_empty);
        defaultView.setMinimumHeight(com.blankj.utilcode.util.a0.a(250.0f));
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            nVar.Y0(defaultView);
        }
    }

    @Override // com.transsion.postdetail.comment.g0
    public void A(CommentBean item) {
        S0("点赞");
        if (item == null || item.getCommentId() == null) {
            return;
        }
        String commentId = item.getCommentId();
        Boolean likeStatu = item.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(!Intrinsics.c(likeStatu, bool) ? 1 : 0));
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            commentViewModel.q(commentLikeBody);
        }
        X0(Intrinsics.c(item.getIsHot(), bool) ? Intrinsics.c(item.getLikeStatu(), bool) ? "like_hot_comment" : "dislike_hot_comment" : Intrinsics.c(item.getLikeStatu(), bool) ? "like_comment" : "dislike_comment", item.getCommentId());
        Function2 function2 = this.mCommentCallback;
        if (function2 != null) {
        }
    }

    public final void E0(String commentId) {
        try {
            i1(commentId);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "deleteComment", message, false, 4, (Object) null);
            }
        }
    }

    @Override // com.transsion.postdetail.comment.i0
    public void F() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, 0, 1, null);
    }

    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public wn.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.h c2 = wn.h.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.postdetail.comment.g0
    public void H(CommentBean item) {
        com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
        CommentBean i = mVar != null ? mVar.i() : null;
        if (!Intrinsics.c(i != null ? i.getCommentId() : null, item != null ? item.getCommentId() : null)) {
            com.transsion.postdetail.comment.m mVar2 = this.mCommentEditInputViewHelper;
            if (mVar2 != null) {
                mVar2.t();
            }
            com.transsion.postdetail.comment.m mVar3 = this.mCommentEditInputViewHelper;
            if (mVar3 != null) {
                mVar3.v(item);
            }
        }
        d1(item);
        Y0(this, "reply", null, 2, null);
    }

    @Override // com.transsion.postdetail.comment.g0
    public void Q(CommentBean item) {
        c1(item);
    }

    @Override // com.transsion.postdetail.comment.g0
    public void R(CommentBean item) {
        String uid;
        S0("跳转个人页面");
        if (item != null && (uid = item.getUid()) != null) {
            Navigator.x(TheRouter.c("/profile/user_profile").K("userId", uid), requireContext(), (mf.c) null, 2, (Object) null);
        }
        Y0(this, "avatar_comment", null, 2, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v5 java.lang.String, still in use, count: 2, list:
          (r6v5 java.lang.String) from 0x00b6: IF  (r6v5 java.lang.String) == (null java.lang.String)  -> B:39:0x00a5 A[HIDDEN]
          (r6v5 java.lang.String) from 0x00b9: PHI (r6v4 java.lang.String) = (r6v3 java.lang.String), (r6v5 java.lang.String) binds: [B:75:0x00bc, B:73:0x00b6] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1083)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1083)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1083)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1083)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1083)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @Override // com.transsion.postdetail.comment.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T(android.text.Editable r25, com.transsion.flow.bean.CommentBean r26) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.CommentFragment.T(android.text.Editable, com.transsion.moviedetailapi.bean.CommentBean):void");
    }

    public final void Z0(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.mCommentCallback = callback;
    }

    @Override // com.transsion.postdetail.comment.i0, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        i0.a.a(this, editable);
    }

    public final void b1(b bVar) {
        this.onCommentCountChangedListener = bVar;
    }

    @Override // com.transsion.postdetail.comment.i0, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        i0.a.b(this, charSequence, i, i2, i3);
    }

    public final void c1(CommentBean item) {
        FragmentManager childFragmentManager;
        UserInfo i;
        if (item == null) {
            return;
        }
        String content = item.getContent();
        String str = null;
        this.mCommentDeleteDialog = content != null ? CommentDeleteDialogFragment.INSTANCE.a(item.getCommentId(), this.topicType, content) : null;
        try {
            if (isAdded() && (childFragmentManager = getChildFragmentManager()) != null) {
                childFragmentManager.g0();
                CommentDeleteDialogFragment commentDeleteDialogFragment = this.mCommentDeleteDialog;
                if ((commentDeleteDialogFragment != null && commentDeleteDialogFragment.isAdded()) || childFragmentManager.k0("commentDelete") != null) {
                    return;
                }
                String uid = item.getUid();
                qx.a loginApi = getLoginApi();
                if (loginApi != null && (i = loginApi.i()) != null) {
                    str = i.getUserId();
                }
                boolean equals = TextUtils.equals(uid, str);
                CommentDeleteDialogFragment commentDeleteDialogFragment2 = this.mCommentDeleteDialog;
                if (commentDeleteDialogFragment2 != null) {
                    commentDeleteDialogFragment2.o0(new f());
                }
                CommentDeleteDialogFragment commentDeleteDialogFragment3 = this.mCommentDeleteDialog;
                if (commentDeleteDialogFragment3 != null) {
                    commentDeleteDialogFragment3.q0(childFragmentManager, "commentDelete", equals);
                }
            }
            h1();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [android.app.Dialog, com.transsion.postdetail.comment.g] */
    public final boolean d1(CommentBean item) {
        vn.a g2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return false;
        }
        if (this.mCommentEditInputDialog == null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            g.a c2 = new g.a(requireContext).d(300).c(this);
            com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
            ?? a = c2.b(mVar != null ? mVar.h() : null).e(item).a();
            this.mCommentEditInputDialog = a;
            if (a != 0) {
                a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.transsion.postdetail.ui.fragment.j
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        CommentFragment.e1(CommentFragment.this, dialogInterface);
                    }
                });
            }
        }
        androidx.appcompat.app.w wVar = this.mCommentEditInputDialog;
        if (wVar == null || wVar.isShowing()) {
            return true;
        }
        com.transsion.postdetail.comment.g gVar = this.mCommentEditInputDialog;
        if (gVar != null) {
            gVar.j(this.mText);
        }
        com.transsion.postdetail.comment.g gVar2 = this.mCommentEditInputDialog;
        if (gVar2 != null && (g2 = gVar2.g()) != null) {
            g2.i(item);
        }
        androidx.appcompat.app.w wVar2 = this.mCommentEditInputDialog;
        if (wVar2 == null) {
            return true;
        }
        wVar2.show();
        return true;
    }

    @Override // com.transsion.postdetail.comment.g0
    public void f(un.a info, int count) {
        Intrinsics.h(info, "info");
        S0("加载更多");
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            commentViewModel.p(info, this.topicType, String.valueOf(info.c()), this.mPerPage);
        }
    }

    public void hideLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        wn.h hVar = (wn.h) getMViewBinding();
        if (hVar != null && (recyclerView = hVar.c) != null) {
            uf.c.k(recyclerView);
        }
        wn.h hVar2 = (wn.h) getMViewBinding();
        if (hVar2 == null || (linearLayout = hVar2.d) == null) {
            return;
        }
        uf.c.g(linearLayout);
    }

    @Override // io.a
    public void i(Function1 callback) {
        this.loadResultCallback = callback;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        this.mCommentList = view.findViewById(R$id.comment_list);
        initAdapter();
        W0();
        initExposureHelper();
        S0("onViewCreated");
        initViewModel();
        j1();
        I0();
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.postdetail.ui.fragment.g
            public final void a(Object obj) {
                CommentFragment.J0(CommentFragment.this, (ActivityResult) obj);
            }
        });
    }

    public void lazyLoadData() {
        CommentListBean commentListBean = this.mMsgData;
        if (commentListBean == null) {
            loadData();
        } else {
            B0(commentListBean);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.topicId = arguments.getString(GifImagePreviewActivity.POST_ID);
            String string = arguments.getString("TOPIC_TYPE");
            if (string == null) {
                string = CommentTopicType.POST.getValue();
            }
            this.topicType = string;
            this.mCommentCount = arguments.getLong("comment_count");
            this.mShowDownload = arguments.getBoolean("show_download", true);
            this.mFromDetail = arguments.getBoolean("from_detail", false);
            this.commentId = arguments.getString("comment_id", BuildConfig.FLAVOR);
            this.pageFrom = arguments.getString("page_from");
            this.trackId = arguments.getString("TRACK_ID");
            this.previousTrackId = arguments.getString("PREVIOUS_TRACK_ID");
            this.previousPageVideoId = arguments.getString("PREVIOUS_PAGE_VIDEO_ID");
            this.ugcVideoId = arguments.getString("UGC_VIDEO_ID");
            this.pageName = arguments.getString("PAGE_NAME");
            this.collectionId = arguments.getString("COLLECTION_ID");
        }
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.f
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = CommentFragment.U0(CommentFragment.this, (jo.b) obj);
                return U0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        bj.b bVar = this.exposureHelper;
        if (bVar != null && (recyclerView = this.mCommentList) != null) {
            recyclerView.removeOnScrollListener(bVar);
        }
        this.exposureHelper = null;
        this.exposedCommentIds.clear();
    }

    public void onHiddenChanged(boolean hidden) {
        bj.b bVar;
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (!hidden || (bVar = this.exposureHelper) == null) {
            return;
        }
        bVar.f();
    }

    public void onPause() {
        super.onPause();
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        S0("onTextChanged");
    }

    @Override // io.a
    public boolean s() {
        return d1(null);
    }

    public void startLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        wn.h hVar = (wn.h) getMViewBinding();
        if (hVar != null && (recyclerView = hVar.c) != null) {
            uf.c.g(recyclerView);
        }
        wn.h hVar2 = (wn.h) getMViewBinding();
        if (hVar2 == null || (linearLayout = hVar2.d) == null) {
            return;
        }
        uf.c.k(linearLayout);
    }

    @Override // io.a
    public void u(View view) {
        if (view == null || this.mCommentEditInputViewHelper != null) {
            return;
        }
        Dialog dialog = null;
        boolean z = false;
        this.mCommentEditInputViewHelper = new com.transsion.postdetail.comment.m(view, dialog, new SocialStatus(false, false, false, this.mShowDownload, 7, null), z, 10, null);
        vn.a aVar = new vn.a();
        aVar.h(300);
        aVar.f(this);
        aVar.g(null);
        com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
        if (mVar != null) {
            mVar.k(aVar);
        }
    }

    @Override // io.a
    public void updateCommentCount(long commentCount) {
        this.mCommentCount = commentCount;
        j1();
    }
}
