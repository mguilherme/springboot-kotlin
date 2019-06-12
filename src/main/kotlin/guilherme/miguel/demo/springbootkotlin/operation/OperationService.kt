package guilherme.miguel.demo.springbootkotlin.operation

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OperationService(private val operationRepository: OperationRepository) {

    fun findAll(): List<Operation> = operationRepository.findAll()

    fun getOperations(status: OperationStatus?): List<Operation> {
        return status?.let { operationRepository.findAllByOperationStatus(it) } ?: operationRepository.findAll()
    }

    fun getOperation(id: Long): Operation? = operationRepository.findByIdOrNull(id)

    fun addOperation(operation: Operation): Operation = operationRepository.save(operation)

}