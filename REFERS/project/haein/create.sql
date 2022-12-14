
CREATE TABLE ANSWER_LIST
(
  ANSWER_LIST_UID VARCHAR(200) NOT NULL COMMENT '답항 대표값',
  ANSWER_LIST     VARCHAR(200) NOT NULL COMMENT '답항 리스트',
  PRIMARY KEY (ANSWER_LIST_UID)
) COMMENT '답항';

CREATE TABLE AUTHOR
(
  AUTHOR_UID VARCHAR(200) NOT NULL COMMENT '접근권한대표값',
  AUTHOR     VARCHAR(200) NOT NULL COMMENT '접근권한',
  PRIMARY KEY (AUTHOR_UID)
) COMMENT '접근권한';

CREATE TABLE QUESTION
(
  QUESTION_UID    VARCHAR(200) NOT NULL COMMENT '설문문항 대표값',
  QUESTION        VARCHAR(200) NOT NULL COMMENT '설문 내용',
  ANSWER_LIST_UID VARCHAR(200) NOT NULL COMMENT '답항 대표값',
  PRIMARY KEY (QUESTION_UID)
) COMMENT '설문문항';

CREATE TABLE QUESTION_ANSWER
(
  USER_UID        VARCHAR(200) NOT NULL COMMENT '회원대표값',
  QUESTION_UID    VARCHAR(200) NOT NULL COMMENT '설문문항 대표값',
  ANSWER_LIST_UID VARCHAR(200) NOT NULL COMMENT '답항 대표값',
  ANSWER          VARCHAR(200) NULL     COMMENT '답변'
) COMMENT '설문 문항 답변';

CREATE TABLE USER
(
  USER_UID   VARCHAR(200) NOT NULL COMMENT '회원대표값',
  ID         VARCHAR(200) NOT NULL COMMENT 'ID',
  PW         VARCHAR(200) NOT NULL COMMENT 'PW',
  AUTHOR_UID VARCHAR(200) NOT NULL COMMENT '접근권한대표값',
  PRIMARY KEY (USER_UID)
) COMMENT '회원정보';

ALTER TABLE USER
  ADD CONSTRAINT FK_AUTHOR_TO_USER
    FOREIGN KEY (AUTHOR_UID)
    REFERENCES AUTHOR (AUTHOR_UID);

ALTER TABLE QUESTION_ANSWER
  ADD CONSTRAINT FK_USER_TO_QUESTION_ANSWER
    FOREIGN KEY (USER_UID)
    REFERENCES USER (USER_UID);

ALTER TABLE QUESTION
  ADD CONSTRAINT FK_ANSWER_LIST_TO_QUESTION
    FOREIGN KEY (ANSWER_LIST_UID)
    REFERENCES ANSWER_LIST (ANSWER_LIST_UID);

ALTER TABLE QUESTION_ANSWER
  ADD CONSTRAINT FK_QUESTION_TO_QUESTION_ANSWER
    FOREIGN KEY (QUESTION_UID)
    REFERENCES QUESTION (QUESTION_UID);

ALTER TABLE QUESTION_ANSWER
  ADD CONSTRAINT FK_ANSWER_LIST_TO_QUESTION_ANSWER
    FOREIGN KEY (ANSWER_LIST_UID)
    REFERENCES ANSWER_LIST (ANSWER_LIST_UID);
