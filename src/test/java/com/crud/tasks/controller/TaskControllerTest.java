package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private DbService dbService;

    @Test
    void shouldGetEmptyList() {
        //Given
        //When
        ResponseEntity<List<TaskDto>> resultList = taskController.getTasks();
        //Then
        assertThat(resultList.getBody()).isNotNull();
        assertThat(resultList.getBody().size()).isEqualTo(0);
    }
}
