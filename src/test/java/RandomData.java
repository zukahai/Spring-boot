public class RandomData {
    public static void main(String[] args) {
        int n = 255;
        int start = 56;
        System.out.println("INSERT INTO `account` (`id`, `password`, `username`) " +
            "VALUES");
        for (int i = start; i < n + start; i++) {
            int id = i;
            String userName = "User" + (int) (Math.random() * 10000);
            String password = "Password" + (int) (Math.random() * 10000);
            System.out.print("('" + id + "', '"+ password + "', '"  + userName + "')");
            if (i < n + start - 1)
                System.out.println(",");
            else
                System.out.println();
        }
        
    }
}
