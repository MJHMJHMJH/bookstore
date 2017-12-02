package zddteam.bookstore.testdao;

public class TestUser {


    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder.Builder("dahuang",20).phone("10086").addr("usa").build();
        System.out.println(userBuilder.toString());
    }
}
