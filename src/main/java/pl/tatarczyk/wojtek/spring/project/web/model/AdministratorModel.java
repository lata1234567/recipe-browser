package pl.tatarczyk.wojtek.spring.project.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorModel {
    private Long id;
    private String nickname;
    private String password;
}
