package guilherme.miguel.demo.springbootkotlin.operation

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OperationRepository : JpaRepository<Operation, Long> {

    fun findAllByOperationStatus(operationStatus: OperationStatus): List<Operation>

    @Query(value = "select o from Operation o where o.title = :title")
    fun findWhereTitle(@Param("title") title: String): List<Operation>

}