package testrecursion;

public class TestRecursion {

    //递归算法
    //递归就是方法自己调用自己，但是需要满足一定的条件
    /*
    * 比如说我们现在要盖宝塔，你告诉工人说你要盖5层的宝塔，
    * 那么工人告诉你，我可以盖最上面的一层，但是你要找人盖下面的几层
    * 下面的盖好了，我就可以盖了，那这时候你有找到一个工人来盖第四层
    * 那第四层工人说也可以盖，但是你要找到别人来盖第三层
    * 那你又找到一个工人来盖第二层，第二层工人也告诉 你说
    * 你要找到别人盖好第一层我才能给你盖第二层，这时候你又找到一个人来盖第一层
    * 第一层这个人就负责把第一层盖好就可以了。
    * 然后第二层看到第一层盖好了就开始盖第二层
    * 第三层看第二层盖好了 就开始盖第三层
    * 第四层看你三层盖好了也开始盖第四层
    * 第五层的工人看前面第四层的盖好了就开始盖第五层
    *
    * 我们发现其实每一个工人做得事情都是一样的，这时候我们可以使用递归的方法
    * 就是定义一个方法，当满足一定条件的时候就调用它自己
    * */
    public void buildTower(int floor){//这个方法是负责盖宝塔的
        //你传递给我几层，我就给你盖几层，但是要满足一定的条件

        if (floor > 1){//第四层要求第三层第三层要求第二层第二层要求第一层。
            this.buildTower(floor - 1);
        }
        System.out.println("盖到了第"+floor+"层宝塔");
    }

    //定义一个方法用来输出从0到指定数字
    public void outNum(int num){
        if (num > 0){
            outNum(num - 1);
        }
        System.out.println(num);
    }

    public static void main(String[] args) {

        TestRecursion tr = new TestRecursion();
        tr.buildTower(6);

        tr.outNum(6);
    }
}
