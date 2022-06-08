package User;

public class adminUser extends user{

    public adminUser(String name) {
        super(name);
    }


    public void menu(){
        System.out.println("你好"+this.getName()+"管理员,欢迎访问图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("请输入你的选择");
    }


}


