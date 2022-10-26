-- select *
-- from question_answer inner join answer
-- ON question_answer.ANSWER_UID = ANSWER.ANSWER_UID
-- inner join question
-- ON question_answer.QUESTION_UID = question.QUESTION_UID
-- inner join user
-- ON question_answer.USER_UID = user.USER_UID
-- ;

select question.QUESTION from question where question.QUESTION_UID = 'QS01';

select answer.answer from answer
inner join question
ON question.QUESTION_UID = ANSWER.question_uid;
-- where question.QUESTION_UID = 'QS01';

select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS01';


insert into question_answer(user_uid, question_uid, answer_uid) value ('MB01','QS01','AS02');
delete from question_answer;
select * from question_answer;

select question.QUESTION from question where question.QUESTION_UID = 'QS02';
select * from answer inner join question ON question.QUESTION_UID = ANSWER.question_uid where question.QUESTION_UID = 'QS02';