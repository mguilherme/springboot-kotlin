package guilherme.miguel.demo.springbootkotlin.operation

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OperationService(private val repository: OperationRepository) {

    fun findAll(): List<Operation> = repository.findAll()

    fun getOperations(status: String?): List<Operation> = when {
        status != null -> repository.findAllByOperationStatus(OperationStatus.valueOf(status.toUpperCase()))
        else -> repository.findAll()
    }

    fun getOperation(id: Long): Operation? = repository.findByIdOrNull(id)

    fun addOperation(operation: Operation): Operation = repository.save(operation)

}