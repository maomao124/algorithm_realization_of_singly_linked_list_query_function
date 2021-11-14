/**
 * Project name(项目名称)：算法_单链表的实现之查询功能
 * Package(包名): PACKAGE_NAME
 * Class(类名): q_sort
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/14
 * Time(创建时间)： 21:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class q_sort
{
    public void quickSort(int[] array, int high, int low)
    {
        int i, j, temp;
        i = high;//高端下标
        j = low;//低端下标
        temp = array[i];//取第一个元素为标准元素。

        while (i < j)
        {//递归出口是 low>=high
            while (i < j && temp > array[j])
            {
                j--;
            }
            if (i < j)
            {
                array[i] = array[j];
                i++;
            }
            while (i < j && temp < array[i])
            {
                i++;
            }
            if (i < j)
            {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;

        if (high < i)
        {
            quickSort(array, high, i - 1);
        }
        if (i < low)
        {
            quickSort(array, i + 1, low);
        }
    }
}
