package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosDetalhamentoRemedio;
import farmacia_estoque.infra.entities.Remedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class CadastrarRemedios_usecase {
  @Autowired
  private RemedioRepository repository;
  

  public ResponseEntity<DadosDetalhamentoRemedio> execute(DadosCadastrarRemedio dados, UriComponentsBuilder uriBuilder){
    try {
      var remedio  = new Remedio(dados);
      repository.save(remedio);
      var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

      return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));

    } catch (Exception e) {
      throw e;
    }
  }
}
