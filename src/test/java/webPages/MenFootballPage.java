package webPages;

import baseFunc.BaseFunc;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class MenFootballPage {
    private final By SORTING_OPTIONS = By.xpath(".//select");
    private final By FILTER_NAMES = By.xpath(".//fieldset/ol/li/label");
    private final By FILTER_CHECKBOX = By.xpath(".//input[@type='checkbox']");
    private final By PRODUCT_INFORMATION = By.xpath(".//a[@class = 'spodb-product-card']");

    private BaseFunc baseFunc;

    public MenFootballPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSortingMethod(String sortingMethod) {
        Select dropdown = new Select(baseFunc.getElement(SORTING_OPTIONS));
        dropdown.selectByVisibleText(sortingMethod);
    }

    public void selectFilters(List<String> filterName) {
        List<WebElement> categories = baseFunc.getAllElements(FILTER_NAMES);
        List<WebElement> checkboxes = baseFunc.getAllElements(FILTER_CHECKBOX);
        for (int i = 0; i < filterName.size(); i++) {
            for (int j = 0; j < categories.size(); j++) {
                for (int k = 0; k < filterName.size(); k++) {
                    if (categories.get(j).getText().contains(filterName.get(k))) {
                        if (!checkboxes.get(j).isSelected()) {
                            categories.get(j).click();
                            baseFunc.waitJsExecution(FILTER_NAMES);
                            categories = baseFunc.getAllElements(FILTER_NAMES);
                            checkboxes = baseFunc.getAllElements(FILTER_CHECKBOX);
                        }
                    }
                }
            }
        }
    }

    public void collectInformationTxt() throws IOException {
        List<WebElement> information = baseFunc.getAllElements(PRODUCT_INFORMATION);
        File file = new File("myFirstFile.txt");
        FileWriter fw = new FileWriter(file);
        for (WebElement info: information) {
            fw.write(info.getText() + "\r\n");
        }
        fw.close();
    }



}