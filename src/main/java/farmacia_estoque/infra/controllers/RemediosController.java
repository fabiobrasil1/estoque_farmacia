package farmacia_estoque.infra.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;

@RestController
@RequestMapping("/remedios")
public class RemediosController {
  @PostMapping
  public String cadastrar(@RequestBody DadosCadastrarRemedio dados) {
    System.out.println(dados);
    return dados.toString();
  }
}