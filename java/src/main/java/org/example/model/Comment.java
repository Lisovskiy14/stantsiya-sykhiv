package org.example.model;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private int task_id;
    private int author_id;
    private String content;
    private String timestamp;
}
