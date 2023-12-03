package farmacia_estoque.infra.controllers.dtos;

import java.time.LocalDate;

import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarRemedio(
  @NotBlank
  String nome,

  @Enumerated
  Via via,
  String lote,
  int quantidade,
  
  @Future
  LocalDate validade,

  @Enumerated
  Laboratorio laboratorio ) {
}
