package guilherme.miguel.demo.springbootkotlin.operation

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping(path = ["/operations"])
class OperationController(private val operationService: OperationService) {

    private val log = LoggerFactory.getLogger(OperationController::class.java)

    @GetMapping
    fun getOperations(@PathParam("status") status: OperationStatus?): ResponseEntity<List<Operation>> {
        log.info("Retrieving operations")
        return ResponseEntity.ok(operationService.getOperations(status))
    }

    @GetMapping("{id}")
    fun getOperation(@PathVariable id: Long): ResponseEntity<Operation> {
        log.info("Retrieving Operation [$id]");
        val operation = operationService.getOperation(id).orElseGet { Operation() }

        return ResponseEntity.ok(operation)
    }

    @PostMapping
    fun addOperation(@RequestBody operation: Operation): ResponseEntity<Operation> {
        log.info("Adding a new Operation");
        return ResponseEntity.ok(
                operationService.addOperation(operation)
                        .orElseThrow { RuntimeException("Error while trying to save a new Operation") }
        )
    }

}
