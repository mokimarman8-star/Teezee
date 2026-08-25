package androidx.core.view.accessibility;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AccessibilityNodeInfoCompat$AccessibilityActionCompat {
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DRAG_CANCEL;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DRAG_DROP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DRAG_START;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_IME_ENTER;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_MOVE_WINDOW;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_PROGRESS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
    private static final String TAG = "A11yActionCompat";
    final Object mAction;
    protected final AccessibilityViewCommand mCommand;
    private final int mId;
    private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SELECT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(64, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.ASSIGN, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.COLLECTION, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.THISREF, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_IF, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4096, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8192, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COPY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_UNTIL, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PASTE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_WHILE, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CUT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_DO, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_DO_UNTIL, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_EXPAND = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.BLOCK_FOR, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.OPT_SUBTR, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DISMISS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(ASTNode.FQCN, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
        int i = Build.VERSION.SDK_INT;
        ACTION_SHOW_ON_SCREEN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        ACTION_SCROLL_TO_POSITION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
        ACTION_SCROLL_UP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        ACTION_SCROLL_LEFT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        ACTION_SCROLL_DOWN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        ACTION_SCROLL_RIGHT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        if (i >= 29) {
            accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            accessibilityAction = accessibilityAction28;
        } else {
            accessibilityAction = null;
        }
        ACTION_PAGE_UP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
        if (i >= 29) {
            accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction2 = accessibilityAction27;
        } else {
            accessibilityAction2 = null;
        }
        ACTION_PAGE_DOWN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
        if (i >= 29) {
            accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            accessibilityAction3 = accessibilityAction26;
        } else {
            accessibilityAction3 = null;
        }
        ACTION_PAGE_LEFT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction3, R.id.accessibilityActionPageLeft, null, null, null);
        if (i >= 29) {
            accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction4 = accessibilityAction25;
        } else {
            accessibilityAction4 = null;
        }
        ACTION_PAGE_RIGHT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction4, R.id.accessibilityActionPageRight, null, null, null);
        ACTION_CONTEXT_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        if (i >= 24) {
            accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            accessibilityAction5 = accessibilityAction24;
        } else {
            accessibilityAction5 = null;
        }
        ACTION_SET_PROGRESS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction5, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
        if (i >= 26) {
            accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            accessibilityAction6 = accessibilityAction23;
        } else {
            accessibilityAction6 = null;
        }
        ACTION_MOVE_WINDOW = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction6, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
        if (i >= 28) {
            accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction7 = accessibilityAction22;
        } else {
            accessibilityAction7 = null;
        }
        ACTION_SHOW_TOOLTIP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction7, R.id.accessibilityActionShowTooltip, null, null, null);
        if (i >= 28) {
            accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction8 = accessibilityAction21;
        } else {
            accessibilityAction8 = null;
        }
        ACTION_HIDE_TOOLTIP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction8, R.id.accessibilityActionHideTooltip, null, null, null);
        if (i >= 30) {
            accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            accessibilityAction9 = accessibilityAction20;
        } else {
            accessibilityAction9 = null;
        }
        ACTION_PRESS_AND_HOLD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction9, R.id.accessibilityActionPressAndHold, null, null, null);
        if (i >= 30) {
            accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction10 = accessibilityAction19;
        } else {
            accessibilityAction10 = null;
        }
        ACTION_IME_ENTER = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction10, R.id.accessibilityActionImeEnter, null, null, null);
        if (i >= 32) {
            accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            accessibilityAction11 = accessibilityAction18;
        } else {
            accessibilityAction11 = null;
        }
        ACTION_DRAG_START = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction11, R.id.accessibilityActionDragStart, null, null, null);
        if (i >= 32) {
            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction12 = accessibilityAction17;
        } else {
            accessibilityAction12 = null;
        }
        ACTION_DRAG_DROP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction12, R.id.accessibilityActionDragDrop, null, null, null);
        if (i >= 32) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction13 = accessibilityAction16;
        } else {
            accessibilityAction13 = null;
        }
        ACTION_DRAG_CANCEL = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction13, R.id.accessibilityActionDragCancel, null, null, null);
        if (i >= 33) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            accessibilityAction14 = accessibilityAction15;
        } else {
            accessibilityAction14 = null;
        }
        ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction14, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        ACTION_SCROLL_IN_DIRECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 34 ? AccessibilityNodeInfoCompat.c.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence) {
        this(null, i, charSequence, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        this(null, i, charSequence, accessibilityViewCommand, null);
    }

    private AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
        this(null, i, charSequence, null, cls);
    }

    AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object obj) {
        this(obj, 0, null, null, null);
    }

    AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
        this.mId = i;
        this.mCommand = accessibilityViewCommand;
        if (obj == null) {
            this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
        } else {
            this.mAction = obj;
        }
        this.mViewCommandArgumentClass = cls;
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        return new AccessibilityNodeInfoCompat$AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat$AccessibilityActionCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfoCompat$AccessibilityActionCompat) obj;
        Object obj2 = this.mAction;
        return obj2 == null ? accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction == null : obj2.equals(accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction);
    }

    public int getId() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
    }

    public CharSequence getLabel() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
    }

    public int hashCode() {
        Object obj = this.mAction;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean perform(View view, Bundle bundle) {
        AccessibilityViewCommand.CommandArguments newInstance;
        if (this.mCommand == null) {
            return false;
        }
        Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
        AccessibilityViewCommand.CommandArguments commandArguments = null;
        if (cls != null) {
            try {
                newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                e = e;
            }
            try {
                newInstance.setBundle(bundle);
                commandArguments = newInstance;
            } catch (Exception e3) {
                e = e3;
                commandArguments = newInstance;
                Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                return this.mCommand.perform(view, commandArguments);
            }
        }
        return this.mCommand.perform(view, commandArguments);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessibilityActionCompat: ");
        String actionSymbolicName = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
        if (actionSymbolicName.equals("ACTION_UNKNOWN") && getLabel() != null) {
            actionSymbolicName = getLabel().toString();
        }
        sb.append(actionSymbolicName);
        return sb.toString();
    }
}
