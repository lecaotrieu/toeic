package vn.webtienganh.core.service.utils;

import vn.webtienganh.core.daoimpl.*;

public class SingletonDaoUtil {
    private static UserDaoImpl userDaoImpl = null;
    private static RoleDaoImpl roleDaoInpl = null;
    private static ListenGuidelineDaoImpl listenGuidelineDaoImpl = null;
    private static CommentDaoImpl commentDaoImpl = null;
    private static ExaminationDaoImpl examinationDaoImpl = null;
    private static ExaminationQuestionDaoImpl examinationQuestionDaoImpl = null;
    private static ExerciseDaoImpl exerciseDaoImpl = null;
    private static ExerciseQuestionDaoImpl exerciseQuestionDaoImpl = null;
    private static ResultDaoImpl resultDaoImpl = null;

    public static ResultDaoImpl getResultDaoImpl() {
        if (resultDaoImpl == null) {
            resultDaoImpl = new ResultDaoImpl();
        }
        return resultDaoImpl;
    }

    public static CommentDaoImpl getCommentDaoImpl() {
        if (commentDaoImpl == null) {
            commentDaoImpl = new CommentDaoImpl();
        }
        return commentDaoImpl;
    }

    public static ExaminationDaoImpl getExaminationDaoImpl() {
        if (examinationDaoImpl == null) {
            examinationDaoImpl = new ExaminationDaoImpl();
        }
        return examinationDaoImpl;
    }

    public static ExaminationQuestionDaoImpl getExaminationQuestionDaoImpl() {
        if (examinationQuestionDaoImpl == null) {
            examinationQuestionDaoImpl = new ExaminationQuestionDaoImpl();
        }
        return examinationQuestionDaoImpl;
    }

    public static ExerciseDaoImpl getExerciseDaoImpl() {
        if (exerciseDaoImpl == null) {
            exerciseDaoImpl = new ExerciseDaoImpl();
        }
        return exerciseDaoImpl;
    }

    public static ExerciseQuestionDaoImpl getExerciseQuestionDaoImpl() {
        if (exerciseQuestionDaoImpl == null) {
            exerciseQuestionDaoImpl = new ExerciseQuestionDaoImpl();
        }
        return exerciseQuestionDaoImpl;
    }

    public static UserDaoImpl getUserDaoInstance() {
        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }

    public static RoleDaoImpl getRoleDaoInstance() {
        if (roleDaoInpl == null) {
            roleDaoInpl = new RoleDaoImpl();
        }
        return roleDaoInpl;
    }

    public static ListenGuidelineDaoImpl getListenGuidelineDaoInstance() {
        if (listenGuidelineDaoImpl == null) {
            listenGuidelineDaoImpl = new ListenGuidelineDaoImpl();
        }
        return listenGuidelineDaoImpl;
    }
}
