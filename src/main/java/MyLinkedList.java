import java.util.Arrays;

/**
 * Project name(项目名称)：算法_单链表的实现之查询功能
 * Package(包名): PACKAGE_NAME
 * Class(类名): MyLinkedList
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/14
 * Time(创建时间)： 21:03
 * Version(版本): 1.0
 * Description(描述)： 在上一关的基础上继续完善单链表的功能，实现获取指定位置元素的功能。
 */

public class MyLinkedList
{

    private Node first;//头结点，不存数据
    private Node last;//指向链表的最后一个节点
    private int size;

    public MyLinkedList()
    {
        size = 0;
        first = new Node(0, null);
        last = null;
    }

    /**
     * 添加到链表尾部
     *
     * @param item
     */
    public void add(int item)
    {
        final Node l = last;
        final Node node = new Node(item, null);
        last = node;
        if (first.next == null)
        {//首次添加
            first.next = node;
        }
        else
        {
            l.next = node;
        }
        ++size;
    }

    /**
     * 添加数据item到指定位置index
     * index从0开始
     *
     * @param index
     * @param item
     */
    public void add(int index, int item)
    {
        checkPosIndex(index);
        int n = index;
        Node l = first;
        while ((n--) > 0)
        {
            l = l.next;
        }

        final Node node = new Node(item, null);
        if (null == first.next)
        {//首次添加
            last = node;
        }
        node.next = l.next;
        l.next = node;
        ++size;
    }

    /**
     * 删除指定位置index处的元素并返回, index从0开始
     *
     * @param index
     * @return
     */
    public int remove(int index)
    {
        checkPosIndex(index);
        Node f = first;
        while ((index--) > 0)
        {
            f = f.next;
        }
        Node del = f.next;
        if (del == last)
        {//删除最后一个元素
            last = f;
        }
        f.next = del.next;
        del.next = null;

        int oldVal = del.item;

        del = null;
        --size;
        return oldVal;
    }

    public int remove()
    {
        if (size == 0)
        {
            System.out.println("删除失败！！！链表元素为空");
            return -3692547;
        }
        int index = size - 1;
        Node node = first;
        if (index == 0)
        {
            int result = node.next.item;
            node.next = node.next.next;
            size--;
            return result;
        }
        node = node.next;
        for (int i = 0; i < index - 1; i++)
        {
            node = node.next;
        }
        int result = node.next.item;
        node.next = node.next.next;
        size--;
        return result;
    }

    public void sort()    //升序
    {
        int[] array = new int[size];
        Node node = first;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            array[i] = node.item;
            node = node.next;
        }
        /*
        for (int s : array)
        {
            System.out.println(s);
        }
         */
        Arrays.sort(array);
        node = first;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            node.item = array[i];
            node = node.next;
        }
    }

    public void sort_desc()
    {
        int[] array = new int[size];
        Node node = first;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            array[i] = node.item;
            node = node.next;
        }
        q_sort qSort = new q_sort();
        qSort.quickSort(array, 0, array.length - 1);
        node = first;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            node.item = array[i];
            node = node.next;
        }
    }


    /**
     * 获取链表中第index个元素
     *
     * @param index
     * @return
     */
    public int get(int index)
    {
        checkPosIndex(index);
        /********** Begin *********/
        Node node = first;
        for (int i = 0; i < index; i++)
        {
            node = node.next;
        }
        return node.next.item;

        /********** End *********/
    }

    public int size()
    {
        return size;
    }

    private void checkPosIndex(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void display()
    {
        System.out.println("数量：" + size);
        Node node = first;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    //结点内部类
    private static class Node
    {
        int item;
        Node next;

        Node(int item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
}
