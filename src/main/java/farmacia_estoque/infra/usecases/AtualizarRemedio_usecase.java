package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.controllers.dtos.DadosAtualizarRemedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class AtualizarRemedio_usecase {
  @Autowired
  private RemedioRepository repository;

  public void execute(DadosAtualizarRemedio dados){
    try {
      var remedio = repository.getReferenceById(dados.id());
      remedio.atualizarInformacoes(dados);
    } catch (Exception e) {
      throw e;
    }
  }
}
