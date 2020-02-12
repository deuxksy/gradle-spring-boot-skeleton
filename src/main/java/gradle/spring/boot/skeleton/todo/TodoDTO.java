package gradle.spring.boot.skeleton.todo;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TodoDTO {
  @Column
  private String memo;

  @Builder
  public TodoDTO(String memo) {
    this.memo = memo;
  }

  public void update(Todo todo) {
    todo.setMemo(this.memo);
  }
}