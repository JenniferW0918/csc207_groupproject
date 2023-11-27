import app.*;
import entity.SearchNameResult;
import org.junit.Before;
import use_case.search_name.*;
import interface_adapter.search_name.*;
import view.SearchNameView;
import view.SearchedNameView;
import data_access.SearchNameDataAccessObject;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.*;

public class SearchNameTests {

    private static final String TEST_TERM = "Creamy Lemon Butter Chicken";
    private static final String TEST_LOCATION = "Toronto";

    private static final SearchNameDataAccessObject DATA_ACCESS = new SearchNameDataAccessObject();

    private static final SearchNameInputData INPUT_DATA = new SearchNameInputData(TEST_TERM, TEST_LOCATION);

    private static final String RESULT =
            "Term: Creamy Lemon Butter Chicken\n" +
            "Location: Toronto\n" +
            "Businesses: \n" +
            "Name: Rikki Tikki\n" +
            "Address: 209 Augusta Avenue, Toronto, ON M5T 2L4, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: The Senator\n" +
            "Address: 249 Victoria Street, Toronto, ON M5B 1T8, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Le Baratin\n" +
            "Address: 1600 Dundas Street. W, Toronto, ON M6K 1T8, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Maison Selby\n" +
            "Address: 592 Sherbourne Street, Toronto, ON M4X 1L4, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Himalayan Kitchen\n" +
            "Address: 1526 Queen Street W, Toronto, ON M6R 1A1, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Aloette\n" +
            "Address: 163 Spadina Avenue, 1st Floor, Toronto, ON M5V 2L6, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Grey Gardens\n" +
            "Address: 199 Augusta Avenue, Toronto, ON M5T 2L4, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Milou\n" +
            "Address: 1375 Dundas St W, Toronto, ON M6J 1Y3, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Union\n" +
            "Address: 72A Ossington Avenue, Toronto, ON M6J 2Y7, Canada\n" +
            "Open: Yes\n" +
            "\n" +
            "Name: Khau Gully\n" +
            "Address: 1991 Yonge Street, Toronto, ON M4S 1Z8, Canada\n" +
            "Open: Yes\n\n";



    public void makeASearch() {

    }

    /**
     * Test that the search name use case uses the correct parameters.
     */

    @org.junit.Test
    public void testResultsParameter() {
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        SearchNameInputData searchNameInputData = new SearchNameInputData("Creamy Lemon Butter Chicken", "Toronto");
        SearchNameResult result = searchNameDataAccessObject.getSearchName(searchNameInputData);
        assertEquals(result.getTerm(), "Creamy Lemon Butter Chicken");
        assertEquals(result.getLocation(), "Toronto");
    }


    @org.junit.Test
    public void testResults() {
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        SearchNameInputData searchNameInputData = new SearchNameInputData("Creamy Lemon Butter Chicken", "Toronto");
        SearchNameResult result = searchNameDataAccessObject.getSearchName(searchNameInputData);
        assertEquals(result.toString(), RESULT);
    }
    /**
     *
     * Test that the Clear button is present and where it is expected to be
     */
    @org.junit.Test
    public void testSearchNameButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("Clear"));
    }

    private JButton getButton() {
        return null;
    }


}

