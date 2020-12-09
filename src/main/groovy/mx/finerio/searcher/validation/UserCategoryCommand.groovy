package mx.finerio.searcher.validation

import groovy.transform.ToString

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserCategoryCommand extends ValidationCommand {

    @NotNull
    Long userId
    @NotNull
    @NotBlank
    String description
    @NotNull
    Long categoryId

}
