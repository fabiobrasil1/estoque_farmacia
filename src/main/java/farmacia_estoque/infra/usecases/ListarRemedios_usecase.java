package farmacia_estoque.infra.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farmacia_estoque.infra.controllers.dtos.DadosListagemRemedio;
import farmacia_estoque.infra.repositories.RemedioRepository;

@Service
public class ListarRemedios_usecase {
  @Autowired
  private RemedioRepository repository;

  public List<DadosListagemRemedio> execute (){
    return this.repository.findAll()
    .stream()
    .map(DadosListagemRemedio::new)
    .toList();
  }
}
