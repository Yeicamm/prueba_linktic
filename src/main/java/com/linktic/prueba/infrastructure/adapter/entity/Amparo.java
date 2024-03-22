package com.linktic.prueba.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "amparos")
public class Amparo {
    @Id
    private Long codigo;
    private String nombre;
}
