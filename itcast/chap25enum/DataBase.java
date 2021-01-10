package itcast.day25;

import java.util.Arrays;
import java.util.EnumMap;

// 定义数据库类型枚举
public enum DataBase {
    DB2, MYSQL, ORACLE, SQLSERVER;
    // 某类中定义的获取数据库URL的方法以及EnumMap的声明
    private static EnumMap<DataBase, String> urls = new EnumMap<DataBase, String>(DataBase.class);

    public static void DataBaseInfo() {
        urls.put(DataBase.DB2, "jdbc:db2://localhost:5000/sample");
        urls.put(DataBase.MYSQL, "jdbc:mysql://localhost/mydb");
        urls.put(DataBase.ORACLE, "jdbc:oracle:thin:@localhost:1521:sample");
        urls.put(DataBase.SQLSERVER, "jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    }

    //根据不同的数据库类型，返回对应的URL
    // @param type DataBase 枚举类新实例
    // @return
    public static String getURL(DataBase type) {
        return urls.get(type);
    }

    public static void main(String[] args) {
        DataBaseInfo();
        DataBase[] values = DataBase.values();
        DataBase mysql = DataBase.MYSQL;
        String url = getURL(mysql);
        System.out.println(mysql);
        System.out.println(url);
        System.out.println(Arrays.toString(values));
        for (DataBase db : values) {
            System.out.println(getURL(db));
            int i = mysql.compareTo(db);
            System.out.println(i);
        }
    }
}
