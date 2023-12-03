package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.entities.Remedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class CadastrarRemedios_usecase {
  @Autowired
  private RemedioRepository repository;

  public void execute(DadosCadastrarRemedio dados){
    repository.save(new Remedio(dados));
  }
}
