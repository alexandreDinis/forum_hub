CREATE TABLE `responses` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `message` TEXT NOT NULL,
  `topic_id` BIGINT NOT NULL,
  `author_id` BIGINT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT `fk_response_topic` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`),
  CONSTRAINT `fk_response_author` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
);
