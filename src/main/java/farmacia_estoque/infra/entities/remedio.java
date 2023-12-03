package farmacia_estoque.infra.entities;

import farmacia_estoque.infra.controllers.dtos.DadosCadastrarRemedio;
import farmacia_estoque.infra.Enum.Laboratorio;
import farmacia_estoque.infra.Enum.Via;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Remedio")
@Entity(name = "remedios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
  public Remedio(DadosCadastrarRemedio dados){
    this.nome = dados.nome();
    this.via = dados.via();
    this.lote = dados.lote();
    this.quantidade = dados.quantidade();
    this.validade = dados.validade();
    this.laboratorio = dados.laboratorio();
  }

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String nome;
  private String lote;
  private String quantidade;
  private String valor;
  private  String validade;

  @Enumerated(EnumType.STRING)
  private Via via;

  @Enumerated(EnumType.STRING)
  private Laboratorio laboratorio;
}
