CREATE TABLE `topics` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `message` TEXT NOT NULL,
  `author_id` BIGINT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT `fk_topic_author` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
);
