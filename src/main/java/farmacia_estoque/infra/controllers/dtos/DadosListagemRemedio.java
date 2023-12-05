package farmacia_estoque.infra.controllers.dtos;

import java.time.LocalDate;

import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;
import farmacia_estoque.infra.entities.Remedio;

public record DadosListagemRemedio (
  Long id,
  String nome, 
  Via via, 
  String lote, 
  Laboratorio laboratorio, 
  LocalDate validade
  ) {

    public DadosListagemRemedio(Remedio remedio){
      this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
