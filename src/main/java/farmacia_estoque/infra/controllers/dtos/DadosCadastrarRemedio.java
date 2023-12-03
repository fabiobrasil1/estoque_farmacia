package farmacia_estoque.infra.controllers.dtos;

import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;

public record DadosCadastrarRemedio(
  String nome,
  Via via,
  String lote,
  String quantidade,
  String validade,
  Laboratorio laboratorio ) {
}
