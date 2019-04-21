package todolist

import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 1,
        var content: String = "",
        var done: Boolean = false
)