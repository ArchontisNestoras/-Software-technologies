package project2023.Diploma_Projects_Management_App.model.strategies;

import project2023.Diploma_Projects_Management_App.service.StudentService;

public class BestApplicantStrategyFactory {
	
    public static BestApplicantStrategy getStrategy(String strategyType) {
    	
        if (strategyType == null) {
            return null;
        }
        
        if (strategyType.equalsIgnoreCase("RANDOM_CHOICE")) {
            return new RandomStrategy();
        } else if (strategyType.equalsIgnoreCase("BEST_AVG_GRADE")) {
            return new BestAvgGradeStrategy();
        } else if (strategyType.equalsIgnoreCase("FEWEST_COURSES")) {
            return new FewestCoursesStrategy();
        } else if (strategyType.equalsIgnoreCase("LIMIT")) {
            return new LimitStrategy();
        }
        
        return null;
    }
}
