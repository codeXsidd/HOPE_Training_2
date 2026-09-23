class SegmentTree{
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

    public static void main(String[]args){
        int[]a={1,2,3,4,5};
        int n=a.length;
        seg_t=new int[4*n];
        seg_build(a, 0, n-1, 1);
        System.out.println(query(1, 0, n-1, 0, 2));
    }
}
