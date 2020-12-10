package mx.finerio.searcher.model

import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory
import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.search.annotations.AnalyzerDef
import org.hibernate.search.annotations.AnalyzerDefs
import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import org.hibernate.search.annotations.Parameter
import org.hibernate.search.annotations.TokenFilterDef
import org.hibernate.search.annotations.TokenizerDef

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Indexed
@AnalyzerDefs([
        @AnalyzerDef(
                name = 'b_es',
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory),
                filters = [
                        @TokenFilterDef(factory = LowerCaseFilterFactory),
                        @TokenFilterDef(factory = SnowballPorterFilterFactory, params = [
                                @Parameter(name = 'language', value = 'Spanish')
                        ])
                ]
        ),
        @AnalyzerDef(
                name = 'b_en',
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory),
                filters = [
                        @TokenFilterDef(factory = LowerCaseFilterFactory),
                        @TokenFilterDef(factory = SnowballPorterFilterFactory, params = [
                                @Parameter(name = 'language', value = 'English')
                        ])
                ]
        )
])
class UserCategorizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Field
    Long userId

    @Field
    String description
    Long categoryId
    @CreationTimestamp
    Date dateCreated
    @UpdateTimestamp
    Date lastUpdated
}
