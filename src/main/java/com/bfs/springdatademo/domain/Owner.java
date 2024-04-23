package com.bfs.springdatademo.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Owner {
    private String id;
    private String name;
    private List<Pet> pets = new ArrayList<>();
}
