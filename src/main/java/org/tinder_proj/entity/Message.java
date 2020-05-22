package org.tinder_proj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
  private int id;
  private int from_id;
  private int to_id;
  private String content;
  private LocalDate date;
}
