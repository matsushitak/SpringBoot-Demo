package todolist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("tasks")
class TaskController(@Autowired private val service: TaskService) {

    @GetMapping("")
    fun getTasks(): List<Task> {
        return service.findAll()
    }

    @GetMapping("{id}")
    fun getTask(@PathVariable("id") id: Int): Task {
        return service.findById(id)
    }

    @PostMapping("")
    fun createTask(@RequestBody task: Task): Task {
        return service.create(task)
    }

    @PutMapping("{id}")
    fun deleteTask(@PathVariable("id") id: Int, @RequestBody task: Task): Task {
        return service.update(id, task)
    }

    @DeleteMapping("{id}")
    fun deleteTask(@PathVariable("id") id: Int) {
        service.deleteById(id)
    }
}