package guilherme.miguel.demo.springbootkotlin.operation

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "operations")
@EntityListeners(AuditingEntityListener::class)
data class Operation(
        @Id @GeneratedValue(strategy = IDENTITY) var id: Long? = null,

        var title: String,

        @Enumerated(EnumType.STRING) var operationStatus: OperationStatus,

        @CreatedDate var createdDate: Instant? = null,

        @LastModifiedDate var lastModifiedDate: Instant? = null
)


enum class OperationStatus {
    CREATED,
    RUNNING,
    FAILED,
    COMPLETED
}