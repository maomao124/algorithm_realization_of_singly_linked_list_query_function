/**
 * Project name(项目名称)：算法_单链表的实现之查询功能
 * Package(包名): PACKAGE_NAME
 * Class(类名): MyLinkedListTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/14
 * Time(创建时间)： 21:04
 * Version(版本): 1.0
 * Description(描述)：
 * 预期输出
 * <p>
 * 3
 * 1
 * 4
 * 5
 * 7
 * -1
 * 33
 */

public class MyLinkedListTest
{
    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        list.add(0, 1);
        list.add(5);
        list.add(7);
        list.add(-1);
        list.add(0, 3);
        list.add(2, 4);
        list.add(-6);
        list.remove(6);
        list.add(33);
        list.display();
        /*
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
         */

        System.out.println();
        //list.sort();
        list.display();
        list.sort_desc();
        list.display();

    }
}
