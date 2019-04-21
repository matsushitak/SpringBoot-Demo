package todolist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService(@Autowired private val repository: TaskRepository) {

    fun findAll(): List<Task> {
        return repository.findAll()
    }

    fun findById(id: Int): Task {
        return repository.findById(id).get()
    }

    fun create(task: Task): Task {
        return repository.save(task)
    }

    fun update(id: Int, task: Task): Task {
        val updateTask = findById(id)
        updateTask.content = task.content
        updateTask.done = task.done
        return repository.save(updateTask)
    }

    fun deleteById(id: Int) {
        repository.deleteById(id)
    }
}