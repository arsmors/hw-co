package stepDefs;

import baseFunc.BaseFunc;
import baseFunc.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webPages.MenFootballPage;
import webPages.ProductsPage;
;import java.io.IOException;
import java.util.List;

public class ManShoesSection {
    private BaseFunc basefunc = new BaseFunc();
    private Helper helper = new Helper(basefunc);
    private ProductsPage productsPage = new ProductsPage(basefunc);
    private MenFootballPage menFootballShoesPage = new MenFootballPage(basefunc);

    @Given("^I open \"([^\"]*)\" link$")
    public void open_page(String url) {
        basefunc.openPage(url);
    }

    @When("I push menu")
    public void push_menu() {
        helper.pushHamburger_BTN();
    }

    @And("^I choose \"([^\"]*)\" section$")
    public void select_section(String sectionName) {
        helper.selectMenuSection(sectionName);
    }

    @And("^I select \"([^\"]*)\" under \"([^\"]*)\" section in \"([^\"]*)\" tab$")
    public void click_futbol(String section, String category, String gender) {
        productsPage.selectProductSection(section, category, gender);
    }

    @And("^we sort products by \"([^\"]*)\"$")
    public void choose_sorting_method(String method) {
        menFootballShoesPage.selectSortingMethod(method);
    }

    @When("I select filters:")
    public void select_filters(List<String> filterNames) {
        menFootballShoesPage.selectFilters(filterNames);
    }

    @Then("^on page appeared only \"([^\"]*)\" brand shoes$")
    public void check_filtered_brand(String brand) {
        helper.checkBrand(brand);
    }

    @Then("all products are on sale")
    public void check_products_sale() {
        helper.checkSale();
    }

    @Then("we create txt file with with info about products")
    public void create_txt_file() throws IOException {
        menFootballShoesPage.collectInformationTxt();
    }

    @Then("we create json file with the same information")
    public void create_json_file() {

    }

    @Then("we close browser")
    public void close_browser() {
        basefunc.closeBrowser();
    }
}