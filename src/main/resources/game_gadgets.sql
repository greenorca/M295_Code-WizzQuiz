DROP DATABASE IF EXISTS game_gadgets;
CREATE DATABASE game_gadgets;
USE game_gadgets;
CREATE USER game_gadget IDENTIFIED BY "game_gadget";
GRANT INSERT, SELECT, UPDATE, DELETE ON game_gadgets.* TO game_gadget;

CREATE TABLE `game_item` (
  `item_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
);

INSERT INTO `game_item` VALUES (3,'Heilige Handgranate');
INSERT INTO `game_item` VALUES (2,'Wundersamer Weihnachtsstern');
INSERT INTO `game_item` VALUES (1,'Tänzelnde Taschenlampe');

--
-- Table structure for table `player`
--
CREATE TABLE `player` (
  `player_id` int unsigned NOT NULL AUTO_INCREMENT,
  `player_name` varchar(100) DEFAULT NULL,
  `score` int unsigned DEFAULT '0',
  `game_item` int unsigned DEFAULT NULL,
  PRIMARY KEY (`player_id`),
  FOREIGN KEY (`game_item`) REFERENCES `game_item` (`item_id`)
);

INSERT INTO `player` VALUES (1,'Zelda',0,3),(2,'Super Mario',0,NULL),(3,'Roger Rabbit',0,NULL);
