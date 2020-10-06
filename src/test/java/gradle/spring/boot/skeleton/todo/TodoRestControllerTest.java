package gradle.spring.boot.skeleton.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoRestControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Order(1)
  @DisplayName("생성")
  void postTest() throws Exception {

    TodoDTO todoDTO = TodoDTO.builder()
                             .memo("서비스개발팀")
                             .build();

    mockMvc.perform(post("/todo")
      .contentType(MediaTypes.HAL_JSON_VALUE)
      .accept(MediaTypes.HAL_JSON)
      .content(objectMapper.writeValueAsString(todoDTO))
    )
           .andDo(print())
           .andExpect(status().isOk())
//           .andExpect(header().exists(HttpHeaders.LOCATION))
//           .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
           .andExpect(jsonPath("memo").value("서비스개발팀"))
//           .andExpect(jsonPath("location").value("5층"))
    ;
  }

  @Test
  @Order(2)
  @DisplayName("수정")
  void putTest() throws Exception {
    TodoDTO todoDTO = TodoDTO.builder()
                             .memo("아몰랑")
                             .build();
    mockMvc.perform(put("/todo/1")
      .contentType(MediaTypes.HAL_JSON_VALUE)
      .accept(MediaTypes.HAL_JSON)
      .content(objectMapper.writeValueAsString(todoDTO))
    )
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(jsonPath("memo").value("아몰랑"))
    ;
  }
}
