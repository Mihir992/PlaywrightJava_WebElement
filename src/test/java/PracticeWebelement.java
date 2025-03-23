import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.Random;

public class PracticeWebelement {

    public static void main(String[] args) throws InterruptedException {

        // Initialize Playwright
        Playwright playwright = Playwright.create();

        // Launch the Chromium browser (this opens Chrome as well)
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Set headless(false) for visible UI
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Open the desired URL in the browser
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        // Maximize the browser window by setting a large viewport size (e.g., 1920x1080 for Full HD)
        //page.setViewportSize(1920, 1080);


        // RadioButton - Select a random radio button dynamically
        // Get the count of radio buttons on the page
       /* int radioButtonCount = page.locator("//input[@type='radio']").count();
        // Generate a random index to select one of the radio buttons
        Random random = new Random();
        int randomIndex = random.nextInt(radioButtonCount);  // This will generate a number between 0 and radioButtonCount-1
        // Select the radio button dynamically by its index
        page.locator("//input[@type='radio']").nth(randomIndex).click();
        // Wait for some action (e.g., confirmation of the radio button click)
        page.waitForTimeout(2000); */ // Wait for 2 seconds just for visual confirmation

        //Suggestion Class Example
        // Input text you want to search for in the autocomplete field
        /*String inputText = "India";  // This could be dynamic based on your test case
        // Locate the autocomplete input box using XPath and fill the input field
        Locator autocompleteInput = page.locator("//input[@id='autocomplete']");
        autocompleteInput.waitFor();  // Wait for the input box to be visible
        autocompleteInput.fill(inputText);  // Type 'India' into the input field
        // Adding a sleep or wait to keep the browser open (for example 5 seconds)
        page.waitForTimeout(5000);  // Wait for 5 seconds to see the result before closing
        // Dynamically generate XPath based on inputText
        String dynamicXPath = "(//li[div[text()='" + inputText + "']])[1]";

        // Locate the dynamic suggestion using the generated XPath
        Locator dynamicSuggestion = page.locator(dynamicXPath);

        // Check if the suggestion is present and click it
        if (dynamicSuggestion.count() > 0) {
            dynamicSuggestion.click();  // Click the dynamically found suggestion
            System.out.println("Selected suggestion: " + inputText);
        } else {
            System.out.println("No suggestion matching: " + inputText);
        }
        // Optional: Adding a small wait before closing the browser
        page.waitForTimeout(5000);*/

        //Dropdown Example
        // Locate the dropdown element by its id
       /* Locator dropdown = page.locator("#dropdown-class-example");
        // Select an option by value ("option1", "option2", "option3")
        dropdown.selectOption(new SelectOption().setValue("option1"));  // Select Option1
        // Optional: Wait for a while to observe the selection
        page.waitForTimeout(2000);*/

        // Locate the checkbox by its id
        /*Locator checkbox = page.locator("#checkBoxOption1");
        // Check the checkbox (if not already checked)
        checkbox.check();*/

        // Locate and click the label (which contains the checkbox)
        // Locate the checkbox label by its "for" attribute
        /*Locator checkboxLabel = page.locator("label[for='checkBoxOption1']");

        // Wait for the label to be visible
        checkboxLabel.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // Wait up to 5 seconds for visibility

        // Check if the checkbox is visible and enabled
        boolean isVisible = checkboxLabel.isVisible();
        boolean isEnabled = checkboxLabel.isEnabled();

        System.out.println("Is checkbox label visible? " + isVisible);
        System.out.println("Is checkbox label enabled? " + isEnabled);

        // If it's visible and enabled, click the label
        if (isVisible && isEnabled) {
            checkboxLabel.check(); // This will toggle the checkbox when clicking on the label
        } else {
            System.out.println("Checkbox label is not visible or not enabled.");
        }*/

        //Switch Window Example
        /*Locator switchWindow = page.locator("//button[@id='openwindow']");
        switchWindow.click();
        // Wait a short time to ensure the new window is opened
        page.waitForTimeout(2000); // Wait for 2 seconds (you can adjust the time)

        // After waiting, check if the new page is opened
        // Fetch all open pages
        java.util.List<Page> pages = context.pages();
        if (pages.size() > 1) {
            // The second page should be at index 1
            Page page2 = pages.get(1);

            // Retrieve the **parent page's URL** (page1)
            String parentPageUrl = page.url();
            System.out.println("Current URL of the parent page: " + parentPageUrl);

            // Interact with page2, for example, print the dynamic URL again after actions
            page2.waitForTimeout(1000);  // Example wait to ensure actions are completed
            String dynamicUrlAfterAction = page2.url();
            System.out.println("Dynamic URL of second page after some interaction: " + dynamicUrlAfterAction);
        } else {
            System.out.println("No new window/tab opened.");
        }*/

        //Switch Tab Example
        // Locate the element using XPath and click it
        /*Locator switchLocator = page.locator("//a[@id='opentab']");
        switchLocator.click();
        // You can add additional logic or wait as needed
        Thread.sleep(2000);*/

        //Switch to Alert Example
        /*Locator switchToALertLocator = page.locator("//input[@id='name']");
        switchToALertLocator.fill("Test");
        Thread.sleep(2000);
        Locator alertButton = page.locator("//input[@id='alertbtn']");
        // Listen for the alert event
        page.onDialog(dialog -> {
            // Print the message from the alert
            System.out.println("Alert message: " + dialog.message());
            // Accept the alert
            dialog.accept();
            System.out.println("Alert accepted!");
        });
        alertButton.click();*/

        //Element - Hide/Display Example
        // Scroll down by 500 pixels
        /*page.evaluate("window.scrollBy(0, 500);");
        // Locate the "Hide" button by its ID
        Locator hideButton = page.locator("//input[@id='show-textbox']");
        // Click the "Hide" button
        hideButton.click();
        // Locate the textbox (the element that should hide/show after clicking the button)
        Locator textbox = page.locator("//input[@id='displayed-text']");  // Replace with actual textbox selector
        // Condition: Check if the textbox is hidden or visible
        if (textbox.isVisible()) {
            System.out.println("Textbox is visible.");
        } else {
            System.out.println("Textbox is hidden.");
        }*/

        //Web Table Fixed Header
        page.evaluate("window.scrollBy(0, 500);");
        // Wait for the table to load
        page.waitForSelector(".tableFixHead", new Locator.WaitForOptions().setTimeout(60000));  // 60 seconds timeout

        // Locate the table body (tbody)
        Locator tableBody = page.locator("table tbody");
        int rowCount = tableBody.locator("tr").count();
        System.out.println(rowCount);
        // Loop through all the rows and print the data in each row
        for (int i = 0; i < rowCount; i++) {
            // Get data from each column (td) of the row (tr)
            String name = tableBody.locator("tr").nth(i).locator("td:nth-child(1)").textContent();
            String position = tableBody.locator("tr").nth(i).locator("td:nth-child(2)").textContent();
            String city = tableBody.locator("tr").nth(i).locator("td:nth-child(3)").textContent();
            String amount = tableBody.locator("tr").nth(i).locator("td:nth-child(4)").textContent();
            // Print data from the row
            System.out.println("Row " + (i + 1) + ": Name = " + name + ", Position = " + position +
                    ", City = " + city + ", Amount = " + amount);
        }

        // Adding a wait to allow the dialog to be captured and handled
        Thread.sleep(2000);


        browser.close();
        playwright.close();
    }
}
