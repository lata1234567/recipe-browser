package pl.tatarczyk.wojtek.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.repository.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
}
