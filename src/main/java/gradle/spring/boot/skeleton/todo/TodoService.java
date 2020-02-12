package gradle.spring.boot.skeleton.todo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TodoService {

  private final TodoRepository todoRepository;
  private final ModelMapper modelMapper;


  public Todo save(@NonNull TodoDTO todoDTO) {
    Todo saveTodo = modelMapper.map(todoDTO, Todo.class);
    return save(saveTodo);
  }

  private Todo save(@NonNull Todo todo) {
    return todoRepository.save(todo);
  }

  public void deleteById(@NonNull Long id) {
    todoRepository.deleteById(id);
  }

  @Transactional(readOnly = true)
  public Todo findById(@NonNull Long id) {
    final Optional<Todo> findedTeam = todoRepository.findById(id);
    findedTeam.orElseThrow(() -> new NullPointerException());
    return findedTeam.get();
  }

  @Transactional(readOnly = true)
  public Page<Todo> findAll(@NonNull Pageable pageable) {
    return todoRepository.findAll(pageable);
  }

  public Todo updateById(@NonNull Long id, @NonNull TodoDTO todoDTO) {
    Todo findedTodo = findById(id);
    findedTodo.setMemo(todoDTO.getMemo());
    return this.save(findedTodo);

  }
}
