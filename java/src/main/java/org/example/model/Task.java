package org.example.model;

import lombok.Data;

@Data
public class Task {
    private int id;
    private String title;
    private String description;
    private String start_date;
    private String end_date;
    private String status;
    private int project_id;
    private int assignee_id;
}
