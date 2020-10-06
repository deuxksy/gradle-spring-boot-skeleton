package gradle.spring.boot.skeleton.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.MediaTypes;

@RestController
@RequestMapping(value = "/todo", produces = MediaTypes.HAL_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class TodoRestController {

  private final TodoService todoService;

  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable("id") Todo todo) {
    return ResponseEntity.ok()
                         .body(todo);
  }

  @PostMapping
  public ResponseEntity post(@RequestBody TodoDTO todoDTO) {
    Todo todo = todoService.save(todoDTO);
    return ResponseEntity.ok()
                         .body(todo);
  }

  @PutMapping("/{id}")
  public ResponseEntity put(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
    return ResponseEntity.ok()
                         .body(todoService.updateById(id, todoDTO));
  }

  @DeleteMapping
  public ResponseEntity delete(@PathVariable("id") Long id) {
    todoService.deleteById(id);
    return ResponseEntity.ok()
                         .body(id);
  }

  @GetMapping
  public PagedModel list(Pageable pageable, PagedResourcesAssembler pagedResourcesAssembler) {
    return pagedResourcesAssembler.toModel(todoService.findAll(pageable));
  }
}
