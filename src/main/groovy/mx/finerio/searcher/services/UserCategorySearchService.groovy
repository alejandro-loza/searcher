package mx.finerio.searcher.services

import mx.finerio.searcher.dtos.UserCategorizerDto
import mx.finerio.searcher.validation.UserCategoryCommand

interface UserCategorySearchService {
    List findByDescription(long userId, String description )
    UserCategorizerDto create(UserCategoryCommand cmd)
    UserCategorizerDto findById(long id)

}