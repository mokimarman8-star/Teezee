package com.cloud.tmc.kernel.node;

import android.os.Parcelable;
import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.security.Accessor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface Node extends Accessor, Parcelable {
    void addFixedView(View view);

    @Nullable
    <T extends Node> T bubbleFindNode(Class<T> cls);

    Node getChild(long j);

    Node getChildAt(int i);

    int getChildCount();

    int getIndexOfChild(Node node);

    long getNodeId();

    Node getParentNode();

    boolean isChildless();

    void onFinalized();

    void onInitialized();

    Node peekChild();

    Node popChild();

    void pushChild(Node node);

    boolean removeChild(Node node);

    void setParentNode(Node node);
}
