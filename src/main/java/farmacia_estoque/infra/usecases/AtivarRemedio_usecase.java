package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class AtivarRemedio_usecase {
  @Autowired
  private RemedioRepository repository;

  public void execute(Long id){
    var remedio = repository.getReferenceById(id);
    remedio.ativarRemeio();
  }
}
