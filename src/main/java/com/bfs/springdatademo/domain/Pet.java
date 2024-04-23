package com.bfs.springdatademo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Pet {
    private String name;
    private String species;
}
