package org.example.model;

import lombok.Data;

@Data
public class Project {
    private int id;
    private String title;
    private String description;
    private int owner_id;
}
