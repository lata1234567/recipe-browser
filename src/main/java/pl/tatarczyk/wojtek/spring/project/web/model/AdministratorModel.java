package pl.tatarczyk.wojtek.spring.project.web.model;

public class AdministratorModel {
    private Long Id;
    private String nickname;
    private String password;

    public AdministratorModel() {
    }

    public AdministratorModel(Long id, String nickname, String password) {
        Id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdministratorModel{" +
                "Id=" + Id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
