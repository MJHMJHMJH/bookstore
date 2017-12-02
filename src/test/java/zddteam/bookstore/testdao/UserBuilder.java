package zddteam.bookstore.testdao;

public class UserBuilder {
    private final String name;
    private final Integer age;
    private  final String sex;
    private final String phone;
    private final String addr;
    private final String work;

    public static class Builder{
        private final String name;
        private final Integer age;
        private   String sex="男";
        private  String phone="未填写";
        private  String addr="中国";
        private  String work="学生";

        public Builder(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder addr(String val) {
            addr = val;
            return this;
        }

        public Builder work(String val) {
            work = val;
            return this;
        }

        public UserBuilder build(){
            return new UserBuilder(this);
        }
    }

    private UserBuilder(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
        phone = builder.phone;
        addr = builder.addr;
        work = builder.work;
    }

    @Override
    public String toString() {
        return "["+name+age+sex+phone+addr+work+"]";
    }
}
