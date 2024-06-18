package pl.tatarczyk.wojtek.spring.project.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AdministratorEntity {

    @GeneratedValue
    @Id
    private Long Id;

    private String nickname;
    private String password;

    public AdministratorEntity() {
    }

    public AdministratorEntity(Long id, String nickname, String password) {
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
        return "AdministratorEntity{" +
                "Id=" + Id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
