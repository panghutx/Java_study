class Father{
    public static void father(){
        System.out.println("father");
    }
}

class Son extends Father{
    public static void father(){
        System.out.println("son");
    }
}

class Test{
    public static void main(String[] args){

        Father.father();//输出的结果为father
    }
}

