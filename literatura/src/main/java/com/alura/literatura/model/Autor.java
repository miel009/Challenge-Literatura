package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("birth_year") String anoDesde,
        @JsonAlias("death_year") String anoHasta
) {
}
