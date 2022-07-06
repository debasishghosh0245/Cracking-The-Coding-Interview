public class AllocateMinimumNumberOfPages{
	
	public static void main(String[] args){
		int[] pages={12,34,67,90};
        int m=2;
		System.out.println(alocateMinNoPages(pages,m));
	}
	
	public static int alocateMinNoPages(int[] pages, int n){
		int low=0;
		int high=0;
		for(int page:pages){
			low=Math.max(page,low);
			high+=page;
		}
		while(low<high){
			int mid=low+(high-low)/2;
			int students=countNumsOfStudentsAllocation(pages,mid);
			if(students<=n){
				high=mid;
			}else{
				low=mid+1;
			}
		}
		return high;
	}
	
	public static int countNumsOfStudentsAllocation(int[] pages,int numsOfPage){
		int sudents=0;
		int totalPage=0;
		for(int i=0;i<pages.length;i++){
			if(totalPage+pages[i]>numsOfPage){
			    sudents++;
				totalPage=pages[i];
			}else{
				totalPage+=pages[i];
			}
		}
		return sudents+1;
	}
}