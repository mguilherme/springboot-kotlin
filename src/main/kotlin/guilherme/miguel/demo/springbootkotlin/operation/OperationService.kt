package guilherme.miguel.demo.springbootkotlin.operation

import org.springframework.stereotype.Service
import java.util.*

@Service
class OperationService(private val operationRepository: OperationRepository) {

    fun findAll(): List<Operation> = operationRepository.findAll()

    fun getOperations(status: OperationStatus?): List<Operation> = if (status != null) operationRepository.findAllByOperationStatus(status) else operationRepository.findAll()

    fun getOperation(id: Long): Optional<Operation> = operationRepository.findById(id)

    fun addOperation(operation: Operation): Operation = operationRepository.save(operation)

}