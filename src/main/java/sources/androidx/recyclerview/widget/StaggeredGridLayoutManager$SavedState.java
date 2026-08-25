package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$SavedState> CREATOR = new a();
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StaggeredGridLayoutManager$SavedState createFromParcel(Parcel parcel) {
            return new StaggeredGridLayoutManager$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StaggeredGridLayoutManager$SavedState[] newArray(int i5) {
            return new StaggeredGridLayoutManager$SavedState[i5];
        }
    }

    public StaggeredGridLayoutManager$SavedState() {
    }

    StaggeredGridLayoutManager$SavedState(Parcel parcel) {
        this.mAnchorPosition = parcel.readInt();
        this.mVisibleAnchorPosition = parcel.readInt();
        int readInt = parcel.readInt();
        this.mSpanOffsetsSize = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            this.mSpanOffsets = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        this.mSpanLookupSize = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            this.mSpanLookup = iArr2;
            parcel.readIntArray(iArr2);
        }
        this.mReverseLayout = parcel.readInt() == 1;
        this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        this.mLastLayoutRTL = parcel.readInt() == 1;
        this.mFullSpanItems = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem.class.getClassLoader());
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState) {
        this.mSpanOffsetsSize = staggeredGridLayoutManager$SavedState.mSpanOffsetsSize;
        this.mAnchorPosition = staggeredGridLayoutManager$SavedState.mAnchorPosition;
        this.mVisibleAnchorPosition = staggeredGridLayoutManager$SavedState.mVisibleAnchorPosition;
        this.mSpanOffsets = staggeredGridLayoutManager$SavedState.mSpanOffsets;
        this.mSpanLookupSize = staggeredGridLayoutManager$SavedState.mSpanLookupSize;
        this.mSpanLookup = staggeredGridLayoutManager$SavedState.mSpanLookup;
        this.mReverseLayout = staggeredGridLayoutManager$SavedState.mReverseLayout;
        this.mAnchorLayoutFromEnd = staggeredGridLayoutManager$SavedState.mAnchorLayoutFromEnd;
        this.mLastLayoutRTL = staggeredGridLayoutManager$SavedState.mLastLayoutRTL;
        this.mFullSpanItems = staggeredGridLayoutManager$SavedState.mFullSpanItems;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void invalidateAnchorPositionInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mAnchorPosition = -1;
        this.mVisibleAnchorPosition = -1;
    }

    void invalidateSpanInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mSpanLookupSize = 0;
        this.mSpanLookup = null;
        this.mFullSpanItems = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.mAnchorPosition);
        parcel.writeInt(this.mVisibleAnchorPosition);
        parcel.writeInt(this.mSpanOffsetsSize);
        if (this.mSpanOffsetsSize > 0) {
            parcel.writeIntArray(this.mSpanOffsets);
        }
        parcel.writeInt(this.mSpanLookupSize);
        if (this.mSpanLookupSize > 0) {
            parcel.writeIntArray(this.mSpanLookup);
        }
        parcel.writeInt(this.mReverseLayout ? 1 : 0);
        parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
        parcel.writeList(this.mFullSpanItems);
    }
}
