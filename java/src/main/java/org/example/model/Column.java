package org.example.model;

import lombok.Data;

@Data
public class Column {
    private int id;
    private String title;
    private int board_id;
    private int order;
}
