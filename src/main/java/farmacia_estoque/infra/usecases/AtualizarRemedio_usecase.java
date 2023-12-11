package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.controllers.dtos.DadosAtualizarRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosDetalhamentoRemedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class AtualizarRemedio_usecase {
  @Autowired
  private RemedioRepository repository;

  public ResponseEntity<DadosDetalhamentoRemedio> execute(DadosAtualizarRemedio dados){
    try {
      var remedio = repository.getReferenceById(dados.id());
      remedio.atualizarInformacoes(dados);
      
      return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    } catch (Exception e) {
      throw e;
    }
  }
}
