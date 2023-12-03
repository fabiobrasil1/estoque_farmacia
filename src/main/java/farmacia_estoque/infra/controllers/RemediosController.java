package farmacia_estoque.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.usecases.CadastrarRemedios_usecase;

@RestController
@RequestMapping("/remedios")
public class RemediosController {
  @Autowired
  private CadastrarRemedios_usecase cadastrarRemediosUC;


  @PostMapping
  public String cadastrar(@RequestBody DadosCadastrarRemedio dados) {
   cadastrarRemediosUC.execute(dados);

    return dados.toString();
  }
}