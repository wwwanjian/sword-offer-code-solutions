import java.util.ArrayList;
import java.util.List;

/**
 * @author wwwanjian
 * @className Problem_41
 * @description TODO
 * @create 2019/5/9 11:13
 * @vsersion 1.0
 **/
//从数据流中得到中位数
public class Problem_41 {
    public static void main(String args[]) {
        //获取数据流
        int[] arr = {1,2,3,4,5};
        //获得中位数
        ArrayOfDataStraem ads = new ArrayOfDataStraem();
        ads.insert(0);
        ads.insert(1);
        ads.insert(2);
        ads.insert(3);
        ads.insert(4);
        ads.insert(5);
        ads.insert(5);
        //打印结果
        System.out.println(ads.getMedium());
    }
    //插入数据并获得中位数
    //思路1：使用数组或者列表存储，每次插入后都进行排序，然后取中位数，O(n)
    //思路2：把数据分平均两部分，左部分构建大顶堆，右部分构建小顶堆
}
//处理插入数据和找到中位数
class ArrayOfDataStraem{
    private List<Integer> minHeap = new ArrayList<>();
    private List<Integer> maxHeap = new ArrayList<>();
    public ArrayOfDataStraem(){}
    //插入，然后调整大顶堆
    public void insert(int value){
        //判断应该插入哪边
        if (minHeap.size()<maxHeap.size()){
            if (value<maxHeap.get(0)){
                //保证右边都大于左边
                minHeap.add(maxHeap.get(0));
                maxHeap.set(0,value);
                //调整小顶堆
                adjustMinHeap();
                //调整大顶堆
                adjustMaxHeap();
            }
            else {
                //插入右边
                minHeap.add(value);
                //调整小顶堆
                adjustMinHeap();
            }
        }
        else {
            if (minHeap.size()!=0&&value>minHeap.get(0)){
                maxHeap.add(minHeap.get(0));
                minHeap.set(0,value);
                //调整大顶堆
                adjustMaxHeap();
                //调整小顶堆
                adjustMinHeap();
            }
            else {
                //插入左边
                maxHeap.add(value);
                //调整大顶堆
                adjustMaxHeap();
            }
        }
    }
    //获得中位数
    public int getMedium(){
        //没有数据进来
        if (minHeap.size()==0&&maxHeap.size()==0){
            return -1;
        }
        else if (((minHeap.size()+maxHeap.size())&1)==0){//偶数项
            return (minHeap.get(0)+maxHeap.get(0))>>1;
        }
        else {
            return maxHeap.get(0);
        }
    }
    //调整大顶堆
    private void adjustMaxHeap(){
        for (int k = (maxHeap.size()-2)/2;k>=0;--k){
            int temp = maxHeap.get(k);
            int length = maxHeap.size();
            for(int i=2*k+1; i<length; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
                if(i+1<length && maxHeap.get(i)<maxHeap.get(i+1)){  //取节点较大的子节点的下标
                    i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
                }
                if(temp>=maxHeap.get(i)){  //根节点 >=左右子女中关键字较大者，调整结束
                    break;
                }else{   //根节点 <左右子女中关键字较大者
                    maxHeap.set(k,maxHeap.get(i));  //将左右子结点中较大值array[i]调整到双亲节点上
                    k = i; //【关键】修改k值，以便继续向下调整
                }
            }
            maxHeap.set(k,temp);  //被调整的结点的值放人最终位置
        }
    }

    //调整小顶堆
    private void adjustMinHeap(){
        for (int k = (minHeap.size()-2)/2;k>=0;--k){
            int temp = minHeap.get(k);
            int length = minHeap.size();
            for(int i=2*k+1; i<length; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
                if(i+1<length && minHeap.get(i)>minHeap.get(i+1)){  //取节点较小的子节点的下标
                    i++;   //如果节点的右孩子<左孩子，则取右孩子节点的下标
                }
                if(temp<=minHeap.get(i)){  //根节点 <=左右子女中关键字较大者，调整结束
                    break;
                }else{   //根节点 >左右子女中关键字较大者
                    minHeap.set(k,minHeap.get(i));  //将左右子结点中较大值array[i]调整到双亲节点上
                    k = i; //【关键】修改k值，以便继续向下调整
                }
            }
            minHeap.set(k,temp);  //被调整的结点的值放人最终位置
        }
    }
}