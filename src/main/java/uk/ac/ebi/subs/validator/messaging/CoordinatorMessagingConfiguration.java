package uk.ac.ebi.subs.validator.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uk.ac.ebi.subs.messaging.ExchangeConfig;
import uk.ac.ebi.subs.messaging.Queues;

import static uk.ac.ebi.subs.validator.messaging.CoordinatorQueues.*;
import static uk.ac.ebi.subs.validator.messaging.CoordinatorRoutingKeys.*;

/**
 * Created by karoly on 05/07/2017.
 */
@Configuration
@ComponentScan(basePackageClasses = ExchangeConfig.class)
public class CoordinatorMessagingConfiguration {

    /**
     * Instantiate a {@link Queue} for validate published submissions.
     *
     * @return an instance of a {@link Queue} for validate published submissions.
     */
    @Bean
    Queue submissionSampleValidatorQueue() {
        return Queues.buildQueueWithDlx(SUBMISSION_SAMPLE_VALIDATOR);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     *
     * @param submissionSampleValidatorQueue {@link Queue} for validating sample submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     */
    @Bean
    Binding validationForCreatedSampleSubmissionBinding(Queue submissionSampleValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionSampleValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_SAMPLE_CREATED);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     *
     * @param submissionSampleValidatorQueue {@link Queue} for validating sample submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     */
    @Bean
    Binding validationForUpdatedSampleSubmissionBinding(Queue submissionSampleValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionSampleValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_SAMPLE_UPDATED);
    }

    @Bean
    Queue submissionStudyValidatorQueue() {
        return Queues.buildQueueWithDlx(SUBMISSION_STUDY_VALIDATOR);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     *
     * @param submissionStudyValidatorQueue {@link Queue} for validating study submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     */
    @Bean
    Binding validationForCreatedStudySubmissionBinding(Queue submissionStudyValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionStudyValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_STUDY_CREATED);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     *
     * @param submissionStudyValidatorQueue {@link Queue} for validating study submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     */
    @Bean
    Binding validationForUpdatedStudySubmissionBinding(Queue submissionStudyValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionStudyValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_STUDY_UPDATED);
    }

    @Bean
    Queue submissionAssayValidatorQueue() {
        return Queues.buildQueueWithDlx(SUBMISSION_ASSAY_VALIDATOR);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     *
     * @param submissionAssayValidatorQueue {@link Queue} for validating assay submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     */
    @Bean
    Binding validationForCreatedAssaySubmissionBinding(Queue submissionAssayValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionAssayValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_ASSAY_CREATED);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     *
     * @param submissionAssayValidatorQueue {@link Queue} for validating assay submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     */
    @Bean
    Binding validationForUpdatedAssaySubmissionBinding(Queue submissionAssayValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionAssayValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_ASSAY_UPDATED);
    }

    @Bean
    Queue submissionAssayDataValidatorQueue() {
        return Queues.buildQueueWithDlx(SUBMISSION_ASSAY_DATA_VALIDATOR);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     *
     * @param submissionAssayDataValidatorQueue {@link Queue} for validating assay data submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of created submissions.
     */
    @Bean
    Binding validationForCreatedAssayDataSubmissionBinding(Queue submissionAssayDataValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionAssayDataValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_ASSAYDATA_CREATED);
    }

    /**
     * Create a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     *
     * @param submissionAssayDataValidatorQueue {@link Queue} for validating assay data submissions before submitting them
     * @param submissionExchange {@link TopicExchange} for submissions
     * @return a {@link Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     */
    @Bean
    Binding validationForUpdatedAssayDataSubmissionBinding(Queue submissionAssayDataValidatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(submissionAssayDataValidatorQueue).to(submissionExchange)
                .with(SUBMITTABLE_ASSAYDATA_UPDATED);
    }
}
