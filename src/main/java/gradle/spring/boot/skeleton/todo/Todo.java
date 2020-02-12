package gradle.spring.boot.skeleton.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Todo {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String memo;

  public Todo(String memo) {
    this.memo = memo;
  }
}