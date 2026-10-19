package Tree;

public class SegmentTree {
    static int[]seg_t;

    static void seg_build(int[]a, int l, int r, int v){
        if(l==r){
            seg_t[v]=a[l];
            return;
        }
        int mid=(l+r)/2;
        seg_build(a, l, mid, v*2);
        seg_build(a, mid+1, r, v*2+1);
        seg_t[v]=seg_t[v*2]+seg_t[v*2+1];
    }

    static int query(int lamba, int left, int right, int rl, int rr){
        if(rr<left||right<rl) return 0;
        if(rl<=left&&right<=rr) return seg_t[lamba];
        int mid=(left+right)/2;
        int left_ans=query(2*lamba, left, mid, rl, rr);
        int right_ans=query(2*lamba+1, mid+1, right, rl, rr);
        return left_ans+right_ans;
    }

    // Point Update: updates value at pos (0-based) to new_val
    static void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            seg_t[v] = new_val;
            return;
        }
        int tm = (tl + tr) / 2;
        if (pos <= tm) {
            update(2 * v, tl, tm, pos, new_val);
        } else {
            update(2 * v + 1, tm + 1, tr, pos, new_val);
        }
        seg_t[v] = seg_t[2 * v] + seg_t[2 * v + 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int n = a.length;
        seg_t = new int[4 * n];
        seg_build(a, 0, n - 1, 1);

        System.out.println("--- Segment Tree Range Sum & Point Update ---");
        System.out.println("Initial array: [1, 2, 3, 4, 5]");
        System.out.println("Range sum [0, 2] (1 + 2 + 3): " + query(1, 0, n - 1, 0, 2));
        System.out.println("Range sum [1, 4] (2 + 3 + 4 + 5): " + query(1, 0, n - 1, 1, 4));

        System.out.println("\nUpdating index 2 from 3 to 10...");
        update(1, 0, n - 1, 2, 10);
        System.out.println("New Range sum [0, 2] (1 + 2 + 10): " + query(1, 0, n - 1, 0, 2));
        System.out.println("New Range sum [0, 4] (total sum): " + query(1, 0, n - 1, 0, 4));
    }
}
