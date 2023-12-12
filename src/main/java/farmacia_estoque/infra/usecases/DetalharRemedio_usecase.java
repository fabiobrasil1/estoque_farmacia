package farmacia_estoque.infra.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.controllers.dtos.DadosDetalhamentoRemedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class DetalharRemedio_usecase {
  @Autowired
  private RemedioRepository repository;

  public ResponseEntity<DadosDetalhamentoRemedio> execute(Long id ){
    var remedioDetalhes = repository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedioDetalhes));
  }
}
