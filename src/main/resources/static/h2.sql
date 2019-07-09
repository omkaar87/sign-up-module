--Tables creation

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
)

CREATE TABLE `reset` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `resetToken` varchar(50) DEFAULT NULL
) 

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL
)

--Adding keys

ALTER TABLE `authorities`
  ADD UNIQUE KEY `authorities_idx_1` (`username`,`authority`);

ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

ALTER TABLE `reset`
  ADD PRIMARY KEY (`id`)

ALTER TABLE `reset`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `reset`
  ADD CONSTRAINT `fk` FOREIGN KEY (`email`) REFERENCES `users` (`username`);