DROP TABLE IF EXISTS message;

CREATE TABLE message (
       message_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
     , contents VARCHAR(200) NOT NULL
);