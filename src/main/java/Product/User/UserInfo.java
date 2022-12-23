package Product.User;

public class UserInfo {
    private String login;
  private String name;


    public  UserInfo(String login, String name) {
     this.login = login;
     this.name =name;

 }
    public String getLogin() {
        return login;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
