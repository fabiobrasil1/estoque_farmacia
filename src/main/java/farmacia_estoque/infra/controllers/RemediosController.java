package farmacia_estoque.infra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosListagemRemedio;
import farmacia_estoque.infra.usecases.CadastrarRemedios_usecase;
import farmacia_estoque.infra.usecases.ListarRemedios_usecase;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/remedios")
public class RemediosController {
  @Autowired
  private CadastrarRemedios_usecase cadastrarRemediosUC;
  @Autowired
  private ListarRemedios_usecase listarRemediosUC;


  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody DadosCadastrarRemedio dados) {
   cadastrarRemediosUC.execute(dados);
  }

  @GetMapping
  public List<DadosListagemRemedio> listar (){
    return listarRemediosUC.execute();
  } 
}