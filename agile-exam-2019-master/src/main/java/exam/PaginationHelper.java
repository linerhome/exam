package exam;

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper<I> {
	private List<I> collect = new ArrayList<I>();
	private int item ;
	private int num;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
    	collect.addAll(collection);
    	item = itemsPerPage;
     }

    public int itemCount() {
    	num = collect.size();
    	return num;
    }

    public int pageCount() {
    	int count,score;
    	num= collect.size();
    	score = num/item;
    	if (score == 0) {
    		count = score;
		}else {
			count = score+1;
		}
    	return count;
    }

    public int pageItemCount(int pageIndex) {
        int rest,m;
        num = collect.size();
        rest = num-(pageIndex)*item;
        m = pageCount();
		if (pageIndex >= m || pageIndex < 0) {
			num = -1;
		}else {
			if (rest >= item) {
				num = item;
			} else{
				num = rest;
			}
		}
        return num;
    }

    public int pageIndex(int itemIndex) {
        int num,index;
        num = collect.size();
        if (itemIndex>num || itemIndex<0) {
			index = -1;
		}else {
			index=itemIndex/item;
        }
        return index;
    }
}