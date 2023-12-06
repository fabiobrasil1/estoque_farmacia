package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class DeletarRemedio_usecase {
  @Autowired
  private RemedioRepository repository;
  
  public void execute(Long id){
    try {
       repository.deleteById(id);
    } catch (Exception e) {
      throw e;
    }
  }
}
