package fileFind;

import java.util.List;

/**
* Class to calculate TfIdf of term.
*/
public class TfIdf {

/**
 * Calculated the tf of term termToCheck
 */
public double tfCalculator(String[] totalterms, String termToCheck) {
    double count = 0;  //to count the overall occurrence of the term termToCheck
    for (String s : totalterms) {
        if (s.equalsIgnoreCase(termToCheck)) {
            count++;
        }
    }
    return count / totalterms.length;
}

/**
 * Calculated idf of term termToCheck
 */
public double idfCalculator(List<String[]> allTerms, String termToCheck) {
    double count = 0;
    for (String[] ss : allTerms) {
        for (String s : ss) {
            if (s.equalsIgnoreCase(termToCheck)) {
                count++;
                break;
            }
        }
    }
    return Math.log(allTerms.size() / count);
}

}

