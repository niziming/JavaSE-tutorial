package chap24;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("asd");
        list.add("asd");

        List<String> todoDtos = new ArrayList<>();
        // todoDtos = list.stream().map(todo -> new TodoDto(todo.getUserId(),todo.getTitle(),todo.getContent())).collect(Collectors.toList());
        //  或者
        // todoDtos = list.stream().map(
        //         todo->{
        //             TodoDto to = new TodoDto();
        //             BeanUtils.copyProperties(todo,to);
        //             return to;
        //         }
        // ).collect(Collectors.toList());
    }
}
