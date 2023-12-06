package farmacia_estoque.infra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farmacia_estoque.infra.controllers.dtos.DadosAtualizarRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosListagemRemedio;
import farmacia_estoque.infra.entities.Remedio;
import farmacia_estoque.infra.usecases.AtualizarRemedio_usecase;
import farmacia_estoque.infra.usecases.CadastrarRemedios_usecase;
import farmacia_estoque.infra.usecases.DeletarRemedio_usecase;
import farmacia_estoque.infra.usecases.ListarRemedios_usecase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/remedios")
public class RemediosController {
  @Autowired
  private CadastrarRemedios_usecase cadastrarRemediosUC;
  @Autowired
  private ListarRemedios_usecase listarRemediosUC;
  @Autowired
  private AtualizarRemedio_usecase atualizarRemedioUC;
  @Autowired
  private DeletarRemedio_usecase deletarRemedioUC;


  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastrarRemedio dados) {
   cadastrarRemediosUC.execute(dados);
  }

  @GetMapping
  public List<DadosListagemRemedio> listar (){
    return listarRemediosUC.execute();
  } 

  @PutMapping
  @Transactional
  public void atualizar (@RequestBody @Valid DadosAtualizarRemedio dados){
    atualizarRemedioUC.execute(dados);
  } 
  @DeleteMapping("/{id}")
  @Transactional
  public void deletar (@PathVariable Long id){
    deletarRemedioUC.execute(id);
  } 
}