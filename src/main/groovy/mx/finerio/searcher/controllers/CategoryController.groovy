package mx.finerio.searcher.controllers

import mx.finerio.searcher.services.UserCategorySearchService
import mx.finerio.searcher.validation.UserCategoryCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/categorize")
@RestController
class CategoryController {

    @Autowired
    UserCategorySearchService categorySearchService

    @GetMapping(path="/{id}", produces = "application/json")
    ResponseEntity find(@PathVariable("id") Long id) {
        new ResponseEntity<>(categorySearchService.findById(id), HttpStatus.OK)
    }

    @GetMapping(produces = "application/json")
    ResponseEntity findFuzzy(@RequestParam Long userId, @RequestParam String description ) {
        new ResponseEntity<>(categorySearchService.findByDescription(userId, description), HttpStatus.OK)
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity create (@RequestBody @Valid UserCategoryCommand newCategoryCommand) {
        new ResponseEntity<>(categorySearchService.create(newCategoryCommand), HttpStatus.OK)
    }

}
