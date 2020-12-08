package mx.finerio.searcher.repository

import mx.finerio.searcher.model.UserCategorizer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCategorizerRepository extends JpaRepository<UserCategorizer, Long>  {
    UserCategorizer findById(long id)
}