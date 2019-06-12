package guilherme.miguel.demo.springbootkotlin

import guilherme.miguel.demo.springbootkotlin.operation.Operation
import guilherme.miguel.demo.springbootkotlin.operation.OperationRepository
import guilherme.miguel.demo.springbootkotlin.operation.OperationStatus
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringbootKotlinApplication {

    @Bean
    fun commandLineRunner(repository: OperationRepository) = CommandLineRunner {
        val operation1 = Operation(title = "My Operation 1", operationStatus = OperationStatus.COMPLETED)
        val operation2 = Operation(title = "My Operation 2", operationStatus = OperationStatus.FAILED)
        val operation3 = Operation(title = "My Operation 3", operationStatus = OperationStatus.RUNNING)
        val operation4 = Operation(title = "My Operation 4", operationStatus = OperationStatus.COMPLETED)

        repository.saveAll(listOf(operation1, operation2, operation3, operation4))
    }

}

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinApplication>(*args)
}

