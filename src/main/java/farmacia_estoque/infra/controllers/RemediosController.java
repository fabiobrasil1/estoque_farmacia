package farmacia_estoque.infra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import farmacia_estoque.infra.controllers.dtos.DadosDetalhamentoRemedio;
import farmacia_estoque.infra.controllers.dtos.DadosListagemRemedio;
import farmacia_estoque.infra.usecases.AtivarRemedio_usecase;
import farmacia_estoque.infra.usecases.AtualizarRemedio_usecase;
import farmacia_estoque.infra.usecases.CadastrarRemedios_usecase;
import farmacia_estoque.infra.usecases.DeletarRemedio_usecase;
import farmacia_estoque.infra.usecases.InativarRemedio_usecase;
import farmacia_estoque.infra.usecases.ListarRemedios_usecase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

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
  @Autowired
  private InativarRemedio_usecase inativarRemedioUC;
  @Autowired
  private AtivarRemedio_usecase ativarRemedioUC;

  
  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastrarRemedio dados) {
   cadastrarRemediosUC.execute(dados);
  }

  @GetMapping
  public ResponseEntity<List<DadosListagemRemedio>> listar (){
    var lista = listarRemediosUC.execute();
    return ResponseEntity.ok(lista);
  } 

  @PutMapping
  @Transactional
  public ResponseEntity<DadosDetalhamentoRemedio> atualizar (@RequestBody @Valid DadosAtualizarRemedio dados){
    return atualizarRemedioUC.execute(dados);
  } 

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> deletar (@PathVariable Long id){
    deletarRemedioUC.execute(id);
    return ResponseEntity.noContent().build();
  } 

  @DeleteMapping("inativar/{id}")
  @Transactional
  public ResponseEntity<Void> inativar (@PathVariable Long id){
    inativarRemedioUC.execute(id);
    return ResponseEntity.noContent().build();
  } 

  @PutMapping("ativar/{id}")
  @Transactional
  public ResponseEntity<Void> ativar (@PathVariable Long id){
    ativarRemedioUC.execute(id);
    return ResponseEntity.noContent().build();
  } 
}