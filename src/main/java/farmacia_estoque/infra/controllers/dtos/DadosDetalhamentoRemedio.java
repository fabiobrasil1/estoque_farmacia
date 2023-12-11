package farmacia_estoque.infra.controllers.dtos;

import java.time.LocalDate;

import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;
import farmacia_estoque.infra.entities.Remedio;

public record DadosDetalhamentoRemedio(
    Long id,

    String nome,

    Via via,

    String lote,

    int quantidade,

    LocalDate validade,

    Laboratorio laboratorio,

    Boolean ativo
  ){

  public DadosDetalhamentoRemedio(Remedio remedio){
    this(
      remedio.getId(),
      remedio.getNome(),
      remedio.getVia(),
      remedio.getLote(),
      remedio.getQuantidade(),
      remedio.getValidade(),
      remedio.getLaboratorio(),
      remedio.isAtivo()
    );
  }
}
