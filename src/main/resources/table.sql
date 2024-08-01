CREATE database `assignment1`;
use `assignment1`;
CREATE TABLE `COMPANY` (
                           `id`	varchar(10)	NOT NULL,
                           `pw`	varchar(10)	NOT NULL,
                           `name`	varchar(10)	NOT NULL,
                           `country`	varchar(10)	NOT NULL,
                           `district`	varchar(20)	NOT NULL
);

CREATE TABLE `USER` (
                        `id`	varchar(10)	NOT NULL,
                        `pw`	varchar(10)	NOT NULL,
                        `name`	varchar(10)	NOT NULL
);

CREATE TABLE `APPLY` (
                         `user_id`	varchar(10)	NOT NULL,
                         `recruit_num`	int	NOT NULL
);

CREATE TABLE `RECRUIT` (
                           `num`	int	NOT NULL,
                           `company_id`	varchar(10)	NOT NULL,
                           `position`	varchar(10)	NULL,
                           `reward`	bigint	NULL,
                           `detail`	text	NULL,
                           `tech`	varchar(50)	NULL,
                           `district`	varchar(20)	NULL
);

ALTER TABLE `COMPANY` ADD CONSTRAINT `PK_COMPANY` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE `USER` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `id`
    );

ALTER TABLE `APPLY` ADD CONSTRAINT `PK_APPLY` PRIMARY KEY (
                                                           `user_id`,
                                                           `recruit_num`
    );

ALTER TABLE `RECRUIT` ADD CONSTRAINT `PK_RECRUIT` PRIMARY KEY (
                                                               `num`
    );

ALTER TABLE `APPLY` ADD CONSTRAINT `FK_USER_TO_APPLY_1` FOREIGN KEY (
                                                                     `user_id`
    )
    REFERENCES `USER` (
                       `id`
        );

ALTER TABLE `APPLY` ADD CONSTRAINT `FK_RECRUIT_TO_APPLY_1` FOREIGN KEY (
                                                                        `recruit_num`
    )
    REFERENCES `RECRUIT` (
                          `num`
        );

ALTER TABLE `RECRUIT` ADD CONSTRAINT `FK_COMPANY_TO_RECRUIT_1` FOREIGN KEY (
                                                                            `company_id`
    )
    REFERENCES `COMPANY` (
                          `id`
        );

