package farmacia_estoque.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import farmacia_estoque.infra.entities.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio,Long> {
  List<Remedio> findAllByAtivoTrue();
}
