package study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanApplication

fun main(args: Array<String>) {
    runApplication<PlanApplication>(*args)
}
