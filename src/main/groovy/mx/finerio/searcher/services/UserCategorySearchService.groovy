package mx.finerio.searcher.services

import mx.finerio.searcher.dtos.UserCategorizerDto
import mx.finerio.searcher.validation.UserCategoryCommand

interface UserCategorySearchService {
    List findByDescription(String text )
    UserCategorizerDto create(UserCategoryCommand cmd)
    UserCategorizerDto findById(long id)

}