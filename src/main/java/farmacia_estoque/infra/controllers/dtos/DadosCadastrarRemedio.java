package farmacia_estoque.infra.controllers.dtos;

import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;

public record DadosCadastrarRemedio(
  String nome,
  String lote,
  String quantidade,
  Via via,
  String valor,
  Laboratorio laboratorio ) {
}
