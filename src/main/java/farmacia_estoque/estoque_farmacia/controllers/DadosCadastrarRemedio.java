package farmacia_estoque.estoque_farmacia.controllers;

public record DadosCadastrarRemedio(
  String nome,
  String quantidade,
  Via via,
  String valor,
  Laboratorio laboratorio ) {
}
