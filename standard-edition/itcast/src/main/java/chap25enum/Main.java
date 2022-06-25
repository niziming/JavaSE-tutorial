package chap25enum;

public class Main {
    public static void main(String[] args) {
        DataBase mysql = DataBase.MYSQL;
        mysql.DataBaseInfo();
        String url = mysql.getURL(mysql);
        System.out.println(url);
    }
}
