package farmacia_estoque.estoque_farmacia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemediosController {
  @PostMapping
  public String cadastrarRemedio(@RequestBody String json) {
    System.out.println(json);
    return json;

  }
}
