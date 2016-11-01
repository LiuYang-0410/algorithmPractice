package base;

/**
 * Created by liuyang on 16/3/18.
 */
public class Sort {

    public void insertSort(int num[]){
        for(int i = 0; i < num.length; i++){
            int copy = num[i],j = i;
            while(j > 0 && copy < num[j-1])
                num[j--] = num[j];
            num[j] = copy;
        }
    }

    public void shellSort(int num[]){
        int dt = num.length/2;
        while(dt > 0){
            for(int group = 0; group < dt; group ++)
                for(int i = group; i < num.length; i+= dt){//每组进行插入排序
                    int copy = num[i],j = i;
                    while(j >= dt && copy < num[j-dt])
                        num[j] = num[j-=dt];
                    num[j] = copy;
                }
            dt /= 2;
        }
    }

    public void bubbleSort(int num[]){
        boolean isSwaped = true;
        for (int i = 0; i < num.length-1 && !isSwaped ; i++){
            isSwaped = false;
            for (int j =num.length-1; j > i ; j++)
                if (num[j] < num[j-1]){
                    int copy = num[j];
                    num[j] = num[j-1];
                    num[j-1] = copy;
                    isSwaped = true;
                }
        }
    }

    public void bubbleSort2(int num[]){
        int lastSwapPos = 0,lastSwapPosTemp = 0;
        for (int i = 0; i < num.length - 1; i++)
        {
            lastSwapPos = lastSwapPosTemp;
            for (int j = num.length - 1; j >lastSwapPos; j--)
            {
                if (num[j - 1] > num[j])
                {
                    int temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;

                    lastSwapPosTemp = j;
                }
            }
            if (lastSwapPos == lastSwapPosTemp)
                break;

        }
    }

    public void bubbleSort3(int num[]){
        int left = 0, right = num.length-1;
        while (left < right){
            int left_temp = left+1,right_temp = right-1;
            for (int i = left; i < right; i++)
                if (num[i] > num[i+1]){
                    int copy = num[i+1];
                    num[i+1] = num[i];
                    num[i] = copy;
                    right_temp = i;
                }
            right = right_temp;
            for (int i = right; i > left ; i--)
                if (num[i] < num[i-1]){
                    int copy = num[i];
                    num[i] = num[i-1];
                    num[i-1] = copy;
                    left_temp = i;
                }
            left = left_temp;
        }
    }

    public void selectSort(int num[]){
        for (int i = 0; i < num.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < num.length; j++)
                if (num[j] < num[i])
                    minIndex = j;
            int copy = num[i];
            num[i] = num[minIndex];
            num[minIndex] = copy;
        }
    }

    private void maxHeapify(int num[],int i,int heapSize){
        int leftIndex = i*2;
        int rightIndex = leftIndex+1;
        int largestIndex = i;
        if(leftIndex <= heapSize && num[leftIndex-1] > num[largestIndex-1])
            largestIndex = leftIndex;
        if(rightIndex <= heapSize && num[rightIndex-1] > num[largestIndex-1])
            largestIndex = rightIndex;
        if(largestIndex != i){
            int copy = num[i-1];
            num[i-1] = num[largestIndex-1];
            num[largestIndex-1] = copy;
            maxHeapify(num,largestIndex,heapSize);
        }
    }
    private void buildMaxHeap(int num[]){//建立最大堆
        for(int i = num.length/2; i>= 0; i--)
            maxHeapify(num,i+1,num.length);
    }
    public void heapSort(int num[]){
        int heapSize = num.length;
        buildMaxHeap(num);
        for (int i = num.length-1; i > 0 ; i--) {
            int copy = num[0];
            num[0] = num[i];
            num[i] = copy;
            maxHeapify(num,1,--heapSize);
        }
    }

    public void mergeSort(int num[]){
        devide(num,0,num.length-1);
    }
    private void devide(int num[],int beginIndex,int endIndex){
        if(beginIndex >= endIndex)
            return;
        int midIndex = (beginIndex + endIndex)/2;
        devide(num,beginIndex,midIndex);
        devide(num,midIndex+1,endIndex);
        merge(num,beginIndex,endIndex,midIndex);
    }
    private void merge(int num[],int beginIndex,int endIndex,int midIndex){
        int temp[] = new int[endIndex-beginIndex+1];
        int i = beginIndex, j = midIndex+1,tempIndex=0;
        while(i<=midIndex && j<=endIndex)
            if(num[i] <= num[j])
                temp[tempIndex++] = num[i++];
            else
                temp[tempIndex++] = num[j++];
        while(i<=midIndex)
            temp[tempIndex++] = num[i++];
        while(j<=endIndex)
            temp[tempIndex++] = num[j++];
        for(int k = 0; k < temp.length;k++)
            num[beginIndex+k] = temp[k];
    }

    public void quickSort(int num[]){
        if (num == null || num.length <= 1)
            return;
        quickSortHelper(num,0,num.length-1);
    }

    private void quickSortHelper(int num[],int beginIndex,int endIndex){
        if (beginIndex >= endIndex)
            return;
        int tempIndex = pivotFromRandom(num,beginIndex,endIndex),pivotIndex = beginIndex;
        int copyBegin = num[beginIndex];
        num[beginIndex] = num[tempIndex];
        num[tempIndex] = copyBegin;
        for (int i = beginIndex+1;i <= endIndex;i++)
            if (num[i] < num[pivotIndex]){
                int copy = num[i];
                num[i] = num[pivotIndex+1];
                num[pivotIndex+1] = num[pivotIndex];
                num[pivotIndex++] = copy;
            }
        quickSortHelper(num,beginIndex,pivotIndex-1);
        quickSortHelper(num,pivotIndex+1,endIndex);
    }

    /**
     * 子数组第一个元素做pivot
     * @param num   数组
     * @param beginIndex 开始
     * @param endIndex  结束
     * @return  pivot的索引
     */
    private int pivotFromBegin(int num[],int beginIndex,int endIndex){
        return beginIndex;
    }

    /**
     * 子数组最后一个元素做pivot
     * @param num   数组
     * @param beginIndex 开始
     * @param endIndex  结束
     * @return  pivot的索引
     */
    private int pivotFromEnd(int num[],int beginIndex,int endIndex){
        return endIndex;
    }

    /**
     * 子数组第一个元素,最后一个元素,中间元素中值居中的做pivot
     * @param num   数组
     * @param beginIndex 开始
     * @param endIndex  结束
     * @return  pivot的索引
     */
    private int pivotFromMiddle(int num[],int beginIndex,int endIndex){
        int midIndex = (beginIndex+endIndex)/2;
        if (num[beginIndex] <= num[midIndex] && num[beginIndex] > num[endIndex]
                || num[beginIndex] <= num[endIndex]  && num[beginIndex] > num[midIndex])
            return beginIndex;
        if (num[midIndex] <= num[endIndex] && num[midIndex] > num[beginIndex]
                || num[midIndex] <= num[beginIndex]  && num[midIndex] > num[endIndex])
            return midIndex;
        return endIndex;
    }

    /**
     * 子数组中随机选取元素做pivot
     * @param num   数组
     * @param beginIndex 开始
     * @param endIndex  结束
     * @return  pivot的索引
     */
    private int pivotFromRandom(int num[],int beginIndex,int endIndex){
        double d = Math.random();
        return (int)(d * (endIndex-beginIndex)+beginIndex);
    }
    
    public int[] countSort(int num[], int k) {
		int temp[] = new int[num.length], count[] = new int[k+1];
		for (int i : num) 
			count[i]++;
		for (int i = 1; i < count.length; i++) 
			count[i] += count[i-1];
		for (int i = num.length-1; i >= 0; i--) 
			temp[count[num[i]]-- -1] = num[i];
		return temp;
	}

    public void printNum(int num[]){
        for (int i : num)
            System.out.print(i+"\t");
        System.out.println("");
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        {
            System.out.println("直接插入排序");
            int num[] = {12,11,10,9,8,7,6,5,4,3,2,1,0};
            sort.insertSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("希尔排序");
            int num[] = {10,20,8,25,35,6,18,30,5,15,28};
            sort.shellSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("冒泡排序1");
            int num[] = {12,11,10,9,8,7,6,5,4,3,2,1,0};
            sort.bubbleSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("冒泡排序2");
            int num[] = {4,3,6,5,2,1,0};
            sort.bubbleSort2(num);
            sort.printNum(num);
        }
        {
            System.out.println("冒泡排序3");
            int num[] = {12,11,10,9,8,7,6,5,4,3,2,1,0};
            sort.bubbleSort3(num);
            sort.printNum(num);
        }
        {
            System.out.println("选择排序");
            int num[] = {12,11,10,9,8,7,6,5,4,3,2,1,0};
            sort.selectSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("堆排序");
            int num[] = {16,4,10,14,7,9,3,2,8,1};
            sort.heapSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("归并排序");
            int num[] = {16,4,10,14,7,9,3,2,8,1};
            sort.mergeSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("快速排序");
            int num[] = {16,4,10,14,7,9,3,2,8,1};
            sort.quickSort(num);
            sort.printNum(num);
        }
        {
            System.out.println("计数排序");
            int num[] = {2,5,3,0,2,3,0,3};
            int ans[] = sort.countSort(num, 5);
            sort.printNum(ans);
        }
    }
}
